package org.github.foxnic.web.generator.module.dataperm;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class DPRuleConfig extends BaseCodeConfig<DP_RULE> {

	public DPRuleConfig() {
		super(PREFIX_DATA_PERM,DP_RULE.$TABLE,"dp_", 3);
	}



	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addListProperty(RuleRange.class,"ranges","约束范围列表","约束范围列表");
	}

	@Override
	public void configService(ServiceOptions service) {

	}

	@Override
	public void configController(ControllerOptions controller) {

	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(DP_RULE.ID).basic().hidden();
		view.field(DP_RULE.VERSION_NO).basic().label("版本").search().hidden();
		view.field(DP_RULE.VALID).basic().label("有效").form().logicField().off("否",0).on("是",1).defaultValue(true);
		view.field(DP_RULE.PO_TYPE).basic().label("PO类型")
		.search().hidden();
	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		form.columnLayout(new Object[] {
				DP_RULE.CODE,DP_RULE.NAME,
				DP_RULE.VERSION_NO,
				DP_RULE.VALID,
				DP_RULE.PO_TYPE,
				DP_RULE.NOTES
		});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.operationColumn().addActionButton("范围","openRanges");
		list.operationColumn().addActionButton("应用","apply");
		list.columnLayout(DP_RULE.CODE,DP_RULE.NAME,DP_RULE.VERSION_NO,DP_RULE.VALID,DP_RULE.PO_TYPE,DP_RULE.NOTES);
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
