package org.github.foxnic.web.framework.licence;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.CP;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LicenceProxy {

    public static Object KE = null;
    public static Method KEM = null;
    public static Object LO = null;
    public static String LICENCE_DATA = null;
    public static String VnV_CODE =null;
    public static Long VnV_TICK=0L;
    public static String DP_CODE=null;
	public static String SN = "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";

    public static void reset() {
        try {
            CP.getInstance().reset();
            EXCLUDED_MENU_IDS = null;
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
     * 数据量是否任然在许可证限制的范围内
     * */
    public static boolean isInDataLimit(String key) {
        JSONObject lic=getLicence();
        if(lic==null) return true;
        JSONObject dataLimit=lic.getJSONObject("dataLimit");
        if(dataLimit==null) {
            return false;
        }
        JSONObject  item=dataLimit.getJSONObject(key);
        if(item==null) {
            return true;
        }
        // 如果未指定可用或或不可用，则在约束范围内
        if(item.getBoolean("enable")==null || item.getBoolean("enable")==false) {
            return true;
        }

        Long current=item.getLong("current");
        Long count=item.getLong("count");
        if(current==null) {
            return true;
        }
        return current<count;

    }

    private static List<String> EXCLUDED_MENU_IDS = null;

    /**
     * 获得未授权的菜单ID
     * */
    public static List<String> getExcludedMenuIds() {
//        if(System.currentTimeMillis()>0) {
//            return new ArrayList<>();
//        }
        if(EXCLUDED_MENU_IDS!=null) {
            return EXCLUDED_MENU_IDS;
        }
        List<String> ids=new ArrayList<>();
        JSONObject lic = null;
        try {
            lic = getLicence();
        } catch (Throwable t) {
            return ids;
        };
        if(lic==null) return ids;
        JSONObject menuExcludeData=lic.getJSONObject("menuExcludeData");
        if(menuExcludeData==null) return ids;
        JSONArray menuIds=menuExcludeData.getJSONArray("menuIds");
        if(menuIds==null) return ids;
        for (int i = 0; i < menuIds.size(); i++) {
            ids.add(menuIds.getString(i));
        }
        EXCLUDED_MENU_IDS = ids;
        return ids;
    }


    /**
     * 获得模块配置，建议把这个方法拷贝到自己的模块去
     * */
    public static JSONObject getModuleConfig(String code) {
        if(LicenceProxy.KE ==null || LicenceProxy.KEM==null) return null;
        try {
            return  (JSONObject)LicenceProxy.KEM.invoke(LicenceProxy.KE,code);
        } catch (Exception e) {
            Logger.error("许可读模块取置失败",e);
            return null;
        }
    }


}