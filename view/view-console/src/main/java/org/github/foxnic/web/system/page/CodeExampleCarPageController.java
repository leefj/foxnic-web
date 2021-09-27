package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.CodeExampleCarServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 代码生成拥有的车辆 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-27 13:58:09
*/

@Controller("SysCodeExampleCarPageController")
@RequestMapping(CodeExampleCarPageController.prefix)
public class CodeExampleCarPageController extends ViewController {
	
	public static final String prefix="business/system/code_example_car";

	private CodeExampleCarServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeExampleCarServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeExampleCarServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 代码生成拥有的车辆 功能主页面
	 */
	@RequestMapping("/code_example_car_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_example_car_list";
	}

	/**
	 * 代码生成拥有的车辆 表单页面
	 */
	@RequestMapping("/code_example_car_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_example_car_form";
	}
}