package org.github.foxnic.web.framework.web;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.springboot.mvc.RequestParameter;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SuperController {


	public static final String REQUEST_VALIDATOR = "$REQUEST_VALIDATOR";
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

    protected void limitForPermission(PagedList<? extends Entity> list, String perm,String... field) {
		if(perm==null) return;
		if(this.getSessionUser().permission().checkAnyAuth(perm)) return;
		for (Entity entity : list) {
			for (String f : field) {
				BeanUtil.setFieldValue(entity,f,null);
			}

		}
    }

	@Autowired
	private Validator validator;

	/**
	 * 获得参数验证器，在 request 生命周期内返回同一个验证器
	 * */
	public Validator validator() {
		return validator;
	}

}
