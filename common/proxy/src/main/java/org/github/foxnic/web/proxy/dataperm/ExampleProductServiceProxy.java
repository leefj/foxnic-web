package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import org.github.foxnic.web.domain.dataperm.ExampleProductVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 销售订单表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:38
 */
@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = ExampleProductServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ExampleProductServiceProxy {

    /**
     * 基础路径 , service-dataperm
     */
    public static final String API_BASIC_PATH = "service-dataperm";

    /**
     * API 上下文路径 , dp-example-product
     */
    public static final String API_CONTEXT_PATH = "dp-example-product";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加销售订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除销售订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除销售订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新销售订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存销售订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个销售订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个销售订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询销售订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询销售订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.INSERT)
    Result insert(@RequestParam(name = "exampleProductVO") ExampleProductVO exampleProductVO);

    /**
     * 删除销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.UPDATE)
    Result update(@RequestParam(name = "exampleProductVO") ExampleProductVO exampleProductVO);

    /**
     * 更新销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.SAVE)
    Result save(@RequestParam(name = "exampleProductVO") ExampleProductVO exampleProductVO);

    /**
     * 获取销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.GET_BY_ID)
    Result<ExampleProduct> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.GET_BY_IDS)
    Result<List<ExampleProduct>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.QUERY_LIST)
    Result<List<ExampleProduct>> queryList(@RequestParam(name = "sample") ExampleProductVO sample);

    /**
     * 分页查询销售订单
     */
    @RequestMapping(ExampleProductServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ExampleProduct>> queryPagedList(@RequestParam(name = "sample") ExampleProductVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.dataperm.controller.ExampleProductController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ExampleProductServiceProxy api() {
        return APIProxy.get(ExampleProductServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
