package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.Language;
import org.github.foxnic.web.constants.enums.SystemConfigType;
import org.github.foxnic.web.domain.oauth.meta.ResourzeMeta;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;


public class CodeExampleGenerator extends SystemCodeGenerator {

	public static void main(String[] args) throws Exception {
		CodeExampleGenerator g=new CodeExampleGenerator();
		g.generateExample();
	}


	
 
	public void generateExample() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_CODE_EXAMPLE.$TABLE, 6);

		//设置全局搜索输入框宽度
		cfg.view().search().inputWidth(140);

		//配置在搜索、表单、列表中均隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.ID).basic().hidden();
		//配置在列表中隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.NOTES)
				.list().hidden();

		//日期类型
		cfg.view().field(SYS_CODE_EXAMPLE.BIRTHDAY)
				.form().dateInput();

		//整数类型
		cfg.view().field(SYS_CODE_EXAMPLE.AREA)
			.form().numberInput().integer().step(2.0).range(10.0,20.0).allowNegative(false);

		//小数类型
		cfg.view().field(SYS_CODE_EXAMPLE.WEIGHT)
				.form().numberInput().decimal().step(0.5).range(-1.5,6.6).allowNegative(true).scale(2);

		//单个图片上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.IMAGE_ID)
				.search().hidden()
				.list().hidden()
				.form().upload().acceptSingleImage().displayFileName(false);

		//多文件上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.FILE_IDS)
				.list().hidden()
				.search().hidden();

		//单选框，下拉数据来自枚举
		cfg.view().field(SYS_CODE_EXAMPLE.RADIO_ENUM)
				.form().radioBox().enumType(Language.class);

		//单选框，下拉数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.RADIO_DICT)
				.form().radioBox().dict(DictEnum.SEX);

		//逻辑值
		cfg.view().field(SYS_CODE_EXAMPLE.VALID)
				.form().logicField().on("有效",1).off("无效",0);

		//下拉选择，数据来自枚举
		cfg.view().field(SYS_CODE_EXAMPLE.SELECT_ENUM)
				.form().selectBox().enumType(SystemConfigType.class);

		//下拉选择，数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.SELECT_DICT)
				.form().selectBox().dict(DictEnum.ORDER_STATUS);

		//下拉选择，数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.SELECT_API)
				.search().inputWidth(140)
				.form().selectBox().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST).valueField(ResourzeMeta.ID).textField(ResourzeMeta.URL).toolbar(false).paging(true);


		//多行文本
		cfg.view().field(SYS_CODE_EXAMPLE.NOTES)
				.form().textArea();

		cfg.view().formWindow();

		//此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
		cfg.view().search().inputLayout(
				new Object[]{SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.NOTES,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.BIRTHDAY},
				new Object[]{SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,SYS_CODE_EXAMPLE.VALID},
				new Object[]{SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.SELECT_API}
		);

//		//其实就是排个顺序
//		cfg.view().form().inputColumnLayout(1,
//				SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.NOTES,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.BIRTHDAY,
//				SYS_CODE_EXAMPLE.IMAGE_ID,SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,SYS_CODE_EXAMPLE.VALID,
//				SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.SELECT_API
//		);
//
//
//		cfg.view().form().inputColumnLayout(2,
//				SYS_CODE_EXAMPLE.NAME,		 		SYS_CODE_EXAMPLE.NOTES,
//				SYS_CODE_EXAMPLE.AREA,					SYS_CODE_EXAMPLE.WEIGHT,
//				SYS_CODE_EXAMPLE.BIRTHDAY,			SYS_CODE_EXAMPLE.IMAGE_ID,
//				SYS_CODE_EXAMPLE.RADIO_ENUM,	SYS_CODE_EXAMPLE.RADIO_DICT,
//				SYS_CODE_EXAMPLE.VALID, 				SYS_CODE_EXAMPLE.SELECT_ENUM,
//				SYS_CODE_EXAMPLE.SELECT_DICT,		SYS_CODE_EXAMPLE.SELECT_API
//		);


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
