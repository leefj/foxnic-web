package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-02-02 09:18:37
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EmployeeType  implements CodeTextEnum {
	
	/**
	 * 前台员工
	*/
	_1("1" , "前台员工"),
	
	/**
	 * 后台员工
	*/
	_2("2" , "后台员工"),
	
	/**
	 * 临时员工
	*/
	_3("3" , "临时员工"),
	;
	
	private String code;
	private String text;
	private EmployeeType(String code,String text)  {
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
	public static EmployeeType parseByCode(String code) {
		return (EmployeeType) EnumUtil.parseByCode(EmployeeType.values(),code);
	}
}