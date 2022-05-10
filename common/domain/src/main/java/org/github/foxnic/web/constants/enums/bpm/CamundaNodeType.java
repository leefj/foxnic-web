package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 审批结果
 * */
public enum CamundaNodeType implements CodeTextEnum {

	START_NODE("起始节点","StartEvent"),
	USER_TASK("人工任务","UserTask"),
	SEQUENCE_FLOW("单一流向","SequenceFlow"),
	/**
	 * 不涉及，跳过审批
	 * */
	END_EVENT("结束节点","EndEvent");

	private String text;
	private String code;
	private CamundaNodeType(String text,String code)  {
		this.text=text;
		this.code=code;
	}

	public String code() {
		return this.code;
	}

	public String text() {
		return text;
	}

	public static CamundaNodeType parseByCode(String code) {
		return (CamundaNodeType) EnumUtil.parseByCode(CamundaNodeType.values(),code);
	}

}
