package org.github.foxnic.web.framework.web;

import java.lang.reflect.Method;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.ReflectUtil;

public abstract class SessionUser {
	
	private static String SECURITY_CONTEXTHOLDER_CLASS_NAME="org.springframework.security.core.context.SecurityContextHolder";
	
	private static Class SECURITY_CONTEXTHOLDER_CLASS=null;
	
	public SessionUser() {
		SECURITY_CONTEXTHOLDER_CLASS=ReflectUtil.forName(SECURITY_CONTEXTHOLDER_CLASS_NAME);
	}
	
	/**
	 * 账户
	 * */
	public abstract String getUsername();
	
	/**
	 * 账户ID
	 * */
	public abstract String getUserId();
	
	/**
	 * 权限对象
	 * */
	public abstract SessionPermission permission();
	
	
	
	
	/**
	 * 获得当前登录的账户
	 * */
	public static SessionUser getCurrent() {
		 
		if(SECURITY_CONTEXTHOLDER_CLASS==null) return null;
		
		Object context = getOnMethod(SECURITY_CONTEXTHOLDER_CLASS,"getContext");
		if(context==null) return null;
		
		Object authentication=getOnMethod(context, "getAuthentication");
		if(authentication==null) return null;
 
	    Boolean isAuthenticated= (Boolean)BeanUtil.getFieldValue(authentication, "authenticated");
	    if(isAuthenticated==null || !isAuthenticated) return null;
 
        Object principal = getOnMethod(authentication, "getPrincipal");
        
        if(principal==null || !(principal instanceof SessionUser)) {
        	return null;
        }
        SessionUser userDetail=(SessionUser)principal;
        return userDetail;
	}
 
	private static Object getOnMethod(Object target, String methodName) {
		Method method=null;
		Object value=null;
		try {
			if(target instanceof Class) {
				method=((Class)target).getDeclaredMethod(methodName, null);
				if(method==null) return null;
				value=method.invoke(null);
			} else {
				method=target.getClass().getDeclaredMethod(methodName, null);
				if(method==null) return null;
				value=method.invoke(target);
			}
		} catch (Exception e) {
			Logger.error(e);
		}
		return value;
	}
	
}
