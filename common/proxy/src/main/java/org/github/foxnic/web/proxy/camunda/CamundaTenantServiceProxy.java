package org.github.foxnic.web.proxy.camunda;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = CamundaTenantServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CamundaTenantServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-camunda";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "camunda-tenant";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加租户
     */
    public static final String CREATE = API_PREFIX + "create";

    /**
     * 添加租户
     */
    @RequestMapping(CamundaTenantServiceProxy.CREATE)
    @ParameterNames(value = {"tenantId"})
    Result create(String tenantId);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.camunda.api.CamundaTenantController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CamundaTenantServiceProxy api() {
        return APIProxy.get(CamundaTenantServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
