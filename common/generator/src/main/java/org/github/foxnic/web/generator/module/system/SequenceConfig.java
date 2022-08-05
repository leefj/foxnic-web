package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.commons.busi.id.SequenceType;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SEQUENCE;
import org.github.foxnic.web.generator.module.BaseCodeConfig;

public class SequenceConfig extends BaseCodeConfig<SYS_SEQUENCE> {

    public SequenceConfig() {
        super(PREFIX_SYSTEM, SYS_SEQUENCE.$TABLE,"sys_", 4);
    }




    @Override
    public void configFields(ViewOptions view) {
        view.field(SYS_SEQUENCE.PK).basic().hidden();
        view.field(SYS_SEQUENCE.MEMO).table().hidden().search().hidden();

        view.field(SYS_SEQUENCE.NAME).basic().label("名称").form().validate().required();

        view.field(SYS_SEQUENCE.ID).basic().label("Key");

        view.field(SYS_SEQUENCE.LENGTH)
                .basic().label("长度")
                .search().hidden()
                .form().numberInput().integer().range(1d,64d)
        .form().validate().required();


        view.field(SYS_SEQUENCE.FETCH_SIZE)
                .basic().label("取值个数")
                .search().hidden()
                .form().numberInput().integer().range(1d,1024d)
                .form().validate().required();


        view.field(SYS_SEQUENCE.CATALOG ).search().hidden().form().hidden();
        view.field(SYS_SEQUENCE.VALUE).search().hidden().form().hidden();

        view.field(SYS_SEQUENCE.TYPE).basic().label("类型")
                .search().hidden()
        .form().radioBox().enumType(SequenceType.class)
        .form().validate().required();
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(100);
        form.columnLayout(new Object[]{
                SYS_SEQUENCE.ID,SYS_SEQUENCE.NAME,SYS_SEQUENCE.TYPE,SYS_SEQUENCE.LENGTH,SYS_SEQUENCE.FETCH_SIZE,SYS_SEQUENCE.MEMO
        });
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.disableModify().disableBatchDelete();
        list.operationColumn().width(220);
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
