package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.hrm.EmployeePositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 *  模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:54
*/

@Controller("HrmEmployeePositionPageController")
@RequestMapping(EmployeePositionPageController.prefix)
public class EmployeePositionPageController extends ViewController {
	
	public static final String prefix="business/hrm/employee_position";

	private EmployeePositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public EmployeePositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=EmployeePositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * hrm_employee_position 功能主页面
	 */
	@RequestMapping("/employee_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/employee_position_list";
	}

	/**
	 * hrm_employee_position 表单页面
	 */
	@RequestMapping("/employee_position_form.html")
	public String form(Model model,HttpServletRequest request , Integer id) {
		return prefix+"/employee_position_form";
	}
}