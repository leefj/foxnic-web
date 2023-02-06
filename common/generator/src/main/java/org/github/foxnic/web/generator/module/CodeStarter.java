package org.github.foxnic.web.generator.module;

import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.generator.builder.business.TemplateJavaFile;
import com.github.foxnic.generator.util.ModuleCodeGenerator;
import org.github.foxnic.web.generator.module.api.ApiSourceConfig;
import org.github.foxnic.web.generator.module.bpm.*;
import org.github.foxnic.web.generator.module.changes.ChsChangeDefinitionConfig;
import org.github.foxnic.web.generator.module.dataperm.*;
import org.github.foxnic.web.generator.module.example.ExampleAddressConfig;
import org.github.foxnic.web.generator.module.example.ExampleNewsConfig;
import org.github.foxnic.web.generator.module.hrm.HrmEmployeeConfig;
import org.github.foxnic.web.generator.module.job.SysJobConfig;
import org.github.foxnic.web.generator.module.job.SysJobLogConfig;
import org.github.foxnic.web.generator.module.job.SysJobWorkerConfig;
import org.github.foxnic.web.generator.module.oauth.SysMenuForkConfig;
import org.github.foxnic.web.generator.module.oauth.SysUserConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogAllocationConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogAttributeConfig;
import org.github.foxnic.web.generator.module.pcm.PcmCatalogConfig;
import org.github.foxnic.web.generator.module.storage.SysFileConfig;
import org.github.foxnic.web.generator.module.system.BusiRoleConfig;
import org.github.foxnic.web.generator.module.system.SysConfigConfig;
import org.github.foxnic.web.generator.module.system.SysProfileConfig;

import java.io.File;

public class CodeStarter extends ModuleCodeGenerator {

    public static void main(String[] args) {

        copyTemplateFiles();

        CodeStarter g=new CodeStarter();
        g.initModules();
        g.start();
    }

    public static void copyTemplateFiles() {

        MavenProject sourceProject=new MavenProject(BaseCodeConfig.class);
        File sourceTemplatesDir= FileUtil.resolveByPath(sourceProject.getMainResourceDir(),"templates");

        MavenProject targetProject=new MavenProject(TemplateJavaFile.class);
        File targetTemplatesDir= FileUtil.resolveByPath(targetProject.getMainResourceDir(),"templates");

        // System.out.println(sourceTemplatesDir.getAbsolutePath());
        // System.out.println(targetTemplatesDir.getAbsolutePath());

        FileUtil.delete(targetTemplatesDir,true);

        FileUtil.copyDir(sourceTemplatesDir,targetTemplatesDir);



    }

    public void initModules() {

//        initPcmModules();
        initOAuthModules();
//        initSystemModules();
//        initHrmModules();
//        initExampleModules();
//        initStorageModules();
//        initChangeModules();
//        initBpmModules();
//        initDatapermModules();
//
//        initExample2Modules();
//        initJobModules();

//        initDocsModules();

    }



    private void initExample2Modules() {
        this.addConfig(new ExampleNewsConfig());
    }



    private void initDocsModules() {
        this.addConfig(new ApiSourceConfig());
    }

    private void initStorageModules() {

        this.addConfig(new SysFileConfig());
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
        this.addConfig(new ProcessDefinitionConfig());
        this.addConfig(new ProcessDefinitionFileConfig());
        this.addConfig(new ProcessDefinitionNodeConfig());
        this.addConfig(new ProcessDefinitionNodeAssigneeConfig());
        this.addConfig(new ProcessInitiatorConfig());
        this.addConfig(new ProcessDefinitionApplyConfig());
        //
        this.addConfig(new ProcessInstanceConfig());
        //
        this.addConfig(new FormDefinitionConfig());
        this.addConfig(new FormInstanceConfig());
        this.addConfig(new FormInstanceBillConfig());
        this.addConfig(new TaskConfig());
        this.addConfig(new TaskReadConfig());
        this.addConfig(new TaskAssigneeConfig());
        this.addConfig(new TaskApprovalConfig());
        this.addConfig(new ProcessErrorConfig());
//
//        //
//        this.addConfig(new DemoLeaveConfig());
//        this.addConfig(new DemoCommonConfig());
    }

    private void  initChangeModules() {
        this.addConfig(new ChsChangeDefinitionConfig());
//        this.addConfig(new ChsChangeInstanceConfig());
//        this.addConfig(new ChsChangeDataConfig());
//        this.addConfig(new ChsExampleOrderConfig());
//        this.addConfig(new ChsExampleOrderItemConfig());
//        this.addConfig(new ChsChangeEventConfig());
//        this.addConfig(new ChsInstanceBillConfig());
//        this.addConfig(new ChsInstanceApproverConfig());
    }

    private void initJobModules() {
        this.addConfig(new SysJobConfig());
        this.addConfig(new SysJobWorkerConfig());
        this.addConfig(new SysJobLogConfig());
    }

    private void initPcmModules() {
        this.addConfig(new PcmCatalogConfig());
        this.addConfig(new PcmCatalogAttributeConfig());
        this.addConfig(new PcmCatalogAllocationConfig());
    }

    private void initHrmModules() {
//        this.addConfig(new HrmCompanyConfig());
//        this.addConfig(new HrmOrgnizationConfig());
//        this.addConfig(new HrmPositionConfig());
        this.addConfig(new HrmEmployeeConfig());
//        this.addConfig(new HrmEmployeePositionConfig());
//        this.addConfig(new HrmPersonConfig());
//        this.addConfig(new HrmFavouriteGroupConfig());
//        this.addConfig(new HrmFavouriteGroupItemConfig());

    }

    private void initOAuthModules() {
        this.addConfig(new SysMenuForkConfig());
        // this.addConfig(new SysUserConfig());
        // this.addConfig(new SysResourzeConfig());

    }

    private void initExampleModules() {
        //this.addConfig(new CodeExampleConfig());
//        this.addConfig(new CodeExampleRoleConfig());
//        this.addConfig(new CodeExampleStudentConfig());
//        this.addConfig(new CodeExampleCarConfig());
//        this.addConfig(new CodeExampleMulitPkConfig());

//        this.addConfig(new ExampleOrderConfig());
//        this.addConfig(new ExampleOrderItemConfig());
//        this.addConfig(new ExampleGoodsConfig());
        this.addConfig(new ExampleAddressConfig());

    }

    private void initSystemModules() {

//        this.addConfig(new BusiRoleConfig());
//        this.addConfig(new BusiRoleMemberConfig());
//
//        this.addConfig(new SysDictConfig());
        this.addConfig(new SysConfigConfig());
        this.addConfig(new SysProfileConfig());
//        this.addConfig(new TenantConfig());
//        this.addConfig(new SysDictItemConfig());
//        this.addConfig(new SysFileConfig());
//        //
//        this.addConfig(new SequenceConfig());
//        this.addConfig(new UserTenantConfig());
//        this.addConfig(new TenantConfig());


    }

}
