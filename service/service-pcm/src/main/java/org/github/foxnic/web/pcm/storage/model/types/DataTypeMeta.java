package org.github.foxnic.web.pcm.storage.model.types;

import org.github.foxnic.web.domain.pcm.DataType;

public class DataTypeMeta {
    private Class<? extends AbstractType> type;

    public Class<? extends AbstractType> getType() {
        return type;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    private Class[] paramTypes;

    public DataType getDataType() {
        return dataType;
    }

    private DataType dataType;


    public DataTypeMeta(DataType dataType, Class<? extends AbstractType> type, Class[] params) {
        this.type=type;
        this.paramTypes =params;
    }

}
