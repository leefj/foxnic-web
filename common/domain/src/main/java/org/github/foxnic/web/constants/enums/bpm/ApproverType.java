package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ApproverType implements CodeTextEnum {

	employee("员工"),bpm_role("流程角色");

	private String text;
	private ApproverType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ApproverType parseByCode(String code) {
		return (ApproverType) EnumUtil.parseByCode(ApproverType.values(),code);
	}

}
