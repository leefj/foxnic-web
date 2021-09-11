package org.github.foxnic.web.framework.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.springboot.spring.SpringUtil;

import javax.sql.DataSource;
import java.io.File;

public class DBConfigs {

    public static final String PRIMARY_DAO = "primaryDAO";

    /**
     * 解密数据库配置信息，并重新设置数据库连接
     * */
    public static void reset(DataSource dataSource, String prefix) {

        Boolean enable=SpringUtil.getBooleanEnvProperty(prefix+".encrypt.enable");
        if(enable==null || !enable) return;
        //
        OSType osType=OSType.getOSType();
        String file= SpringUtil.getEnvProperty(prefix+".encrypt.file."+ osType.name().toLowerCase());
        String passwd= FileUtil.readText(new File(file));
        //
        AESUtil aes=new AESUtil(passwd);
        //
        String dbPassed=SpringUtil.getEnvProperty(prefix+".password");
        //
        if(dataSource instanceof DruidDataSource) {
            DruidDataSource dds=(DruidDataSource) dataSource;
            String url=aes.decryptData(dds.getUrl());
            String username=aes.decryptData(dds.getUsername());
            dds.setUrl(url);
            dds.setUsername(username);
            dbPassed=aes.decryptData(dbPassed);
            dds.setPassword(dbPassed);
        }
    }
}
