package org.github.foxnic.web.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.example.OrderItem;
import org.github.foxnic.web.domain.example.OrderItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 06:30:54
 */
@FeignClient(value = MicroServiceNames.EXAMPLE, contextId = OrderItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface OrderItemServiceProxy {

    /**
     * 基础路径 , service-example
     */
    public static final String API_BASIC_PATH = "service-example";

    /**
     * API 上下文路径 , example-order-item
     */
    public static final String API_CONTEXT_PATH = "example-order-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加example_order_item
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除example_order_item
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除example_order_item
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新example_order_item
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存example_order_item
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个example_order_item
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个example_order_item
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询example_order_item
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询example_order_item
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出example_order_item数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载example_order_item导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入example_order_item数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 删除example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 更新example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "orderItemVO") OrderItemVO orderItemVO);

    /**
     * 获取example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.GET_BY_ID)
    Result<OrderItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.GET_BY_IDS)
    Result<List<OrderItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.QUERY_LIST)
    Result<List<OrderItem>> queryList(@RequestParam(name = "sample") OrderItemVO sample);

    /**
     * 分页查询example_order_item
     */
    @RequestMapping(OrderItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<OrderItem>> queryPagedList(@RequestParam(name = "sample") OrderItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.example.controller.OrderItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static OrderItemServiceProxy api() {
        return APIProxy.get(OrderItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
