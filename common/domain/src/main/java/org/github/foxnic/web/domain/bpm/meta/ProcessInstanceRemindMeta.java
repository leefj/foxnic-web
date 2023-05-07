package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemind;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-21 14:49:09
 * @sign 1739DD758979580DE91C9FA33AFF8009
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceRemindMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 监控的目标节点ID , 类型: java.lang.String
	*/
	public static final String TARGET_NODE_ID="targetNodeId";
	
	/**
	 * 监控的目标节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> TARGET_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,TARGET_NODE_ID, java.lang.String.class, "监控的目标节点ID", "监控的目标节点ID", java.lang.String.class, null);
	
	/**
	 * 设置提醒的节点ID , 类型: java.lang.String
	*/
	public static final String SOURCE_NODE_ID="sourceNodeId";
	
	/**
	 * 设置提醒的节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> SOURCE_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,SOURCE_NODE_ID, java.lang.String.class, "设置提醒的节点ID", "设置提醒的节点ID", java.lang.String.class, null);
	
	/**
	 * 提醒内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 提醒内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,CONTENT, java.lang.String.class, "提醒内容", "提醒内容", java.lang.String.class, null);
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final String REMIND_TIME="remindTime";
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.util.Date> REMIND_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,REMIND_TIME, java.util.Date.class, "提醒时间", "提醒时间", java.util.Date.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 提醒时长 , 类型: java.lang.Integer
	*/
	public static final String REMIND_TERM="remindTerm";
	
	/**
	 * 提醒时长 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.Integer> REMIND_TERM_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,REMIND_TERM, java.lang.Integer.class, "提醒时长", "提醒时长", java.lang.Integer.class, null);
	
	/**
	 * 提醒时长单位 , 类型: java.lang.String
	*/
	public static final String REMIND_TERM_UNIT="remindTermUnit";
	
	/**
	 * 提醒时长单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.lang.String> REMIND_TERM_UNIT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,REMIND_TERM_UNIT, java.lang.String.class, "提醒时长单位", "提醒时长单位", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String COMPLETE_TIME="completeTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,java.util.Date> COMPLETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,COMPLETE_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 接收人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver
	*/
	public static final String RECEIVERS="receivers";
	
	/**
	 * 接收人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver> RECEIVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,RECEIVERS, java.util.List.class, "接收人清单", "接收人清单", org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class, null);
	
	/**
	 * 监控的目标节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final String TARGET_NODE="targetNode";
	
	/**
	 * 监控的目标节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,org.github.foxnic.web.domain.bpm.ProcessDefinitionNode> TARGET_NODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,TARGET_NODE, org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, "监控的目标节点", "监控的目标节点", org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, null);
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String PROCESS_INSTANCE="processInstance";
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemind,org.github.foxnic.web.domain.bpm.ProcessInstance> PROCESS_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemind.class ,PROCESS_INSTANCE, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "流程实例", "流程实例", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_INSTANCE_ID , TARGET_NODE_ID , SOURCE_NODE_ID , CONTENT , REMIND_TIME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , STATUS , REMIND_TERM , REMIND_TERM_UNIT , COMPLETE_TIME , RECEIVERS , TARGET_NODE , PROCESS_INSTANCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessInstanceRemind {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 监控的目标节点ID
		 * @param targetNodeId 监控的目标节点ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTargetNodeId(String targetNodeId) {
			super.change(TARGET_NODE_ID,super.getTargetNodeId(),targetNodeId);
			super.setTargetNodeId(targetNodeId);
			return this;
		}
		
		/**
		 * 设置 设置提醒的节点ID
		 * @param sourceNodeId 设置提醒的节点ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setSourceNodeId(String sourceNodeId) {
			super.change(SOURCE_NODE_ID,super.getSourceNodeId(),sourceNodeId);
			super.setSourceNodeId(sourceNodeId);
			return this;
		}
		
		/**
		 * 设置 提醒内容
		 * @param content 提醒内容
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 提醒时间
		 * @param remindTime 提醒时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTime(Date remindTime) {
			super.change(REMIND_TIME,super.getRemindTime(),remindTime);
			super.setRemindTime(remindTime);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 提醒时长
		 * @param remindTerm 提醒时长
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTerm(Integer remindTerm) {
			super.change(REMIND_TERM,super.getRemindTerm(),remindTerm);
			super.setRemindTerm(remindTerm);
			return this;
		}
		
		/**
		 * 设置 提醒时长单位
		 * @param remindTermUnit 提醒时长单位
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTermUnit(String remindTermUnit) {
			super.change(REMIND_TERM_UNIT,super.getRemindTermUnit(),remindTermUnit);
			super.setRemindTermUnit(remindTermUnit);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param completeTime 处理时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCompleteTime(Date completeTime) {
			super.change(COMPLETE_TIME,super.getCompleteTime(),completeTime);
			super.setCompleteTime(completeTime);
			return this;
		}
		
		/**
		 * 设置 接收人清单
		 * @param receivers 接收人清单
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setReceivers(List<ProcessInstanceRemindReceiver> receivers) {
			super.change(RECEIVERS,super.getReceivers(),receivers);
			super.setReceivers(receivers);
			return this;
		}
		
		/**
		 * 设置 监控的目标节点
		 * @param targetNode 监控的目标节点
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTargetNode(ProcessDefinitionNode targetNode) {
			super.change(TARGET_NODE,super.getTargetNode(),targetNode);
			super.setTargetNode(targetNode);
			return this;
		}
		
		/**
		 * 设置 流程实例
		 * @param processInstance 流程实例
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setProcessInstance(ProcessInstance processInstance) {
			super.change(PROCESS_INSTANCE,super.getProcessInstance(),processInstance);
			super.setProcessInstance(processInstance);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessInstanceRemind clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessInstanceRemind duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setCompleteTime(this.getCompleteTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setRemindTermUnit(this.getRemindTermUnit());
			inst.setContent(this.getContent());
			inst.setRemindTerm(this.getRemindTerm());
			inst.setRemindTime(this.getRemindTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setSourceNodeId(this.getSourceNodeId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTargetNodeId(this.getTargetNodeId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setReceivers(this.getReceivers());
				inst.setProcessInstance(this.getProcessInstance());
				inst.setTargetNode(this.getTargetNode());
			}
			inst.clearModifies();
			return inst;
		}

	}
}