package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-11-30 09:46:32
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrmPersonPolitic  implements CodeTextEnum {
	
	/**
	 * 群众
	*/
	QZ("qz" , "群众"),
	
	/**
	 * 团员
	*/
	TY("ty" , "团员"),
	
	/**
	 * 党员
	*/
	DY("dy" , "党员"),
	;
	
	private String code;
	private String text;
	private HrmPersonPolitic(String code,String text)  {
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
	public static HrmPersonPolitic parseByCode(String code) {
		return (HrmPersonPolitic) EnumUtil.parseByCode(HrmPersonPolitic.values(),code);
	}
}