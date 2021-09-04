package org.github.foxnic.web.pcm.storage.model;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBMetaData;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBDataType;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.service.ICatalogAllocationService;
import org.github.foxnic.web.pcm.service.ICatalogAttributeService;
import org.github.foxnic.web.session.SessionUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldManager {

    private DAO dao;
    private String table;
    private DBTableMeta tableMeta;
    private Catalog catalog;
    /**
     * 所有字段
     * */
    private Map<String, DBColumnMeta> colmapAll;
    /**
     * 未使用的字段
     * */
    private Map<String, DBColumnMeta> colmapUnused;
    private int fieldIndex=0;
    private List<CatalogAttribute> attributes;
    private Map<String, CatalogAttribute> attrmap;

    private StorageAdapter storageAdapter;

    private String temporaryTable = null;

    private ICatalogAttributeService catalogAttributeService;
    private ICatalogAllocationService catalogAllocationService;

    public FieldManager(DAO dao,Catalog catalog, List<CatalogAttribute> attributes, ICatalogAttributeService catalogAttributeService, ICatalogAllocationService catalogAllocationService) {
        this.catalog=catalog;
        this.dao=dao;
        this.catalogAttributeService=catalogAttributeService;
        this.catalogAllocationService=catalogAllocationService;
        this.table=catalog.getDataTable();
        DBMetaData.invalid(this.dao,table);
        tableMeta=dao.getTableMeta(table);
        //
        this.attributes=attributes;
        attrmap=new HashMap<>();
        for (CatalogAttribute attribute : attributes) {
            if(attribute.getAllocation()==null) continue;
            attrmap.put(attribute.getAllocation().getColumnName(),attribute);
        }
        //
        colmapAll=new HashMap<>();
        colmapUnused=new HashMap<>();
        int index=1;
        String colname=null;
        for (DBColumnMeta column : tableMeta.getColumns()) {
            colname=column.getColumn().toLowerCase();
            if(colname.startsWith("f_")) {
                index = DataParser.parseInteger(colname.split("_")[1]);
                if(fieldIndex<index) fieldIndex=index;
                colmapAll.put(column.getColumn(),column);
                if(!attrmap.keySet().contains(colname)) {
                    colmapUnused.put(column.getColumn(),column);
                }
            }

        }
        //
        this.storageAdapter=StorageAdapter.getStorageAdapter(this.dao.getDBType());
        //
        this.temporaryTable="pcm_"+ IDGenerator.getSnowflakeIdString();
    }

    /**
     * 校验并分配属性字段
     * */
    public Result verifyAndAllotAttributes() {
        Result result=storageAdapter.createTemporaryTable(this.dao,this.temporaryTable);
        if(result.failure()) return result;
        //规则校验
        for (CatalogAttribute attribute : attributes) {
            CatalogAttribute sourceAttr = attribute.getSourceAttr();
            if (sourceAttr != null) {
                //比较修改前后的变化
                if (!sourceAttr.getDataType().equals(attribute.getDataType())) {
                    result.addError("不支持[" + attribute.getFullName() + "]类型变更", attribute);
                }
                if (sourceAttr.getLength() != null && sourceAttr.getLength() > attribute.getLength()) {
                    result.addError("不支持[" + attribute.getFullName() + "]长度减少,不允许小于 "+sourceAttr.getLength(), attribute);
                }
                if (sourceAttr.getAccuracy() != null && sourceAttr.getAccuracy() > attribute.getAccuracy()) {
                    result.addError("不支持[" + attribute.getFullName() + "]精度减少,不允许小于 "+sourceAttr.getAccuracy(), attribute);
                }
                if (sourceAttr.getScale() != null && sourceAttr.getScale() > attribute.getScale()) {
                    result.addError("不支持[" + attribute.getFullName() + "]小数位减少,不允许小于 "+sourceAttr.getScale(), attribute);
                }
            }
        }
        //数据库字段校验
        for (CatalogAttribute attribute : attributes) {
            Result r=storageAdapter.verifyField(dao,temporaryTable,attribute);
            if(r.failure()){
                result.addError(r);
            }
        }
        storageAdapter.dropTemporaryTable(this.dao,this.temporaryTable);
        if(result.getErrors()!=null && !result.getErrors().isEmpty()) {
            result.success(false).message("属性校验失败");
            return result;
        }
        //分配字段
        for (CatalogAttribute attribute : attributes) {
            Result r=this.allotField(attribute);
            if(r.failure()){
                result.addErrors(r.getErrors());
            }
        }
        return result;
    }

    /**
     * 分配字段
     * */
    private Result allotField(CatalogAttribute attribute) {
        CatalogAllocation allocation=attribute.getAllocation();
        Result result=new Result();
        String column = null;
        if(allocation==null) {
            allocation=new CatalogAllocation();
            allocation.setCatalogId(attribute.getCatalogId());
            allocation.setAttributeId(attribute.getId());
            allocation.setVersionNo(attribute.getVersionNo());
            attribute.setAllocation(allocation);
            //在未使用清单中查找
            column=findColumn(attribute);
            //如果找到匹配的未使用字段
            if(column!=null) {
                //从未使用中移除
                this.colmapUnused.remove(column);
                allocation.setColumnName(column);
            } else {
                //如果未找到未使用的匹配字段，则创建一个新字段
                fieldIndex++;
                column="f_"+fieldIndex;
                allocation.setColumnName(column);
                //创建存储字段
                Result r=storageAdapter.createField(dao,table,attribute,true);
                if(r.failure()){
                    result.addError(r);
                }
            }

            //创建并关联
            catalogAllocationService.insert(allocation);
        } else {
            // 如果存在则验证字段
            CatalogAttribute sourceAttr = attribute.getSourceAttr();
            boolean changed=false;
            if (sourceAttr != null) {
                //前面已经有规则校验，此处直接处理即可
                if (sourceAttr.getLength() != null && sourceAttr.getLength() != attribute.getLength()) {
                    changed=true;
                }
                if (sourceAttr.getAccuracy() != null && sourceAttr.getAccuracy() != attribute.getAccuracy()) {
                    changed=true;
                }
                if (sourceAttr.getScale() != null && sourceAttr.getScale() != attribute.getScale()) {
                    changed=true;
                }
                //如果字段参数有调整，变更存储字段
                if(changed) {
                    //
                    CatalogAllocation before=CatalogAllocation.createFrom(allocation);
                    //匹配已有字段
                    column=this.findColumn(attribute);
                    //如果没有找到
                    if(column==null) {
                        fieldIndex++;
                        column="f_"+fieldIndex;
                        allocation.setColumnName(column);
                        //创建存储字段
                        Result r=storageAdapter.createField(dao,table,attribute,true);
                        if(r.failure()){
                            result.addError(r);
                        }
                    } else {
                        //从未使用中移除
                        this.colmapUnused.remove(column);
                        allocation.setColumnName(column);
                    }
                    //保存变更
                    catalogAllocationService.updateDirtyFields(allocation);
                    //复制列数据
                    Result r=duplicateColumnData(before.getColumnName(),allocation.getColumnName());
                    if(r.failure()){
                        result.addError(r);
                    }
                }

            } else {
                //如果是新加的字段
                //新加的字段不会有 allocation ，所以这个逻辑的处理是在 allocation==null 这个 if 分支中
            }

        }
        return result;
    }

    /**
     * 复制数据到目标列
     * */
    private Result duplicateColumnData(String sourceColumn, String targetColumn) {
        String tenantId= SessionUser.getCurrent().getActivatedTenantId();
        try {
            dao.execute("update "+table+" set "+targetColumn+"="+sourceColumn+" where tenant_id=? and catalog_id=?",tenantId,catalog.getId());
            return ErrorDesc.success();
        } catch (Exception e) {
            return ErrorDesc.exception(e);
        }
    }

    private String createColumn(CatalogAttribute attribute) {
//        this.storageAdapter.allotField()
        for (Map.Entry<String, DBColumnMeta> e : colmapUnused.entrySet()) {

        }
        return null;
    }

    private String findColumn(CatalogAttribute attribute) {
        DataType dataType=DataType.valueOf(attribute.getDataType());
        for (DBColumnMeta e : colmapUnused.values()) {
            if(dataType==DataType.STRING) {
                if(e.getDBDataType()== DBDataType.STRING  && attribute.getLength()==e.getCharLength()) {
                    return e.getColumn();
                }
            } else if(dataType==DataType.INTEGER) {
                if(e.getDBDataType()== DBDataType.INTEGER && attribute.getLength()==e.getDataLength()) {
                    return e.getColumn();
                }
            } else if(dataType==DataType.DECIMAL) {
                if(e.getDBDataType()== DBDataType.DECIMAL && attribute.getAccuracy()==e.getPrecision() &&  attribute.getScale()==e.getScale()) {
                    return e.getColumn();
                }
            } else if(dataType==DataType.DATE_TIME) {
                if(e.getDBDataType()== DBDataType.DATE) {
                    return e.getColumn();
                }
            } else if(dataType==DataType.LOGIC) {
                if(e.getDBDataType()== DBDataType.INTEGER && attribute.getLength()==e.getDataLength()) {
                    return e.getColumn();
                }
            }

        }
        return null;
    }
}
