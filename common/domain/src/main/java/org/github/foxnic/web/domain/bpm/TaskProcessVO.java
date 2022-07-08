package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.HashMap;



/**
 * 任务处理参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-08 09:44:32
 * @sign 26F893ED5C4C9BE4E819D74A551EF02E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskProcessVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String taskId;
	
	/**
	 * 审批人账户ID：审批人账户
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "审批人账户")
	private String assigneeUserId;
	
	/**
	 * 审批人身份类型：审批人身份类型
	*/
	@ApiModelProperty(required = false,value="审批人身份类型" , notes = "审批人身份类型")
	private String assigneeType;
	
	/**
	 * 审批人身份ID：审批人身份ID
	*/
	@ApiModelProperty(required = false,value="审批人身份ID" , notes = "审批人身份ID")
	private String assigneeId;
	
	/**
	 * 审批结果：审批结果
	*/
	@ApiModelProperty(required = false,value="审批结果" , notes = "审批结果")
	private String result;
	@Transient
	private ApprovalResult resultEnum;
	
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
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
	/**
	 * 流程跳转的目标节点ID：流程跳转的目标节点ID
	*/
	@ApiModelProperty(required = false,value="流程跳转的目标节点ID" , notes = "流程跳转的目标节点ID")
	private String jumpToNodeId;
	
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
	 * 获得 审批人身份类型<br>
	 * 审批人身份类型
	 * @return 审批人身份类型
	*/
	public String getAssigneeType() {
		return assigneeType;
	}
	
	/**
	 * 设置 审批人身份类型
	 * @param assigneeType 审批人身份类型
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		return this;
	}
	
	/**
	 * 获得 审批人身份ID<br>
	 * 审批人身份ID
	 * @return 审批人身份ID
	*/
	public String getAssigneeId() {
		return assigneeId;
	}
	
	/**
	 * 设置 审批人身份ID
	 * @param assigneeId 审批人身份ID
	 * @return 当前对象
	*/
	public TaskProcessVO setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}
	
	/**
	 * 获得 审批结果<br>
	 * 审批结果
	 * @return 审批结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 获得 审批结果 的投影属性<br>
	 * 等价于 getResult 方法，获得对应的枚举类型
	 * @return 审批结果
	*/
	@Transient
	public ApprovalResult getResultEnum() {
		if(this.resultEnum==null) {
			this.resultEnum = (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),result);
		}
		return this.resultEnum ;
	}
	
	/**
	 * 设置 审批结果
	 * @param result 审批结果
	 * @return 当前对象
	*/
	public TaskProcessVO setResult(String result) {
		this.result=result;
		this.resultEnum= (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),result) ;
		if(StringUtil.hasContent(result) && this.resultEnum==null) {
			throw new IllegalArgumentException( result + " is not one of ApprovalResult");
		}
		return this;
	}
	
	/**
	 * 设置 审批结果的投影属性，等同于设置 审批结果
	 * @param resultEnum 审批结果
	 * @return 当前对象
	*/
	@Transient
	public TaskProcessVO setResultEnum(ApprovalResult resultEnum) {
		if(resultEnum==null) {
			this.setResult(null);
		} else {
			this.setResult(resultEnum.code());
		}
		this.resultEnum=resultEnum;
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
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public TaskProcessVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public TaskProcessVO setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程跳转的目标节点ID<br>
	 * 流程跳转的目标节点ID
	 * @return 流程跳转的目标节点ID
	*/
	public String getJumpToNodeId() {
		return jumpToNodeId;
	}
	
	/**
	 * 设置 流程跳转的目标节点ID
	 * @param jumpToNodeId 流程跳转的目标节点ID
	 * @return 当前对象
	*/
	public TaskProcessVO setJumpToNodeId(String jumpToNodeId) {
		this.jumpToNodeId=jumpToNodeId;
		return this;
	}
}