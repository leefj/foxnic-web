package org.github.foxnic.web.proxy.oauth;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = UserServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface UserServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-user
     */
    public static final String API_CONTEXT_PATH = "sys-user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加账户
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除账户
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除账户
     */
    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";

    /**
     * 更新账户
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 更新账户
     */
    public static final String UPDATE_PROFILE = API_PREFIX + "update-profile";

    /**
     * 保存账户
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取账户
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取账户
     */
    public static final String GET_BY_ACCOUNT = API_PREFIX + "get-by-account";

    /**
     * 获取账户
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询账户
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询账户
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出账户数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 导入账户数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 更改密码
     */
    public static final String CHANGE_PASSWD = API_PREFIX + "change-passwd";

    /**
     * 重置密码
     */
    public static final String RESET_PASSWD = API_PREFIX + "reset-passwd";

    /**
     * 添加账户
     */
    @RequestMapping(UserServiceProxy.INSERT)
    Result insert(@RequestParam(name = "userVO") UserVO userVO);

    /**
     * 删除账户
     */
    @RequestMapping(UserServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除账户
     */
    @RequestMapping(UserServiceProxy.BATCH_DELETE)
    Result deleteByIds(@RequestParam(name = "id") List<String> id);

    /**
     * 更新账户
     */
    @RequestMapping(UserServiceProxy.UPDATE)
    Result update(@RequestParam(name = "userVO") UserVO userVO);

    /**
     * 更新账户
     */
    @RequestMapping(UserServiceProxy.SAVE)
    Result save(@RequestParam(name = "userVO") UserVO userVO);

    /**
     * 获取账户
     */
    @RequestMapping(UserServiceProxy.GET_BY_ID)
    Result<User> getById(@RequestParam(name = "id") String id);

    @RequestMapping(UserServiceProxy.GET_BY_ACCOUNT)
    Result<User> getByAccount(@RequestParam(name = "account") String account);

    /**
     * 获取账户
     */
    @RequestMapping(UserServiceProxy.GET_BY_IDS)
    Result<List<User>> getByIds(@RequestParam(name = "ids") List<String> ids);


    /**
     * 查询账户
     */
    @RequestMapping(value = UserServiceProxy.QUERY_LIST)
    Result<List<User>> queryList(@RequestParam(name = "sample") UserVO sample);

    /**
     * 分页查询账户
     */
    @RequestMapping(UserServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<User>> queryPagedList(@RequestParam(name = "sample") UserVO sample);

    /**
     * 获得会话信息
     */
    @RequestMapping(UserServiceProxy.GET_SESSION_USER_URI)
    Result<SessionUser> getSessionUser(String sessionId);

    @RequestMapping(UserServiceProxy.GET_SYSTEM_LOGIN_PAGE)
    Result<String> getSystemLoginPage();

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.UserController";

    /**
     * 帐号密码登录
     */
    public static final String LOGIN_URI = "/security/login";


    /**
     * 单点登录地址
     */
    public static final String SSO_LOGIN_URI = "/security/sso-login.html";

    /**
     * 帐号密码登录
     */
    public static final String GET_SESSION_USER_URI = "/security/get-session-user";

    /**
     * 验证码登录
     */
    public static final String LOGIN_BY_CAPTCHA_URI = "/security/login_by_captcha";

    /**
     * 账户登出
     */
    public static final String LOGOUT_URI = "/security/logout";

    public static final String GET_SYSTEM_LOGIN_PAGE = "/security/get-system-login-page";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static UserServiceProxy api() {
        return APIProxy.get(UserServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
