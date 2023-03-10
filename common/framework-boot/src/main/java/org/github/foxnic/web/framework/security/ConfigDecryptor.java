package org.github.foxnic.web.framework.security;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;

/**
 * 配置信息解密工具
 * */
public class ConfigDecryptor {

    private static AESUtil aesUtil = null;

    private static void initAESUtil(YMLProperties ymlcfg) {
        if(aesUtil!=null) return;
        //
        OSType osType=OSType.getOSType();
        String file= getProperty(ConfigKeys.DEVELOP_ENCRYPT_FILE,osType.name().toLowerCase(),ymlcfg);
        java.io.File f=new java.io.File(file);
        if(!f.exists()){
            throw new RuntimeException(file+ " 文件不存在");
        }
        String passwd= FileUtil.readText(f);
        //
        aesUtil=new AESUtil(passwd);
    }


    /**
     * 解密数据配置信息
     * */
    public static String decrypt(String data) {
        return decrypt(data,null);
    }

    /**
     * 解密数据配置信息
     * */
    public static String decrypt(String data,YMLProperties ymlcfg) {
        initAESUtil(ymlcfg);
        if(StringUtil.isBlank(data)) return data;
        return aesUtil.decryptData(data);
    }

    public static String getProperty(String prefix,String suffix, YMLProperties ymlcfg) {
        String key=prefix+"."+suffix;
        if(ymlcfg!=null) {
            return ymlcfg.getProperty(key).stringValue();
        } else {
            return SpringUtil.getEnvProperty(key);
        }
    }

    public static Boolean getBooleanProperty(String prefix,String suffix, YMLProperties ymlcfg) {
        return DataParser.parseBoolean(getProperty(prefix,suffix,ymlcfg));
    }

}
