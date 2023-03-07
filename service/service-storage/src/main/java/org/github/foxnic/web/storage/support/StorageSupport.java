package org.github.foxnic.web.storage.support;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
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
    public abstract  File write(File fileInfo, MultipartFile mf,String dir);

    /**
     * 文件下载
     * */
    public abstract  byte[] read(File fileInfo) throws Exception;

    public abstract Boolean isFileExists(File fileInfo);

    /**
     * 解密数据库配置信息，并重新设置数据库连接
     * */
    protected String decrypt(String prefix,String data) {
        if(StringUtil.isBlank(data)) return data;
        Boolean enable=getBooleanProperty(prefix,"encrypt.enable",null);
        if(enable==null || !enable) return data;
        //
        OSType osType=OSType.getOSType();
        String file= getProperty(prefix,"encrypt.file."+ osType.name().toLowerCase(),null);
        java.io.File f=new java.io.File(file);
        if(!f.exists()){
            throw new RuntimeException(file+ " 文件不存在");
        }
        String passwd= FileUtil.readText(f);
        //
        AESUtil aes=new AESUtil(passwd);
        return aes.decryptData(data);
    }

    protected static String getProperty(String prefix,String suffix, YMLProperties ymlcfg) {
        String key=prefix+"."+suffix;
        if(ymlcfg!=null) {
            return ymlcfg.getProperty(key).stringValue();
        } else {
            return SpringUtil.getEnvProperty(key);
        }
    }

    protected static Boolean getBooleanProperty(String prefix,String suffix, YMLProperties ymlcfg) {
        return DataParser.parseBoolean(getProperty(prefix,suffix,ymlcfg));
    }

}
