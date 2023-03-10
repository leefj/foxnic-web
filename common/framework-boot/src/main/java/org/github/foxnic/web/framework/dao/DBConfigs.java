package org.github.foxnic.web.framework.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;
import org.github.foxnic.web.framework.security.ConfigDecryptor;

import javax.sql.DataSource;
import java.io.File;

public class DBConfigs {

    public static final String PRIMARY_DAO = "primaryDAO";

    /**
     * 解密数据库配置信息，并重新设置数据库连接
     * */
    public static void reset(DataSource dataSource, String prefix, YMLProperties ymlcfg) {

        Boolean enable= ConfigDecryptor.getBooleanProperty(prefix, ConfigKeys.ENCRYPT,ymlcfg);
        if(enable==null || !enable) return;

        //
        String dbPassed=ConfigDecryptor.getProperty(prefix,"password",ymlcfg);
        String userName=ConfigDecryptor.getProperty(prefix,"username",ymlcfg);
        String url=ConfigDecryptor.getProperty(prefix,"url",ymlcfg);
        //
        if(dataSource instanceof DruidDataSource) {
            DruidDataSource dds=(DruidDataSource) dataSource;
            url=ConfigDecryptor.decrypt(url,ymlcfg);
            userName=ConfigDecryptor.decrypt(userName,ymlcfg);
            dds.setUrl(url);
            dds.setUsername(userName);
            dbPassed=ConfigDecryptor.decrypt(dbPassed,ymlcfg);
            dds.setPassword(dbPassed);
        }
    }

}
