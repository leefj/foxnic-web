package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_EXAMPLE_ORDER;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ChsExampleOrderConfig extends BaseCodeConfig<CHS_EXAMPLE_ORDER> {

	public ChsExampleOrderConfig() {
		super(PREFIX_CHANGES,CHS_EXAMPLE_ORDER.$TABLE,"chs_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.shadow(CHS_EXAMPLE_ORDER.CHS_STATUS, ChangeStatus.class);
		poType.shadow(CHS_EXAMPLE_ORDER.CHS_TYPE, ChangeType.class);
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(CHS_EXAMPLE_ORDER.ID).basic().hidden();
		view.field(CHS_EXAMPLE_ORDER.ORDER_TIME).search().hidden();
		view.field(CHS_EXAMPLE_ORDER.TITLE).search().fuzzySearch();
		view.field(CHS_EXAMPLE_ORDER.CODE).search().fuzzySearch();

		view.field(CHS_EXAMPLE_ORDER.ORDER_TIME).form().dateInput().format("yyyy-MM-dd");

		view.field(CHS_EXAMPLE_ORDER.CHS_STATUS).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.SOURCE_ID).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.CHS_TYPE).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.CHS_VERSION).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.AMOUNT).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.SOURCE_ID).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.PROC_ID).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.PROC_NODE_SUMMARY).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.PROC_SUMMARY).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.BUYER_ID).basic().label("买家").form().button().chooseEmployee(true);
		view.field(CHS_EXAMPLE_ORDER.CHS_ID).form().hidden();

	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.inputLayout(new Object[]{CHS_EXAMPLE_ORDER.TITLE,CHS_EXAMPLE_ORDER.CODE});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.addToolButton("创建变更","startChange","");
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
