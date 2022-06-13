package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批状态
 * */
public enum ApprovalStatus implements CodeTextEnum {
	drafting("起草中"),approving("审批中"),passed("已通过"),
	rejected("已驳回"),abandoned("已废弃"),error("流程异常");

	private String text;
	private ApprovalStatus(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ApprovalStatus parseByCode(String code) {
		return (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),code);
	}

}
