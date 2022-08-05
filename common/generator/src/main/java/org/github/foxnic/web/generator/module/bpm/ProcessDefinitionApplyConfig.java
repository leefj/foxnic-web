package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_DEPLOY;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class ProcessDefinitionApplyConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION_DEPLOY> {

    public ProcessDefinitionApplyConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION_DEPLOY.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {



    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {

    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.IGNORE) //Rest
            .setPageController(WriteMode.IGNORE) //页面控制器
            .setFormPage(WriteMode.IGNORE) //表单HTML页
            .setListPage(WriteMode.IGNORE) //列表HTML页
            .setExtendJsFile(WriteMode.IGNORE);
    }

}
