package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 驳回配置项，流程在驳回时的表现
 * */
public enum RejectOption implements CodeTextEnum {

	abandon_process("废弃流程"),fetch_back("撤回"),choose_node("选择节点");

	private String text;
	private RejectOption(String text)  {
		this.text=text;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static RejectOption parseByCode(String code) {
		return (RejectOption) EnumUtil.parseByCode(RejectOption.values(),code);
	}

}
