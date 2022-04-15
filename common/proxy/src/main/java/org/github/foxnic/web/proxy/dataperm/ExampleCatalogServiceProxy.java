package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.dataperm.ExampleCatalog;
import org.github.foxnic.web.domain.dataperm.ExampleCatalogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 商品分类表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-02 14:49:27
 */
@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = ExampleCatalogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ExampleCatalogServiceProxy {

    /**
     * 基础路径 , service-dataperm
     */
    public static final String API_BASIC_PATH = "service-dataperm";

    /**
     * API 上下文路径 , dp-example-catalog
     */
    public static final String API_CONTEXT_PATH = "dp-example-catalog";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商品分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商品分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商品分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商品分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商品分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商品分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商品分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商品分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商品分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出商品分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载商品分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入商品分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "exampleCatalogVO") ExampleCatalogVO exampleCatalogVO);

    /**
     * 删除商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "exampleCatalogVO") ExampleCatalogVO exampleCatalogVO);

    /**
     * 更新商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.SAVE)
    Result save(@RequestParam(name = "exampleCatalogVO") ExampleCatalogVO exampleCatalogVO);

    /**
     * 获取商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.GET_BY_ID)
    Result<ExampleCatalog> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.GET_BY_IDS)
    Result<List<ExampleCatalog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.QUERY_LIST)
    Result<List<ExampleCatalog>> queryList(@RequestParam(name = "sample") ExampleCatalogVO sample);

    /**
     * 分页查询商品分类
     */
    @RequestMapping(ExampleCatalogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ExampleCatalog>> queryPagedList(@RequestParam(name = "sample") ExampleCatalogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.dataperm.controller.ExampleCatalogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ExampleCatalogServiceProxy api() {
        return APIProxy.get(ExampleCatalogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
