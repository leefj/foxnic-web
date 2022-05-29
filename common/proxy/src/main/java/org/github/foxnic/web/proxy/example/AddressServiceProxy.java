package org.github.foxnic.web.proxy.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.AddressVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 07:30:45
 */
@FeignClient(value = MicroServiceNames.EXAMPLE, contextId = AddressServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AddressServiceProxy {

    /**
     * 基础路径 , service-example
     */
    public static final String API_BASIC_PATH = "service-example";

    /**
     * API 上下文路径 , example-address
     */
    public static final String API_CONTEXT_PATH = "example-address";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加example_address
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除example_address
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除example_address
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新example_address
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存example_address
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个example_address
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个example_address
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询example_address
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询example_address
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出example_address数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载example_address导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入example_address数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加example_address
     */
    @RequestMapping(AddressServiceProxy.INSERT)
    Result insert(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 删除example_address
     */
    @RequestMapping(AddressServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除example_address
     */
    @RequestMapping(AddressServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新example_address
     */
    @RequestMapping(AddressServiceProxy.UPDATE)
    Result update(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 更新example_address
     */
    @RequestMapping(AddressServiceProxy.SAVE)
    Result save(@RequestParam(name = "addressVO") AddressVO addressVO);

    /**
     * 获取example_address
     */
    @RequestMapping(AddressServiceProxy.GET_BY_ID)
    Result<Address> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个example_address
     */
    @RequestMapping(AddressServiceProxy.GET_BY_IDS)
    Result<List<Address>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询example_address
     */
    @RequestMapping(AddressServiceProxy.QUERY_LIST)
    Result<List<Address>> queryList(@RequestParam(name = "sample") AddressVO sample);

    /**
     * 分页查询example_address
     */
    @RequestMapping(AddressServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Address>> queryPagedList(@RequestParam(name = "sample") AddressVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.example.controller.AddressController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AddressServiceProxy api() {
        return APIProxy.get(AddressServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
