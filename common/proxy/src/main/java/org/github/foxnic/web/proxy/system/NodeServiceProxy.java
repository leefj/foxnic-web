package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.Node;
import org.github.foxnic.web.domain.system.NodeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-11 17:11:20
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = NodeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface NodeServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-node
     */
    public static final String API_CONTEXT_PATH = "sys-node";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加sys_node
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除sys_node
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除sys_node
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新sys_node
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存sys_node
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个sys_node
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个sys_node
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询sys_node
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询sys_node
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出sys_node数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载sys_node导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入sys_node数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加sys_node
     */
    @RequestMapping(NodeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "nodeVO") NodeVO nodeVO);

    /**
     * 删除sys_node
     */
    @RequestMapping(NodeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除sys_node
     */
    @RequestMapping(NodeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新sys_node
     */
    @RequestMapping(NodeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "nodeVO") NodeVO nodeVO);

    /**
     * 更新sys_node
     */
    @RequestMapping(NodeServiceProxy.SAVE)
    Result save(@RequestParam(name = "nodeVO") NodeVO nodeVO);

    /**
     * 获取sys_node
     */
    @RequestMapping(NodeServiceProxy.GET_BY_ID)
    Result<Node> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除sys_node
     */
    @RequestMapping(NodeServiceProxy.GET_BY_IDS)
    Result<List<Node>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询sys_node
     */
    @RequestMapping(NodeServiceProxy.QUERY_LIST)
    Result<List<Node>> queryList(@RequestParam(name = "sample") NodeVO sample);

    /**
     * 分页查询sys_node
     */
    @RequestMapping(NodeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Node>> queryPagedList(@RequestParam(name = "sample") NodeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.NodeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static NodeServiceProxy api() {
        return APIProxy.get(NodeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
