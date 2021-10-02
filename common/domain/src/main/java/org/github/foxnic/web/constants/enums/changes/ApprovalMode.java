package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批状态
 * */
public enum ApprovalMode implements CodeTextEnum {
	simple("简单模式"),bpm("流程引擎");

	private String text;
	private ApprovalMode(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ApprovalMode parseByCode(String code) {
		return (ApprovalMode) EnumUtil.parseByCode(ApprovalMode.values(),code);
	}

}
