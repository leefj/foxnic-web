package org.github.foxnic.web.system.page;

import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-15 17:25:48
*/

@Controller("SysPortalPageController")
@RequestMapping(PortalPageController.prefix)
public class PortalPageController extends ViewController  {
	
	public static final String prefix="";
 
	/**
	 * 系统配置 功能主页面
	 */
	@RequestMapping("/index.html")
	public String index(Model model) {
		String title= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		model.addAttribute("title", title);
		String moduleEnable= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_PORTAL_MODULE_ENABLE);
		model.addAttribute("moduleEnable", moduleEnable);
		return prefix+"index";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/login.html")
	public String login(Model model) {
		//
		String title= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		model.addAttribute("title", title);
		//
		String copyrightText= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_TEXT);
		model.addAttribute("copyrightText", copyrightText);
		//
		String copyrightLink= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_LINK);
		model.addAttribute("copyrightLink", copyrightLink);
		//
		return prefix+"login";
	}
}