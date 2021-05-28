package org.github.foxnic.web.oauth.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.oauth.domain.SOSUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.ResponseUtils;

 

/**
 *  <p> 认证成功处理 </p>
 *
 * @description :
 * @author : 李方捷
 * @date : 2021/05/28
 */
@Component
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        SOSUserDetails securityUser = ((SOSUserDetails) auth.getPrincipal());
        
        JSONObject ret=new JSONObject();
        
        User user=securityUser.getUser().toPojo(User.class);
        user.setPasswd(null).setSalt(null);
        ret.put("user", user);
        ret.put("token", securityUser.getToken());
        
        Result r=ErrorDesc.success().message("登录成功").data(ret);
 
        ResponseUtils.out(response, r);
    }
}
