package org.github.foxnic.web.pcm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.pcm.CatalogAttributeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据存储分配表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-30 16:49:46
*/

@Controller("PcmCatalogAttributePageController")
@RequestMapping(CatalogAttributePageController.prefix)
public class CatalogAttributePageController extends ViewController {
	
	public static final String prefix="business/pcm/catalog_attribute";

	private CatalogAttributeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CatalogAttributeServiceProxy proxy() {
		if(proxy==null) {
			proxy=CatalogAttributeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据存储分配 功能主页面
	 */
	@RequestMapping("/catalog_attribute_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/catalog_attribute_list";
	}

	/**
	 * 数据存储分配 表单页面
	 */
	@RequestMapping("/catalog_attribute_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/catalog_attribute_form";
	}
}