package org.github.foxnic.web.generator.module.job;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_JOB;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import org.github.foxnic.web.constants.enums.job.Status;
import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.meta.JobMeta;
import org.github.foxnic.web.domain.job.meta.JobWorkerMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.job.JobWorkerServiceProxy;

import java.util.Date;


public class SysJobConfig extends BaseCodeConfig<SYS_JOB> {

	public SysJobConfig() {
		super(PREFIX_JOB,SYS_JOB.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(JobWorker.class,"worker","任务的执行类","任务的执行类");
		poType.shadow(SYS_JOB.STATUS, Status.class);
		poType.shadow(SYS_JOB.MISFIRE_POLICY, MisfirePolicy.class);
		poType.addSimpleProperty(Date.class,"nextFireTime","下一次执行时间","下次执行时间");
	}

	@Override
	public void configFields(ViewOptions view) {


		view.field(SYS_JOB.NAME).basic().label("任务名")
				.form().validate().required()
				.search().fuzzySearch();

		view.field(SYS_JOB.GROUP_TAG).basic().hidden().table().disable();

		view.field(SYS_JOB.WORKER_ID).basic().label("执行器")
				.form().validate().required()
			.form().selectBox().queryApi(JobWorkerServiceProxy.QUERY_PAGED_LIST).paging(true).muliti(false,false)
			.valueField(JobWorkerMeta.ID).textField(JobWorkerMeta.CLASS_NAME).fillWith(JobMeta.WORKER)
			.table().fillBy(JobMeta.WORKER,JobWorkerMeta.CLASS_NAME)
		;

		view.field(SYS_JOB.MISFIRE_POLICY).basic().label("执行策略")
				.form().validate().required()
				.form().selectBox().enumType(MisfirePolicy.class);


		view.field(SYS_JOB.CRON_EXPR)
				.basic().label("cron")
				.form().validate().required();

		view.field(SYS_JOB.PARAMETER).form().textArea().height(100);

		view.field(JobMeta.NEXT_FIRE_TIME).form().hidden().table().label("下次执行时间");

//		view.field(SYS_JOB.ERRORS).basic().label("失败次数").form().hidden();

		view.field(SYS_JOB.CONCURRENT).basic().label("允许并发")
				.form().validate().required()
				.form().logicField().on("允许",1).off("禁止",0);

		view.field(SYS_JOB.STATUS).basic().label("状态")
				.form().radioBox().enumType(Status.class)
			.form().validate().required();

	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		view.formWindow().width("700px");
		form.labelWidth(85);
		form.columnLayout(new Object[]{
				SYS_JOB.CODE,
				SYS_JOB.NAME,SYS_JOB.WORKER_ID,SYS_JOB.CRON_EXPR,
				SYS_JOB.CONCURRENT,SYS_JOB.MISFIRE_POLICY,
				SYS_JOB.PARAMETER,SYS_JOB.STATUS,
				SYS_JOB.NOTES
		});

//		form.addGroup(null,new Object[]{
//				SYS_JOB.NAME,SYS_JOB.WORKER_ID,SYS_JOB.CRON_EXPR,
//				SYS_JOB.CONCURRENT,SYS_JOB.MISFIRE_POLICY,
////				SYS_JOB.PARAMETER,SYS_JOB.STATUS,
////				SYS_JOB.NOTES
//		});

//		form.addGroup("XX",new Object[]{
////				SYS_JOB.NAME,SYS_JOB.WORKER_ID,SYS_JOB.CRON_EXPR,
////				SYS_JOB.CONCURRENT,SYS_JOB.MISFIRE_POLICY,
//				SYS_JOB.PARAMETER,SYS_JOB.STATUS,
//				SYS_JOB.NOTES
//		});

//		form.addGroup(null, new Object[]{
//						SYS_JOB.NAME, SYS_JOB.WORKER_ID, SYS_JOB.CRON_EXPR,
//						SYS_JOB.CONCURRENT, SYS_JOB.MISFIRE_POLICY,
//				}
//				, new Object[]{
//						SYS_JOB.PARAMETER, SYS_JOB.STATUS,
//						SYS_JOB.NOTES
//				});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

		list.operationColumn().addActionButton("立即调度","invokeImm","","bb-d4336a824f-be86");

		list.columnLayout(new Object[] {SYS_JOB.NAME,SYS_JOB.WORKER_ID,SYS_JOB.CRON_EXPR,SYS_JOB.MISFIRE_POLICY,
				SYS_JOB.STATUS,JobMeta.NEXT_FIRE_TIME});
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
