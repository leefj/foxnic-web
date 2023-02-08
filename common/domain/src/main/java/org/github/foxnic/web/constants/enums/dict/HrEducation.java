package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-02-08 13:58:45
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrEducation  implements CodeTextEnum {
	
	/**
	 * 小学
	*/
	PRIMARY("primary" , "小学"),
	
	/**
	 * 高中
	*/
	HIGH("high" , "高中"),
	
	/**
	 * 初中
	*/
	MIDDLE("middle" , "初中"),
	
	/**
	 * 大专
	*/
	JUNIOR_COLLEGE("junior_college" , "大专"),
	
	/**
	 * 本科
	*/
	UNDERGRADUATE("undergraduate" , "本科"),
	
	/**
	 * 研究生
	*/
	POSTGRADUATE("postgraduate" , "研究生"),
	;
	
	private String code;
	private String text;
	private HrEducation(String code,String text)  {
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
	public static HrEducation parseByCode(String code) {
		return (HrEducation) EnumUtil.parseByCode(HrEducation.values(),code);
	}
}