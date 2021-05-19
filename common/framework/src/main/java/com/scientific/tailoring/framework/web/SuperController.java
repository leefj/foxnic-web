package com.scientific.tailoring.framework.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.foxnic.springboot.mvc.RequestParameter;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.framework.language.LanguageService;
import com.scientific.tailoring.framework.security.permission.SessionSubject;
import com.scientific.tailoring.framework.security.service.ISecurityService;

public class SuperController {

	@Autowired
	private ISecurityService securityService;
	
	@Autowired
	protected LanguageService languageService;
 
	/**
	 * 获得当前登录的会话
	 * */
	public SessionSubject getSessionSubject() {
		return securityService.getSessionSubject();
	}

	/**
	 * 获得当前登录的账户ID
	 * */
	public Long getSessionUserId() {
		return getSessionSubject().getUser().getId();
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
