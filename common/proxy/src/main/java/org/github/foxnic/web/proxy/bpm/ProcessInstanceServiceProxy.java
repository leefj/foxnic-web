package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.ProcessInstanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程实例表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-20 14:30:03
 * @version
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessInstanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessInstanceServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-instance
     */
    public static final String API_CONTEXT_PATH = "bpm-process-instance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程实例
     */
    public static final String TEMPORARY_SAVE = API_PREFIX + "temporary-save";

    /**
     * 添加流程实例
     */
    public static final String START = API_PREFIX + "insert";

    /**
     * 删除流程实例
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程实例
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 获取单个流程实例
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程实例
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程实例
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程实例
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程实例数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程实例导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程实例数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.START)
    Result insert(@RequestParam(name = "processInstanceVO") ProcessInstanceVO processInstanceVO);

    /**
     * 删除流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Integer id);

    /**
     * 批量删除流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<Integer> ids);

    /**
     * 获取流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.GET_BY_ID)
    Result<ProcessInstance> getById(@RequestParam(name = "id") Integer id);

    /**
     * 获取多个流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.GET_BY_IDS)
    Result<List<ProcessInstance>> getByIds(@RequestParam(name = "ids") List<Integer> ids);

    /**
     * 查询流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.QUERY_LIST)
    Result<List<ProcessInstance>> queryList(@RequestParam(name = "sample") ProcessInstanceVO sample);

    /**
     * 分页查询流程实例
     */
    @RequestMapping(ProcessInstanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessInstance>> queryPagedList(@RequestParam(name = "sample") ProcessInstanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessInstanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessInstanceServiceProxy api() {
        return APIProxy.get(ProcessInstanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
