package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CODE_EXAMPLE_CAR;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.system.meta.CodeExampleCarMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class CodeExampleCarConfig extends BaseCodeConfig<SYS_CODE_EXAMPLE_CAR> {

    public CodeExampleCarConfig() {
        super("service-system", SYS_CODE_EXAMPLE_CAR.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Organization.class,"organization","关联组织","关联组织");
        poType.addSimpleProperty(Organization.class,"subOrganization","关联组织","关联组织");
        poType.addSimpleProperty(Organization.class,"company","关联公司","关联公司");
        poType.addSimpleProperty(Position.class,"position","关联岗位","关联岗位");
        poType.addSimpleProperty(Employee.class,"employee","关联人员","关联人员");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{SYS_CODE_EXAMPLE_CAR.PLATE_NUMBER,SYS_CODE_EXAMPLE_CAR.ORG_ID,SYS_CODE_EXAMPLE_CAR.EMP_ID});
//        context.view().list().disableMargin();
    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_CODE_EXAMPLE_CAR.ID).basic().hidden();
        view.field(SYS_CODE_EXAMPLE_CAR.EXAMPLE_ID)
                .basic().hidden();

        view.field(SYS_CODE_EXAMPLE_CAR.PLATE_NUMBER).basic().label("牌号").search().fuzzySearch();
        view.field(SYS_CODE_EXAMPLE_CAR.COLOR).basic().label("规格");

        //单选组织，包括公司和部门
        view.field(SYS_CODE_EXAMPLE_CAR.ORG_ID)
                .form().button().chooseOrganization(true)
        .table().fillBy(CodeExampleCarMeta.ORGANIZATION, OrganizationMeta.FULL_NAME);


        //多选组织，包括公司和部门
        view.field(SYS_CODE_EXAMPLE_CAR.ORG_IDS)
                .form().button().chooseOrganization(false);

        //单选组织，包括公司和部门，并指定根节点
        view.field(SYS_CODE_EXAMPLE_CAR.SUB_ORG_ID)
                .form().button().chooseOrganization(true,"shanghai")
                .table().fillBy(CodeExampleCarMeta.SUB_ORGANIZATION, OrganizationMeta.FULL_NAME);

        //单选组织，仅公司
        view.field(SYS_CODE_EXAMPLE_CAR.COM_ID)
                .form().button().chooseCompany(true)
                .table().fillBy(CodeExampleCarMeta.COMPANY, OrganizationMeta.FULL_NAME);

        //多选组织，仅部门
        view.field(SYS_CODE_EXAMPLE_CAR.DEPT_IDS)
                .form().button().chooseDepartment(false);

        //单选岗位
        view.field(SYS_CODE_EXAMPLE_CAR.POSITION_ID)
                .form().button().choosePosition(true)
                .table().fillBy(CodeExampleCarMeta.POSITION, PositionMeta.FULL_NAME);

        //多选岗位
        view.field(SYS_CODE_EXAMPLE_CAR.POSITION_IDS)
                .form().button().choosePosition(false);

        //单选员工
        view.field(SYS_CODE_EXAMPLE_CAR.EMP_ID)
                .form().button().chooseEmployee(true)
                .table().fillBy(CodeExampleCarMeta.EMPLOYEE, EmployeeMeta.PERSON, PersonMeta.NAME);

        //多选员工
        view.field(SYS_CODE_EXAMPLE_CAR.EMP_IDS)
                .form().button().chooseEmployee(false);



    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

        view.formWindow().width("80%");

        form.addGroup("基本信息",
                new Object[] {
                        SYS_CODE_EXAMPLE_CAR.PLATE_NUMBER
                }, new Object[] {
                        SYS_CODE_EXAMPLE_CAR.COLOR
                }
        );
        form.addGroup("选组织节点",
                new Object[] {
                        SYS_CODE_EXAMPLE_CAR.ORG_ID,
                        SYS_CODE_EXAMPLE_CAR.SUB_ORG_ID,
                        SYS_CODE_EXAMPLE_CAR.DEPT_IDS
                }, new Object[] {
                        SYS_CODE_EXAMPLE_CAR.ORG_IDS,
                        SYS_CODE_EXAMPLE_CAR.COM_ID,

                }
        );
        form.addGroup("选岗位",
                new Object[] {
                        SYS_CODE_EXAMPLE_CAR.POSITION_ID
                }, new Object[] {
                        SYS_CODE_EXAMPLE_CAR.POSITION_IDS
                }
        );
        form.addGroup("选员工",
                new Object[] {
                        SYS_CODE_EXAMPLE_CAR.EMP_ID
                }, new Object[] {
                        SYS_CODE_EXAMPLE_CAR.EMP_IDS
                }
        );
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.WRITE_TEMP_FILE)
        ;
    }

}
