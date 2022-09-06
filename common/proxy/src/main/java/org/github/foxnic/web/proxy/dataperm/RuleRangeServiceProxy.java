package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import org.github.foxnic.web.domain.dataperm.RuleRangeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据权限规则范围表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:34
 */
@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = RuleRangeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RuleRangeServiceProxy {

    /**
     * 基础路径 , service-dataperm
     */
    public static final String API_BASIC_PATH = "service-dataperm";

    /**
     * API 上下文路径 , dp-rule-range
     */
    public static final String API_CONTEXT_PATH = "dp-rule-range";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据权限规则范围
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据权限规则范围
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据权限规则范围
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据权限规则范围
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据权限规则范围
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据权限规则范围
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据权限规则范围
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据权限规则范围
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据权限规则范围
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "ruleRangeVO") RuleRangeVO ruleRangeVO);

    /**
     * 删除数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "ruleRangeVO") RuleRangeVO ruleRangeVO);

    /**
     * 更新数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.SAVE)
    Result save(@RequestParam(name = "ruleRangeVO") RuleRangeVO ruleRangeVO);

    /**
     * 获取数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.GET_BY_ID)
    Result<RuleRange> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.GET_BY_IDS)
    Result<List<RuleRange>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.QUERY_LIST)
    Result<List<RuleRange>> queryList(@RequestParam(name = "sample") RuleRangeVO sample);

    /**
     * 分页查询数据权限规则范围
     */
    @RequestMapping(RuleRangeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RuleRange>> queryPagedList(@RequestParam(name = "sample") RuleRangeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.dataperm.controller.RuleRangeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RuleRangeServiceProxy api() {
        return APIProxy.get(RuleRangeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
