package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 菜单表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-07 16:24:15
*/

@Controller("SysMenuPageController")
@RequestMapping(MenuPageController.prefix)
public class MenuPageController {
	
	public static final String prefix="business/oauth/menu";

	/**
	 * 菜单 功能主页面
	 */
	@RequestMapping("/menu_list.html")
	public String list(Model model) {
		return prefix+"/menu_list";
	}

	/**
	 * 菜单 表单页面
	 */
	@RequestMapping("/menu_form.html")
	public String form(Model model , String id) {
		return prefix+"/menu_form";
	}
}