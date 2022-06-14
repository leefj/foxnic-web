package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum UserTaskType implements CodeTextEnum {

	regular("或审"),countersign_parallel("会审(并行)"),countersign_sequence("会审(顺序)"),loop("循环");

	private String text;
	private UserTaskType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static UserTaskType parseByCode(String code) {
		return (UserTaskType) EnumUtil.parseByCode(UserTaskType.values(),code);
	}







}
