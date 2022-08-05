package org.github.foxnic.web.generator.module.pcm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ATTRIBUTE;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.DataType;
import org.github.foxnic.web.domain.pcm.meta.CatalogAttributeMeta;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class PcmCatalogAttributeConfig extends BaseCodeConfig<PCM_CATALOG_ATTRIBUTE> {

    public PcmCatalogAttributeConfig() {
        super(PREFIX_PCM, PCM_CATALOG_ATTRIBUTE.$TABLE,"pcm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(Catalog.class,"catalog","类目对象","类目对象");
        poType.addSimpleProperty(CatalogAllocation.class,"allocation","分配的字段","分配的字段");
        poType.addSimpleProperty(CatalogAllocation.class,"allocationBefore","重新分配前的字段","用于字段参数变更时登记");
        poType.addSimpleProperty(CatalogAttribute.class,"sourceAttr","来源","上一个版本的配置信息");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{PCM_CATALOG_ATTRIBUTE.VERSION_NO,PCM_CATALOG_ATTRIBUTE.SHORT_NAME,PCM_CATALOG_ATTRIBUTE.FULL_NAME,PCM_CATALOG_ATTRIBUTE.FIELD,PCM_CATALOG_ATTRIBUTE.DATA_TYPE});
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.addToolButton("创建版本","createVersion","create-version-button");
        list.addToolButton("应用版本","applyVersion","apply-version-button");
        list.columnLayout(PCM_CATALOG_ATTRIBUTE.FIELD,PCM_CATALOG_ATTRIBUTE.DATA_TYPE,PCM_CATALOG_ATTRIBUTE.NOT_NULL,
                PCM_CATALOG_ATTRIBUTE.SHORT_NAME,PCM_CATALOG_ATTRIBUTE.FULL_NAME,catalogName);
    }

    private String catalogName="catalogName";

    @Override
    public void configFields(ViewOptions view) {
        view.field(PCM_CATALOG_ATTRIBUTE.ID).basic().hidden();

        view.field(PCM_CATALOG_ATTRIBUTE.FULL_NAME).form().validate().required()
        .search().inputWidth(100);
        view.field(PCM_CATALOG_ATTRIBUTE.SHORT_NAME).form().validate().required()
        .search().inputWidth(100);

        view.field(PCM_CATALOG_ATTRIBUTE.NOT_NULL)
                .table().alignCenter()
                .form().validate().required()
                .form().logicField().on("必填",1).off("可空",0);


        view.field(PCM_CATALOG_ATTRIBUTE.CATALOG_ID).basic().hidden();

        view.field(PCM_CATALOG_ATTRIBUTE.VERSION_NO)
                .basic().label("版本")
        .form().hidden()
        .table().hidden();

        view.field(PCM_CATALOG_ATTRIBUTE.SOURCE_ID).basic().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.FIELD).form().validate().required()
        .search().inputWidth(100);
        view.field(PCM_CATALOG_ATTRIBUTE.LENGTH).search().hidden().table().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.ACCURACY).search().hidden().table().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.SCALE).search().hidden().table().hidden();
        view.field(PCM_CATALOG_ATTRIBUTE.HINT).search().hidden();

        view.field(PCM_CATALOG_ATTRIBUTE.NOTE).search().hidden().table().hidden()
                .form().textArea().height(100);
        view.field(PCM_CATALOG_ATTRIBUTE.DETAIL).search().hidden().table().hidden().form().label("属性说明").textArea().height(100);

        view.field(catalogName).basic().label("所属类目").table().fillBy(CatalogAttributeMeta.CATALOG, CatalogMeta.NAME);

        view.field(PCM_CATALOG_ATTRIBUTE.DATA_TYPE)
                .form().validate().required()
                .form().selectBox().enumType(DataType.class).muliti(false).filter(false).toolbar(false);

        view.field(PCM_CATALOG_ATTRIBUTE.VALID)
                .search().hidden()
                .form().logicField().off("无效",0).on("有效",1)
                .table().hidden();
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(100);
        form.columnLayout(new Object[]{
                PCM_CATALOG_ATTRIBUTE.FULL_NAME,PCM_CATALOG_ATTRIBUTE.SHORT_NAME,
                PCM_CATALOG_ATTRIBUTE.FIELD, PCM_CATALOG_ATTRIBUTE.NOT_NULL,PCM_CATALOG_ATTRIBUTE.VALID,
                PCM_CATALOG_ATTRIBUTE.DATA_TYPE,PCM_CATALOG_ATTRIBUTE.LENGTH,PCM_CATALOG_ATTRIBUTE.ACCURACY,PCM_CATALOG_ATTRIBUTE.SCALE,
                PCM_CATALOG_ATTRIBUTE.HINT,PCM_CATALOG_ATTRIBUTE.DETAIL,PCM_CATALOG_ATTRIBUTE.NOTE
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
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //扩展页面
    }

}
