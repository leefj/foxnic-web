package org.github.foxnic.web.proxy.utils;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.session.SessionUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUserProxyUtil {

    private static UserServiceProxy proxy;

    private static void  init() {
       if(proxy==null) proxy=UserServiceProxy.api();
    }

    /**
     * 目前仅实现单体应用的逻辑，后期实现微服务以及前后端分离的逻辑
     * */
    public static SessionUser getSessionUser(HttpServletRequest request) {
        init();
        HttpSession session=request.getSession();
        if(session==null) return null;
        String sessionId=session.getId();
        Result<SessionUser> result=proxy.getSessionUser(sessionId);
        if(result.success()) return null;
        return result.data();
    }


}
