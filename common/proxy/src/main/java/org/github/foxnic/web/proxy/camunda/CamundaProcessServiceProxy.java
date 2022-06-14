package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.ProcessAbandonVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 流程实例  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaProcessServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CamundaProcessServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-camunda";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "camunda-process";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 启动流程
     */
    public static final String START = API_PREFIX + "start";

    /**
     * 启动流程
     */
    public static final String SET_VARIABLES = API_PREFIX + "set-variables";

    /**
     * 按流程ID查询流程
     */
    public static final String QUERY_BY_IDS = API_PREFIX + "query-by-ids";

    /**
     * 废弃流程
     */
    public static final String ABANDON_PROCESS = API_PREFIX + "abandon-process";


    @RequestMapping(CamundaProcessServiceProxy.SET_VARIABLES)
    Result setVariables(@RequestParam(name = "processInstanceId") String processInstanceId,@RequestParam(name = "variables") Map<String,Object> variables);

    /**
     * 启动流程
     */
    @RequestMapping(CamundaProcessServiceProxy.START)
    Result start(@RequestParam(name = "processDefinitionKey") String processDefinitionKey, @RequestParam(name = "variables")  Map<String,Object> variables);


    @RequestMapping(CamundaProcessServiceProxy.QUERY_BY_IDS)
    Result queryByIds(@RequestParam(name = "processIds") List<String> processIds);

    @PostMapping(CamundaProcessServiceProxy.ABANDON_PROCESS)
    Result abandonProcess(@RequestParam(name = "processAbandonVOList") List<ProcessAbandonVO> processAbandonVOList);
    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.camunda.api.CamundaProcessController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CamundaProcessServiceProxy api() {
        return APIProxy.get(CamundaProcessServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
