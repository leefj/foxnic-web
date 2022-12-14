package org.github.foxnic.web.oauth.logout;

 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.session.SessionUserImpl;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.api.error.ErrorDesc;

/**
 * CustomLogoutSuccessHandler
 *
 * @author 李方捷
 * @since  2021-06-02
 **/

public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        
    	if(authentication==null) {
    		ResponseUtil.writeOK(response,ErrorDesc.failure().message("no session"));
    		return;
    	}
     
    	Object principal=authentication.getPrincipal();
    	if(principal==null) {
    		ResponseUtil.writeOK(response,ErrorDesc.failure().message("no session"));
    		return;
    	}
    	
    	SessionUserImpl user = (SessionUserImpl) principal;
        String username = user.getUsername();
        Logger.info("username: {}  is offline now", username);
        
        ResponseUtil.writeOK(response,ErrorDesc.success());
    }

   
}
