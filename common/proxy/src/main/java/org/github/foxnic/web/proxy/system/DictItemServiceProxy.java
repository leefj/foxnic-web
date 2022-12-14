package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 数据字典条目  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-20 01:06:36
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = DictItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DictItemServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-dict-item
     */
    public static final String API_CONTEXT_PATH = "sys-dict-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据字典条目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据字典条目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据字典条目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据字典条目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据字典条目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据字典条目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据字典条目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据字典条目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据字典条目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出数据字典条目数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载数据字典条目导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入数据字典条目数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dictItemVO") DictItemVO dictItemVO);

    /**
     * 删除数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dictItemVO") DictItemVO dictItemVO);

    /**
     * 更新数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "dictItemVO") DictItemVO dictItemVO);

    /**
     * 获取数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.GET_BY_ID)
    Result<DictItem> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.GET_BY_IDS)
    Result<List<DictItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.QUERY_LIST)
    Result<List<DictItem>> queryList(@RequestParam(name = "sample") DictItemVO sample);

    /**
     * 分页查询数据字典条目
     */
    @RequestMapping(DictItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DictItem>> queryPagedList(@RequestParam(name = "sample") DictItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.DictItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DictItemServiceProxy api() {
        return APIProxy.get(DictItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
