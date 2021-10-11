package org.github.foxnic.web.changes.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 变更实例表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-11 15:25:41
*/

@Controller("ChsChangeInstancePageController")
@RequestMapping(ChangeInstancePageController.prefix)
public class ChangeInstancePageController extends ViewController {
	
	public static final String prefix="business/changes/change_instance";

	private ChangeInstanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ChangeInstanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=ChangeInstanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 变更实例 功能主页面
	 */
	@RequestMapping("/change_instance_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/change_instance_list";
	}

	/**
	 * 变更实例 表单页面
	 */
	@RequestMapping("/change_instance_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/change_instance_form";
	}
}