package org.github.foxnic.web.generator.module.notify;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SMS_TEMPLATE;
import org.github.foxnic.web.constants.enums.job.MisfirePolicy;
import org.github.foxnic.web.constants.enums.job.Status;
import org.github.foxnic.web.domain.job.JobWorker;
import org.github.foxnic.web.domain.job.meta.JobMeta;
import org.github.foxnic.web.domain.job.meta.JobWorkerMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.job.JobWorkerServiceProxy;

import java.util.Date;


public class SysSmsTemplateConfig extends BaseCodeConfig<SYS_SMS_TEMPLATE> {

	public SysSmsTemplateConfig() {
		super(PREFIX_NOTIFY,SYS_SMS_TEMPLATE.$TABLE,"sys_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {

	}

	@Override
	public void configFields(ViewOptions view) {




	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		view.formWindow().width("700px");
		form.labelWidth(85);
//		form.columnLayout(new Object[]{
//				SYS_SMS_TEMPLATE.CODE,
//				SYS_SMS_TEMPLATE.NAME,SYS_SMS_TEMPLATE.WORKER_ID,SYS_SMS_TEMPLATE.CRON_EXPR,
//				SYS_SMS_TEMPLATE.CONCURRENT,SYS_SMS_TEMPLATE.MISFIRE_POLICY,
//				SYS_SMS_TEMPLATE.PARAMETER,SYS_SMS_TEMPLATE.STATUS,
//				SYS_SMS_TEMPLATE.NOTES
//		});

//		form.addGroup(null,new Object[]{
//				SYS_SMS_TEMPLATE.NAME,SYS_SMS_TEMPLATE.WORKER_ID,SYS_SMS_TEMPLATE.CRON_EXPR,
//				SYS_SMS_TEMPLATE.CONCURRENT,SYS_SMS_TEMPLATE.MISFIRE_POLICY,
////				SYS_SMS_TEMPLATE.PARAMETER,SYS_SMS_TEMPLATE.STATUS,
////				SYS_SMS_TEMPLATE.NOTES
//		});

//		form.addGroup("XX",new Object[]{
////				SYS_SMS_TEMPLATE.NAME,SYS_SMS_TEMPLATE.WORKER_ID,SYS_SMS_TEMPLATE.CRON_EXPR,
////				SYS_SMS_TEMPLATE.CONCURRENT,SYS_SMS_TEMPLATE.MISFIRE_POLICY,
//				SYS_SMS_TEMPLATE.PARAMETER,SYS_SMS_TEMPLATE.STATUS,
//				SYS_SMS_TEMPLATE.NOTES
//		});

//		form.addGroup(null, new Object[]{
//						SYS_SMS_TEMPLATE.NAME, SYS_SMS_TEMPLATE.WORKER_ID, SYS_SMS_TEMPLATE.CRON_EXPR,
//						SYS_SMS_TEMPLATE.CONCURRENT, SYS_SMS_TEMPLATE.MISFIRE_POLICY,
//				}
//				, new Object[]{
//						SYS_SMS_TEMPLATE.PARAMETER, SYS_SMS_TEMPLATE.STATUS,
//						SYS_SMS_TEMPLATE.NOTES
//				});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

//		list.operationColumn().addActionButton("立即调度","invokeImm","","bb-d4336a824f-be86");
//
//		list.columnLayout(new Object[] {SYS_SMS_TEMPLATE.NAME,SYS_SMS_TEMPLATE.WORKER_ID,SYS_SMS_TEMPLATE.CRON_EXPR,SYS_SMS_TEMPLATE.MISFIRE_POLICY,
//				SYS_SMS_TEMPLATE.STATUS,JobMeta.NEXT_FIRE_TIME});
	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
//		search.inputLayout(new Object[] {SYS_SMS_TEMPLATE.NAME});
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
