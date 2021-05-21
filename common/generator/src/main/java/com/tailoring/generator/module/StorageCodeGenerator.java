package com.tailoring.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_FILE;

import com.github.foxnic.generatorV2.config.MduCtx;
import com.github.foxnic.generatorV2.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 
 

/**
 * 为以usr_开头的表生成代码
 */
public class StorageCodeGenerator extends SystemCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		StorageCodeGenerator g=new StorageCodeGenerator();
		g.generateSysFile();
 

		
	}
 
	public StorageCodeGenerator() {
		super("service-storage");
	}
 
	public MduCtx createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}
	
 
	public void generateSysFile() throws Exception {
		//创建配置
		MduCtx cfg=createModuleConfig(SYS_FILE.$TABLE, 6);
		
		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.DO_NOTHING) //服务与接口
		.setControllerAndAgent(WriteMode.DO_NOTHING) //Rest
		.setPageController(WriteMode.DO_NOTHING) //页面控制器
		.setFormPage(WriteMode.IGNORE) //表单HTML页
		.setListPage(WriteMode.IGNORE); //列表HTML页
		
		//生成代码
		cfg.buildAll();
	}
 
	
	 
	
	 
	
	
	

}