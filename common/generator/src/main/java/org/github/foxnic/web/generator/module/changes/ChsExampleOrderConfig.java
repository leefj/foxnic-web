package org.github.foxnic.web.generator.module.changes;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_EXAMPLE_ORDER;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.changes.ExampleOrderItem;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class ChsExampleOrderConfig extends BaseCodeConfig<CHS_EXAMPLE_ORDER> {

	public ChsExampleOrderConfig() {
		super(PREFIX_CHANGES,CHS_EXAMPLE_ORDER.$TABLE,"chs_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.shadow(CHS_EXAMPLE_ORDER.CHS_STATUS, ApprovalStatus.class);
		poType.shadow(CHS_EXAMPLE_ORDER.CHS_TYPE, ChangeType.class);
		poType.addListProperty(ExampleOrderItem.class,"items","订单明细","订单明细");
		poType.addSimpleProperty(Employee.class,"buyerEmployee","采购人","采购人");
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(CHS_EXAMPLE_ORDER.ID).basic().hidden();
		view.field(CHS_EXAMPLE_ORDER.ORDER_TIME).search().hidden();
		view.field(CHS_EXAMPLE_ORDER.TITLE)
				//.table().permission("xxx")
				.search().fuzzySearch();
		view.field(CHS_EXAMPLE_ORDER.CODE).search().fuzzySearch();

		view.field(CHS_EXAMPLE_ORDER.ORDER_TIME).form().dateInput().format("yyyy-MM-dd");

		//变更状态
		view.field(CHS_EXAMPLE_ORDER.CHS_STATUS)
				.form().radioBox().enumType(ApprovalStatus.class)
				.form().hidden();

		view.field(CHS_EXAMPLE_ORDER.SOURCE_ID).form().hidden();

		//变更类型
		view.field(CHS_EXAMPLE_ORDER.CHS_TYPE)
				.form().radioBox().enumType(ChangeType.class)
				.form().hidden();

		view.field(CHS_EXAMPLE_ORDER.CHS_VERSION).basic().label("版本").form().hidden();
		view.field(CHS_EXAMPLE_ORDER.AMOUNT).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.SOURCE_ID).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.SUMMARY).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.BUYER_ID)
				.basic().label("买家")
				.table().fillBy(ExampleOrderMeta.BUYER_EMPLOYEE, EmployeeMeta.PERSON, PersonMeta.NAME)
				.form().button().chooseEmployee(true);
		view.field(CHS_EXAMPLE_ORDER.CHANGE_INSTANCE_ID).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.LATEST_APPROVER_ID).basic().hidden().label("最后审批人");
		view.field(CHS_EXAMPLE_ORDER.LATEST_APPROVER_NAME).form().hidden();
		view.field(CHS_EXAMPLE_ORDER.NEXT_APPROVER_IDS).basic().hidden();
		view.field(CHS_EXAMPLE_ORDER.NEXT_APPROVER_NAMES).basic().label("下一审批人").form().hidden();

	}

	@Override
	public void configSearch(ViewOptions view, SearchAreaOptions search) {
		search.inputLayout(new Object[]{CHS_EXAMPLE_ORDER.TITLE,CHS_EXAMPLE_ORDER.CODE,CHS_EXAMPLE_ORDER.CHS_TYPE,CHS_EXAMPLE_ORDER.CHS_STATUS});
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {

		list.configCreateNewButton("创建订单",null,"no-css-create");
		list.configBatchDeleteButton("删除订单",null,"no-css-delete");

		list.addToolButton("起草","draftProcess","");
		list.addToolButton("提交","submitProcess","");
		list.addToolButton("撤回","revokeProcess","");
		list.addToolButton("作废","abandonProcess","");
		list.addToolButton("同意","agreeNode","");
		list.addToolButton("驳回","rejectNode","");


		//设置额外的按钮
		list.operationColumn().addActionButton("明细","openDetails","css");
//		list.operationColumn().addActionMenu("明细细","openDetailss","uuu");

		//配置按钮
		list.operationColumn().configFormViewButton("看看",null,"no-css-create");
		list.operationColumn().configModifyButton("打开",null,"no-css-create");
		list.operationColumn().configDeleteButton("删了",null,"no-css-create");
	}

	@Override
	public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
		view.formWindow().bottomSpace(200);
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
