package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_POSITION;
import org.github.foxnic.web.constants.enums.DictEnum;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class HrmPositionConfig extends BaseCodeConfig<HRM_POSITION> {

    public HrmPositionConfig() {
        super(PREFIX_HRM, HRM_POSITION.$TABLE,"hrm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Organization.class,"organization","所属组织节点","所属组织节点");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(70);

        view.field(HRM_POSITION.ID).basic().hidden();
        view.field(HRM_POSITION.ORG_ID).basic().hidden();
        view.field(HRM_POSITION.VALID)
                .form().validate().required()
                .form().logicField().on("有效",1).off("无效",0).defaultValue(true);
        view.field(HRM_POSITION.COMPANY_ID).basic().hidden();

        view.field(HRM_POSITION.TYPE).form().selectBox().dict(DictEnum.POSITION_TYPE);

        view.field(HRM_POSITION.SORT).basic().hidden();
        view.field(HRM_POSITION.CODE).basic().label("代码");


    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.columnLayout(new Object[] {
                HRM_POSITION.FULL_NAME,HRM_POSITION.SHORT_NAME,HRM_POSITION.CODE,HRM_POSITION.TYPE,HRM_POSITION.VALID
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
