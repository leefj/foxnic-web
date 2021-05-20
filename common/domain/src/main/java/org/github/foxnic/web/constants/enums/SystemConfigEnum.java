package org.github.foxnic.web.constants.enums;




/**
 * @since 2021-05-20 03:37:45
 * @author 李方捷 , leefangjie@qq.com
 * 从 select code,name from sys_config WHERE deleted=0 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum SystemConfigEnum {
	
	/**
	 * 系统默认语言
	*/
	SYSTEM_LANGUAGE("system.language" , "系统默认语言"),
	
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
	
	/**
	 * 从字符串转换成当前枚举类型，使用 valueOf 方法可能导致偏差，建议不要使用
	*/
	public static SystemConfigEnum parse(String code) {
		for (SystemConfigEnum dn : SystemConfigEnum.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}