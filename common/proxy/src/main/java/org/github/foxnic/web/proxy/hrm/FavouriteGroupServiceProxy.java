package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.hrm.FavouriteGroup;
import org.github.foxnic.web.domain.hrm.FavouriteGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 常用人员分组表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:24:59
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = FavouriteGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FavouriteGroupServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-favourite-group
     */
    public static final String API_CONTEXT_PATH = "hrm-favourite-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加常用人员分组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除常用人员分组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除常用人员分组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新常用人员分组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存常用人员分组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个常用人员分组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个常用人员分组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询常用人员分组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询常用人员分组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "favouriteGroupVO") FavouriteGroupVO favouriteGroupVO);

    /**
     * 删除常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "favouriteGroupVO") FavouriteGroupVO favouriteGroupVO);

    /**
     * 更新常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "favouriteGroupVO") FavouriteGroupVO favouriteGroupVO);

    /**
     * 获取常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.GET_BY_ID)
    Result<FavouriteGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.GET_BY_IDS)
    Result<List<FavouriteGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.QUERY_LIST)
    Result<List<FavouriteGroup>> queryList(@RequestParam(name = "sample") FavouriteGroupVO sample);

    /**
     * 分页查询常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FavouriteGroup>> queryPagedList(@RequestParam(name = "sample") FavouriteGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.FavouriteGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FavouriteGroupServiceProxy api() {
        return APIProxy.get(FavouriteGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
