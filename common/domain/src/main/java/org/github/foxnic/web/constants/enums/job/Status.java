package org.github.foxnic.web.constants.enums.job;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum Status implements CodeTextEnum {
	NORMAL("正常","normal"),
	PAUSED("暂停","paused");

	private String code;
	private String text;

	private Status(String text, String code) {
		this.code=code;
		this.text=text;
	}

	public String code() {
		return this.code;
	}

	public String text() {
		return this.text;
	}

	public static Status parseByCode(String code) {
		return (Status) EnumUtil.parseByCode(Status.values(),code);
	}
}
