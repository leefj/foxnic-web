package org.github.foxnic.web.generator.module.job;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import org.github.foxnic.web.constants.enums.job.Status;
import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.meta.JobMeta;
import org.github.foxnic.web.domain.job.meta.JobWorkerMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.job.JobWorkerServiceProxy;


public class SysJobConfig extends BaseCodeConfig<SYS_JOB> {

	public SysJobConfig() {
		super(PREFIX_JOB,SYS_JOB.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(JobWorker.class,"worker","任务的执行类","任务的执行类");
		poType.shadow(SYS_JOB.STATUS, Status.class);
		poType.shadow(SYS_JOB.MISFIRE_POLICY, MisfirePolicy.class);
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(SYS_JOB.NAME).basic().label("任务名")
				.search().fuzzySearch();

		view.field(SYS_JOB.GROUP_TAG).basic().hidden().table().disable();

		view.field(SYS_JOB.WORKER_ID).basic().label("执行器")
		.form().selectBox().queryApi(JobWorkerServiceProxy.QUERY_PAGED_LIST).paging(true).muliti(false,false)
		.valueField(JobWorkerMeta.ID).textField(JobWorkerMeta.CLASS_NAME)
		.table().fillBy(JobMeta.WORKER,JobWorkerMeta.CLASS_NAME)
		;

		view.field(SYS_JOB.CRON_EXPR).basic().label("cron");

		view.field(SYS_JOB.ERRORS).basic().label("失败次数");

		view.field(SYS_JOB.CONCURRENT).basic().label("并发")
				.form().logicField().on("是",1).off("否",0);



	}

	@Override
	public void configForm(ViewOptions view, FormOptions form) {
		view.formWindow().width("700px");
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.inputLayout(new Object[] {SYS_JOB.NAME});
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
