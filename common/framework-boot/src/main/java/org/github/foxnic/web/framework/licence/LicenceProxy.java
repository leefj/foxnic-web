package org.github.foxnic.web.framework.licence;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.CP;

import java.lang.reflect.Method;

public class LicenceProxy {

    public static Object KE = null;
    public static Method KEM = null;
    public static Object LO = null;
    public static String LICENCE_DATA = null;
    public static String VnV_CODE=null;
    public static Long VnV_TICK=0L;
	public static String SN = "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";

    public static void reset() {
        try {
            CP.getInstance().reset();
        } catch (Exception e) {
            Logger.error("许可证重置失败",e);
        }
    }

    public static JSONObject getLicence() {
        try {
            return CP.getInstance().getConfig();
        } catch (Exception e) {
            Logger.error("许可读取置失败",e);
            return null;
        }
    }

    /**
     * 获得模块配置，建议把这个方法拷贝到自己的模块去
     * */
    public static JSONObject getModuleConfig(String code) {
        if(LicenceProxy.KE==null || LicenceProxy.KEM==null) return null;
        try {
            return  (JSONObject)LicenceProxy.KEM.invoke(LicenceProxy.KE,code);
        } catch (Exception e) {
            Logger.error("许可读模块取置失败",e);
            return null;
        }
    }


}