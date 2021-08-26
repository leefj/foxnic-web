package org.github.foxnic.web.framework.view.aspect;

import com.alibaba.fastjson.JSONObject;
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

}
