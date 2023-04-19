package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE_REMIND_RECEIVER;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class ProcessInstanceRemindReceiverConfig extends BaseCodeConfig<BPM_PROCESS_INSTANCE_REMIND_RECEIVER> {

    public ProcessInstanceRemindReceiverConfig() {
        super(PREFIX_BPM, BPM_PROCESS_INSTANCE_REMIND_RECEIVER.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Employee.class,"employee","关联员工","关联员工");
        poType.shadow(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.RECEIVER_TYPE, UnifiedUserType.class);
        poType.addSimpleProperty(Assignee.class,"asignee","关联代理人","关联代理人");
        poType.addSimpleProperty(String.class,"name","名称","名称");
    }

    @Override
    public void configView(ViewOptions view, ListOptions list, FormOptions form) {

//        view.list().addJs("/list/demo/demo.js");
//        view.list().addCss("/list/demo/demo.css");
//
//        // 设置 Excel 导入导出
//        view.list().excel(false,true);
//
//        view.form().addJs("/form/demo/demo.js");
//        view.form().addCss("/form/demo/demo.css");
    }


    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

        search.disable();

    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(70);

//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.ID).basic().hidden();
//
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.PROCESS_INSTANCE_ID).basic().hidden();
//
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.ID).basic().hidden();
//
//        // 暂时仅支持员工
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.RECEIVER_ID).basic().label("提醒对象")
//                .form().button().chooseEmployee(false);
//
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.CONTENT).basic().label("提醒内容");
//
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.REMIND_DATE).basic().hidden();
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.VALID).basic().hidden();
//        view.field(BPM_PROCESS_INSTANCE_REMIND_RECEIVER.SOURCE_NODE_ID).basic().hidden();
    }



    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableMargin();
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
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setBpmEventAdaptor(WriteMode.IGNORE) //设置BPM事件回调类
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE) //列表HTML页
                .setExtendJsFile(WriteMode.IGNORE);
    }

}
