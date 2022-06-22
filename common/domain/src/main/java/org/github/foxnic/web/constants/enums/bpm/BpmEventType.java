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


	PROCESS_SUBMIT_START("流程提交/启动前"),
	PROCESS_SUBMIT_END("流程提交/启动后"),

	TASK_START("待办处理前"),
	TASK_END("待办处理后"),
	NODE_START("流程引擎处理器前"),
	NODE_END("流程引擎处理后"),

	FETCH_BACK_START("撤回前"),
	FETCH_BACK_END("撤回后"),

	JUMP_START("节点跳转前"),
	JUMP_END("节点跳转后"),

	DELEGATE_START("转办前"),
	DELEGATE_END("转办后"),

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
