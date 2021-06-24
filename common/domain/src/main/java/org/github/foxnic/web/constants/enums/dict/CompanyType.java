package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-06-24 11:45:00
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum CompanyType  implements CodeTextEnum {
	
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
}