package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.Language;
import org.github.foxnic.web.constants.enums.MenuType;
import org.github.foxnic.web.constants.enums.SystemConfigType;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.meta.ResourzeMeta;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleVOMeta;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;


public class CodeExampleGenerator extends SystemCodeGenerator {

	public static void main(String[] args) throws Exception {
		CodeExampleGenerator g=new CodeExampleGenerator();
		g.generateExample();
		g.generateExampleRole();
	}


 
	public void generateExample() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(SYS_CODE_EXAMPLE.$TABLE, 6);

		//配置两个扩展属性
		cfg.getPoClassFile().addSimpleProperty(Resourze.class,"resourze","关联一个资源","一对一关系属性拓展");
		cfg.getPoClassFile().addListProperty(Role.class,"roles","关联多个角色","一对多关系属性拓展");
		cfg.getPoClassFile().addSimpleProperty(Integer.class,"roleCountByAfter","角色的数量(Java)","关联角色数量JAva统计");
		cfg.getPoClassFile().addSimpleProperty(Integer.class,"roleCountByJoin","角色的数量(Join)","关联角色数量Join统计");
		//
		cfg.getPoClassFile().addListProperty(String.class,"roleIds","角色ID列表","用于表单角色ID提交到后端");

		//设置全局搜索输入框宽度
		cfg.view().search().inputWidth(140);

		//配置在搜索、表单、列表中均隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.ID).basic().hidden();

		//增加必填的校验
		cfg.view().field(SYS_CODE_EXAMPLE.NAME)
				.list().fix(true)
				.form().validate().required()
				.search().fuzzySearch();

		//配置在列表中隐藏
		cfg.view().field(SYS_CODE_EXAMPLE.NOTES)
				//多行文本
				.form().textArea().height(120)
				.search().fuzzySearch()
		;

		//整数类型
		cfg.view().field(SYS_CODE_EXAMPLE.AREA)
			.form().numberInput().integer().step(2.0).range(0.0,20.0).allowNegative(false)
			.form().validate().required()
			.search().range().inputWidth(64)
		;

		//小数类型
		cfg.view().field(SYS_CODE_EXAMPLE.WEIGHT)
				.form().numberInput().decimal().step(0.5).range(-10.5,16.6).allowNegative(true).scale(2);

		//日期类型
		cfg.view().field(SYS_CODE_EXAMPLE.BIRTHDAY)
				.form().dateInput()
				.search().range();

		//单个图片上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.IMAGE_ID)
				.search().hidden()
				.form().upload().acceptSingleImage().displayFileName(false);

		//多文件上传类型
		cfg.view().field(SYS_CODE_EXAMPLE.FILE_IDS)
				.list().hidden()
				.form().upload().acceptExts("doc","zip","xlsx","rar","docx","txt","svg").maxFileCount(4)
				.form().validate().required()
				.search().hidden();

		//单选框，下拉数据来自枚举
		cfg.view().field(SYS_CODE_EXAMPLE.RADIO_ENUM)
				.form().radioBox().enumType(Language.class);

		//单选框，下拉数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.RADIO_DICT)
				.form().validate().required()
				.form().radioBox().dict(DictEnum.SEX);

		//复选框，下拉数据来自枚举
		cfg.view().field(SYS_CODE_EXAMPLE.CHECK_ENUM)
				.form().checkBox().enumType(MenuType.class)
		.search().fuzzySearchWithDoubleQM();

		//复选框，下拉数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.CHECK_DICT)
				.form().checkBox().dict(DictEnum.MEASURE_METHOD)
				.form().validate().required()
				.search().fuzzySearchWithDoubleQM();

		//逻辑值
		cfg.view().field(SYS_CODE_EXAMPLE.VALID)
				.form().logicField().on("有效",1).off("无效",0);

		//下拉选择，数据来自枚举
		cfg.view().field(SYS_CODE_EXAMPLE.SELECT_ENUM)
				.form().validate().required()
				.form().selectBox().enumType(SystemConfigType.class);

		//下拉选择，数据来自字典
		cfg.view().field(SYS_CODE_EXAMPLE.SELECT_DICT)
				.form().validate().required()
				.form().selectBox().dict(DictEnum.ORDER_STATUS).muliti(true)
				.search().fuzzySearchWithDoubleQM();

		//下拉选择，数据来自外部表
		cfg.view().field(SYS_CODE_EXAMPLE.RESOURCE_ID)
				.search().inputWidth(140).fuzzySearch()
				.form().selectBox().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST)
				.valueField(ResourzeMeta.ID).textField(ResourzeMeta.URL)
				.toolbar(false).paging(true)
				.fillBy(CodeExampleMeta.RESOURZE)
		;

		//下拉选择，数据来自外部表
		cfg.view().field(CodeExampleVOMeta.ROLE_IDS)
				.basic().label("角色")
				.search().inputWidth(140)
				.list().sort(false)
				.form().selectBox().queryApi(RoleServiceProxy.QUERY_PAGED_LIST)
					.valueField(RoleMeta.ID).textField(RoleMeta.NAME)
					.toolbar(false).paging(true)
					.fillBy(CodeExampleMeta.ROLES).muliti(true);
		;

		cfg.view().field(CodeExampleVOMeta.ROLE_COUNT_BY_AFTER)
				.basic().label("角色数(Java)")
				.list().sort(false).alignRight();

		cfg.view().field(CodeExampleVOMeta.ROLE_COUNT_BY_JOIN)
				.basic().label("角色数(SQL)")
				.list().sort(true).alignRight();


		//设置表格的列
		cfg.view().list().columnLayout(
				//常规列
				SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.NOTES,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.BIRTHDAY,SYS_CODE_EXAMPLE.VALID,
				//单选
				SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,
				//复选
				SYS_CODE_EXAMPLE.CHECK_ENUM,SYS_CODE_EXAMPLE.CHECK_DICT,
				//下拉选择
				SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.SELECT_ENUM,
				//外部关联
				CodeExampleMeta.ROLE_IDS,SYS_CODE_EXAMPLE.RESOURCE_ID,
				//统计值
				CodeExampleVOMeta.ROLE_COUNT_BY_AFTER,CodeExampleVOMeta.ROLE_COUNT_BY_JOIN,
				//附件
				CodeExampleMeta.IMAGE_ID,CodeExampleMeta.FILE_IDS
		);

		//此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
		cfg.view().search().inputLayout(
				new Object[]{SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.NOTES,SYS_CODE_EXAMPLE.AREA},
				new Object[]{SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.BIRTHDAY,SYS_CODE_EXAMPLE.VALID},
				new Object[]{SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,SYS_CODE_EXAMPLE.CHECK_ENUM,SYS_CODE_EXAMPLE.CHECK_DICT},
				new Object[]{SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT},
				new Object[]{CodeExampleMeta.ROLE_IDS,SYS_CODE_EXAMPLE.RESOURCE_ID}
		);



//		//单列布局方式：其实就是排个顺序,并把不在清单中的字段设置成隐藏
//		cfg.view().formWindow().width(600);
//		cfg.view().form().inputColumnLayout(1,
//				SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.BIRTHDAY,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.WEIGHT,
//				SYS_CODE_EXAMPLE.IMAGE_ID,SYS_CODE_EXAMPLE.FILE_IDS,
//				SYS_CODE_EXAMPLE.RADIO_ENUM,SYS_CODE_EXAMPLE.RADIO_DICT,SYS_CODE_EXAMPLE.VALID,
//				SYS_CODE_EXAMPLE.CHECK_ENUM,SYS_CODE_EXAMPLE.CHECK_DICT,
//				SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.SELECT_API,SYS_CODE_EXAMPLE.NOTES
//		);


		//分成两栏的布局
//		cfg.view().formWindow().width(1000);
//		cfg.view().form().columnLayout(
//			new Object[] {
//				SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.BIRTHDAY,SYS_CODE_EXAMPLE.RADIO_ENUM,
//				SYS_CODE_EXAMPLE.VALID,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.CHECK_ENUM,SYS_CODE_EXAMPLE.NOTES
//			}, new Object[] {
//				SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.CHECK_DICT,SYS_CODE_EXAMPLE.IMAGE_ID,SYS_CODE_EXAMPLE.RADIO_DICT,
//				SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_API,SYS_CODE_EXAMPLE.FILE_IDS
//			}
//		);


//		//分成两栏的混合布局
//		cfg.view().formWindow().width(1000);
//		cfg.view().form().addGroup(null,
//				new Object[] {
//						SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.BIRTHDAY,
//						SYS_CODE_EXAMPLE.VALID,SYS_CODE_EXAMPLE.SELECT_DICT,SYS_CODE_EXAMPLE.CHECK_ENUM
//				}, new Object[] {
//						SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.CHECK_DICT,SYS_CODE_EXAMPLE.IMAGE_ID,
//						SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.SELECT_API
//				}
//		);
//		cfg.view().form().addGroup(null,
//				new Object[] {SYS_CODE_EXAMPLE.FILE_IDS}
//		);
//		cfg.view().form().addGroup(null,
//				new Object[] {
//						SYS_CODE_EXAMPLE.RADIO_ENUM,
//				}, new Object[] {
//						SYS_CODE_EXAMPLE.RADIO_DICT,
//				}
//		);
//		cfg.view().form().addGroup(null,
//				new Object[] {SYS_CODE_EXAMPLE.NOTES}
//		);


		//分成分组布局
		cfg.view().formWindow().width(1000);
		cfg.view().form().addGroup("基本信息",
				new Object[] {
						SYS_CODE_EXAMPLE.NAME,SYS_CODE_EXAMPLE.AREA,SYS_CODE_EXAMPLE.BIRTHDAY,
						SYS_CODE_EXAMPLE.VALID,SYS_CODE_EXAMPLE.SELECT_DICT,
				}, new Object[] {
						SYS_CODE_EXAMPLE.WEIGHT,SYS_CODE_EXAMPLE.CHECK_DICT,
						SYS_CODE_EXAMPLE.SELECT_ENUM,SYS_CODE_EXAMPLE.RESOURCE_ID,CodeExampleVOMeta.ROLE_IDS
				}
		);
		cfg.view().form().addGroup("附件信息",
				new Object[] {SYS_CODE_EXAMPLE.IMAGE_ID,SYS_CODE_EXAMPLE.FILE_IDS,}
		);
		cfg.view().form().addGroup("类型信息",
				new Object[] {
						SYS_CODE_EXAMPLE.RADIO_ENUM,
				}, new Object[] {
						SYS_CODE_EXAMPLE.RADIO_DICT,
				}
		);
		cfg.view().form().addGroup("扩展信息",
				new Object[] {SYS_CODE_EXAMPLE.CHECK_ENUM,SYS_CODE_EXAMPLE.NOTES}
		);





		//文件生成覆盖模式
		cfg.overrides()
		//请勿覆盖，已有代码加入！！！！！
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
		.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
 
		//生成代码
		cfg.buildAll();
	}


	public void generateExampleRole() throws Exception {
		//创建配置
		ModuleContext cfg = createModuleConfig(FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.$TABLE, 6);

		//指定该表为关系表
		cfg.setRelationField(FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID, FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.ROLE_ID,true);

		//文件生成覆盖模式
		cfg.overrides()
				.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
				.setControllerAndAgent(WriteMode.IGNORE) //Rest
				.setPageController(WriteMode.IGNORE) //页面控制器
				.setFormPage(WriteMode.IGNORE) //表单HTML页
				.setListPage(WriteMode.IGNORE); //列表HTML页

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
