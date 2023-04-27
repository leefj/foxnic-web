package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.DictServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据字典模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-27 09:39:13
*/

@Controller("SysDictPageController")
@RequestMapping(DictPageController.prefix)
public class DictPageController extends ViewController {

	public static final String prefix="business/system/dict";

	private DictServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DictServiceProxy proxy() {
		if(proxy==null) {
			proxy=DictServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 数据字典 功能主页面
	 */
	@RequestMapping("/dict_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"dict_list");
	}

	/**
	 * 数据字典 表单页面
	 */
	@RequestMapping("/dict_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"dict_form");
	}
}