package org.github.foxnic.web.pcm.storage.model.types;

import org.github.foxnic.web.domain.pcm.DataType;

public abstract class AbstractString  extends AbstractType {

    private int length = 128;

    public AbstractString(int length) {
        super(DataType.STRING);
        this.length=length;
    }

    public int getLength() {
        return length;
    }
}
