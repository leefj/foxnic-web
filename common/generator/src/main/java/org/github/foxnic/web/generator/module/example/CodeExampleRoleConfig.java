package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class CodeExampleRoleConfig extends BaseCodeConfig<FoxnicWeb.SYS_CODE_EXAMPLE_ROLE> {

    public CodeExampleRoleConfig() {
        super("service-system", FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        this.context.setRelationField(CodeExample.class,FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.EXAMPLE_ID, Role.class,FoxnicWeb.SYS_CODE_EXAMPLE_ROLE.ROLE_ID,true);
    }


    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.IGNORE) //Rest
            .setPageController(WriteMode.IGNORE) //页面控制器
            .setFormPage(WriteMode.IGNORE) //表单HTML页
            .setListPage(WriteMode.IGNORE); //列表HTML页
    }

}
