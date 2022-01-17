package org.github.foxnic.web.generator.module.job;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB_WORKER;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class SysJobWorkerConfig extends BaseCodeConfig<SYS_JOB_WORKER> {

	public SysJobWorkerConfig() {
		super(PREFIX_JOB,SYS_JOB_WORKER.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(JobExecutor.class,"executor","执行任务的Bean","执行任务的Bean");
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
