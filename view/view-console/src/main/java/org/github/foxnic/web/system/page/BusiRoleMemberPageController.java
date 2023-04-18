package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.BusiRoleMemberServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 业务角色成员关系模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-18 09:51:55
*/

@Controller("SysBusiRoleMemberPageController")
@RequestMapping(BusiRoleMemberPageController.prefix)
public class BusiRoleMemberPageController extends ViewController {

	public static final String prefix="business/system/busi_role_member";

	private BusiRoleMemberServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public BusiRoleMemberServiceProxy proxy() {
		if(proxy==null) {
			proxy=BusiRoleMemberServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 业务角色成员关系 功能主页面
	 */
	@RequestMapping("/busi_role_member_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"busi_role_member_list");
	}

	/**
	 * 业务角色成员关系 表单页面
	 */
	@RequestMapping("/busi_role_member_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"busi_role_member_form");
	}
}