package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ApproveCatalog implements CodeTextEnum {

	drafted("我起草的流程"),approving("我待批的流程"),approved("我办结的流程");

	private String text;
	private ApproveCatalog(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ApproveCatalog parseByCode(String code) {
		return (ApproveCatalog) EnumUtil.parseByCode(ApproveCatalog.values(),code);
	}

}
