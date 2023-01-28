package org.github.foxnic.web.oauth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.encrypt.Base64Util;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.log.PerformanceLogger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.oauth.meta.UserVOMeta;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import org.github.foxnic.web.framework.web.ServiceHub;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.language.LanguageService;
import org.github.foxnic.web.oauth.config.security.SecurityProperties;
import org.github.foxnic.web.oauth.login.SessionCache;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.system.LangServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 账户表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
 * @version manual
 */
@InDoc
@Api(tags = "认证服务/账户接口")
@ApiSort(0)
@RestController("SysUserController")
public class UserController extends SuperController {

    @Autowired
    private IUserService userService;

    @Autowired
    private SessionCache sessionCache;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 添加账户
     */
    @ApiOperation(value = "添加账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD, value = "密码", required = true, dataTypeClass = String.class, example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY, value = "缓存键", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME, value = "最后登录时间", required = false, dataTypeClass = Date.class, example = "2021-05-31 03:09:23"),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = UserServiceProxy.INSERT)
    @PostMapping(UserServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(UserVO userVO) {
        this.validator().asserts(userVO.getRealName()).require();
        if (this.validator().failure()) {
            return this.validator().getMergedResult();
        }
        Result result = userService.insert(userVO);
        return result;
    }

    /**
     * 删除账户
     */
    @ApiOperation(value = "按主键删除账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = UserServiceProxy.DELETE)
    @PostMapping(UserServiceProxy.DELETE)
    public Result<User> deleteById(String id) {
        return userService.deleteByIdLogical(id);
    }

    /**
     * 批量删除账户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = UserServiceProxy.BATCH_DELETE)
    @PostMapping(UserServiceProxy.BATCH_DELETE)
    public Result deleteByIds(List<String> ids) {
        Result result = userService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新账户
     */
    @ApiOperation(value = "更新账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD, value = "密码", required = true, dataTypeClass = String.class, example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY, value = "缓存键", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME, value = "最后登录时间", required = false, dataTypeClass = Date.class, example = "2021-05-31 03:09:23"),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { UserVOMeta.PAGE_INDEX, UserVOMeta.PAGE_SIZE, UserVOMeta.SEARCH_FIELD, UserVOMeta.SEARCH_VALUE, UserVOMeta.IDS })
    @SentinelResource(value = UserServiceProxy.UPDATE)
    @PostMapping(UserServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(UserVO userVO) {
        Result result = userService.update(userVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 更新账户
     */
    @ApiOperation(value = "更新账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { UserVOMeta.PAGE_INDEX, UserVOMeta.PAGE_SIZE, UserVOMeta.SEARCH_FIELD, UserVOMeta.SEARCH_VALUE, UserVOMeta.IDS })
    @SentinelResource(value = UserServiceProxy.UPDATE_PROFILE)
    @PostMapping(UserServiceProxy.UPDATE_PROFILE)
    public Result updateProfile(UserVO userVO) {
        User user = userService.getById(this.getSessionUserId());
        if (user == null) {
            return ErrorDesc.failure().message("保存失败，账户无效");
        }
        user.setRealName(userVO.getRealName());
        user.setPhone(userVO.getPhone());
        user.setPortraitId(userVO.getPortraitId());
        user.setLanguage(userVO.getLanguage());
        Result result = userService.update(user, SaveMode.DIRTY_FIELDS);
        user.setPasswd("******");
        Language language=Language.parseByCode(userVO.getLanguage());
        LangServiceProxy.api().switchLanguage(language.code());
        return result.data(user);
    }

    /**
     * 保存账户
     */
    @ApiOperation(value = "保存账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD, value = "密码", required = true, dataTypeClass = String.class, example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY, value = "缓存键", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME, value = "最后登录时间", required = false, dataTypeClass = Date.class, example = "2021-05-31 03:09:23"),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { UserVOMeta.PAGE_INDEX, UserVOMeta.PAGE_SIZE, UserVOMeta.SEARCH_FIELD, UserVOMeta.SEARCH_VALUE, UserVOMeta.IDS })
    @SentinelResource(value = UserServiceProxy.SAVE)
    @PostMapping(UserServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result<User> save(UserVO userVO) {
        Result result = userService.save(userVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取账户
     */
    @ApiOperation(value = "按主键获取账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = UserServiceProxy.GET_BY_ID)
    @PostMapping(UserServiceProxy.GET_BY_ID)
    public Result<User> getById(String id) {
        // IUserService userService=ServiceHub.get(IUserService.class,false);
        Result<User> result = new Result<>();
        User role = userService.getById(id);
        result.success(true).data(role);
        return result;
    }

    /**
     * 获取账户
     */
    @ApiOperation(value = "获取账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "leefj")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = UserServiceProxy.GET_BY_ACCOUNT)
    @PostMapping(UserServiceProxy.GET_BY_ACCOUNT)
    public Result<User> getByAccount(String account) {
        Result<User> result = new Result<>();
        User user = new User();
        user.setAccount(account);
        user = userService.queryEntity(user);
        result.success(true).data(user);
        return result;
    }

    /**
     * 获取账户
     */
    @ApiOperation(value = "获取多个账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.IDS, value = "主键集合", required = true, dataTypeClass = String.class, example = "['1','2','3']")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = UserServiceProxy.GET_BY_IDS)
    @PostMapping(UserServiceProxy.GET_BY_IDS)
    public Result<List<User>> getByIds(List<String> ids) {
        Result<List<User>> result = new Result<>();
        List<User> users = userService.getByIds(ids);
        result.success(true).data(users);
        return result;
    }

    /**
     * 获取账户
     */
    @ApiOperation(value = "获取当前登录账户")
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = UserServiceProxy.GET_SESSION_USER_URI)
    @PostMapping(UserServiceProxy.GET_SESSION_USER_URI)
    public Result<SessionUser> getSessionUser(String sessionId) {
        Result<SessionUser> result = new Result<>();
        SessionUser user = sessionCache.get(sessionId);
        result.data(user);
        return result;
    }

    /**
     * 查询账户
     */
    @ApiOperation(value = "查询账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD, value = "密码", required = true, dataTypeClass = String.class, example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY, value = "缓存键", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME, value = "最后登录时间", required = false, dataTypeClass = Date.class, example = "2021-05-31 03:09:23"),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { UserVOMeta.PAGE_INDEX, UserVOMeta.PAGE_SIZE })
    @SentinelResource(value = UserServiceProxy.QUERY_LIST)
    @PostMapping(UserServiceProxy.QUERY_LIST)
    public Result<List<User>> queryList(UserVO sample) {
        Result<List<User>> result = new Result<>();
        List<User> list = userService.queryList(sample);
        for (User user : list) {
            user.setPasswd("");
        }
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询账户
     */
    @ApiOperation(value = "分页查询账户")
    @ApiImplicitParams({
		@ApiImplicitParam(name = UserVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class, example = "110588348101165000"),
		@ApiImplicitParam(name = UserVOMeta.ACCOUNT, value = "账户", required = true, dataTypeClass = String.class, example = "admin"),
		@ApiImplicitParam(name = UserVOMeta.REAL_NAME, value = "姓名", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PASSWD, value = "密码", required = true, dataTypeClass = String.class, example = "******"),
		@ApiImplicitParam(name = UserVOMeta.PHONE, value = "手机号码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.PORTRAIT_ID, value = "头像ID", required = false, dataTypeClass = String.class, example = "1110"),
		@ApiImplicitParam(name = UserVOMeta.LANGUAGE, value = "语言", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.VALID, value = "是否有效", required = true, dataTypeClass = Integer.class, example = "1"),
		@ApiImplicitParam(name = UserVOMeta.CACHE_KEY, value = "缓存键", required = false, dataTypeClass = String.class, example = "443c1"),
		@ApiImplicitParam(name = UserVOMeta.LAST_LOGIN_TIME, value = "最后登录时间", required = false, dataTypeClass = Date.class, example = "2022-04-19 02:57:10"),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = UserVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = UserServiceProxy.QUERY_PAGED_LIST)
    @PostMapping(UserServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<User>> queryPagedList(UserVO sample) {
        RequestParameter requestParameter = this.getParameter();
        Logger.info(requestParameter.getRequestTimeString() + "," + requestParameter.getRequestTimestamp());
        Result<PagedList<User>> result = new Result<>();
        PerformanceLogger pl = new PerformanceLogger(true);
        pl.collect("A");
        PagedList<User> list = userService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        pl.collect("B");
        for (User user : list) {
            user.setPasswd("");
        }
        pl.collect("C");
        DAO dao = userService.dao();
        FieldsBuilder roleFields = FieldsBuilder.build(dao, FoxnicWeb.SYS_ROLE.$TABLE).addAll().removeDBTreatyFields();
        FieldsBuilder employeeFields = FieldsBuilder.build(dao, FoxnicWeb.HRM_EMPLOYEE.$TABLE).addAll().removeDBTreatyFields();
        FieldsBuilder personFields = FieldsBuilder.build(dao, FoxnicWeb.HRM_PERSON.$TABLE).addAll().removeDBTreatyFields();
        FieldsBuilder tenantFields = FieldsBuilder.build(dao, FoxnicWeb.SYS_TENANT.$TABLE).addAll().removeDBTreatyFields();
        FieldsBuilder userTenantFields = FieldsBuilder.build(dao, FoxnicWeb.SYS_USER_TENANT.$TABLE).addAll().removeDBTreatyFields();
        pl.collect("D");
        // 填充账户模型
        userService.dao().fill(list).with(UserMeta.ROLES).with(UserMeta.JOINED_TENANTS, UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON).fields(roleFields, employeeFields, personFields, tenantFields, userTenantFields).execute();
        // pl.collect("Start Clone");
        // int z=0;
        // List<User> users=new ArrayList<>();
        // for (User user : list) {
        // for (int i = 0; i < 1000; i++) {
        // //				User user1=new User();
        // User u=user.duplicate(false);
        // users.add(u);
        // z++;
        // }
        // }
        // pl.collect("End Clone 克隆 "+z+" 次");
        // // 暂时如此修复一下
        // for (User user : list) {
        // user.setActivatedTenant(null);
        // user.setCompositeParameter(null);
        // if(user.getRoles()!=null) {
        // for (Role role : user.getRoles()) {
        // role.setMenus(null);
        // }
        // }
        // }
        pl.collect("E");
        result.success(true).data(list);
        pl.collect("F");
        pl.info("queryPagedList");
        return result;
    }

    @ApiOperation(value = "更改当前登录用户密码")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "oldpwd", value = "原始密码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = "newpwd", value = "新密码", required = true, dataTypeClass = String.class)
	})
    @PostMapping(UserServiceProxy.CHANGE_PASSWD)
    @ApiOperationSupport(order = 4)
    public Result changePasswd(String oldpwd, String newpwd) {
        return userService.changePasswd(this.getSessionUserId(), oldpwd, newpwd);
    }

    @ApiOperation(value = "管理员重置用户密码")
    @ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "账户ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = "adminPwd", value = "管理员密码", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = "pwd", value = "新密码", required = true, dataTypeClass = String.class)
	})
    @PostMapping(UserServiceProxy.RESET_PASSWD)
    @ApiOperationSupport(order = 4)
    public Result resetPasswd(String userId, String adminPwd, String pwd) {
        for (int i = 0; i < 4; i++) {
            adminPwd = Base64Util.decode(adminPwd);
            pwd = Base64Util.decode(pwd);
        }
        return userService.resetPasswd(userId, adminPwd, pwd);
    }

    /**
     * 获得系统默认的登录页地址
     */
    @ApiOperation(value = "获得系统默认的登录页地址")
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = UserServiceProxy.GET_SYSTEM_LOGIN_PAGE)
    @PostMapping(UserServiceProxy.GET_SYSTEM_LOGIN_PAGE)
    public Result<String> getSystemLoginPage() {
        Result<String> result = new Result<>();
        return result.success(true).data(securityProperties.getLoginPage());
    }
}
