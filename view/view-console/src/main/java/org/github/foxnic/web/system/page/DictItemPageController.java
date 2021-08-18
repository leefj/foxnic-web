package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据字典条目 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-18 17:28:07
*/

@Controller("SysDictItemPageController")
@RequestMapping(DictItemPageController.prefix)
public class DictItemPageController extends ViewController {
	
	public static final String prefix="business/system/dict_item";

	private DictItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DictItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=DictItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据字典条目 功能主页面
	 */
	@RequestMapping("/dict_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/dict_item_list";
	}

	/**
	 * 数据字典条目 表单页面
	 */
	@RequestMapping("/dict_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/dict_item_form";
	}
}