package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;



/**
 * 任务处理参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-29 17:32:38
 * @sign D6B2FFFB7725EFD35CDA1C4CED1722AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskProcessVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String taskId;
	
	/**
	 * 审批人账户ID：审批人账户
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "审批人账户")
	private String assigneeUserId;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String comment;
	
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
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 流程实例ID
	 * @param taskId 流程实例ID
	 * @return 当前对象
	*/
	public TaskProcessVO setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 审批人账户ID<br>
	 * 审批人账户
	 * @return 审批人账户ID
	*/
	public String getAssigneeUserId() {
		return assigneeUserId;
	}
	
	/**
	 * 设置 审批人账户ID
	 * @param assigneeUserId 审批人账户ID
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeUserId(String assigneeUserId) {
		this.assigneeUserId=assigneeUserId;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getComment() {
		return comment;
	}
	
	/**
	 * 设置 审批意见
	 * @param comment 审批意见
	 * @return 当前对象
	*/
	public TaskProcessVO setComment(String comment) {
		this.comment=comment;
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
	public TaskProcessVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param pn 流程参数
	 * @return 当前对象
	*/
	public TaskProcessVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
}