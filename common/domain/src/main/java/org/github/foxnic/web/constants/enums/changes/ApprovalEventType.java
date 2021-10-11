package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ApprovalEventType implements CodeTextEnum {
	create_success("创建成功"),create_failure("创建失败"),internal_error("内部错误"),
	revoke_success("撤回成功"),abandon_success("废弃成功"),agree_success("同意成功"),
	reject_success("驳回成功"),submit_success("提交成功");

	private String text;
	private ApprovalEventType(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ApprovalEventType parseByCode(String code) {
		return (ApprovalEventType) EnumUtil.parseByCode(ApprovalEventType.values(),code);
	}

}
