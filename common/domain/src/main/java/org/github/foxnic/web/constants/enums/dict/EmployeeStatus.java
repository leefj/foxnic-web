package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-09-15 15:06:56
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EmployeeStatus  implements CodeTextEnum {
	
	/**
	 * 在职
	*/
	ACTIVE("active" , "在职"),
	
	/**
	 * 离职
	*/
	LEAVE("leave" , "离职"),
	;
	
	private String code;
	private String text;
	private EmployeeStatus(String code,String text)  {
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