package org.github.foxnic.web.proxy.oauth;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.RoleUser;
import org.github.foxnic.web.domain.oauth.RoleUserVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 角色账户关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:03
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = RoleUserServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RoleUserServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-role-user
     */
    public static final String API_CONTEXT_PATH = "sys-role-user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加角色账户关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除角色账户关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除角色账户关系
     */
    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";

    /**
     * 更新角色账户关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存角色账户关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取角色账户关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 查询角色账户关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询角色账户关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出角色账户关系数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 导入角色账户关系数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.INSERT)
    Result insert(@RequestParam(name = "roleUserVO") RoleUserVO roleUserVO);

    /**
     * 删除角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.BATCH_DELETE)
    Result deleteByIds(@RequestParam(name = "id") List<String> id);

    /**
     * 更新角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.UPDATE)
    Result update(@RequestParam(name = "roleUserVO") RoleUserVO roleUserVO);

    /**
     * 更新角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.SAVE)
    Result save(@RequestParam(name = "roleUserVO") RoleUserVO roleUserVO);

    /**
     * 获取角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.GET_BY_ID)
    Result<RoleUser> getById(@RequestParam(name = "id") String id);

    /**
     * 查询角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.QUERY_LIST)
    Result<List<RoleUser>> queryList(@RequestParam(name = "sample") RoleUserVO sample);

    /**
     * 分页查询角色账户关系
     */
    @RequestMapping(RoleUserServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RoleUser>> queryPagedList(@RequestParam(name = "sample") RoleUserVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.RoleUserController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RoleUserServiceProxy api() {
        return APIProxy.get(RoleUserServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
