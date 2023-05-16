package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.DemoLeave;
import org.github.foxnic.web.domain.bpm.DemoLeaveVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 请假流程示例 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-16 11:38:40
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = DemoLeaveServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DemoLeaveServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-demo-leave
     */
    public static final String API_CONTEXT_PATH = "bpm-demo-leave";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加请假流程示例
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除请假流程示例
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除请假流程示例
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新请假流程示例
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存请假流程示例
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个请假流程示例
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个请假流程示例
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询请假流程示例
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询请假流程示例
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.INSERT)
    Result insert(@RequestParam(name = "demoLeaveVO") DemoLeaveVO demoLeaveVO);

    /**
     * 删除请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.UPDATE)
    Result update(@RequestParam(name = "demoLeaveVO") DemoLeaveVO demoLeaveVO);

    /**
     * 更新请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.SAVE)
    Result save(@RequestParam(name = "demoLeaveVO") DemoLeaveVO demoLeaveVO);

    /**
     * 获取请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.GET_BY_ID)
    Result<DemoLeave> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.GET_BY_IDS)
    Result<List<DemoLeave>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.QUERY_LIST)
    Result<List<DemoLeave>> queryList(@RequestParam(name = "sample") DemoLeaveVO sample);

    /**
     * 分页查询请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DemoLeave>> queryPagedList(@RequestParam(name = "sample") DemoLeaveVO sample);

    /**
     * 分页查询请假流程示例
     */
    @RequestMapping(DemoLeaveServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.DemoLeaveController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DemoLeaveServiceProxy api() {
        return APIProxy.get(DemoLeaveServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
