package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_INVOKE_LOG;
import org.github.foxnic.web.constants.enums.system.ResourceType;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.meta.CompanyMeta;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.hrm.CompanyServiceProxy;

public class InvokeLogConfig extends BaseCodeConfig<SYS_INVOKE_LOG> {

    public InvokeLogConfig() {
        super(PREFIX_SYSTEM, SYS_INVOKE_LOG.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(SYS_INVOKE_LOG.TYPE, ResourceType.class);
        poType.addSimpleProperty(Integer.class,"step","写入进度","写入进度");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

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

    public static void main(String[] args) {
        execute();
    }

}
