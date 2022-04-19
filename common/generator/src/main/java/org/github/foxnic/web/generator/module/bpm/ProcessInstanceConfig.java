package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.config.ActionConfig;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.BpmIdentityServiceProxy;

public class ProcessInstanceConfig extends BaseCodeConfig<BPM_PROCESS_INSTANCE> {

    public ProcessInstanceConfig() {
        super(PREFIX_BPM, BPM_PROCESS_INSTANCE.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(ProcessDefinition.class,"processDefinition","流程定义","流程定义");
        poType.addSimpleProperty(FormInstance.class,"formInstance","表单实例","表单实例");
        poType.addSimpleProperty(Appover.class,"drafter","起草人","起草人");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_PROCESS_INSTANCE.ID).basic().hidden();
        view.field(BPM_PROCESS_INSTANCE.TITLE).search().fuzzySearch();
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_TYPE).basic().label("发起人身份").form().radioBox().enumType(UnifiedUserType.class).defaultValue(UnifiedUserType.user);
        view.field(BPM_PROCESS_INSTANCE.DRAFTER_ID).basic().label("发起人").form().selectBox().queryApi(BpmIdentityServiceProxy.GET_IDENTITIES)
                .valueField("id").textField("name");
        view.field(BPM_PROCESS_INSTANCE.FORM_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.CAMUNDA_INSTANCE_ID).search().hidden();
        view.field(BPM_PROCESS_INSTANCE.APPROVAL_STATUS).form().selectBox().enumType(ApprovalStatus.class)
                .form().hidden();

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

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
        view.formWindow().width("90%");
        super.configForm(view, form);

        //
        form.columnLayout(new Object[] {BPM_PROCESS_INSTANCE.TITLE,BPM_PROCESS_INSTANCE.DRAFTER_TYPE,BPM_PROCESS_INSTANCE.DRAFTER_ID});

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
