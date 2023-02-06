package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * @since 2022-12-20 11:34:59
 * @author 李方捷 , leefangjie@qq.com
*/

public enum MenuOpenType implements CodeTextEnum {

	/**
	 * 系统Tab页面
	*/
	INTERNAL_TAB("internal_tab" , "内部Tab页"),

	/**
	 * 系统内窗口
	 */
	INTERNAL_WIN("internal_win" , "内部窗口"),

	/**
	 * 外部页面
	*/
	EXTERNAL_TAB("external_tab" , "浏览器Tab页"),

	/**
	 * 外部窗口
	 */
	EXTERNAL_WIN("external_win" , "浏览器窗口");


	private String code;
	private String text;
	private MenuOpenType(String code, String text)  {
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
	public static MenuOpenType parseByCode(String code) {
		return (MenuOpenType) EnumUtil.parseByCode(MenuOpenType.values(),code);
	}
}
