package org.github.foxnic.web.framework.view;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.proxy.spring.AwareHandler;
import org.github.foxnic.web.proxy.utils.EnumUtil;
import org.github.foxnic.web.proxy.utils.SessionUserProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.foxnic.commons.log.Logger;

 

 
@Aspect
@Component
public class PageAspector {
	
	 
	private static final String LANG = "lang";
	
	private static final String ENUM = "enum";
	
	private EnumUtil enumUtil;

	private LanguageService languageService;



	@PostConstruct
	private void init() {
		Logger.info("PageAspector Init");
	}

	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void pointCut4RequestMapping() {}
	
	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void pointCut4GetMapping() {}
 
	@Around("PageAspector.pointCut4RequestMapping()")
	public Object processRequestMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		return processControllerMethod(joinPoint,RequestMapping.class);
	}
 
	@Around("PageAspector.pointCut4GetMapping()")
	public Object processGetMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		return processControllerMethod(joinPoint,GetMapping.class);
	}

	/**
	 * 拦截控制器方法，进行预处理
	 * */
	private Object processControllerMethod(ProceedingJoinPoint joinPoint,Class mappingType) throws Throwable {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		MethodSignature ms=(MethodSignature)joinPoint.getSignature();
		Method method=ms.getMethod();
		Controller rc=method.getDeclaringClass().getAnnotation(Controller.class);
		if(rc==null) {
			return joinPoint.proceed();
		}
		
		
		if(languageService==null) {
			languageService= AwareHandler.getBean(LanguageService.class);
		}
		
		if(enumUtil==null) {
			enumUtil=AwareHandler.getBean(EnumUtil.class);
		}

//		SessionUser user=null;
//		HttpSession session=request.getSession();
//		if(session!=null) {
//			user=(SessionUser)session.getAttribute("SESSEION-USER");
//		}
//		if(user==null) {
//			SessionUserProxyUtil.getSessionUser(request);
//		}


		
		
		Object args[] = joinPoint.getArgs();
		for (Object arg : args) {
			if(arg instanceof Model ) {
				((Model)arg).addAttribute(LANG, languageService);
				((Model)arg).addAttribute(ENUM, enumUtil);
			} else if(arg instanceof ModelAndView ) {
				((ModelAndView)arg).addObject(LANG, languageService);
				((ModelAndView)arg).addObject(ENUM, enumUtil);
			} else if(arg instanceof ModelMap ) {
				((ModelMap)arg).addAttribute(LANG, languageService);
				((ModelMap)arg).addAttribute(ENUM, enumUtil);
			}
		}
		 
		
		return joinPoint.proceed();
	}
 
}
