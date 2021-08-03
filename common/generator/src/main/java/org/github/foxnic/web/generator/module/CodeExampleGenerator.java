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
		cfg.view().field(SYS_CODE_EXAMPLE.NOTES)
				//单独设置输入框在搜索工具栏的位置
				.search().location(1,3)
				.list().hidden();
		cfg.view().field(SYS_CODE_EXAMPLE.BIRTHDAY)
				//单独设置输入框在搜索工具栏的位置
				.search().location(1,1);

		cfg.view().field(SYS_CODE_EXAMPLE.AREA)
			.form().validate().required().integer();

		cfg.view().field(SYS_CODE_EXAMPLE.WEIGHT)
				.form().validate().required().decimal();

		//配置为上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.IMAGE_ID)
				.search().hidden()
				.list().hidden()
				.form().upload().acceptSingleImage().displayFileName(false);

		cfg.view().field(SYS_CODE_EXAMPLE.FILE_IDS)
				.list().hidden()
				.search().hidden();

		cfg.view().formWindow();

		//此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
		cfg.view().search().inputLayout(
				new Object[]{SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.NOTES,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.BIRTHDAY},
				new Object[]{SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,SYS_CODE_EXAMPLE.VALID},
				new Object[]{SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.SELECT_API}
		);

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
