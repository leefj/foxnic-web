package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.TaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程任务
 * <p>流程任务 , 数据表 bpm_task 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 15:57:41
 * @sign 79A8E74A5A5E477DA7551C9257BE7C6F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task")
@ApiModel(description = "流程任务 ; 流程任务 , 数据表 bpm_task 的PO类型")
public class Task extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id" , example = "681081982213423104")
	private String id;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID" , example = "680090042923745280")
	private String processDefinitionId;
	
	/**
	 * 节点ID：节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "节点ID" , example = "680095924969537536")
	private String nodeId;
	
	/**
	 * 节点名称：节点名称
	*/
	@ApiModelProperty(required = false,value="节点名称" , notes = "节点名称" , example = "商务来案")
	private String nodeName;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID" , example = "681076426912301056")
	private String processInstanceId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态" , example = "done")
	private String status;
	@Transient
	@EnumFor("status")
	private TaskStatus statusEnum;
	
	/**
	 * 原因：状态变更的原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "状态变更的原因")
	private String statusReason;
	
	/**
	 * 最后处理时间：最后处理时间
	*/
	@ApiModelProperty(required = false,value="最后处理时间" , notes = "最后处理时间" , example = "2023-02-23 10:16:40")
	private Date approvalTime;
	
	/**
	 * 任务ID：Camunda 任务ID
	*/
	@ApiModelProperty(required = true,value="任务ID" , notes = "Camunda 任务ID" , example = "05cc1e9d-b31d-11ed-acb0-1268e6e59107")
	private String camundaTaskId;
	
	/**
	 * cam中指定的审批人：cam中指定的审批人
	*/
	@ApiModelProperty(required = false,value="cam中指定的审批人" , notes = "cam中指定的审批人" , example = "#internal_drafter")
	private String camundaAssignee;
	
	/**
	 * create_by：create_by
	*/
	@ApiModelProperty(required = false,value="create_by" , notes = "create_by")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-02-23 09:54:35")
	private Date createTime;
	
	/**
	 * update_by：update_by
	*/
	@ApiModelProperty(required = false,value="update_by" , notes = "update_by")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-02-23 10:16:40")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id" , example = "T001")
	private String tenantId;
	
	/**
	 * 流程类型：流程类型
	*/
	@ApiModelProperty(required = false,value="流程类型" , notes = "流程类型")
	private ProcessDefinition processDefinition;
	
	/**
	 * 流程实例：流程实例
	*/
	@ApiModelProperty(required = false,value="流程实例" , notes = "流程实例")
	private ProcessInstance processInstance;
	
	/**
	 * 审批动作清单：审批动作清单
	*/
	@ApiModelProperty(required = false,value="审批动作清单" , notes = "审批动作清单")
	private List<TaskApproval> approvals;
	
	/**
	 * 审批人清单：审批人清单
	*/
	@ApiModelProperty(required = false,value="审批人清单" , notes = "审批人清单")
	private List<TaskAssignee> assignees;
	
	/**
	 * 审批人账户清单：审批人账户清单
	*/
	@ApiModelProperty(required = false,value="审批人账户清单" , notes = "审批人账户清单")
	private List<TaskAssigneeUser> assigneeUsers;
	
	/**
	 * 流程节点：流程节点
	*/
	@ApiModelProperty(required = false,value="流程节点" , notes = "流程节点")
	private ProcessDefinitionNode node;
	
	/**
	 * 已读清单：已读人员清单
	*/
	@ApiModelProperty(required = false,value="已读清单" , notes = "已读人员清单")
	private List<TaskRead> readers;
	
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
	public Task setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程定义ID<br>
	 * 流程定义ID
	 * @return 流程定义ID
	*/
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	
	/**
	 * 设置 流程定义ID
	 * @param processDefinitionId 流程定义ID
	 * @return 当前对象
	*/
	public Task setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 节点ID<br>
	 * 节点ID
	 * @return 节点ID
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点ID
	 * @param nodeId 节点ID
	 * @return 当前对象
	*/
	public Task setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 节点名称<br>
	 * 节点名称
	 * @return 节点名称
	*/
	public String getNodeName() {
		return nodeName;
	}
	
	/**
	 * 设置 节点名称
	 * @param nodeName 节点名称
	 * @return 当前对象
	*/
	public Task setNodeName(String nodeName) {
		this.nodeName=nodeName;
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
	public Task setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 获得 任务状态 的投影属性<br>
	 * 等价于 getStatus 方法，获得对应的枚举类型
	 * @return 任务状态
	*/
	@Transient
	public TaskStatus getStatusEnum() {
		if(this.statusEnum==null) {
			this.statusEnum = (TaskStatus) EnumUtil.parseByCode(TaskStatus.values(),status);
		}
		return this.statusEnum ;
	}
	
	/**
	 * 设置 任务状态
	 * @param status 任务状态
	 * @return 当前对象
	*/
	@JsonProperty("status")
	public Task setStatus(String status) {
		this.status=status;
		this.statusEnum= (TaskStatus) EnumUtil.parseByCode(TaskStatus.values(),status) ;
		if(StringUtil.hasContent(status) && this.statusEnum==null) {
			throw new IllegalArgumentException( status + " is not one of TaskStatus");
		}
		return this;
	}
	
	/**
	 * 设置 任务状态的投影属性，等同于设置 任务状态
	 * @param statusEnum 任务状态
	 * @return 当前对象
	*/
	@Transient
	public Task setStatusEnum(TaskStatus statusEnum) {
		if(statusEnum==null) {
			this.setStatus(null);
		} else {
			this.setStatus(statusEnum.code());
		}
		this.statusEnum=statusEnum;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 状态变更的原因
	 * @return 原因
	*/
	public String getStatusReason() {
		return statusReason;
	}
	
	/**
	 * 设置 原因
	 * @param statusReason 原因
	 * @return 当前对象
	*/
	public Task setStatusReason(String statusReason) {
		this.statusReason=statusReason;
		return this;
	}
	
	/**
	 * 获得 最后处理时间<br>
	 * 最后处理时间
	 * @return 最后处理时间
	*/
	public Date getApprovalTime() {
		return approvalTime;
	}
	
	/**
	 * 设置 最后处理时间
	 * @param approvalTime 最后处理时间
	 * @return 当前对象
	*/
	public Task setApprovalTime(Date approvalTime) {
		this.approvalTime=approvalTime;
		return this;
	}
	
	/**
	 * 获得 任务ID<br>
	 * Camunda 任务ID
	 * @return 任务ID
	*/
	public String getCamundaTaskId() {
		return camundaTaskId;
	}
	
	/**
	 * 设置 任务ID
	 * @param camundaTaskId 任务ID
	 * @return 当前对象
	*/
	public Task setCamundaTaskId(String camundaTaskId) {
		this.camundaTaskId=camundaTaskId;
		return this;
	}
	
	/**
	 * 获得 cam中指定的审批人<br>
	 * cam中指定的审批人
	 * @return cam中指定的审批人
	*/
	public String getCamundaAssignee() {
		return camundaAssignee;
	}
	
	/**
	 * 设置 cam中指定的审批人
	 * @param camundaAssignee cam中指定的审批人
	 * @return 当前对象
	*/
	public Task setCamundaAssignee(String camundaAssignee) {
		this.camundaAssignee=camundaAssignee;
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
	public Task setCreateBy(String createBy) {
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
	public Task setCreateTime(Date createTime) {
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
	public Task setUpdateBy(String updateBy) {
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
	public Task setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public Task setDeleted(Integer deleted) {
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
	public Task setDeleted(Boolean deletedBool) {
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
	public Task setDeleteBy(String deleteBy) {
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
	public Task setDeleteTime(Date deleteTime) {
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
	public Task setVersion(Integer version) {
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
	public Task setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程类型<br>
	 * 流程类型
	 * @return 流程类型
	*/
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}
	
	/**
	 * 设置 流程类型
	 * @param processDefinition 流程类型
	 * @return 当前对象
	*/
	public Task setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition=processDefinition;
		return this;
	}
	
	/**
	 * 获得 流程实例<br>
	 * 流程实例
	 * @return 流程实例
	*/
	public ProcessInstance getProcessInstance() {
		return processInstance;
	}
	
	/**
	 * 设置 流程实例
	 * @param processInstance 流程实例
	 * @return 当前对象
	*/
	public Task setProcessInstance(ProcessInstance processInstance) {
		this.processInstance=processInstance;
		return this;
	}
	
	/**
	 * 获得 审批动作清单<br>
	 * 审批动作清单
	 * @return 审批动作清单
	*/
	public List<TaskApproval> getApprovals() {
		return approvals;
	}
	
	/**
	 * 设置 审批动作清单
	 * @param approvals 审批动作清单
	 * @return 当前对象
	*/
	public Task setApprovals(List<TaskApproval> approvals) {
		this.approvals=approvals;
		return this;
	}
	
	/**
	 * 添加 审批动作清单
	 * @param approval 审批动作清单
	 * @return 当前对象
	*/
	public Task addApproval(TaskApproval... approval) {
		if(this.approvals==null) approvals=new ArrayList<>();
		this.approvals.addAll(Arrays.asList(approval));
		return this;
	}
	
	/**
	 * 获得 审批人清单<br>
	 * 审批人清单
	 * @return 审批人清单
	*/
	public List<TaskAssignee> getAssignees() {
		return assignees;
	}
	
	/**
	 * 设置 审批人清单
	 * @param assignees 审批人清单
	 * @return 当前对象
	*/
	public Task setAssignees(List<TaskAssignee> assignees) {
		this.assignees=assignees;
		return this;
	}
	
	/**
	 * 添加 审批人清单
	 * @param assignee 审批人清单
	 * @return 当前对象
	*/
	public Task addAssignee(TaskAssignee... assignee) {
		if(this.assignees==null) assignees=new ArrayList<>();
		this.assignees.addAll(Arrays.asList(assignee));
		return this;
	}
	
	/**
	 * 获得 审批人账户清单<br>
	 * 审批人账户清单
	 * @return 审批人账户清单
	*/
	public List<TaskAssigneeUser> getAssigneeUsers() {
		return assigneeUsers;
	}
	
	/**
	 * 设置 审批人账户清单
	 * @param assigneeUsers 审批人账户清单
	 * @return 当前对象
	*/
	public Task setAssigneeUsers(List<TaskAssigneeUser> assigneeUsers) {
		this.assigneeUsers=assigneeUsers;
		return this;
	}
	
	/**
	 * 添加 审批人账户清单
	 * @param assigneeUser 审批人账户清单
	 * @return 当前对象
	*/
	public Task addAssigneeUser(TaskAssigneeUser... assigneeUser) {
		if(this.assigneeUsers==null) assigneeUsers=new ArrayList<>();
		this.assigneeUsers.addAll(Arrays.asList(assigneeUser));
		return this;
	}
	
	/**
	 * 获得 流程节点<br>
	 * 流程节点
	 * @return 流程节点
	*/
	public ProcessDefinitionNode getNode() {
		return node;
	}
	
	/**
	 * 设置 流程节点
	 * @param node 流程节点
	 * @return 当前对象
	*/
	public Task setNode(ProcessDefinitionNode node) {
		this.node=node;
		return this;
	}
	
	/**
	 * 获得 已读清单<br>
	 * 已读人员清单
	 * @return 已读清单
	*/
	public List<TaskRead> getReaders() {
		return readers;
	}
	
	/**
	 * 设置 已读清单
	 * @param readers 已读清单
	 * @return 当前对象
	*/
	public Task setReaders(List<TaskRead> readers) {
		this.readers=readers;
		return this;
	}
	
	/**
	 * 添加 已读清单
	 * @param reader 已读清单
	 * @return 当前对象
	*/
	public Task addReader(TaskRead... reader) {
		if(this.readers==null) readers=new ArrayList<>();
		this.readers.addAll(Arrays.asList(reader));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Task , 转换好的 Task 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Task , 转换好的 PoJo 对象
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
	 * 克隆当前对象
	*/
	@Transient
	public Task clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Task duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.TaskMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.TaskMeta.$$proxy$$();
		inst.setNodeName(this.getNodeName());
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setApprovalTime(this.getApprovalTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCamundaTaskId(this.getCamundaTaskId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setStatusReason(this.getStatusReason());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setCamundaAssignee(this.getCamundaAssignee());
		inst.setNodeId(this.getNodeId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setNode(this.getNode());
			inst.setAssigneeUsers(this.getAssigneeUsers());
			inst.setReaders(this.getReaders());
			inst.setProcessDefinition(this.getProcessDefinition());
			inst.setApprovals(this.getApprovals());
			inst.setProcessInstance(this.getProcessInstance());
			inst.setAssignees(this.getAssignees());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Task clone(boolean deep) {
		return EntityContext.clone(Task.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Task
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return Task , 转换好的的 Task 对象
	*/
	@Transient
	public static Task createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		Task po = create();
		EntityContext.copyProperties(po,taskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Task
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Task , 转换好的的 Task 对象
	*/
	@Transient
	public static Task createFrom(Object pojo) {
		if(pojo==null) return null;
		Task po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Task，等同于 new
	 * @return Task 对象
	*/
	@Transient
	public static Task create() {
		return new org.github.foxnic.web.domain.bpm.meta.TaskMeta.$$proxy$$();
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
			this.setNodeName(DataParser.parse(String.class, map.get(TaskMeta.NODE_NAME)));
			this.setProcessDefinitionId(DataParser.parse(String.class, map.get(TaskMeta.PROCESS_DEFINITION_ID)));
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(TaskMeta.PROCESS_INSTANCE_ID)));
			this.setApprovalTime(DataParser.parse(Date.class, map.get(TaskMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TaskMeta.UPDATE_TIME)));
			this.setCamundaTaskId(DataParser.parse(String.class, map.get(TaskMeta.CAMUNDA_TASK_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TaskMeta.CREATE_BY)));
			this.setStatusReason(DataParser.parse(String.class, map.get(TaskMeta.STATUS_REASON)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TaskMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(TaskMeta.ID)));
			this.setCamundaAssignee(DataParser.parse(String.class, map.get(TaskMeta.CAMUNDA_ASSIGNEE)));
			this.setNodeId(DataParser.parse(String.class, map.get(TaskMeta.NODE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(TaskMeta.STATUS)));
			// others
			this.setNode(DataParser.parse(ProcessDefinitionNode.class, map.get(TaskMeta.NODE)));
			this.setProcessDefinition(DataParser.parse(ProcessDefinition.class, map.get(TaskMeta.PROCESS_DEFINITION)));
			this.setProcessInstance(DataParser.parse(ProcessInstance.class, map.get(TaskMeta.PROCESS_INSTANCE)));
			return true;
		} else {
			try {
				this.setNodeName( (String)map.get(TaskMeta.NODE_NAME));
				this.setProcessDefinitionId( (String)map.get(TaskMeta.PROCESS_DEFINITION_ID));
				this.setProcessInstanceId( (String)map.get(TaskMeta.PROCESS_INSTANCE_ID));
				this.setApprovalTime( (Date)map.get(TaskMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)map.get(TaskMeta.UPDATE_TIME));
				this.setCamundaTaskId( (String)map.get(TaskMeta.CAMUNDA_TASK_ID));
				this.setVersion( (Integer)map.get(TaskMeta.VERSION));
				this.setCreateBy( (String)map.get(TaskMeta.CREATE_BY));
				this.setStatusReason( (String)map.get(TaskMeta.STATUS_REASON));
				this.setDeleted( (Integer)map.get(TaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(TaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TaskMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(TaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TaskMeta.DELETE_BY));
				this.setId( (String)map.get(TaskMeta.ID));
				this.setCamundaAssignee( (String)map.get(TaskMeta.CAMUNDA_ASSIGNEE));
				this.setNodeId( (String)map.get(TaskMeta.NODE_ID));
				this.setStatus( (String)map.get(TaskMeta.STATUS));
				// others
				this.setNode( (ProcessDefinitionNode)map.get(TaskMeta.NODE));
				this.setProcessDefinition( (ProcessDefinition)map.get(TaskMeta.PROCESS_DEFINITION));
				this.setProcessInstance( (ProcessInstance)map.get(TaskMeta.PROCESS_INSTANCE));
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
			this.setNodeName(DataParser.parse(String.class, r.getValue(TaskMeta.NODE_NAME)));
			this.setProcessDefinitionId(DataParser.parse(String.class, r.getValue(TaskMeta.PROCESS_DEFINITION_ID)));
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(TaskMeta.PROCESS_INSTANCE_ID)));
			this.setApprovalTime(DataParser.parse(Date.class, r.getValue(TaskMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TaskMeta.UPDATE_TIME)));
			this.setCamundaTaskId(DataParser.parse(String.class, r.getValue(TaskMeta.CAMUNDA_TASK_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TaskMeta.CREATE_BY)));
			this.setStatusReason(DataParser.parse(String.class, r.getValue(TaskMeta.STATUS_REASON)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TaskMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(TaskMeta.ID)));
			this.setCamundaAssignee(DataParser.parse(String.class, r.getValue(TaskMeta.CAMUNDA_ASSIGNEE)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(TaskMeta.NODE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(TaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNodeName( (String)r.getValue(TaskMeta.NODE_NAME));
				this.setProcessDefinitionId( (String)r.getValue(TaskMeta.PROCESS_DEFINITION_ID));
				this.setProcessInstanceId( (String)r.getValue(TaskMeta.PROCESS_INSTANCE_ID));
				this.setApprovalTime( (Date)r.getValue(TaskMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)r.getValue(TaskMeta.UPDATE_TIME));
				this.setCamundaTaskId( (String)r.getValue(TaskMeta.CAMUNDA_TASK_ID));
				this.setVersion( (Integer)r.getValue(TaskMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TaskMeta.CREATE_BY));
				this.setStatusReason( (String)r.getValue(TaskMeta.STATUS_REASON));
				this.setDeleted( (Integer)r.getValue(TaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TaskMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(TaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TaskMeta.DELETE_BY));
				this.setId( (String)r.getValue(TaskMeta.ID));
				this.setCamundaAssignee( (String)r.getValue(TaskMeta.CAMUNDA_ASSIGNEE));
				this.setNodeId( (String)r.getValue(TaskMeta.NODE_ID));
				this.setStatus( (String)r.getValue(TaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}