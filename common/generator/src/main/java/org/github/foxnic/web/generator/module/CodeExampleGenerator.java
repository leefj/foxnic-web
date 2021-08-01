package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;


public class CodeExampleGenerator extends SystemCodeGenerator {

	public static void main(String[] args) throws Exception {
		CodeExampleGenerator g=new CodeExampleGenerator();
		g.generateExample();
	}


	
 
	public void generateExample() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_CODE_EXAMPLE.$TABLE, 6);

		//配置在搜索、表单、列表中均隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.ID).basic().hidden();
		//配置在列表中隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.NOTES).list().hidden();
		//配置为上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.IMAGE_ID)
				.form().upload().acceptSingleImage().displayFileName(false);


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






	public CodeExampleGenerator() {
		super("service-system");
	}

	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "sys_", apiSort);
	}
	

}
