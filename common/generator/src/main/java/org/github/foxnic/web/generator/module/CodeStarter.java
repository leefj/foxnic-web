package org.github.foxnic.web.generator.module;

import com.github.foxnic.generator.util.ModuleCodeGenerator;
import org.github.foxnic.web.generator.module.changes.*;
import org.github.foxnic.web.generator.module.dataperm.*;
import org.github.foxnic.web.generator.module.example.CodeExampleCarConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleRoleConfig;
import org.github.foxnic.web.generator.module.example.CodeExampleStudentConfig;
import org.github.foxnic.web.generator.module.hrm.*;
import org.github.foxnic.web.generator.module.oauth.SysUserConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogAllocationConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogAttributeConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogConfig;
import org.github.foxnic.web.generator.module.system.BusiRoleConfig;
import org.github.foxnic.web.generator.module.system.BusiRoleMemberConfig;

public class CodeStarter extends ModuleCodeGenerator {

    public static void main(String[] args) {
        CodeStarter g=new CodeStarter();
        g.initModules();
        g.start();
    }

    public void initModules()
    {

//        initPcmModules();
//        initOAuthModules();
        initSystemModules();
//        initHrmModules();
//        initExampleModules();
//        initChangeModules();
//        initBpmModules();
//        initDatapermModules();

    }

    private void initDatapermModules() {
        //
        this.addConfig(new DPRuleConfig());
        this.addConfig(new DPRuleRangeConfig());
        this.addConfig(new DPRuleConditionConfig());
        //
        this.addConfig(new DPExampleOrderConfig());
        this.addConfig(new DPExampleProductConfig());
        this.addConfig(new DPExampleShopConfig());
        this.addConfig(new DPExampleCatalogConfig());
        this.addConfig(new DPExampleBrandConfig());
    }

    private void initBpmModules() {

    }

    private void  initChangeModules() {
        this.addConfig(new ChsChangeDefinitionConfig());
        this.addConfig(new ChsChangeInstanceConfig());
        this.addConfig(new ChsChangeDataConfig());
        this.addConfig(new ChsExampleOrderConfig());
        this.addConfig(new ChsExampleOrderItemConfig());
        this.addConfig(new ChsChangeEventConfig());
        this.addConfig(new ChsInstanceBillConfig());
        this.addConfig(new ChsInstanceApproverConfig());
    }

    private void initPcmModules() {
        this.addConfig(new PcmCatalogConfig());
        this.addConfig(new PcmCatalogAttributeConfig());
        this.addConfig(new PcmCatalogAllocationConfig());
    }

    private void initHrmModules() {
        this.addConfig(new HrmCompanyConfig());
        this.addConfig(new HrmOrgnizationConfig());
        this.addConfig(new HrmPositionConfig());
        this.addConfig(new HrmEmployeeConfig());
        this.addConfig(new HrmEmployeePositionConfig());
        this.addConfig(new HrmPersonConfig());
        this.addConfig(new HrmFavouriteGroupConfig());
        this.addConfig(new HrmFavouriteGroupItemConfig());

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

        this.addConfig(new BusiRoleConfig());
        this.addConfig(new BusiRoleMemberConfig());

//        this.addConfig(new SysDictConfig());
//        this.addConfig(new SysDictItemConfig());
//        this.addConfig(new SysFileConfig());
        //
//        this.addConfig(new SequenceConfig());
//        this.addConfig(new UserTenantConfig());
//        this.addConfig(new TenantConfig());


    }

}
