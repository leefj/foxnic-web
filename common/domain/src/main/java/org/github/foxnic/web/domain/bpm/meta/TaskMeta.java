package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.Task;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.TaskApproval;
import java.util.List;
import org.github.foxnic.web.domain.bpm.TaskAssignee;
import org.github.foxnic.web.domain.bpm.TaskAssigneeUser;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.TaskRead;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 * @sign 79A8E74A5A5E477DA7551C9257BE7C6F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskMeta {
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,NODE_ID, java.lang.String.class, "节点ID", "节点ID", java.lang.String.class, null);
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,NODE_NAME, java.lang.String.class, "节点名称", "节点名称", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 原因 , 状态变更的原因 , 类型: java.lang.String
	*/
	public static final String STATUS_REASON="statusReason";
	
	/**
	 * 原因 , 状态变更的原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> STATUS_REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,STATUS_REASON, java.lang.String.class, "原因", "状态变更的原因", java.lang.String.class, null);
	
	/**
	 * 最后处理时间 , 类型: java.util.Date
	*/
	public static final String APPROVAL_TIME="approvalTime";
	
	/**
	 * 最后处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.util.Date> APPROVAL_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,APPROVAL_TIME, java.util.Date.class, "最后处理时间", "最后处理时间", java.util.Date.class, null);
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_TASK_ID="camundaTaskId";
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> CAMUNDA_TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,CAMUNDA_TASK_ID, java.lang.String.class, "任务ID", "Camunda 任务ID", java.lang.String.class, null);
	
	/**
	 * cam中指定的审批人 , 类型: java.lang.String
	*/
	public static final String CAMUNDA_ASSIGNEE="camundaAssignee";
	
	/**
	 * cam中指定的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> CAMUNDA_ASSIGNEE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,CAMUNDA_ASSIGNEE, java.lang.String.class, "cam中指定的审批人", "cam中指定的审批人", java.lang.String.class, null);
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,CREATE_BY, java.lang.String.class, "create_by", "create_by", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,UPDATE_BY, java.lang.String.class, "update_by", "update_by", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,DELETE_BY, java.lang.String.class, "delete_by", "delete_by", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,TENANT_ID, java.lang.String.class, "tenant_id", "tenant_id", java.lang.String.class, null);
	
	/**
	 * 流程类型 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final String PROCESS_DEFINITION="processDefinition";
	
	/**
	 * 流程类型 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.ProcessDefinition> PROCESS_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,PROCESS_DEFINITION, org.github.foxnic.web.domain.bpm.ProcessDefinition.class, "流程类型", "流程类型", org.github.foxnic.web.domain.bpm.ProcessDefinition.class, null);
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String PROCESS_INSTANCE="processInstance";
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.ProcessInstance> PROCESS_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,PROCESS_INSTANCE, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "流程实例", "流程实例", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final String APPROVALS="approvals";
	
	/**
	 * 审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.TaskApproval> APPROVALS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,APPROVALS, java.util.List.class, "审批动作清单", "审批动作清单", org.github.foxnic.web.domain.bpm.TaskApproval.class, null);
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssignee
	*/
	public static final String ASSIGNEES="assignees";
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.TaskAssignee> ASSIGNEES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,ASSIGNEES, java.util.List.class, "审批人清单", "审批人清单", org.github.foxnic.web.domain.bpm.TaskAssignee.class, null);
	
	/**
	 * 审批人账户清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssigneeUser
	*/
	public static final String ASSIGNEE_USERS="assigneeUsers";
	
	/**
	 * 审批人账户清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssigneeUser
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.TaskAssigneeUser> ASSIGNEE_USERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,ASSIGNEE_USERS, java.util.List.class, "审批人账户清单", "审批人账户清单", org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class, null);
	
	/**
	 * 流程节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final String NODE="node";
	
	/**
	 * 流程节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.ProcessDefinitionNode> NODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,NODE, org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, "流程节点", "流程节点", org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, null);
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final String READERS="readers";
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.Task,org.github.foxnic.web.domain.bpm.TaskRead> READERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.Task.class ,READERS, java.util.List.class, "已读清单", "已读人员清单", org.github.foxnic.web.domain.bpm.TaskRead.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_DEFINITION_ID , NODE_ID , NODE_NAME , PROCESS_INSTANCE_ID , STATUS , STATUS_REASON , APPROVAL_TIME , CAMUNDA_TASK_ID , CAMUNDA_ASSIGNEE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PROCESS_DEFINITION , PROCESS_INSTANCE , APPROVALS , ASSIGNEES , ASSIGNEE_USERS , NODE , READERS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.Task {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public Task setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public Task setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 节点ID
		 * @param nodeId 节点ID
		 * @return 当前对象
		*/
		public Task setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 节点名称
		 * @param nodeName 节点名称
		 * @return 当前对象
		*/
		public Task setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public Task setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 任务状态
		 * @param status 任务状态
		 * @return 当前对象
		*/
		public Task setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param statusReason 原因
		 * @return 当前对象
		*/
		public Task setStatusReason(String statusReason) {
			super.change(STATUS_REASON,super.getStatusReason(),statusReason);
			super.setStatusReason(statusReason);
			return this;
		}
		
		/**
		 * 设置 最后处理时间
		 * @param approvalTime 最后处理时间
		 * @return 当前对象
		*/
		public Task setApprovalTime(Date approvalTime) {
			super.change(APPROVAL_TIME,super.getApprovalTime(),approvalTime);
			super.setApprovalTime(approvalTime);
			return this;
		}
		
		/**
		 * 设置 任务ID
		 * @param camundaTaskId 任务ID
		 * @return 当前对象
		*/
		public Task setCamundaTaskId(String camundaTaskId) {
			super.change(CAMUNDA_TASK_ID,super.getCamundaTaskId(),camundaTaskId);
			super.setCamundaTaskId(camundaTaskId);
			return this;
		}
		
		/**
		 * 设置 cam中指定的审批人
		 * @param camundaAssignee cam中指定的审批人
		 * @return 当前对象
		*/
		public Task setCamundaAssignee(String camundaAssignee) {
			super.change(CAMUNDA_ASSIGNEE,super.getCamundaAssignee(),camundaAssignee);
			super.setCamundaAssignee(camundaAssignee);
			return this;
		}
		
		/**
		 * 设置 create_by
		 * @param createBy create_by
		 * @return 当前对象
		*/
		public Task setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Task setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 update_by
		 * @param updateBy update_by
		 * @return 当前对象
		*/
		public Task setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Task setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Task setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 delete_by
		 * @param deleteBy delete_by
		 * @return 当前对象
		*/
		public Task setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Task setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Task setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant_id
		 * @param tenantId tenant_id
		 * @return 当前对象
		*/
		public Task setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程类型
		 * @param processDefinition 流程类型
		 * @return 当前对象
		*/
		public Task setProcessDefinition(ProcessDefinition processDefinition) {
			super.change(PROCESS_DEFINITION,super.getProcessDefinition(),processDefinition);
			super.setProcessDefinition(processDefinition);
			return this;
		}
		
		/**
		 * 设置 流程实例
		 * @param processInstance 流程实例
		 * @return 当前对象
		*/
		public Task setProcessInstance(ProcessInstance processInstance) {
			super.change(PROCESS_INSTANCE,super.getProcessInstance(),processInstance);
			super.setProcessInstance(processInstance);
			return this;
		}
		
		/**
		 * 设置 审批动作清单
		 * @param approvals 审批动作清单
		 * @return 当前对象
		*/
		public Task setApprovals(List<TaskApproval> approvals) {
			super.change(APPROVALS,super.getApprovals(),approvals);
			super.setApprovals(approvals);
			return this;
		}
		
		/**
		 * 设置 审批人清单
		 * @param assignees 审批人清单
		 * @return 当前对象
		*/
		public Task setAssignees(List<TaskAssignee> assignees) {
			super.change(ASSIGNEES,super.getAssignees(),assignees);
			super.setAssignees(assignees);
			return this;
		}
		
		/**
		 * 设置 审批人账户清单
		 * @param assigneeUsers 审批人账户清单
		 * @return 当前对象
		*/
		public Task setAssigneeUsers(List<TaskAssigneeUser> assigneeUsers) {
			super.change(ASSIGNEE_USERS,super.getAssigneeUsers(),assigneeUsers);
			super.setAssigneeUsers(assigneeUsers);
			return this;
		}
		
		/**
		 * 设置 流程节点
		 * @param node 流程节点
		 * @return 当前对象
		*/
		public Task setNode(ProcessDefinitionNode node) {
			super.change(NODE,super.getNode(),node);
			super.setNode(node);
			return this;
		}
		
		/**
		 * 设置 已读清单
		 * @param readers 已读清单
		 * @return 当前对象
		*/
		public Task setReaders(List<TaskRead> readers) {
			super.change(READERS,super.getReaders(),readers);
			super.setReaders(readers);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}