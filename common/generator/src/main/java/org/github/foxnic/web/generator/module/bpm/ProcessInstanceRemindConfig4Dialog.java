package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE_REMIND;
import org.github.foxnic.web.constants.enums.bpm.RemindStatus;
import org.github.foxnic.web.constants.enums.bpm.RemindTermUnit;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindReceiverMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.ProcessDefinitionNodeServiceProxy;

public class ProcessInstanceRemindConfig4Dialog extends BaseCodeConfig<BPM_PROCESS_INSTANCE_REMIND> {

    public ProcessInstanceRemindConfig4Dialog() {
        super(PREFIX_BPM, BPM_PROCESS_INSTANCE_REMIND.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        voType.addSimpleProperty(String.class,"receiverInfo","接收人参数","接收人参数");
        poType.addListProperty(ProcessInstanceRemindReceiver.class,"receivers","接收人清单","接收人清单");
        poType.addSimpleProperty(ProcessDefinitionNode.class,"targetNode","监控的目标节点","监控的目标节点");
        poType.shadow(BPM_PROCESS_INSTANCE_REMIND.STATUS, RemindStatus.class);
        poType.shadow(BPM_PROCESS_INSTANCE_REMIND.REMIND_TERM_UNIT, RemindTermUnit.class);
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

//        search.disable();
        search.inputLayout(new Object[]{BPM_PROCESS_INSTANCE_REMIND.TARGET_NODE_ID});
    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(70);

        view.field(BPM_PROCESS_INSTANCE_REMIND.ID).basic().hidden();

        view.field(BPM_PROCESS_INSTANCE_REMIND.PROCESS_INSTANCE_ID).basic().hidden();

        view.field(BPM_PROCESS_INSTANCE_REMIND.ID).basic().hidden();

        // 暂时仅支持员工
        view.field("receiverInfo").basic().label("提醒对象")
                .table().fillBy(ProcessInstanceRemindMeta.RECEIVERS,ProcessInstanceRemindReceiverMeta.NAME)
                .form().button().chooseEmployee(false).form().validate().required();

        view.field(BPM_PROCESS_INSTANCE_REMIND.CONTENT).basic().label("提醒内容").form().validate().required();

        view.field(BPM_PROCESS_INSTANCE_REMIND.REMIND_TERM_UNIT).basic().label("时长单位")
                .form().radioBox().enumType(RemindTermUnit.class).form().validate().required();

        view.field(BPM_PROCESS_INSTANCE_REMIND.REMIND_TERM).basic().label("等待时长").form().validate().required();

        view.field(BPM_PROCESS_INSTANCE_REMIND.REMIND_TIME).basic().hidden();

        view.field(BPM_PROCESS_INSTANCE_REMIND.STATUS).basic().hidden()
                .table().disable();

        view.field(BPM_PROCESS_INSTANCE_REMIND.SOURCE_NODE_ID).basic().hidden();

        view.field(BPM_PROCESS_INSTANCE_REMIND.TARGET_NODE_ID).basic().label("监控节点")
                .form().selectBox().queryApi(ProcessDefinitionNodeServiceProxy.QUERY_LIST_BY_PROCESS_INSTANCE_ID)
                .valueField("id").textField("nodeName").muliti(false,false).fillWith(ProcessInstanceRemindMeta.TARGET_NODE)
                .search().inputWidth(200).triggerOnSelect(true)
                .form().validate().required();
    }



    @Override
    public void configList(ViewOptions view, ListOptions list) {
//        list.disableMargin();
//        ActionConfig actio1n = null;
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
                .setBpmEventAdaptor(WriteMode.COVER_EXISTS_FILE) //设置BPM事件回调类
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

}
