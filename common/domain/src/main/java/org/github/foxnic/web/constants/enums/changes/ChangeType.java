package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ChangeType implements CodeTextEnum {
	create("新增"),modify("调整"),drop("作废");

	private String text;
	private ChangeType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ChangeType parseByCode(String code) {
		return (ChangeType) EnumUtil.parseByCode(ChangeType.values(),code);
	}

}
