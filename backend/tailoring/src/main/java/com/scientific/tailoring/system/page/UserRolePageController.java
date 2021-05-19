package com.scientific.tailoring.system.page;
import com.scientific.tailoring.system.service.IUserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:24
 * 用户角色关系 模版页面
 */

@Controller("SysUserRolePageController")
@RequestMapping(UserRolePageController.prefix)
public class UserRolePageController extends SuperController {
	
	public static final String prefix="pages/system/user_role";

	@Autowired
	private IUserRoleService userRoleService;

	/**
	 * 用户角色关系 功能主页面
	 */
	@RequiresPermissions("SysUserRole:page:list")
	@RequestMapping("/user_role_list.html")
	public String list(Model model) {
		return prefix+"/user_role_list";
	}

	/**
	 * 用户角色关系 表单页面
	 */
	@RequiresPermissions("SysUserRole:page:form")
	@RequestMapping("/user_role_form.html")
	public String form(Model model) {
		return prefix+"/user_role_form";
	}
}