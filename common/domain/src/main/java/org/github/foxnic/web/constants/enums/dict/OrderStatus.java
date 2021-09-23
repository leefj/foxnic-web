package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * @since 2021-09-23 19:39:32
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OrderStatus  implements CodeTextEnum {
	
	/**
	 * 未完成
	*/
	TODO("todo" , "未完成"),
	
	/**
	 * 已完成
	*/
	DONE("done" , "已完成"),
	
	/**
	 * 已废弃
	*/
	ABADON("abadon" , "已废弃"),
	;
	
	private String code;
	private String text;
	private OrderStatus(String code,String text)  {
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
	public static OrderStatus parseByCode(String code) {
		return (OrderStatus) EnumUtil.parseByCode(OrderStatus.values(),code);
	}
}