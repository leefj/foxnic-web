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