package org.github.foxnic.web.proxy.notify;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.notify.SmsLog;
import org.github.foxnic.web.domain.notify.SmsLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 短信日志 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
 */
@FeignClient(value = MicroServiceNames.NOTIFY, contextId = SmsLogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SmsLogServiceProxy {

    /**
     * 基础路径 , service-notify
     */
    public static final String API_BASIC_PATH = "service-notify";

    /**
     * API 上下文路径 , sys-sms-log
     */
    public static final String API_CONTEXT_PATH = "sys-sms-log";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加短信日志
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除短信日志
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除短信日志
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新短信日志
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存短信日志
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个短信日志
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个短信日志
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询短信日志
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询短信日志
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加短信日志
     */
    @RequestMapping(SmsLogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "smsLogVO") SmsLogVO smsLogVO);

    /**
     * 删除短信日志
     */
    @RequestMapping(SmsLogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Integer id);

    /**
     * 批量删除短信日志
     */
    @RequestMapping(SmsLogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Integer> ids);

    /**
     * 更新短信日志
     */
    @RequestMapping(SmsLogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "smsLogVO") SmsLogVO smsLogVO);

    /**
     * 更新短信日志
     */
    @RequestMapping(SmsLogServiceProxy.SAVE)
    Result save(@RequestParam(name = "smsLogVO") SmsLogVO smsLogVO);

    /**
     * 获取短信日志
     */
    @RequestMapping(SmsLogServiceProxy.GET_BY_ID)
    Result<SmsLog> getById(@RequestParam(name = "id") Integer id);

    /**
     * 获取多个短信日志
     */
    @RequestMapping(SmsLogServiceProxy.GET_BY_IDS)
    Result<List<SmsLog>> getByIds(@RequestParam(name = "ids") List<Integer> ids);

    /**
     * 查询短信日志
     */
    @RequestMapping(SmsLogServiceProxy.QUERY_LIST)
    Result<List<SmsLog>> queryList(@RequestParam(name = "sample") SmsLogVO sample);

    /**
     * 分页查询短信日志
     */
    @RequestMapping(SmsLogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<SmsLog>> queryPagedList(@RequestParam(name = "sample") SmsLogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.notify.controller.SmsLogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SmsLogServiceProxy api() {
        return APIProxy.get(SmsLogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
