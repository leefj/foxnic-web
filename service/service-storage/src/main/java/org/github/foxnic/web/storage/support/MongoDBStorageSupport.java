package org.github.foxnic.web.storage.support;

import org.github.foxnic.web.domain.storage.File;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MongoDBStorageSupport extends  StorageSupport {
    public MongoDBStorageSupport() {
        super("mongodb");
    }

    @Override
    public File write(File fileInfo, MultipartFile mf) {
        return null;
    }

    @Override
    public byte[] read(File fileInfo) {
        return new byte[0];
    }
}
