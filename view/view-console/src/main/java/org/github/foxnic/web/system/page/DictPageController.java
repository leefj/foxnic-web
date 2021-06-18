package org.github.foxnic.web.system.page;

import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.proxy.utils.DBCacheProxyUtil;
import org.github.foxnic.web.proxy.utils.SessionUserProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.DictServiceProxy;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 数据字典 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 16:41:53
*/

@Controller("SysDictPageController")
@RequestMapping(DictPageController.prefix)
public class DictPageController {
	
	public static final String prefix="business/system/dict";

	private DictServiceProxy proxy;

	private SessionUser user;
	
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
	public String list(Model model, HttpServletRequest request)
	{

		//String uri=request.getRequestURI();
		//List<DbCache> layuiTableWidth= DBCacheProxyUtil.getByCatalogAndGroup("layui-table",uri);
		//model.addAttribute("layuiTableWidth",layuiTableWidth);
		return prefix+"/dict_list";
	}

	/**
	 * 数据字典 表单页面
	 */
	@RequestMapping("/dict_form.html")
	public String form(Model model , String id) {
		return prefix+"/dict_form";
	}
}