package org.github.foxnic.web.proxy.changes;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.changes.ExampleOrder;
import org.github.foxnic.web.domain.changes.ExampleOrderVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 变更示例订单表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 11:04:38
 * @version
 */
@FeignClient(value = MicroServiceNames.CHS, contextId = ExampleOrderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ExampleOrderServiceProxy {

    /**
     * 基础路径 , service-changes
     */
    public static final String API_BASIC_PATH = "service-changes";

    /**
     * API 上下文路径 , chs-example-order
     */
    public static final String API_CONTEXT_PATH = "chs-example-order";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加变更示例订单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除变更示例订单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除变更示例订单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新变更示例订单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存变更示例订单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个变更示例订单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个变更示例订单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 启动流程审批
     */
    public static final String START_PROCESS = API_PREFIX + "start-process";

    /**
     * 节点审批
     */
    public static final String APPROVE = API_PREFIX + "approve";

    /**
     * 查询变更示例订单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询变更示例订单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出变更示例订单数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载变更示例订单导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入变更示例订单数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.INSERT)
    @ParameterNames(value = {"exampleOrderVO"})
    Result insert(ExampleOrderVO exampleOrderVO);

    /**
     * 删除变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.UPDATE)
    @ParameterNames(value = {"exampleOrderVO"})
    Result update(ExampleOrderVO exampleOrderVO);

    /**
     * 更新变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.SAVE)
    @ParameterNames(value = {"exampleOrderVO"})
    Result save(ExampleOrderVO exampleOrderVO);

    /**
     * 获取变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<ExampleOrder> getById(String id);

    /**
     * 批量删除变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<ExampleOrder>> getByIds(List<String> ids);

    /**
     * 查询变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<ExampleOrder>> queryList(ExampleOrderVO sample);

    /**
     * 分页查询变更示例订单
     */
    @RequestMapping(ExampleOrderServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<ExampleOrder>> queryPagedList(ExampleOrderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.changes.controller.ExampleOrderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ExampleOrderServiceProxy api() {
        return APIProxy.get(ExampleOrderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
