package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum Theme implements CodeTextEnum {

	DEFAULT("默认",new String[]{},new String[]{},"/","index"),
	BLUE("蓝色主题",new String[]{"/assets/css/theme/blue.css"},new String[]{"/assets/css/theme/blue.js"},"/","index"),
	ORANGE("橘色主题",new String[]{"/assets/css/theme/orange.css"},new String[]{"/assets/css/theme/orange.js"},"/","index"),
	PEAR("PEAR",new String[]{"/console/pear/component/pear/css/pear-support.css"},new String[]{"/console/pear/component/pear/css/pear-support.js"},"/console/pear","console/pear/index");

	private String[] css;
	private String[] js;
	private String text;

	private String baseDir;
	private String indexTemplatePath;


	private Theme(String text, String[] css,String[] js,String baseDir, String indexTemplatePath) {
		this.css=css;
		this.text=text;
		this.js=js;
		this.baseDir=baseDir;
		this.indexTemplatePath=indexTemplatePath;
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

	public String getBaseDir() {
		return baseDir;
	}

	public String getIndexTemplatePath() {
		return indexTemplatePath;
	}

	public static Theme parseByCode(String code) {
		return (Theme) EnumUtil.parseByCode(Theme.values(),code);
	}
}
