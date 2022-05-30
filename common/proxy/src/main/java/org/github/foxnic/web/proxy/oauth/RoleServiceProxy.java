package org.github.foxnic.web.proxy.oauth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 角色表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-06 16:52:11
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = RoleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RoleServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-role
     */
    public static final String API_CONTEXT_PATH = "sys-role";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加角色
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除角色
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除角色
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新角色
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存角色
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个角色
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个角色
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询角色
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询角色
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出角色数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载角色导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入角色数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加角色
     */
    @RequestMapping(RoleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "roleVO") RoleVO roleVO);

    /**
     * 删除角色
     */
    @RequestMapping(RoleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除角色
     */
    @RequestMapping(RoleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新角色
     */
    @RequestMapping(RoleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "roleVO") RoleVO roleVO);

    /**
     * 更新角色
     */
    @RequestMapping(RoleServiceProxy.SAVE)
    Result save(@RequestParam(name = "roleVO") RoleVO roleVO);

    /**
     * 获取角色
     */
    @RequestMapping(RoleServiceProxy.GET_BY_ID)
    Result<Role> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除角色
     */
    @RequestMapping(RoleServiceProxy.GET_BY_IDS)
    Result<List<Role>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询角色
     */
    @RequestMapping(RoleServiceProxy.QUERY_LIST)
    Result<List<Role>> queryList(@RequestParam(name = "sample") RoleVO sample);

    /**
     * 分页查询角色
     */
    @RequestMapping(RoleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Role>> queryPagedList(@RequestParam(name = "sample") RoleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.RoleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RoleServiceProxy api() {
        return APIProxy.get(RoleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
