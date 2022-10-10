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