package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.hrm.FavouriteGroup;
import org.github.foxnic.web.domain.hrm.FavouriteGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 常用人员分组表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-30 08:56:31
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
     * 导出常用人员分组数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载常用人员分组导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入常用人员分组数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.INSERT)
    @ParameterNames(value = {"favouriteGroupVO"})
    Result insert(FavouriteGroupVO favouriteGroupVO);

    /**
     * 删除常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.UPDATE)
    @ParameterNames(value = {"favouriteGroupVO"})
    Result update(FavouriteGroupVO favouriteGroupVO);

    /**
     * 更新常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.SAVE)
    @ParameterNames(value = {"favouriteGroupVO"})
    Result save(FavouriteGroupVO favouriteGroupVO);

    /**
     * 获取常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<FavouriteGroup> getById(String id);

    /**
     * 批量删除常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<FavouriteGroup>> getByIds(List<String> ids);

    /**
     * 查询常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<FavouriteGroup>> queryList(FavouriteGroupVO sample);

    /**
     * 分页查询常用人员分组
     */
    @RequestMapping(FavouriteGroupServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<FavouriteGroup>> queryPagedList(FavouriteGroupVO sample);

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
