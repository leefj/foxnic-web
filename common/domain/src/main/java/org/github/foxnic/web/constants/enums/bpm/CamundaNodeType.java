package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * Camunda 流程节点类型
 * */
public enum CamundaNodeType implements CodeTextEnum {

	START_NODE("起始节点","StartEvent"),
	USER_TASK("人工任务","UserTask"),
	SEQUENCE_FLOW("单一流向","SequenceFlow"),
	EXCLUSIVE_GATEWAY("决策网关","ExclusiveGateway"),
	INTERMEDIATE_THROW_EVENT("中间事件","IntermediateThrowEvent"),
	SUB_PROCESS("子流程","SubProcess"),
	DATA_OBJECT_REFERENCE("数据对象引用","DataObjectReference"),
	DATA_STORE_REFERENCE("数据存储引用","DataStoreReference"),
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
