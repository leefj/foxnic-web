package org.github.foxnic.web.generator.module.storage;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_FILE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class SysFileConfig extends BaseCodeConfig<SYS_FILE> {

	public SysFileConfig() {
		super(PREFIX_STORAGE,SYS_FILE.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(Boolean.class,"exists","是否存在与存储系统","");
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(SYS_FILE.ID).basic().hidden();
		view.field(SYS_FILE.FILE_NAME).search().fuzzySearch();
		view.field(SYS_FILE.LOCATION).search().hidden();
		view.field(SYS_FILE.SIZE).basic().search().hidden();
		view.field(SYS_FILE.MEDIA_TYPE).basic().search().hidden();
		view.field(SYS_FILE.FILE_TYPE).search().hidden();
		view.field(SYS_FILE.DOWNLOAD_URL)
				.basic().label("下载地址")
				.search().hidden();
		view.field(SYS_FILE.DOWNLOADS).search().hidden();
		view.field(SYS_FILE.LATEST_VISIT_TIME)
				.basic().label("最后访问")
				.search().hidden();
	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		form.labelWidth(80);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.disableSpaceColumn().disableBatchDelete().disableSingleDelete().disableModify().disableCreateNew();
	}

	@Override
	public void configOverrides() {

		//文件生成覆盖模式
		context.overrides()
			.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
			.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
			.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
			.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
			.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页

	}

}
