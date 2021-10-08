package org.github.foxnic.web.bpm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.bpm.RoleEmployeeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 流程角色员工关系表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-08 17:28:36
*/

@Controller("BpmRoleEmployeePageController")
@RequestMapping(RoleEmployeePageController.prefix)
public class RoleEmployeePageController extends ViewController {
	
	public static final String prefix="business/bpm/role_employee";

	private RoleEmployeeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RoleEmployeeServiceProxy proxy() {
		if(proxy==null) {
			proxy=RoleEmployeeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 流程角色员工关系 功能主页面
	 */
	@RequestMapping("/role_employee_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/role_employee_list";
	}

	/**
	 * 流程角色员工关系 表单页面
	 */
	@RequestMapping("/role_employee_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/role_employee_form";
	}
}