package org.github.foxnic.web.proxy.changes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.changes.ChangeBill;
import org.github.foxnic.web.domain.changes.ChangeBillVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 20:13:19
 */
@FeignClient(value = MicroServiceNames.CHS, contextId = ChangeBillServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ChangeBillServiceProxy {

    /**
     * 基础路径 , service-changes
     */
    public static final String API_BASIC_PATH = "service-changes";

    /**
     * API 上下文路径 , chs-change-bill
     */
    public static final String API_CONTEXT_PATH = "chs-change-bill";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加chs_change_bill
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除chs_change_bill
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除chs_change_bill
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新chs_change_bill
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存chs_change_bill
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个chs_change_bill
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个chs_change_bill
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询chs_change_bill
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询chs_change_bill
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出chs_change_bill数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载chs_change_bill导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入chs_change_bill数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.INSERT)
    @ParameterNames(value = {"changeBillVO"})
    Result insert(ChangeBillVO changeBillVO);

    /**
     * 删除chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.UPDATE)
    @ParameterNames(value = {"changeBillVO"})
    Result update(ChangeBillVO changeBillVO);

    /**
     * 更新chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.SAVE)
    @ParameterNames(value = {"changeBillVO"})
    Result save(ChangeBillVO changeBillVO);

    /**
     * 获取chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<ChangeBill> getById(String id);

    /**
     * 批量删除chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<ChangeBill>> getByIds(List<String> ids);

    /**
     * 查询chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<ChangeBill>> queryList(ChangeBillVO sample);

    /**
     * 分页查询chs_change_bill
     */
    @RequestMapping(ChangeBillServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<ChangeBill>> queryPagedList(ChangeBillVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.changes.controller.ChangeBillController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ChangeBillServiceProxy api() {
        return APIProxy.get(ChangeBillServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
