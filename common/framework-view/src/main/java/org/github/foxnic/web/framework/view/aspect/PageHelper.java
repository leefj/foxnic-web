package org.github.foxnic.web.framework.view.aspect;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.proxy.utils.DBCacheProxyUtil;
import org.github.foxnic.web.session.SessionUser;

import javax.servlet.http.HttpServletRequest;

public class PageHelper {

    private HttpServletRequest  request;
    private SessionUser user;

    public  PageHelper(HttpServletRequest  request,SessionUser user) {
        this.request=request;
        this.user=user;
    }

    public JSONObject getTableColumnWidthConfig(String tableId) {
        return DBCacheProxyUtil.getLayUITableWidthConfig(request,user,tableId);
    }

    /**
     * 在模版调用
     * */
    public boolean checkDefault(String code,Integer index,String valueStr,String indexStr) {
        indexStr= StringUtil.trim(indexStr,",");
        valueStr=StringUtil.trim(valueStr,",");
        if(!StringUtil.isBlank(indexStr)){
            indexStr=","+indexStr+",";
            if(indexStr.contains(","+index+",")) return true;
        }
        if(!StringUtil.isBlank(valueStr)){
            valueStr=","+valueStr+",";
            if(valueStr.contains(","+code+",")) return true;
        }
        return false;
    }



}
