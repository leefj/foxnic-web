package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessError;
import org.github.foxnic.web.domain.bpm.ProcessErrorVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程错误信息  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-13 16:36:10
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessErrorServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessErrorServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-error
     */
    public static final String API_CONTEXT_PATH = "bpm-process-error";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程错误信息
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程错误信息
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程错误信息
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程错误信息
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程错误信息
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程错误信息
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程错误信息
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程错误信息
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程错误信息
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程错误信息数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程错误信息导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程错误信息数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 导入流程错误信息数据(Excel)
     */
    public static final String SYNC_ERRORS = API_PREFIX + "sync-errors";

    @PostMapping(ProcessErrorServiceProxy.SYNC_ERRORS)
    Result syncCamundaErrors(@RequestParam(name = "processInstanceIds") List<String> processInstanceIds);

    /**
     * 添加流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.INSERT)
    Result insert(@RequestParam(name = "processErrorVO") ProcessErrorVO processErrorVO);

    /**
     * 删除流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.UPDATE)
    Result update(@RequestParam(name = "processErrorVO") ProcessErrorVO processErrorVO);

    /**
     * 更新流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.SAVE)
    Result save(@RequestParam(name = "processErrorVO") ProcessErrorVO processErrorVO);

    /**
     * 获取流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.GET_BY_ID)
    Result<ProcessError> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.GET_BY_IDS)
    Result<List<ProcessError>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.QUERY_LIST)
    Result<List<ProcessError>> queryList(@RequestParam(name = "sample") ProcessErrorVO sample);

    /**
     * 分页查询流程错误信息
     */
    @RequestMapping(ProcessErrorServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessError>> queryPagedList(@RequestParam(name = "sample") ProcessErrorVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessErrorController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessErrorServiceProxy api() {
        return APIProxy.get(ProcessErrorServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
