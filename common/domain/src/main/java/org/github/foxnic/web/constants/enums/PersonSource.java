package org.github.foxnic.web.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;

/**
 * 人员的创建来源
 * */
public enum PersonSource implements CodeTextEnum {
	employee("员工管理");

	private String text;
	private PersonSource(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}
}
