package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * @since 2022-12-20 11:34:59
 * @author 李方捷 , leefangjie@qq.com
*/

public enum MenuLinkType implements CodeTextEnum {

	/**
	 * 系统页面
	*/
	INTERNAL("internal" , "系统页面"),

	/**
	 * 外部页面
	*/
	EXTERNAL("external" , "外部页面");



	private String code;
	private String text;
	private MenuLinkType(String code, String text)  {
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
	public static MenuLinkType parseByCode(String code) {
		return (MenuLinkType) EnumUtil.parseByCode(MenuLinkType.values(),code);
	}
}
