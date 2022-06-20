package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.queue.QueueStatus;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_EVENT_CALLBACK;
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.constants.enums.bpm.CamundaNodeType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class EventCallbackConfig extends BaseCodeConfig<BPM_EVENT_CALLBACK> {

    public EventCallbackConfig() {
        super(PREFIX_BPM, BPM_EVENT_CALLBACK.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(BPM_EVENT_CALLBACK.EVENT_TYPE, BpmEventType.class);
        poType.shadow(BPM_EVENT_CALLBACK.STATUS, QueueStatus.class);
        poType.shadow(BPM_EVENT_CALLBACK.NODE_TYPE, CamundaNodeType.class);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(100);
//
//        view.field(BPM_PROCESS_DEFINITION_NODE.NODE_NAME).search().fuzzySearch();
//
//        view.field( BPM_PROCESS_DEFINITION_NODE.CAMUNDA_NODE_ID).form().readOnly();
//        view.field( BPM_PROCESS_DEFINITION_NODE.NODE_TYPE).form().readOnly();

//        view.field(BPM_PROCESS_DEFINITION_FILE.FILE_ID).basic().label("流程文件").table().hidden().search().hidden()
//                .form().upload().acceptExts("bpmn","txt").buttonLabel("上传流程图").maxFileCount(1).displayFileName(true)
//                .form().validate().required();
//
//        view.field(BPM_PROCESS_DEFINITION_FILE.NAME).search().fuzzySearch().form().hidden();
//        view.field(BPM_PROCESS_DEFINITION_FILE.VERSION_NO).search().hidden();
//        view.field(BPM_PROCESS_DEFINITION_FILE.ACTIVATED).basic().label("状态").form().hidden();
//
//        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_ERROR).basic().label("部署提示").search().hidden();
//        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_RESULT).search().hidden().table().disable();
//        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_SUCCESS).basic().label("部署结果").search().hidden();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
//        form.columnLayout(new Object[]{
//                BPM_PROCESS_DEFINITION_NODE.CAMUNDA_NODE_ID,
//                BPM_PROCESS_DEFINITION_NODE.NODE_TYPE
//        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableCreateNew();
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
