package org.github.foxnic.web.constants.enums.dataperm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum LogicType implements CodeTextEnum {

	and("AND"),or("OR");

	private String text;
	private LogicType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static LogicType parseByCode(String code) {
		return (LogicType) EnumUtil.parseByCode(LogicType.values(),code);
	}

}
