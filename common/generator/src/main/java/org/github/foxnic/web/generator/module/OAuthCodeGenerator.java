package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.HttpMethodType;
import org.github.foxnic.web.constants.enums.Language;
import org.github.foxnic.web.constants.enums.ResourceType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.meta.*;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;


public class OAuthCodeGenerator extends SystemCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		OAuthCodeGenerator g=new OAuthCodeGenerator();
		g.generateSysResource();
		g.generateSysMenuResource();
		g.generateSysUser();
//		g.generateSysOAuthClient();
//		g.generateSysSessionOnline();
//		g.generateSysToken();
		g.generateSysRole();
		g.generateSysRoleUser();
		g.generateSysMenu();
		g.generateSysRoleMenu();
		
	}
 
	public OAuthCodeGenerator() {
		super("service-oauth");
	}
 
	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}
	
 
	public void generateSysUser() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_USER.$TABLE, 6);

		cfg.getPoClassFile().addListProperty( Role.class, "roles","角色清单", "当前用户的所有角色清单");
		cfg.getPoClassFile().addListProperty( Menu.class, "menus","菜单清单", "当前用户的所有菜单清单");
		cfg.getPoClassFile().addListProperty( RoleMenu.class, "roleMenus","角色菜单关系清单", "当前用户的所有角色菜单关系清单");

		//增加VO属性
		cfg.getVoClassFile().addListProperty(String.class,"roleIds","角色ID列表","");

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
		

		PojoClassFile pojo=cfg.createPojo("LoginIdentityVO");
		pojo.setSuperType(null);
		pojo.setDoc("用于App登录接口");
		pojo.addSimpleProperty(String.class,"identity","帐号或手机号等用于识别身份的标识","");
		pojo.addSimpleProperty(String.class,"passwd","密码","");
		pojo.addSimpleProperty(String.class,"browserId","随机ID","客户端产生的唯一ID，用于标识一次认证");
		pojo.addSimpleProperty(String.class,"captcha","校验码/验证码","用户输入的校验码");


		cfg.view().field(SYS_USER.ID)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.ID)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.PASSWD)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.EMPLOYEE_ID)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.LAST_LOGIN_TIME)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.PERSON_ID)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.EMPLOYEE_ID)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.PASSWD)
				.basic().hidden(true);

		cfg.view().field(SYS_USER.NAME)
				.form().validate().required()
				.search().displayAlone(true)
		;

		cfg.view().field(SYS_USER.PHONE)
				.form().validate().required().phone();

		cfg.view().field(SYS_USER.LANGUAGE)
				.form().radio().enumType(Language.class);

		cfg.view().field(UserVOMeta.ROLE_IDS)
				.basic().label("角色")
				.list().hidden(true)
				.form().select().muliti(true).queryApi(RoleServiceProxy.QUERY_LIST).fillBy(UserMeta.ROLES)
		;

		cfg.view().field(SYS_USER.PORTRAIT_ID)
				.basic().label("头像")
				.search().hidden(true)
				.list().alignCenter()
				.form().upload().acceptSingleImage().buttonLabel("选择头像")
		;

		cfg.view().field(SYS_USER.VALID)
				.list().alignCenter()
				.form().logic().on("有效","1").off("无效","0");

		//表单不需要显示的字段
//		cfg.view().field(SYS_USER.ID).hideInList().hideInForm();
//		cfg.view().field(SYS_USER.PASSWD).hideInList().hideInForm();
//		cfg.view().field(SYS_USER.EMPLOYEE_ID).hideInForm().hideInList();
//		cfg.view().field(SYS_USER.LAST_LOGIN_TIME).hideInForm();
//		cfg.view().field(SYS_USER.PERSON_ID).hideInForm().hideInList();
//		cfg.view().field(SYS_USER.EMPLOYEE_ID).hideInForm();
//		cfg.view().field(SYS_USER.PASSWD).hideInForm();
		//配置校验
//		cfg.view().field(SYS_USER.NAME).validate().required();
//		cfg.view().field(SYS_USER.NAME).search().displayAlone(true);

//		cfg.view().field(SYS_USER.PHONE).validate().required().phone();
		//配置单选
//		cfg.view().field(SYS_USER.LANGUAGE).radioField().enumType(Language.class);
//		cfg.view().field(SYS_USER.LANGUAGE).checkField().enumType(Language.class);
//		cfg.view().field(SYS_USER.LANGUAGE).checkField().dict(DictEnum.ORDER_STATUS);
		//配置数据库表字段外的输入框



//		cfg.view().field(UserVOMeta.ROLE_IDS).label("角色").hideInList().selectField().muliti(true).queryApi(RoleServiceProxy.QUERY_LIST).fillBy(UserMeta.ROLES);
		//使用枚举
		//cfg.view().field(UserVOMeta.ROLE_IDS).label("角色").selectField().muliti().enumType(Language.class);
		//使用字典数据
//		cfg.view().field(UserVOMeta.ROLE_IDS).label("角色").selectField().muliti().dict(DictEnum.COMPANY_TYPE);

//		cfg.view().field(SYS_USER.PORTRAIT_ID).label("头像").hideInSearch().alignCenterInList().uploadField().acceptSingleImage().buttonLabel("选择头像");
//		cfg.view().field(SYS_USER.VALID).alignCenterInList().logicField().on("有效","1").off("无效","0");

		//生成代码
		cfg.buildAll();
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

	public void generateSysResource() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_RESOURZE.$TABLE, 6);

//		cfg.view().field(SYS_RESOURZE.ID).hideInList();
//		cfg.view().field(SYS_RESOURZE.METHOD).label("Method").radioField().enumType(HttpMethodType.class);
//		cfg.view().field(SYS_RESOURZE.TYPE).radioField().enumType(ResourceType.class);
//		cfg.view().field(SYS_RESOURZE.NAME).validate().required();
//		cfg.view().field(SYS_RESOURZE.URL).validate().required();
//		cfg.view().field(SYS_RESOURZE.BATCH_ID).hideInForm().hideInList();
//		cfg.view().field(SYS_RESOURZE.MODULE).label("模块");
//		cfg.view().field(SYS_RESOURZE.TABLE_NAME).label("数据表");

		cfg.view().field(SYS_RESOURZE.ID).list().hidden(true);

		cfg.view().field(SYS_RESOURZE.METHOD)
				.basic().label("Method")
				.form().radio().enumType(HttpMethodType.class);

		cfg.view().field(SYS_RESOURZE.TYPE).form().radio().enumType(ResourceType.class);
		cfg.view().field(SYS_RESOURZE.NAME).form().validate().required();
		cfg.view().field(SYS_RESOURZE.URL).form().validate().required();
		cfg.view().field(SYS_RESOURZE.BATCH_ID).basic().hidden(true);
		cfg.view().field(SYS_RESOURZE.MODULE).basic().label("模块");
		cfg.view().field(SYS_RESOURZE.TABLE_NAME).basic().label("数据表");

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
		//增加菜单选择
		cfg.view().field(RoleMeta.MENU_IDS).basic().label("菜单权限")
				.list().hidden(true);



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

		//
		cfg.getPoClassFile().addSimpleProperty(String.class,"path","页面路径","");
		cfg.getPoClassFile().addListProperty(String.class,"resourceIds","资源ID清单","");
		cfg.getPoClassFile().addSimpleProperty(String.class,"ancestorsNamePath","祖先名称路径","用斜杠隔开");



		cfg.getVoClassFile().addSimpleProperty(String.class,"roleId","菜单角色","从前端传入，指定勾选指定角色的菜单");
		cfg.getVoClassFile().addSimpleProperty(Integer.class,"isLoadAllDescendants","是否加载所有子孙节点","1：是；0：否");





//		cfg.view().field(SYS_MENU.PATH_RESOURCE_ID).selectField().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(false).paging(true).fillBy(MenuVOMeta.PATH_RESOURCE_ID);
//		cfg.view().field(MenuMeta.RESOURCE_IDS).label("资源清单").selectField().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(true).paging(true).fillBy(MenuVOMeta.RESOURCE_IDS);

		cfg.view().field(SYS_MENU.PATH_RESOURCE_ID).form().select().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(false).paging(true).fillBy(MenuVOMeta.PATH_RESOURCE_ID);
		cfg.view().field(MenuMeta.RESOURCE_IDS).basic().label("资源清单")
				.form().select().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).muliti(true).paging(true).fillBy(MenuVOMeta.RESOURCE_IDS);

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


	
	

}
