package org.github.foxnic.web.constants.enums.system;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 资源访问控制类型
 * */
public enum IndexPageTemplate implements CodeTextEnum {
	DEFAULT("默认","/","index"),
	PEAR("Pear","/console/pear","console/pear/index");
	private String text;
	private String baseDir;
	private String templatePath;

	private IndexPageTemplate(String text, String baseDir, String templatePath) {
		this.baseDir=baseDir;
		this.templatePath=templatePath;
		this.text=text;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return this.text;
	}



	public static IndexPageTemplate parseByCode(String code) {
		return (IndexPageTemplate) EnumUtil.parseByCode(IndexPageTemplate.values(),code);
	}
}
