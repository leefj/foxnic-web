package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批结果
 * */
public enum ApprovalResult implements CodeTextEnum {

	agree("同意",true),
	agree_cond("有条件同意",true),
	reject("驳回",true),
	/**
	 * 不涉及，跳过审批
	 * */
	skip("跳过",true),
	fetch_back("撤回",true),

	resubmit("再次提交",false),
	abandon("废弃",false);

	private boolean display;
	private String text;
	private ApprovalResult(String text,boolean display)  {
		this.text=text;
		this.display=display;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	@Override
	public boolean display() {
		return display;
	}

	public static ApprovalResult parseByCode(String code) {
		return (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),code);
	}

}
