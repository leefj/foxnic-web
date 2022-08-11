package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 流程事件类型
 * */
public enum BpmEventType implements CodeTextEnum {

	temporary_save_start("暂存前"),
	temporary_save_end("暂存后"),


	process_submit_start("流程提交/启动前"),
	process_submit_end("流程提交/启动后"),

	task_start("待办处理前"),
	task_end("待办处理后"),
	node_start("流程引擎处理器前"),
	node_end("流程引擎处理后"),

	fetch_back_start("撤回前"),
	fetch_back_end("撤回后"),

	jump_start("节点跳转前"),
	jump_end("节点跳转后"),

	delegate_start("转办前"),
	delegate_end("转办后"),

	process_abandon_start("流程废弃前"),
	process_abandon_end("流程废弃后");


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
