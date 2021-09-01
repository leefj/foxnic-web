package org.github.foxnic.web.pcm.storage.mysql;

import com.github.foxnic.sql.meta.DBType;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.pcm.storage.model.StorageAdapter;
import org.github.foxnic.web.pcm.storage.model.types.DataTypeMeta;
import org.github.foxnic.web.pcm.storage.mysql.types.MySQLString;

public class MySQLStorageAdaptor extends StorageAdapter {

    public MySQLStorageAdaptor() {
        super(DBType.MYSQL);
        this.registTypes(new DataTypeMeta(DataType.STRING, MySQLString.class,new Class[]{int.class}));
    }

}
