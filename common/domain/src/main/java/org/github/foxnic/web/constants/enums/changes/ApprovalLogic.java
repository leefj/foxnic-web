package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批逻辑，简单审批模式下适用
 * */
public enum ApprovalLogic implements CodeTextEnum {
	/**
	 * 以第一个审批人的意见为准
	 * */
	any("常规"),
	/**
	 * 需要全部审批人通过
	 * */
	all("会审");

	private String text;
	private ApprovalLogic(String text)  {
		this.text=text;
	}
	
	public String code() {
		return this.name();
	}
	
	public String text() {
		return text;
	}

	public static ApprovalLogic parseByCode(String code) {
		return (ApprovalLogic) EnumUtil.parseByCode(ApprovalLogic.values(),code);
	}

}
