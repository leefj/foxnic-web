package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT_ITEM;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.IDictService;
import org.github.foxnic.web.system.service.ISequenceService;

public class SysDictItemConfig extends BaseCodeConfig<FoxnicWeb.SYS_DICT_ITEM> {

    public SysDictItemConfig() {
        super("service-system", SYS_DICT_ITEM.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

    }

    @Override
    public void configService(ServiceOptions service) {
        service.autoware(ISequenceService.class,"序列服务");
        service.inject(IConfigService.class,"SysConfigService","系统配置服务");
        service.injectMuliti(IDictService.class,"字典服务");
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {

    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_DICT_ITEM.ID).basic().hidden();
        view.field(SYS_DICT_ITEM.DICT_ID).basic().hidden();
        view.field(SYS_DICT_ITEM.DICT_CODE).basic().hidden();
        view.field(SYS_DICT_ITEM.PARENT_ID).basic().hidden();
        view.field(SYS_DICT_ITEM.SORT).search().hidden();
        //
        view.field(SYS_DICT_ITEM.CODE)
                .form().validate().required()
                .search().fuzzySearch();

        view.field(SYS_DICT_ITEM.VALID).basic().label("生效")
                .form().logicField().on("有效",1).off("无效",0).defaultValue(true)
                .form().validate().required()
                .search().hidden();

        view.field(SYS_DICT_ITEM.LABEL)
                .form().validate().required()
                .search().fuzzySearch();

        view.field(SYS_DICT_ITEM.NOTES).search().hidden().form().textArea().height(50);
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.operationColumn().width(120);
        list.disableFormView();
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
            .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
            .setFormPage(WriteMode.WRITE_TEMP_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
