package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 角色表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-07 16:24:14
*/

@Controller("SysRolePageController")
@RequestMapping(RolePageController.prefix)
public class RolePageController {
	
	public static final String prefix="business/oauth/role";

	/**
	 * 角色 功能主页面
	 */
	@RequestMapping("/role_list.html")
	public String list(Model model) {
		return prefix+"/role_list";
	}

	/**
	 * 角色 表单页面
	 */
	@RequestMapping("/role_form.html")
	public String form(Model model , String id) {
		return prefix+"/role_form";
	}
}