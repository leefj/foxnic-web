package org.github.foxnic.web.generator.module.bpm;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_FILE;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class ProcessDefinitionFileConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION_FILE> {

    public ProcessDefinitionFileConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION_FILE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.addSimpleProperty(User.class,"lastUpdateUser","最后修改人","最后修改人");
        // 映射逻辑值
        poType.shadowBoolean(BPM_PROCESS_DEFINITION_FILE.ACTIVATED);
        poType.addListProperty(ProcessDefinitionNode.class,"nodes","审批节点清单","审批节点清单");

        //
        voType.addSimpleProperty(JSONObject.class,"extraModelSettings","模型的额外设置信息","模型的额外设置信息");




    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_PROCESS_DEFINITION_FILE.ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.MODEL_XML).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.PROCESS_DEFINITION_ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.FILE_ID).basic().label("流程文件").table().hidden().search().hidden()
                .form().upload().acceptExts("bpmn","txt").buttonLabel("上传流程图").maxFileCount(1).displayFileName(true)
                .form().validate().required();

        view.field(BPM_PROCESS_DEFINITION_FILE.NAME).search().fuzzySearch().form().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.VERSION_NO).search().hidden().form().validate().required(false);
        view.field(BPM_PROCESS_DEFINITION_FILE.ACTIVATED).basic().label("状态").form().hidden().search().hidden().table().alignCenter();


        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_ERROR).basic().label("部署提示").search().hidden();
        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_RESULT).search().hidden().table().disable();
        view.field(BPM_PROCESS_DEFINITION_FILE.DEPLOY_SUCCESS).basic().label("部署结果").search().hidden();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.columnLayout(new Object[]{
                BPM_PROCESS_DEFINITION_FILE.NAME,
                BPM_PROCESS_DEFINITION_FILE.FILE_ID,
                BPM_PROCESS_DEFINITION_FILE.NOTES
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableModify().disableFormView();
        list.disableBatchDelete();
//        list.operationColumn().addActionButton("节点","showNodes");
        list.operationColumn().addActionButton("打开","showModel");
//        list.operationColumn().addActionButton("部署","deploy");
        list.operationColumn().addActionButton("复制","duplicate");
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
