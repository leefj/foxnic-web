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