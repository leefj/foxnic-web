package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_COMPANY;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class ProcessDefinitionFileConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION_FILE> {

    public ProcessDefinitionFileConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION_FILE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(User.class,"lastUpdateUser","最后修改人","最后修改人");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_PROCESS_DEFINITION_FILE.ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.DEFINITION_ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.FILE_ID).basic().label("流程文件").table().hidden().search().hidden()
                .form().upload().acceptExts("bpmn","txt").buttonLabel("上传流程图").maxFileCount(1).displayFileName(true)
                .form().validate().required();

        view.field(BPM_PROCESS_DEFINITION_FILE.NAME).search().fuzzySearch().form().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.VERSION_NO).search().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.ACTIVATED).basic().label("状态").form().logicField().on("有效",1).off("无效",0);

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
        form.columnLayout(new Object[]{
                BPM_PROCESS_DEFINITION_FILE.NAME,
                BPM_PROCESS_DEFINITION_FILE.FILE_ID,
                BPM_PROCESS_DEFINITION_FILE.NOTES
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableModify();
        list.disableBatchDelete().disableSingleDelete();
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
