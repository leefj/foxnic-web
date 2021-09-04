package org.github.foxnic.web.pcm.storage.mysql;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.storage.model.StorageAdapter;
import org.github.foxnic.web.pcm.storage.model.types.DataTypeMeta;
import org.github.foxnic.web.pcm.storage.mysql.types.*;

public class MySQLStorageAdaptor extends StorageAdapter {

    public MySQLStorageAdaptor() {
        super(DBType.MYSQL);
        this.registDataTypes(new DataTypeMeta(DataType.STRING, MySQLString.class));
        this.registDataTypes(new DataTypeMeta(DataType.INTEGER, MySQLInteger.class));
        this.registDataTypes(new DataTypeMeta(DataType.DECIMAL, MySQLDecimal.class));
        this.registDataTypes(new DataTypeMeta(DataType.DATE_TIME, MySQLDatetime.class));
        this.registDataTypes(new DataTypeMeta(DataType.LOGIC, MySQLLogic.class));
    }


    @Override
    public Result createTemporaryTable(DAO dao,String temporaryTable) {
        try {
            dao.execute("create table "+temporaryTable+"(id int primary key) Engine=InnoDB default charset utf8");
            return ErrorDesc.success();
        } catch (Exception e) {
            return ErrorDesc.failure().message("创建临时表失败");
        }
    }


    @Override
    public Result verifyField(DAO dao, String temporaryTable,CatalogAttribute attribute) {
        return this.createField(dao,temporaryTable,attribute,false);
    }

    @Override
    public void dropTemporaryTable(DAO dao, String temporaryTable) {
        dao.execute("drop table "+temporaryTable);
    }
}
