package org.github.foxnic.web.proxy.dataperm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.dataperm.Rule;
import org.github.foxnic.web.domain.dataperm.RuleVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 数据权限规则表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 10:00:45
 * @version
 */
@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = RuleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RuleServiceProxy {

    /**
     * 基础路径 , service-dataperm
     */
    public static final String API_BASIC_PATH = "service-dataperm";

    /**
     * API 上下文路径 , dp-rule
     */
    public static final String API_CONTEXT_PATH = "dp-rule";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据权限规则
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据权限规则
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据权限规则
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据权限规则
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据权限规则
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据权限规则
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 应用数据权限规则
     */
    public static final String APPLY = API_PREFIX + "apply";

    /**
     * 获取多个数据权限规则
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据权限规则
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 查询实体字段
     */
    public static final String QUERY_FIELD_LIST = API_PREFIX + "query-field-list";

    /**
     * 分页查询数据权限规则
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出数据权限规则数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载数据权限规则导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入数据权限规则数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加数据权限规则
     */
    @RequestMapping(RuleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ruleVO") RuleVO ruleVO);

    /**
     * 删除数据权限规则
     */
    @RequestMapping(RuleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据权限规则
     */
    @RequestMapping(RuleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据权限规则
     */
    @RequestMapping(RuleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ruleVO") RuleVO ruleVO);

    /**
     * 更新数据权限规则
     */
    @RequestMapping(RuleServiceProxy.SAVE)
    Result save(@RequestParam(name = "ruleVO") RuleVO ruleVO);

    /**
     * 获取数据权限规则
     */
    @RequestMapping(RuleServiceProxy.GET_BY_ID)
    Result<Rule> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据权限规则
     */
    @RequestMapping(RuleServiceProxy.GET_BY_IDS)
    Result<List<Rule>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据权限规则
     */
    @RequestMapping(RuleServiceProxy.QUERY_LIST)
    Result<List<Rule>> queryList(@RequestParam(name = "sample") RuleVO sample);

    /**
     * 分页查询数据权限规则
     */
    @RequestMapping(RuleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Rule>> queryPagedList(@RequestParam(name = "sample") RuleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.dataperm.controller.RuleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RuleServiceProxy api() {
        return APIProxy.get(RuleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
