package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_DEFINITION;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ChsChangeDefinitionConfig extends BaseCodeConfig<CHS_CHANGE_DEFINITION> {

	public ChsChangeDefinitionConfig() {
		super(PREFIX_CHANGES,CHS_CHANGE_DEFINITION.$TABLE,"chs_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.shadow(CHS_CHANGE_DEFINITION.MODE,ApprovalMode.class);
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(CHS_CHANGE_DEFINITION.ID).basic().hidden();
		view.field(CHS_CHANGE_DEFINITION.VALID).form().logicField().on("有效",1).off("无效",0).defaultValue(true)
		.search().hidden();



		view.field(CHS_CHANGE_DEFINITION.CODE)
				.form().validate().required()
		;

		view.field(CHS_CHANGE_DEFINITION.NAME)
				.form().validate().required()
		;

		view.field(CHS_CHANGE_DEFINITION.MODE)
			.form().radioBox().enumType(ApprovalMode.class).defaultValue(ApprovalMode.simple)
			.form().validate().required()
		;

		view.field(CHS_CHANGE_DEFINITION.SIMPLE_APPROVERS)
			.basic().label("审批人")
			.table().hidden()
			.search().hidden()
			.form().button().chooseEmployee(false)
			.form().validate().required()
		;

//		view.field(CHS_CHANGE_DEFINITION.SIMPLE_APPROVAL_LOGIC)
//			.table().hidden()
//			.search().hidden()
//			.form().validate().required()
//			.form().radioBox().enumType(ApprovalLogic.class).defaultValue(ApprovalLogic.any)
//		;

	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		form.labelWidth(100);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

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
