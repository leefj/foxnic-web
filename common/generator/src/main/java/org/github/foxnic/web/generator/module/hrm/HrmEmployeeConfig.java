package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.dict.EmployeeStatus;
import org.github.foxnic.web.domain.hrm.*;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.EmployeeVOMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.hrm.meta.PositionMeta;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.hrm.service.IPersonService;

public class HrmEmployeeConfig extends BaseCodeConfig<HRM_EMPLOYEE> {

    public HrmEmployeeConfig() {
        super(PREFIX_HRM, HRM_EMPLOYEE.$TABLE,"hrm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.setSuperType(Person.class);
        poType.addSimpleProperty( Person.class, "person","对应的人员信息", "对应的人员信息");
        poType.addSimpleProperty( Company.class, "company","所属公司", "所属公司");
        poType.addSimpleProperty( String.class, "nameAndBadge","姓名与工号", "虚拟属性");
        poType.addListProperty( Position.class, "positions","岗位清单", "作为员工时，所属的岗位清单");
        poType.addListProperty( Organization.class, "organizations","组织清单", "作为员工时，所属的组织清单");
        poType.addSimpleProperty( Position.class, "primaryPosition","主岗", "作为员工时，所属的主岗");
        poType.addSimpleProperty( Organization.class, "primaryOrganization","主岗部门", "作为员工时，所属的主岗部门");
        poType.addListProperty( BusiRole.class, "busiRoles","业务角色清单", "作为员工时，所属的业务角色");
        poType.addSimpleProperty(String.class, "primaryPositionId","主岗ID","只有一个");
        poType.addListProperty(String.class, "vicePositionIds","兼岗ID","多个用逗号隔开");
        poType.addListProperty( Position.class, "vicePositions","兼岗", "作为员工时，所属的兼岗");
        poType.addMapProperty(String.class,Object.class,"extInfo","扩展信息","员工扩展信息");

        poType.addSimpleProperty( Employee.class, "directLeader","直属领导", "直属领导");
        //
        voType.addSimpleProperty(String.class, "orgId","所属组织ID","");
        voType.addSimpleProperty(String.class, "positionId","岗位ID","");


    }


    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{
                HRM_EMPLOYEE.BADGE,
                personNameField,
                HRM_EMPLOYEE.PHONE,
                personSexField,
                HRM_EMPLOYEE.TYPE,
                HRM_EMPLOYEE.STATUS
        });
    }

    private String personNameField="name";
    private String personSexField="sex";
    private String companyNameField="companyName";

    @Override
    public void configFields(ViewOptions view) {
        view.field(HRM_EMPLOYEE.ID).basic().hidden();

        view.field(EmployeeMeta.EXT_INFO).basic().hidden();

        view.field(HRM_EMPLOYEE.BADGE)
                .form().validate().required()
                .search().inputWidth(90).fuzzySearch();

        view.field(HRM_EMPLOYEE.PERSON_ID).basic().hidden();

        view.field(HRM_EMPLOYEE.COMPANY_ID).basic().hidden();

//        view.field(HRM_EMPLOYEE.COMPANY_ID).basic().label("所属公司")
//                //.table().fillBy(EmployeeMeta.COMPANY, CompanyMeta.NAME)
//                .form().validate().required()
//                .form().selectBox().queryApi(CompanyServiceProxy.QUERY_PAGED_LIST+"?valid=1").paging(true).size(10)
//                .valueField(CompanyMeta.ID).textField(CompanyMeta.NAME).fillBy(EmployeeMeta.COMPANY)
//                .search().fuzzySearch();

        view.field(HRM_EMPLOYEE.PHONE).form().validate().required().phone()
                .search().inputWidth(90).fuzzySearch();

        view.field(personNameField).basic().label("姓名")
                .table().fillBy(EmployeeMeta.PERSON, PersonMeta.NAME).sort(true)
                .form().validate().required()
                .form().fillBy(EmployeeMeta.PERSON, PersonMeta.NAME)
            .search().inputWidth(90).fuzzySearch();


        view.field(personSexField).basic().label("姓别")
                .table().fillBy(EmployeeMeta.PERSON, PersonMeta.SEX).sort(true).alignCenter()
                .form().validate().required()
                .form().radioBox().dict(DictEnum.SEX).defaultIndex(0)
                .form().fillBy(EmployeeMeta.PERSON, PersonMeta.SEX)
                .search().selectMuliti(false).triggerOnSelect(true)
                .search().inputWidth(100).on(FoxnicWeb.HRM_PERSON.SEX);

        view.field(PersonMeta.IDENTITY).basic().label("身份证")
                .search().hidden()
                .table().sort(true)
                .table().fillBy(EmployeeMeta.PERSON, PersonMeta.IDENTITY)
                .form().fillBy(EmployeeMeta.PERSON, PersonMeta.IDENTITY)
                //.form().validate().required().identity()
        ;

        view.field(HRM_EMPLOYEE.STATUS)
                .form().radioBox().dict(DictEnum.EMPLOYEE_STATUS).defaultValue(EmployeeStatus.ACTIVE)
                .search().selectMuliti(false).triggerOnSelect(true)
                .form().validate().required()
                .search().inputWidth(100)
        ;

        view.field(HRM_EMPLOYEE.TYPE)
                .form().selectBox().dict(DictEnum.EMPLOYEE_TYPE)
                .search().selectMuliti(false).triggerOnSelect(true)
        ;

        view.field(HRM_EMPLOYEE.DIRECT_LEADER_ID).basic().label("直属领导")
                .form()
                .form().button().chooseEmployee(true)
                .table().sort(false)
                .table().fillBy(EmployeeMeta.DIRECT_LEADER, EmployeeMeta.NAME)
                .search().hidden();


        view.field(EmployeeVOMeta.PRIMARY_POSITION_ID).basic().label("主岗")
        .form().validate().required()
        .form().button().choosePosition(true)
                .table().sort(false)
        .table().fillBy(EmployeeMeta.PRIMARY_POSITION, PositionMeta.FULL_NAME)
        .search().hidden();

        view.field(EmployeeVOMeta.PRIMARY_ORGANIZATION).basic().label("部门")
                .table().fillBy(EmployeeMeta.PRIMARY_ORGANIZATION, PositionMeta.FULL_NAME)
                .search().hidden();

        view.field(EmployeeVOMeta.VICE_POSITION_IDS).basic().label("兼岗")
            .form().button().choosePosition(false)
                .table().sort(false)
                .table().fillBy(EmployeeMeta.VICE_POSITIONS, PositionMeta.FULL_NAME)
            .search().hidden();

    }



    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.addJsVariable("extInfoAttrs","[[${extInfoAttrs}]]","员工扩展信息");
        form.labelWidth(80);

        formWindow.width("800px");

        form.columnLayout(new Object[] {
                PersonMeta.NAME,
                HRM_EMPLOYEE.TYPE,
                HRM_EMPLOYEE.PHONE,
                PersonMeta.IDENTITY,
                EmployeeVOMeta.PRIMARY_POSITION_ID,

        },new Object[] {
                HRM_EMPLOYEE.BADGE,
                personSexField,
                HRM_EMPLOYEE.STATUS,
                HRM_EMPLOYEE.DIRECT_LEADER_ID,
                EmployeeVOMeta.VICE_POSITION_IDS
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.addJsVariable("extInfoAttrs","[[${extInfoAttrs}]]","员工扩展信息");
        list.columnLayout(HRM_EMPLOYEE.COMPANY_ID,HRM_EMPLOYEE.BADGE,personNameField,personSexField,HRM_EMPLOYEE.PHONE,EmployeeVOMeta.PRIMARY_ORGANIZATION,EmployeeVOMeta.PRIMARY_POSITION_ID,HRM_EMPLOYEE.CREATE_TIME);
    }

    @Override
    public void configService(ServiceOptions service) {
        service.autoware(IPersonService.class,"人员服务");
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

    public static void main(String[] args) {
        execute();
    }

}
