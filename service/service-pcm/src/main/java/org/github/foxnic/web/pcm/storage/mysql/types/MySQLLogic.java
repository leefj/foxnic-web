package org.github.foxnic.web.pcm.storage.mysql.types;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.pcm.storage.model.types.AbstractLogic;

public class MySQLLogic extends AbstractLogic {

    @Override
    public boolean createDBField(DAO dao,String table,String fieldName, CatalogAttribute attribute) {
        try {
            dao.execute("alter table "+table+" add column "+fieldName+" integer(1) null");
            return true;
        } catch (Exception e) {
            Logger.exception("创建字段异常",e);
            return false;
        }
    }
}
