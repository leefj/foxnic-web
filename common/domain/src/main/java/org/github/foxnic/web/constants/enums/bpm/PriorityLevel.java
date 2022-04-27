package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum PriorityLevel implements CodeTextEnum {

	normal("普通"),urgency("加急");

	private String text;
	private PriorityLevel(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static PriorityLevel parseByCode(String code) {
		return (PriorityLevel) EnumUtil.parseByCode(PriorityLevel.values(),code);
	}

}
