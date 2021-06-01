package org.github.foxnic.web.oauth.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.config.user.SessionUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.github.foxnic.commons.log.Logger;

/**
 * 自定义登录处理器
 *
 * @author Felordcn
 * @since 16:55 2019/10/23
 **/
public class CustomLogoutHandler implements LogoutHandler {
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
        SessionUser user = (SessionUser) principal;
        String username = user.getUsername();
        Logger.info("username: {}  is offline now", username);
    }
}
