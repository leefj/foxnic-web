package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;



/**
 * 任务查询对象
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 * @sign 262FEC1D2243F4F0A869401B7EDD19FD
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

	/**
	 * 创建一个 TaskQueryVO，等同于 new
	 * @return TaskQueryVO 对象
	*/
	@Transient
	public static TaskQueryVO create() {
		return new TaskQueryVO();
	}

	/**
	 * 将 Map 转换成 TaskQueryVO
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return TaskQueryVO , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskQueryVO createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		TaskQueryVO po = new TaskQueryVO();
		BeanUtil.copy(taskMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskQueryVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskQueryVO , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskQueryVO createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskQueryVO po = new TaskQueryVO();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskQueryVO clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskQueryVO clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskQueryVO , 转换好的 PoJo 对象
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