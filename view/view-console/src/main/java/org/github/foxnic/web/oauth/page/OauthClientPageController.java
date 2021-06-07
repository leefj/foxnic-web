package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 认证客户端 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-07 16:24:14
*/

@Controller("SysOauthClientPageController")
@RequestMapping(OauthClientPageController.prefix)
public class OauthClientPageController {
	
	public static final String prefix="business/oauth/oauth_client";

	/**
	 * 认证客户端 功能主页面
	 */
	@RequestMapping("/oauth_client_list.html")
	public String list(Model model) {
		return prefix+"/oauth_client_list";
	}

	/**
	 * 认证客户端 表单页面
	 */
	@RequestMapping("/oauth_client_form.html")
	public String form(Model model , String id) {
		return prefix+"/oauth_client_form";
	}
}