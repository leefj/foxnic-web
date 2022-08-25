package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.domain.system.InvokeLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 调用统计日志  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:42:23
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = InvokeLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InvokeLogServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-invoke-log
     */
    public static final String API_CONTEXT_PATH = "sys-invoke-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加调用统计日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除调用统计日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除调用统计日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新调用统计日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存调用统计日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个调用统计日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个调用统计日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询调用统计日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询调用统计日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "invokeLogVO") InvokeLogVO invokeLogVO);

    /**
     * 删除调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Long id);

    /**
     * 批量删除调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 更新调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "invokeLogVO") InvokeLogVO invokeLogVO);

    /**
     * 更新调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "invokeLogVO") InvokeLogVO invokeLogVO);

    /**
     * 获取调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.GET_BY_ID)
    Result<InvokeLog> getById(@RequestParam(name = "id") Long id);

    /**
     * 获取多个调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.GET_BY_IDS)
    Result<List<InvokeLog>> getByIds(@RequestParam(name = "ids") List<Long> ids);

    /**
     * 查询调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.QUERY_LIST)
    Result<List<InvokeLog>> queryList(@RequestParam(name = "sample") InvokeLogVO sample);

    /**
     * 分页查询调用统计日志
     */
    @RequestMapping(InvokeLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InvokeLog>> queryPagedList(@RequestParam(name = "sample") InvokeLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.InvokeLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InvokeLogServiceProxy api() {
        return APIProxy.get(InvokeLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
