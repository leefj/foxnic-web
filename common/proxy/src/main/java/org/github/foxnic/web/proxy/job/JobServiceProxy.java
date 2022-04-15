package org.github.foxnic.web.proxy.job;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.github.foxnic.api.proxy.ParameterNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 定时任务配置表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 11:34:00
 * @version
 */
@FeignClient(value = MicroServiceNames.JOB, contextId = JobServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface JobServiceProxy {

    /**
     * 基础路径 , service-job
     */
    public static final String API_BASIC_PATH = "service-job";

    /**
     * API 上下文路径 , sys-job
     */
    public static final String API_CONTEXT_PATH = "sys-job";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加定时任务配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 校验并模拟Job的执行时间
     */
    public static final String SIMULATE = API_PREFIX + "simulate";

    /**
     * 删除定时任务配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除定时任务配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新定时任务配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存定时任务配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个定时任务配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 立即调度
     */
    public static final String INVOKE = API_PREFIX + "invoke";

    /**
     * 获取多个定时任务配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询定时任务配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询定时任务配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出定时任务配置数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载定时任务配置导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入定时任务配置数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加定时任务配置
     */
    @RequestMapping(JobServiceProxy.INSERT)
    Result insert(@RequestParam(name = "jobVO") JobVO jobVO);

    /**
     * 删除定时任务配置
     */
    @RequestMapping(JobServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除定时任务配置
     */
    @RequestMapping(JobServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新定时任务配置
     */
    @RequestMapping(JobServiceProxy.UPDATE)
    Result update(@RequestParam(name = "jobVO") JobVO jobVO);

    /**
     * 更新定时任务配置
     */
    @RequestMapping(JobServiceProxy.SAVE)
    Result save(@RequestParam(name = "jobVO") JobVO jobVO);

    /**
     * 获取定时任务配置
     */
    @RequestMapping(JobServiceProxy.GET_BY_ID)
    Result<Job> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个定时任务配置
     */
    @RequestMapping(JobServiceProxy.GET_BY_IDS)
    Result<List<Job>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询定时任务配置
     */
    @RequestMapping(JobServiceProxy.QUERY_LIST)
    Result<List<Job>> queryList(@RequestParam(name = "sample") JobVO sample);

    /**
     * 分页查询定时任务配置
     */
    @RequestMapping(JobServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Job>> queryPagedList(@RequestParam(name = "sample") JobVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.job.controller.JobController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static JobServiceProxy api() {
        return APIProxy.get(JobServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
