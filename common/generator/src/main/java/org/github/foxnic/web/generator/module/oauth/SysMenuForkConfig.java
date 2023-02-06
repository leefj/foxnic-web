package org.github.foxnic.web.generator.module.oauth;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU_FORK;
import org.github.foxnic.web.constants.enums.hrm.ResourceType;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.constants.enums.system.HttpMethodType;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SysMenuForkConfig extends BaseCodeConfig<SYS_MENU_FORK> {

    public SysMenuForkConfig() {
        super(PREFIX_OAUTH, SYS_MENU_FORK.$TABLE,"sys_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_MENU_FORK.ID).basic().hidden();
        view.field(SYS_MENU_FORK.MENU_ID).basic().hidden();
        view.field(SYS_MENU_FORK.DIR).basic().label("目录").search().fuzzySearch().form().validate().required();
        view.field(SYS_MENU_FORK.NAME).basic().label("名称").search().fuzzySearch().form().validate().required();
        view.field(SYS_MENU_FORK.NOTES).search().hidden();
        view.field(SYS_MENU_FORK.SORT).search().hidden().form().validate().required();
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(70);
        form.columnLayout(new Object[]{
                SYS_MENU_FORK.NAME,SYS_MENU_FORK.DIR,SYS_MENU_FORK.NOTES,SYS_MENU_FORK.SORT
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        //list.refreshAfterEdit(false);
//        list.disableMargin();
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{
                SYS_MENU_FORK.NAME,SYS_MENU_FORK.DIR
        });
    }

    @Override
    public void configController(ControllerOptions controller) {
        controller.restApiTagDir("认证服务");
    }

    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        context.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
