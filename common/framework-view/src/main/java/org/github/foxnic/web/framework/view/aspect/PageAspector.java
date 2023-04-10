package org.github.foxnic.web.framework.view.aspect;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.cache.Variable;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.Theme;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.proxy.spring.AwareHandler;
import org.github.foxnic.web.proxy.utils.CodeTextEnumUtil;
import org.github.foxnic.web.proxy.utils.DictProxyUtil;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
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

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;




@Aspect
@Component
public class PageAspector {


	private static final String LANG = "lang";

	private static final String THEME = "theme";

	private static final String ENUM = "enum";

	private static final String USER = "user";

	private static final String DICT = "dict";

	private static final String PERMISSION = "perm";

	private static final String CACHE_KEY = "cacheKey";

	private static final String PAGE_HELPER = "pageHelper";

	public static final String LAYUI_TABLE_WIDTH_CONFIG="layuiTableWidthConfig";

	private CodeTextEnumUtil enumUtil;

	private DictProxyUtil dictUtil;

	private LanguageService languageService;


	private Variable theme = new Variable(null,5000);




	@PostConstruct
	private void init() {
		Logger.info("PageAspector Init");
	}

	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void pointCut4RequestMapping() {}

	@Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void pointCut4GetMapping() {}

	@Around("org.github.foxnic.web.framework.view.aspect.PageAspector.pointCut4RequestMapping()")
	public Object processRequestMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		return processControllerMethod(joinPoint, RequestMapping.class);
	}

	@Around("org.github.foxnic.web.framework.view.aspect.PageAspector.pointCut4GetMapping()")
	public Object processGetMapping(ProceedingJoinPoint joinPoint) throws Throwable {
		return processControllerMethod(joinPoint, GetMapping.class);
	}

	/**
	 * 拦截控制器方法，进行预处理
	 * */
	private Object processControllerMethod(ProceedingJoinPoint joinPoint,Class mappingType) throws Throwable {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = null;
		if(attributes!=null) {
			request = attributes.getRequest();
		}

		MethodSignature ms=(MethodSignature)joinPoint.getSignature();
		Method method=ms.getMethod();
		Controller rc=method.getDeclaringClass().getAnnotation(Controller.class);
		if(rc==null) {
			return joinPoint.proceed();
		}

		//单体应用是可以支持，后期考虑多种模式的实现
		if(languageService==null) {
			languageService= AwareHandler.getBean(LanguageService.class);
		}
		if(enumUtil==null) {
			enumUtil=AwareHandler.getBean(CodeTextEnumUtil.class);
		}
		if(dictUtil==null) {
			dictUtil=AwareHandler.getBean(DictProxyUtil.class);
		}

		//主题
		if(this.theme.getValue()==null) {
			Theme theme = SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_THEME_DEFAULT, Theme.class);
			String ico=SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_FAVICO);
			if (theme == null) theme = Theme.PEAR;
			JSONObject json=new JSONObject();
			json.put("css",theme.getCss());
			json.put("js",theme.getJs());
			if(StringUtil.isBlank(ico)) {
				ico = "favicon.ico";
			}
			json.put("ico",ico);
			this.theme.setValue(json);

		}


		//获得登录 SessionUser
		SessionUser user=SessionUser.getCurrent();

		PageHelper pageHelper=null;
		if(request!=null) {
			pageHelper=new PageHelper(request, user);
		}

		String cacheKey= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CACHEKEY);
		String userCacheKey=null;
		if(user!=null) {
			userCacheKey=user.getCacheKey();
			if (!StringUtil.isBlank(userCacheKey)) {
				cacheKey += userCacheKey;
			}
		}

		//JSONObject widthConfig = DBCacheProxyUtil.getLayUITableWidthConfig(request,user);

		Object args[] = joinPoint.getArgs();
		for (Object arg : args) {
			if(arg instanceof Model ) {
				((Model)arg).addAttribute(THEME, theme.getValue());
				((Model)arg).addAttribute(LANG, languageService);
				((Model)arg).addAttribute(ENUM, enumUtil);
				if(user!=null) {
					((Model) arg).addAttribute(USER, user);
					((Model) arg).addAttribute(PERMISSION, user.permission());
				}
				//((Model)arg).addAttribute(LAYUI_TABLE_WIDTH_CONFIG, widthConfig);
				((Model)arg).addAttribute(DICT, dictUtil);
				((Model)arg).addAttribute(CACHE_KEY, cacheKey);
				((Model)arg).addAttribute(PAGE_HELPER, pageHelper);
			} else if(arg instanceof ModelAndView ) {
				((ModelAndView)arg).addObject(THEME, theme.getValue());
				((ModelAndView)arg).addObject(LANG, languageService);
				((ModelAndView)arg).addObject(ENUM, enumUtil);
				if(user!=null) {
					((ModelAndView) arg).addObject(USER, user);
					((ModelAndView) arg).addObject(PERMISSION, user.permission());
				}
				//((ModelAndView)arg).addObject(LAYUI_TABLE_WIDTH_CONFIG, widthConfig);
				((ModelAndView)arg).addObject(DICT, dictUtil);
				((Model)arg).addAttribute(CACHE_KEY, cacheKey);
				((Model)arg).addAttribute(PAGE_HELPER, pageHelper);
			} else if(arg instanceof ModelMap ) {
				((ModelMap)arg).addAttribute(THEME, theme.getValue());
				((ModelMap)arg).addAttribute(LANG, languageService);
				((ModelMap)arg).addAttribute(ENUM, enumUtil);
				if(user!=null) {
					((ModelMap) arg).addAttribute(USER, user);
					((ModelMap) arg).addAttribute(PERMISSION, user.permission());
				}
				//((ModelMap)arg).addAttribute(LAYUI_TABLE_WIDTH_CONFIG, widthConfig);
				((ModelMap)arg).addAttribute(DICT, dictUtil);
				((Model)arg).addAttribute(CACHE_KEY, cacheKey);
				((Model)arg).addAttribute(PAGE_HELPER, pageHelper);
			}
		}

		Object result =  joinPoint.proceed();

		return result;
	}

}
