package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-08-09 14:52:54
 * @author 李方捷 , leefangjie@qq.com
 * 从 select code,name from sys_config WHERE deleted=0 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum SystemConfigEnum implements CodeTextEnum {
	
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
	 * 系统默认语言
	*/
	SYSTEM_LANGUAGE("system.language" , "系统默认语言"),
	
	/**
	 * 首页分模块
	*/
	SYSTEM_PORTAL_MODULE_ENABLE("system.portal.module.enable" , "首页分模块"),
	
	/**
	 * 系统名称
	*/
	SYSTEM_TITLE("system.title" , "系统名称"),
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
}