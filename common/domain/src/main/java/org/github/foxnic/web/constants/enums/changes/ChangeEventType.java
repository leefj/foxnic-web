package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ChangeEventType implements CodeTextEnum {
	create_success("创建成功"),create_failure("创建失败");

	private String text;
	private ChangeEventType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ChangeEventType parseByCode(String code) {
		return (ChangeEventType) EnumUtil.parseByCode(ChangeEventType.values(),code);
	}

}
