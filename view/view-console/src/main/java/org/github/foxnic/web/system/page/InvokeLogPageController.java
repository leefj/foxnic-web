package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.InvokeLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 调用统计日志 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-19 14:42:57
*/

@Controller("SysInvokeLogPageController")
@RequestMapping(InvokeLogPageController.prefix)
public class InvokeLogPageController extends ViewController {
	
	public static final String prefix="business/system/invoke_log";

	private InvokeLogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InvokeLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=InvokeLogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 调用统计日志 功能主页面
	 */
	@RequestMapping("/invoke_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/invoke_log_list";
	}

	/**
	 * 调用统计日志 表单页面
	 */
	@RequestMapping("/invoke_log_form.html")
	public String form(Model model,HttpServletRequest request , Long id) {
		return prefix+"/invoke_log_form";
	}
}