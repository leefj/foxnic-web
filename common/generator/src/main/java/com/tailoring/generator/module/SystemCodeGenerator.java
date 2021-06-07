package com.tailoring.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.proxy.MicroServiceNames;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import com.tailoring.generator.config.FoxnicWebConfigs;
import com.tailoring.generator.config.FoxnicWebConfigs.ProjectConfigs;
 
 

/**
 * 为以usr_开头的表生成代码
 */
public class SystemCodeGenerator  {
 
	public static void main(String[] args) throws Exception {
		SystemCodeGenerator g=new SystemCodeGenerator();
		// 
		g.generateSysConfig();
//		//
//		g.generateSysDict();
//		//
//		g.generateSysDictItem();
//		//
 
 
//		//
//		g.generateSysArea();
//		//
		g.generateSysLang();

		
	}
	
	private FoxnicWebConfigs configs;
	
 
	public SystemCodeGenerator() {
		this("service-system");
	}
	
	public SystemCodeGenerator(String appConfigPrefix) {
		configs=new FoxnicWebConfigs(appConfigPrefix);
	}
	
	
	protected ModuleContext createModuleConfig(DBTable table,String tablePrefix,int apiSort) {

		//项目配置
		ProjectConfigs procfg=this.configs.getProjectConfigs();
		
		ModuleContext mdu=new ModuleContext(this.configs.getSettings(),table,tablePrefix,procfg.getAppPackageName());
		//设置页面的代码文件路径
		mdu.setViewPrefixPath(procfg.getAppViewPrefixPath());
		//设置页面访问的基础URI
		mdu.setViewPrefixURI(procfg.getAppViewPrefixURI());
		//设置 DAO
		mdu.setDAO(this.configs.getDAO());
		//设置 Domain Project
		mdu.setDomainProject(this.configs.getDomianProject());
		//设置 Proxy Project
		mdu.setProxyProject(this.configs.getProxyProject());
		//设置 Service Project
		mdu.setServiceProject(this.configs.getServiceProject());
		//设置 View Project
		mdu.setViewProject(this.configs.getViewProject());
		//设置 Wrapper Project
		mdu.setWrapperProject(this.configs.getWrapperProject());
		//设置DAO名称常量
		mdu.setDAONameConsts(procfg.getDAONameConst());
		//设置微服务命名常量
		mdu.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+procfg.getAppMicroServiceNameConst());
 
		return mdu;
 
	}
	
	
	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}
	
	
	public void generateSysConfig() throws Exception {	
		
		//创建模块配置
		ModuleContext cfg=createModuleConfig(SYS_CONFIG.$TABLE, 1);
		
		
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
	
	
	
	 


	
//	public void generateSysDict() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_DICT.$TABLE, 2);
//		//生成代码
//		mducfg.buildAll();
////		generator.build(mducfg);
//	
//	}
//	
//	public void generateSysDictItem() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_DICT_ITEM.$TABLE, 3);
//		//生成代码
////		Context ctx=generator.build(mducfg);
//		mducfg.buildAll();
//		
//		
//	
//	}
//	
//	
//	
//	public void generateSysUser() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_USER.$TABLE, 4);
//		
//		//
////		mducfg.getDefaultVO().addListProperty("roleIds", Integer.class, "角色ID清单", "");
//		mducfg.getVoClassFile().addProperty(PojoProperty.list(Integer.class, "roleIds", "角色ID清单", ""));
//		
////		Pojo userEditModel=new Pojo();
////		userEditModel.setName("UserEditModel");
////		userEditModel.setDoc("用户编辑数据模型");
////		userEditModel.addListProperty("roleIds",Integer.class,"角色ID清单","");
////		mducfg.addPojo(userEditModel);
//		
////		MduCtx ctx=mducfg.getMductx();
//		
//		PojoClassFile pojo=mducfg.createPojo("UserEditModel");
//		pojo.addListProperty(Integer.class,"roleIds","角色ID清单","");
//	 
//		
//		
////		Pojo appLoginVO=new Pojo();
////		appLoginVO.setSuperClass(""); //继承 Entity
////		appLoginVO.setName("LoginAppVO");
////		appLoginVO.addProperty("identity",String.class,"帐号或手机号","");
////		appLoginVO.addProperty("passwd",String.class,"密码","");
////		mducfg.addPojo(appLoginVO);
//		
//		pojo=mducfg.createPojo("LoginAppVO");
//		pojo.setDoc("用于PC登录接口");
//		pojo.addSimpleProperty(String.class,"identity","帐号或手机号","");
//		pojo.addSimpleProperty(String.class,"passwd","密码","");
//		
//		
////		Pojo consoleLoginVO=new Pojo();
////		consoleLoginVO.setSuperClass(""); //继承 Entity
////		consoleLoginVO.setName("LoginConsoleVO");
////		consoleLoginVO.addProperty("identity",String.class,"帐号或手机号","");
////		consoleLoginVO.addProperty("passwd",String.class,"密码","");
////		consoleLoginVO.addProperty("deviceId",String.class,"设备ID","客户端产生的UUID");
////		consoleLoginVO.addProperty("code",String.class,"校验码","用户输入的校验码");
////		mducfg.addPojo(consoleLoginVO);
//		
//		
//		pojo=mducfg.createPojo("LoginConsoleVO");
//		pojo.setDoc("用于App登录接口");
//		pojo.addSimpleProperty(String.class,"identity","帐号或手机号","");
//		pojo.addSimpleProperty(String.class,"passwd","密码","");
//		pojo.addSimpleProperty(String.class,"deviceId","设备ID","客户端产生的UUID");
//		pojo.addSimpleProperty(String.class,"code","校验码","用户输入的校验码");
//
//		// 生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	
//	}
//	
//	
	private void generateSysLang() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_LANG.$TABLE, 5);
		
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
//	
//	
//	public void generateSysRole() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_ROLE.$TABLE, 5);
// 
//		mducfg.overrides().setControllerAndAgent(WriteMode.DO_NOTHING)
//		.setPageController(WriteMode.DO_NOTHING);
//		//生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	
//	}
//	
//	
//	public void generateSysUserRole() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_USER_ROLE.$TABLE, 5);
//		//生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	
//	}
//	
//	
//	public void generateSysMenu() throws Exception {
// 
//		//创建模块配置对象
//		MduCtx mducfg=createModuleConfig(SYS_MENU.$TABLE, 5);
////		MduCtx ctx=mducfg.getMductx();
//		
////		Pojo menuNodeModel=new Pojo();
////		menuNodeModel.setName("MenuNodeModel");
////		menuNodeModel.addProperty("hidden", Boolean.class, "是否隐藏", "");
////		menuNodeModel.addListProperty("subMenus","MenuNodeModel","下级菜单节点","");
////		mducfg.addPojo(menuNodeModel);
//		
//		PojoClassFile pojo = mducfg.createPojo("MenuNodeModel");
//		pojo.addSimpleProperty(Boolean.class, "hidden", "是否隐藏", "");
//		pojo.addListProperty(pojo, "subMenus", "下级菜单节点","");
//		
//		// 生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	
//	}
//	
//	
//	public void generateSysFile() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_FILE.$TABLE, 6);
//		//生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	}
//
//	public void generateSysArea() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_AREA.$TABLE, 7);
//		
//		
//		
//		//生成代码
//		mducfg.buildAll();
//	}
	
	 
	
	 
	
	
	

}
