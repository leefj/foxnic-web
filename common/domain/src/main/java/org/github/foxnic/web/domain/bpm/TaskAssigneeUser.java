package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import javax.persistence.Transient;
import java.util.Map;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.HashMap;



/**
 * 任务审批人账户
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-07 11:05:52
 * @sign D59DB9EB7E94161F0AF69CE6CAFE0BBF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskAssigneeUser {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String taskId;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态")
	private String taskStatus;
	@Transient
	private TaskStatus taskStatusEnum;
	
	/**
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID")
	private String userId;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private Map<String,Object> account;
	
	/**
	 * 账户名：账户名
	*/
	@ApiModelProperty(required = false,value="账户名" , notes = "账户名")
	private String realName;
	
	/**
	 * 审批人类型：审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "审批人类型")
	private String assigneeType;
	@Transient
	private UnifiedUserType assigneeTypeEnum;
	
	/**
	 * 审批人ID：审批人ID
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "审批人ID")
	private String assigneeId;
	
	/**
	 * 审批人名称：审批人名称
	*/
	@ApiModelProperty(required = false,value="审批人名称" , notes = "审批人名称")
	private String assigneeName;
	
	/**
	 * 获得 任务ID<br>
	 * 任务ID
	 * @return 任务ID
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务ID
	 * @param taskId 任务ID
	 * @return 当前对象
	*/
	public TaskAssigneeUser setTaskId(String taskId) {
		this.taskId=taskId;
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
	public TaskAssigneeUser setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public String getTaskStatus() {
		return taskStatus;
	}
	
	/**
	 * 获得 任务状态 的投影属性<br>
	 * 等价于 getTaskStatus 方法，获得对应的枚举类型
	 * @return 任务状态
	*/
	@Transient
	public TaskStatus getTaskStatusEnum() {
		if(this.taskStatusEnum==null) {
			this.taskStatusEnum = (TaskStatus) EnumUtil.parseByCode(TaskStatus.values(),taskStatus);
		}
		return this.taskStatusEnum ;
	}
	
	/**
	 * 设置 任务状态
	 * @param taskStatus 任务状态
	 * @return 当前对象
	*/
	public TaskAssigneeUser setTaskStatus(String taskStatus) {
		this.taskStatus=taskStatus;
		this.taskStatusEnum= (TaskStatus) EnumUtil.parseByCode(TaskStatus.values(),taskStatus) ;
		if(StringUtil.hasContent(taskStatus) && this.taskStatusEnum==null) {
			throw new IllegalArgumentException( taskStatus + " is not one of TaskStatus");
		}
		return this;
	}
	
	/**
	 * 设置 任务状态的投影属性，等同于设置 任务状态
	 * @param taskStatusEnum 任务状态
	 * @return 当前对象
	*/
	@Transient
	public TaskAssigneeUser setTaskStatusEnum(TaskStatus taskStatusEnum) {
		if(taskStatusEnum==null) {
			this.setTaskStatus(null);
		} else {
			this.setTaskStatus(taskStatusEnum.code());
		}
		this.taskStatusEnum=taskStatusEnum;
		return this;
	}
	
	/**
	 * 获得 账户ID<br>
	 * 账户ID
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
	public TaskAssigneeUser setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public Map<String,Object> getAccount() {
		return account;
	}
	
	/**
	 * 设置 账户
	 * @param account 账户
	 * @return 当前对象
	*/
	public TaskAssigneeUser setAccount(Map<String,Object> account) {
		this.account=account;
		return this;
	}
	
	/**
	 * 添加 账户
	 * @param key 键
	 * @param account 账户
	 * @return 当前对象
	*/
	public TaskAssigneeUser putAccount(String key,Object account) {
		if(this.account==null) this.account=new HashMap<>();
		this.account.put(key ,account);
		return this;
	}
	
	/**
	 * 获得 账户名<br>
	 * 账户名
	 * @return 账户名
	*/
	public String getRealName() {
		return realName;
	}
	
	/**
	 * 设置 账户名
	 * @param realName 账户名
	 * @return 当前对象
	*/
	public TaskAssigneeUser setRealName(String realName) {
		this.realName=realName;
		return this;
	}
	
	/**
	 * 获得 审批人类型<br>
	 * 审批人类型
	 * @return 审批人类型
	*/
	public String getAssigneeType() {
		return assigneeType;
	}
	
	/**
	 * 获得 审批人类型 的投影属性<br>
	 * 等价于 getAssigneeType 方法，获得对应的枚举类型
	 * @return 审批人类型
	*/
	@Transient
	public UnifiedUserType getAssigneeTypeEnum() {
		if(this.assigneeTypeEnum==null) {
			this.assigneeTypeEnum = (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),assigneeType);
		}
		return this.assigneeTypeEnum ;
	}
	
	/**
	 * 设置 审批人类型
	 * @param assigneeType 审批人类型
	 * @return 当前对象
	*/
	public TaskAssigneeUser setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		this.assigneeTypeEnum= (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),assigneeType) ;
		if(StringUtil.hasContent(assigneeType) && this.assigneeTypeEnum==null) {
			throw new IllegalArgumentException( assigneeType + " is not one of UnifiedUserType");
		}
		return this;
	}
	
	/**
	 * 设置 审批人类型的投影属性，等同于设置 审批人类型
	 * @param assigneeTypeEnum 审批人类型
	 * @return 当前对象
	*/
	@Transient
	public TaskAssigneeUser setAssigneeTypeEnum(UnifiedUserType assigneeTypeEnum) {
		if(assigneeTypeEnum==null) {
			this.setAssigneeType(null);
		} else {
			this.setAssigneeType(assigneeTypeEnum.code());
		}
		this.assigneeTypeEnum=assigneeTypeEnum;
		return this;
	}
	
	/**
	 * 获得 审批人ID<br>
	 * 审批人ID
	 * @return 审批人ID
	*/
	public String getAssigneeId() {
		return assigneeId;
	}
	
	/**
	 * 设置 审批人ID
	 * @param assigneeId 审批人ID
	 * @return 当前对象
	*/
	public TaskAssigneeUser setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}
	
	/**
	 * 获得 审批人名称<br>
	 * 审批人名称
	 * @return 审批人名称
	*/
	public String getAssigneeName() {
		return assigneeName;
	}
	
	/**
	 * 设置 审批人名称
	 * @param assigneeName 审批人名称
	 * @return 当前对象
	*/
	public TaskAssigneeUser setAssigneeName(String assigneeName) {
		this.assigneeName=assigneeName;
		return this;
	}
}