package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 流程启动参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 * @sign C4E84A3AF83F0CB35CD0873D88930A73
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
	 * @param variable 流程参数
	 * @return 当前对象
	*/
	public ProcessStartVO putVariable(String key,Object variable) {
		if(this.variables==null) this.variables=new HashMap<>();
		this.variables.put(key ,variable);
		return this;
	}

	/**
	 * 创建一个 ProcessStartVO，等同于 new
	 * @return ProcessStartVO 对象
	*/
	@Transient
	public static ProcessStartVO create() {
		return new ProcessStartVO();
	}

	/**
	 * 将 Map 转换成 ProcessStartVO
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessStartVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessStartVO createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessStartVO po = new ProcessStartVO();
		BeanUtil.copy(processInstanceMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessStartVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessStartVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessStartVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessStartVO po = new ProcessStartVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessStartVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessStartVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessStartVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)EntityContext.create((Class<? extends Entity>) pojoType,this);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}