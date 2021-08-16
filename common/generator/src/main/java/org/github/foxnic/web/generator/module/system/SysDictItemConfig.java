package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT_ITEM;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SysDictItemConfig extends BaseCodeConfig<FoxnicWeb.SYS_DICT_ITEM> {

    public SysDictItemConfig() {
        super("service-system", SYS_DICT_ITEM.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

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
