package org.github.foxnic.web.constants.enums.dataperm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ConditionNodeType implements CodeTextEnum {

	group("逻辑组"),expr("表达式");

	private String text;
	private ConditionNodeType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ConditionNodeType parseByCode(String code) {
		return (ConditionNodeType) EnumUtil.parseByCode(ConditionNodeType.values(),code);
	}

}
