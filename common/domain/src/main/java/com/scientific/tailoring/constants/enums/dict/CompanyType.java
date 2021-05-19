package com.scientific.tailoring.constants.enums.dict;




/**
 * @since 2021-05-18 10:44:41
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum CompanyType {
	
	/**
	 * 供应商
	*/
	SUPPLIER("supplier" , "供应商"),
	
	/**
	 * 客户
	*/
	CLIENT("client" , "客户"),
	;
	
	private String code;
	private String text;
	private CompanyType(String code,String text)  {
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
	public static CompanyType parse(String code) {
		for (CompanyType dn : CompanyType.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}