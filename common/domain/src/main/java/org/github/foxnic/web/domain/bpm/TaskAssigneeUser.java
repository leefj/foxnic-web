package org.github.foxnic.web.domain.bpm;

import io.swagger.annotations.ApiModel;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Map;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.HashMap;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.bpm.meta.TaskAssigneeUserMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务审批人账户
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-28 06:40:58
 * @sign AD4E2E92D5F108E3E7A0F1F7C4C487A9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel()
public class TaskAssigneeUser {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 任务ID：任务ID
	*/
	private String taskId;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	private String processInstanceId;
	
	/**
	 * 任务状态：任务状态
	*/
	private String taskStatus;
	@Transient
	@EnumFor("taskStatus")
	private TaskStatus taskStatusEnum;
	
	/**
	 * 账户ID：账户ID
	*/
	private String userId;
	
	/**
	 * 账户：账户
	*/
	private Map<String,Object> account;
	
	/**
	 * 账户名：账户名
	*/
	private String realName;
	
	/**
	 * 审批人类型：审批人类型
	*/
	private String assigneeType;
	@Transient
	@EnumFor("assigneeType")
	private UnifiedUserType assigneeTypeEnum;
	
	/**
	 * 审批人ID：审批人ID
	*/
	private String assigneeId;
	
	/**
	 * 审批人名称：审批人名称
	*/
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
	@JsonProperty("taskStatus")
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
	@JsonProperty("assigneeType")
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

	/**
	 * 创建一个 TaskAssigneeUser，等同于 new
	 * @return TaskAssigneeUser 对象
	*/
	@Transient
	public static TaskAssigneeUser create() {
		return new TaskAssigneeUser();
	}

	/**
	 * 将 Map 转换成 TaskAssigneeUser
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return TaskAssigneeUser , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskAssigneeUser createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		TaskAssigneeUser po = new TaskAssigneeUser();
		BeanUtil.copy(taskMap,po);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskAssigneeUser
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskAssigneeUser , 转换好的的 Task 对象
	*/
	@Transient
	public static TaskAssigneeUser createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskAssigneeUser po = new TaskAssigneeUser();
		BeanUtil.copy(pojo,po,true);
		return po;
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskAssigneeUser duplicate(boolean all) {
		TaskAssigneeUser inst = new TaskAssigneeUser();
		// others
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setRealName(this.getRealName());
			inst.setAssigneeName(this.getAssigneeName());
			inst.setAssigneeType(this.getAssigneeType());
			inst.setUserId(this.getUserId());
			inst.setAssigneeId(this.getAssigneeId());
			inst.setTaskId(this.getTaskId());
			inst.setTaskStatus(this.getTaskStatus());
			inst.setAccount(this.getAccount());
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskAssigneeUser clone() {
		return BeanUtil.clone(this,false);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskAssigneeUser clone(boolean deep) {
		return BeanUtil.clone(this,deep);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskAssigneeUser , 转换好的 PoJo 对象
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

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			// others
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.PROCESS_INSTANCE_ID)));
			this.setRealName(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.REAL_NAME)));
			this.setAssigneeName(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.ASSIGNEE_NAME)));
			this.setAssigneeType(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.ASSIGNEE_TYPE)));
			this.setUserId(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.USER_ID)));
			this.setAssigneeId(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.ASSIGNEE_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.TASK_ID)));
			this.setTaskStatus(DataParser.parse(String.class, map.get(TaskAssigneeUserMeta.TASK_STATUS)));
			return true;
		} else {
			try {
				// others
				this.setProcessInstanceId( (String)map.get(TaskAssigneeUserMeta.PROCESS_INSTANCE_ID));
				this.setRealName( (String)map.get(TaskAssigneeUserMeta.REAL_NAME));
				this.setAssigneeName( (String)map.get(TaskAssigneeUserMeta.ASSIGNEE_NAME));
				this.setAssigneeType( (String)map.get(TaskAssigneeUserMeta.ASSIGNEE_TYPE));
				this.setUserId( (String)map.get(TaskAssigneeUserMeta.USER_ID));
				this.setAssigneeId( (String)map.get(TaskAssigneeUserMeta.ASSIGNEE_ID));
				this.setTaskId( (String)map.get(TaskAssigneeUserMeta.TASK_ID));
				this.setTaskStatus( (String)map.get(TaskAssigneeUserMeta.TASK_STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			return true;
		} else {
			try {
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}