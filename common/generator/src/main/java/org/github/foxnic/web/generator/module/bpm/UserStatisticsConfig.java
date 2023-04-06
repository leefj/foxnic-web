package org.github.foxnic.web.generator.module.bpm;

import com.github.foxnic.api.query.MatchType;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_USER_STATISTICS;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import org.github.foxnic.web.constants.enums.bpm.TaskStatus;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.*;
import org.github.foxnic.web.domain.bpm.meta.ProcessDefinitionMeta;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import org.github.foxnic.web.domain.bpm.meta.TaskMeta;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.bpm.ProcessDefinitionServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

public class UserStatisticsConfig extends BaseCodeConfig<BPM_USER_STATISTICS> {

    public UserStatisticsConfig() {
        super(PREFIX_BPM, BPM_USER_STATISTICS.$TABLE,"bpm_", 4);
    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
        poType.addSimpleProperty(ProcessDefinition.class,"processDefinition","流程类型","流程类型");


    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {



    }

    @Override
    public void configFields(ViewOptions view) {



    }





    @Override
    public void configList(ViewOptions view, ListOptions list) {

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
