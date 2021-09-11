package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-09-11 14:38:36
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum Sex  implements CodeTextEnum {
	
	/**
	 * 男
	*/
	F("F" , "男"),
	
	/**
	 * 女
	*/
	M("M" , "女"),
	;
	
	private String code;
	private String text;
	private Sex(String code,String text)  {
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