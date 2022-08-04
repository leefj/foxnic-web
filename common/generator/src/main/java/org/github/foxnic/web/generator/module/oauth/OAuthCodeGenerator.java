package org.github.foxnic.web.generator.module.oauth;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.*;
import org.github.foxnic.web.generator.module.system.SystemCodeGenerator;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;


public class OAuthCodeGenerator extends SystemCodeGenerator {

	public static void main(String[] args) throws Exception {
		OAuthCodeGenerator g=new OAuthCodeGenerator();
//		g.generateSysResource();  //ok
//		g.generateSysMenuResource();
//		g.generateSysUser(); //ok
//		g.generateSysOAuthClient();
//		g.generateSysSessionOnline();
//		g.generateSysToken();
		g.generateSysRole();
//		g.generateSysRoleUser();
//		g.generateSysMenu();
//		g.generateSysRoleMenu();

	}

	public OAuthCodeGenerator() {
		super("service-oauth");
	}

	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}




	public void generateSysOAuthClient() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_OAUTH_CLIENT.$TABLE, 7);

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页

		//生成代码
		cfg.buildAll();
	}



	public void generateSysSessionOnline() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_SESSION_ONLINE.$TABLE, 6);

		cfg.getPoClassFile().addSimpleProperty(User.class,"user","账户","");

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

		cfg.view().field(SYS_SESSION_ONLINE.ID)
			.table().hidden().search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.REFRESH_TOKEN)
				.table().hidden().search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.ACCESS_TOKEN)
				.table().hidden().search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.SESSION_ID)
			.table().hidden().search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.HOST_ID)
				.table().hidden().search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.NODE_ID)
				.table().hidden().search().hidden();


		cfg.view().field(SYS_SESSION_ONLINE.USER_ID)
			.basic().label("账户")
			.table().fillBy(SessionOnlineMeta.USER,UserMeta.REAL_NAME)
			.search().hidden();


		cfg.view().field(SYS_SESSION_ONLINE.LOGOUT_TIME)
				.search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.LOGIN_TIME)
				.form().dateInput()
				.search().range();

		cfg.view().field(SYS_SESSION_ONLINE.INTERACT_TIME).basic().label("最后交互")
			.form().dateInput()
			.search().range();

		cfg.view().field(SYS_SESSION_ONLINE.INTERACT_URL).basic().label("最后访问")
			.search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.SESSION_TIME)
				.search().hidden();

		cfg.view().field(SYS_SESSION_ONLINE.ONLINE)
				.table().hidden().search().hidden();


		cfg.view().list().disableBatchDelete();
//		cfg.view().list().disableCreateNew();
		cfg.view().list().disableModify();
		cfg.view().list().disableSingleDelete();
		cfg.view().list().disableSpaceColumn();
		cfg.view().list().disableCreateNew();

		//设置标签宽度
		cfg.view().form().labelWidth(85);

		//生成代码
		cfg.buildAll();
	}


	public void generateSysMenuResource() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_MENU_RESOURCE.$TABLE, 6);

		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.IGNORE) //Rest
				.setPageController(WriteMode.IGNORE) //页面控制器
				.setFormPage(WriteMode.IGNORE) //表单HTML页
				.setListPage(WriteMode.IGNORE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}


	public void generateSysToken() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_TOKEN.$TABLE, 6);

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页

		//生成代码
		cfg.buildAll();
	}


	public void generateSysRole() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_ROLE.$TABLE, 6);

		cfg.getPoClassFile().addListProperty(Menu.class, "menus","菜单清单", "当前角色的所有菜单");
		cfg.getPoClassFile().addListProperty(String.class,"menuIds","所拥有的菜单ID清单","");

		cfg.view().field(SYS_ROLE.ID).basic().hidden(true);

		cfg.view().field(SYS_ROLE.CODE).search().fuzzySearch();
		cfg.view().field(SYS_ROLE.NAME).search().fuzzySearch();

		//增加菜单选择
		cfg.view().field(RoleMeta.MENU_IDS).basic().label("菜单权限")
				.search().hidden()
				.table().hidden(true);



		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页

		//生成代码
		cfg.buildAll();
	}


	public void generateSysRoleUser() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_ROLE_USER.$TABLE, 6);

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.IGNORE) //Rest
		.setPageController(WriteMode.IGNORE) //页面控制器
		.setFormPage(WriteMode.IGNORE) //表单HTML页
		.setListPage(WriteMode.IGNORE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}

	public void generateSysRoleMenu() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_ROLE_MENU.$TABLE, 6);

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.IGNORE) //Rest
		.setPageController(WriteMode.IGNORE) //页面控制器
		.setFormPage(WriteMode.IGNORE) //表单HTML页
		.setListPage(WriteMode.IGNORE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}

	public void generateSysMenu() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_MENU.$TABLE, 6);

		cfg.getPoClassFile().addSimpleProperty(Resourze.class,"pathResource","路径资源","");
		cfg.getPoClassFile().addListProperty(Resourze.class,"resources","菜单包含的资源清单","");
		cfg.getPoClassFile().addSimpleProperty(Menu.class,"parent","上级菜单","");


//		cfg.getPoClassFile().shadow(SYS_MENU.TYPE, MenuType.class,"menuTypeEnum");

		//
		cfg.getPoClassFile().addSimpleProperty(String.class,"path","页面路径","");
		cfg.getPoClassFile().addListProperty(String.class,"resourceIds","资源ID清单","");
		cfg.getPoClassFile().addSimpleProperty(String.class,"ancestorsNamePath","祖先名称路径","用斜杠隔开");



		cfg.getVoClassFile().addSimpleProperty(String.class,"roleId","菜单角色","从前端传入，指定勾选指定角色的菜单");
		cfg.getVoClassFile().addSimpleProperty(Integer.class,"isLoadAllDescendants","是否加载所有子孙节点","1：是；0：否");





//		cfg.view().field(SYS_MENU.PATH_RESOURCE_ID).selectField().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(false).paging(true).fillBy(MenuVOMeta.PATH_RESOURCE_ID);
//		cfg.view().field(MenuMeta.RESOURCE_IDS).label("资源清单").selectField().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(true).paging(true).fillBy(MenuVOMeta.RESOURCE_IDS);

		cfg.view().field(SYS_MENU.PATH_RESOURCE_ID).form().selectBox().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(false).paging(true).fillWith(MenuVOMeta.PATH_RESOURCE_ID);
		cfg.view().field(MenuMeta.RESOURCE_IDS).basic().label("资源清单")
				.form().selectBox().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(true).paging(true).fillWith(MenuVOMeta.RESOURCE_IDS);

		cfg.view().field(SYS_MENU.LABEL).form().validate().required();
		cfg.view().field(SYS_MENU.TYPE).form().validate().required();

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页

		//生成代码
		cfg.buildAll();
	}





}
