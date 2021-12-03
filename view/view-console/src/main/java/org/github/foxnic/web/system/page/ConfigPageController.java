package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 15:42:25
*/

@Controller("SysConfigPageController")
@RequestMapping(ConfigPageController.prefix)
public class ConfigPageController extends ViewController {
	
	public static final String prefix="business/system/config";

	private ConfigServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ConfigServiceProxy proxy() {
		if(proxy==null) {
			proxy=ConfigServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 系统配置 功能主页面
	 */
	@RequestMapping("/config_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/config_list";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/config_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/config_form";
	}
}