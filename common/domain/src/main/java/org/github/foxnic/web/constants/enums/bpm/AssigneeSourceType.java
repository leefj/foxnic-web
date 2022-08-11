package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批人来源类型
 * */
public enum AssigneeSourceType implements CodeTextEnum {

	fixed_in_model("模型中固定选择的人员","#fixed_in_model"),internal_drafter("内部默认起草人","#internal_drafter");

	private String text;
	private String code;
	private AssigneeSourceType(String text,String code)  {
		this.text=text;
		this.code=code;
	}

	public String code() {
		return this.code;
	}

	public String text() {
		return text;
	}

	public static AssigneeSourceType parseByCode(String code) {
		return (AssigneeSourceType) EnumUtil.parseByCode(AssigneeSourceType.values(),code);
	}

}
