package org.github.foxnic.web.proxy.bpm;

import org.github.foxnic.web.domain.bpm.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程任务表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-05 14:57:07
 * @version
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = TaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TaskServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-task
     */
    public static final String API_CONTEXT_PATH = "bpm-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程任务
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程任务
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程任务
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程任务
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程任务
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程任务
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程任务
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程任务
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";


    /**
     * 查询流程任务
     */
    public static final String QUERY_TASK = API_PREFIX + "query-task";

    /**
     * 分页查询流程任务
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程任务数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程任务导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程任务数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


    /**
     * 导入流程任务数据(Excel)
     */
    public static final String SYNC_CAMUNDA_TASKS = API_PREFIX + "sync-camunda-tasks";

    public static final String PROCESS_TASK = API_PREFIX + "process-task";

    /**
     * 添加流程任务
     */
    @RequestMapping(TaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "taskVO") TaskVO taskVO);

    /**
     * 删除流程任务
     */
    @RequestMapping(TaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程任务
     */
    @RequestMapping(TaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程任务
     */
    @RequestMapping(TaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "taskVO") TaskVO taskVO);

    /**
     * 更新流程任务
     */
    @RequestMapping(TaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "taskVO") TaskVO taskVO);

    /**
     * 获取流程任务
     */
    @RequestMapping(TaskServiceProxy.GET_BY_ID)
    Result<Task> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程任务
     */
    @RequestMapping(TaskServiceProxy.GET_BY_IDS)
    Result<List<Task>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程任务
     */
    @RequestMapping(TaskServiceProxy.QUERY_LIST)
    Result<List<Task>> queryList(@RequestParam(name = "sample") TaskVO sample);

    @RequestMapping(TaskServiceProxy.QUERY_TASK)
    Result<List<Task>> queryTasks(@RequestParam(name = "taskQueryVO") TaskQueryVO taskQueryVO);
    /**
     * 分页查询流程任务
     */
    @RequestMapping(TaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Task>> queryPagedList(@RequestParam(name = "sample") TaskVO sample);

    /**
     * 同步流程任务
     * */
    @RequestMapping(TaskServiceProxy.SYNC_CAMUNDA_TASKS)
    Result syncCamundaTasks(@RequestParam(name = "processInstanceIds")  List<String> processInstanceIds);

    /**
     * 处理流程任务
     * */
    @RequestMapping(TaskServiceProxy.PROCESS_TASK)
    Result<Task> processTask(@RequestParam(name = "taskProcessVO") TaskProcessVO taskProcessVO);
    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.TaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TaskServiceProxy api() {
        return APIProxy.get(TaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
