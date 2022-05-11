package org.github.foxnic.web.proxy.bpm;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:02
 * @version
 */
@FeignClient(value = MicroServiceNames.CAMUNDA, contextId = BpmIdentityServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BpmIdentityServiceProxy {

    /**
     * 基础路径 , service-camunda
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , camunda-user
     */
    public static final String API_CONTEXT_PATH = "identity";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 获得身份列表
     */
    public static final String GET_IDENTITIES = API_PREFIX + "identities";

    /**
     * 获得身份列表
     */
    @RequestMapping(BpmIdentityServiceProxy.GET_IDENTITIES)
    Result<List<Assignee>> getIdentities(@RequestParam(name = "userId") String userId, @RequestParam(name = "identityType") String identityType);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.BpmIdentityController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BpmIdentityServiceProxy api() {
        return APIProxy.get(BpmIdentityServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
