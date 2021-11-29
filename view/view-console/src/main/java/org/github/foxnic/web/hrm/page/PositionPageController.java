package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.hrm.PositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 岗位表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:58
*/

@Controller("HrmPositionPageController")
@RequestMapping(PositionPageController.prefix)
public class PositionPageController extends ViewController {
	
	public static final String prefix="business/hrm/position";

	private PositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=PositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 岗位 功能主页面
	 */
	@RequestMapping("/position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/position_list";
	}

	/**
	 * 岗位 表单页面
	 */
	@RequestMapping("/position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/position_form";
	}
}