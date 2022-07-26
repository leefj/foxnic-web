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