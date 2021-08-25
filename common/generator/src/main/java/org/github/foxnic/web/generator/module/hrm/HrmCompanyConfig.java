package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_COMPANY;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class HrmCompanyConfig extends BaseCodeConfig<HRM_COMPANY> {

    public HrmCompanyConfig() {
        super(PREFIX_HRM, HRM_COMPANY.$TABLE,"hrm_", 4);
    }


    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

        view.field(HRM_COMPANY.ID).basic().hidden();
        view.field(HRM_COMPANY.NAME).search().fuzzySearch();
        view.field(HRM_COMPANY.VALID).form().logicField().on("有效",1).off("无效",0);

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
