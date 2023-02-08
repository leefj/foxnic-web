package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-02-08 13:58:45
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum HrMaritalStatus  implements CodeTextEnum {
	
	/**
	 * 已婚
	*/
	MARRIED("married" , "已婚"),
	
	/**
	 * 未婚
	*/
	UNMARRIED("unmarried" , "未婚"),
	;
	
	private String code;
	private String text;
	private HrMaritalStatus(String code,String text)  {
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
	public static HrMaritalStatus parseByCode(String code) {
		return (HrMaritalStatus) EnumUtil.parseByCode(HrMaritalStatus.values(),code);
	}
}