package org.github.foxnic.web.oauth.exception;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.springboot.web.WebContext;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.utils.ResponseUtil;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

		if(!isEndPoint(uri)) {

			Boolean externalPortalEnable= SystemConfigProxyUtil.getBoolean(SystemConfigEnum.SYSTEM_EXTERNAL_PORTAL_ENABLE);
			if(externalPortalEnable==null) externalPortalEnable=false;
			String loginURL=securityProperties.getLoginPage();
			String externalPortalLoginURL= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_EXTERNAL_PORTAL_LOGINURL);
			if(externalPortalEnable) {
				loginURL = externalPortalLoginURL;
			}

			//如果是静态资源，重定向到登录页
			if(context.isStaticResource(request)) {
				response.sendRedirect(loginURL);
				return;
			}

			HandlerMethod hm=context.getHandlerMethod(request);
			if(hm==null) {
				response.sendRedirect(loginURL);
				return;
			}

			//如果未返回 Result 则不是 API 接口
			if(!Result.class.isAssignableFrom(hm.getMethod().getReturnType())) {
				response.sendRedirect(loginURL);
				return;
			}

		}

		Result result;
		boolean isKnownException=true;
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
			isKnownException =false;
            Logger.error("登录失败：", e);
			result = ErrorDesc.failureMessage("登录失败 : "+e.getMessage());
        }

		if((!isKnownException && StringUtil.hasContent(e.getMessage())) || StringUtil.isBlank(result.message())) {
			result.message(e.getMessage());
		}

        ResponseUtil.writeOK(response, result);
	}

	private static boolean isEndPoint(String uri) {
		return UserServiceProxy.LOGIN_URI.equals(uri) || UserServiceProxy.LOGOUT_URI.equals(uri);
	}

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
    	handleException(request,response,e);
    }
}
