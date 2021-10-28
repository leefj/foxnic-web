package org.github.foxnic.web.generator.module.dataperm;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_CONDITION;
import org.github.foxnic.web.constants.enums.dataperm.ConditionNodeType;
import org.github.foxnic.web.constants.enums.dataperm.ExprType;
import org.github.foxnic.web.constants.enums.dataperm.LogicType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.dataperm.RuleServiceProxy;


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
		view.field(DP_RULE_CONDITION.RULE_ID).basic().hidden();
		view.field(DP_RULE_CONDITION.RANGE_ID).basic().hidden();

		view.field(DP_RULE_CONDITION.QUERY_PROPERTY).basic().label("目标属性")
				.form().selectBox().queryApi(RuleServiceProxy.QUERY_FIELD_LIST)
					.toolbar(false)
					.paging(false).muliti(false).valueField("fullProperty").textField("fullProperty");
		view.field(DP_RULE_CONDITION.QUERY_FIELD).basic().hidden();
		view.field(DP_RULE_CONDITION.SORT).basic().hidden();
		view.field(DP_RULE_CONDITION.TYPE).basic().hidden();
		view.field(DP_RULE_CONDITION.PARENT_ID).basic().hidden();
		view.field(DP_RULE_CONDITION.HIERARCHY).basic().hidden();
		view.field(DP_RULE_CONDITION.VALID).basic().label("生效").form().logicField().off("否",0).on("是",1).defaultValue(false);
		view.field(DP_RULE_CONDITION.LOGIC).basic().label("前置逻辑").form().radioBox().enumType(LogicType.class).defaultValue(LogicType.and);
		view.field(DP_RULE_CONDITION.EXPR_TYPE).basic().label("条件类型").form().selectBox().enumType(ExprType.class).defaultValue(ExprType.custom).paging(false).muliti(false);

		view.field(DP_RULE_CONDITION.EXPR).form().textArea().height(100);
		view.field(DP_RULE_CONDITION.VARIABLES).form().textArea().height(100);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		view.search().disable();
		list.disableMargin();
	}

	@Override
	public void configForm(ViewOptions view, FormOptions form) {
		form.labelWidth(80);

		form.columnLayout(new Object[]{
				DP_RULE_CONDITION.RULE_ID,DP_RULE_CONDITION.RANGE_ID,
				//
				DP_RULE_CONDITION.LOGIC,DP_RULE_CONDITION.VALID,
				DP_RULE_CONDITION.QUERY_PROPERTY,DP_RULE_CONDITION.EXPR_TYPE,
				DP_RULE_CONDITION.EXPR,DP_RULE_CONDITION.VARIABLES
		});

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
