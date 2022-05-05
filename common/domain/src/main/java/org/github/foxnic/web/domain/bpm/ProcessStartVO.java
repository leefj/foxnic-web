package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;



/**
 * 流程启动参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-05 17:12:08
 * @sign FD820CA158ABE822D575BA472DD95DCA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessStartVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程发起前先要暂存流程实例，返回流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程发起前先要暂存流程实例，返回流程实例ID")
	private String processInstanceId;
	
	/**
	 * 发起人账户ID：如果不指定则默认为当前账户ID
	*/
	@ApiModelProperty(required = false,value="发起人账户ID" , notes = "如果不指定则默认为当前账户ID")
	private String drafterUserId;
	
	/**
	 * 发起人身份类型：发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值
	*/
	@ApiModelProperty(required = false,value="发起人身份类型" , notes = "发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值")
	private String drafterType;
	
	/**
	 * 发起人身份ID：发起人身份ID，如果未指定，则使用暂存值
	*/
	@ApiModelProperty(required = false,value="发起人身份ID" , notes = "发起人身份ID，如果未指定，则使用暂存值")
	private String drafterId;
	
	/**
	 * 流程参数：流程参数
	*/
	@ApiModelProperty(required = false,value="流程参数" , notes = "流程参数")
	private Map<String,Object> variables;
	
	/**
	 * 获得 流程实例ID<br>
	 * 流程发起前先要暂存流程实例，返回流程实例ID
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
	public ProcessStartVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 发起人账户ID<br>
	 * 如果不指定则默认为当前账户ID
	 * @return 发起人账户ID
	*/
	public String getDrafterUserId() {
		return drafterUserId;
	}
	
	/**
	 * 设置 发起人账户ID
	 * @param drafterUserId 发起人账户ID
	 * @return 当前对象
	*/
	public ProcessStartVO setDrafterUserId(String drafterUserId) {
		this.drafterUserId=drafterUserId;
		return this;
	}
	
	/**
	 * 获得 发起人身份类型<br>
	 * 发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值
	 * @return 发起人身份类型
	*/
	public String getDrafterType() {
		return drafterType;
	}
	
	/**
	 * 设置 发起人身份类型
	 * @param drafterType 发起人身份类型
	 * @return 当前对象
	*/
	public ProcessStartVO setDrafterType(String drafterType) {
		this.drafterType=drafterType;
		return this;
	}
	
	/**
	 * 获得 发起人身份ID<br>
	 * 发起人身份ID，如果未指定，则使用暂存值
	 * @return 发起人身份ID
	*/
	public String getDrafterId() {
		return drafterId;
	}
	
	/**
	 * 设置 发起人身份ID
	 * @param drafterId 发起人身份ID
	 * @return 当前对象
	*/
	public ProcessStartVO setDrafterId(String drafterId) {
		this.drafterId=drafterId;
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
	public ProcessStartVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param pn 流程参数
	 * @return 当前对象
	*/
	public ProcessStartVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
}