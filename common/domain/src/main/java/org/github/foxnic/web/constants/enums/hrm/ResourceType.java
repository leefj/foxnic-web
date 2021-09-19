package org.github.foxnic.web.constants.enums.hrm;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum ResourceType implements CodeTextEnum {
	page("页面"),api("接口");
	private String text;
	private ResourceType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

}
