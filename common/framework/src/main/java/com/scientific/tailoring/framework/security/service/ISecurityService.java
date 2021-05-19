package com.scientific.tailoring.framework.security.service;

import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.LoginAppVO;
import com.scientific.tailoring.domain.system.LoginConsoleVO;
import com.scientific.tailoring.framework.security.permission.SessionSubject;

public interface ISecurityService {
	/**
	 * App 登录
	 * */
	Result appLogin(LoginAppVO m);
	
	/**
	 * 控制台 登录
	 * */
	Result consoleLogin(LoginConsoleVO m);


	/**
	 * 核对Token是否有效
	 * */
	Result checkToken(String token);
	/**
	 * 登出
	 * */
	Result logout(String token);
	
	/**
	 * 获取当前登录用户
	 * */
	SessionSubject getSessionSubject();

	String getToken();

    Result changePasswd(Long userId, String oldpwd, String newpwd);

	void lifeMore();
}
