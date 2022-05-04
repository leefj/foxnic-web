package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;



/**
 * Camunda任务对象
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-03 06:46:14
 * @sign B2E1DAAE016AF4D1421672F7B6F4CB11
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CamundaTask {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String id;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 获得 任务ID<br>
	 * 任务ID
	 * @return 任务ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 任务ID
	 * @param id 任务ID
	 * @return 当前对象
	*/
	public CamundaTask setId(String id) {
		this.id=id;
		return this;
	}
	
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
	public CamundaTask setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
}