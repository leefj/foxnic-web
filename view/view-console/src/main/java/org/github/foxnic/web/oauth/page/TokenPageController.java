package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * Token表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-02 14:46:36
*/

@Controller("SysTokenPageController")
@RequestMapping(TokenPageController.prefix)
public class TokenPageController {
	
	public static final String prefix="pages/oauth/token";

	/**
	 * Token 功能主页面
	 */
	@RequestMapping("/token_list.html")
	public String list(Model model) {
		return prefix+"/token_list";
	}

	/**
	 * Token 表单页面
	 */
	@RequestMapping("/token_form.html")
	public String form(Model model , Integer id) {
		return prefix+"/token_form";
	}
}