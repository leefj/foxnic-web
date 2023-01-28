package org.github.foxnic.web.oauth.page;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.proxy.spring.AwareHandler;
import org.github.foxnic.web.proxy.utils.CodeTextEnumUtil;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.thymeleaf.spring5.context.SpringContextUtils;

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
	public String profileForm(Model model , String id) throws Exception {
		CodeTextEnumUtil enumUtil= AwareHandler.getBean(CodeTextEnumUtil.class);
		JSONArray langs=enumUtil.toArray(Language.class.getName(),true);
		JSONArray languageRange = SystemConfigProxyUtil.getJSONArray(SystemConfigEnum.SYSTEM_LANGUAGE_RANGE);
		JSONArray finalLangs=new JSONArray();
		for (int i = 0; i < langs.size(); i++) {
			JSONObject lang=langs.getJSONObject(i);
			if(languageRange.indexOf(lang.getString("code"))!=-1) {
				finalLangs.add(lang);
			}
		}
		model.addAttribute("finalLangs", finalLangs);
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
