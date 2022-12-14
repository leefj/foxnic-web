package org.github.foxnic.web.proxy.job;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.job.JobLog;
import org.github.foxnic.web.domain.job.JobLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 定时任务执行日志表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 13:14:14
 */
@FeignClient(value = MicroServiceNames.JOB, contextId = JobLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface JobLogServiceProxy {

    /**
     * 基础路径 , service-job
     */
    public static final String API_BASIC_PATH = "service-job";

    /**
     * API 上下文路径 , sys-job-log
     */
    public static final String API_CONTEXT_PATH = "sys-job-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加定时任务执行日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除定时任务执行日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除定时任务执行日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新定时任务执行日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存定时任务执行日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个定时任务执行日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个定时任务执行日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询定时任务执行日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询定时任务执行日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "jobLogVO") JobLogVO jobLogVO);

    /**
     * 删除定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "jobLogVO") JobLogVO jobLogVO);

    /**
     * 更新定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "jobLogVO") JobLogVO jobLogVO);

    /**
     * 获取定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.GET_BY_ID)
    Result<JobLog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.GET_BY_IDS)
    Result<List<JobLog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.QUERY_LIST)
    Result<List<JobLog>> queryList(@RequestParam(name = "sample") JobLogVO sample);

    /**
     * 分页查询定时任务执行日志
     */
    @RequestMapping(JobLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<JobLog>> queryPagedList(@RequestParam(name = "sample") JobLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.job.controller.JobLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static JobLogServiceProxy api() {
        return APIProxy.get(JobLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
