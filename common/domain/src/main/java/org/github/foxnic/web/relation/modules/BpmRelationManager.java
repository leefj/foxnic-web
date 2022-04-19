package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.meta.FormInstanceMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;

public class BpmRelationManager extends RelationManager {


	@Override
	protected void config() {
		setupBpm();
		setupChanges();
	}

	protected void setupBpm() {

		//流程定义 - 账户(最后更新人)
		this.property(ProcessDefinitionMeta.LAST_UPDATE_USER_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.UPDATE_BY).join(FoxnicWeb.SYS_USER.ID);
		;

		//流程定义 - 当前激活的流程定义文件
		this.property(ProcessDefinitionMeta.DEFINITION_FILE_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.DEFINITION_ID)
				.conditionEquals(FoxnicWeb.BPM_PROCESS_DEFINITION_FILE.ACTIVATED,1);
		;

		//流程定义 - 表单定义
		this.property(ProcessDefinitionMeta.FORM_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID).join(FoxnicWeb.BPM_FORM_DEFINITION.ID);
		;

		//流程实例 - 流程定义
		this.property(ProcessInstanceMeta.PROCESS_DEFINITION_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID).join(FoxnicWeb.BPM_PROCESS_DEFINITION.ID);
		;

		//流程实例 - 表单实例
		this.property(ProcessInstanceMeta.FORM_INSTANCE_PROP)
				.using(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).join(FoxnicWeb.BPM_FORM_INSTANCE.ID);
		;

		//流程实例 - 业务单据
		this.property(FormInstanceMeta.BILLS_PROP)
				.using(FoxnicWeb.BPM_FORM_INSTANCE.ID).join(FoxnicWeb.BPM_FORM_INSTANCE_BILL.FORM_INSTANCE_ID);
		;





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
