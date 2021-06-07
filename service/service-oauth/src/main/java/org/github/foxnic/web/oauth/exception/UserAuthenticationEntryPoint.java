package org.github.foxnic.web.oauth.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
import org.springframework.web.method.HandlerMethod;

import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;

/**
 * 认证异常处理
 * @author 李方捷
 * @since  2021-06-02
 */
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
 
	private static WebContext context;
	
	private static SecurityProperties securityProperties;
	
	public static void handleException(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
		
		String url=request.getRequestURL().toString();
		String uri=request.getRequestURI();
		
		Logger.error("不允许访问 "+url);
		
		if(context==null) {
			context=SpringUtil.getBean(WebContext.class);
		}
		if(securityProperties==null) {
			securityProperties=SpringUtil.getBean(SecurityProperties.class);
		}
		
		//如果是静态资源，重定向到登录页
		if(context.isStaticResource(request)) {
			response.sendRedirect(securityProperties.getLoginPage());
			return;
		}
		
	 
		HandlerMethod hm=context.getHandlerMethod(request);
		if(hm==null) {
			response.sendRedirect(securityProperties.getLoginPage());
			return;
		}
		
		//如果未返回 Result 则不是 API 接口
		if(!Result.class.isAssignableFrom(hm.getMethod().getReturnType())) {
			response.sendRedirect(securityProperties.getLoginPage());
			return;
		}
	 
		
 
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
        ResponseUtil.writeOK(response, result);
	}
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
    	handleException(request,response,e);
    }
}
