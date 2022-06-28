package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批状态
 * */
public enum DemoStatus implements CodeTextEnum {

	drafting("起草中"),approving("审批中"), passed("已通过"),rejected("已驳回");

	private String text;
	private DemoStatus(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static DemoStatus parseByCode(String code) {
		return (DemoStatus) EnumUtil.parseByCode(DemoStatus.values(),code);
	}

}
