package org.github.foxnic.web.system.page;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.json.JSONUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.SSOConstants;
import org.github.foxnic.web.constants.enums.system.SSOResponseFormat;
import org.github.foxnic.web.constants.enums.system.Theme;
import org.github.foxnic.web.constants.enums.system.VersionType;
import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.system.LangServiceProxy;
import org.github.foxnic.web.proxy.utils.DBCacheProxyUtil;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
		Boolean portalEnable= SystemConfigProxyUtil.getBoolean(SystemConfigEnum.SYSTEM_INDEX_PORTAL_ENABLE);
		String logo= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_INDEX_LOGO);
		String title= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		String versionCode= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CODE);
		String versionName= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_NAME);
		VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE,VersionType.class);
		String loginPageURL= UserServiceProxy.api().getSystemLoginPage().data();
		Boolean externalPortalEnable= SystemConfigProxyUtil.getBoolean(SystemConfigEnum.SYSTEM_EXTERNAL_PORTAL_ENABLE);
		String externalPortalLoginURL= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_EXTERNAL_PORTAL_LOGINURL);

		String pages= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_UI_TABLE_PAGELEVELS);
		if(!StringUtil.isBlank(pages)) {
			JSONArray array = JSONArray.parseArray(pages);
			model.addAttribute("tablePageLevels", array);
		}


		if(versionType!=VersionType.PROD) {
			title+="("+versionName+"_"+versionCode+")";
		}

		model.addAttribute("portalEnable", portalEnable==null?false:portalEnable);
		model.addAttribute("portalURL", portalURL);
		model.addAttribute("systemLoginPageURL", loginPageURL);

		model.addAttribute("externalPortalEnable", externalPortalEnable==null?false:externalPortalEnable);
		model.addAttribute("externalPortalLoginURL", externalPortalLoginURL);




		model.addAttribute("title", title);
		model.addAttribute("logo", logo);
		String moduleEnable= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_PORTAL_MODULE_ENABLE);
		model.addAttribute("moduleEnable", moduleEnable);



		 Result result = LangServiceProxy.api().queryList(LangVO.create());
		 if(result.success()) {
			 model.addAttribute("languageData", result.data());
		 } else {
			 model.addAttribute("languageData", new JSONArray());
		 }


		Theme theme  = SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_THEME, Theme.class);
		JSONObject themeConfig=new JSONObject();
		if(theme==Theme.PEAR) {
			DbCacheVO sample=new DbCacheVO();
			sample.setCatalog("theme");
			sample.setArea("pear-config");
			sample.setOwnerType("user");
			sample.setOwnerId(this.getCurrentUer().getUserId());
			List<DbCache> list = DBCacheProxyUtil.getList(sample);
			if(list!=null && list.size()>0) {
				DbCache cache = list.get(0);
				String cfg = cache.getValue();
				themeConfig = JSONUtil.parseJSONObject(cfg);
			}
		}

		model.addAttribute("theme_code", theme.code());
		model.addAttribute("theme_config", themeConfig);
		String indexTemplatePath=SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_THEME_INDEXTEMPLATEPATH);
		if(theme==null) {
			model.addAttribute("baseDir", "");
			if(StringUtil.isBlank(indexTemplatePath)) {
				indexTemplatePath="index";
			}
			return prefix+indexTemplatePath;
		} else {
			model.addAttribute("baseDir", theme.getBaseDir());
			if(StringUtil.isBlank(indexTemplatePath)) {
				indexTemplatePath=theme.getIndexTemplatePath();
			}
			return indexTemplatePath;
		}
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping("/login.html")
	public String login(Model model) {
		//
		Theme theme  = SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_THEME, Theme.class);
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

		model.addAttribute("theme_code", theme.code());
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

		JSONArray languageRange = SystemConfigProxyUtil.getJSONArray(SystemConfigEnum.SYSTEM_LANGUAGE_RANGE);
		model.addAttribute("languageRange", languageRange);



		//
		return prefix+"security/login-style-1";
//		 return prefix+"login";
	}

	/**
	 * 系统配置 表单页面
	 */
	@RequestMapping(UserServiceProxy.SSO_LOGIN_URI)
	public String ssoLogin(Model model, HttpServletRequest request) {

		SSOResponseFormat responseFormat= SSOResponseFormat.parseByCode(request.getParameter(SSOConstants.PARAMETER_FORMAT_NAME));
		String redirect=request.getParameter(SSOConstants.PARAMETER_REDIRECT_NAME);
		if(StringUtil.isBlank(redirect)) {
			redirect=SSOConstants.DEFAULT_SSO_REDIRECT_PAGE;
		}
		// 暂不考虑非单体应用情况
		JSONObject userLoginJson=(JSONObject) request.getAttribute(SessionUser.USER_LOGIN_JSON);

		String shortTitle= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_TITLE);
		String versionCode= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_CODE);
		String versionName= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_VERSION_NAME);
		VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE,VersionType.class);
		String fullTitle=shortTitle;

		if(versionType!=VersionType.PROD) {
			fullTitle+="("+versionName+"_"+versionCode+")";
		}

		model.addAttribute("responseFormat", responseFormat.code());
		model.addAttribute("redirect", redirect);
		model.addAttribute("shortTitle", shortTitle);
		model.addAttribute("fullTitle", fullTitle);

		model.addAttribute("userLoginJson", userLoginJson);


		//
		return StringUtil.removeFirst(UserServiceProxy.SSO_LOGIN_URI,"/");
	}


	@RequestMapping("/pages/tpl/password.html")
	public String changePasswd(Model model) {
		return prefix+"pages/tpl/password";
	}

}
