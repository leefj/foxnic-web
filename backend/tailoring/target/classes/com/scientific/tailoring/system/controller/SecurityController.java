package com.scientific.tailoring.system.controller;

import java.util.HashMap;
import java.util.Map;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.scientific.tailoring.domain.system.meta.LoginAppVOMeta;
import com.scientific.tailoring.domain.system.meta.LoginConsoleVOMeta;
import com.scientific.tailoring.domain.system.meta.UserMeta;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.foxnic.springboot.api.annotations.NotNull;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.scientific.tailoring.domain.system.LoginAppVO;
import com.scientific.tailoring.domain.system.LoginConsoleVO;
import com.scientific.tailoring.framework.security.permission.SessionSubject;
import com.scientific.tailoring.framework.security.service.ISecurityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "账户安全接口")
@ApiSort(2)
@RestController("SecurityController")
@RequestMapping("/security/user")
public class SecurityController {

	@Autowired
	private ISecurityService securityService;


	/**
	 * App端登录
	*/
	@ApiOperation(value = "App端登录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LoginAppVOMeta.IDENTITY , value = "身份标识，帐号或手机号码" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = LoginAppVOMeta.PASSWD , value = "密码" , required = true , dataTypeClass=String.class),

	})
	@NotNull(name = LoginAppVOMeta.IDENTITY)
	@NotNull(name = LoginAppVOMeta.PASSWD)
	@PostMapping("app-login")
	@ApiOperationSupport(order=2)
	public  Result appLogin(LoginAppVO m) {
		Result<SessionSubject> loginResult=securityService.appLogin(m);
		if(loginResult.failure()) {
			return loginResult;
		}
		return makeLoginResult(loginResult.data());
	}
	
	
	
	/**
	 * App端登录
	*/
	@ApiOperation(value = "PC端登录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LoginConsoleVOMeta.IDENTITY , value = "身份标识，帐号或手机号码" , required = true , dataTypeClass=Long.class),
		@ApiImplicitParam(name = LoginConsoleVOMeta.PASSWD , value = "密码" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LoginConsoleVOMeta.DEVICE_ID , value = "设备ID，客户端唯一ID" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LoginConsoleVOMeta.CODE , value = "验证码，由用户输入" , required = true , dataTypeClass=String.class),
 
	})
	@NotNull(name = LoginConsoleVOMeta.IDENTITY)
	@NotNull(name = LoginConsoleVOMeta.PASSWD)
	@NotNull(name = LoginConsoleVOMeta.DEVICE_ID)
	@NotNull(name = LoginConsoleVOMeta.CODE)
	@PostMapping("console-login")
	@ApiOperationSupport(order=1)
	public  Result consoleLogin(LoginConsoleVO m) {
		Result<SessionSubject> loginResult=securityService.consoleLogin(m); 
		if(loginResult.failure()) {
			return loginResult;
		}
		return makeLoginResult(loginResult.data());
	}
	
	
	/**
	 * 登出
	*/
	@ApiOperation(value = "登出")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token" , value = "token值" , required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "token")
	@PostMapping("logout")
	@ApiOperationSupport(order=4)
	public  Result logout(String token) {
		return securityService.logout(token);
	}

	/**
	 * 校验Token
	 */
	@ApiOperation(value = "校验Token")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token" , value = "token值" , required = true, dataTypeClass=String.class),
	})
	@NotNull(name = "token")
	@PostMapping("check-token")
	@ApiOperationSupport(order=4)
	public  Result checkToken(String token) {
		return securityService.checkToken(token);
	}
	
	/**
	 * App端登录
	*/
	@RequiresPermissions
	@ApiOperation(value = "获得当前登录用户信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token" , value = "token值" , paramType="header",required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "token")
	@PostMapping("current-user")
	@ApiOperationSupport(order=3)
	public  Result<SessionSubject> getCurrentUser(String token) {
		SessionSubject sessionSubject=securityService.getSessionSubject();
		Result<SessionSubject> ru=new Result<>();
		if(sessionSubject==null) {
			return ErrorDesc.failure(CommonError.TOKEN_INVALID);
		} else {
			return ErrorDesc.success(ru).data(sessionSubject);
		}
	}
	
	
	private Result makeLoginResult(SessionSubject sessionUser) {
		Map<String,Object> info=new HashMap<>();
		info.put("user", sessionUser.getUser());
		info.put("token", sessionUser.getToken());
		return ErrorDesc.success().data(info);
	}


	/**
	 * App端登录
	 */
	@RequiresPermissions
	@ApiOperation(value = "获得当前登录用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "oldpwd" , value = "原始密码" ,required = true , dataTypeClass=String.class),
			@ApiImplicitParam(name = "newpwd" , value = "新密码" ,required = true , dataTypeClass=String.class),
	})
	@NotNull(name = "oldpwd")
	@NotNull(name = "newpwd")
	@PostMapping("change-passwd")
	@ApiOperationSupport(order=4)
	public  Result changePasswd(String oldpwd,String newpwd) {
		SessionSubject sessionSubject=securityService.getSessionSubject();
		return securityService.changePasswd(sessionSubject.getUserId(),oldpwd,newpwd);
	}
 
}
