package org.github.foxnic.web.oauth.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.oauth.MenuForkServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 菜单功能分版本实现配置模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-02-06 15:12:53
*/

@Controller("SysMenuForkPageController")
@RequestMapping(MenuForkPageController.prefix)
public class MenuForkPageController extends ViewController {

	public static final String prefix="business/oauth/menu_fork";

	private MenuForkServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public MenuForkServiceProxy proxy() {
		if(proxy==null) {
			proxy=MenuForkServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 菜单功能分版本实现配置 功能主页面
	 */
	@RequestMapping("/menu_fork_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"menu_fork_list");
	}

	/**
	 * 菜单功能分版本实现配置 表单页面
	 */
	@RequestMapping("/menu_fork_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"menu_fork_form");
	}
}