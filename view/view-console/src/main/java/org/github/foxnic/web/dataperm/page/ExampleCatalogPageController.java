package org.github.foxnic.web.dataperm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.dataperm.ExampleCatalogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 商品分类表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-02 14:49:27
*/

@Controller("DpExampleCatalogPageController")
@RequestMapping(ExampleCatalogPageController.prefix)
public class ExampleCatalogPageController extends ViewController {
	
	public static final String prefix="business/dataperm/example_catalog";

	private ExampleCatalogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ExampleCatalogServiceProxy proxy() {
		if(proxy==null) {
			proxy=ExampleCatalogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 商品分类 功能主页面
	 */
	@RequestMapping("/example_catalog_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/example_catalog_list";
	}

	/**
	 * 商品分类 表单页面
	 */
	@RequestMapping("/example_catalog_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/example_catalog_form";
	}
}