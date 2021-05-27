package com.tailoring.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_OAUTH_CLIENT;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 

public class OAuthCodeGenerator extends SystemCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		OAuthCodeGenerator g=new OAuthCodeGenerator();
		g.generateSysUser();
		g.generateSysOAuthClient();
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
 
	
	 
	
	 
	
	
	

}
