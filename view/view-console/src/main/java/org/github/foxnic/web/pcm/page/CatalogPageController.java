package org.github.foxnic.web.pcm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据存储表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-30 16:49:46
 * @version
*/

@Controller("PcmCatalogPageController")
@RequestMapping(CatalogPageController.prefix)
public class CatalogPageController extends ViewController {
	
	public static final String prefix="business/pcm/catalog";

	private CatalogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CatalogServiceProxy proxy() {
		if(proxy==null) {
			proxy=CatalogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据存储 功能主页面
	 */
	@RequestMapping("/catalog_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/catalog_list";
	}

	/**
	 * 数据存储 表单页面
	 */
	@RequestMapping("/catalog_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		model.addAttribute("storageTables",CatalogServiceProxy.api().storageTables().data());
		return prefix+"/catalog_form";
	}
}