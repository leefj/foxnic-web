package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 流程定义文件表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-04-16 07:17:27
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = ProcessDefinitionFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProcessDefinitionFileServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-process-definition-file
     */
    public static final String API_CONTEXT_PATH = "bpm-process-definition-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加流程定义文件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除流程定义文件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除流程定义文件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新流程定义文件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存流程定义文件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个流程定义文件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个流程定义文件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询流程定义文件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询流程定义文件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出流程定义文件数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载流程定义文件导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入流程定义文件数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "processDefinitionFileVO") ProcessDefinitionFileVO processDefinitionFileVO);

    /**
     * 删除流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "processDefinitionFileVO") ProcessDefinitionFileVO processDefinitionFileVO);

    /**
     * 更新流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "processDefinitionFileVO") ProcessDefinitionFileVO processDefinitionFileVO);

    /**
     * 获取流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.GET_BY_ID)
    Result<ProcessDefinitionFile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.GET_BY_IDS)
    Result<List<ProcessDefinitionFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.QUERY_LIST)
    Result<List<ProcessDefinitionFile>> queryList(@RequestParam(name = "sample") ProcessDefinitionFileVO sample);

    /**
     * 分页查询流程定义文件
     */
    @RequestMapping(ProcessDefinitionFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ProcessDefinitionFile>> queryPagedList(@RequestParam(name = "sample") ProcessDefinitionFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.ProcessDefinitionFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProcessDefinitionFileServiceProxy api() {
        return APIProxy.get(ProcessDefinitionFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
