package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 流程废弃参数
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 * @sign 6B3AFF228474C4681624D93928824C03
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

	/**
	 * 创建一个 ProcessAbandonVO，等同于 new
	 * @return ProcessAbandonVO 对象
	*/
	@Transient
	public static ProcessAbandonVO create() {
		return new ProcessAbandonVO();
	}

	/**
	 * 将 Map 转换成 ProcessAbandonVO
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessAbandonVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessAbandonVO createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessAbandonVO po = new ProcessAbandonVO();
		BeanUtil.copy(processInstanceMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessAbandonVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessAbandonVO , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessAbandonVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessAbandonVO po = new ProcessAbandonVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessAbandonVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessAbandonVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessAbandonVO , 转换好的 PoJo 对象
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