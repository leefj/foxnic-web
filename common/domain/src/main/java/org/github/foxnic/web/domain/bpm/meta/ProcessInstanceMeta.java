package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.FormInstance;
import org.github.foxnic.web.domain.bpm.Appover;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-27 15:45:10
 * @sign D5F3920702318BCBBA912A73E028CCD8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 起草人ID , 类型: java.lang.String
	*/
	public static final String DRAFTER_ID="drafterId";
	
	/**
	 * 起草人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> DRAFTER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DRAFTER_ID, java.lang.String.class, "起草人ID", "起草人ID", java.lang.String.class, null);
	
	/**
	 * 起草人类型 , 类型: java.lang.String
	*/
	public static final String DRAFTER_TYPE="drafterType";
	
	/**
	 * 起草人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> DRAFTER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DRAFTER_TYPE, java.lang.String.class, "起草人类型", "起草人类型", java.lang.String.class, null);
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final String FORM_INSTANCE_ID="formInstanceId";
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> FORM_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,FORM_INSTANCE_ID, java.lang.String.class, "表单实例ID", "表单实例ID", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 流程标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> TITLE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,TITLE, java.lang.String.class, "流程标题", "流程标题", java.lang.String.class, null);
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final String PRIORITY="priority";
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> PRIORITY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,PRIORITY, java.lang.String.class, "紧急程度", "紧急程度", java.lang.String.class, null);
	
	/**
	 * 流程说明 , 类型: java.lang.String
	*/
	public static final String COMMENT="comment";
	
	/**
	 * 流程说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,COMMENT, java.lang.String.class, "流程说明", "流程说明", java.lang.String.class, null);
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final String APPROVAL_STATUS="approvalStatus";
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> APPROVAL_STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,APPROVAL_STATUS, java.lang.String.class, "审批状态", "审批状态", java.lang.String.class, null);
	
	/**
	 * camunda流程实例ID , 类型: java.lang.Integer
	*/
	public static final String CAMUNDA_INSTANCE_ID="camundaInstanceId";
	
	/**
	 * camunda流程实例ID , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.Integer> CAMUNDA_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,CAMUNDA_INSTANCE_ID, java.lang.Integer.class, "camunda流程实例ID", "camunda流程实例ID", java.lang.Integer.class, null);
	
	/**
	 * 提交时间 , 类型: java.util.Date
	*/
	public static final String COMMIT_TIME="commitTime";
	
	/**
	 * 提交时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.util.Date> COMMIT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,COMMIT_TIME, java.util.Date.class, "提交时间", "提交时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 流程定义 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final String PROCESS_DEFINITION="processDefinition";
	
	/**
	 * 流程定义 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,org.github.foxnic.web.domain.bpm.ProcessDefinition> PROCESS_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,PROCESS_DEFINITION, org.github.foxnic.web.domain.bpm.ProcessDefinition.class, "流程定义", "流程定义", org.github.foxnic.web.domain.bpm.ProcessDefinition.class, null);
	
	/**
	 * 表单实例 , 类型: org.github.foxnic.web.domain.bpm.FormInstance
	*/
	public static final String FORM_INSTANCE="formInstance";
	
	/**
	 * 表单实例 , 类型: org.github.foxnic.web.domain.bpm.FormInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,org.github.foxnic.web.domain.bpm.FormInstance> FORM_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,FORM_INSTANCE, org.github.foxnic.web.domain.bpm.FormInstance.class, "表单实例", "表单实例", org.github.foxnic.web.domain.bpm.FormInstance.class, null);
	
	/**
	 * 起草人 , 类型: org.github.foxnic.web.domain.bpm.Appover
	*/
	public static final String DRAFTER="drafter";
	
	/**
	 * 起草人 , 类型: org.github.foxnic.web.domain.bpm.Appover
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,org.github.foxnic.web.domain.bpm.Appover> DRAFTER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DRAFTER, org.github.foxnic.web.domain.bpm.Appover.class, "起草人", "起草人", org.github.foxnic.web.domain.bpm.Appover.class, null);
	
	/**
	 * 起草人名称 , 类型: java.lang.String
	*/
	public static final String DRAFTER_NAME="drafterName";
	
	/**
	 * 起草人名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstance,java.lang.String> DRAFTER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstance.class ,DRAFTER_NAME, java.lang.String.class, "起草人名称", "起草人名称", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DRAFTER_ID , DRAFTER_TYPE , FORM_INSTANCE_ID , PROCESS_DEFINITION_ID , TITLE , PRIORITY , COMMENT , APPROVAL_STATUS , CAMUNDA_INSTANCE_ID , COMMIT_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PROCESS_DEFINITION , FORM_INSTANCE , DRAFTER , DRAFTER_NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessInstance {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProcessInstance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 起草人ID
		 * @param drafterId 起草人ID
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterId(String drafterId) {
			super.change(DRAFTER_ID,super.getDrafterId(),drafterId);
			super.setDrafterId(drafterId);
			return this;
		}
		
		/**
		 * 设置 起草人类型
		 * @param drafterType 起草人类型
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterType(String drafterType) {
			super.change(DRAFTER_TYPE,super.getDrafterType(),drafterType);
			super.setDrafterType(drafterType);
			return this;
		}
		
		/**
		 * 设置 表单实例ID
		 * @param formInstanceId 表单实例ID
		 * @return 当前对象
		*/
		public ProcessInstance setFormInstanceId(String formInstanceId) {
			super.change(FORM_INSTANCE_ID,super.getFormInstanceId(),formInstanceId);
			super.setFormInstanceId(formInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程标题
		 * @param title 流程标题
		 * @return 当前对象
		*/
		public ProcessInstance setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 紧急程度
		 * @param priority 紧急程度
		 * @return 当前对象
		*/
		public ProcessInstance setPriority(String priority) {
			super.change(PRIORITY,super.getPriority(),priority);
			super.setPriority(priority);
			return this;
		}
		
		/**
		 * 设置 流程说明
		 * @param comment 流程说明
		 * @return 当前对象
		*/
		public ProcessInstance setComment(String comment) {
			super.change(COMMENT,super.getComment(),comment);
			super.setComment(comment);
			return this;
		}
		
		/**
		 * 设置 审批状态
		 * @param approvalStatus 审批状态
		 * @return 当前对象
		*/
		public ProcessInstance setApprovalStatus(String approvalStatus) {
			super.change(APPROVAL_STATUS,super.getApprovalStatus(),approvalStatus);
			super.setApprovalStatus(approvalStatus);
			return this;
		}
		
		/**
		 * 设置 camunda流程实例ID
		 * @param camundaInstanceId camunda流程实例ID
		 * @return 当前对象
		*/
		public ProcessInstance setCamundaInstanceId(Integer camundaInstanceId) {
			super.change(CAMUNDA_INSTANCE_ID,super.getCamundaInstanceId(),camundaInstanceId);
			super.setCamundaInstanceId(camundaInstanceId);
			return this;
		}
		
		/**
		 * 设置 提交时间
		 * @param commitTime 提交时间
		 * @return 当前对象
		*/
		public ProcessInstance setCommitTime(Date commitTime) {
			super.change(COMMIT_TIME,super.getCommitTime(),commitTime);
			super.setCommitTime(commitTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessInstance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessInstance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessInstance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessInstance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessInstance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessInstance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessInstance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessInstance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessInstance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程定义
		 * @param processDefinition 流程定义
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinition(ProcessDefinition processDefinition) {
			super.change(PROCESS_DEFINITION,super.getProcessDefinition(),processDefinition);
			super.setProcessDefinition(processDefinition);
			return this;
		}
		
		/**
		 * 设置 表单实例
		 * @param formInstance 表单实例
		 * @return 当前对象
		*/
		public ProcessInstance setFormInstance(FormInstance formInstance) {
			super.change(FORM_INSTANCE,super.getFormInstance(),formInstance);
			super.setFormInstance(formInstance);
			return this;
		}
		
		/**
		 * 设置 起草人
		 * @param drafter 起草人
		 * @return 当前对象
		*/
		public ProcessInstance setDrafter(Appover drafter) {
			super.change(DRAFTER,super.getDrafter(),drafter);
			super.setDrafter(drafter);
			return this;
		}
		
		/**
		 * 设置 起草人名称
		 * @param drafterName 起草人名称
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterName(String drafterName) {
			super.change(DRAFTER_NAME,super.getDrafterName(),drafterName);
			super.setDrafterName(drafterName);
			return this;
		}
	}
}