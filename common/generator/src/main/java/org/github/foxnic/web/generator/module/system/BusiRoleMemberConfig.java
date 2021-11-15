package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_PERSON;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_BUSI_ROLE_MEMBER;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.system.meta.BusiRoleMemberMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class BusiRoleMemberConfig extends BaseCodeConfig<SYS_BUSI_ROLE_MEMBER> {

	public BusiRoleMemberConfig() {
		super(PREFIX_SYSTEM,SYS_BUSI_ROLE_MEMBER.$TABLE,"sys_", 3);
	}

	@Override
	public void configService(ServiceOptions service) {

	}

	@Override
	public void configController(ControllerOptions controller) {
		//指定控制器中的保存模式
		controller.saveMode(SaveMode.NOT_NULL_FIELDS);
		//指定控制器中的删除模式
		controller.usePhysicalDelete();
		//加入批量插入接口
		controller.batchInsert();
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(Employee.class,"employee","员工","员工");
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(SYS_BUSI_ROLE_MEMBER.ID).search().hidden();
		view.field(SYS_BUSI_ROLE_MEMBER.ROLE_ID).search().hidden();
		view.field(SYS_BUSI_ROLE_MEMBER.MEMBER_TYPE).search().hidden();
		view.field(SYS_BUSI_ROLE_MEMBER.MEMBER_ID).search().hidden();

		view.field(FoxnicWeb.HRM_PERSON.NAME).basic().label("姓名").search().fuzzySearch().on(HRM_PERSON.NAME)
				.table().fillBy(BusiRoleMemberMeta.EMPLOYEE, EmployeeMeta.PERSON, PersonMeta.NAME);

		view.field(HRM_EMPLOYEE.BADGE).basic().label("工号").search().fuzzySearch().on(HRM_EMPLOYEE.BADGE)
				.table().fillBy(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.BADGE);

		view.field("positionName").basic().label("岗位").search().fuzzySearch().on(FoxnicWeb.HRM_POSITION.FULL_NAME)
				.table().fillBy(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.POSITIONS, PositionMeta.FULL_NAME);

		view.field("deptName").basic().label("部门").search().fuzzySearch().on(FoxnicWeb.HRM_ORGANIZATION.FULL_NAME)
				.table().fillBy(BusiRoleMemberMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS, OrganizationMeta.FULL_NAME);
	}

	@Override
	public void configList(ViewOptions view, ListOptions list) {
		list.columnLayout(HRM_EMPLOYEE.BADGE,HRM_PERSON.NAME,"positionName","deptName");
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
