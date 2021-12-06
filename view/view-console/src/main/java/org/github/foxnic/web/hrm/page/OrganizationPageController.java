package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 组织层级表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:26
*/

@Controller("HrmOrganizationPageController")
@RequestMapping(OrganizationPageController.prefix)
public class OrganizationPageController extends ViewController {

	public static final String prefix="business/hrm/organization";

	private OrganizationServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public OrganizationServiceProxy proxy() {
		if(proxy==null) {
			proxy=OrganizationServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 组织层级 功能主页面
	 */
	@RequestMapping("/organization_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/organization_list";
	}

	/**
	 * 组织层级 功能主页面
	 */
	@RequestMapping("/org_tree.html")
	public String tree(Model model,HttpServletRequest request) {
		return prefix+"/org_tree";
	}

	/**
	 * 组织层级 表单页面
	 */
	@RequestMapping("/organization_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/organization_form";
	}
}
