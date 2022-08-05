package org.github.foxnic.web.generator.module.oauth;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.FormWindowOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.constants.enums.system.Language;
import org.github.foxnic.web.constants.enums.system.LoginType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.generator.module.BaseCodeConfig;
import org.github.foxnic.web.proxy.oauth.RoleServiceProxy;

public class SysUserConfig extends BaseCodeConfig<SYS_USER> {

    public SysUserConfig() {
        super(PREFIX_OAUTH, SYS_USER.$TABLE,"sys_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.addListProperty( Role.class, "roles","角色清单", "当前用户的所有角色清单");
        poType.addListProperty( Menu.class, "menus","菜单清单", "当前用户的所有菜单清单");
        poType.addListProperty( RoleMenu.class, "roleMenus","角色菜单关系清单", "当前用户的所有角色菜单关系清单");
        poType.addListProperty( UserTenant.class, "joinedTenants","所属租户关系清单", "可用且有效的所属租户关系清单");
        poType.addSimpleProperty( UserTenant.class, "activatedTenant","当前激活的租户", "当前激活的租户");
        poType.addSimpleProperty( String.class, "activatedEmployeeId","当前激活的员工ID", "当前激活的租户对应的员工ID");
        poType.addSimpleProperty( String.class, "activatedEmployeeName","当前激活的员工姓名", "当前激活的租户对应的员工姓名");


        //增加VO属性
        voType.addListProperty(String.class,"roleIds","角色ID列表","");

        PojoClassFile pojo=context.createPojo("LoginIdentityVO");
        pojo.setSuperType(null);
        pojo.setDoc("用于App登录接口");
        pojo.addSimpleProperty(String.class,"identity","帐号或手机号等用于识别身份的标识","");
        pojo.addSimpleProperty(String.class,"passwd","密码","");
        pojo.addSimpleProperty(String.class,"browserId","随机ID","客户端产生的唯一ID，用于标识一次认证");
        pojo.addSimpleProperty(String.class,"captcha","校验码/验证码","用户输入的校验码");
        pojo.addSimpleProperty(String.class,"loginType","登录方式","登录方式");
        pojo.shadow("loginType", LoginType.class);
    }

    @Override
    public void configFields(ViewOptions view) {




        context.view().field(SYS_USER.ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.PASSWD)
                .basic().hidden(true);

//        context.view().field(SYS_USER.EMPLOYEE_ID)
//                .basic().hidden(true);

        context.view().field(SYS_USER.LAST_LOGIN_TIME)
                .basic().hidden(true);

//        context.view().field(SYS_USER.PERSON_ID)
//                .basic().hidden(true);
//
//        context.view().field(SYS_USER.EMPLOYEE_ID)
//                .basic().hidden(true);

        context.view().field(SYS_USER.PASSWD)
                .basic().hidden(true).table().disable();

        context.view().field(SYS_USER.ACCOUNT)
                .search().fuzzySearch()
                .form().validate().required()
        ;

        context.view().field(SYS_USER.REAL_NAME).basic().label("姓名")
                .search().fuzzySearch();

//                .table().sort(false)
//                .fillBy(UserMeta.JOINED_TENANTS, UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON, PersonMeta.NAME).form().hidden()
//        ;


        context.view().field(SYS_USER.PHONE)
                .basic().label("手机")
                .search().fuzzySearch()
                .form().validate().required().phone();

        context.view().field(SYS_USER.LANGUAGE)
                .table().useThemeBadgeStyle()
                .search().triggerOnSelect(true)
                .form().radioBox().enumType(Language.class);



        context.view().field(UserVOMeta.ROLE_IDS)
                .basic().label("角色")
//				.list().hidden(true)
                .table().sort(false).useThemeBadgeStyle()
                .search().inputWidth(180).on(FoxnicWeb.SYS_ROLE.ID).selectMuliti(false).triggerOnSelect(true)
                .form().selectBox().muliti(true,false).queryApi(RoleServiceProxy.QUERY_LIST).fillWith(UserMeta.ROLES)
                .valueField(RoleMeta.ID).textField(RoleMeta.NAME).muliti(true,false)
                .form().validate().required()
        ;

        context.view().field(SYS_USER.PORTRAIT_ID)
                .basic().label("头像")
                .search().hidden(true)
                .table().alignCenter().sort(false)
                .form().upload().acceptSingleImage().buttonLabel("选择头像")
        ;

//        context.view().field(SYS_USER.PORTRAIT_ID)
//                .basic().label("头像")
//                .search().hidden(true)
//                .table().alignCenter()
//                .form().upload().acceptSingleFile().buttonLabel("选择头像")
//        ;

        context.view().field(SYS_USER.CACHE_KEY).search().hidden();

        context.view().field(SYS_USER.VALID)
                .table().alignCenter()
                .search().triggerOnSelect(true)
                .form().logicField().on("有效","1").off("无效","0");

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form, FormWindowOptions formWindow) {
        form.labelWidth(85);
        // 开启右键菜单
        form.enableContextMenu();
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.columnLayout(SYS_USER.ACCOUNT,SYS_USER.REAL_NAME,SYS_USER.PORTRAIT_ID,SYS_USER.LANGUAGE
                ,SYS_USER.PHONE,SYS_USER.VALID,UserVOMeta.ROLE_IDS);

//        list.operationColumn().addActionButton("属主","openTenantOwner");

        list.operationColumn().addActionMenu("ownerRelation","属主关系");
        list.operationColumn().addActionMenu("passwdReset","重置密码");

    }

    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        context.overrides()
            .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
            .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
            .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setExtendJsFile(WriteMode.IGNORE)
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
