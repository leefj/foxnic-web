package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ChangeStatus implements CodeTextEnum {
	prepare("待审批"),approving("审批中"),pass("已通过"),reject("已驳回"),abandon("已废弃");

	private String text;
	private ChangeStatus(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ChangeStatus parseByCode(String code) {
		return (ChangeStatus) EnumUtil.parseByCode(ChangeStatus.values(),code);
	}

}
