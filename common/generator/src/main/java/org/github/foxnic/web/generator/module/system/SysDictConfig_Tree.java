package org.github.foxnic.web.generator.module.system;

import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DICT;

public class SysDictConfig_Tree extends SysDictConfig {
    public SysDictConfig_Tree() {
        super();
        // 指定实现的目录名称
        this.context.setViewImplDir("tree");
    }
    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(new Object[]{
                SYS_DICT.NAME,SYS_DICT.CODE
        });
    }
}
