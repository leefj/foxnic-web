package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssignee;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNodeAssigneeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程审批人表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-08 07:30:34
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessDefinitionNodeAssigneeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessDefinitionNodeAssigneeServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-definition-node-assignee
     */
    public static final String API_CONTEXT_PATH = "bpm-process-definition-node-assignee";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程审批人
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程审批人
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程审批人
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程审批人
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程审批人
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程审批人
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程审批人
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程审批人
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程审批人
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程审批人数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程审批人导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程审批人数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "processDefinitionNodeAssigneeVO") ProcessDefinitionNodeAssigneeVO processDefinitionNodeAssigneeVO);

    /**
     * 删除流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "processDefinitionNodeAssigneeVO") ProcessDefinitionNodeAssigneeVO processDefinitionNodeAssigneeVO);

    /**
     * 更新流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.SAVE)
    Result save(@RequestParam(name = "processDefinitionNodeAssigneeVO") ProcessDefinitionNodeAssigneeVO processDefinitionNodeAssigneeVO);

    /**
     * 获取流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.GET_BY_ID)
    Result<ProcessDefinitionNodeAssignee> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.GET_BY_IDS)
    Result<List<ProcessDefinitionNodeAssignee>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.QUERY_LIST)
    Result<List<ProcessDefinitionNodeAssignee>> queryList(@RequestParam(name = "sample") ProcessDefinitionNodeAssigneeVO sample);

    /**
     * 分页查询流程审批人
     */
    @RequestMapping(ProcessDefinitionNodeAssigneeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessDefinitionNodeAssignee>> queryPagedList(@RequestParam(name = "sample") ProcessDefinitionNodeAssigneeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessDefinitionNodeAssigneeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessDefinitionNodeAssigneeServiceProxy api() {
        return APIProxy.get(ProcessDefinitionNodeAssigneeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
