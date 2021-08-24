package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.oauth.*;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;

import java.util.List;

public class OAuthRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupMenu();
		this.setupUser();
		this.setupRole();
	}

	/**
	 * 扩展菜单模型
	 * */
	public void setupMenu() {

		//路径ID映射到路径资源
		this.property(MenuMeta.PATH_RESOURCE_PROP)
			.using(SYS_MENU.PATH_RESOURCE_ID).join(SYS_RESOURZE.ID)
			.after((menu,res)->{
				if(!res.isEmpty()) {
					menu.setPath(res.get(0).getUrl());
				}
			return res;
		});


		//菜单包含的资源清单
		this.property(MenuMeta.RESOURCES_PROP)
			.using(SYS_MENU.ID).join(SYS_MENU_RESOURCE.MENU_ID).condition("version is not null")
		    .using(SYS_MENU_RESOURCE.RESOURCE_ID).join(SYS_RESOURZE.ID).condition("version is not null")
			.addOrderBy(SYS_RESOURZE.URL,true,true).after((menu,res)->{
				List<String> resIds= CollectorUtil.collectList(res,Resourze::getId);
				menu.setResourceIds(resIds);
				return res;
		}).fork(32);

		/**
		 * 上级菜单
		 * */
		this.property(MenuMeta.PARENT_PROP)
		.using(SYS_MENU.PARENT_ID).join(SYS_MENU.ID).after((menu,parents)->{
			return parents;
		});
	}



	/**
	 * 扩展用户模型
	 * */
	private void setupUser() {

		// 用户 - 角色
		this.property(UserMeta.ROLES_PROP)
				.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
				.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE.ID);

		// 用户 - 菜单
		this.property(UserMeta.MENUS_PROP)
				.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
				.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE_MENU.ROLE_ID)
				.using(SYS_ROLE_MENU.MENU_ID).join(SYS_MENU.ID)
				.addOrderBy(SYS_MENU.SORT,true,true);

		// 用户 - 角色菜单关系
		this.property(UserMeta.ROLE_MENUS_PROP)
				.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
				.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE_MENU.ROLE_ID);

		//
		this.property(SessionOnlineMeta.USER_PROP)
				.using(SYS_SESSION_ONLINE.USER_ID).join(SYS_USER.ID);

		// 用户 - 人员
		this.property(UserMeta.PERSON_PROP)
				.using(SYS_USER.PERSON_ID).join(HRM_PERSON.ID);

		// 用户 - 员工
		this.property(UserMeta.EMPLOYEE_PROP)
				.using(SYS_USER.EMPLOYEE_ID).join(HRM_EMPLOYEE.ID);

	}

	/**
	 * 扩展用户模型
	 * */
	private void setupRole() {

		// 角色 - 菜单
		this.property(RoleMeta.MENUS_PROP)
				.using(SYS_ROLE.ID).join(SYS_ROLE_MENU.MENU_ID)
				.using(SYS_ROLE_MENU.MENU_ID).join(SYS_ROLE.ID)
				.after((role,menus)->{
					role.setMenuIds(CollectorUtil.collectList(menus,Menu::getId));
					return menus;
				});
	}

}
