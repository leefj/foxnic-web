package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_INSTANCE;
import org.github.foxnic.web.constants.enums.changes.ApprovalLogic;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ChsChangeInstanceConfig extends BaseCodeConfig<CHS_CHANGE_INSTANCE> {

	public ChsChangeInstanceConfig() {
		super(PREFIX_CHANGES,CHS_CHANGE_INSTANCE.$TABLE,"chs_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.shadow(CHS_CHANGE_INSTANCE.STATUS, ApprovalStatus.class);
		poType.shadow(CHS_CHANGE_INSTANCE.TYPE, ChangeType.class);
		poType.shadow(CHS_CHANGE_INSTANCE.MODE, ApprovalMode.class);
		poType.shadow(CHS_CHANGE_INSTANCE.SIMPLE_APPROVE_LOGIC, ApprovalLogic.class);
		poType.addSimpleProperty(ChangeData.class,"dataBefore","变更前的数据","变更前的数据");
		poType.addSimpleProperty(ChangeData.class,"dataAfter","变更后的数据","变更后的数据");

		PojoClassFile pojo=context.createPojo("ProcessStartVO");
		pojo.setSuperType(null);
		pojo.setDoc("用于流程提交");
		pojo.addListProperty(String.class,"billIds","业务单据号","");
		pojo.addSimpleProperty(String.class,"opinion","审批意见","");

		pojo=context.createPojo("ProcessApproveVO");
		pojo.setSuperType(null);
		pojo.setDoc("用于流程审批");
		pojo.addListProperty(String.class,"instanceIds","业务单据号","");
		pojo.addSimpleProperty(String.class,"opinion","审批意见","");
		pojo.addSimpleProperty(String.class,"action","审批动作","ApprovalAction的一种");

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
