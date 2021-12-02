package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum Theme implements CodeTextEnum {

	DEFAULT("默认",new String[]{}),
	BLUE("蓝色主题",new String[]{"/assets/css/theme-blue.css"}),
	ORANGE("橘色主题",new String[]{"assets/css/theme-orange.css"});

	private String[] css;
	private String text;

	private Theme(String text, String[] css) {
		this.css=css;
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}

	@Override
	public String description() {
		return this.text();
	}

	public String[] getCss() {
		return css;
	}

	public static Theme parseByCode(String code) {
		return (Theme) EnumUtil.parseByCode(Theme.values(),code);
	}
}
