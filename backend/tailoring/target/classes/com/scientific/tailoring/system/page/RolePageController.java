package com.scientific.tailoring.system.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.scientific.tailoring.system.service.IRoleService;

import com.scientific.tailoring.framework.web.SuperController;

/**
 * <p>
 * 角色表 模版页面控制器
 * </p>
 * @author 李方捷
 * @since 2021-04-29 02:38:17
*/

@Controller("SysRolePageController")
@RequestMapping(RolePageController.prefix)
public class RolePageController  extends SuperController {
	
	public static final String prefix="pages/system/role";

	@Autowired
	private IRoleService roleService;

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
	public String form(Model model) {
		return prefix+"/role_form";
	}
}