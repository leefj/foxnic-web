package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.query.MatchType;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import org.github.foxnic.web.constants.enums.bpm.AppovalReault;
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
        // 将属性映射为枚举
        poType.shadow(BPM_PROCESS_INSTANCE.APPROVAL_STATUS,ApprovalStatus.class);
        poType.shadow(BPM_PROCESS_INSTANCE.DRAFTER_TYPE,UnifiedUserType.class);
        poType.shadow(BPM_PROCESS_INSTANCE.PRIORITY,PriorityLevel.class);
        poType.addSimpleProperty(ProcessDefinitionFile.class,"processDefinitionFile","流程定义文件","流程定义文件");

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

        //
        pojo=context.createPojo("TaskQueryVO");
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
        search.inputLayout(new Object[]{
                BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID,
                BPM_PROCESS_INSTANCE.TITLE,
                BPM_PROCESS_INSTANCE.APPROVAL_STATUS,
                BPM_PROCESS_INSTANCE.COMMIT_TIME,
        },new Object[]{
                BPM_PROCESS_INSTANCE.DRAFTER_TYPE,
                ProcessInstanceMeta.DRAFTER_NAME,
                ProcessInstanceMeta.DRAFTER_USER
        });
    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_PROCESS_INSTANCE.ID).basic().hidden();
        view.field(BPM_PROCESS_INSTANCE.TITLE).search().fuzzySearch();
        view.field(BPM_PROCESS_INSTANCE.COMMENT).search().label("审批意见").hidden();
        view.field(BPM_PROCESS_INSTANCE.PRIORITY).basic().label("紧急程度").form().radioBox().enumType(PriorityLevel.class).defaultValue(PriorityLevel.normal);
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_TYPE).basic().label("发起人身份类型").form().radioBox().enumType(UnifiedUserType.class).defaultValue(UnifiedUserType.user);
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_ID).basic().label("发起人身份").form().selectBox().queryApi(BpmIdentityServiceProxy.GET_IDENTITIES)
                .valueField("id").textField("nameWithCode")
                .fillWith(ProcessInstanceMeta.DRAFTER)
                .table().fillBy(ProcessInstanceMeta.DRAFTER,"nameWithCode")
                .search().hidden();

        view.field(BPM_PROCESS_INSTANCE.DRAFTER_USER_ID).basic().hidden();

        view.field(ProcessInstanceMeta.DRAFTER_USER).basic().label("发起人")
                .form().hidden().search().on(FoxnicWeb.SYS_USER.REAL_NAME).fuzzySearch()
                .table().fillBy(ProcessInstanceMeta.DRAFTER_USER,UserMeta.REAL_NAME);

        view.field(ProcessInstanceMeta.DRAFTER_NAME).basic().label("发起人身份").search().fuzzySearch();

        view.field(BPM_PROCESS_INSTANCE.COMMIT_TIME).search().range().matchType(MatchType.auto);

        view.field(BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID)
                .basic().label("表单类型")
                .search().hidden()
                .table().fillBy(ProcessInstanceMeta.FORM_DEFINITION, FormDefinitionMeta.NAME)
                .form().hidden();

        view.field(BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.CAMUNDA_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.APPROVAL_STATUS).form().selectBox().enumType(ApprovalStatus.class)
                .form().hidden();

        view.field(BPM_PROCESS_INSTANCE.PROCESS_DEFINITION_ID).basic().label("流程类型").form().selectBox().queryApi(ProcessDefinitionServiceProxy.QUERY_PAGED_LIST).paging(true).muliti(false).toolbar(false).filter(true)
                .textField(FoxnicWeb.BPM_PROCESS_DEFINITION.NAME).valueField(FoxnicWeb.BPM_PROCESS_DEFINITION.ID)
                .fillWith(ProcessInstanceMeta.PROCESS_DEFINITION)
                .table().fillBy(ProcessInstanceMeta.PROCESS_DEFINITION,ProcessDefinitionMeta.NAME);







//        view.field(BPM_PROCESS_DEFINITION.VALID).form().logicField().on("有效",1).off("无效",0);
//        view.field(BPM_PROCESS_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
//        view.field("lastUpdateUserName").basic().label("最后修改").table().fillBy(ProcessDefinitionMeta.LAST_UPDATE_USER, UserMeta.NAME)
//                .form().hidden()
//                .search().hidden();

        //view.field(BPM_PROCESS_DEFINITION.UPDATE_TIME).table().displayWhenDBTreaty(true);
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

        list.addToolButton("提交","submitProcess","");
        list.addToolButton("撤回","revokeProcess","");
        list.addToolButton("作废","abandonProcess","");
        list.addToolButton("同意","agreeNode","");
        list.addToolButton("驳回","rejectNode","");

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
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
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

}
