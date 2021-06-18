package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.DbCacheServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 数据库缓存表，内存表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-18 13:15:22
*/

@Controller("SysDbCachePageController")
@RequestMapping(DbCachePageController.prefix)
public class DbCachePageController extends ViewController {
	
	public static final String prefix="business/system/db_cache";

	private DbCacheServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DbCacheServiceProxy proxy() {
		if(proxy==null) {
			proxy=DbCacheServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据库缓存 功能主页面
	 */
	@RequestMapping("/db_cache_list.html")
	public String list(Model model) {
		return prefix+"/db_cache_list";
	}

	/**
	 * 数据库缓存 表单页面
	 */
	@RequestMapping("/db_cache_form.html")
	public String form(Model model , String id) {
		return prefix+"/db_cache_form";
	}
}