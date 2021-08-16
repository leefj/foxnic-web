package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import org.github.foxnic.web.constants.enums.SystemConfigType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs.ProjectConfigs;
import org.github.foxnic.web.proxy.MicroServiceNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 为以usr_开头的表生成代码
 */
public class SystemCodeGenerator  {
 
	public static void main(String[] args) throws Exception {

//		GBuilder gb=new GBuilder();

		SystemCodeGenerator g=new SystemCodeGenerator();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				System.out.println("What you name?");
				String str = br.readLine();
				System.out.println("Hello " + str + ".");
				g.generateSysNode();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 
//		g.generateSysConfig();
//		//
		g.generateSysDict();
//		//
//		g.generateSysDictItem();
//		//

//		g.generateSysNode();
 
//		//
//		g.generateSysArea();
//		//
//		g.generateSysLang();


//		g.generateSysDbCache();

//		g.generateSysInvokeLog();

		
	}
	
	private FoxnicWebConfigs configs;
	
 


	private void generateSysNode() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(FoxnicWeb.SYS_NODE.$TABLE, 5);

		cfg.view().field(FoxnicWeb.SYS_NODE.IS_UP).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.HOST_ID).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.ID).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.PORT).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.PROCESS_ID).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.START_TIME).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.HEART_BEAT_TIME).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.HOST_NAME).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.IP).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.WORKER_ID).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.DATACENTER_ID).search().hidden();
		cfg.view().field(FoxnicWeb.SYS_NODE.CREATE_TIME).table().disable();
		cfg.view().field(FoxnicWeb.SYS_NODE.APPLICATION_NAME).search().inputWidth(200).fuzzySearch();
		//
		cfg.view().list().disableSpaceColumn();
		cfg.view().list().disableModify();
		cfg.view().list().disableCreateNew();
		cfg.view().list().disableSingleDelete();
		cfg.view().list().disableBatchDelete();
		//配置表格操作列宽度
		cfg.view().list().operationColumn().width(60);

		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
				.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
				.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
				.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

		//生成代码
		cfg.buildAll();
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
		
//		//配置逻辑型字段
//		cfg.field(SYS_CONFIG.VALID).logicField().off("无效", 0).on("有效", 1);
//		//配置字段为单选框，并指定枚举选项
//		cfg.field(SYS_CONFIG.TYPE).radioField().enumType(SystemConfigType.class);

		//配置逻辑型字段
		cfg.view().field(SYS_CONFIG.VALID)
				.form().logicField().off("无效", 0).on("有效", 1);
		//配置字段为单选框，并指定枚举选项
		cfg.view().field(SYS_CONFIG.TYPE)
				.form().radioBox().enumType(SystemConfigType.class);

		
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


	private void generateSysDict() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(FoxnicWeb.SYS_DICT.$TABLE, 5);

		cfg.getPoClassFile().addSimpleProperty(Menu.class,"moduleInfo","关联模块","");





		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
				.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
				.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
				.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}

	private void generateSysDictItem() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(FoxnicWeb.SYS_DICT_ITEM.$TABLE, 5);

		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
				.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
				.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
				.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
				.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}

	private void generateSysDbCache() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(FoxnicWeb.SYS_DB_CACHE.$TABLE, 5);

		cfg.getVoClassFile().addSimpleProperty(Integer.class,"seconds","过期秒数","");
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

	private void generateSysInvokeLog() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(FoxnicWeb.SYS_INVOKE_LOG.$TABLE, 5);


		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
				.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
				.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
				.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
				.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

		//生成代码
		cfg.buildAll();
	}


	public SystemCodeGenerator() {
		this("service-system");
	}

	public SystemCodeGenerator(String appConfigPrefix) {
		configs=new FoxnicWebConfigs(appConfigPrefix);
	}



}
