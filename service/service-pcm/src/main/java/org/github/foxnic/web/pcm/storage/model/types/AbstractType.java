package org.github.foxnic.web.pcm.storage.model.types;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.springframework.jdbc.BadSqlGrammarException;

public abstract class AbstractType {

    private  DataType dataType;

    public DataType getDataType() {
        return dataType;
    }

    public  AbstractType(DataType dataType) {
        this.dataType=dataType;
    }

    public abstract Result createDBField(DAO dao, String table, String fieldName, CatalogAttribute attribute);

    protected Result handleException(Exception e,String fieldName,CatalogAttribute attribute){
        Result r= ErrorDesc.exception(e);
        boolean handled=false;
        if(e instanceof BadSqlGrammarException) {
            if(e.getCause()!=null && e.getCause().getMessage().toLowerCase().contains("duplicate column")){
                r.message("属性:" + attribute.getFullName() + "(" + fieldName + ") 字段名已经存在");
                handled=true;
            }
        }
        if(!handled) {
            r.message("属性:" + attribute.getFullName() + "(" + fieldName + ") 配置错误");
        }
        r.data(attribute);
        return r;
    }
}
