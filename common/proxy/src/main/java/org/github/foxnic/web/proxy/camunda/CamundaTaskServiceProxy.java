package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.Task;
import org.github.foxnic.web.domain.bpm.TaskProcessVO;
import org.github.foxnic.web.domain.bpm.TaskQueryVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 流程任务  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CamundaTaskServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-camunda";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "camunda-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 获得待办任务
     */
    public static final String TODO_TASKS = API_PREFIX + "todo-tasks";

    public static final String PROCESS_INSTANCE_TODO_TASKS = API_PREFIX + "process_instance_todo_tasks";

    /**
     * 处理待办任务
     */
    public static final String PROCESS_TASK = API_PREFIX + "process-task";

    /**
     * 查询待办任务
     */
    @RequestMapping(CamundaTaskServiceProxy.TODO_TASKS)
    Result getTodoTasks(@RequestParam(name = "taskQueryVO") TaskQueryVO taskQueryVO);


    /**
     * 查询待办任务
     */
    @RequestMapping(CamundaTaskServiceProxy.PROCESS_TASK)
    Result processTask(@RequestParam(name = "taskProcessVO") TaskProcessVO taskProcessVO);

    @RequestMapping(CamundaTaskServiceProxy.PROCESS_INSTANCE_TODO_TASKS)
    Result<List<Task>> getProcessInstanceIdTasks(@RequestParam(name = "processInstanceIds") List<String> processInstanceIds);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.camunda.api.CamundaTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CamundaTaskServiceProxy api() {
        return APIProxy.get(CamundaTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
