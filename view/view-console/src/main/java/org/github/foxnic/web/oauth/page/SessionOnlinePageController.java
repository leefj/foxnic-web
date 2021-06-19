package org.github.foxnic.web.oauth.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.oauth.SessionOnlineServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 在线会话表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 08:02:07
*/

@Controller("SysSessionOnlinePageController")
@RequestMapping(SessionOnlinePageController.prefix)
public class SessionOnlinePageController extends ViewController {
	
	public static final String prefix="business/oauth/session_online";

	private SessionOnlineServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SessionOnlineServiceProxy proxy() {
		if(proxy==null) {
			proxy=SessionOnlineServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 在线会话 功能主页面
	 */
	@RequestMapping("/session_online_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/session_online_list";
	}

	/**
	 * 在线会话 表单页面
	 */
	@RequestMapping("/session_online_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/session_online_form";
	}
}