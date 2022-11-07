package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemConfigProxyUtil {

    /**
     * 获取字符串型系统配置
     * */
    public static String getString(SystemConfigEnum key) {
        Result<Config> result =ConfigServiceProxy.api().getByCode(key.code());
        if(result==null) return null;
        if(result.failure()) return  null;
        if(result.data()==null) return null;
        return result.data().getValue();
    }

    /**
     * 获取JSONArray型系统配置
     * */
    public static JSONArray getJSONArray(SystemConfigEnum key) {
         String data=getString(key);
         if(data==null) return null;
         try {
             return JSONArray.parseArray(data);
         } catch (Exception e) {
             Logger.exception(e);
             return null;
         }
    }

    /**
     * 获取 CodeTextEnum 型系统配置
     * */
    public static <T extends CodeTextEnum> T getEnum(SystemConfigEnum key,Class<T> type) {
        String value=getString(key);
        return  EnumUtil.parseByCode(type,value);
    }


    /**
     * 获取 List<CodeTextEnum> 型系统配置
     * */
    public static <T extends CodeTextEnum> List<T> getEnumList(SystemConfigEnum key,Class<T> type) {
        JSONArray value=getJSONArray(key);
        if(value==null) return null;
        List<T> list=new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            list.add(EnumUtil.parseByCode(type,value.getString(i)));
        }
        return list;
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
