package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_ASSIGNEE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程任务处理人
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-11 13:32:18
 * @sign EAB0D3998FC2AD40DE0CBC3326CA3C1C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task_assignee")
public class TaskAssignee extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK_ASSIGNEE.$TABLE;

	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;

	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;

	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String taskId;

	/**
	 * 审批人类型：预计的审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "预计的审批人类型")
	private String assigneeType;

	/**
	 * 审批人ID：预计的审批人
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "预计的审批人")
	private String assigneeId;

	/**
	 * create_by：create_by
	*/
	@ApiModelProperty(required = false,value="create_by" , notes = "create_by")
	private String createBy;

	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;

	/**
	 * update_by：update_by
	*/
	@ApiModelProperty(required = false,value="update_by" , notes = "update_by")
	private String updateBy;

	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;

	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	private Boolean deletedBool;

	/**
	 * delete_by：delete_by
	*/
	@ApiModelProperty(required = false,value="delete_by" , notes = "delete_by")
	private String deleteBy;

	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;

	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;

	/**
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id")
	private String tenantId;

	/**
	 * 审批人：审批人
	*/
	@ApiModelProperty(required = false,value="审批人" , notes = "审批人")
	private Assignee assignee;

	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}

	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public TaskAssignee setId(String id) {
		this.id=id;
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
	public TaskAssignee setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}

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
	public TaskAssignee setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}

	/**
	 * 获得 审批人类型<br>
	 * 预计的审批人类型
	 * @return 审批人类型
	*/
	public String getAssigneeType() {
		return assigneeType;
	}

	/**
	 * 设置 审批人类型
	 * @param assigneeType 审批人类型
	 * @return 当前对象
	*/
	public TaskAssignee setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		return this;
	}

	/**
	 * 获得 审批人ID<br>
	 * 预计的审批人
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
	public TaskAssignee setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}

	/**
	 * 获得 create_by<br>
	 * create_by
	 * @return create_by
	*/
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 create_by
	 * @param createBy create_by
	 * @return 当前对象
	*/
	public TaskAssignee setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}

	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public TaskAssignee setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 获得 update_by<br>
	 * update_by
	 * @return update_by
	*/
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 update_by
	 * @param updateBy update_by
	 * @return 当前对象
	*/
	public TaskAssignee setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}

	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public TaskAssignee setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}

	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}

	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public TaskAssignee setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}

	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public TaskAssignee setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}

	/**
	 * 获得 delete_by<br>
	 * delete_by
	 * @return delete_by
	*/
	public String getDeleteBy() {
		return deleteBy;
	}

	/**
	 * 设置 delete_by
	 * @param deleteBy delete_by
	 * @return 当前对象
	*/
	public TaskAssignee setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}

	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}

	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public TaskAssignee setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}

	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}

	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public TaskAssignee setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 获得 tenant_id<br>
	 * tenant_id
	 * @return tenant_id
	*/
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * 设置 tenant_id
	 * @param tenantId tenant_id
	 * @return 当前对象
	*/
	public TaskAssignee setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 获得 审批人<br>
	 * 审批人
	 * @return 审批人
	*/
	public Assignee getAssignee() {
		return assignee;
	}

	/**
	 * 设置 审批人
	 * @param assignee 审批人
	 * @return 当前对象
	*/
	public TaskAssignee setAssignee(Assignee assignee) {
		this.assignee=assignee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TaskAssignee , 转换好的 TaskAssignee 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskAssignee , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
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
	 * 将 Map 转换成 TaskAssignee
	 * @param taskAssigneeMap 包含实体信息的 Map 对象
	 * @return TaskAssignee , 转换好的的 TaskAssignee 对象
	*/
	@Transient
	public static TaskAssignee createFrom(Map<String,Object> taskAssigneeMap) {
		if(taskAssigneeMap==null) return null;
		TaskAssignee po = EntityContext.create(TaskAssignee.class, taskAssigneeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskAssignee
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskAssignee , 转换好的的 TaskAssignee 对象
	*/
	@Transient
	public static TaskAssignee createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskAssignee po = EntityContext.create(TaskAssignee.class,pojo);
		return po;
	}

	/**
	 * 创建一个 TaskAssignee，等同于 new
	 * @return TaskAssignee 对象
	*/
	@Transient
	public static TaskAssignee create() {
		return EntityContext.create(TaskAssignee.class);
	}
}
