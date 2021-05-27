package org.github.foxnic.web.oauth.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.domain.SOSUserDetails;
import org.github.foxnic.web.oauth.utils.ResponseUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;

 

/**
 *  <p> 认证成功处理 </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/12 15:31
 */
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
//        User user = new User();
        SOSUserDetails securityUser = ((SOSUserDetails) auth.getPrincipal());
//        user.setToken(securityUser.getToken());
        Result r=ErrorDesc.success().message("登录成功!").data(securityUser.getUser());
        ResponseUtils.out(response, r);
    }
}
