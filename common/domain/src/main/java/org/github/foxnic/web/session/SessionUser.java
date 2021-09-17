package org.github.foxnic.web.session;

import org.github.foxnic.web.domain.oauth.User;

public abstract class SessionUser {
	
//	private static String SECURITY_CONTEXTHOLDER_CLASS_NAME="org.springframework.security.core.context.SecurityContextHolder";
	
//	private static Class SECURITY_CONTEXTHOLDER_CLASS=null;
	
	public SessionUser() {
//		SECURITY_CONTEXTHOLDER_CLASS=ReflectUtil.forName(SECURITY_CONTEXTHOLDER_CLASS_NAME);
	}
	
	/**
	 * 账户名
	 * */
	public abstract String getUsername();

	/**
	 * 账户对象
	 * */
	public abstract User getUser();
	
	/**
	 * 语言
	 * */
	public abstract String getLanguage();
	
	/**
	 * 账户ID
	 * */
	public abstract String getUserId();

	/**
	 * 获得当前激活租户的ID
	 * */
	public String getActivatedTenantId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		return this.getUser().getActivatedTenant().getOwnerTenantId();
	}

	/**
	 * 获得当前激活租户对应公司的ID
	 * */
	public String getActivatedCompanyId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		return this.getUser().getActivatedTenant().getTenant().getCompanyId();
	}

	/**
	 * 获得当前激活租户对应所在公司的岗位ID
	 * */
	public String getPrimaryPositionId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		return this.getUser().getActivatedTenant().getEmployee().getPrimaryPosition().getId();
	}

	/**
	 * 获得当前激活租户对应所在公司的组织ID
	 * */
	public String getPrimaryOrganizationId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		return this.getUser().getActivatedTenant().getEmployee().getPrimaryOrganization().getId();
	}
	
	/**
	 * 权限对象
	 * */
	public abstract SessionPermission permission();

	public abstract String getSessionOnlineId();

    public abstract String getCacheKey();


    public static interface GetInService {
		SessionUser get();
	}

	public static interface GetInView{
		SessionUser get();
	}

	private static GetInService getInService;
	private static GetInView getInView;

	public static void configGetInService(GetInService gs){
		getInService=gs;
	}
	public static void configGetInView(GetInView gv){
		getInView=gv;
	}
	
	/**
	 * 获得当前登录的账户
	 * */
	public static SessionUser getCurrent() {
		SessionUser user=null;
		if(getInService!=null) {
			user=getInService.get();
		}
		if(user==null && getInView!=null) {
			user=getInView.get();
		}
		return user;
	}

//	private static SessionUser getInService() {
//
//		if(SECURITY_CONTEXTHOLDER_CLASS==null) return null;
//
//		Object context = getOnMethod(SECURITY_CONTEXTHOLDER_CLASS,"getContext");
//		if(context==null) return null;
//
//		Object authentication=getOnMethod(context, "getAuthentication");
//		if(authentication==null) return null;
//
//		Boolean isAuthenticated= (Boolean)BeanUtil.getFieldValue(authentication, "authenticated");
//		if(isAuthenticated==null || !isAuthenticated) return null;
//
//		Object principal = getOnMethod(authentication, "getPrincipal");
//
//		if(principal==null || !(principal instanceof SessionUser)) {
//			return null;
//		}
//		SessionUser userDetail=(SessionUser)principal;
//		return userDetail;
//
//	}

//	private static Object getOnMethod(Object target, String methodName) {
//		Method method=null;
//		Object value=null;
//		try {
//			if(target instanceof Class) {
//				method=((Class)target).getDeclaredMethod(methodName, null);
//				if(method==null) return null;
//				value=method.invoke(null);
//			} else {
//				method=target.getClass().getDeclaredMethod(methodName, null);
//				if(method==null) return null;
//				value=method.invoke(target);
//			}
//		} catch (Exception e) {
//			Logger.error(e);
//		}
//		return value;
//	}
	
}
