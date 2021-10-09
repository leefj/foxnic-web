package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_ROLE_EMPLOYEE;
import org.github.foxnic.web.domain.bpm.meta.RoleEmployeeMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;


public class BPMRoleEmployeeConfig extends BaseCodeConfig<BPM_ROLE_EMPLOYEE> {

	public BPMRoleEmployeeConfig() {
		super(PREFIX_BPM,BPM_ROLE_EMPLOYEE.$TABLE,"bpm_", 3);
	}

	@Override
	public void configModel(PoClassFile poType, VoClassFile voType) {
		poType.addSimpleProperty(Employee.class,"employee","员工","员工");
	}

	@Override
	public void configFields(ViewOptions view) {
		view.field(BPM_ROLE_EMPLOYEE.ID).search().hidden();
		view.field(BPM_ROLE_EMPLOYEE.ROLE_ID).search().hidden();
		view.field(BPM_ROLE_EMPLOYEE.EMPLOYEE_ID).search().hidden();

		view.field(HRM_PERSON.NAME).basic().label("姓名").search().fuzzySearch()
				.table().fillBy(RoleEmployeeMeta.EMPLOYEE,EmployeeMeta.PERSON, PersonMeta.NAME);

		view.field(HRM_EMPLOYEE.BADGE).basic().label("工号").search().fuzzySearch()
				.table().fillBy(RoleEmployeeMeta.EMPLOYEE,EmployeeMeta.BADGE);

		view.field("positionName").basic().label("岗位").search().fuzzySearch()
				.table().fillBy(RoleEmployeeMeta.EMPLOYEE,EmployeeMeta.POSITIONS, PositionMeta.FULL_NAME);

		view.field("deptName").basic().label("部门").search().fuzzySearch()
				.table().fillBy(RoleEmployeeMeta.EMPLOYEE,EmployeeMeta.ORGANIZATIONS, OrganizationMeta.FULL_NAME);
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
