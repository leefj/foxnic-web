package org.github.foxnic.web.generator.module.dataperm;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_CONDITION;
import org.github.foxnic.web.constants.enums.dataperm.ConditionNodeType;
import org.github.foxnic.web.constants.enums.dataperm.LogicType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class DPRuleConditionConfig extends BaseCodeConfig<DP_RULE_CONDITION> {

	public DPRuleConditionConfig() {
		super(PREFIX_DATA_PERM,DP_RULE_CONDITION.$TABLE,"dp_", 3);
	}



	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

		poType.shadow(DP_RULE_CONDITION.TYPE, ConditionNodeType.class);
		poType.shadow(DP_RULE_CONDITION.LOGIC, LogicType.class);

	}

	@Override
	public void configService(ServiceOptions service) {

	}

	@Override
	public void configController(ControllerOptions controller) {

	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(DP_RULE_CONDITION.ID).basic().hidden();
		view.field(DP_RULE_CONDITION.RANGE_ID).basic().hidden();
		view.field(DP_RULE_CONDITION.VALID).basic().label("生效").form().logicField().off("否",0).on("是",1).defaultValue(false);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		view.search().disable();
		list.disableMargin();
	}

	@Override
	public void configOverrides() {

		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
			.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.CREATE_IF_NOT_EXISTS) //列表HTML页
			.setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
	}

}
