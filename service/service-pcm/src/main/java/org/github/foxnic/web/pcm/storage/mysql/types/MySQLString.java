package org.github.foxnic.web.pcm.storage.mysql.types;

import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.pcm.storage.model.types.AbstractString;

public class MySQLString extends AbstractString {

    public MySQLString(int length) {
        super(length);
    }

    @Override
    public void createDBField(DAO dao,String table) {

    }
}
