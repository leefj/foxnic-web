package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.bpm.Role;
import org.github.foxnic.web.domain.bpm.RoleEmployee;
import org.github.foxnic.web.domain.bpm.meta.RoleEmployeeMeta;
import org.github.foxnic.web.domain.bpm.meta.RoleMeta;

public class BpmRelationManager extends RelationManager {

	@Override
	protected void config() {

		//角色下的员工清单
		this.property(RoleMeta.EMPLOYEES_PROP)
			.using(FoxnicWeb.BPM_ROLE.ID).join(FoxnicWeb.BPM_ROLE_EMPLOYEE.ROLE_ID)
			.using(FoxnicWeb.BPM_ROLE_EMPLOYEE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
		;

		//角色下员工数量统计
		this.property(Role.class,RoleMeta.EMP_COUNT, RoleEmployee.class)
				.using(FoxnicWeb.BPM_ROLE.ID).join(FoxnicWeb.BPM_ROLE_EMPLOYEE.ROLE_ID)
				.groupForCount();
		;


		//角色员工关系 - 员工
		this.property(RoleEmployeeMeta.EMPLOYEE_PROP)
				.using(FoxnicWeb.BPM_ROLE_EMPLOYEE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
		;


	}




}
