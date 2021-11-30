package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER_TENANT;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.system.TenantServiceProxy;

public class UserTenantConfig extends BaseCodeConfig<SYS_USER_TENANT> {

    public UserTenantConfig() {
        super(PREFIX_SYSTEM, SYS_USER_TENANT.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Tenant.class,"tenant","租户对象","租户对象");
        poType.addSimpleProperty(Employee.class, "employee","当前激活的租户对应的员工", "当前激活的租户对应的员工");
        this.context.setRelationField(User.class,SYS_USER_TENANT.USER_ID, Tenant.class,SYS_USER_TENANT.OWNER_TENANT_ID,true);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.disable();
        view.list().disableMargin();
    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(80);

        view.field(SYS_USER_TENANT.ID).basic().hidden();
        view.field(SYS_USER_TENANT.USER_ID).basic().hidden();

        view.field(SYS_USER_TENANT.VALID).form().logicField().on("有效",1).off("无效",0);
        view.field(SYS_USER_TENANT.ACTIVATED).basic().label("默认")
                .form().logicField().on("默认",1).off("可选",0);

        view.field(SYS_USER_TENANT.OWNER_TENANT_ID)
                .basic().label("所属租户")
                .form().validate().required()
                .form().selectBox().queryApi(TenantServiceProxy.QUERY_PAGED_LIST).paging(true).size(10)
                .valueField(TenantMeta.ID).textField(TenantMeta.ALIAS)
        .fillWith(UserTenantMeta.TENANT)
        .table().fillBy(UserTenantMeta.TENANT,TenantMeta.ALIAS);


        view.field(SYS_USER_TENANT.EMPLOYEE_ID)
                .basic().label("工号")
                .form().validate().required()
                .form().selectBox().queryApi(EmployeeServiceProxy.QUERY_PAGED_LIST).paging(true).size(10)
                .valueField(EmployeeMeta.ID).textField(EmployeeMeta.NAME_AND_BADGE)
                .fillWith(UserTenantMeta.EMPLOYEE)
                .table().fillBy(UserTenantMeta.EMPLOYEE,EmployeeMeta.NAME_AND_BADGE).hidden(false);

    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS);
    }

}
