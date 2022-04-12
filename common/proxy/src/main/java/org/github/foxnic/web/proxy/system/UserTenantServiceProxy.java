package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.UserTenant;
import org.github.foxnic.web.domain.system.UserTenantVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 账户租户关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-06 15:56:15
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
     * 导出账户租户关系数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载账户租户关系导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入账户租户关系数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.INSERT)
    @ParameterNames(value = {"userTenantVO"})
    Result insert(UserTenantVO userTenantVO);

    /**
     * 删除账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.UPDATE)
    @ParameterNames(value = {"userTenantVO"})
    Result update(UserTenantVO userTenantVO);

    /**
     * 更新账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.SAVE)
    @ParameterNames(value = {"userTenantVO"})
    Result save(UserTenantVO userTenantVO);

    /**
     * 获取账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<UserTenant> getById(String id);

    /**
     * 获取多个账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<UserTenant>> getByIds(List<String> ids);

    /**
     * 查询账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<UserTenant>> queryList(UserTenantVO sample);

    /**
     * 分页查询账户租户关系
     */
    @RequestMapping(UserTenantServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<UserTenant>> queryPagedList(UserTenantVO sample);

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
