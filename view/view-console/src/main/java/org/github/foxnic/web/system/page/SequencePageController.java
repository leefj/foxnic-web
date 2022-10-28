package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.SequenceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 序列模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:51
*/

@Controller("SysSequencePageController")
@RequestMapping(SequencePageController.prefix)
public class SequencePageController extends ViewController {
	
	public static final String prefix="business/system/sequence";

	private SequenceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SequenceServiceProxy proxy() {
		if(proxy==null) {
			proxy=SequenceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 序列 功能主页面
	 */
	@RequestMapping("/sequence_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/sequence_list";
	}

	/**
	 * 序列 表单页面
	 */
	@RequestMapping("/sequence_form.html")
	public String form(Model model,HttpServletRequest request , String pk) {
		return prefix+"/sequence_form";
	}
}