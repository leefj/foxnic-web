package org.github.foxnic.web.proxy.api;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 错误码
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-20 15:24:48
 * @version
 */
@FeignClient(value = MicroServiceNames.API, contextId = ErrorCodesServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ErrorCodesServiceProxy {

    /**
     * 基础路径 , service-api
     */
    public static final String API_BASIC_PATH = "service-api";

    /**
     * API 上下文路径 , sys-api-source
     */
    public static final String API_CONTEXT_PATH = "error-codes";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 查询错误码
     */
    public static final String QUERY = API_PREFIX + "query";


    /**
     * 查询错误码
     */
    @RequestMapping(ErrorCodesServiceProxy.QUERY)
    Result query();

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.api.controller.ErrorCodesController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ErrorCodesServiceProxy api() {
        return APIProxy.get(ErrorCodesServiceProxy.class,  CONTROLLER_CLASS_NAME);
    }
}
