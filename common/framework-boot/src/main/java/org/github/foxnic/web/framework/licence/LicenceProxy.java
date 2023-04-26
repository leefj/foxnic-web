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