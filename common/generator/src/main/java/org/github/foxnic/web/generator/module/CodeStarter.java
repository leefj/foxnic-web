package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.util.ModuleCodeGenerator;
import org.github.foxnic.web.generator.module.example.CodeExampleCarConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleRoleConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleStudentConfig;
import org.github.foxnic.web.generator.module.hrm.HrmCompanyConfig;
import org.github.foxnic.web.generator.module.hrm.HrmEmployeeConfig;
import org.github.foxnic.web.generator.module.hrm.HrmPersonConfig;
import org.github.foxnic.web.generator.module.oauth.SysUserConfig;
import org.github.foxnic.web.generator.module.system.TenantConfig;
import org.github.foxnic.web.generator.module.system.UserTenantConfig;

public class CodeStarter extends ModuleCodeGenerator {

    public static void main(String[] args) {
        CodeStarter g=new CodeStarter();
        g.initModules();
        g.start();
    }

    public void initModules()
    {

        initOAuthModules();
        initSystemModules();
        initHrmModules();
//        initExampleModules();

    }

    private void initHrmModules() {
        this.addConfig(new HrmCompanyConfig());
        this.addConfig(new HrmPersonConfig());
        this.addConfig(new HrmEmployeeConfig());
    }

    private void initOAuthModules() {
        this.addConfig(new SysUserConfig());
    }

    private void initExampleModules() {
        this.addConfig(new CodeExampleConfig());
        this.addConfig(new CodeExampleRoleConfig());
        this.addConfig(new CodeExampleStudentConfig());
        this.addConfig(new CodeExampleCarConfig());
    }

    private void initSystemModules() {
//        this.addConfig(new SysDictConfig());
//        this.addConfig(new SysDictItemConfig());
//        this.addConfig(new SysFileConfig());
        //
        this.addConfig(new UserTenantConfig());
        this.addConfig(new TenantConfig());

    }

}
