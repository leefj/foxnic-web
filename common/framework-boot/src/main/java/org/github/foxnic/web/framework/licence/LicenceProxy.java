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