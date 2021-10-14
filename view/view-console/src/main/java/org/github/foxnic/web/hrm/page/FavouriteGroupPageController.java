package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.hrm.FavouriteGroupServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 常用人员分组表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 15:44:30
*/

@Controller("HrmFavouriteGroupPageController")
@RequestMapping(FavouriteGroupPageController.prefix)
public class FavouriteGroupPageController extends ViewController {
	
	public static final String prefix="business/hrm/favourite_group";

	private FavouriteGroupServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public FavouriteGroupServiceProxy proxy() {
		if(proxy==null) {
			proxy=FavouriteGroupServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 常用人员分组 功能主页面
	 */
	@RequestMapping("/favourite_group_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/favourite_group_list";
	}

	/**
	 * 常用人员分组 表单页面
	 */
	@RequestMapping("/favourite_group_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/favourite_group_form";
	}
}