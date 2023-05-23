package org.github.foxnic.web.constants.enums.dict;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2023-05-23 17:01:23
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum RoleType  implements CodeTextEnum {
	
	/**
	 * 基础
	*/
	BASIC("basic" , "基础"),
	
	/**
	 * 查询
	*/
	QUERY("query" , "查询"),
	
	/**
	 * 管理
	*/
	ADMIN("admin" , "管理"),
	
	/**
	 * 测试
	*/
	TEST("test" , "测试"),
	
	/**
	 * 普通
	*/
	NORMAL("normal" , "普通"),
	;
	
	private String code;
	private String text;
	private RoleType(String code,String text)  {
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
	public static RoleType parseByCode(String code) {
		return (RoleType) EnumUtil.parseByCode(RoleType.values(),code);
	}
}