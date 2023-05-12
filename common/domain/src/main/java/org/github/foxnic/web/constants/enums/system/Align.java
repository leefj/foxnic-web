package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum Align implements CodeTextEnum {

	LEFT("靠左"),
	CENTER("居中"),
	RIGHT("靠右");
	private String text;

	private Align(String text) {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}

	public static Align parseByCode(String code) {
		return (Align) EnumUtil.parseByCode(Align.values(),code);
	}
}
