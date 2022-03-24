package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;

public class BpmRelationManager extends RelationManager {


	@Override
	protected void config() {
		setupBpm();
		setupChanges();
	}

	protected void setupBpm() {

		//流程定义 - 账户
		this.property(ProcessDefinitionMeta.LAST_UPDATE_USER_PROP)
				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.UPDATE_BY).join(FoxnicWeb.SYS_USER.ID);
		;

//		//流程定义 - 账户
//		this.property(ProcessDefinitionMeta.LAST_UPDATE_USER_PROP)
//				.using(FoxnicWeb.BPM_PROCESS_DEFINITION.UPDATE_BY).join(FoxnicWeb.SYS_USER.ID);
//		;


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
