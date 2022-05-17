package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION;
import org.github.foxnic.web.constants.enums.bpm.AppovalReault;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
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


        //
        PojoClassFile pojo=context.createPojo("TaskQueryVO");
        pojo.setSuperType(null);
        pojo.setDoc("任务查询对象");
        pojo.addSimpleProperty(String.class,"userId","账户ID","用于查询指定账户可处理的待办");
        pojo.addSimpleProperty(Boolean.class,"useUserIdInSession","是否使用会话账户","userId 当 uerseId 未指定时是否使用会话账户");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","用于查询指定账户可处理的待办");
        pojo.addSimpleProperty(String.class,"status","任务状态","任务状态");
        poType.shadow("status", TaskStatus.class);

        //
        pojo=context.createPojo("CamundaTaskQueryVO");
        pojo.setSuperType(null);
        pojo.setDoc("任务查询参数");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","流程实例ID");
        pojo.addSimpleProperty(String.class,"assigneeUserId","委托人、审批人账户ID","委托人、审批人账户");
        pojo.addSimpleProperty(Integer.class,"pageSize","分页大小","分页大小");
        pojo.addSimpleProperty(Integer.class,"pageIndex","页码","页码");

        pojo=context.createPojo("TaskProcessVO");
        pojo.setSuperType(null);
        pojo.setDoc("任务处理参数");
        pojo.addSimpleProperty(String.class,"taskId","流程实例ID","流程实例ID");
        pojo.addSimpleProperty(String.class,"assigneeUserId","审批人账户ID","审批人账户");
        pojo.addSimpleProperty(String.class,"result","审批结果","审批结果");
        pojo.shadow("result", AppovalReault.class);
        pojo.addSimpleProperty(String.class,"comment","审批意见","审批意见");
        pojo.addMapProperty(String.class,Object.class,"variables","流程参数","流程参数");
        pojo.addSimpleProperty(String.class,"tenantId","租户ID","租户ID");

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
        list.operationColumn().addActionButton("打开","showProcessForm");
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
