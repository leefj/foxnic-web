package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-04-18 09:15:57
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_config WHERE profile_id='default' and type!='DIR' and deleted=0 and (code like 'system.%' or code like 'modules%') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum SystemConfigEnum implements CodeTextEnum {
	
	/**
	 * default
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_SERVICE_IPROFILESERVICE_IMPL_C1675395268512("modules.org.github.foxnic.web.system.service.IProfileService.impl.C1675395268512" , "default"),
	
	/**
	 * T001
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_SERVICE_IPROFILESERVICE_IMPL_TENANT_C1675395334919("modules.org.github.foxnic.web.system.service.IProfileService.impl.tenant.C1675395334919" , "T001"),
	
	/**
	 * T002
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_SERVICE_IPROFILESERVICE_IMPL_TENANT_C1675395344550("modules.org.github.foxnic.web.system.service.IProfileService.impl.tenant.C1675395344550" , "T002"),
	
	/**
	 * admin
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_SERVICE_IPROFILESERVICE_IMPL_USER_ADMIN("modules.org.github.foxnic.web.system.service.IProfileService.impl.user.admin" , "admin"),
	
	/**
	 * list
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_PAGE_PROFILEPAGECONTROLLER_IMPL_DEFAULT_LIST("modules.org.github.foxnic.web.system.page.ProfilePageController.impl.default.list" , "list"),
	
	/**
	 * form
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_PAGE_PROFILEPAGECONTROLLER_IMPL_DEFAULT_FORM("modules.org.github.foxnic.web.system.page.ProfilePageController.impl.default.form" , "form"),
	
	/**
	 * list
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_PAGE_PROFILEPAGECONTROLLER_IMPL_USER_ADMIN_LIST("modules.org.github.foxnic.web.system.page.ProfilePageController.impl.user.admin.list" , "list"),
	
	/**
	 * form
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_PAGE_PROFILEPAGECONTROLLER_IMPL_USER_ADMIN_FORM("modules.org.github.foxnic.web.system.page.ProfilePageController.impl.user.admin.form" , "form"),
	
	/**
	 * default
	*/
	MODULES_ORG_GITHUB_FOXNIC_WEB_SYSTEM_SERVICE_IDICTSERVICE_IMPL_DEFAULT("modules.org.github.foxnic.web.system.service.IDictService.impl.default" , "default"),
	
	/**
	 * 缓存键
	*/
	SYSTEM_VERSION_CACHEKEY("system.version.cachekey" , "缓存键"),
	
	/**
	 * 版权信息链接
	*/
	SYSTEM_COPYRIGHT_LINK("system.copyright.link" , "版权信息链接"),
	
	/**
	 * 版权信息文本
	*/
	SYSTEM_COPYRIGHT_TEXT("system.copyright.text" , "版权信息文本"),
	
	/**
	 * 创建员工时同步创建账户
	*/
	SYSTEM_EMPLOYEE_CREATEUSER("system.employee.createUser" , "创建员工时同步创建账户"),
	
	/**
	 * 是否集成外部门户
	*/
	SYSTEM_EXTERNAL_PORTAL_ENABLE("system.external.portal.enable" , "是否集成外部门户"),
	
	/**
	 * 外部门户登录页面地址
	*/
	SYSTEM_EXTERNAL_PORTAL_LOGINURL("system.external.portal.loginURL" , "外部门户登录页面地址"),
	
	/**
	 * 站点图标
	*/
	SYSTEM_FAVICO("system.favico" , "站点图标"),
	
	/**
	 * 首页右上的logo图片
	*/
	SYSTEM_INDEX_LOGO("system.index.logo" , "首页右上的logo图片"),
	
	/**
	 * 是否启用门户页面
	*/
	SYSTEM_INDEX_PORTAL_ENABLE("system.index.portal.enable" , "是否启用门户页面"),
	
	/**
	 * 门户页面
	*/
	SYSTEM_INDEX_PORTALURL("system.index.portalURL" , "门户页面"),
	
	/**
	 * 系统默认语言
	*/
	SYSTEM_LANGUAGE_DEFAULT("system.language.default" , "系统默认语言"),
	
	/**
	 * 系统语言范围
	*/
	SYSTEM_LANGUAGE_RANGE("system.language.range" , "系统语言范围"),
	
	/**
	 * 登录页背景图
	*/
	SYSTEM_LOGIN_BACKGROUND("system.login.background" , "登录页背景图"),
	
	/**
	 * 任意校验码
	*/
	SYSTEM_LOGIN_CAPTCHA_ANY("system.login.captcha.any" , "任意校验码"),
	
	/**
	 * 登录信息
	*/
	SYSTEM_LOGIN_DEFAULT("system.login.default" , "登录信息"),
	
	/**
	 * 登录页Logo图片
	*/
	SYSTEM_LOGIN_LOGO("system.login.logo" , "登录页Logo图片"),
	
	/**
	 * 登录页抬头
	*/
	SYSTEM_LOGIN_TITLE("system.login.title" , "登录页抬头"),
	
	/**
	 * 登录页模版
	*/
	SYSTEM_LOGIN_TEMPLATE("system.login.template" , "登录页模版"),
	
	/**
	 * 账户默认密码
	*/
	SYSTEM_USER_DEFAULT_PASSWORD("system.user.default_password" , "账户默认密码"),
	
	/**
	 * 首页分模块
	*/
	SYSTEM_INDEX_MODULE_ENABLE("system.index.module_enable" , "首页分模块"),
	
	/**
	 * 系统主题
	*/
	SYSTEM_THEME_DEFAULT("system.theme.default" , "系统主题"),
	
	/**
	 * 系统主题模版页面
	*/
	SYSTEM_THEME_INDEXTEMPLATEPATH("system.theme.indexTemplatePath" , "系统主题模版页面"),
	
	/**
	 * 系统名称
	*/
	SYSTEM_TITLE("system.title" , "系统名称"),
	
	/**
	 * mysqldump
	*/
	SYSTEM_TOOL_MYSQLDUMP("system.tool.mysqldump" , "mysqldump"),
	
	/**
	 * 表格分页档位
	*/
	SYSTEM_UI_TABLE_PAGELEVELS("system.ui.table.pageLevels" , "表格分页档位"),
	
	/**
	 * 版本代码
	*/
	SYSTEM_VERSION_CODE("system.version.code" , "版本代码"),
	
	/**
	 * 版本名称
	*/
	SYSTEM_VERSION_NAME("system.version.name" , "版本名称"),
	
	/**
	 * 版本类型
	*/
	SYSTEM_VERSION_TYPE("system.version.type" , "版本类型"),
	;
	
	private String code;
	private String text;
	private SystemConfigEnum(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
	
	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static SystemConfigEnum parseByCode(String code) {
		return (SystemConfigEnum) EnumUtil.parseByCode(SystemConfigEnum.values(),code);
	}
}