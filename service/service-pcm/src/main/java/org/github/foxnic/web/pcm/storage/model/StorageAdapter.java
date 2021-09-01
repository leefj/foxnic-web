package org.github.foxnic.web.pcm.storage.model;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBMetaData;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.storage.model.types.AbstractType;
import org.github.foxnic.web.pcm.storage.model.types.DataTypeMeta;
import org.github.foxnic.web.pcm.storage.mysql.MySQLStorageAdaptor;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class StorageAdapter {

    private static final Map<DBType,StorageAdapter> ADAPTERS = new HashMap<>();
    static {
        new MySQLStorageAdaptor();
    }

    public static  StorageAdapter getStorageAdapter(DAO dao) {
        return  ADAPTERS.get(dao.getDBType());
    }

    private DBType dbType=null;
    private Map<DataType, DataTypeMeta> types=new HashMap<>();
    public StorageAdapter(DBType dbType) {
        this.dbType=dbType;
        ADAPTERS.put(this.dbType,this);
    }


    protected void registTypes(DataTypeMeta... metas) {
        for (DataTypeMeta m : metas) {
            types.put(m.getDataType(),m);
        }
    }

    public Result allotField(DAO dao, String table, List<CatalogAttribute> attributes,CatalogAttribute attribute) {
        //
        DBMetaData.invalid(dao,table);
        DBTableMeta tm=dao.getTableMeta(table);
        //按字段名形成以map
        Map<String,DBColumnMeta> columnMap=new HashMap<>();
        for (DBColumnMeta column : tm.getColumns()) {
            if(column.getColumn().toLowerCase().startsWith("f_")) {
                columnMap.put(column.getColumn(), column);
            }
        }
        //
        DataType dataType = DataType.valueOf(attribute.getDataType());
        DataTypeMeta meta = this.types.get(dataType);
        //
        for (CatalogAttribute attr : attributes) {
            if(attr.getId().equals(attributes)) {
                attributes.remove(attr);
                break;
            }
        }
        //

        //
        AbstractType typeImpl = null;
        try {
            Constructor constructor = meta.getType().getConstructor(meta.getParamTypes());
            if (dataType == DataType.STRING) {
                typeImpl = (AbstractType) constructor.newInstance(attribute.getLength());
            }
        } catch (Exception e) {
            Logger.error("数据类型创建失败", e);
        }
        if (typeImpl == null) {
            throw new RuntimeException("数据类型不支持");
        }
        typeImpl.createDBField(dao,table);
        return ErrorDesc.success();
    }




}
