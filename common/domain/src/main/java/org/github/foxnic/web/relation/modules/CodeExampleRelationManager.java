package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;

public class CodeExampleRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupProperties();
	}
 
	public void setupProperties() {


		//
		this.property(CodeExampleMeta.RESOURZE_PROP)
			.using(SYS_CODE_EXAMPLE.RESOURCE_ID).join(SYS_RESOURZE.ID);

		//
		this.property(CodeExampleMeta.ROLES_PROP)
			.using(SYS_CODE_EXAMPLE.ID).join(SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID)
			.using(SYS_CODE_EXAMPLE_ROLE.ROLE_ID).join(SYS_ROLE.ID)
			.after((example,roles)->{
				//统计角色数量
				example.setRoleCountByAfter(roles.size());
				return roles;
			})
		;




	}


}
