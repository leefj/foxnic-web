package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;

public class SysDictConfig extends BaseCodeConfig<SYS_DICT> {

    public SysDictConfig() {
        super(PREFIX_SYSTEM, SYS_DICT.$TABLE,"sys_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addListProperty(DictItem.class,"items","字典项目","");
        poType.addSimpleProperty(Menu.class,"moduleInfo","关联模块","");
    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(FoxnicWeb.SYS_DICT.ID)
                .basic().hidden();
        view.field(FoxnicWeb.SYS_DICT.IS_TREE).basic().hidden();

        view.field(FoxnicWeb.SYS_DICT.MODULE)
                .basic().label("模块")
                .form().validate().required()
                .form().selectBox().queryApi(MenuServiceProxy.QUERY_LIST+"?parentId=0").paging(false).filter(false).toolbar(false)
                .valueField(MenuMeta.ID).textField(MenuMeta.LABEL).fillWith(DictMeta.MODULE_INFO).muliti(false,false)
                .search().triggerOnSelect(true);

        view.field(FoxnicWeb.SYS_DICT.CODE)
                .basic().label("代码")
                .form().validate().required()
                .search().fuzzySearch()
        ;

        view.field(FoxnicWeb.SYS_DICT.NAME)
                .basic().label("名称")
                .form().validate().required()
                .search().fuzzySearch();

        //
        view.formWindow().bottomSpace(120);

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.operationColumn().width(220);
        //表格操作列增加一个按钮，并指定JS函数
        list.operationColumn().addActionButton("条目","openDictItemWindow");
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
