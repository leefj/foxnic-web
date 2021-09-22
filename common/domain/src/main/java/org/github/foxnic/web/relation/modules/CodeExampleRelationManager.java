package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_ROLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_RESOURZE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.system.CodeExampleCar;
import org.github.foxnic.web.domain.system.meta.CodeExampleCarMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;

public class CodeExampleRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupProperties();
	}
 
	public void setupProperties() {


		//关联
		this.property(CodeExampleMeta.RESOURZE_PROP)
			.using(SYS_CODE_EXAMPLE.RESOURCE_ID).join(SYS_RESOURZE.ID);

		//关联
		this.property(CodeExampleMeta.ROLES_PROP)
			.using(SYS_CODE_EXAMPLE.ID).join(SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID).condition("version > ?",-1)
			.using(SYS_CODE_EXAMPLE_ROLE.ROLE_ID).join(SYS_ROLE.ID).condition("version > ?",-2)
			.after((example,roles,map)->{
				//统计角色数量
				example.setRoleCountByAfter(roles.size());
				return roles;
			});

		//分组统计
		this.property(CodeExample.class,CodeExampleMeta.ROLE_COUNT_BY_JOIN, Role.class)
				.using(SYS_CODE_EXAMPLE.ID).join(SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID).condition("version > ?",-1)
				.using(SYS_CODE_EXAMPLE_ROLE.ROLE_ID).join(SYS_ROLE.ID).condition("version > ?",-2)
				.groupForCount();


		//关联组织
		this.property(CodeExampleCar.class, CodeExampleCarMeta.ORGANIZATION, Organization.class)
				.using(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		//关联组织
		this.property(CodeExampleCar.class, CodeExampleCarMeta.SUB_ORGANIZATION, Organization.class)
				.using(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.SUB_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		//关联组织(公司)
		this.property(CodeExampleCar.class, CodeExampleCarMeta.COMPANY, Organization.class)
				.using(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.COM_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		//关联岗位
		this.property(CodeExampleCar.class, CodeExampleCarMeta.POSITION, Position.class)
				.using(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.POSITION_ID).join(FoxnicWeb.HRM_POSITION.ID);

		//关联岗位
		this.property(CodeExampleCar.class, CodeExampleCarMeta.EMPLOYEE, Employee.class)
				.using(FoxnicWeb.SYS_CODE_EXAMPLE_CAR.EMP_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}


}
