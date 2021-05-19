package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import com.scientific.tailoring.system.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:24
 * 功能菜单 模版页面
 */

@Controller("SysMenuPageController")
@RequestMapping(MenuPageController.prefix)
public class MenuPageController extends SuperController {
	
	public static final String prefix="pages/system/menu";

	@Autowired
	private IMenuService menuService;

	/**
	 * 功能菜单 功能主页面
	 */
	@RequiresPermissions("SysMenu:page:list")
	@RequestMapping("/menu_list.html")
	public String list(Model model) {
		return prefix+"/menu_list";
	}

	/**
	 * 功能菜单 表单页面
	 */
	@RequiresPermissions("SysMenu:page:form")
	@RequestMapping("/menu_form.html")
	public String form(Model model) {
		return prefix+"/menu_form";
	}
}