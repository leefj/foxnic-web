package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import org.github.foxnic.web.domain.system.meta.*;

public class SystemRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupDictProperties();
		this.setupTenantProperties();
		this.setupBusiRoleProperties();
	}

	public void setupDictProperties() {
		//字典 - 模块关联关系
		this.property(DictMeta.MODULE_INFO_PROP)
				.using(FoxnicWeb.SYS_DICT.MODULE).join(FoxnicWeb.SYS_MENU.ID);

		//字典 - 下级条目关联关系
		this.property(DictMeta.ITEMS_PROP)
				.using(FoxnicWeb.SYS_DICT.ID).join(FoxnicWeb.SYS_DICT_ITEM.DICT_ID);
	}

	public void setupTenantProperties() {

		//租户 - 公司关联关系
		this.property(TenantMeta.COMPANY_PROP)
				.using(FoxnicWeb.SYS_TENANT.COMPANY_ID).join(FoxnicWeb.HRM_COMPANY.ID);


		//用户所属租户 -租户关联关系
		this.property(UserTenantMeta.TENANT_PROP)
				.using(FoxnicWeb.SYS_USER_TENANT.OWNER_TENANT_ID).join(FoxnicWeb.SYS_TENANT.ID);

		//用户所属租户 -员工关联关系
		this.property(UserTenantMeta.EMPLOYEE_PROP)
				.using(FoxnicWeb.SYS_USER_TENANT.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}


	/**
	 *
	 * */
	public void setupBusiRoleProperties() {

		//角色下的成员(员工)清单
		this.property(BusiRoleMeta.EMPLOYEES_PROP)
				.using(FoxnicWeb.SYS_BUSI_ROLE.ID).join(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.ROLE_ID).conditionEquals(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_TYPE, UnifiedUserType.employee)
				.using(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
		;

		//角色下成员数量统计
		this.property(BusiRole.class,BusiRoleMeta.EMP_COUNT, BusiRoleMember.class)
				.using(FoxnicWeb.SYS_BUSI_ROLE.ID).join(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.ROLE_ID)
				.groupForCount();
		;

		//角色成员关系 - 员工
		this.property(BusiRoleMemberMeta.EMPLOYEE_PROP)
				.using(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
		;

	}




}
