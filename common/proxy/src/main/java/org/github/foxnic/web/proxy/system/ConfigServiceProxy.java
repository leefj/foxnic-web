package org.github.foxnic.web.proxy.system;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.domain.system.ConfigVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 系统配置表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 09:07:26
 * @version
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = ConfigServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ConfigServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-config
     */
    public static final String API_CONTEXT_PATH = "sys-config";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加系统配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除系统配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除系统配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新系统配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存系统配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个系统配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取单个系统配置
     */
    public static final String GET_BY_CODE = API_PREFIX + "get-by-code";

    /**
     * 获取单个系统配置
     */
    public static final String GET_BY_CODES = API_PREFIX + "get-by-codes";

    /**
     * 获取多个系统配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询系统配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询系统配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出系统配置数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载系统配置导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入系统配置数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加系统配置
     */
    @RequestMapping(ConfigServiceProxy.INSERT)
    Result insert(@RequestParam(name = "configVO") ConfigVO configVO);

    /**
     * 删除系统配置
     */
    @RequestMapping(ConfigServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除系统配置
     */
    @RequestMapping(ConfigServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新系统配置
     */
    @RequestMapping(ConfigServiceProxy.UPDATE)
    Result update(@RequestParam(name = "configVO") ConfigVO configVO);

    /**
     * 更新系统配置
     */
    @RequestMapping(ConfigServiceProxy.SAVE)
    Result save(@RequestParam(name = "configVO") ConfigVO configVO);

    /**
     * 获取系统配置
     */
    @RequestMapping(ConfigServiceProxy.GET_BY_ID)
    Result<Config> getById(@RequestParam(name = "id") String id);

    /**
     * 获取系统配置
     */
    @PostMapping(ConfigServiceProxy.GET_BY_CODE)
    Result<Config> getByCode(@RequestParam(name = "code")String code);

    /**
     * 批量删除系统配置
     */
    @RequestMapping(ConfigServiceProxy.GET_BY_IDS)
    Result<List<Config>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 批量删除系统配置
     */
    @RequestMapping(ConfigServiceProxy.GET_BY_CODES)
    Result<List<Config>> getByCodes(@RequestParam(name = "codes") List<String> codes);

    /**
     * 查询系统配置
     */
    @RequestMapping(ConfigServiceProxy.QUERY_LIST)
    Result<List<Config>> queryList(@RequestParam(name = "sample") ConfigVO sample);

    /**
     * 分页查询系统配置
     */
    @RequestMapping(ConfigServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Config>> queryPagedList(@RequestParam(name = "sample") ConfigVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.ConfigController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ConfigServiceProxy api() {
        return APIProxy.get(ConfigServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
