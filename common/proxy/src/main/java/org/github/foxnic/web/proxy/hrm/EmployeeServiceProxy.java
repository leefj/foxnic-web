package org.github.foxnic.web.proxy.hrm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 员工表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-15 16:24:05
 * @version
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = EmployeeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface EmployeeServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-employee
     */
    public static final String API_CONTEXT_PATH = "hrm-employee";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加员工
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除员工
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除员工
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新员工
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存员工
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个员工
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个员工
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 获取单个员工
     */
    public static final String GET_BY_BADGE = API_PREFIX + "get-by-badge";

    /**
     * 获取多个员工
     */
    public static final String GET_BY_BADGES = API_PREFIX + "get-by-badges";

    /**
     * 查询员工
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询员工
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出员工数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载员工导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入员工数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加员工
     */
    @RequestMapping(EmployeeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "employeeVO") EmployeeVO employeeVO);

    /**
     * 删除员工
     */
    @RequestMapping(EmployeeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除员工
     */
    @RequestMapping(EmployeeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新员工
     */
    @RequestMapping(EmployeeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "employeeVO") EmployeeVO employeeVO);

    /**
     * 更新员工
     */
    @RequestMapping(EmployeeServiceProxy.SAVE)
    Result save(@RequestParam(name = "employeeVO") EmployeeVO employeeVO);

    /**
     * 获取员工
     */
    @RequestMapping(EmployeeServiceProxy.GET_BY_ID)
    Result<Employee> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除员工
     */
    @RequestMapping(EmployeeServiceProxy.GET_BY_IDS)
    Result<List<Employee>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 获取员工
     */
    @RequestMapping(EmployeeServiceProxy.GET_BY_BADGE)
    Result<Employee> getByBadge(@RequestParam(name = "badge") String badge);

    /**
     * 批量删除员工
     */
    @RequestMapping(EmployeeServiceProxy.GET_BY_BADGES)
    Result<List<Employee>> getByBadges(@RequestParam(name = "badges") List<String> badges);

    /**
     * 查询员工
     */
    @RequestMapping(EmployeeServiceProxy.QUERY_LIST)
    Result<List<Employee>> queryList(@RequestParam(name = "sample") EmployeeVO sample);

    /**
     * 分页查询员工
     */
    @RequestMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Employee>> queryPagedList(@RequestParam(name = "sample") EmployeeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.EmployeeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static EmployeeServiceProxy api() {
        return APIProxy.get(EmployeeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
