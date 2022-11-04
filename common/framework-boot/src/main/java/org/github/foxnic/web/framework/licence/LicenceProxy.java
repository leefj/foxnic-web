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