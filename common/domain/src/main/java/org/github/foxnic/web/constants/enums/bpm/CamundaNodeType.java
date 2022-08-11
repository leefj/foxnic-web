package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * Camunda 流程节点类型
 * */
public enum CamundaNodeType implements CodeTextEnum {

	start_node("起始节点","StartEvent","start","startEvent"),
	user_task("人工任务","UserTask","user","userTask"),
	sequence_flow("单一流向","SequenceFlow","sequence","sequenceFlow"),
	exclusive_gateway("决策网关","ExclusiveGateway","gateway","exclusiveGateway"),
	intermediate_throw_event("中间事件","IntermediateThrowEvent","intermediate","intermediateThrowEvent"),
	sub_process("子流程","SubProcess","process","subProcess"),
	data_object_reference("数据对象引用","DataObjectReference","object","dataObjectReference"),
	data_store_reference("数据存储引用","DataStoreReference","store","dataStoreReference"),
	end_event("结束节点","EndEvent","end","endEvent");

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
