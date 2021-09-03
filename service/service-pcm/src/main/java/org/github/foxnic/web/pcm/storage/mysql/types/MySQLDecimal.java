package org.github.foxnic.web.pcm.storage.mysql.types;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.pcm.storage.model.types.AbstractDecimal;
import org.github.foxnic.web.pcm.storage.model.types.AbstractString;

public class MySQLDecimal extends AbstractDecimal {

    @Override
    public boolean createDBField(DAO dao,String table,String fieldName, CatalogAttribute attribute) {
        try {
            dao.execute("alter table "+table+" add column "+fieldName+" decimal("+attribute.getAccuracy()+", "+attribute.getScale()+") null");
            return true;
        } catch (Exception e) {
            Logger.exception("创建字段异常",e);
            return false;
        }
    }
}
