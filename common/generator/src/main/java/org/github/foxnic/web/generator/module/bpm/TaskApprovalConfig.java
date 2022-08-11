package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_APPROVAL;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class TaskApprovalConfig extends BaseCodeConfig<BPM_TASK_APPROVAL> {

    public TaskApprovalConfig() {
        super(PREFIX_BPM, BPM_TASK_APPROVAL.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Assignee.class,"approver","审批人身份","审批人身份");
        poType.addSimpleProperty(User.class,"approvalUser","审批人账户","审批人账户");
        poType.shadow(BPM_TASK_APPROVAL.APPROVAL_RESULT, ApprovalResult.class);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
//        search.inputLayout(new Object[]{BPM_PROCESS_DEFINITION_NODE_ASSIGNEE.NODE_NAME});
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
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
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
            .setPageController(WriteMode.IGNORE) //页面控制器
            .setFormPage(WriteMode.IGNORE) //表单HTML页
            .setListPage(WriteMode.IGNORE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
    }

}
