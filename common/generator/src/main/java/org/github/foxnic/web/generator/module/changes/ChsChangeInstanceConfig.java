package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_INSTANCE;
import org.github.foxnic.web.constants.enums.bpm.ApprovalCatalog;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.changes.ChangeApprover;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.BusiRole;
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
//		poType.shadow(CHS_CHANGE_INSTANCE.SIMPLE_APPROVE_LOGIC, ApprovalLogic.class);
		poType.addSimpleProperty(ChangeData.class,"dataBefore","变更前的数据","变更前的数据");
		poType.addSimpleProperty(ChangeData.class,"dataAfter","变更后的数据","变更后的数据");
		poType.addSimpleProperty(ChangeDefinition.class,"definition","流程定义对象","流程定义");

		//
		poType.addListProperty(Employee.class,"currEmployeeApprovers","当前可审批员工清单","");
		poType.addListProperty(BusiRole.class,"currBusiRoleApprovers","当前可审批流程角色清单","");


		//
		poType.addListProperty(ChangeApprover.class,"currEmployeeApproverIds","当前可审批员工ID清单","");
		poType.addListProperty(ChangeApprover.class,"currBusiRoleApproverIds","当前可审批流程角色ID清单","");


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

		voType.addSimpleProperty(String.class,"catalog","流程分类","流程分类");

	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(CHS_CHANGE_INSTANCE.ID).basic().hidden();
		view.field(CHS_CHANGE_INSTANCE.DEFINITION_ID).basic().hidden();
		view.field(CHS_CHANGE_INSTANCE.DRAFTER_ID).basic().hidden();
		view.field(CHS_CHANGE_INSTANCE.CREATE_TIME).basic().hidden();
		view.field(CHS_CHANGE_INSTANCE.DRAFTER_NAME).basic().label("起草人");
		view.field(CHS_CHANGE_INSTANCE.PROCESS_ID)
				.table().hidden()
				.search().hidden();
		view.field(CHS_CHANGE_INSTANCE.PROCESS_SUMMARY)
				.table().hidden()
				.search().hidden();
		view.field(CHS_CHANGE_INSTANCE.PROCESS_NODE_SUMMARY)
				.table().hidden()
				.search().hidden();

		view.field(CHS_CHANGE_INSTANCE.SIMPLE_APPROVERS)
				.table().hidden()
				.search().hidden();
		view.field(CHS_CHANGE_INSTANCE.SIMPLE_NODE_ID).basic().hidden();

		view.field(CHS_CHANGE_INSTANCE.START_TIME).basic().label("发起时间").search().hidden().form().dateInput().format("yyyy-MM-dd HH:mm:ss");
		view.field(CHS_CHANGE_INSTANCE.FINISH_TIME).basic().label("结束时间").search().hidden().form().dateInput().format("yyyy-MM-dd HH:mm:ss");

		view.field(CHS_CHANGE_INSTANCE.MODE).form().radioBox().enumType(ApprovalMode.class);
		view.field(CHS_CHANGE_INSTANCE.STATUS).form().radioBox().enumType(ApprovalStatus.class);
		view.field(CHS_CHANGE_INSTANCE.TYPE).form().radioBox().enumType(ChangeType.class);

		view.field("catalog").basic().label("分类")
				.search().inputWidth(160)
				.form().selectBox().enumType(ApprovalCatalog.class).muliti(false,false);


	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.inputLayout(new Object[]{
				"catalog",CHS_CHANGE_INSTANCE.MODE,CHS_CHANGE_INSTANCE.DRAFTER_NAME,CHS_CHANGE_INSTANCE.STATUS,CHS_CHANGE_INSTANCE.TYPE
		});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.disableCreateNew().disableBatchDelete().disableSingleDelete().disableModify().disableFormView();

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
