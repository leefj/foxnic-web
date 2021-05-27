package com.tailoring.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_OAUTH_CLIENT;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;

import com.alibaba.nacos.api.cmdb.pojo.Entity;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 

public class OAuthCodeGenerator extends SystemCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		OAuthCodeGenerator g=new OAuthCodeGenerator();
		g.generateSysUser();
		g.generateSysOAuthClient();
		g.generateSysSessionOnline();
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
		
		
		PojoClassFile pojo=cfg.createPojo("LoginIdentityVO");
		pojo.setSuperType(null);
		pojo.setDoc("用于App登录接口");
		pojo.addSimpleProperty(String.class,"identity","帐号或手机号","");
		pojo.addSimpleProperty(String.class,"passwd","密码","");
		pojo.addSimpleProperty(String.class,"randomId","随机ID","客户端产生的唯一ID，用于标识一次认证");
		pojo.addSimpleProperty(String.class,"vcode","校验码","用户输入的校验码");
 
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
		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
 
		//生成代码
		cfg.buildAll();
	}
 
	
	 
	
	 
	
	
	

}
