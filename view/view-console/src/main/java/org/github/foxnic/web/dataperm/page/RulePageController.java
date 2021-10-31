package org.github.foxnic.web.dataperm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.dataperm.RuleServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据权限规则表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-30 10:29:41
*/

@Controller("DpRulePageController")
@RequestMapping(RulePageController.prefix)
public class RulePageController extends ViewController {
	
	public static final String prefix="business/dataperm/rule";

	private RuleServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RuleServiceProxy proxy() {
		if(proxy==null) {
			proxy=RuleServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据权限规则 功能主页面
	 */
	@RequestMapping("/rule_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/rule_list";
	}

	/**
	 * 数据权限规则 表单页面
	 */
	@RequestMapping("/rule_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/rule_form";
	}
}