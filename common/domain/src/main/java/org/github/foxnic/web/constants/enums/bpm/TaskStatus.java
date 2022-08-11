package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批任务状态
 * */
public enum TaskStatus implements CodeTextEnum {

	todo("待办"),done("已办"),cancel("取消"),abandoned("废弃"),unread("待阅"),read("已阅");

	private String text;
	private TaskStatus(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static TaskStatus parseByCode(String code) {
		return (TaskStatus) EnumUtil.parseByCode(TaskStatus.values(),code);
	}

}
