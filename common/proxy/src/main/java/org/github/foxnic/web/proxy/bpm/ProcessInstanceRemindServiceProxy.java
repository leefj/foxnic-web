package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemind;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程实例提醒 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-20 09:58:19
 * @version
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessInstanceRemindServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessInstanceRemindServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-instance-remind
     */
    public static final String API_CONTEXT_PATH = "bpm-process-instance-remind";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程实例提醒
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程实例提醒
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程实例提醒
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程实例提醒
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程实例提醒
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程实例提醒
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程实例提醒
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程实例提醒
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程实例提醒
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    public static final String PROCESS_NODE_START = API_PREFIX + "process-node-start";

    public static final String PROCESS_NODE_END = API_PREFIX + "process-node-end";

    /**
     * 添加流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.INSERT)
    Result insert(@RequestParam(name = "processInstanceRemindVO") ProcessInstanceRemindVO processInstanceRemindVO);

    /**
     * 删除流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.UPDATE)
    Result update(@RequestParam(name = "processInstanceRemindVO") ProcessInstanceRemindVO processInstanceRemindVO);

    /**
     * 更新流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.SAVE)
    Result save(@RequestParam(name = "processInstanceRemindVO") ProcessInstanceRemindVO processInstanceRemindVO);

    /**
     * 获取流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.GET_BY_ID)
    Result<ProcessInstanceRemind> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.GET_BY_IDS)
    Result<List<ProcessInstanceRemind>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.QUERY_LIST)
    Result<List<ProcessInstanceRemind>> queryList(@RequestParam(name = "sample") ProcessInstanceRemindVO sample);

    /**
     * 分页查询流程实例提醒
     */
    @RequestMapping(ProcessInstanceRemindServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessInstanceRemind>> queryPagedList(@RequestParam(name = "sample") ProcessInstanceRemindVO sample);

    @RequestMapping(ProcessInstanceRemindServiceProxy.PROCESS_NODE_START)
    Result processNodeStart(@RequestParam(name = "processInstanceId") String processInstanceId, @RequestParam(name = "targetNodeId") String targetNodeId);

    @RequestMapping(ProcessInstanceRemindServiceProxy.PROCESS_NODE_END)
    Result processNodeEnd(@RequestParam(name = "processInstanceId") String processInstanceId, @RequestParam(name = "targetNodeId") String targetNodeId);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessInstanceRemindController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessInstanceRemindServiceProxy api() {
        return APIProxy.get(ProcessInstanceRemindServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
