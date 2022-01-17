package org.github.foxnic.web.constants.enums.job;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 日志类型
 * */
public enum LogType implements CodeTextEnum {
	CRON("任务日志","cron"),
	CONFIG("配置日志","config");

	private String code;
	private String text;

	private LogType(String text, String code) {
		this.code=code;
		this.text=text;
	}

	public String code() {
		return this.code;
	}

	public String text() {
		return this.text;
	}

	public static LogType parseByCode(String code) {
		return (LogType) EnumUtil.parseByCode(LogType.values(),code);
	}
}
