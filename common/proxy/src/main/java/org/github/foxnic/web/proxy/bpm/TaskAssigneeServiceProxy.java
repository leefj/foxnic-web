package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.TaskAssignee;
import org.github.foxnic.web.domain.bpm.TaskAssigneeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程任务处理人表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = TaskAssigneeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TaskAssigneeServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-task-assignee
     */
    public static final String API_CONTEXT_PATH = "bpm-task-assignee";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程任务处理人
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程任务处理人
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程任务处理人
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程任务处理人
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程任务处理人
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程任务处理人
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程任务处理人
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程任务处理人
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程任务处理人
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "taskAssigneeVO") TaskAssigneeVO taskAssigneeVO);

    /**
     * 删除流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "taskAssigneeVO") TaskAssigneeVO taskAssigneeVO);

    /**
     * 更新流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.SAVE)
    Result save(@RequestParam(name = "taskAssigneeVO") TaskAssigneeVO taskAssigneeVO);

    /**
     * 获取流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.GET_BY_ID)
    Result<TaskAssignee> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.GET_BY_IDS)
    Result<List<TaskAssignee>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.QUERY_LIST)
    Result<List<TaskAssignee>> queryList(@RequestParam(name = "sample") TaskAssigneeVO sample);

    /**
     * 分页查询流程任务处理人
     */
    @RequestMapping(TaskAssigneeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<TaskAssignee>> queryPagedList(@RequestParam(name = "sample") TaskAssigneeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.TaskAssigneeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TaskAssigneeServiceProxy api() {
        return APIProxy.get(TaskAssigneeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
