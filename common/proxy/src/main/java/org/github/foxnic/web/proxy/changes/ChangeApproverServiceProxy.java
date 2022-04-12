package org.github.foxnic.web.proxy.changes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.changes.ChangeApprover;
import org.github.foxnic.web.domain.changes.ChangeApproverVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 变更单据关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-23 14:31:43
 */
@FeignClient(value = MicroServiceNames.CHS, contextId = ChangeApproverServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ChangeApproverServiceProxy {

    /**
     * 基础路径 , service-changes
     */
    public static final String API_BASIC_PATH = "service-changes";

    /**
     * API 上下文路径 , chs-change-approver
     */
    public static final String API_CONTEXT_PATH = "chs-change-approver";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加变更单据关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除变更单据关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除变更单据关系
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新变更单据关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存变更单据关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个变更单据关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个变更单据关系
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询变更单据关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询变更单据关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出变更单据关系数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载变更单据关系导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入变更单据关系数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.INSERT)
    @ParameterNames(value = {"changeApproverVO"})
    Result insert(ChangeApproverVO changeApproverVO);

    /**
     * 删除变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.UPDATE)
    @ParameterNames(value = {"changeApproverVO"})
    Result update(ChangeApproverVO changeApproverVO);

    /**
     * 更新变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.SAVE)
    @ParameterNames(value = {"changeApproverVO"})
    Result save(ChangeApproverVO changeApproverVO);

    /**
     * 获取变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<ChangeApprover> getById(String id);

    /**
     * 批量删除变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<ChangeApprover>> getByIds(List<String> ids);

    /**
     * 查询变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<ChangeApprover>> queryList(ChangeApproverVO sample);

    /**
     * 分页查询变更单据关系
     */
    @RequestMapping(ChangeApproverServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<ChangeApprover>> queryPagedList(ChangeApproverVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.changes.controller.ChangeApproverController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ChangeApproverServiceProxy api() {
        return APIProxy.get(ChangeApproverServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
