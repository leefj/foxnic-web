package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum RemindTermUnit implements CodeTextEnum {

	minute("分钟"),hour("小时"),day("天");

	private String text;
	private RemindTermUnit(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static RemindTermUnit parseByCode(String code) {
		return (RemindTermUnit) EnumUtil.parseByCode(RemindTermUnit.values(),code);
	}

}
