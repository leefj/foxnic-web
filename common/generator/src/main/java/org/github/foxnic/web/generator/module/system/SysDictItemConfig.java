package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.generator.util.JSFunctions;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT_ITEM;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SysDictItemConfig extends BaseCodeConfig<FoxnicWeb.SYS_DICT_ITEM> {

    public SysDictItemConfig() {
        super("service-system", SYS_DICT_ITEM.$TABLE,"sys_", 4);
    }

    @Override
    public void configCodeSegment() {
        context.addJsFuncs(new JSFunctions(this.getClass(),"dict_functions.js"));
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
        //表单数据填充前调用
        form.jsBeforeDataFill("beforeDictItemDataFill");
        //表单数据填充后调用
        form.jsAfterDataFill("afterDictItemDataFill");
    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_DICT_ITEM.ID).basic().hidden();
        view.field(SYS_DICT_ITEM.DICT_ID).basic().hidden();
        view.field(SYS_DICT_ITEM.DICT_CODE).basic().hidden();
        view.field(SYS_DICT_ITEM.PARENT_ID).basic().hidden();
        view.field(SYS_DICT_ITEM.SORT).search().hidden();
        //
        view.field(SYS_DICT_ITEM.CODE).search().fuzzySearch();
        view.field(SYS_DICT_ITEM.LABEL).search().fuzzySearch();
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.operationColumn().width(120);
        list.disableFormView();
        //设置查询前调用的 JS 函数
        list.jsBeforeQuery("beforeDictItemDataQuery");

    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
