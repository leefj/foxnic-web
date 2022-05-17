package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.AppovalReault;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.HashMap;



/**
 * 任务处理参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-17 13:45:28
 * @sign 802AE535AA9A281B55D62FB3E731677A
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
	 * 审批结果：审批结果
	*/
	@ApiModelProperty(required = false,value="审批结果" , notes = "审批结果")
	private String result;
	@Transient
	private AppovalReault resultEnum;
	
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
	public AppovalReault getResultEnum() {
		if(this.resultEnum==null) {
			this.resultEnum = (AppovalReault) EnumUtil.parseByCode(AppovalReault.values(),result);
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
		this.resultEnum= (AppovalReault) EnumUtil.parseByCode(AppovalReault.values(),result) ;
		if(StringUtil.hasContent(result) && this.resultEnum==null) {
			throw new IllegalArgumentException( result + " is not one of AppovalReault");
		}
		return this;
	}
	
	/**
	 * 设置 审批结果的投影属性，等同于设置 审批结果
	 * @param resultEnum 审批结果
	 * @return 当前对象
	*/
	@Transient
	public TaskProcessVO setResultEnum(AppovalReault resultEnum) {
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
}