package org.github.foxnic.web.oauth.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.web.ResponseUtils;
 

/**
 *  <p> 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此 </p>
 *
 * @description :  
 * @author : 李方捷
 * @date : 2021/05/28 17:32
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        ResponseUtils.out(response,  ErrorDesc.failure(CommonError.SESSION_INVALID));
    }
	
}
