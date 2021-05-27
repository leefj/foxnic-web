package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * OAuth 认证客户端 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 01:25:31
*/

@Controller("SysOauthClientPageController")
@RequestMapping(OauthClientPageController.prefix)
public class OauthClientPageController {
	
	public static final String prefix="pages/oauth/oauth_client";

	/**
	 * OAuth 功能主页面
	 */
	@RequestMapping("/oauth_client_list.html")
	public String list(Model model) {
		return prefix+"/oauth_client_list";
	}

	/**
	 * OAuth 表单页面
	 */
	@RequestMapping("/oauth_client_form.html")
	public String form(Model model , String clientId) {
		return prefix+"/oauth_client_form";
	}
}