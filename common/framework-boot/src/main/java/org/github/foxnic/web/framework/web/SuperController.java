package org.github.foxnic.web.framework.web;

import com.github.foxnic.api.model.CompositeItem;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.springboot.mvc.Validator;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SuperController {


	/**
	 * 定义 springfox.documentation.service.ParameterType.QUERY
	 */
	public static final String PARAM_TYPE_QUERY="query";

	/**
	 * 定义 springfox.documentation.service.ParameterType.BODY
	 */
	public static final String PARAM_TYPE_BODY="body";

	/**
	 * 定义 springfox.documentation.service.ParameterType.HEADER
	 */
	public static final String PARAM_TYPE_HEADER="header";

	/**
	 * 定义 springfox.documentation.service.ParameterType.PATH
	 */
	public static final String PARAM_TYPE_PATH="path";

	/**
	 * 定义 springfox.documentation.service.ParameterType.COOKIE
	 */
	public static final String PARAM_TYPE_COOKIE="cookie";

	/**
	 * 定义 springfox.documentation.service.ParameterType.FORM
	 */
	public static final String PARAM_TYPE_FORM="form";

	/**
	 * 定义 springfox.documentation.service.ParameterType.FORMDATA
	 */
	public static final String PARAM_TYPE_FORMDATA="formData";


	private static final String REQUEST_VALIDATOR = "$REQUEST_VALIDATOR";

	//@Autowired
	//protected LanguageService languageService;

	/**
	 * 获得当前登录的会话
	 * */
	public SessionUser getSessionUser() {
		SessionUser user =  SessionUser.getCurrent();
		return user;
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
		if(attributes==null) return null;
		return attributes.getRequest();
	}

	public HttpSession getSession() {
		HttpServletRequest request = this.getRequest();
		if(request==null) return null;
		return request.getSession();
	}

	public HttpSession getSession(boolean create) {
		HttpServletRequest request = this.getRequest();
		if(request==null) return null;
		return request.getSession(create);
	}

	/**
	 * 根据权限对返回的数据进行处理
	 * */
    protected void limitForPermission(PagedList<? extends Entity> list, String perm,String... field) {
		if(perm==null) return;
		if(this.getSessionUser().permission().checkAnyAuth(perm)) return;
		for (Entity entity : list) {
			for (String f : field) {
				BeanUtil.setFieldValue(entity,f,null);
			}
		}
    }


	private static InheritableThreadLocal<Validator> VALIDATOR = new InheritableThreadLocal();
	/**
	 * 获得参数验证器，在 request 生命周期内返回同一个验证器
	 * */
	public Validator validator() {
		Validator validator = null;
		HttpServletRequest request = getRequest();
		if(request==null) {
			validator = VALIDATOR.get();
			if (validator == null) {
				validator = new Validator();
				VALIDATOR.set(validator);
			}
		} else {
			validator = (Validator) request.getAttribute(REQUEST_VALIDATOR);
			if (validator == null) {
				validator = new Validator();
				request.setAttribute(REQUEST_VALIDATOR, validator);
			}
		}
		return validator;
	}

	/**
	 * 从 VO 提取属性值
	 * */
	public <T,V> V getPropertyValue(T vo,String prop,Class<V> type) {
		Object value= BeanUtil.getFieldValue(vo,prop);
		if(vo instanceof Entity) {
			Entity entity = (Entity) vo;
			CompositeItem drafterNameItem = entity.getCompositeParameter().getItem(prop);
			if (StringUtil.isBlank(value) && drafterNameItem != null) {
				value = drafterNameItem.getValue();
			}
		}
		return DataParser.parse(type,value);
	}

	/**
	 * 设置 VO 的属性值
	 * */
	public <T> void setPropertyValue(T vo,String prop,Object value) {
		// 提取 drafterName 并是参数置空以取消底层的查询
		BeanUtil.setFieldValue(vo,prop,value);
		if(vo instanceof Entity) {
			Entity entity = (Entity) vo;
			CompositeItem drafterNameItem = entity.getCompositeParameter().getItem(prop);
			if (drafterNameItem != null) {
				drafterNameItem.setValue(value);
			}
		}
	}

}
