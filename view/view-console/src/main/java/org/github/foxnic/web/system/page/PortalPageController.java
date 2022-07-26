package org.github.foxnic.web.system.page;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.Theme;
import org.github.foxnic.web.constants.enums.system.VersionType;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 系统配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-15 17:25:48
*/

@Controller("SysPortalPageController")
@RequestMapping(PortalPageController.prefix)
public class PortalPageController extends ViewController  {

	public static final String prefix="";

	/**
	 * 系统配置 功能主页面
	 */
	@RequestMapping(value = {"/index.html","/"})
	public String index(Model model) {
		String portalURL= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_INDEX_PORTALURL);
		String logo= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_INDEX_LOGO);
		String title= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		String versionCode= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CODE);
		String versionName= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_NAME);
		VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE,VersionType.class);

		String pages= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_UI_TABLE_PAGELEVELS);
		if(!StringUtil.isBlank(pages)) {
			JSONArray array = JSONArray.parseArray(pages);
			model.addAttribute("tablePageLevels", array);
		}


		if(versionType!=VersionType.PROD) {
			title+="("+versionName+"_"+versionCode+")";
		}

		model.addAttribute("portalURL", portalURL);
		model.addAttribute("title", title);
		model.addAttribute("logo", logo);
		String moduleEnable= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_PORTAL_MODULE_ENABLE);
		model.addAttribute("moduleEnable", moduleEnable);


		Theme theme  = SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_THEME, Theme.class);

		if(theme==null) {
			model.addAttribute("baseDir", "");
			return prefix+"index";
		} else {
			model.addAttribute("baseDir", theme.getBaseDir());
			return theme.getIndexTemplatePath();
		}
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/login.html")
	public String login(Model model) {
		//
		String bgImage= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_LOGIN_BACKGROUND);
		String shortTitle= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		String versionCode= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CODE);
		String versionName= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_NAME);
		VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE,VersionType.class);
		String fullTitle=shortTitle;
		if(versionType!=VersionType.PROD) {
			fullTitle+="("+versionName+"_"+versionCode+")";
		}

		String loginDefault= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_LOGIN_DEFAULT);
		JSONObject loginDefaultJson=JSONObject.parseObject(loginDefault);


		model.addAttribute("bgImage", bgImage);
		model.addAttribute("shortTitle", shortTitle);
		model.addAttribute("fullTitle", fullTitle);
		//
		String copyrightText= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_TEXT);
		model.addAttribute("copyrightText", copyrightText);
		//
		String copyrightLink= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_COPYRIGHT_LINK);
		model.addAttribute("copyrightLink", copyrightLink);

		model.addAttribute("loginDefault", loginDefaultJson);
		//
		return prefix+"login";
	}
}
