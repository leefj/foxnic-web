package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.LangServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 语言条目表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
*/

@Controller("SysLangPageController")
@RequestMapping(LangPageController.prefix)
public class LangPageController extends ViewController {
	
	public static final String prefix="business/system/lang";

	private LangServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public LangServiceProxy proxy() {
		if(proxy==null) {
			proxy=LangServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 语言条目 功能主页面
	 */
	@RequestMapping("/lang_list.html")
	public String list(Model model) {
		return prefix+"/lang_list";
	}

	/**
	 * 语言条目 表单页面
	 */
	@RequestMapping("/lang_form.html")
	public String form(Model model , String code) {
		return prefix+"/lang_form";
	}
}