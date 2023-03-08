package org.github.foxnic.web.framework.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;

import javax.sql.DataSource;
import java.io.File;

public class DBConfigs {

    public static final String PRIMARY_DAO = "primaryDAO";

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
    public static void reset(DataSource dataSource, String prefix, YMLProperties ymlcfg) {

        Boolean enable=getBooleanProperty(prefix, ConfigKeys.ENCRYPT,ymlcfg);
        if(enable==null || !enable) return;
        //
        OSType osType=OSType.getOSType();
        String file= getProperty(ConfigKeys.DEVELOP_ENCRYPT_FILE,osType.name().toLowerCase(),ymlcfg);
        File f=new File(file);
        if(!f.exists()){
            throw new RuntimeException(file+ " 文件不存在");
        }
        String passwd= FileUtil.readText(f);
        //
        AESUtil aes=new AESUtil(passwd);
        //
        String dbPassed=getProperty(prefix,"password",ymlcfg);
        String userName=getProperty(prefix,"username",ymlcfg);
        String url=getProperty(prefix,"url",ymlcfg);
        //
        if(dataSource instanceof DruidDataSource) {
            DruidDataSource dds=(DruidDataSource) dataSource;
            url=aes.decryptData(url);
            userName=aes.decryptData(userName);
            dds.setUrl(url);
            dds.setUsername(userName);
            dbPassed=aes.decryptData(dbPassed);
            dds.setPassword(dbPassed);
        }
    }

}
