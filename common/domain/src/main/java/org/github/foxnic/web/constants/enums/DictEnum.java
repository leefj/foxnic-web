package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-08-17 15:38:37
 * @author 李方捷 , leefangjie@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('system') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum implements CodeTextEnum {
	
	/**
	 * 性别
	*/
	SEX("sex" , "性别"),
	
	/**
	 * 订单状态
	*/
	ORDER_STATUS("order_status" , "订单状态"),
	;
	
	private String code;
	private String text;
	private DictEnum(String code,String text)  {
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