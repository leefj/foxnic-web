package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.config.ActionConfig;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.bpm.DrafterRangeType;
import org.github.foxnic.web.constants.enums.bpm.RejectOption;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Catalog;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.meta.CatalogMeta;
import org.github.foxnic.web.domain.bpm.meta.FormDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.bpm.FormDefinitionServiceProxy;

public class ProcessDefinitionConfig extends BaseCodeConfig<BPM_PROCESS_DEFINITION> {

    public ProcessDefinitionConfig() {
        super(PREFIX_BPM, BPM_PROCESS_DEFINITION.$TABLE, "bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(User.class, "lastUpdateUser", "最后修改人", "最后修改人");
        poType.addSimpleProperty(ProcessDefinitionFile.class, "definitionFile", "流程模型定义", "流程模型文件");
        poType.addSimpleProperty(FormDefinition.class, "formDefinition", "表单定义", "表单定义");
        poType.shadow(BPM_PROCESS_DEFINITION.REJECT_OPTION, RejectOption.class);
        poType.addSimpleProperty(Catalog.class, "catalog", "分类对象", "分类对象");

        poType.shadow(BPM_PROCESS_DEFINITION.DRAFTER_RANGE, DrafterRangeType.class);

        voType.addSimpleProperty(String.class, "formDefinitionCode", "表单定义代码", "表单定义代码");

    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{
                BPM_PROCESS_DEFINITION.CATALOG_ID,
                BPM_PROCESS_DEFINITION.CODE,
                BPM_PROCESS_DEFINITION.NAME,
                BPM_PROCESS_DEFINITION.VALID,
                BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID
        });
    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(80);

        view.field(BPM_PROCESS_DEFINITION.CAMUNDA_DEFINITION_ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION.CAMUNDA_DEFINITION_KEY).basic().hidden();

        view.field(BPM_PROCESS_DEFINITION.SORT).search().hidden();

        view.field(BPM_PROCESS_DEFINITION.ICON_FILE_PC).search().hidden().form().upload().acceptSingleImage();
        view.field(BPM_PROCESS_DEFINITION.ICON_FILE_MOBILE).search().hidden().form().upload().acceptSingleImage();

        view.field(BPM_PROCESS_DEFINITION.CATALOG_ID).basic().label("分类")
                .search().triggerOnSelect(true)
                .table().fillBy(ProcessDefinitionMeta.CATALOG, CatalogMeta.NAME)
                .form().inputWidth(150)
                .form().validate().required()
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_LIST).paging(false).filter(false).muliti(false, false)
                .textField(BPM_CATALOG.NAME).valueField(BPM_CATALOG.ID).fillWith(ProcessDefinitionMeta.CATALOG);


        view.field(BPM_PROCESS_DEFINITION.ICON_FILE_PC).search().hidden().form().upload().acceptSingleImage();
        view.field(BPM_PROCESS_DEFINITION.ICON_FILE_MOBILE).search().hidden().form().upload().acceptSingleImage();


        view.field(BPM_PROCESS_DEFINITION.ID).basic().hidden();
        view.field(BPM_PROCESS_DEFINITION.CODE).basic().label("代码").search().fuzzySearch()
                .form().validate().required();

        view.field(BPM_PROCESS_DEFINITION.NAME).search().fuzzySearch()
                .form().inlines(BPM_PROCESS_DEFINITION.CATALOG_ID,BPM_PROCESS_DEFINITION.VALID).inlineDelta(20)
                .form().validate().required();

        view.field(BPM_PROCESS_DEFINITION.VALID).form().label("有效").logicField().on("有效", 1).off("无效", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.NOTES).search().fuzzySearch().form().textArea();
        view.field("lastUpdateUserName").basic().label("最后修改").table().fillBy(ProcessDefinitionMeta.LAST_UPDATE_USER, UserMeta.REAL_NAME)
                .form().hidden()
                .search().hidden();

        view.field(BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID).basic().label("表单")
                .table().fillBy(ProcessDefinitionMeta.FORM_DEFINITION, FormDefinitionMeta.NAME)
                .search().inputWidth(200).triggerOnSelect(true)
                .form().validate().required()
                .form().selectBox().queryApi(FormDefinitionServiceProxy.QUERY_PAGED_LIST + "?isBindProcess=0").queryApi4Search(FormDefinitionServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).muliti(false, false)
                .textField(BPM_FORM_DEFINITION.NAME).valueField(BPM_FORM_DEFINITION.ID).fillWith(ProcessDefinitionMeta.FORM_DEFINITION);

        view.field(BPM_PROCESS_DEFINITION.DRAFTER_RANGE).basic().label("起草人")
                .form().validate().required()
                .form().checkBox().enumType(DrafterRangeType.class)
                .search().hidden().table().hidden();

        view.field(BPM_PROCESS_DEFINITION.ASSIGNEE_TYPE_RANGE).basic().label("审批人")
                .form().validate().required()
                .form().checkBox().enumType(UnifiedUserType.class)
                .search().hidden().table().hidden();
        ;

        view.field(BPM_PROCESS_DEFINITION.REJECT_OPTION).basic().label("驳回选项")
                .form().validate().required()
                .form().radioBox().enumType(RejectOption.class)
                .search().hidden().table().hidden();
        ;

        view.field(BPM_CATALOG.SORT).search().hidden().form().inputWidth(80);


        view.field(BPM_PROCESS_DEFINITION.ALLOW_FETCH_BACK).form().label("撤回流程").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly().table().disable();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_ABANDON).form().label("废弃流程").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly().table().disable();



        view.field(BPM_PROCESS_DEFINITION.ALLOW_AGREE_WITH_CONDITION).form().label("有条件同意").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_REJECT).form().label("审批驳回").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_SKIP).form().label("审批跳过").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_DRAFTING_COMMENT).form().label("起草意见").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_APPROVE_COMMENT).form().label("审批意见").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_DRAFTING_ATTACHMENT).form().label("起草附件").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

        view.field(BPM_PROCESS_DEFINITION.ALLOW_APPROVE_ATTACHMENT).form().label("审批附件").logicField().on("允许", 1).off("禁止", 0).search().triggerOnSelect(true)
                .table().logicFieldReadonly();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

        view.formWindow().width("1200px");

        form.addGroup("basic", "基本信息",

                new Object[]{BPM_PROCESS_DEFINITION.CODE,
                        BPM_PROCESS_DEFINITION.NAME,

                        BPM_PROCESS_DEFINITION.VALID,
                        BPM_PROCESS_DEFINITION.FORM_DEFINITION_ID,


                        BPM_PROCESS_DEFINITION.SORT,
                        //
                        BPM_PROCESS_DEFINITION.CATALOG_ID
                }

        );

        form.addGroup("icon", "",
                new Object[]{BPM_PROCESS_DEFINITION.ICON_FILE_PC},
                new Object[]{BPM_PROCESS_DEFINITION.ICON_FILE_MOBILE}
        );



        form.addGroup("member", "人员设置",
                new Object[]{BPM_PROCESS_DEFINITION.DRAFTER_RANGE},
                new Object[]{BPM_PROCESS_DEFINITION.ASSIGNEE_TYPE_RANGE}
        );


        form.addGroup("process", "流程控制",
                new Object[]{
                        BPM_PROCESS_DEFINITION.REJECT_OPTION,
                        BPM_PROCESS_DEFINITION.ALLOW_FETCH_BACK
                }, new Object[]{BPM_PROCESS_DEFINITION.ALLOW_ABANDON}
        );

        form.addGroup("approval", "审批控制",
                new Object[]{ BPM_PROCESS_DEFINITION.ALLOW_AGREE_WITH_CONDITION,BPM_PROCESS_DEFINITION.ALLOW_SKIP},
                new Object[]{BPM_PROCESS_DEFINITION.ALLOW_REJECT}
        );

        form.addGroup("content", "内容控制",
                new Object[]{ BPM_PROCESS_DEFINITION.ALLOW_DRAFTING_COMMENT,BPM_PROCESS_DEFINITION.ALLOW_DRAFTING_ATTACHMENT},
                new Object[]{BPM_PROCESS_DEFINITION.ALLOW_APPROVE_COMMENT,BPM_PROCESS_DEFINITION.ALLOW_APPROVE_ATTACHMENT}
        );



        form.addGroup("g10", "",

                new Object[]{
                        BPM_PROCESS_DEFINITION.NOTES
                }
        );


    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        ActionConfig action = null;
        action = list.operationColumn().addActionButton("模型", "showBpmnDiagrams");
        //action.setIconHtml("<li class='mdi mdi-set mdi-arrow-decision-outline'></li>");
        action = list.operationColumn().addActionButton("发起人", "showInitiators");
        //action.setIconHtml("<li class='fa fa-user-secret' style='font-size:14px'></li>");

        list.columnLayout(BPM_PROCESS_DEFINITION.NAME, BPM_PROCESS_DEFINITION.VALID, BPM_PROCESS_DEFINITION.NOTES, BPM_PROCESS_DEFINITION.CREATE_TIME, BPM_PROCESS_DEFINITION.UPDATE_TIME, "lastUpdateUserName");

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
