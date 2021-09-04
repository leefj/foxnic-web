package org.github.foxnic.web.pcm.storage.mysql.types;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.pcm.storage.model.types.AbstractString;

public class MySQLString extends AbstractString {

    @Override
    public Result createDBField(DAO dao, String table, String fieldName, CatalogAttribute attribute) {
        try {
            if(attribute.getLength()>4096) {
                dao.execute("alter table "+table+" add column "+fieldName+" text null");
            } else {
                dao.execute("alter table "+table+" add column "+fieldName+" varchar("+attribute.getLength()+") null");
            }
            return ErrorDesc.success();
        } catch (Exception e) {
            Logger.exception("创建字段异常",e);
            return handleException(e,fieldName,attribute);
        }
    }
}
