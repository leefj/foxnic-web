package org.github.foxnic.web.generator.module.example;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class CodeExampleCarConfig extends BaseCodeConfig<SYS_CODE_EXAMPLE_CAR> {

    public CodeExampleCarConfig() {
        super("service-system", SYS_CODE_EXAMPLE_CAR.$TABLE,"sys_", 4);
    }




    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
