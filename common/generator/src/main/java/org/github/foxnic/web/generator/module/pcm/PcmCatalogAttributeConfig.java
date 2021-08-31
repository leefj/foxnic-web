package org.github.foxnic.web.generator.module.pcm;

import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ATTRIBUTE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class PcmCatalogAttributeConfig extends BaseCodeConfig<PCM_CATALOG_ATTRIBUTE> {

    public PcmCatalogAttributeConfig() {
        super(PREFIX_PCM, PCM_CATALOG_ATTRIBUTE.$TABLE,"pcm_", 4);
    }


    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(PCM_CATALOG_ATTRIBUTE.ID).basic().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.CATALOG_ID).basic().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.FIELD).basic().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.LENGTH).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.ACCURACY).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.SCALE).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.HINT).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.NOTE).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.DETAIL).search().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.VALID).search().hidden();
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //扩展页面
    }

}
