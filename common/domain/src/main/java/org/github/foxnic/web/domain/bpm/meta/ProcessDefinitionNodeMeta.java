package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:51
 * @sign 1A80F015B160C370BD92FA9EC886F55E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessDefinitionNodeMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_FILE_ID="processDefinitionFileId";
	
	/**
	 * 流程文件ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> PROCESS_DEFINITION_FILE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,PROCESS_DEFINITION_FILE_ID, java.lang.String.class, "流程文件ID", "流程文件ID", java.lang.String.class, null);
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_NODE_ID="camundaNodeId";
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> CAMUNDA_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,CAMUNDA_NODE_ID, java.lang.String.class, "节点ID", "节点ID", java.lang.String.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String NODE_TYPE="nodeType";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> NODE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,NODE_TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,NODE_NAME, java.lang.String.class, "节点名称", "节点名称", java.lang.String.class, null);
	
	/**
	 * 人工节点类型 , 类型: java.lang.String
	*/
	public static final String USER_TASK_TYPE="userTaskType";
	
	/**
	 * 人工节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> USER_TASK_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,USER_TASK_TYPE, java.lang.String.class, "人工节点类型", "人工节点类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,SORT, java.lang.Integer.class, "序号", "序号", java.lang.Integer.class, null);
	
	/**
	 * 会审的循环基数 , 类型: java.lang.Integer
	*/
	public static final String LOOP_CARDINALITY="loopCardinality";
	
	/**
	 * 会审的循环基数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,java.lang.Integer> LOOP_CARDINALITY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,LOOP_CARDINALITY, java.lang.Integer.class, "会审的循环基数", "会审的循环基数", java.lang.Integer.class, null);
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee
	*/
	public static final String ASSIGNEES="assignees";
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionNode,org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee> ASSIGNEES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class ,ASSIGNEES, java.util.List.class, "审批人清单", "审批人清单", org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROCESS_DEFINITION_ID , PROCESS_DEFINITION_FILE_ID , CAMUNDA_NODE_ID , NODE_TYPE , NODE_NAME , USER_TASK_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SORT , LOOP_CARDINALITY , ASSIGNEES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessDefinitionNode {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程文件ID
		 * @param processDefinitionFileId 流程文件ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setProcessDefinitionFileId(String processDefinitionFileId) {
			super.change(PROCESS_DEFINITION_FILE_ID,super.getProcessDefinitionFileId(),processDefinitionFileId);
			super.setProcessDefinitionFileId(processDefinitionFileId);
			return this;
		}
		
		/**
		 * 设置 节点ID
		 * @param camundaNodeId 节点ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setCamundaNodeId(String camundaNodeId) {
			super.change(CAMUNDA_NODE_ID,super.getCamundaNodeId(),camundaNodeId);
			super.setCamundaNodeId(camundaNodeId);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param nodeType 节点类型
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setNodeType(String nodeType) {
			super.change(NODE_TYPE,super.getNodeType(),nodeType);
			super.setNodeType(nodeType);
			return this;
		}
		
		/**
		 * 设置 节点名称
		 * @param nodeName 节点名称
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 人工节点类型
		 * @param userTaskType 人工节点类型
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setUserTaskType(String userTaskType) {
			super.change(USER_TASK_TYPE,super.getUserTaskType(),userTaskType);
			super.setUserTaskType(userTaskType);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 序号
		 * @param sort 序号
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 会审的循环基数
		 * @param loopCardinality 会审的循环基数
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setLoopCardinality(Integer loopCardinality) {
			super.change(LOOP_CARDINALITY,super.getLoopCardinality(),loopCardinality);
			super.setLoopCardinality(loopCardinality);
			return this;
		}
		
		/**
		 * 设置 审批人清单
		 * @param assignees 审批人清单
		 * @return 当前对象
		*/
		public ProcessDefinitionNode setAssignees(List<ProcessDefinitionNodeAssignee> assignees) {
			super.change(ASSIGNEES,super.getAssignees(),assignees);
			super.setAssignees(assignees);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessDefinitionNode clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessDefinitionNode duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNodeName(this.getNodeName());
			inst.setProcessDefinitionId(this.getProcessDefinitionId());
			inst.setUserTaskType(this.getUserTaskType());
			inst.setNotes(this.getNotes());
			inst.setLoopCardinality(this.getLoopCardinality());
			inst.setProcessDefinitionFileId(this.getProcessDefinitionFileId());
			inst.setCamundaNodeId(this.getCamundaNodeId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setNodeType(this.getNodeType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setAssignees(this.getAssignees());
			}
			inst.clearModifies();
			return inst;
		}

	}
}