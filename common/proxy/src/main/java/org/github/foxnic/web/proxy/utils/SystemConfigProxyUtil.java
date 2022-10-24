package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;

import java.util.Date;

public class SystemConfigProxyUtil {

    /**
     * 获取字符串型系统配置
     * */
    public static String getString(SystemConfigEnum key) {
        Result<Config> result =ConfigServiceProxy.api().getByCode(key.code());
        if(result==null) return null;
        if(result.failure()) return  null;
        return result.data().getValue();
    }

    public static <T extends CodeTextEnum> T getEnum(SystemConfigEnum key,Class<T> type) {
        String value=getString(key);
        return  EnumUtil.parseByCode(type,value);
    }

    /**
     * 获取日期型系统配置
     * */
    public static Date getDate(SystemConfigEnum key) {
        return DataParser.parseDate(getString(key));
    }

    /**
     * 获取 Boolean 型系统配置
     * */
    public static Boolean getBoolean(SystemConfigEnum key) {
        String value=getString(key);
        return DataParser.parseBoolean(value);
    }

}
