package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum SystemConfigType implements CodeTextEnum {
	
	STRING("字符串"),DATETIME("日期时间"),NUMBER("数字"),DICT("字典"),ENUM("枚举");
	 
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
