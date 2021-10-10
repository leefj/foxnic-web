package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_FAVOURITE_GROUP_ITEM;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class HrmFavouriteGroupItemConfig extends BaseCodeConfig<HRM_FAVOURITE_GROUP_ITEM> {

    public HrmFavouriteGroupItemConfig() {
        super(PREFIX_HRM, HRM_FAVOURITE_GROUP_ITEM.$TABLE,"hrm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        voType.addSimpleProperty(String.class,"initValue","初始化的人员清单","初始化的人员清单");

        poType.addSimpleProperty(Employee.class,"employee","关联的员工","");
        poType.addSimpleProperty(Employee.class,"organization","关联的部门","");
        poType.addSimpleProperty(Employee.class,"position","关联的岗位","");
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

//        view.form().labelWidth(100);
//
//        view.field(HRM_COMPANY.ID).basic().hidden();
//        view.field(HRM_COMPANY.NAME).search().fuzzySearch();
//        view.field(HRM_COMPANY.VALID).form().logicField().on("有效",1).off("无效",0);

    }
    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
            .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
    }

}
