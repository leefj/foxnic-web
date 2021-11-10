package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.changes.meta.ChangeInstanceMeta;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.system.UserTenant;

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
			.after((menu,res,m)->{
				if(!res.isEmpty()) {
					menu.setPath(res.get(0).getUrl());
				}
			return res;
		}).fork(128);


		//菜单包含的资源清单
		this.property(MenuMeta.RESOURCES_PROP)
			.using(SYS_MENU.ID).join(SYS_MENU_RESOURCE.MENU_ID).condition("version is not null")
		    .using(SYS_MENU_RESOURCE.RESOURCE_ID).join(SYS_RESOURZE.ID).condition("version is not null")
			.addOrderBy(SYS_RESOURZE.URL,true,true).after((menu,res,m)->{
				List<String> resIds= CollectorUtil.collectList(res,Resourze::getId);
				menu.setResourceIds(resIds);
				return res;
		}).fork(128);

		/**
		 * 上级菜单
		 * */
		this.property(MenuMeta.PARENT_PROP)
		.using(SYS_MENU.PARENT_ID).join(SYS_MENU.ID).after((menu,parents,m)->{
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
				.addOrderBy(SYS_MENU.SORT,true,true).fork(128);

		// 用户 - 角色菜单关系
		this.property(UserMeta.ROLE_MENUS_PROP)
				.using(SYS_USER.ID).join(SYS_ROLE_USER.USER_ID)
				.using(SYS_ROLE_USER.ROLE_ID).join(SYS_ROLE_MENU.ROLE_ID).fork(128);

		//
		this.property(SessionOnlineMeta.USER_PROP)
				.using(SYS_SESSION_ONLINE.USER_ID).join(SYS_USER.ID);

		// 用户 - 所属租户
		this.property(UserMeta.JOINED_TENANTS_PROP)
				.using(SYS_USER.ID).join(SYS_USER_TENANT.USER_ID).condition("valid=1")
				.addOrderBy(SYS_USER_TENANT.ACTIVATED,false,true)
				.addOrderBy(SYS_USER_TENANT.SORT,true,true)
		.after((user,tenants,m)->{
			for (UserTenant tenant : tenants) {
				//设置当前激活的租户
				if(user.getActivatedTenant()==null  && tenant.getActivated()==1) {
					user.setActivatedTenant(tenant);
					user.setActivatedEmployeeId(tenant.getEmployeeId());
				}
			}
			//设置默认激活的租户
			if(user.getActivatedTenant()==null && tenants.size()>0) {
				user.setActivatedTenant(tenants.get(0));
			}
			return tenants;
		});


	}

	/**
	 * 扩展用户模型
	 * */
	private void setupRole() {

		// 角色 - 菜单
		this.property(RoleMeta.MENUS_PROP)
				.using(SYS_ROLE.ID).join(SYS_ROLE_MENU.MENU_ID)
				.using(SYS_ROLE_MENU.MENU_ID).join(SYS_ROLE.ID)
				.after((role,menus,m)->{
					role.setMenuIds(CollectorUtil.collectList(menus,Menu::getId));
					return menus;
				}).fork(128);
	}



}
