package org.github.foxnic.web.framework.language;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.api.swagger.SwaggerDataHandler;
import com.github.foxnic.springboot.spring.SpringUtil;

 

 
@Aspect
@Component
public class PageAspector {
	
	 
	private static final String LANG = "lang";
	

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
 
		MethodSignature ms=(MethodSignature)joinPoint.getSignature();
		Method method=ms.getMethod();
		Controller rc=method.getDeclaringClass().getAnnotation(Controller.class);
		if(rc==null) {
			return joinPoint.proceed();
		}
		
		
		if(languageService==null) {
			languageService=SpringUtil.getBean(LanguageService.class);
		}
		
		Object args[] = joinPoint.getArgs();
		for (Object arg : args) {
			if(arg instanceof Model ) {
				((Model)arg).addAttribute(LANG, languageService);
			} else if(arg instanceof ModelAndView ) {
				((ModelAndView)arg).addObject(LANG, languageService);
			} else if(arg instanceof ModelMap ) {
				((ModelMap)arg).addAttribute(LANG, languageService);
			}
		}
		 
		
		return joinPoint.proceed();
	}
 
}
