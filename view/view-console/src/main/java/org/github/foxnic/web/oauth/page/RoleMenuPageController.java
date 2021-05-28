package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 角色账户关系表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 10:53:35
*/

@Controller("SysRoleMenuPageController")
@RequestMapping(RoleMenuPageController.prefix)
public class RoleMenuPageController {
	
	public static final String prefix="pages/oauth/role_menu";

	/**
	 * 角色账户关系 功能主页面
	 */
	@RequestMapping("/role_menu_list.html")
	public String list(Model model) {
		return prefix+"/role_menu_list";
	}

	/**
	 * 角色账户关系 表单页面
	 */
	@RequestMapping("/role_menu_form.html")
	public String form(Model model , String id) {
		return prefix+"/role_menu_form";
	}
}