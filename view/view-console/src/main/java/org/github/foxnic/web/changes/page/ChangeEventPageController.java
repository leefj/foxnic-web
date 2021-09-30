package org.github.foxnic.web.changes.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.changes.ChangeEventServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 变更事件表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-01 02:53:28
*/

@Controller("ChsChangeEventPageController")
@RequestMapping(ChangeEventPageController.prefix)
public class ChangeEventPageController extends ViewController {
	
	public static final String prefix="business/changes/change_event";

	private ChangeEventServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ChangeEventServiceProxy proxy() {
		if(proxy==null) {
			proxy=ChangeEventServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 变更事件 功能主页面
	 */
	@RequestMapping("/change_event_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/change_event_list";
	}

	/**
	 * 变更事件 表单页面
	 */
	@RequestMapping("/change_event_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/change_event_form";
	}
}