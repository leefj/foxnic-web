package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum DrafterRangeType implements CodeTextEnum {

	any("任何人"),range("指定人员");

	private String text;
	private DrafterRangeType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static DrafterRangeType parseByCode(String code) {
		return (DrafterRangeType) EnumUtil.parseByCode(DrafterRangeType.values(),code);
	}







}
