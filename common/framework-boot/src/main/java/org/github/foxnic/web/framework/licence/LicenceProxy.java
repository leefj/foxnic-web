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