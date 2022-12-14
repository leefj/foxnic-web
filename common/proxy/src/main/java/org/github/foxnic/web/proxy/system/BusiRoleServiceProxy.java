package org.github.foxnic.web.proxy.system;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.BusiRoleVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 业务角色表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-15 14:49:46
 * @version
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = BusiRoleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BusiRoleServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-busi-role
     */
    public static final String API_CONTEXT_PATH = "sys-busi-role";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加业务角色
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除业务角色
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除业务角色
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新业务角色
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存业务角色
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个业务角色
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取单个业务角色
     */
    public static final String GET_BY_CODES = API_PREFIX + "get-by-codes";

    /**
     * 获取员工对应的业务员角色
     */
    public static final String GET_EMPLOYEE_ROLES = API_PREFIX + "get-employee-roles";

    /**
     * 获取多个业务角色
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询业务角色
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询业务角色
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出业务角色数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载业务角色导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入业务角色数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "busiRoleVO") BusiRoleVO busiRoleVO);

    /**
     * 删除业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "busiRoleVO") BusiRoleVO busiRoleVO);

    /**
     * 更新业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.SAVE)
    Result save(@RequestParam(name = "busiRoleVO") BusiRoleVO busiRoleVO);

    /**
     * 获取业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.GET_BY_ID)
    Result<BusiRole> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.GET_BY_IDS)
    Result<List<BusiRole>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 获取员工对应的业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.GET_EMPLOYEE_ROLES)
    Result<List<BusiRole>> getEmployeeRoles(@RequestParam(name = "employeeId") String employeeId);

    /**
     * 批量删除业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.GET_BY_CODES)
    Result<List<BusiRole>> getByCodes(@RequestParam(name = "codes") List<String> codes);

    /**
     * 查询业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.QUERY_LIST)
    Result<List<BusiRole>> queryList(@RequestParam(name = "sample") BusiRoleVO sample);

    /**
     * 分页查询业务角色
     */
    @RequestMapping(BusiRoleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BusiRole>> queryPagedList(@RequestParam(name = "sample") BusiRoleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.BusiRoleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BusiRoleServiceProxy api() {
        return APIProxy.get(BusiRoleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
