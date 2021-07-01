package org.github.foxnic.web.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.oauth.*;

public class OAuthRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
 
	public void setupProperties() {
		// 用户 - 角色
		this.property(User.class, "roles", Role.class, "角色清单", "当前用户的所有角色清单").list()
			.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
			.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE.ID);



		// 用户 - 菜单
		this.property(User.class, "menus", Menu.class, "菜单清单", "当前用户的所有菜单清单").list()
			.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
			.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE_MENU.ROLE_ID)
			.using(SYS_ROLE_MENU.MENU_ID).join(SYS_MENU.ID)
			.addOrderBy(SYS_MENU.SORT,true,true);



		// 用户 - 角色菜单关系
		this.property(User.class, "roleMenus", RoleMenu.class, "角色菜单关系清单", "当前用户的所有角色菜单关系清单").list()
			.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
			.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE_MENU.ROLE_ID);

		//路径ID映射到路径资源
		this.property(Menu.class,"pathResource", Resourze.class,"路径资源","").single()
			.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
			.after((menu,res)->{
				if(!res.isEmpty()) {
					menu.setPath(res.get(0).getUrl());
				}
			return res;
		});


		//菜单包含的资源清单
		this.property(Menu.class,"resources", Resourze.class,"菜单包含的资源清单","").list()
			.using(SYS_MENU.ID).join(SYS_MENU_RESOURCE.MENU_ID)
		    .using(SYS_MENU_RESOURCE.RESOURCE_ID).join(SYS_RESOURZE.ID);


	}
	
	private void setupRelations() {
		// 菜单 - 菜单层级关系
//		this.from( SYS_MENU.ID ).join( SYS_MENU.PARENT_ID );
//
//		//菜单路径ID，到资源
//		this.from(SYS_MENU.PATH_RESOURCE_ID ).join( FoxnicWeb.SYS_RESOURZE.ID );
//		//菜单关系
//		this.from(SYS_MENU.ID ).join( FoxnicWeb.SYS_MENU_RESOURCE.MENU_ID );
//		//资源关联关系
//		this.from(FoxnicWeb.SYS_RESOURZE.ID).join(FoxnicWeb.SYS_MENU_RESOURCE.RESOURCE_ID);
//
//
//		// 用户 - 用户角色关系
//		this.from( SYS_USER.ID ).join( SYS_ROLE_USER.USER_ID );
//		// 角色 - 用户角色关系
//		this.from( SYS_ROLE.ID ).join( SYS_ROLE_USER.ROLE_ID );
//
//		//角色 - 角色菜单关系
//		this.from( SYS_ROLE.ID ).join( SYS_ROLE_MENU.ROLE_ID );
//		//菜单 - 角色菜单关系
//		this.from( SYS_MENU.ID ).join( SYS_ROLE_MENU.MENU_ID );
//
//		//用户角色关系 - 角色菜单关系
//		this.from( SYS_ROLE_USER.ROLE_ID ).join( SYS_ROLE_MENU.ROLE_ID );
		
	}

}
