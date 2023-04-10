package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum SystemConfigType implements CodeTextEnum {

	/**
	 * 特殊类型
	 * */
	DIR("节点目录"),
	// 以下为数据类型
	STRING("字符串"),DATETIME("日期时间"),NUMBER("数字"),DICT("字典"),ENUM("枚举单选"),ENUM_MULTI("枚举多选");

	private String text;
	private SystemConfigType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static SystemConfigType parseByCode(String code) {
		return (SystemConfigType) EnumUtil.parseByCode(SystemConfigType.values(),code);
	}
}
