package org.github.foxnic.web.generator.module.api;

import com.github.foxnic.generator.builder.business.option.ControllerOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_API_SOURCE;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.springframework.web.bind.annotation.RequestMethod;

public class ApiSourceConfig extends BaseCodeConfig<SYS_API_SOURCE> {

    public ApiSourceConfig() {
        super(PREFIX_API, SYS_API_SOURCE.$TABLE,"sys_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[] {SYS_API_SOURCE.NAME,SYS_API_SOURCE.API_URL});
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        //form.disableFooter().disableMargin();
    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_API_SOURCE.ID).basic().hidden();

        view.field(SYS_API_SOURCE.API_DATA)
               .table().disable()
               .form().hidden()
        ;

        view.field(SYS_API_SOURCE.NAV_DIR)
                .table().disable()
                .form().hidden();
        ;

        view.field(SYS_API_SOURCE.FETCH_TIME)
                .form().hidden();
        ;

        view.field(SYS_API_SOURCE.NAME)
                .search().fuzzySearch()
        ;

        view.field(SYS_API_SOURCE.API_URL)
                .search().fuzzySearch()
                .form().textInput()
        ;

        view.field(SYS_API_SOURCE.VALID)
                .form().logicField().defaultValue(true).on("有效",1).off("无效",0)
        ;


    }

    @Override
    public void configController(ControllerOptions controller) {

        // 定义一个控制器方法
        controller.restApi("立即取数","fetchApiDoc","fetch-api-doc", RequestMethod.POST,"获取API文档")
                .addSimpleParameter(String.class,"id","来源ID",true,"001","来源ID");

        // 定义一个控制器方法
        controller.restApi("获得API接口节点","queryApiNodes","query-api-nodes", RequestMethod.POST,"获得API接口节点")
                .addSimpleParameter(String.class,"id","id",true,"example","id")
                .listResult(ZTreeNode.class,"节点树形结构");

        // 定义一个控制器方法
        controller.restApi("获得API接口详情","queryApiDetail","query-api-detail", RequestMethod.POST,"获得API接口详情")
                .addSimpleParameter(String.class,"path","path",true,"/example/query-list","path")
                .addSimpleParameter(String.class,"method","method",true,"post","method");

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.operationColumn().addActionButton("立即取数","fetchApiDoc");
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
