package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;



/**
 * 任务查询参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-17 15:49:11
 * @sign E76C4A6ADDAA1D4A02E56A279CE79AE8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CamundaTaskQueryVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 委托人、审批人账户ID：委托人、审批人账户
	*/
	@ApiModelProperty(required = false,value="委托人、审批人账户ID" , notes = "委托人、审批人账户")
	private String assigneeUserId;
	
	/**
	 * 分页大小：分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "分页大小")
	private Integer pageSize;
	
	/**
	 * 页码：页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "页码")
	private Integer pageIndex;
	
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
	public CamundaTaskQueryVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 委托人、审批人账户ID<br>
	 * 委托人、审批人账户
	 * @return 委托人、审批人账户ID
	*/
	public String getAssigneeUserId() {
		return assigneeUserId;
	}
	
	/**
	 * 设置 委托人、审批人账户ID
	 * @param assigneeUserId 委托人、审批人账户ID
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setAssigneeUserId(String assigneeUserId) {
		this.assigneeUserId=assigneeUserId;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * 分页大小
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 页码<br>
	 * 页码
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public CamundaTaskQueryVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
}