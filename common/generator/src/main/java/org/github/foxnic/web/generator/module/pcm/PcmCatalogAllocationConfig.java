package org.github.foxnic.web.generator.module.pcm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ALLOCATION;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class PcmCatalogAllocationConfig extends BaseCodeConfig<PCM_CATALOG_ALLOCATION> {

    public PcmCatalogAllocationConfig() {
        super(PREFIX_PCM, PCM_CATALOG_ALLOCATION.$TABLE,"pcm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(CatalogAttribute.class,"attribute","与之关联的属性","与之关联的属性");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        //form.disableFooter().disableMargin();
    }

    @Override
    public void configFields(ViewOptions view) {
//        view.field(SYS_CODE_EXAMPLE_STUDENT.ID).basic().hidden();
//        view.field(PCM_CATALOG_ALLOCATION.CATALOG_ID)
//                .basic().hidden().form().fillBy("","").table().fillBy("","");
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.IGNORE) //Rest
            .setPageController(WriteMode.IGNORE) //页面控制器
            .setFormPage(WriteMode.IGNORE) //表单HTML页
            .setListPage(WriteMode.IGNORE) //列表HTML页
            .setExtendJsFile(WriteMode.IGNORE); //扩展页面
    }

}
