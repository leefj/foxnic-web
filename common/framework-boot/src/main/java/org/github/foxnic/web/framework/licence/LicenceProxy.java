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