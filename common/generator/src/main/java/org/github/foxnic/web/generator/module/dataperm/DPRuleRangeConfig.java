package org.github.foxnic.web.generator.module.dataperm;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_RULE_RANGE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class DPRuleRangeConfig extends BaseCodeConfig<DP_RULE_RANGE> {

	public DPRuleRangeConfig() {
		super(PREFIX_DATA_PERM,DP_RULE_RANGE.$TABLE,"dp_", 3);
	}



	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
//		poType.addSimpleProperty(Integer.class,"empCount","员工数量","员工数量");
//		poType.addListProperty(Employee.class,"employees","关联员工清单","关联员工清单");
	}

	@Override
	public void configService(ServiceOptions service) {
	}

	@Override
	public void configController(ControllerOptions controller) {
	}

	@Override
	public void configFields(ViewOptions view) {

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
