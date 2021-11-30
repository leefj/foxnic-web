package org.github.foxnic.web.generator.module.hrm;

import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE_POSITION;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class HrmEmployeePositionConfig extends BaseCodeConfig<HRM_EMPLOYEE_POSITION> {

    public HrmEmployeePositionConfig() {
        super(PREFIX_HRM, HRM_EMPLOYEE_POSITION.$TABLE,"hrm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
         context.setRelationField(Employee.class, HRM_EMPLOYEE_POSITION.EMPLOYEE_ID, Position.class,HRM_EMPLOYEE_POSITION.POSITION_ID,true);
    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {

    }

    @Override
    public void configFields(ViewOptions view) {

        view.form().labelWidth(100);

//        view.field(HRM_COMPANY.ID).basic().hidden();
//        view.field(HRM_COMPANY.NAME).search().fuzzySearch();
//        view.field(HRM_COMPANY.VALID).form().logicField().on("有效",1).off("无效",0);

    }
    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.IGNORE) //Rest
            .setPageController(WriteMode.IGNORE) //页面控制器
            .setFormPage(WriteMode.IGNORE) //表单HTML页
            .setListPage(WriteMode.IGNORE) //列表HTML页
            .setExtendJsFile(WriteMode.IGNORE);
    }

}
