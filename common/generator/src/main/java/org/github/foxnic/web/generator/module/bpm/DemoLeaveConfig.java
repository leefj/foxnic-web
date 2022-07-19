package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.bpm.IntegrateMode;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.BpmOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_DEMO_LEAVE;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.constants.enums.bpm.DemoStatus;
import org.github.foxnic.web.constants.enums.bpm.FormType;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.meta.DemoLeaveMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import org.github.foxnic.web.domain.bpm.meta.TaskMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class DemoLeaveConfig extends BaseCodeConfig<BPM_DEMO_LEAVE> {

    public DemoLeaveConfig() {
        super(PREFIX_BPM, BPM_DEMO_LEAVE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(BPM_DEMO_LEAVE.STATUS, DemoStatus.class);
    }

    @Override
    public void configBPM(BpmOptions bpm) {
        bpm.form("demo-leave");
        bpm.integrate(IntegrateMode.FRONT);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(70);

//     view.field(BPM_FORM_DEFINITION.ID).basic().hidden();
        view.field(BPM_DEMO_LEAVE.TYPE).search().hidden()
                .form().validate().required()
                .form().selectBox().dict(DictEnum.LEAVE_TYPE).table().useThemeBadgeStyle();
        view.field(BPM_DEMO_LEAVE.BEGIN_TIME).search().hidden().form().validate().required()
                .form().dateInput().renderAtTop(true);
        view.field(BPM_DEMO_LEAVE.END_TIME).search().hidden().form().validate().required()
                .form().dateInput().renderAtTop(true);

        view.field(BPM_DEMO_LEAVE.REASON).search().hidden().form().validate().required();
        view.field(BPM_DEMO_LEAVE.APPLICANT_ID).basic().hidden();


       // 流程字段：仅支持显示，不支持搜索

        view.field("processTitle").basic().label("流程抬头")
                .search().hidden().form().hidden()
                .table().fillByProperty(DemoLeaveMeta.DEFAULT_PROCESS, ProcessInstanceMeta.TITLE).useThemeBadgeStyle();

        view.field("processStatus").basic().label("审批状态")
                .search().hidden().form().hidden()
                .table().fillByProperty(DemoLeaveMeta.DEFAULT_PROCESS,ProcessInstanceMeta.APPROVAL_STATUS_NAME).useThemeBadgeStyle();


        view.field("currNodes").basic().label("待审节点")
                .search().hidden().form().hidden()
                .table().fillByProperty(DemoLeaveMeta.DEFAULT_PROCESS, ProcessInstanceMeta.TODO_TASKS,TaskMeta.NODE_NAME).useThemeBadgeStyle();

        view.field("drafterName").basic().label("起草人")
                .search().hidden().form().hidden()
                .table().fillByProperty(DemoLeaveMeta.DEFAULT_PROCESS, ProcessInstanceMeta.DRAFTER_NAME).useThemeBadgeStyle();
    }



    @Override
    public void configList(ViewOptions view, ListOptions list) {
//        ActionConfig action = null;
//        action = list.operationColumn().addActionButton("流程图","showBpmnDiagrams");
//        //action.setIconHtml("<li class='mdi mdi-set mdi-arrow-decision-outline'></li>");
//        action = list.operationColumn().addActionButton("发起人","showInitiators");
//        //action.setIconHtml("<li class='fa fa-user-secret' style='font-size:14px'></li>");
//
//        list.columnLayout(BPM_PROCESS_DEFINITION.NAME,BPM_PROCESS_DEFINITION.VALID,BPM_PROCESS_DEFINITION.NOTES,BPM_PROCESS_DEFINITION.CREATE_TIME,BPM_PROCESS_DEFINITION.UPDATE_TIME,"lastUpdateUserName");
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
