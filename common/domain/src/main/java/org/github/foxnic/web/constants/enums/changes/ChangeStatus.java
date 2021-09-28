package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ChangeStatus implements CodeTextEnum {
	none("无变更"),changing("变更中"),done("已完成"),reject("驳回");

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
