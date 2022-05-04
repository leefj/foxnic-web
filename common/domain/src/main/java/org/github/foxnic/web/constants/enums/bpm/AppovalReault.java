package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批结果
 * */
public enum AppovalReault implements CodeTextEnum {

	agree("同意"),
	agree_cond("有条件"),
	disagree("不同意"),
	/**
	 * 不涉及，跳过审批
	 * */
	skip("跳过");

	private String text;
	private AppovalReault(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static AppovalReault parseByCode(String code) {
		return (AppovalReault) EnumUtil.parseByCode(AppovalReault.values(),code);
	}

}
