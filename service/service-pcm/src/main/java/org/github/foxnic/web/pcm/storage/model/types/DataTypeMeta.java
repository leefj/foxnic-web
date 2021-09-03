package org.github.foxnic.web.pcm.storage.model.types;

import org.github.foxnic.web.domain.pcm.DataType;

public class DataTypeMeta {
    private Class<? extends AbstractType> type;

    public Class<? extends AbstractType> getType() {
        return type;
    }

    public DataType getDataType() {
        return dataType;
    }

    private DataType dataType;

    public DataTypeMeta(DataType dataType, Class<? extends AbstractType> type) {
        this.type=type;
        this.dataType=dataType;
    }

}
