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