package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import com.scientific.tailoring.system.service.IConfigService;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:23
 * 系统配置 模版页面
 */

@Controller("SysConfigPageController")
@RequestMapping(ConfigPageController.prefix)
public class ConfigPageController extends SuperController {
	
	public static final String prefix="pages/system/config";

	@Autowired
	private IConfigService configService;

	/**
	 * 系统配置 功能主页面
	 */
	@RequiresPermissions("SysConfig:page:list")
	@RequestMapping("/config_list.html")
	public String list(Model model) {
		return prefix+"/config_list";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequiresPermissions("SysConfig:page:form")
	@RequestMapping("/config_form.html")
	public String form(Model model) {
		return prefix+"/config_form";
	}
}