package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class TaskConfig extends BaseCodeConfig<BPM_TASK> {

    public TaskConfig() {
        super(PREFIX_BPM, BPM_TASK.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(BPM_TASK.STATUS, TaskStatus.class);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(80);

//        view.field(BPM_FORM_DEFINITION.ID).basic().hidden();
//        view.field(BPM_FORM_DEFINITION.DRAFT_PAGE_URL).search().hidden().form().textInput();
//        view.field(BPM_FORM_DEFINITION.APPROVAL_PAGE_URL).search().hidden().form().textInput();
//        view.field(BPM_FORM_DEFINITION.VALID).search().hidden().form().logicField().on("有效",1).off("无效",0).defaultValue(true);
//        view.field(BPM_FORM_DEFINITION.NAME).search().fuzzySearch();
//        view.field(BPM_FORM_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
//        view.field(BPM_FORM_DEFINITION.FORM_TYPE).search().hidden().form().radioBox().enumType(FormType.class).defaultValue(FormType.outer);

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
