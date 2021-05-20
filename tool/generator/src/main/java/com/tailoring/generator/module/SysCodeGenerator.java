package com.tailoring.generator.module;

import com.github.foxnic.generatorV2.config.MduCtx;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.tailoring.generator.config.FoxnicWebConstants;
 
 

/**
 * 为以usr_开头的表生成代码
 */
public class SysCodeGenerator extends ModuleGenerator {
 
	public static void main(String[] args) throws Exception {
		SysCodeGenerator g=new SysCodeGenerator();
		//按调用顺序呈现
		// 
//		g.generateSysConfig();
//		//
//		g.generateSysDict();
//		//
//		g.generateSysDictItem();
//		//
//		g.generateSysMenu();
		//
//		g.generateSysUser();
		//
//		g.generateSysRole();
//		//
//		g.generateSysUserRole();
		//
//		g.generateSysFile();
//		//
//		g.generateSysArea();
//		//
//		g.generateSysLang();

		
	}
	
	/**
	 * nacos 配置的 group
	 * */
	private static final String NACOS_GROUP="service";
	
	/**
	 * nacos 配置的 dataId
	 * */
	private static final String NACOS_DATA_ID="service_system.yml";
	
	/**
	 * 代码生成的微服务项目所在的目录
	 * */
	private static final String SERVICE_PROJECT_FOLDER="service-tailoring";
 
	/**
	 * 在 MicroServiceNames 类中定义的常量名
	 * */
	private static final String MICRO_SERVICE_NAME_CONST="TAILORING";
	
	/**
	 * 在配置中使用的数据源配置键
	 * */
	private static final String DATASOURCE_CONFIG_KEY="spring.datasource.druid.primary";
	
	/**
	 * 界面基础路径
	 * */
	private static final String UI_PATH_PREFIX="public/pages/system";
 
	public SysCodeGenerator() {
		//
		super(NACOS_GROUP, NACOS_DATA_ID,SERVICE_PROJECT_FOLDER,MICRO_SERVICE_NAME_CONST,DATASOURCE_CONFIG_KEY);
		//设置开发人员
		generator.setAuthor("李方捷");
	}
	
	
	public MduCtx createModuleConfig(DBTable table,int apiSort) {
		
		
		//前缀
		String tablePrefix="sys_";
		
		MduCtx mdu=new MduCtx(this.getConfigs().getSettings(),table,tablePrefix,"com.scientific.tailoring.system");
		mdu.setBaseUriPrefix4Ui("/pages/system");
		
		
		mdu.setDAO(this.getConfigs().getDAO());
		mdu.setDomainProject(this.getConfigs().getDomianProject());
		mdu.setProxyProject(this.getConfigs().getProxyProject());
		mdu.setServiceProject(this.getConfigs().getServiceProject());
		mdu.setDAONameConsts(FoxnicWebConstants.DAO_NAME_CONST);
		mdu.setMicroServiceNameConst(MicroServiceNames.class.getName()+"."+FoxnicWebConstants.DEFAULT_MICRO_SERVICE_NAME_CONST);
		
 
		return mdu;
 
	}
	
	
//	public void generateSysConfig() throws Exception {		
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_CONFIG.$TABLE, 1);
//		//生成代码
//		mducfg.buildAll();
////		generator.build(mducfg);
//	}
	
	
	
 
	
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
//	public void generateSysLang() throws Exception {
//		//创建配置
//		MduCtx mducfg=createModuleConfig(SYS_LANG.$TABLE, 5);
//		//生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	}
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
//		//生成代码
////		generator.build(mducfg);
//		mducfg.buildAll();
//	}
	
	 
	
	 
	
	
	

}
