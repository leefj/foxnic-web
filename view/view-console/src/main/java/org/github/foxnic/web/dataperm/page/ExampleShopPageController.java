package org.github.foxnic.web.dataperm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.dataperm.ExampleShopServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 销售门店表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:48
*/

@Controller("DpExampleShopPageController")
@RequestMapping(ExampleShopPageController.prefix)
public class ExampleShopPageController extends ViewController {
	
	public static final String prefix="business/dataperm/example_shop";

	private ExampleShopServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ExampleShopServiceProxy proxy() {
		if(proxy==null) {
			proxy=ExampleShopServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 销售门店 功能主页面
	 */
	@RequestMapping("/example_shop_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/example_shop_list";
	}

	/**
	 * 销售门店 表单页面
	 */
	@RequestMapping("/example_shop_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/example_shop_form";
	}
}