package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER_TENANT;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class UserTenantConfig extends BaseCodeConfig<SYS_USER_TENANT> {

    public UserTenantConfig() {
        super(PREFIX_SYSTEM, SYS_USER_TENANT.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        this.context.setRelationField(SYS_USER_TENANT.USER_ID,SYS_USER_TENANT.TENANT_ID,true);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {
//        view.field(SYS_CODE_EXAMPLE_STUDENT.ID).basic().hidden();
//        view.field(SYS_CODE_EXAMPLE_STUDENT.EXAMPLE_ID)
//                .basic().hidden();
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
