package org.github.foxnic.web.storage.support;

import org.github.foxnic.web.domain.storage.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public abstract class StorageSupport {

    private static Map<String,StorageSupport> SUPPORTS=new HashMap<>();

    public  static StorageSupport getStorageSupport(String configKey) {
        return SUPPORTS.get(configKey);
    }

    private String configKey;

    public  StorageSupport(String configKey) {
        this.configKey=configKey;
        SUPPORTS.put(this.configKey,this);
    }

    /**
     * 保存文件
     * */
    public abstract  File write(File fileInfo, MultipartFile mf);

    /**
     * 文件下载
     * */
    public abstract  byte[] read(File fileInfo) throws Exception;

    public abstract Boolean isFileExists(File fileInfo);
}
