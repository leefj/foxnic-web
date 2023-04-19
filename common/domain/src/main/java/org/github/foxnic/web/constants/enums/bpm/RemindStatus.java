package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum RemindStatus implements CodeTextEnum {

	pending("挂起"),reminding("提醒中"),done("已完毕");

	private String text;
	private RemindStatus(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static RemindStatus parseByCode(String code) {
		return (RemindStatus) EnumUtil.parseByCode(RemindStatus.values(),code);
	}

}
