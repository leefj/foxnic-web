package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;



/**
 * 流程废弃参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-06 15:57:46
 * @sign D22AB907CF786D627BB67C3B5349AC05
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessAbandonVO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 废弃原因：废弃原因
	*/
	@ApiModelProperty(required = false,value="废弃原因" , notes = "废弃原因")
	private String reason;
	
	/**
	 * 是否强制删除：是否强制删除
	*/
	@ApiModelProperty(required = false,value="是否强制删除" , notes = "是否强制删除")
	private Boolean force;
	
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
	public ProcessAbandonVO setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 废弃原因<br>
	 * 废弃原因
	 * @return 废弃原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 废弃原因
	 * @param reason 废弃原因
	 * @return 当前对象
	*/
	public ProcessAbandonVO setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 是否强制删除<br>
	 * 是否强制删除
	 * @return 是否强制删除
	*/
	public Boolean isForce() {
		return force;
	}
	
	/**
	 * 获得 是否强制删除<br>
	 * 等价于 isForce 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否强制删除
	 * @return 是否强制删除
	*/
	public Boolean getForce() {
		return this.force;
	}
	
	/**
	 * 设置 是否强制删除
	 * @param force 是否强制删除
	 * @return 当前对象
	*/
	public ProcessAbandonVO setForce(Boolean force) {
		this.force=force;
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
	public ProcessAbandonVO setVariables(Map<String,Object> variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 添加 流程参数
	 * @param key 键
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public ProcessAbandonVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}
}