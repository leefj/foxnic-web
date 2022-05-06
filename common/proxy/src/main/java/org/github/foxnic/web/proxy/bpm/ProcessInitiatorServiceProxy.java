package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessInitiator;
import org.github.foxnic.web.domain.bpm.ProcessInitiatorVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程发起人权限表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-06 14:46:06
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessInitiatorServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessInitiatorServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-initiator
     */
    public static final String API_CONTEXT_PATH = "bpm-process-initiator";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程发起人权限
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程发起人权限
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程发起人权限
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程发起人权限
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程发起人权限
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程发起人权限
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程发起人权限
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程发起人权限
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程发起人权限
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程发起人权限数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程发起人权限导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程发起人权限数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.INSERT)
    Result insert(@RequestParam(name = "processInitiatorVO") ProcessInitiatorVO processInitiatorVO);

    /**
     * 删除流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.UPDATE)
    Result update(@RequestParam(name = "processInitiatorVO") ProcessInitiatorVO processInitiatorVO);

    /**
     * 更新流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.SAVE)
    Result save(@RequestParam(name = "processInitiatorVO") ProcessInitiatorVO processInitiatorVO);

    /**
     * 获取流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.GET_BY_ID)
    Result<ProcessInitiator> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.GET_BY_IDS)
    Result<List<ProcessInitiator>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.QUERY_LIST)
    Result<List<ProcessInitiator>> queryList(@RequestParam(name = "sample") ProcessInitiatorVO sample);

    /**
     * 分页查询流程发起人权限
     */
    @RequestMapping(ProcessInitiatorServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessInitiator>> queryPagedList(@RequestParam(name = "sample") ProcessInitiatorVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessInitiatorController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessInitiatorServiceProxy api() {
        return APIProxy.get(ProcessInitiatorServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
