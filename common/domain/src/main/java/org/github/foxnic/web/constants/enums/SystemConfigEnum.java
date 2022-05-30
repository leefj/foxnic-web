package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-05-16 14:14:33
 * @author 李方捷 , leefangjie@qq.com
 * 从 select distinct code,name from sys_config WHERE deleted=0 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum SystemConfigEnum implements CodeTextEnum {
	
	/**
	 * 资产全局查询数据权限
	*/
	EAM_ASSETDATAPERMISSIONS("eam.assetDataPermissions" , "资产全局查询数据权限"),
	
	/**
	 * 资产页面直接更新
	*/
	EAM_ASSETDIRECTUPDATEMODE("eam.assetDirectUpdateMode" , "资产页面直接更新"),
	
	/**
	 * 资产导入保留编码
	*/
	EAM_ASSETIMPORTASSETCODEKEEP("eam.assetImportAssetCodeKeep" , "资产导入保留编码"),
	
	/**
	 * 资产导入数据自动补充
	*/
	EAM_ASSETIMPORTDATAREPLENISH("eam.assetImportDataReplenish" , "资产导入数据自动补充"),
	
	/**
	 * 资产序列是否唯一
	*/
	EAM_ASSETSERIALNUMBERISUNIQUE("eam.assetSerialNumberIsUnique" , "资产序列是否唯一"),
	
	/**
	 * 资产字段更新禁用
	*/
	EAM_ASSETSTATUSCOLUMNDISABLE("eam.assetStatusColumnDisable" , "资产字段更新禁用"),
	
	/**
	 * 监控zabbixGet命令路径
	*/
	OPS_MONITORZABBIXGETROUTE("ops.monitorZabbixGetRoute" , "监控zabbixGet命令路径"),
	
	/**
	 * 缓存键
	*/
	SYSTEM_CACHEKEY("system.cachekey" , "缓存键"),
	
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
	 * 网站图标
	*/
	SYSTEM_FAVICO("system.favico" , "网站图标"),
	
	/**
	 * 首页右上的logo图片
	*/
	SYSTEM_INDEX_LOGO("system.index.logo" , "首页右上的logo图片"),
	
	/**
	 * 系统默认语言
	*/
	SYSTEM_LANGUAGE("system.language" , "系统默认语言"),
	
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
	 * 账户默认密码
	*/
	SYSTEM_PASSWORD_DEFAULT("system.password.default" , "账户默认密码"),
	
	/**
	 * 首页分模块
	*/
	SYSTEM_PORTAL_MODULE_ENABLE("system.portal.module.enable" , "首页分模块"),
	
	/**
	 * 系统主题
	*/
	SYSTEM_THEME("system.theme" , "系统主题"),
	
	/**
	 * 系统名称
	*/
	SYSTEM_TITLE("system.title" , "系统名称"),
	
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