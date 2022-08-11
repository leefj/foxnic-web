package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 账户表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 01:25:30
*/

@Controller("SysUserPageController")
@RequestMapping(UserPageController.prefix)
public class UserPageController {

	public static final String prefix="business/oauth/user";

	/**
	 * 账户 功能主页面
	 */
	@RequestMapping("/user_list.html")
	public String list(Model model) {
		return prefix+"/user_list";
	}

	/**
	 * 账户 表单页面
	 */
	@RequestMapping("/user_form.html")
	public String form(Model model , String id) {
		return prefix+"/user_form";
	}

	/**
	 * 账户 表单页面
	 */
	@RequestMapping("/user_profile.html")
	public String profileForm(Model model , String id) {
		return prefix+"/user_profile";
	}

	/**
	 * 账户 表单页面
	 */
	@RequestMapping("/user_passwd_form.html")
	public String passwdForm(Model model , String id) {
		return prefix+"/user_passwd_form";
	}

}
