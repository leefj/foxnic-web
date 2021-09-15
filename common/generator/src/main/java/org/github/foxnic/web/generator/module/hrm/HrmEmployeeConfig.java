package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.dict.EmployeeStatus;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
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
        //
        voType.addSimpleProperty(String.class, "orgId","所属组织ID","");
        voType.addSimpleProperty(String.class, "positionId","职位ID","");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    private String personNameField="name";
    private String companyNameField="companyName";

    @Override
    public void configFields(ViewOptions view) {
        view.field(HRM_EMPLOYEE.ID).basic().hidden();
        view.field(HRM_EMPLOYEE.BADGE)
                .form().validate().required()
                .search().fuzzySearch();
        view.field(HRM_EMPLOYEE.PERSON_ID).basic().hidden();

        view.field(HRM_EMPLOYEE.COMPANY_ID).basic().hidden();

//        view.field(HRM_EMPLOYEE.COMPANY_ID).basic().label("所属公司")
//                //.table().fillBy(EmployeeMeta.COMPANY, CompanyMeta.NAME)
//                .form().validate().required()
//                .form().selectBox().queryApi(CompanyServiceProxy.QUERY_PAGED_LIST+"?valid=1").paging(true).size(10)
//                .valueField(CompanyMeta.ID).textField(CompanyMeta.NAME).fillBy(EmployeeMeta.COMPANY)
//                .search().fuzzySearch();

        view.field(HRM_EMPLOYEE.PHONE).form().validate().required().phone();

        view.field(personNameField).basic().label("姓名")
                .table().fillBy(EmployeeMeta.PERSON, PersonMeta.NAME)
                .form().validate().required()
                .form().fillBy(EmployeeMeta.PERSON, PersonMeta.NAME)
            .search().fuzzySearch();

        view.field(PersonMeta.IDENTITY).basic().label("身份证")
                .search().hidden()
                .table().fillBy(EmployeeMeta.PERSON, PersonMeta.IDENTITY)
                .form().fillBy(EmployeeMeta.PERSON, PersonMeta.IDENTITY)
                .form().validate().required().identity()
        ;

        view.field(HRM_EMPLOYEE.STATUS)
                .form().radioBox().dict(DictEnum.EMPLOYEE_STATUS).defaultValue(EmployeeStatus.ACTIVE)
                .form().validate().required()
        ;

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
        form.labelWidth(80);
        form.columnLayout(new Object[] {
                PersonMeta.NAME,
                HRM_EMPLOYEE.BADGE,
                HRM_EMPLOYEE.STATUS,
                HRM_EMPLOYEE.PHONE,
                PersonMeta.IDENTITY
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.columnLayout(HRM_EMPLOYEE.COMPANY_ID,HRM_EMPLOYEE.BADGE,personNameField,HRM_EMPLOYEE.PHONE,HRM_EMPLOYEE.CREATE_TIME);
    }

    @Override
    public void configService(ServiceOptions service) {
        service.autoware(IPersonService.class);
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

}
