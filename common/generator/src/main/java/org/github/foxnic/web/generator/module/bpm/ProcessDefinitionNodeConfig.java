package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_NODE;
import org.github.foxnic.web.constants.enums.bpm.CamundaNodeType;
import org.github.foxnic.web.constants.enums.bpm.UserTaskType;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionNodeAssigneeMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionNodeMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionNodeVOMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class ProcessDefinitionNodeConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION_NODE> {

    public ProcessDefinitionNodeConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION_NODE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        voType.addSimpleProperty(String.class,"assigneeInfo","选择的审批人信息","选择的审批人信息");
        poType.addListProperty(ProcessDefinitionNodeAssignee.class,"assignees","审批人清单","审批人清单");
        // 将属性映射为枚举，将 bpm_process_definition_node 的 node_type 射为 CamundaNodeType 枚举类型
        poType.shadow(BPM_PROCESS_DEFINITION_NODE.NODE_TYPE, CamundaNodeType.class);
        poType.shadow(BPM_PROCESS_DEFINITION_NODE.USER_TASK_TYPE, UserTaskType.class);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{BPM_PROCESS_DEFINITION_NODE.NODE_NAME});
    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(100);
//
        view.field(BPM_PROCESS_DEFINITION_NODE.NODE_NAME).search().fuzzySearch();

        view.field(BPM_PROCESS_DEFINITION_NODE.CAMUNDA_NODE_ID).basic().label("ID").form().readOnly();
        view.field(BPM_PROCESS_DEFINITION_NODE.NODE_TYPE).form().readOnly();
        view.field(BPM_PROCESS_DEFINITION_NODE.NODE_NAME).form().readOnly();
        view.field(ProcessDefinitionNodeVOMeta.ASSIGNEE_INFO).basic().label("审批人").form().button().chooseEmployee(false)
                .form().validate().required()
                .table().fillBy(ProcessDefinitionNodeMeta.ASSIGNEES, ProcessDefinitionNodeAssigneeMeta.ASSIGNEE,"name");

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
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.columnLayout(new Object[]{
                BPM_PROCESS_DEFINITION_NODE.CAMUNDA_NODE_ID,
                BPM_PROCESS_DEFINITION_NODE.NODE_NAME,
                BPM_PROCESS_DEFINITION_NODE.NODE_TYPE,
                ProcessDefinitionNodeVOMeta.ASSIGNEE_INFO
        });
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
