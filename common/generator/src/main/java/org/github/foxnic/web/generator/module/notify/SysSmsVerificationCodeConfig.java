package org.github.foxnic.web.generator.module.notify;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SMS_VERIFICATION_CODE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class SysSmsVerificationCodeConfig extends BaseCodeConfig<SYS_SMS_VERIFICATION_CODE> {

	public SysSmsVerificationCodeConfig() {
		super(PREFIX_NOTIFY,SYS_SMS_VERIFICATION_CODE.$TABLE,"sys_", 3);
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
//				SYS_SMS_VERIFICATION_CODE.CODE,
//				SYS_SMS_VERIFICATION_CODE.NAME,SYS_SMS_VERIFICATION_CODE.WORKER_ID,SYS_SMS_VERIFICATION_CODE.CRON_EXPR,
//				SYS_SMS_VERIFICATION_CODE.CONCURRENT,SYS_SMS_VERIFICATION_CODE.MISFIRE_POLICY,
//				SYS_SMS_VERIFICATION_CODE.PARAMETER,SYS_SMS_VERIFICATION_CODE.STATUS,
//				SYS_SMS_VERIFICATION_CODE.NOTES
//		});

//		form.addGroup(null,new Object[]{
//				SYS_SMS_VERIFICATION_CODE.NAME,SYS_SMS_VERIFICATION_CODE.WORKER_ID,SYS_SMS_VERIFICATION_CODE.CRON_EXPR,
//				SYS_SMS_VERIFICATION_CODE.CONCURRENT,SYS_SMS_VERIFICATION_CODE.MISFIRE_POLICY,
////				SYS_SMS_VERIFICATION_CODE.PARAMETER,SYS_SMS_VERIFICATION_CODE.STATUS,
////				SYS_SMS_VERIFICATION_CODE.NOTES
//		});

//		form.addGroup("XX",new Object[]{
////				SYS_SMS_VERIFICATION_CODE.NAME,SYS_SMS_VERIFICATION_CODE.WORKER_ID,SYS_SMS_VERIFICATION_CODE.CRON_EXPR,
////				SYS_SMS_VERIFICATION_CODE.CONCURRENT,SYS_SMS_VERIFICATION_CODE.MISFIRE_POLICY,
//				SYS_SMS_VERIFICATION_CODE.PARAMETER,SYS_SMS_VERIFICATION_CODE.STATUS,
//				SYS_SMS_VERIFICATION_CODE.NOTES
//		});

//		form.addGroup(null, new Object[]{
//						SYS_SMS_VERIFICATION_CODE.NAME, SYS_SMS_VERIFICATION_CODE.WORKER_ID, SYS_SMS_VERIFICATION_CODE.CRON_EXPR,
//						SYS_SMS_VERIFICATION_CODE.CONCURRENT, SYS_SMS_VERIFICATION_CODE.MISFIRE_POLICY,
//				}
//				, new Object[]{
//						SYS_SMS_VERIFICATION_CODE.PARAMETER, SYS_SMS_VERIFICATION_CODE.STATUS,
//						SYS_SMS_VERIFICATION_CODE.NOTES
//				});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

//		list.operationColumn().addActionButton("立即调度","invokeImm","","bb-d4336a824f-be86");
//
//		list.columnLayout(new Object[] {SYS_SMS_VERIFICATION_CODE.NAME,SYS_SMS_VERIFICATION_CODE.WORKER_ID,SYS_SMS_VERIFICATION_CODE.CRON_EXPR,SYS_SMS_VERIFICATION_CODE.MISFIRE_POLICY,
//				SYS_SMS_VERIFICATION_CODE.STATUS,JobMeta.NEXT_FIRE_TIME});
	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
//		search.inputLayout(new Object[] {SYS_SMS_VERIFICATION_CODE.NAME});
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
