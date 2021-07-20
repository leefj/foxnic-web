package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-07-20 13:37:13
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureResultType  implements CodeTextEnum {
	
	/**
	 * 净体
	*/
	BODY("body" , "净体"),
	
	/**
	 * 着装
	*/
	OUTFIT("outfit" , "着装"),
	;
	
	private String code;
	private String text;
	private MeasureResultType(String code,String text)  {
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