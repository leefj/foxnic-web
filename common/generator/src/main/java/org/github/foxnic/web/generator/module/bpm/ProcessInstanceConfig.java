package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.query.MatchType;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.config.ActionConfig;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import org.github.foxnic.web.constants.enums.bpm.ApprovalCatalog;
import org.github.foxnic.web.constants.enums.bpm.PriorityLevel;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.bpm.meta.FormDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.BpmIdentityServiceProxy;
import org.github.foxnic.web.proxy.bpm.ProcessDefinitionServiceProxy;
import org.github.foxnic.web.proxy.bpm.ProcessInstanceServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

public class ProcessInstanceConfig extends BaseCodeConfig<BPM_PROCESS_INSTANCE> {

    public ProcessInstanceConfig() {
        super(PREFIX_BPM, BPM_PROCESS_INSTANCE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(ProcessDefinition.class,"processDefinition","流程定义","流程定义");
        poType.addSimpleProperty(FormDefinition.class,"formDefinition","表单定义","表单定义");
        poType.addSimpleProperty(FormInstance.class,"formInstance","表单实例","表单实例");
        poType.addSimpleProperty(Assignee.class,"drafter","起草人身份","起草人身份");
        poType.addSimpleProperty(String.class,"drafterName","起草人名称","起草人名称");
        poType.addSimpleProperty(User.class,"drafterUser","起草人账户","起草人账户");
        poType.addListProperty(Task.class,"tasks","流程任务清单","流程任务清单");
        poType.addListProperty(Task.class,"todoTasks","待办的流程任务清单","待办的流程任务清单");
        poType.addListProperty(Task.class,"userTasks","可处理的任务清单","当前登录账户可以处理的任务清单");
        poType.addListProperty(FormInstanceBill.class,"bills","业务单据","关联的业务单据清单");
        poType.addListProperty(String.class,"billIds","业务单据ID清单","业务单据ID清单");
        poType.addListProperty(ProcessError.class,"errors","流程异常清单","流程异常清单");
        poType.addListProperty(TaskRead.class,"readers","已读清单","已读人员清单");
        poType.addSimpleProperty(String.class,"approvalStatusName","审批状态","审批状态");
        // 将属性映射为枚举
        poType.shadow(BPM_PROCESS_INSTANCE.APPROVAL_STATUS,ApprovalStatus.class);
        poType.shadow(BPM_PROCESS_INSTANCE.DRAFTER_TYPE,UnifiedUserType.class);
        poType.shadow(BPM_PROCESS_INSTANCE.PRIORITY,PriorityLevel.class);
        //
        poType.addSimpleProperty(ProcessDefinitionFile.class,"processDefinitionFile","流程定义文件","流程定义文件");
        poType.addListProperty(TaskApproval.class,"taskApprovals","审批动作清单","已完成的审批动作清单");
        //
        voType.addListProperty(String.class,"approvedUserIds","已审批人ID清单","查询已审批人ID清单");
        voType.addListProperty(String.class,"approvingUserIds","待审批人ID清单","查询待审批人ID清单");
        voType.addSimpleProperty(Boolean.class,"mine","是否我的流程","是否我的流程");
        voType.addSimpleProperty(String.class,"approvalCatalog","流程审批分类","流程审批分类");
        voType.shadow("approvalCatalog", ApprovalCatalog.class);
        //
        PojoClassFile pojo=context.createPojo("ProcessStartVO");
        pojo.setSuperType(null);
        pojo.setDoc("流程启动参数");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","流程发起前先要暂存流程实例，返回流程实例ID");
        pojo.addSimpleProperty(String.class,"drafterUserId","发起人账户ID","如果不指定则默认为当前账户ID");
        pojo.addSimpleProperty(String.class,"drafterType","发起人身份类型","发起人身份类型，UnifiedUserType.code()，如果未指定，则使用暂存值");
        poType.shadow("drafterType",UnifiedUserType.class);
        pojo.addSimpleProperty(String.class,"drafterId","发起人身份ID","发起人身份ID，如果未指定，则使用暂存值");
        pojo.addMapProperty(String.class,Object.class,"variables","流程参数","流程参数");



        pojo=context.createPojo("ProcessAbandonVO");
        pojo.setSuperType(null);
        pojo.setDoc("流程废弃参数");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","流程实例ID");
        pojo.addSimpleProperty(String.class,"reason","废弃原因","废弃原因");
        pojo.addSimpleProperty(Boolean.class,"force","是否强制删除","是否强制删除");
        pojo.addMapProperty(String.class,Object.class,"variables","流程参数","流程参数");


        pojo=context.createPojo("ProcessFetchBackVO");
        pojo.setSuperType(null);
        pojo.setDoc("流程撤回参数");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","流程实例ID");
        pojo.addSimpleProperty(String.class,"reason","撤回原因","撤回原因");
        pojo.addMapProperty(String.class,Object.class,"variables","流程参数","流程参数");

        pojo=context.createPojo("ProcessJumpVO");
        pojo.setSuperType(null);
        pojo.setDoc("流程跳转参数");
        pojo.addSimpleProperty(String.class,"processInstanceId","流程实例ID","流程实例ID");
        pojo.addSimpleProperty(String.class,"jumpToNodeId","目标节点ID","目标节点ID,CamundaNodeId");
        pojo.addSimpleProperty(String.class,"reason","跳转原因","跳转原因");
        pojo.addMapProperty(String.class,Object.class,"variables","流程参数","流程参数");


    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{
                BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID,
                BPM_PROCESS_INSTANCE.TITLE,
                BPM_PROCESS_INSTANCE.PRIORITY,
                BPM_PROCESS_INSTANCE.COMMIT_TIME,
        },new Object[]{
                BPM_PROCESS_INSTANCE.APPROVAL_STATUS,
                ProcessInstanceMeta.DRAFTER_USER,
                "APPROVED_USER_IDS",
                "APPROVING_USER_IDS"
        });

        search.rowsDisplay(4);
        //设置各个列的搜索输入框的标签宽度
        search.labelWidth(1,80);
        search.labelWidth(2,80);
        search.labelWidth(3,80);
        search.labelWidth(4,80);
    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(120);

        view.field(BPM_PROCESS_INSTANCE.ID).basic().hidden();
        view.field(BPM_PROCESS_INSTANCE.TITLE).search().fuzzySearch().form().validate().required();
        view.field(BPM_PROCESS_INSTANCE.COMMENT).search().label("审批意见").hidden();
        view.field(BPM_PROCESS_INSTANCE.PRIORITY).basic().label("紧急程度")
                .form().radioBox().enumType(PriorityLevel.class).defaultValue(PriorityLevel.normal)
                .form().validate().required()
                .search().triggerOnSelect(true);
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_TYPE).basic().label("发起人身份类型")
                .form().radioBox().enumType(UnifiedUserType.class).defaultValue(UnifiedUserType.user)
                .form().validate().required();
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_ID).basic().label("发起人身份")
                .form().validate().required()
                .form().selectBox().queryApi(BpmIdentityServiceProxy.GET_IDENTITIES)
                .valueField("id").textField("nameWithCode")
                .fillWith(ProcessInstanceMeta.DRAFTER)
                .table().fillBy(ProcessInstanceMeta.DRAFTER,"nameWithCode")
                .search().hidden();

        view.field(BPM_PROCESS_INSTANCE.DRAFTER_USER_ID).basic().hidden();

        view.field(ProcessInstanceMeta.DRAFTER_USER).basic().label("发起人")
                .form().selectBox().queryApi(UserServiceProxy.QUERY_PAGED_LIST).textField("realName").valueField("id").toolbar(false).filter(true)
                .search().on(BPM_PROCESS_INSTANCE.DRAFTER_USER_ID).triggerOnSelect(true)
                .table().fillBy(ProcessInstanceMeta.DRAFTER_USER,UserMeta.REAL_NAME);

        view.field("APPROVED_USER_IDS").basic().label("已审批人")
                .form().selectBox().queryApi(UserServiceProxy.QUERY_PAGED_LIST).textField("realName").valueField("id").toolbar(false).filter(true)
                .search().on(FoxnicWeb.BPM_TASK_APPROVAL.APPROVAL_USER_ID).triggerOnSelect(true)
                .table().fillBy(ProcessInstanceMeta.TASK_APPROVALS).disable();

        view.field("APPROVING_USER_IDS").basic().label("待审批人")
                .form().selectBox().queryApi(UserServiceProxy.QUERY_PAGED_LIST).textField("realName").valueField("id").toolbar(false).filter(true)
                .search().triggerOnSelect(true)
                .table().disable();

        view.field(ProcessInstanceMeta.DRAFTER_NAME).basic().label("发起人身份").search().fuzzySearch();

        view.field(BPM_PROCESS_INSTANCE.COMMIT_TIME).search().range().matchType(MatchType.auto).triggerOnSelect(true);

        view.field(BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID)
                .basic().label("表单类型")
                .search().hidden()
                .table().fillBy(ProcessInstanceMeta.FORM_DEFINITION, FormDefinitionMeta.NAME)
                .form().hidden();

        view.field(BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.CAMUNDA_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.APPROVAL_STATUS).form().selectBox().enumType(ApprovalStatus.class)
                .form().hidden()
                .search().triggerOnSelect(true);

        view.field(BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID).basic().label("流程类型")
                .form().validate().required()
                .form().selectBox().queryApi(ProcessDefinitionServiceProxy.QUERY_PAGED_LIST).paging(true).size(1022).muliti(false).toolbar(false).filter(true)
                .textField(FoxnicWeb.BPM_PROCESS_DEFINITION.NAME).valueField(FoxnicWeb.BPM_PROCESS_DEFINITION.ID)
                .fillWith(ProcessInstanceMeta.PROCESS_DEFINITION)
                .table().fillBy(ProcessInstanceMeta.PROCESS_DEFINITION,ProcessDefinitionMeta.NAME)
                .search().triggerOnSelect(true);







//        view.field(BPM_PROCESS_DEFINITION.VALID).form().logicField().on("有效",1).off("无效",0);
//        view.field(BPM_PROCESS_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
//        view.field("lastUpdateUserName").basic().label("最后修改").table().fillBy(ProcessDefinitionMeta.LAST_UPDATE_USER, UserMeta.NAME)
//                .form().hidden()
//                .search().hidden();

        //view.field(BPM_PROCESS_DEFINITION.UPDATE_TIME).table().displayWhenDBTreaty(true);
    }



    @Override
    public void configList(ViewOptions view, ListOptions list) {

        list.pageTitle("流程中心");

        ActionConfig action = null;
        action = list.operationColumn().addActionButton("作废","abandonProcess");
//        action.setIconHtml("<li class='mdi mdi-set mdi-arrow-decision-outline'></li>");
        list.configCreateNewButton("发起流程","showApprovalForm","");
        list.operationColumn().addActionButton("打开","showApprovalForm");
//        action.setIconHtml("<li class='fa fa-user-secret' style='font-size:14px'></li>");

//        list.columnLayout(BPM_PROCESS_DEFINITION.NAME,BPM_PROCESS_DEFINITION.VALID,BPM_PROCESS_DEFINITION.NOTES,BPM_PROCESS_DEFINITION.CREATE_TIME,BPM_PROCESS_DEFINITION.UPDATE_TIME,"lastUpdateUserName");

//        list.addToolButton("提交","submitProcess","");
//        list.addToolButton("撤回","revokeProcess","");
//        action=list.addToolButton("作废","abandonProcessBatch","");
//        action.setIconHtml("<i class='fa fa-close' style='font-size:14px'></i>");
//        action.setIconHtml("<i class='layui-icon' >&#xe617;</i>");
//        action.setIconHtml("<i class='mdi mdi-delete-sweep'></i>");

//        list.addToolButton("同意","agreeNode","");
//        list.addToolButton("驳回","rejectNode","");
        list.disableModify().disableFormView().disableBatchDelete().disableSingleDelete();
//        list.configBatchDeleteButton("作废",null,null);
//        list.operationColumn().configDeleteButton("作废",null,null);

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

        view.formWindow().bottomSpace(200);

        view.formWindow().width("90%");
        form.savingURL(ProcessInstanceServiceProxy.TEMPORARY_SAVE);
        //
        form.addGroup("basic","流程信息", new Object[] {
                BPM_PROCESS_INSTANCE.TITLE,BPM_PROCESS_INSTANCE.PRIORITY,BPM_PROCESS_INSTANCE.DRAFTER_TYPE,BPM_PROCESS_INSTANCE.DRAFTER_ID,
                BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID
        });

        //嵌入页面，页面在loadForm 函数中载入
        form.addPage("form","审批内容","loadForm");

        form.addGroup("comment","审批意见", new Object[] {
                BPM_PROCESS_INSTANCE.COMMENT
        });

    }



    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

}
