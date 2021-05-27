package org.github.foxnic.web.oauth.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 在线会话表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-27 05:28:14
*/

@Controller("SysSessionOnlinePageController")
@RequestMapping(SessionOnlinePageController.prefix)
public class SessionOnlinePageController {
	
	public static final String prefix="pages/oauth/session_online";

	/**
	 * 在线会话 功能主页面
	 */
	@RequestMapping("/session_online_list.html")
	public String list(Model model) {
		return prefix+"/session_online_list";
	}

	/**
	 * 在线会话 表单页面
	 */
	@RequestMapping("/session_online_form.html")
	public String form(Model model , String id) {
		return prefix+"/session_online_form";
	}
}