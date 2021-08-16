package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
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
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;
import org.github.foxnic.web.system.service.ICodeExampleRoleService;


public class CodeExampleConfig extends BaseCodeConfig<SYS_CODE_EXAMPLE> {

	/**
	 * 指定关联对象的属性填充单元格，为了避免名称重复，加一个前缀
	 */
	private String resourceNameField="res_"+ResourzeMeta.NAME;

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

		//配置两个扩展属性
		poType.addSimpleProperty(Resourze.class,"resourze","关联一个资源","一对一关系属性拓展");
		poType.addListProperty(Role.class,"roles","关联多个角色","一对多关系属性拓展");
		poType.addSimpleProperty(Integer.class,"roleCountByAfter","角色的数量(Java)","关联角色数量JAva统计");
		poType.addSimpleProperty(Integer.class,"roleCountByJoin","角色的数量(Join)","关联角色数量Join统计");
		//
		poType.addListProperty(String.class,"roleIds","角色ID列表","用于表单角色ID提交到后端");

	}

	@Override
	public void configFields(ViewOptions view) {

		//设置全局搜索输入框宽度
		view.search().inputWidth(140);

		//配置在搜索、表单、列表中均隐藏
		view.field(TABLE.ID).basic().hidden();

		//增加必填的校验
		view.field(TABLE.NAME)
				.table().fix(true)
				.form().validate().required()
				.search().fuzzySearch();

		//配置在列表中隐藏
		view.field(TABLE.NOTES)
				//多行文本
				.form().textArea().height(120)
				.search().fuzzySearch()
		;

		//整数类型
		view.field(TABLE.AREA)
				.form().numberInput().integer().step(2.0)
				//.range(0.0,20.0)
				.allowNegative(false)
				.form().validate().required()
				.search().range().inputWidth(64)
		;

		//小数类型
		view.field(TABLE.WEIGHT)
				.form().numberInput().decimal().step(0.5).range(-10.5,16.6).allowNegative(true).scale(2);

		//日期类型
		view.field(TABLE.BIRTHDAY)
				.form().dateInput()
				.search().range();

		//单个图片上传类型
		view.field(TABLE.IMAGE_ID)
				.search().hidden()
				.form().upload().acceptSingleImage().displayFileName(false);

		//多文件上传类型
		view.field(TABLE.FILE_IDS)
				.table().hidden()
				.form().upload().acceptExts("doc","zip","xlsx","rar","docx","txt","svg").maxFileCount(4)
				.form().validate().required()
				.search().hidden();

		//单选框，下拉数据来自枚举
		view.field(TABLE.RADIO_ENUM)
				.form().radioBox().enumType(Language.class);

		//单选框，下拉数据来自字典
		view.field(TABLE.RADIO_DICT)
				.form().validate().required()
				.form().radioBox().dict(DictEnum.SEX);

		//复选框，下拉数据来自枚举
		view.field(TABLE.CHECK_ENUM)
				.form().checkBox().enumType(MenuType.class)
				.search().fuzzySearchWithDoubleQM();

		//复选框，下拉数据来自字典
		view.field(TABLE.CHECK_DICT)
				.form().checkBox().dict(DictEnum.MEASURE_METHOD)
				.form().validate().required()
				.search().fuzzySearchWithDoubleQM();

		//逻辑值
		view.field(TABLE.VALID)
				.form().logicField().on("有效",1).off("无效",0);

		//下拉选择，数据来自枚举
		view.field(TABLE.SELECT_ENUM)
				.form().validate().required()
				.form().selectBox().enumType(SystemConfigType.class);

		//下拉选择，数据来自字典
		view.field(TABLE.SELECT_DICT)
				.form().validate().required()
				.form().selectBox().dict(DictEnum.ORDER_STATUS).muliti(true)
				.search().fuzzySearchWithDoubleQM();

		//下拉选择，数据来自外部表
		view.field(TABLE.RESOURCE_ID)
				.search().inputWidth(140).fuzzySearch()
				.form().selectBox().queryApi(ResourzeServiceProxy.QUERY_PAGED_LIST)
				.valueField(ResourzeMeta.ID).textField(ResourzeMeta.URL)
				.toolbar(false).paging(true)
				.fillBy(CodeExampleMeta.RESOURZE)
		;


		view.field(resourceNameField)
				.basic().label("资源名称")
				.table().fillBy(CodeExampleMeta.RESOURZE,ResourzeMeta.NAME);

		//下拉选择，数据来自外部表
		view.field(CodeExampleVOMeta.ROLE_IDS)
				.basic().label("角色")
				.search().inputWidth(140)
				.table().sort(false)
				.form().selectBox().queryApi(RoleServiceProxy.QUERY_PAGED_LIST)
				.valueField(RoleMeta.ID).textField(RoleMeta.NAME)
				.toolbar(false).paging(true)
				.fillBy(CodeExampleMeta.ROLES).muliti(true);
		;

		view.field(CodeExampleVOMeta.ROLE_COUNT_BY_AFTER)
				.basic().label("角色数(Java)")
				.table().sort(false).alignRight();

		view.field(CodeExampleVOMeta.ROLE_COUNT_BY_JOIN)
				.basic().label("角色数(SQL)")
				.table().sort(true).alignRight();

		//禁用列
		view.field(CodeExampleMeta.CREATE_TIME).table().disable(true);

	}

	@Override
	public void configOverrides() {
		//文件生成覆盖模式
		context.overrides()
			//请勿覆盖，已有代码加入！！！！！
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
	}

	@Override
	public void configService(ServiceOptions service) {
		//在Service实现中增加一个保存关系的操作
		service.addRelationSaveAction(ICodeExampleRoleService.class,CodeExampleVOMeta.ROLE_IDS);
	}


	@Override
	public void configList(ViewOptions view,ListOptions list) {

		//禁止新建
//		cfg.view().list().disableCreateNew();
		//禁止修改
//		cfg.view().list().disableModify();
		//禁止单行删除
//		cfg.view().list().disableSingleDelete();
		//禁止批量删除
//		cfg.view().list().disableBatchDelete();
		//禁止查看表单，同时也禁用编辑
//		cfg.view().list().disableFormView();
		//禁用空白列
//		cfg.view().list().disableSpaceColumn();

		//设置表格的列
		list.columnLayout(
			//常规列
			TABLE.NAME,TABLE.NOTES,TABLE.AREA,TABLE.WEIGHT,TABLE.BIRTHDAY,TABLE.WORK_TIME,TABLE.VALID,
			//单选
			TABLE.RADIO_ENUM,TABLE.RADIO_DICT,
			//复选
			TABLE.CHECK_ENUM,TABLE.CHECK_DICT,
			//下拉选择
			TABLE.SELECT_ENUM,TABLE.SELECT_DICT,TABLE.SELECT_ENUM,
			//外部关联
			CodeExampleMeta.ROLE_IDS,TABLE.RESOURCE_ID,resourceNameField,
			//统计值
			CodeExampleVOMeta.ROLE_COUNT_BY_AFTER,CodeExampleVOMeta.ROLE_COUNT_BY_JOIN,
			//附件
			CodeExampleMeta.IMAGE_ID,CodeExampleMeta.FILE_IDS
		);

	}

	@Override
	public void configForm(ViewOptions view,FormOptions form) {


//		configFormLayoutA(view,form);

//		configFormLayoutB(view,form);

//		configFormLayoutC(view,form);


		configFormLayoutD(view,form);
	}

	private void configFormLayoutA(ViewOptions view, FormOptions form) {
		//		//单列布局方式：其实就是排个顺序,并把不在清单中的字段设置成隐藏
//		cfg.view().formWindow().width(600);
//		cfg.view().form().inputColumnLayout(1,
//				TABLE.NAME,TABLE.BIRTHDAY,TABLE.AREA,TABLE.WEIGHT,
//				TABLE.IMAGE_ID,TABLE.FILE_IDS,
//				TABLE.RADIO_ENUM,TABLE.RADIO_DICT,TABLE.VALID,
//				TABLE.CHECK_ENUM,TABLE.CHECK_DICT,
//				TABLE.SELECT_ENUM,TABLE.SELECT_DICT,TABLE.SELECT_API,TABLE.NOTES
//		);
	}

	/**
	 * 分成两栏的布局
	 * */
	private void configFormLayoutB(ViewOptions view, FormOptions form) {
		view.formWindow().width(1000);
		form.columnLayout(
			new Object[] {
				TABLE.NAME,TABLE.AREA,TABLE.BIRTHDAY,TABLE.RADIO_ENUM,
				TABLE.VALID,TABLE.SELECT_DICT,TABLE.CHECK_ENUM,TABLE.NOTES
			}, new Object[] {
				TABLE.WEIGHT,TABLE.CHECK_DICT,TABLE.IMAGE_ID,TABLE.RADIO_DICT,
				TABLE.SELECT_ENUM,TABLE.FILE_IDS
				//TABLE.SELECT_API
			}
		);
	}

	/**
	 * 分成两栏的混合布局
	 * */
	private void configFormLayoutC(ViewOptions view, FormOptions form) {

		view.formWindow().width(1000);
		form.addGroup(null,
				new Object[] {
						TABLE.NAME,TABLE.AREA,TABLE.BIRTHDAY,
						TABLE.VALID,TABLE.SELECT_DICT,TABLE.CHECK_ENUM
				}, new Object[] {
						TABLE.WEIGHT,TABLE.CHECK_DICT,TABLE.IMAGE_ID,
						TABLE.SELECT_ENUM
						//,TABLE.SELECT_API
				}
		);
		form.addGroup(null,
				new Object[] {TABLE.FILE_IDS}
		);
		form.addGroup(null,
				new Object[] {
						TABLE.RADIO_ENUM,
				}, new Object[] {
						TABLE.RADIO_DICT,
				}
		);
		form.addGroup(null,
				new Object[] {TABLE.NOTES}
		);
	}

	/**
	 * 分组、分栏混合布局
	 * */
	private void configFormLayoutD(ViewOptions view,FormOptions form) {

		//分成分组布局
		view.formWindow().width(1000);
		form.addGroup("基本信息",
				new Object[] {
						TABLE.NAME,TABLE.AREA,TABLE.BIRTHDAY,
						TABLE.VALID,TABLE.SELECT_DICT,
				}, new Object[] {
						TABLE.WEIGHT,TABLE.CHECK_DICT,
						TABLE.SELECT_ENUM,TABLE.RESOURCE_ID,CodeExampleVOMeta.ROLE_IDS
				}
		);
		form.addGroup("附件信息",
				new Object[] {TABLE.IMAGE_ID,TABLE.FILE_IDS,}
		);
		form.addGroup("类型信息",
				new Object[] {
						TABLE.RADIO_ENUM,
				}, new Object[] {
						TABLE.RADIO_DICT,
						TABLE.WORK_TIME
				}
		);
		form.addGroup("扩展信息",
				new Object[] {TABLE.CHECK_ENUM,TABLE.NOTES}
		);

	}

	@Override
	public void configSearch(ViewOptions view,SearchAreaOptions search) {
		//此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
		search.inputLayout(
				new Object[]{TABLE.NAME,TABLE.NOTES,TABLE.AREA},
				new Object[]{TABLE.WEIGHT,TABLE.BIRTHDAY,TABLE.VALID},
				new Object[]{TABLE.RADIO_ENUM,TABLE.RADIO_DICT,TABLE.CHECK_ENUM,TABLE.CHECK_DICT},
				new Object[]{TABLE.SELECT_ENUM,TABLE.SELECT_DICT},
				new Object[]{CodeExampleMeta.ROLE_IDS,TABLE.RESOURCE_ID}
		);
	}


	public CodeExampleConfig() {
		super("service-system",SYS_CODE_EXAMPLE.$TABLE,"sys_", 3);
	}


	

}
