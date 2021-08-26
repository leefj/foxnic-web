package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.UserTenantServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 账户租户关系表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 15:35:43
*/

@Controller("SysUserTenantPageController")
@RequestMapping(UserTenantPageController.prefix)
public class UserTenantPageController extends ViewController {
	
	public static final String prefix="business/system/user_tenant";

	private UserTenantServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public UserTenantServiceProxy proxy() {
		if(proxy==null) {
			proxy=UserTenantServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 账户租户关系 功能主页面
	 */
	@RequestMapping("/user_tenant_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/user_tenant_list";
	}

	/**
	 * 账户租户关系 表单页面
	 */
	@RequestMapping("/user_tenant_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/user_tenant_form";
	}
}