package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.domain.system.UserTenantVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 账户租户关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:43
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = UserTenantServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface UserTenantServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-user-tenant
     */
    public static final String API_CONTEXT_PATH = "sys-user-tenant";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加账户租户关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除账户租户关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除账户租户关系
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新账户租户关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存账户租户关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个账户租户关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个账户租户关系
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询账户租户关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询账户租户关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.INSERT)
    Result insert(@RequestParam(name = "userTenantVO") UserTenantVO userTenantVO);

    /**
     * 删除账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.UPDATE)
    Result update(@RequestParam(name = "userTenantVO") UserTenantVO userTenantVO);

    /**
     * 更新账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.SAVE)
    Result save(@RequestParam(name = "userTenantVO") UserTenantVO userTenantVO);

    /**
     * 获取账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.GET_BY_ID)
    Result<UserTenant> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.GET_BY_IDS)
    Result<List<UserTenant>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.QUERY_LIST)
    Result<List<UserTenant>> queryList(@RequestParam(name = "sample") UserTenantVO sample);

    /**
     * 分页查询账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<UserTenant>> queryPagedList(@RequestParam(name = "sample") UserTenantVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.UserTenantController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static UserTenantServiceProxy api() {
        return APIProxy.get(UserTenantServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
