package org.github.foxnic.web.storage.support;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.framework.config.ConfigKeys;
import org.github.foxnic.web.framework.security.ConfigDecryptor;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public abstract class StorageSupport {

    private static Map<String,StorageSupport> SUPPORTS=new HashMap<>();

    public  static StorageSupport getStorageSupport(String configKey) {
        return SUPPORTS.get(configKey);
    }

    private String configKey;

    public String getConfigKey() {
        return configKey;
    }

    public  StorageSupport(String configKey) {
        this.configKey=configKey;
        SUPPORTS.put(this.configKey,this);
    }

    /**
     * 保存文件
     * */
    public abstract  File write(File fileInfo, MultipartFile mf,String dir);

    /**
     * 文件下载
     * */
    public abstract  byte[] read(File fileInfo) throws Exception;

    public abstract Boolean isFileExists(File fileInfo);

    /**
     * 解密配置信息
     * */
    protected String decrypt(String data) {
        if(StringUtil.isBlank(data)) return data;
        Boolean enable= ConfigDecryptor.getBooleanProperty(ConfigKeys.FOXNIC_STORAGE,ConfigKeys.ENCRYPT,null);
        if(enable==null || !enable) return data;
        return ConfigDecryptor.decrypt(data);
    }



}
