package org.github.foxnic.web.proxy.oauth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.oauth.MenuFork;
import org.github.foxnic.web.domain.oauth.MenuForkVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 菜单功能分版本实现配置 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-01-31 13:11:20
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = MenuForkServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MenuForkServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-menu-fork
     */
    public static final String API_CONTEXT_PATH = "sys-menu-fork";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加菜单功能分版本实现配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除菜单功能分版本实现配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除菜单功能分版本实现配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新菜单功能分版本实现配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存菜单功能分版本实现配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个菜单功能分版本实现配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个菜单功能分版本实现配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询菜单功能分版本实现配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询菜单功能分版本实现配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.INSERT)
    Result insert(@RequestParam(name = "menuForkVO") MenuForkVO menuForkVO);

    /**
     * 删除菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.UPDATE)
    Result update(@RequestParam(name = "menuForkVO") MenuForkVO menuForkVO);

    /**
     * 更新菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.SAVE)
    Result save(@RequestParam(name = "menuForkVO") MenuForkVO menuForkVO);

    /**
     * 获取菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.GET_BY_ID)
    Result<MenuFork> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.GET_BY_IDS)
    Result<List<MenuFork>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.QUERY_LIST)
    Result<List<MenuFork>> queryList(@RequestParam(name = "sample") MenuForkVO sample);

    /**
     * 分页查询菜单功能分版本实现配置
     */
    @RequestMapping(MenuForkServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MenuFork>> queryPagedList(@RequestParam(name = "sample") MenuForkVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.MenuForkController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MenuForkServiceProxy api() {
        return APIProxy.get(MenuForkServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
