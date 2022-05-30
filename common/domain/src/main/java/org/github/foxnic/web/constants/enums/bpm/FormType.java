package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum FormType implements CodeTextEnum {

	custom("自定义表单"),outer("外部表单");

	private String text;
	private FormType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static FormType parseByCode(String code) {
		return (FormType) EnumUtil.parseByCode(FormType.values(),code);
	}

}
