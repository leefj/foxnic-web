package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_TENANT;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.meta.CompanyMeta;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.hrm.CompanyServiceProxy;

public class TenantConfig extends BaseCodeConfig<SYS_TENANT> {

    public TenantConfig() {
        super(PREFIX_SYSTEM, SYS_TENANT.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Company.class,"company","公司","租户对应的公司");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_TENANT.ID).basic().hidden();
        view.field(SYS_TENANT.COMPANY_ID).basic().label("公司")
                .form().selectBox()
                .queryApi(CompanyServiceProxy.QUERY_PAGED_LIST).paging(true).size(10)
                .textField(CompanyMeta.NAME).valueField(CompanyMeta.ID).fillWith(TenantMeta.COMPANY)
                .search().inputWidth(200)
                .table().fillBy(TenantMeta.COMPANY,CompanyMeta.NAME)
        ;
        view.field(SYS_TENANT.VALID).form().logicField().off("无效",0).on("有效",1);
        //
        view.field(SYS_TENANT.ALIAS)
                .basic().label("租户别名")
                .search().fuzzySearch();
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        super.configForm(view, form, formWindow);
        view.formWindow().bottomSpace(200);
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
