package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_ROLE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_RESOURZE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.system.CodeExample;
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






	}


}
