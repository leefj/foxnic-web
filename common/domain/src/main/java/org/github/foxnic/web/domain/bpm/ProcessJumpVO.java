package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;



/**
 * 流程跳转参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-28 16:15:24
 * @sign E3DEC1658C019F594460B8B90D5621D5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessJumpVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 目标节点ID：目标节点ID,CamundaNodeId
	*/
	@ApiModelProperty(required = false,value="目标节点ID" , notes = "目标节点ID,CamundaNodeId")
	private String jumpToNodeId;
	
	/**
	 * 跳转原因：跳转原因
	*/
	@ApiModelProperty(required = false,value="跳转原因" , notes = "跳转原因")
	private String reason;
	
	/**
	 * 流程参数：流程参数
	*/
	@ApiModelProperty(required = false,value="流程参数" , notes = "流程参数")
	private Map<String,Object> variables;
	
	/**
	 * 获得 流程实例ID<br>
	 * 流程实例ID
	 * @return 流程实例ID
	*/
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	
	/**
	 * 设置 流程实例ID
	 * @param processInstanceId 流程实例ID
	 * @return 当前对象
	*/
	public ProcessJumpVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 目标节点ID<br>
	 * 目标节点ID,CamundaNodeId
	 * @return 目标节点ID
	*/
	public String getJumpToNodeId() {
		return jumpToNodeId;
	}
	
	/**
	 * 设置 目标节点ID
	 * @param jumpToNodeId 目标节点ID
	 * @return 当前对象
	*/
	public ProcessJumpVO setJumpToNodeId(String jumpToNodeId) {
		this.jumpToNodeId=jumpToNodeId;
		return this;
	}
	
	/**
	 * 获得 跳转原因<br>
	 * 跳转原因
	 * @return 跳转原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 跳转原因
	 * @param reason 跳转原因
	 * @return 当前对象
	*/
	public ProcessJumpVO setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 流程参数<br>
	 * 流程参数
	 * @return 流程参数
	*/
	public Map<String,Object> getVariables() {
		return variables;
	}
	
	/**
	 * 设置 流程参数
	 * @param variables 流程参数
	 * @return 当前对象
	*/
	public ProcessJumpVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public ProcessJumpVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
}