package org.github.foxnic.web.pcm.storage.model.types;

import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;

public abstract class AbstractType {

    private  DataType dataType;

    public DataType getDataType() {
        return dataType;
    }

    public  AbstractType(DataType dataType) {
        this.dataType=dataType;
    }

    public abstract boolean createDBField(DAO dao, String table, String fieldName, CatalogAttribute attribute);
}
