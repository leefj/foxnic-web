package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_ORGANIZATION;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class HrmOrgnizationConfig extends BaseCodeConfig<HRM_ORGANIZATION> {

    public HrmOrgnizationConfig() {
        super(PREFIX_HRM, HRM_ORGANIZATION.$TABLE,"hrm_", 4);
    }


    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        voType.addSimpleProperty(Integer.class,"isLoadAllDescendants","是否加载所有子孙节点","1：是；0：否");
        voType.addSimpleProperty(String.class,"root","根节点id或code","根节点id");
        voType.addSimpleProperty(String.class,"targetType","呈现模式","呈现模式:pos,org,com,dept");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(70);

        view.field(HRM_ORGANIZATION.ID).basic().hidden();

        view.field(HRM_ORGANIZATION.FULL_NAME)
                .form().validate().required();


        view.field(HRM_ORGANIZATION.TYPE).basic().label("类型")
                .form().validate().required()
                .form().radioBox().dict(DictEnum.ORG_NODE_TYPE);

        view.field(HRM_ORGANIZATION.VALID)
                .form().validate().required()
                .form().logicField().on("有效",1).off("无效",0).defaultValue(true);

        view.field(HRM_ORGANIZATION.PARENT_ID).basic().hidden();
        view.field(HRM_ORGANIZATION.ID).basic().hidden();

        view.field(HRM_ORGANIZATION.HIERARCHY).basic().hidden();

        view.field(HRM_ORGANIZATION.COMPANY_ID).basic().hidden();

        view.field(HRM_ORGANIZATION.SORT).basic().hidden();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.columnLayout(new Object[]{
                HRM_ORGANIZATION.FULL_NAME,HRM_ORGANIZATION.SHORT_NAME,HRM_ORGANIZATION.CODE,
                HRM_ORGANIZATION.TYPE,HRM_ORGANIZATION.VALID
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
