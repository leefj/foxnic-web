package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.ProfileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * Profile 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-19 15:13:05
*/

@Controller("SysProfilePageController")
@RequestMapping(ProfilePageController.prefix)
public class ProfilePageController extends ViewController {
	
	public static final String prefix="business/system/profile";

	private ProfileServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ProfileServiceProxy proxy() {
		if(proxy==null) {
			proxy=ProfileServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * Profile 功能主页面
	 */
	@RequestMapping("/profile_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/profile_list";
	}

	/**
	 * Profile 表单页面
	 */
	@RequestMapping("/profile_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/profile_form";
	}
}