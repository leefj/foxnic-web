package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;

import java.util.Date;

public class SystemConfigProxyUtil {

    /**
     * 获取系统配置
     * */
    public static String getString(SystemConfigEnum key) {
        Result<Config> result =ConfigServiceProxy.api().getById(key.code());
        if(result==null) return null;
        if(result.failure()) return  null;
        return result.data().getValue();
    }

    /**
     * 获取系统配置
     * */
    public static Date getDate(SystemConfigEnum key) {
        return DataParser.parseDate(getString(key));
    }

}
