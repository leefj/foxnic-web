package org.github.foxnic.web.generator.module.job;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB_LOG;
import org.github.foxnic.web.constants.enums.job.LogType;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class SysJobLogConfig extends BaseCodeConfig<SYS_JOB_LOG> {

	public SysJobLogConfig() {
		super(PREFIX_JOB,SYS_JOB_LOG.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.shadow(SYS_JOB_LOG.TYPE, LogType.class);
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(SYS_JOB_LOG.JOB_NAME).search().fuzzySearch();
		view.field(SYS_JOB_LOG.TYPE)
				.search().triggerOnSelect(true).form().radioBox().enumType(LogType.class);

		view.field(SYS_JOB_LOG.SUCCESS).basic().label("是否成功").table().alignCenter();

		view.field(SYS_JOB_LOG.BEGIN_TIME).basic().label("开始时间");
		view.field(SYS_JOB_LOG.END_TIME).basic().label("结束时间");

		view.field(SYS_JOB_LOG.COST).basic().label("耗时(毫秒)");

		view.field(SYS_JOB_LOG.CLASS_NAME).basic().label("执行类");
		view.field(SYS_JOB_LOG.CRON_EXPR).basic().label("CRON表达式");
		view.field(SYS_JOB_LOG.PARAMETER).basic().label("参数");

		view.field(SYS_JOB_LOG.IS_MISSFIRE).basic().label("是否补执");
		view.field(SYS_JOB_LOG.CONCURRENT).basic().label("允许并发");
		view.field(SYS_JOB_LOG.MISFIRE_POLICY).basic().label("执行策略").form().selectBox().enumType(MisfirePolicy.class);

		view.field(SYS_JOB_LOG.IS_MANUAL).basic().label("手动").table().alignCenter();//.form().radioBox().enumType(YesNo.class);
		view.field(SYS_JOB_LOG.EXCEPTION).form().textArea();
		view.field(SYS_JOB_LOG.LOG_TEXT).basic().hidden();


	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.inputLayout(new Object[]{
				SYS_JOB_LOG.JOB_NAME,SYS_JOB_LOG.TYPE
		});
	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		view.formWindow().width("700px");
		form.labelWidth(100);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.disableModify().disableSingleDelete().disableCreateNew().disableBatchDelete();
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
