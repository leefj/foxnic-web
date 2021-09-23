package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum MenuType implements CodeTextEnum {
	folder("目录"),page("页面"),api("接口"),function("功能点");
 
	private String text;
	private MenuType(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static MenuType parseByCode(String code) {
		return (MenuType) EnumUtil.parseByCode(MenuType.values(),code);
	}
}
