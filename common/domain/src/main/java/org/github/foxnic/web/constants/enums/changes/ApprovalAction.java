package org.github.foxnic.web.constants.enums.changes;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum ApprovalAction implements CodeTextEnum {

	draft("流程起草"),submit("流程提交"),fetch_back("流程撤回"),
	agree("节点同意"),agree_cond("节点有条件同意"),
	reject("节点驳回"),
	/**
	 * 不涉及，跳过审批
	 * */
	skip("跳过"),
	/**
	 * 跳转到任意节点，一般是管理员操作的
	 * */
	jump("节点跳转"),
	/**
	 * 转办
	 * */
	replace_approver("转办"),
	abandon("流程作废");

	private String text;


	private ApprovalAction(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}



	public static ApprovalAction parseByCode(String code) {
		return (ApprovalAction) EnumUtil.parseByCode(ApprovalAction.values(),code);
	}

}
