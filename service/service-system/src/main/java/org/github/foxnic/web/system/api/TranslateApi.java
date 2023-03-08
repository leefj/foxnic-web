package org.github.foxnic.web.system.api;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;
import org.github.foxnic.web.system.service.ILangService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public abstract class TranslateApi {

    @Autowired
    protected ILangService langService;

    public abstract void translate(String code);


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

    /**
     * 解密数据库配置信息，并重新设置数据库连接
     * */
    public String decrypt(String data) {



        Boolean enable=getBooleanProperty(ConfigKeys.FOXNIC_LANGUAGE_TRANSLATOR,ConfigKeys.ENCRYPT,null);
        if(enable==null || !enable) return data;
        //
        OSType osType=OSType.getOSType();
        String file= getProperty(ConfigKeys.DEVELOP_ENCRYPT_FILE,osType.name().toLowerCase(),null);
        File f=new File(file);
        if(!f.exists()){
            throw new RuntimeException(file+ " 文件不存在");
        }
        String passwd= FileUtil.readText(f);
        //
        AESUtil aes=new AESUtil(passwd);
        return aes.decryptData(data);
    }

}
