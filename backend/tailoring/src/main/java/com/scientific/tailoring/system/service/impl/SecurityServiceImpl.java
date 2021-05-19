package com.scientific.tailoring.system.service.impl;

import java.util.Date;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.scientific.tailoring.crm.service.IDepartmentService;
import com.scientific.tailoring.crm.service.IEmployeeService;
import com.scientific.tailoring.domain.crm.Department;
import com.scientific.tailoring.domain.crm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.cache.LocalCache;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.crm.service.ICompanyService;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.system.LoginAppVO;
import com.scientific.tailoring.domain.system.LoginConsoleVO;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.framework.security.permission.SessionSubject;
import com.scientific.tailoring.framework.security.service.ISecurityService;
import com.scientific.tailoring.framework.security.service.IValidateCodeService;
import com.scientific.tailoring.system.service.IUserService;

@Service
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICompanyService companyService;

	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IValidateCodeService  validateCodeService;
 
	/**
	 * 会话缓存
	 * */
	private LocalCache<String, SessionSubject> SESSION_CACHE=new LocalCache<>(1000 * 60 * 60);
 
	/**
	 * 获取当前登录用户
	 * */
	public SessionSubject getSessionSubject() {
		return SESSION_CACHE.get(getToken());
	}

	/***
	 * 从请求中获得Token值
	 * */
	@Override
	public String getToken() {
		RequestParameter requestParameter=RequestParameter.get();
		if(requestParameter==null || requestParameter.getHeader()==null) return null;
		return requestParameter.getHeader().get("token");
	}

	@Override
	public Result changePasswd(Long userId, String oldpwd, String newpwd) {
		User user=userService.getById(userId,true);
		if(!user.getPassword().equals(oldpwd)) {
			return ErrorDesc.failure(CommonError.PASSWORD_INVALID).message("原始密码错误");
		}
		if(newpwd.length()<6) {
			return ErrorDesc.failure(CommonError.PASSWORD_INVALID).message("新密码长度不足");
		}


		user.setPassword(newpwd);
		userService.update(user,SaveMode.DIRTY_FIELDS);
		return ErrorDesc.success();
	}

	/**
	 * app 登录
	 * */
	@Override
	public Result<SessionSubject> appLogin(LoginAppVO m) {
		//认证
		Result<SessionSubject> r=this.doAuthentication(m.getIdentity(),m.getPasswd());
		if(!r.success()) {
			return r;
		}
		//授权
		this.doAuthorization(r.data());
		return r;
	}

	/**
	 * PC 端登录
	 * */
	@Override
	public Result<SessionSubject> consoleLogin(LoginConsoleVO m) {
		
		Result<SessionSubject> r=new Result<>();
		String code=validateCodeService.getValidateCode(m.getDeviceId());
		if(code==null) {
			return ErrorDesc.failure(CommonError.CAPTCHA_EXPIRED);
		} else {
			if(!code.equalsIgnoreCase(m.getCode())) {
				return ErrorDesc.failure(CommonError.CAPTCHA_NOT_MATCH);
			}
		}
		//认证
		r=this.doAuthentication(m.getIdentity(), m.getPasswd());
		if(!r.success()) {
			return r;
		}
		//授权
		this.doAuthorization(r.data());
		return r;
	}

	@Override
	public Result checkToken(String token) {
		if(StringUtil.isBlank(token)) return ErrorDesc.failure(CommonError.TOKEN_INVALID);
		SessionSubject subject=SESSION_CACHE.get(token);
		if(subject==null) {
			return ErrorDesc.failure(CommonError.TOKEN_INVALID);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result logout(String token) {
		if(StringUtil.isBlank(token)) return ErrorDesc.success();
		SESSION_CACHE.remove(token);
		return ErrorDesc.success();
	}
	
	/**
	 * 身份认证
	 * */
	private Result<SessionSubject> doAuthentication(String identity, String passwd) {
		User sample=new User();
		sample.setAccount(identity);
		sample.setPassword(passwd);
		User user=userService.queryEntity(sample);
		if(user==null) {
			sample.setAccount(null);
			sample.setMobile(identity);
			user=userService.queryEntity(sample);
		}
 
		Result<SessionSubject> r=new Result<>();
		if(user==null) {
			return ErrorDesc.failure(CommonError.NAME_PWD_WRONG);
		}
		if(!user.isValid()) {
			return ErrorDesc.failure(CommonError.USER_BLOCKED);
		}

		//查询员工信息
		Employee employee=employeeService.queryEntity(Employee.create().setUserId(user.getId()));

		//获取部门信息
		Department department=null;
		if(employee!=null && employee.getDepartmentId()!=null) {
			department=departmentService.getById(employee.getDepartmentId());
		}

 		//获取公司信息
		Company company=null;
		//查询公司
		if(employee!=null && employee.getCompanyId()!=null) {
			company=companyService.getById(employee.getCompanyId());
		}

		//生成会话
		String token=IDGenerator.getSUID(false);
		SessionSubject sessionUser=new SessionSubject(token,user,company,department,employee);
		r.data(sessionUser).success(true);
		
		SESSION_CACHE.put(token, sessionUser);
		RequestParameter.get().getHeader().put("token", token);
		user.setLatestLoginTime(new Date());
		userService.update(user, SaveMode.DIRTY_FIELDS);
		
		user.setPassword("******");
		user.setDeleted(null);
		
		return r;
	}
	
	/**
	 * 授权
	 * */
	private SessionSubject doAuthorization(SessionSubject sessionUser) {
		return sessionUser;
	}

	@Override
	public void lifeMore() {

		SessionSubject sessionUser=this.getSessionSubject();
		if(sessionUser!=null) {
			SESSION_CACHE.put(this.getToken(), sessionUser);
		}
		
	}
	

}
