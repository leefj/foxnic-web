package org.github.foxnic.web.generator.module.oauth;

import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.PojoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.constants.enums.Language;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
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
        //
        poType.addSimpleProperty( Person.class, "person","对应的人员", "当前用户对应的人员");
        poType.addSimpleProperty( Employee.class, "employee","对应的员工", "当前用户对应的员工");

        //增加VO属性
        voType.addListProperty(String.class,"roleIds","角色ID列表","");

        PojoClassFile pojo=context.createPojo("LoginIdentityVO");
        pojo.setSuperType(null);
        pojo.setDoc("用于App登录接口");
        pojo.addSimpleProperty(String.class,"identity","帐号或手机号等用于识别身份的标识","");
        pojo.addSimpleProperty(String.class,"passwd","密码","");
        pojo.addSimpleProperty(String.class,"browserId","随机ID","客户端产生的唯一ID，用于标识一次认证");
        pojo.addSimpleProperty(String.class,"captcha","校验码/验证码","用户输入的校验码");
    }

    @Override
    public void configFields(ViewOptions view) {




        context.view().field(SYS_USER.ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.PASSWD)
                .basic().hidden(true);

        context.view().field(SYS_USER.EMPLOYEE_ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.LAST_LOGIN_TIME)
                .basic().hidden(true);

        context.view().field(SYS_USER.PERSON_ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.EMPLOYEE_ID)
                .basic().hidden(true);

        context.view().field(SYS_USER.PASSWD)
                .basic().hidden(true);

        context.view().field(SYS_USER.NAME)
                .form().validate().required()
        //.search().displayAlone(true)
        ;

//		context.view().field(UserMeta.ROLES)
//				.form().validate().required()
//				.search().displayAlone(true)
//		;

        context.view().field(SYS_USER.PHONE)
                .basic().label("手机")
                .form().validate().required().phone();

        context.view().field(SYS_USER.LANGUAGE)
                .form().radioBox().enumType(Language.class);

        context.view().field(UserVOMeta.ROLE_IDS)
                .basic().label("角色")
//				.list().hidden(true)
                .search().inputWidth(180)
                .form().selectBox().muliti(true).queryApi(RoleServiceProxy.QUERY_LIST).fillBy(UserMeta.ROLES)
                .valueField(RoleMeta.ID).textField(UserMeta.NAME)
        ;

        context.view().field(SYS_USER.PORTRAIT_ID)
                .basic().label("头像")
                .search().hidden(true)
                .table().alignCenter()
                .form().upload().acceptSingleImage().buttonLabel("选择头像")
        ;

        context.view().field(SYS_USER.CACHE_KEY).search().hidden();

        context.view().field(SYS_USER.VALID)
                .table().alignCenter()
                .form().logicField().on("有效","1").off("无效","0");

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        list.columnLayout(SYS_USER.NAME,SYS_USER.PORTRAIT_ID,SYS_USER.LANGUAGE
                ,SYS_USER.PHONE,SYS_USER.VALID,UserVOMeta.ROLE_IDS);
    }

    @Override
    public void configOverrides() {
        //文件生成覆盖模式
        context.overrides()
            .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
            .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
            .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
            .setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }

}
