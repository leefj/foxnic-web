package org.github.foxnic.web.pcm.storage.model;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBMetaData;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBDataType;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.service.ICatalogAllocationService;
import org.github.foxnic.web.pcm.service.ICatalogAttributeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldManager {

    private DAO dao;
    private String table;
    private DBTableMeta tableMeta;
    /**
     * 所有字段
     * */
    private Map<String, DBColumnMeta> colmapAll;
    /**
     * 未使用的字段
     * */
    private Map<String, DBColumnMeta> colmapUnused;
    private int fieldIndex=1;
    private List<CatalogAttribute> attributes;
    private Map<String, CatalogAttribute> attrmap;

    private StorageAdapter storageAdapter;

    private String temporaryTable = null;

    private ICatalogAttributeService catalogAttributeService;
    private ICatalogAllocationService catalogAllocationService;

    public FieldManager(DAO dao, String table, List<CatalogAttribute> attributes,ICatalogAttributeService catalogAttributeService,ICatalogAllocationService catalogAllocationService) {
        this.dao=dao;
        this.catalogAttributeService=catalogAttributeService;
        this.catalogAllocationService=catalogAllocationService;
        this.table=table;
        DBMetaData.invalid(this.dao,table);
        tableMeta=dao.getTableMeta(table);
        //
        this.attributes=attributes;
        attrmap=new HashMap<>();
        for (CatalogAttribute attribute : attributes) {
            if(attribute.getAllocation()==null) continue;
            attrmap.put(attribute.getAllocation().getColumn(),attribute);
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
            }
            colmapAll.put(column.getColumn(),column);
            if(!attrmap.keySet().contains(colname)) {
                colmapUnused.put(column.getColumn(),column);
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
        //校验字段
        List<Result> fieldErrors=new ArrayList<>();
        for (CatalogAttribute attribute : attributes) {
            Result r=storageAdapter.verifyField(dao,temporaryTable,attribute);
            if(r.failure()){
                fieldErrors.add(r);
            }
        }
        if(fieldErrors.size()>0) {
            result.success(false).addErrors(fieldErrors).message("属性校验失败");
            return result;
        }
        //分配字段
        for (CatalogAttribute attribute : attributes) {
            this.allotField(attribute);
        }
        return result;
    }


    /**
     * 应用已经分配的字段到存储表
     * */
    public void applyAllotedFields() {
        //验证字段
        for (CatalogAttribute attribute : attributes) {
            allotField(attribute);
        }

        for (CatalogAttribute attribute : attributes) {
            allotField(attribute);
        }
    }

    /**
     * 分配字段
     * */
    private CatalogAttribute allotField(CatalogAttribute attribute) {
        CatalogAllocation allocation=attribute.getAllocation();
        if(allocation==null) {
            //在未使用清单中查找
            String column=findColumn(attribute);
            //如果找到匹配的未使用字段
            if(column!=null) {
                this.colmapUnused.remove(column);
            } else {
                //如果未找到未使用的匹配字段，则创建一个新字段
                fieldIndex++;
                column="f_"+fieldIndex;
            }
            allocation=new CatalogAllocation();
            allocation.setCatalogId(attribute.getCatalogId());
            allocation.setColumn(column);
            allocation.setAttributeId(attribute.getId());
            attribute.setAllocation(allocation);
            //创建并关联
            catalogAllocationService.insert(allocation);
        } else {
            // 如果存在则验证字段
            
        }
        return  attribute;
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
