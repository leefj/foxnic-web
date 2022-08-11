package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.config.ActionConfig;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.bpm.RejectOption;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.meta.FormDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.FormDefinitionServiceProxy;

public class ProcessDefinitionConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION> {

    public ProcessDefinitionConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(User.class,"lastUpdateUser","最后修改人","最后修改人");
        poType.addSimpleProperty(ProcessDefinitionFile.class,"definitionFile","流程模型定义","流程模型文件");
        poType.addSimpleProperty(FormDefinition.class,"formDefinition","表单定义","表单定义");
        poType.shadow(BPM_PROCESS_DEFINITION.REJECT_OPTION, RejectOption.class);


        voType.addSimpleProperty(String.class,"formDefinitionCode","表单定义代码","表单定义代码");

    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_PROCESS_DEFINITION.CAMUNDA_DEFINITION_ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION.CAMUNDA_DEFINITION_KEY).basic().hidden();

        view.field(BPM_PROCESS_DEFINITION.ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION.CODE).basic().label("代码").search().fuzzySearch()
                .form().validate().required();
        view.field(BPM_PROCESS_DEFINITION.NAME).search().fuzzySearch().form().validate().required();
        view.field(BPM_PROCESS_DEFINITION.VALID).form().logicField().on("有效",1).off("无效",0);
        view.field(BPM_PROCESS_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
        view.field("lastUpdateUserName").basic().label("最后修改").table().fillBy(ProcessDefinitionMeta.LAST_UPDATE_USER, UserMeta.REAL_NAME)
                .form().hidden()
                .search().hidden();

        view.field(BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID).basic().label("表单")
                .table().fillBy(ProcessDefinitionMeta.FORM_DEFINITION, FormDefinitionMeta.NAME)
                .form().validate().required()
                .form().selectBox().queryApi(FormDefinitionServiceProxy.QUERY_PAGED_LIST+"?isBindProcess=0").paging(true).filter(true).muliti(false,false)
                .textField(BPM_FORM_DEFINITION.NAME).valueField(BPM_FORM_DEFINITION.ID).fillWith(ProcessDefinitionMeta.FORM_DEFINITION);


        view.field(BPM_PROCESS_DEFINITION.ASSIGNEE_TYPE_RANGE).basic().label("审批人范围")
                .form().validate().required()
                .form().checkBox().enumType(UnifiedUserType.class)
                .search().hidden().table().hidden();
        ;

        view.field(BPM_PROCESS_DEFINITION.REJECT_OPTION).basic().label("驳回选项")
                .form().validate().required()
                .form().radioBox().enumType(RejectOption.class)
                .search().hidden().table().hidden();
        ;

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

        view.formWindow().width("650px");

        form.columnLayout(new Object[]{
                BPM_PROCESS_DEFINITION.CODE,
                BPM_PROCESS_DEFINITION.NAME,
                BPM_PROCESS_DEFINITION.VALID,
                BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID,
                BPM_PROCESS_DEFINITION.ASSIGNEE_TYPE_RANGE,
                BPM_PROCESS_DEFINITION.REJECT_OPTION,
                BPM_PROCESS_DEFINITION.NOTES
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        ActionConfig action = null;
        action = list.operationColumn().addActionButton("模型","showBpmnDiagrams");
        //action.setIconHtml("<li class='mdi mdi-set mdi-arrow-decision-outline'></li>");
        action = list.operationColumn().addActionButton("发起人","showInitiators");
        //action.setIconHtml("<li class='fa fa-user-secret' style='font-size:14px'></li>");

        list.columnLayout(BPM_PROCESS_DEFINITION.NAME,BPM_PROCESS_DEFINITION.VALID,BPM_PROCESS_DEFINITION.NOTES,BPM_PROCESS_DEFINITION.CREATE_TIME,BPM_PROCESS_DEFINITION.UPDATE_TIME,"lastUpdateUserName");

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
