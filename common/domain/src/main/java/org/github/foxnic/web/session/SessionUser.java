package org.github.foxnic.web.session;

import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.UserTenant;

public abstract class SessionUser {


	public static final String USER_LOGIN_JSON = "USER_LOGIN_JSON";
	public SessionUser() {
	}

	/**
	 * 账户名
	 * */
	public abstract String getUsername();

	/**
	 * 真实姓名
	 * */
	public abstract String getRealName();

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
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		return tenant.getOwnerTenantId();
	}

	/**
	 * 获得当前激活租户对应公司的ID
	 * */
	public String getActivatedCompanyId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant userTenant=this.getUser().getActivatedTenant();
		if(userTenant==null) return null;
		Tenant tenant=userTenant.getTenant();
		if(tenant==null) return null;
		return tenant.getCompanyId();
	}

	/**
	 * 获得当前激活租户对应员工的ID
	 * */
	public String getActivatedEmployeeId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		return tenant.getEmployeeId();
	}

	/**
	 * 获得当前激活租户对应所在公司的岗位ID
	 * */
	public String getPrimaryPositionId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		Employee employee=tenant.getEmployee();
		if(employee==null) return null;
		Position position=employee.getPrimaryPosition();
		if(position==null) return null;
		return position.getId();
	}

	/**
	 * 获得当前激活租户对应所在公司
	 * */
	public Organization getPrimaryOrganization(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		Employee employee=tenant.getEmployee();
		if(employee==null) return null;
		return employee.getPrimaryOrganization();
	}

	/**
	 * 获得当前激活租户对应所在公司的组织ID
	 * */
	public String getPrimaryOrganizationId(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		Employee employee=tenant.getEmployee();
		if(employee==null) return null;
		Organization organization=employee.getPrimaryOrganization();
		if(organization==null) return null;
		return organization.getId();
	}

	/**
	 * 获得当前激活租户对应所在公司的组织层级代码
	 * */
	public String getPrimaryOrganizationHierarchy(){
		//此处这样写的原因是，这个配置是一定存在的，如果因为不存在而发生异常，一定是配置错误了，即使这里不报错，其它地方也要报错的
		UserTenant tenant=this.getUser().getActivatedTenant();
		if(tenant==null) return null;
		Employee employee=tenant.getEmployee();
		if(employee==null) return null;
		Organization organization=employee.getPrimaryOrganization();
		if(organization==null) return null;
		return organization.getHierarchy();
	}

	/**
	 * 权限对象
	 * */
	public abstract SessionPermission permission();

	public abstract String getSessionOnlineId();

	/**
	 * 获得用户前端缓存键
	 * */
    public abstract String getCacheKey();


    public static interface GetInService {
		SessionUser get();
	}

	public static interface GetInView {
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
