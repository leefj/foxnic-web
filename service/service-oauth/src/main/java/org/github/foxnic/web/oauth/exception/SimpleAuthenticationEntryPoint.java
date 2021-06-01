package org.github.foxnic.web.oauth.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.web.ResponseUtils;

/**
 * 认证异常处理
 * @author dax
 * @since 2019/11/6 22:11
 */
@Component
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	public static void handleException(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
		String uri=request.getRequestURI();
		Result result;
        if (e instanceof UsernameNotFoundException) {
        	 result = ErrorDesc.failure(CommonError.USER_NOT_EXISTS);
        } else if (e instanceof BadCredentialsException) {
        	 result = ErrorDesc.failure(CommonError.PASSWORD_INVALID);
        } else if (e instanceof LockedException) {
            result = ErrorDesc.failure(CommonError.USER_BLOCKED);
        } else if (e instanceof CredentialsExpiredException) {
            result = ErrorDesc.failure(CommonError.CREDENTIALS_EXPIRED);
        } else if (e instanceof AccountExpiredException) {
            result = ErrorDesc.failure(CommonError.USER_EXPIRED);
        } else if (e instanceof DisabledException) {
        	result = ErrorDesc.failure(CommonError.USER_DISABLED);
        } else if(e instanceof InsufficientAuthenticationException) {
        	result = ErrorDesc.failure(CommonError.PERMISSION_REQUIRED);
        } else {
            Logger.error("登录失败：", e);
            result = ErrorDesc.failureMessage("登录失败!");
        }
        ResponseUtils.out(response, result);
	}
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
    	handleException(request,response,e);
    }
}
