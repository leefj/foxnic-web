package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.TaskApproval;
import org.github.foxnic.web.domain.bpm.TaskApprovalVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程任务审批结果表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-11 13:32:20
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = TaskApprovalServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TaskApprovalServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-task-approval
     */
    public static final String API_CONTEXT_PATH = "bpm-task-approval";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程任务审批结果
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程任务审批结果
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程任务审批结果
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程任务审批结果
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程任务审批结果
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程任务审批结果
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程任务审批结果
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程任务审批结果
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程任务审批结果
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程任务审批结果数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程任务审批结果导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程任务审批结果数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.INSERT)
    Result insert(@RequestParam(name = "taskApprovalVO") TaskApprovalVO taskApprovalVO);

    /**
     * 删除流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.UPDATE)
    Result update(@RequestParam(name = "taskApprovalVO") TaskApprovalVO taskApprovalVO);

    /**
     * 更新流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.SAVE)
    Result save(@RequestParam(name = "taskApprovalVO") TaskApprovalVO taskApprovalVO);

    /**
     * 获取流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.GET_BY_ID)
    Result<TaskApproval> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.GET_BY_IDS)
    Result<List<TaskApproval>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.QUERY_LIST)
    Result<List<TaskApproval>> queryList(@RequestParam(name = "sample") TaskApprovalVO sample);

    /**
     * 分页查询流程任务审批结果
     */
    @RequestMapping(TaskApprovalServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<TaskApproval>> queryPagedList(@RequestParam(name = "sample") TaskApprovalVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.TaskApprovalController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TaskApprovalServiceProxy api() {
        return APIProxy.get(TaskApprovalServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
