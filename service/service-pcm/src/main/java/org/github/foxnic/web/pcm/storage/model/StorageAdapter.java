package org.github.foxnic.web.pcm.storage.model;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.storage.model.types.AbstractType;
import org.github.foxnic.web.pcm.storage.model.types.DataTypeMeta;
import org.github.foxnic.web.pcm.storage.mysql.MySQLStorageAdaptor;

import java.util.HashMap;
import java.util.Map;

public abstract class StorageAdapter {

    private static final Map<DBType,StorageAdapter> ADAPTERS = new HashMap<>();
    static {
        new MySQLStorageAdaptor();
    }

    public static  StorageAdapter getStorageAdapter(DBType dbType) {
        return  ADAPTERS.get(dbType);
    }


    private DBType dbType=null;
    private Map<DataType, DataTypeMeta> types=new HashMap<>();
    public StorageAdapter(DBType dbType) {
        this.dbType=dbType;
        ADAPTERS.put(this.dbType,this);
    }

    protected void registDataTypes(DataTypeMeta... metas) {
        for (DataTypeMeta m : metas) {
            types.put(m.getDataType(),m);
        }
    }

    /**
     * 创建一个临时表
     * */
    public abstract Result createTemporaryTable(DAO dao,String temporaryTable);
    /**
     * 在临时表验证字段是否能够被创建
     * */
    public abstract Result verifyField(DAO dao,String temporaryTable,CatalogAttribute attribute);


    protected Result createField(DAO dao,String table,CatalogAttribute attribute,boolean useAllocation) {

        DataType dataType=DataType.valueOf(attribute.getDataType());
        DataTypeMeta meta = this.types.get(dataType);

        AbstractType typeImpl = null;
        try {
            typeImpl = (AbstractType) meta.getType().newInstance();
        } catch (Exception e) {
            Logger.error("数据类型创建失败", e);
        }
        if (typeImpl == null) {
            throw new RuntimeException("数据类型不支持");
        }
        boolean suc=false;
        String fieldName=null;
        if(useAllocation) {
            fieldName=attribute.getAllocation().getColumnName();
        } else {
            fieldName=attribute.getField();
        }
        return  typeImpl.createDBField(dao, table,fieldName,attribute);
    }

    public abstract void dropTemporaryTable(DAO dao, String temporaryTable);
}
