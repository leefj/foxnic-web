package org.github.foxnic.web.oauth.session;


import com.github.foxnic.commons.cache.LocalCache;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import javax.websocket.SessionException;

public class SessionContext {

    private static final  String SESSION_ONLINE_ID_KEY="SESSION_ONLINE_ID_KEY";

    private static final  String SESSION_USER_KEY="SESSION_USER_KEY";

    private static LocalCache<String, HttpSession> SESSIONS=new LocalCache<>();

    public static void put(HttpSession session) {
        if(session==null) return;
        SESSIONS.put(session.getId(),session);
    }

    public static HttpSession get(String sessionId) {
        return SESSIONS.get(sessionId);
    }

    public static HttpSession getCurrent() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes!=null) {
            HttpSession session=SESSIONS.get(attributes.getSessionId());
            if(session!=null) return session;
            return attributes.getRequest().getSession();
        } else {
            return null;
        }
    }

    public static String getOnlineSessionId(HttpSession session) {
        if(session==null) {
            session = getCurrent();
        }
        if(session!=null) {
            return (String) session.getAttribute(SESSION_ONLINE_ID_KEY);
        } else {
            return null;
        }
    }

    public static String getCurrentOnlineSessionId() {
        return getOnlineSessionId(null);
    }

    public static void setCurrentOnlineSessionId(HttpSession session,String sessionId) {
        String onlineId=getOnlineSessionId(session);
        if(onlineId==null) {
            if(session==null) {
                session = getCurrent();
            }
            session.setAttribute(SESSION_ONLINE_ID_KEY,sessionId);
        } else {
            throw new RuntimeException("不允许重复设置 CurrentOnlineSessionId");
        }
    }

    public static SessionUser getCurrentSessionUser() {
        HttpSession session=getCurrent();
        if(session==null) return null;
        return getSessionUser(session);
    }

    public static SessionUser getSessionUser(String sessionId) {
        HttpSession session=get(sessionId);
        if(session==null) return null;
        return  getSessionUser(session);
    }

    public static SessionUser getSessionUser(HttpSession session) {
        if(session==null) return null;
        return (SessionUser) session.getAttribute(SESSION_USER_KEY);
    }

    public static void setCurrentSessionUser(SessionUser user) {
        SessionUser exUser=getCurrentSessionUser();
        if(exUser==null) {
            HttpSession session = getCurrent();
            session.setAttribute(SESSION_USER_KEY,user);
        } else {
            throw new RuntimeException("不允许重复设置 SessionUser");
        }
    }

    public static void remove(String sessionId) {
        SESSIONS.remove(sessionId);
    }

    public static void changeSessionId(String oldSessionId,HttpSession session) {
        remove(oldSessionId);
        if(session==null) return;
        put(session);
    }


}
