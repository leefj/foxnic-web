package org.github.foxnic.web.oauth.logout;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.mvc.InvokeLogService;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.spring.SpringUtil;
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

	private InvokeLogService invokeLogService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		RequestParameter parameter=RequestParameter.get();
		if(invokeLogService==null) {
			invokeLogService= SpringUtil.getBean(InvokeLogService.class);
		}

		invokeLogService.start("账户登出", parameter,null,request.getRequestURI(),request.getRequestURL().toString(),parameter.getRequestBody());

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
