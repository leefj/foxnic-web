package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum Language implements CodeTextEnum {
	defaults("默认语言"),zh_ch("中文简体"),zh_tw("中文繁体"),en_us("English-US"),en_uk("English-UK"),confuse("混淆");
 
	private String text;
	private Language(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

}
