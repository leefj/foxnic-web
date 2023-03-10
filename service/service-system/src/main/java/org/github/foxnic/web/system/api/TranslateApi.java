package org.github.foxnic.web.system.api;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;
import org.github.foxnic.web.framework.security.ConfigDecryptor;
import org.github.foxnic.web.system.service.ILangService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public abstract class TranslateApi {

    @Autowired
    protected ILangService langService;

    public abstract void translate(String code);

    /**
     * 解密数据库配置信息，并重新设置数据库连接
     * */
    public String decrypt(String data) {
        Boolean enable= ConfigDecryptor.getBooleanProperty(ConfigKeys.FOXNIC_LANGUAGE_TRANSLATOR,ConfigKeys.ENCRYPT,null);
        if(enable==null || !enable) return data;
        //
        return ConfigDecryptor.decrypt(data);
    }

}
