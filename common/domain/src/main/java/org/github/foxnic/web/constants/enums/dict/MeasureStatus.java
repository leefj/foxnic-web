package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-07-20 13:37:13
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum MeasureStatus  implements CodeTextEnum {
	
	/**
	 * 待测量
	*/
	TODO("todo" , "待测量"),
	
	/**
	 * 已测量
	*/
	DONE("done" , "已测量"),
	
	/**
	 * 已废弃
	*/
	ABADON("abadon" , "已废弃"),
	
	/**
	 * 已报告
	*/
	REPORT("report" , "已报告"),
	;
	
	private String code;
	private String text;
	private MeasureStatus(String code,String text)  {
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