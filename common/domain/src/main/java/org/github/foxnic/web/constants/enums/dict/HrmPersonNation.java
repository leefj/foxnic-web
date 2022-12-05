package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2022-12-05 14:59:32
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrmPersonNation  implements CodeTextEnum {
	
	/**
	 * 汉族
	*/
	HZ("hz" , "汉族"),
	
	/**
	 * 回族
	*/
	HUIZHU("huizhu" , "回族"),
	;
	
	private String code;
	private String text;
	private HrmPersonNation(String code,String text)  {
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
	public static HrmPersonNation parseByCode(String code) {
		return (HrmPersonNation) EnumUtil.parseByCode(HrmPersonNation.values(),code);
	}
}