package org.github.foxnic.web.oauth.logout;

import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.oauth.session.SessionUserImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义登录处理器
 *
 * @author 李方捷
 * @since  2021-06-02
 **/
public class UserLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

		if(authentication==null) {
    		Logger.info("no session user");
    		return;
    	}
    	Object principal=authentication.getPrincipal();
    	if(principal==null) {
    		Logger.info("no session user");
    		return;
    	}
        SessionUserImpl user = (SessionUserImpl) principal;
        String username = user.getUsername();
        Logger.info("username: {}  is offline now", username);
    }
}
