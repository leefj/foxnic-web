package org.github.foxnic.web.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_LANG;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.constants.enums.SystemConfigType;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs.ProjectConfigs;
import org.github.foxnic.web.proxy.MicroServiceNames;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 
 

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
		
		//配置逻辑型字段
		cfg.field(SYS_CONFIG.VALID).logicField().off("无效", 0).on("有效", 1);
		//配置字段为单选框，并指定枚举选项
		cfg.field(SYS_CONFIG.TYPE).radioField().enumType(SystemConfigType.class);
		
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
	
	 
	
	
	

}
