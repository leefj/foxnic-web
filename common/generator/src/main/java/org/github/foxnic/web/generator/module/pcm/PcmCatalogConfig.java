package org.github.foxnic.web.generator.module.pcm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class PcmCatalogConfig extends BaseCodeConfig<PCM_CATALOG> {

    public PcmCatalogConfig() {
        super(PREFIX_PCM, PCM_CATALOG.$TABLE,"pcm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.addListProperty(CatalogAttribute.class,"attributes","当前有效的属性清单","当前有效的属性清单");

        PojoClassFile pojo=context.createPojo("DataQueryVo");
        pojo.setSuperType(null);
        pojo.setDoc("用于PCM数据查询");
        pojo.addSimpleProperty(String.class,"tenantId","租户ID","");
        pojo.addSimpleProperty(String.class,"catalogId","类目ID","");
        pojo.addListProperty(String.class,"ids","数据的ID清单","");
        pojo.addListProperty(String.class,"ownerIds","所有者单据ID清单","");

        pojo.addSimpleProperty(Integer.class,"pageSize","分页大小","为 null 时不分页");
        pojo.addSimpleProperty(Integer.class,"pageIndex","分页页码","为 null 时不分页");
        //
        voType.addSimpleProperty(Integer.class,"isLoadAllDescendants","是否加载所有子孙节点","1：是；0：否");
        voType.addSimpleProperty(Integer.class,"isLoadAllAncestors","是否加载所有祖先节点","1：是；0：否");
        voType.addSimpleProperty(String.class,"root","根节点id或code","根节点id或code");

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
//        view.field(SYS_CODE_EXAMPLE_STUDENT.EXAMPLE_ID)
//                .basic().hidden();
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
