package org.github.foxnic.web.system.page;

import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.proxy.SystemConfigUtil;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.springboot.mvc.Result;

/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-15 17:25:48
*/

@Controller("SysPortalPageController")
@RequestMapping(PortalPageController.prefix)
public class PortalPageController {
	
	public static final String prefix="/";
 
	/**
	 * 系统配置 功能主页面
	 */
	@RequestMapping("/index.html")
	public String index(Model model) {
		String title= SystemConfigUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		model.addAttribute("title", title);
		return prefix+"index";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/login.html")
	public String login(Model model) {
		//
		String title=SystemConfigUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		model.addAttribute("title", title);
		//
		String copyrightText=SystemConfigUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_TEXT);
		model.addAttribute("copyrightText", copyrightText);
		//
		String copyrightLink=SystemConfigUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_LINK);
		model.addAttribute("copyrightLink", copyrightLink);
		//
		return prefix+"login";
	}
}