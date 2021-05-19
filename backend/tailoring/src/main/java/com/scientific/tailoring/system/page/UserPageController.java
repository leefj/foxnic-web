package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.system.service.IUserService;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:24
 * 用户 模版页面
 */

@Controller("SysUserPageController")
@RequestMapping(UserPageController.prefix)
public class UserPageController extends SuperController {
	
	public static final String prefix="pages/system/user";

	@Autowired
	private IUserService userService;

	/**
	 * 用户 功能主页面
	 */
	@RequiresPermissions("SysUser:page:list")
	@RequestMapping("/user_list.html")
	public String list(Model model) {
		return prefix+"/user_list";
	}

	/**
	 * 用户 表单页面
	 */
	@RequiresPermissions("SysUser:page:form")
	@RequestMapping("/user_form.html")
	public String form(Model model) {
		return prefix+"/user_form";
	}
}