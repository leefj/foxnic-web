package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_ROLE;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class BPMRoleConfig extends BaseCodeConfig<BPM_ROLE> {

	public BPMRoleConfig() {
		super(PREFIX_BPM,BPM_ROLE.$TABLE,"bpm_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(Integer.class,"empCount","员工数量","员工数量");
		poType.addListProperty(Employee.class,"employees","关联员工清单","关联员工清单");
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(BPM_ROLE.ID).search().hidden();
		view.field(BPM_ROLE.VALID).search().hidden()
		.form().logicField().on("有效",1).off("停用",0);
		view.field(BPM_ROLE.CODE).search().fuzzySearch();
		view.field(BPM_ROLE.NAME).search().fuzzySearch();
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
