package org.github.foxnic.web.proxy.hrm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItem;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItemVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 常用人员分组条目表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-20 06:14:04
 * @version
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = FavouriteGroupItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FavouriteGroupItemServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-favourite-group-item
     */
    public static final String API_CONTEXT_PATH = "hrm-favourite-group-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加常用人员分组条目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 批量添加常用人员分组条目
     */
    public static final String INSERTS = API_PREFIX + "inserts";

    /**
     * 清除常用人员分组条目
     */
    public static final String REMOVE_ALL = API_PREFIX + "remove-all";

    /**
     * 删除常用人员分组条目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除常用人员分组条目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新常用人员分组条目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存常用人员分组条目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个常用人员分组条目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个常用人员分组条目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询常用人员分组条目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询常用人员分组条目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出常用人员分组条目数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载常用人员分组条目导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入常用人员分组条目数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "favouriteGroupItemVO") FavouriteGroupItemVO favouriteGroupItemVO);

    /**
     * 删除常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "favouriteGroupItemVO") FavouriteGroupItemVO favouriteGroupItemVO);

    /**
     * 更新常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "favouriteGroupItemVO") FavouriteGroupItemVO favouriteGroupItemVO);

    /**
     * 获取常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.GET_BY_ID)
    Result<FavouriteGroupItem> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.GET_BY_IDS)
    Result<List<FavouriteGroupItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.QUERY_LIST)
    Result<List<FavouriteGroupItem>> queryList(@RequestParam(name = "sample") FavouriteGroupItemVO sample);

    /**
     * 分页查询常用人员分组条目
     */
    @RequestMapping(FavouriteGroupItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FavouriteGroupItem>> queryPagedList(@RequestParam(name = "sample") FavouriteGroupItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.FavouriteGroupItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FavouriteGroupItemServiceProxy api() {
        return APIProxy.get(FavouriteGroupItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
