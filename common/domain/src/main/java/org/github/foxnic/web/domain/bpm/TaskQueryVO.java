package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * 任务查询对象
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-18 14:52:04
 * @sign F0EFD896440D8340AB1EEB9179736B99
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskQueryVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账户ID：用于查询指定账户可处理的待办
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "用于查询指定账户可处理的待办")
	private String userId;
	
	/**
	 * 是否使用会话账户：userId 当 uerseId 未指定时是否使用会话账户
	*/
	@ApiModelProperty(required = false,value="是否使用会话账户" , notes = "userId 当 uerseId 未指定时是否使用会话账户")
	private Boolean useUserIdInSession;
	
	/**
	 * 流程实例ID：用于查询指定账户可处理的待办
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "用于查询指定账户可处理的待办")
	private String processInstanceId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态")
	private List<TaskStatus> statusList;
	
	/**
	 * 获得 账户ID<br>
	 * 用于查询指定账户可处理的待办
	 * @return 账户ID
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 账户ID
	 * @param userId 账户ID
	 * @return 当前对象
	*/
	public TaskQueryVO setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 是否使用会话账户<br>
	 * userId 当 uerseId 未指定时是否使用会话账户
	 * @return 是否使用会话账户
	*/
	public Boolean isUseUserIdInSession() {
		return useUserIdInSession;
	}
	
	/**
	 * 获得 是否使用会话账户<br>
	 * 等价于 isUseUserIdInSession 方法，为兼容 Swagger 需要
	 * 属性说明 : userId 当 uerseId 未指定时是否使用会话账户
	 * @return 是否使用会话账户
	*/
	public Boolean getUseUserIdInSession() {
		return this.useUserIdInSession;
	}
	
	/**
	 * 设置 是否使用会话账户
	 * @param useUserIdInSession 是否使用会话账户
	 * @return 当前对象
	*/
	public TaskQueryVO setUseUserIdInSession(Boolean useUserIdInSession) {
		this.useUserIdInSession=useUserIdInSession;
		return this;
	}
	
	/**
	 * 获得 流程实例ID<br>
	 * 用于查询指定账户可处理的待办
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
	public TaskQueryVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public List<TaskStatus> getStatusList() {
		return statusList;
	}
	
	/**
	 * 设置 任务状态
	 * @param statusList 任务状态
	 * @return 当前对象
	*/
	public TaskQueryVO setStatusList(List<TaskStatus> statusList) {
		this.statusList=statusList;
		return this;
	}
	
	/**
	 * 添加 任务状态
	 * @param status 任务状态
	 * @return 当前对象
	*/
	public TaskQueryVO addStatus(TaskStatus... status) {
		if(this.statusList==null) statusList=new ArrayList<>();
		this.statusList.addAll(Arrays.asList(status));
		return this;
	}
}