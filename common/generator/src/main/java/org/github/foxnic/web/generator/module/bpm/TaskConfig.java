package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import org.github.foxnic.web.domain.bpm.meta.TaskMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.ProcessDefinitionServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

public class TaskConfig extends BaseCodeConfig<BPM_TASK> {

    public TaskConfig() {
        super(PREFIX_BPM, BPM_TASK.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(BPM_TASK.STATUS, TaskStatus.class);
        poType.addSimpleProperty(ProcessDefinition.class,"processDefinition","流程类型","流程类型");
        poType.addSimpleProperty(ProcessInstance.class,"processInstance","流程实例","流程实例");
        poType.addListProperty(TaskApproval.class,"approvals","审批动作清单","审批动作清单");
        poType.addListProperty(TaskAssignee.class,"assignees","审批人清单","审批人清单");

    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
//        search.inputLayout(new Object[]{
//                TaskMeta.PROCESS_DEFINITION,"processTitle",TaskMeta.ASSIGNEE_ID
//        });
    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(80);

        view.field(TaskMeta.PROCESS_DEFINITION).basic().label("流程类型")
                .search().on(BPM_TASK.PROCESS_DEFINITION_ID)
                .form().selectBox().queryApi(ProcessDefinitionServiceProxy.QUERY_PAGED_LIST).paging(true).toolbar(false).filter(true).valueField(BPM_PROCESS_DEFINITION.ID).textField(BPM_PROCESS_DEFINITION.NAME);

        view.field("processName").basic().label("流程类型").table().fillBy(TaskMeta.PROCESS_DEFINITION, ProcessDefinitionMeta.NAME);

        view.field("processTitle").basic().label("流程标题").table().fillBy(TaskMeta.PROCESS_INSTANCE, ProcessInstanceMeta.TITLE)
                .search().fuzzySearch().on(FoxnicWeb.BPM_PROCESS_INSTANCE.TITLE);

        view.field(TaskMeta.NODE_NAME).basic().label("审批节点");

//        view.field(TaskMeta.ASSIGNEE_ID).basic().label("待审人")
//                .form().selectBox().queryApi(UserServiceProxy.QUERY_PAGED_LIST).paging(true).toolbar(false).valueField("id").textField("realName");;

//        view.field("assigneeName").basic().label("待审人").table().fillBy(TaskMeta.ASSIGNEE_USER, UserMeta.REAL_NAME);


//        view.field(BPM_FORM_DEFINITION.DRAFT_PAGE_URL).search().hidden().form().textInput();
//        view.field(BPM_FORM_DEFINITION.APPROVAL_PAGE_URL).search().hidden().form().textInput();
//        view.field(BPM_FORM_DEFINITION.VALID).search().hidden().form().logicField().on("有效",1).off("无效",0).defaultValue(true);
//        view.field(BPM_FORM_DEFINITION.NAME).search().fuzzySearch();
//        view.field(BPM_FORM_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
//        view.field(BPM_FORM_DEFINITION.FORM_TYPE).search().hidden().form().radioBox().enumType(FormType.class).defaultValue(FormType.outer);

    }





    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableBatchDelete().disableSingleDelete().disableModify().disableCreateNew().disableFormView();

//        ActionConfig action = null;
        list.operationColumn().addActionButton("审批","showProcessForm");
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
