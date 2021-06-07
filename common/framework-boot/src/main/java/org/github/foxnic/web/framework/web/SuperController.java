package org.github.foxnic.web.framework.web;

import javax.servlet.http.HttpServletRequest;

import org.github.foxnic.web.framework.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.foxnic.springboot.mvc.RequestParameter;

public class SuperController {
	
	
	private SessionUser sessionUser;
 
 
	@Autowired
	protected LanguageService languageService;
 
	/**
	 * 获得当前登录的会话
	 * */
	public SessionUser getSessionUser() {
		 if(sessionUser!=null) return sessionUser;
		 sessionUser=SessionUser.getCurrent();
		 return sessionUser;
	}

	/**
	 * 获得当前登录的账户ID
	 * */
	public String getSessionUserId() {
		SessionUser user=getSessionUser();
		if(user==null) return null;
		return user.getUserId();
	}

	/**
	 * 获取请求参数
	 * */
	public RequestParameter getParameter() {
		return RequestParameter.get();
	}
	
	/**
	 * 获取请求
	 * */
	public HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attributes.getRequest();
	}

	


}
