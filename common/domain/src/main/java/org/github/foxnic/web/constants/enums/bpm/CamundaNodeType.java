package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * Camunda 流程节点类型
 * */
public enum CamundaNodeType implements CodeTextEnum {

	START_NODE("起始节点","StartEvent","start","startEvent"),
	USER_TASK("人工任务","UserTask","user","userTask"),
	SEQUENCE_FLOW("单一流向","SequenceFlow","sequence","sequenceFlow"),
	EXCLUSIVE_GATEWAY("决策网关","ExclusiveGateway","gateway","exclusiveGateway"),
	INTERMEDIATE_THROW_EVENT("中间事件","IntermediateThrowEvent","intermediate","intermediateThrowEvent"),
	SUB_PROCESS("子流程","SubProcess","process","subProcess"),
	DATA_OBJECT_REFERENCE("数据对象引用","DataObjectReference","object","dataObjectReference"),
	DATA_STORE_REFERENCE("数据存储引用","DataStoreReference","store","dataStoreReference"),
	END_EVENT("结束节点","EndEvent","end","endEvent");

	private String text;
	private String code;
	private String camundaEventName;
	private String camundaNodeType;
	private CamundaNodeType(String text,String code,String camundaEvent,String camundaNodeType)  {
		this.text=text;
		this.code=code;
		this.camundaEventName =camundaEvent;
		this.camundaNodeType=camundaNodeType;
	}

    public static CamundaNodeType parseByCamundaEvent(String camundaEvent) {
		for (CamundaNodeType value : CamundaNodeType.values()) {
			if(value.camundaEventName.equals(camundaEvent)) {
				return value;
			}
		}
		return null;
    }

    public String code() {
		return this.code;
	}

	public String text() {
		return text;
	}

	public String getCamundaEventName() {
		return camundaEventName;
	}

	public String getCamundaNodeType() {
		return camundaNodeType;
	}

	public static CamundaNodeType parseByCode(String code) {
		return (CamundaNodeType) EnumUtil.parseByCode(CamundaNodeType.values(),code);
	}

}
