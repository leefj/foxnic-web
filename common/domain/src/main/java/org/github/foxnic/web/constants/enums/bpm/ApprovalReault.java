package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批结果
 * */
public enum ApprovalReault implements CodeTextEnum {

	agree("同意"),
	agree_cond("有条件同意"),
	reject("驳回"),
	/**
	 * 不涉及，跳过审批
	 * */
	skip("跳过"),
	fetch_back("撤回");

	private boolean display;
	private String text;
	private ApprovalReault(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static ApprovalReault parseByCode(String code) {
		return (ApprovalReault) EnumUtil.parseByCode(ApprovalReault.values(),code);
	}

}
