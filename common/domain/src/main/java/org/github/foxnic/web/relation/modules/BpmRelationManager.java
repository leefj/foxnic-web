package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;

public class BpmRelationManager extends RelationManager {


	@Override
	protected void config() {
//		setupBpm();
		setupChanges();
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

//	protected void setupBpm() {

//		//角色下的员工清单
//		this.property(RoleMeta.EMPLOYEES_PROP)
//			.using(FoxnicWeb.BPM_ROLE.ID).join(FoxnicWeb.BPM_ROLE_EMPLOYEE.ROLE_ID)
//			.using(FoxnicWeb.BPM_ROLE_EMPLOYEE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
//		;
//
//		//角色下员工数量统计
//		this.property(Role.class,RoleMeta.EMP_COUNT, RoleEmployee.class)
//				.using(FoxnicWeb.BPM_ROLE.ID).join(FoxnicWeb.BPM_ROLE_EMPLOYEE.ROLE_ID)
//				.groupForCount();
//		;
//
//
//		//角色员工关系 - 员工
//		this.property(RoleEmployeeMeta.EMPLOYEE_PROP)
//				.using(FoxnicWeb.BPM_ROLE_EMPLOYEE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
//		;


//	}




}
