package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 流程事件类型
 * */
public enum BpmEventType implements CodeTextEnum {

	ACTION("用户处理，提交到流程引擎前发生"),
	START("流程引擎处理器前"),
	END("流程引擎处理后");
	private String text;
	private BpmEventType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static BpmEventType parseByCode(String code) {
		return (BpmEventType) EnumUtil.parseByCode(BpmEventType.values(),code);
	}

}
