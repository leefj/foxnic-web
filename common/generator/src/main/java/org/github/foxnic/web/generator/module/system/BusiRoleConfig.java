package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_BUSI_ROLE;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class BusiRoleConfig extends BaseCodeConfig<SYS_BUSI_ROLE> {

	public BusiRoleConfig() {
		super(PREFIX_SYSTEM,SYS_BUSI_ROLE.$TABLE,"sys_", 3);
	}

	@Override
	public void configService(ServiceOptions service) {

	}

	@Override
	public void configController(ControllerOptions controller) {
//		//指定控制器中的保存模式
//		controller.saveMode(SaveMode.NOT_NULL_FIELDS);
//		//指定控制器中的删除模式
//		controller.usePhysicalDelete();
//		//加入批量插入接口
//		controller.batchInsert();
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addListProperty(Employee.class,"employees","关联员工清单","关联员工清单");
	}

	@Override
	public void configFields(ViewOptions view) {

		view.field(SYS_BUSI_ROLE.ID).basic().hidden();
		view.field(SYS_BUSI_ROLE.ORG_ID).basic().hidden();
		view.field(SYS_BUSI_ROLE.VALID).basic().label("状态").search().hidden()
		.form().logicField().on("启用",1).off("停用",0).defaultValue(true)
		.table().alignCenter();

		view.field(SYS_BUSI_ROLE.CODE).basic().label("代码").search().fuzzySearch()
		.form().validate().required();
		view.field(SYS_BUSI_ROLE.NAME).basic().label("名称").search().fuzzySearch()
		.form().validate().required();

//		view.field(BusiRoleMeta.EMP_COUNT).basic().label("成员数").table().alignRight()
//		.form().hidden();

	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
//		list.columnLayout(BPM_ROLE.CODE,BPM_ROLE.NAME,BPM_ROLE.VALID,RoleMeta.EMP_COUNT,BPM_ROLE.CREATE_TIME);
		list.operationColumn().addActionButton("员工","openEmployees");
	}

	@Override
	public void configOverrides() {

		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
			.setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
	}

}
