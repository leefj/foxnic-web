package org.github.foxnic.web.generator.module.oauth;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.*;
import org.github.foxnic.web.constants.enums.hrm.ResourceType;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.constants.enums.system.HttpMethodType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SysResourzeConfig extends BaseCodeConfig<SYS_RESOURZE> {

    public SysResourzeConfig() {
        super(PREFIX_OAUTH, SYS_RESOURZE.$TABLE,"sys_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.shadow(SYS_RESOURZE.ACCESS_TYPE, AccessType.class);
        poType.shadow(SYS_RESOURZE.TYPE, ResourceType.class);
        poType.shadow(SYS_RESOURZE.METHOD, HttpMethodType.class);
    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(SYS_RESOURZE.ID)
                .table().hidden(true)
                .search().hidden();
        ;

        view.field(SYS_RESOURZE.ACCESS_TYPE)
                .basic().label("访问控制")
                .search()
                .form().radioBox().enumType(AccessType.class)
                .form().validate().required();

        view.field(SYS_RESOURZE.METHOD)
                .basic().label("Method")
                .search().hidden()
                .form().radioBox().enumType(HttpMethodType.class)
                .form().validate().required();

        view.field(SYS_RESOURZE.TYPE).form().radioBox().enumType(ResourceType.class).form().validate().required();
        view.field(SYS_RESOURZE.NAME).form().validate().required()
                .search().fuzzySearch();
        view.field(SYS_RESOURZE.URL).form().validate().required()
                .search().fuzzySearch();
        view.field(SYS_RESOURZE.BATCH_ID).basic().hidden(true);
        view.field(SYS_RESOURZE.MODULE).basic().label("模块")
                .search().fuzzySearch();
        view.field(SYS_RESOURZE.TABLE_NAME).basic().label("数据表")
                .search().hidden();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(70);
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        //list.refreshAfterEdit(false);
    }

    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        context.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
    }

}
