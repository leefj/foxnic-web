package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import feign.Param;
import org.github.foxnic.web.domain.bpm.ProcessError;
import org.github.foxnic.web.domain.bpm.TaskProcessVO;
import org.github.foxnic.web.domain.bpm.TaskQueryVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
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
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaIncidentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CamundaIncidentServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-camunda";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "camunda-incident";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 获得待办任务
     */
    public static final String QUERY_BY_PROCESS_INSTANCE_IDS = API_PREFIX + "query-by-process-instance-ids";



    /**
     * 查询待办任务
     */
    @PostMapping(CamundaIncidentServiceProxy.QUERY_BY_PROCESS_INSTANCE_IDS)
    Result<List<ProcessError>> queryIncidentsByProcessInstanceIds(@RequestParam(name = "processInstanceIds") List<String> processInstanceIds);


    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.camunda.api.CamundaIncidentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CamundaIncidentServiceProxy api() {
        return APIProxy.get(CamundaIncidentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
