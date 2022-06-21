package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;
import org.github.foxnic.web.domain.bpm.ProcessInstanceVO;

/**
 * 流程事件类型
 * */
public enum BpmEventType implements CodeTextEnum {

	TEMPORARY_SAVE_START("暂存前"),

	TEMPORARY_SAVE_END("暂存后"),
	NODE_USER_ACTION("用户处理，提交到流程引擎前发生"),
	NODE_START("流程引擎处理器前"),
	NODE_END("流程引擎处理后"),

	PROCESS_ABANDON_START("流程废弃前"),
	PROCESS_ABANDON_END("流程废弃后");
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
