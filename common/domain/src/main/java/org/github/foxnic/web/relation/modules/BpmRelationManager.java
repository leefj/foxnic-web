package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.FormInstanceBill;
import org.github.foxnic.web.domain.bpm.TaskApproval;
import org.github.foxnic.web.domain.bpm.meta.*;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;
import org.github.foxnic.web.domain.oauth.User;

public class BpmRelationManager extends RelationManager {


	@Override
	protected void config() {
		setupBpmProcessDefinition();
		setupBpmProcessInstance();
		setupBpmTask();
		setupBpmForm();
		//
		setupChanges();
	}

	protected void setupBpmProcessDefinition() {

		//流程定义 - 账户(最后更新人)
		this.property(ProcessDefinitionMeta.LAST_UPDATE_USER_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.UPDATE_BY).join(FoxnicWeb.SYS_USER.ID)
				.after((tag,owner,data,map)->{
					for (User user : data) {
						user.setPasswd("******");
					}
					return data;
				});


		//流程定义 - 当前激活的流程定义文件
		this.property(ProcessDefinitionMeta.DEFINITION_FILE_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.PROCESS_DEFINITION_ID)
				.conditionEquals(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.ACTIVATED,1);


		//流程定义 - 表单定义
		this.property(ProcessDefinitionMeta.FORM_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID).join(FoxnicWeb.BPM_FORM_DEFINITION.ID)
				.cache(true);


		//流程定义文件 - 流程节点
		this.property(ProcessDefinitionFileMeta.NODES_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_NODE.PROCESS_DEFINITION_FILE_ID)
				.cache(true);


		//流程定义节点 - 流程审批人
		this.property(ProcessDefinitionNodeMeta.ASSIGNEES_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION_NODE.ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_NODE_ASSIGNEE.NODE_ID)
				.cache(true);

	}

	protected void setupBpmProcessInstance() {
		//流程实例 - 流程定义
		this.property(ProcessInstanceMeta.PROCESS_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION.ID)
				.cache(true);

		//流程实例 - 流程定义文件
		this.property(ProcessInstanceMeta.PROCESS_DEFINITION_FILE_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_FILE_ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.ID)
				.cache(true);

		//流程实例 - 表单定义
		this.property(ProcessInstanceMeta.FORM_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID).join(FoxnicWeb.BPM_FORM_DEFINITION.ID)
				.cache(true);


		//流程实例 - 表单实例
		this.property(ProcessInstanceMeta.FORM_INSTANCE_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).join(FoxnicWeb.BPM_FORM_INSTANCE.ID).cache(true);

		//流程实例 - 单据
		this.property(ProcessInstanceMeta.BILLS_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).join(FoxnicWeb.BPM_FORM_INSTANCE_BILL.FORM_INSTANCE_ID)
				.after((tag,instance,bills,map)->{
					instance.setBillIds(CollectorUtil.collectList(bills, FormInstanceBill::getBillId));
					return bills;
				}).cache(true);

		//流程实例 - 发起人账户
		this.property(ProcessInstanceMeta.DRAFTER_USER_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.DRAFTER_USER_ID).join(FoxnicWeb.SYS_USER.ID)
				.after((tag,owner,data,map)->{
					for (User user : data) {
						user.setPasswd("******");
					}
					return data;
				})
				.cache(true);

		//流程实例 - 任务
		this.property(ProcessInstanceMeta.TASKS_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.ID).join(FoxnicWeb.BPM_TASK.PROCESS_INSTANCE_ID);

		//流程实例 - 审批动作
		this.property(ProcessInstanceMeta.TASK_APPROVALS_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.ID).join(FoxnicWeb.BPM_TASK_APPROVAL.PROCESS_INSTANCE_ID)
				.addOrderBy(FoxnicWeb.BPM_TASK_APPROVAL.CREATE_TIME,false,true);

		//流程实例 - 流程异常
		this.property(ProcessInstanceMeta.ERRORS_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.ID).join(FoxnicWeb.BPM_PROCESS_ERROR.PROCESS_INSTANCE_ID);
	}

	protected void setupBpmTask() {

		//任务 - 流程定义
		this.property(TaskMeta.PROCESS_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_TASK.PROCESS_DEFINITION_ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION.ID);

		//任务 - 流程节点
		this.property(TaskMeta.NODE_PROP)
				.using(FoxnicWeb.BPM_TASK.NODE_ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_NODE.ID);

		//任务 - 流程实例
		this.property(TaskMeta.PROCESS_INSTANCE_PROP)
				.using(FoxnicWeb.BPM_TASK.PROCESS_INSTANCE_ID).join(FoxnicWeb.BPM_PROCESS_INSTANCE.ID);

		//任务 - 审批代理人
		this.property(TaskMeta.ASSIGNEES_PROP)
				.using(FoxnicWeb.BPM_TASK.ID).join(FoxnicWeb.BPM_TASK_ASSIGNEE.TASK_ID);

		//任务 - 审批动作
		this.property(TaskMeta.APPROVALS_PROP)
				.using(FoxnicWeb.BPM_TASK.ID).join(FoxnicWeb.BPM_TASK_APPROVAL.TASK_ID);


		//审批动作 - 审批人账户
		this.property(TaskApprovalMeta.APPROVAL_USER_PROP)
				.using(FoxnicWeb.BPM_TASK_APPROVAL.APPROVAL_USER_ID).join(FoxnicWeb.SYS_USER.ID)
				.after((tag,owner,data,map)->{
					for (User user : data) {
						user.setPasswd("******");
					}
					return data;
				});

	}

	protected void setupBpmForm() {

		//表单实例 - 业务单据
		this.property(FormInstanceMeta.BILLS_PROP)
				.using(FoxnicWeb.BPM_FORM_INSTANCE.ID).join(FoxnicWeb.BPM_FORM_INSTANCE_BILL.FORM_INSTANCE_ID);

	}



	private void setupChanges() {

		//变更实例 - 当前审批员工关系
		this.property(ChangeInstanceMeta.CURR_EMPLOYEE_APPROVER_IDS_PROP)
				.using(FoxnicWeb.CHS_CHANGE_INSTANCE.ID).join(FoxnicWeb.CHS_CHANGE_APPROVER.INSTANCE_ID).conditionEquals(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_TYPE, UnifiedUserType.employee.code())
		;

		//变更实例 - 当前审批流程角色关系
		this.property(ChangeInstanceMeta.CURR_BUSI_ROLE_APPROVER_IDS_PROP)
				.using(FoxnicWeb.CHS_CHANGE_INSTANCE.ID).join(FoxnicWeb.CHS_CHANGE_APPROVER.INSTANCE_ID).conditionEquals(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_TYPE, UnifiedUserType.busi_role.code())
		;

		//变更实例 - 当前审批员工
		this.property(ChangeInstanceMeta.CURR_EMPLOYEE_APPROVERS_PROP)
				.using(FoxnicWeb.CHS_CHANGE_INSTANCE.ID).join(FoxnicWeb.CHS_CHANGE_APPROVER.INSTANCE_ID).conditionEquals(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_TYPE, UnifiedUserType.employee.code())
				.using(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
		;

		//变更实例 - 当前审批流程角色
		this.property(ChangeInstanceMeta.CURR_BUSI_ROLE_APPROVERS_PROP)
				.using(FoxnicWeb.CHS_CHANGE_INSTANCE.ID).join(FoxnicWeb.CHS_CHANGE_APPROVER.INSTANCE_ID).conditionEquals(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_TYPE, UnifiedUserType.busi_role.code())
				.using(FoxnicWeb.CHS_CHANGE_APPROVER.APPROVER_ID).join(FoxnicWeb.SYS_BUSI_ROLE.ID)
		;

		//变更实例 - 流程定义
		this.property(ChangeInstanceMeta.DEFINITION_PROP)
				.using(FoxnicWeb.CHS_CHANGE_INSTANCE.DEFINITION_ID).join(FoxnicWeb.CHS_CHANGE_DEFINITION.ID);
		;

	}






}
