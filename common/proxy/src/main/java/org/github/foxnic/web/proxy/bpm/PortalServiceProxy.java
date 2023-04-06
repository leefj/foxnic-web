package org.github.foxnic.web.proxy.bpm;

import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 通用审批表单  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-18 11:53:45
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = PortalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PortalServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-demo-common
     */
    public static final String API_CONTEXT_PATH = "portal";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 查询当前用户流程统计信息
     */
    public static final String QUERY_SUMMARY = API_PREFIX + "query-summary";

    /**
     * 查询当前用户常用流程
     */
    public static final String QUERY_COMMONLY_USED = API_PREFIX + "query-commonly-used";

    /**
     * 查询当前用户常用流程
     */
    public static final String QUERY_LATEST_USED = API_PREFIX + "query-latest-used";

    /**
     * 查询当前用户的流程
     */
    public static final String QUERY_MY_PROCESS = API_PREFIX + "query-my-process";

    /**
     * 查询流程分类以及分类下的流程
     */
    public static final String QUERY_CATALOG = API_PREFIX + "query-catalog";






}
