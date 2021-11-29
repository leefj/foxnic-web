package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.hrm.CompanyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 公司表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:19
*/

@Controller("HrmCompanyPageController")
@RequestMapping(CompanyPageController.prefix)
public class CompanyPageController extends ViewController {
	
	public static final String prefix="business/hrm/company";

	private CompanyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CompanyServiceProxy proxy() {
		if(proxy==null) {
			proxy=CompanyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 公司 功能主页面
	 */
	@RequestMapping("/company_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/company_list";
	}

	/**
	 * 公司 表单页面
	 */
	@RequestMapping("/company_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/company_form";
	}
}