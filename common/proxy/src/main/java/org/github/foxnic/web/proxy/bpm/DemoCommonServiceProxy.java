package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.DemoCommon;
import org.github.foxnic.web.domain.bpm.DemoCommonVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 通用审批表单  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-22 17:21:49
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = DemoCommonServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DemoCommonServiceProxy extends BpmCallbackController {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-demo-common
     */
    public static final String API_CONTEXT_PATH = "bpm-demo-common";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加通用审批表单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除通用审批表单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除通用审批表单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新通用审批表单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存通用审批表单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个通用审批表单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个通用审批表单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询通用审批表单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询通用审批表单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出通用审批表单数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载通用审批表单导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入通用审批表单数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 流程事件回调接收接口
     */
    public static final String BPM_CALLBACK = API_PREFIX + "bpm-callback";

    /**
     * 添加通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.INSERT)
    Result insert(@RequestParam(name = "demoCommonVO") DemoCommonVO demoCommonVO);

    /**
     * 删除通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.UPDATE)
    Result update(@RequestParam(name = "demoCommonVO") DemoCommonVO demoCommonVO);

    /**
     * 更新通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.SAVE)
    Result save(@RequestParam(name = "demoCommonVO") DemoCommonVO demoCommonVO);

    /**
     * 获取通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.GET_BY_ID)
    Result<DemoCommon> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.GET_BY_IDS)
    Result<List<DemoCommon>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.QUERY_LIST)
    Result<List<DemoCommon>> queryList(@RequestParam(name = "sample") DemoCommonVO sample);

    /**
     * 分页查询通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DemoCommon>> queryPagedList(@RequestParam(name = "sample") DemoCommonVO sample);

    /**
     * 分页查询通用审批表单
     */
    @RequestMapping(DemoCommonServiceProxy.BPM_CALLBACK)
    BpmActionResult onProcessCallback(@RequestParam(name = "event") BpmEvent event);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.DemoCommonController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DemoCommonServiceProxy api() {
        return APIProxy.get(DemoCommonServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
