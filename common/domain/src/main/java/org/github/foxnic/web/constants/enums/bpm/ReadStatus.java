package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批任务状态
 * */
public enum ReadStatus implements CodeTextEnum {

	unread("待阅"),read("已阅");

	private String text;
	private ReadStatus(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ReadStatus parseByCode(String code) {
		return (ReadStatus) EnumUtil.parseByCode(ReadStatus.values(),code);
	}

}
