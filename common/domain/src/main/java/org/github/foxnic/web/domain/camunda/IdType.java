package org.github.foxnic.web.domain.camunda;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 日志类型
 * */
public enum IdType implements CodeTextEnum {

	USER("账户"),GROUP("群组"),TENANT("租户");

	private String text;

	private IdType(String text) {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}

	public static IdType parseByCode(String code) {
		return (IdType) EnumUtil.parseByCode(IdType.values(),code);
	}
}
