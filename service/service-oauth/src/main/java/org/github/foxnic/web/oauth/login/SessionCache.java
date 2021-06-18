package org.github.foxnic.web.oauth.login;

import com.github.foxnic.commons.cache.LocalCache;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Component;

/**
 * 会话缓存的副本，用户按 sessionId 获得会话用户
 * 与 SpringSecurity 的会话缓存用的不是同一个，后期再考虑合并问题，以及远程缓存的扩展问题
 * */
@Component
public class SessionCache {

    LocalCache<String, SessionUser> cache=new LocalCache<>();

    public void put(String sessionId, SessionUser sessionUser) {
        cache.put(sessionId,sessionUser);
    }

    public SessionUser get(String sessionId) {
        return cache.get(sessionId);
    }

    public void remove(String sessionId) {
        cache.remove(sessionId);
    }

}
