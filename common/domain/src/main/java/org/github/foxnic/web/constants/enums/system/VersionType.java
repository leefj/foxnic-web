package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum VersionType implements CodeTextEnum {

	DEV("开发版"),TEST("测试版"),SIT("集测版"),
	UAT("验收版"),PRE("预发版"),PROD("生产版");

	private String text;

	private VersionType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

}
