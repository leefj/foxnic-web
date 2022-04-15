package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaDeployServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CamundaDeployServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-camunda";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "camunda-deploy";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加账户
     */
    public static final String DEPLOY = API_PREFIX + "deploy";

    /**
     * 添加账户
     */
    @RequestMapping(CamundaDeployServiceProxy.DEPLOY)
    Result deploy(@RequestParam(name = "processDefinition") ProcessDefinition processDefinition);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.camunda.api.CamundaDeployController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CamundaDeployServiceProxy api() {
        return APIProxy.get(CamundaDeployServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
