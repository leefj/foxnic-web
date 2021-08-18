package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.util.ModuleCodeGenerator;
import org.github.foxnic.web.generator.module.example.CodeExampleConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleRoleConfig;
import org.github.foxnic.web.generator.module.storage.SysFileConfig;
import org.github.foxnic.web.generator.module.system.SysDictConfig;
import org.github.foxnic.web.generator.module.system.SysDictItemConfig;

public class CodeStarter extends ModuleCodeGenerator {

    public static void main(String[] args) {
        CodeStarter g=new CodeStarter();
        g.initModules();
        g.start();
    }

    public void initModules()
    {
        this.addConfig(new SysDictConfig());
        this.addConfig(new SysDictItemConfig());
        this.addConfig(new SysFileConfig());
        this.addConfig(new CodeExampleConfig());
        this.addConfig(new CodeExampleRoleConfig());
    }

}
