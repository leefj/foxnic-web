package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_ROLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_RESOURZE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderMeta;
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
		this.setupCodeProperties();
		this.setupChangeProperties();
	}

	/**
	 * 变更示例的相关配置
	 * */
	public void setupChangeProperties() {
		//关联订单-订单明细
		this.property(ExampleOrderMeta.ITEMS_PROP)
				.using(FoxnicWeb.CHS_EXAMPLE_ORDER.ID).join(FoxnicWeb.CHS_EXAMPLE_ORDER_ITEM.ORDER_ID);
		//关联订单-下单人员
		this.property(ExampleOrderMeta.BUYER_EMPLOYEE_PROP)
				.using(FoxnicWeb.CHS_EXAMPLE_ORDER.BUYER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}

	/**
	 * 代码生成的相关配置
	 * */
	public void setupCodeProperties() {


		//关联
		this.property(CodeExampleMeta.RESOURZE_PROP)
			.using(SYS_CODE_EXAMPLE.RESOURCE_ID).join(SYS_RESOURZE.ID);

		//关联
		this.property(CodeExampleMeta.ROLES_PROP)
			.using(SYS_CODE_EXAMPLE.ID).join(SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID).condition("version > ?",-1)
			.using(SYS_CODE_EXAMPLE_ROLE.ROLE_ID).join(SYS_ROLE.ID).condition("version > ?",-2)
			.after((tag,example,roles,map)->{
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
