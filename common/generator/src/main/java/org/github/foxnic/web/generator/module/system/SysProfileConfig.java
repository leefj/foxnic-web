package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_PROFILE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SysProfileConfig extends BaseCodeConfig<SYS_PROFILE> {

    public SysProfileConfig() {
        super(PREFIX_SYSTEM, SYS_PROFILE.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        //poType.addSimpleProperty(Company.class,"company","公司","租户对应的公司");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

//        //配置逻辑型字段
//        view.field(SYS_CONFIG.VALID)
//                .search().hidden()
//                .form().logicField().off("无效", 0).on("有效", 1);
//        //配置字段为单选框，并指定枚举选项
//        view.field(SYS_CONFIG.TYPE)
//                .table().hidden()
//                .form().radioBox().enumType(SystemConfigType.class);
//
//        //
        view.field(SYS_PROFILE.ID)
               .basic().label("编码").search().fuzzySearch();

        view.field(SYS_PROFILE.NOTES).form().textArea().search().hidden();
        //
        view.field(SYS_PROFILE.NAME)
                .search().fuzzySearch();
//
//        view.field(SYS_CONFIG.TYPE_DESC)
//                .search().hidden()
//                .table().hidden();
//
//        view.field(SYS_CONFIG.VALUE)
//                .search().hidden();
//
//        view.field(SYS_CONFIG.NOTES)
//                .table().hidden()
//                .search().hidden();

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.operationColumn().addActionButton("参数","openSysProfileConfig");
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(80);
    }

    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        this.context.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)  //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE)
        ;

    }

}
