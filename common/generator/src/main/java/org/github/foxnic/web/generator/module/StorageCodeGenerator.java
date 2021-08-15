package org.github.foxnic.web.generator.module;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_FILE;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 

public class StorageCodeGenerator extends SystemCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		StorageCodeGenerator g=new StorageCodeGenerator();
		g.generateSysFile();
	}
 
	public StorageCodeGenerator() {
		super("service-storage");
	}
 
	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}
	
 
	public void generateSysFile() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_FILE.$TABLE, 6);

		cfg.getPoClassFile().addSimpleProperty(Boolean.class,"exists","是否存在与存储系统","");

//		cfg.view().field("").search().displayAlone(true);

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
