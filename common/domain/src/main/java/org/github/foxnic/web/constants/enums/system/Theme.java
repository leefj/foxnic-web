package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum Theme implements CodeTextEnum {

	DEFAULT("默认",new String[]{},new String[]{}),
	BLUE("蓝色主题",new String[]{"/assets/css/theme/blue.css"},new String[]{"/assets/css/theme/blue.js"}),
	ORANGE("橘色主题",new String[]{"/assets/css/theme/orange.css"},new String[]{"/assets/css/theme/orange.js"});

	private String[] css;
	private String[] js;
	private String text;

	private Theme(String text, String[] css,String[] js) {
		this.css=css;
		this.text=text;
		this.js=js;
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

	public String[] getJs() {
		return js;
	}

	public static Theme parseByCode(String code) {
		return (Theme) EnumUtil.parseByCode(Theme.values(),code);
	}
}
