package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_FORM_DEFINITION;
import org.github.foxnic.web.constants.enums.bpm.FormType;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class FormDefinitionConfig extends BaseCodeConfig<BPM_FORM_DEFINITION> {

    public FormDefinitionConfig() {
        super(PREFIX_BPM, BPM_FORM_DEFINITION.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(User.class,"lastUpdateUser","最后修改人","最后修改人");
        voType.addSimpleProperty(Integer.class,"isBindProcess","是否已经绑定流程","查询条件，null:不控制;1绑定流程:0:未绑定流程");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(BPM_FORM_DEFINITION.ID).basic().hidden();
        view.field(BPM_FORM_DEFINITION.DRAFT_PAGE_URL)
                .search().hidden().form().textInput()
                .form().validate().required();
        view.field(BPM_FORM_DEFINITION.APPROVAL_PAGE_URL)
                .search().hidden().form().textInput()
                .form().validate().required();
        view.field(BPM_FORM_DEFINITION.VALID).basic().label("有效")
                .search().hidden().form().logicField().on("有效",1).off("无效",0).defaultValue(true);
        view.field(BPM_FORM_DEFINITION.NAME).search().fuzzySearch().form().validate().required();
        view.field(BPM_FORM_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
        view.field(BPM_FORM_DEFINITION.FORM_TYPE).search().hidden().form().radioBox().enumType(FormType.class).defaultValue(FormType.outer)
                .form().validate().required();

        view.field(BPM_FORM_DEFINITION.CALLBACK_CONTROLLER)
                .search().hidden().form().textInput()
                .form().validate().required();

        view.field(BPM_FORM_DEFINITION.MULITI_PROCESS).basic().label("多流程").form().logicField().on("是",1).off("否",0);
//        view.field(BPM_PROCESS_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
//        view.field("lastUpdateUserName").basic().label("最后修改").table().fillBy(ProcessDefinitionMeta.LAST_UPDATE_USER, UserMeta.NAME)
//                .form().hidden()
//                .search().hidden();

        //view.field(BPM_PROCESS_DEFINITION.UPDATE_TIME).table().displayWhenDBTreaty(true);
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        super.configForm(view, form, formWindow);
        view.formWindow().width("750px");
        form.columnLayout(new Object[] {
                BPM_FORM_DEFINITION.CODE,
                BPM_FORM_DEFINITION.NAME,
                BPM_FORM_DEFINITION.FORM_TYPE,
                BPM_FORM_DEFINITION.VALID,
                BPM_FORM_DEFINITION.MULITI_PROCESS,
                BPM_FORM_DEFINITION.DRAFT_PAGE_URL,
                BPM_FORM_DEFINITION.APPROVAL_PAGE_URL,
                BPM_FORM_DEFINITION.CALLBACK_CONTROLLER,
                BPM_FORM_DEFINITION.NOTES
        });
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
