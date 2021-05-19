package com.scientific.tailoring.framework.security.permission;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.scientific.tailoring.framework.security.service.ISecurityService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.api.swagger.SwaggerDataHandler;
import com.github.foxnic.springboot.api.validator.ParameterValidateManager;

 

 
@Aspect
@Component
public class PermissionAspector {


	private ISecurityService securityService;
 
	@PostConstruct
	private void init() {
		Logger.info("PermissionAspector Init");
	}

	@Pointcut(value = "@annotation(com.scientific.tailoring.framework.security.permission.RequiresPermissions)")
	public void pointCut4RequestMapping() {}
	
 
	@Around("PermissionAspector.pointCut4RequestMapping()")
	public Object processRequestMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		return processControllerMethod(joinPoint);
	}
 
	/**
	 * 拦截控制器方法，进行预处理
	 * */
	private Object processControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		MethodSignature ms=(MethodSignature)joinPoint.getSignature();
		Method method=ms.getMethod();
		Controller rc=method.getDeclaringClass().getAnnotation(Controller.class);
		
		if(securityService==null) {
			securityService= SpringUtil.getBean(ISecurityService.class);
		}
		SessionSubject subject = securityService.getSessionSubject();
		Object ret=null;
		//未登录
		if(subject==null) {
			
			if(method.getReturnType().equals(Result.class)) {
				return ErrorDesc.failure(CommonError.SESSION_INVALID);
			}  
		}
	 

		ret=joinPoint.proceed();


		return ret;
		 
	}
 
}
