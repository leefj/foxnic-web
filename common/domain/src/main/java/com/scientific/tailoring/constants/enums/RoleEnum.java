package com.scientific.tailoring.constants.enums;




/**
 * @since 2021-05-18 10:44:41
 * 从 select code,name from sys_role WHERE deleted=0 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum RoleEnum {
	
	/**
	 * 管理员
	*/
	ADMIN("admin" , "管理员"),
	
	/**
	 * 业务员
	*/
	BUSI("busi" , "业务员"),
	;
	
	private String code;
	private String text;
	private RoleEnum(String code,String text)  {
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
	public static RoleEnum parse(String code) {
		for (RoleEnum dn : RoleEnum.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}