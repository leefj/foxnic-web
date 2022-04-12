package org.github.foxnic.web.proxy.hrm;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 组织层级表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-13 15:09:51
 * @version
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = OrganizationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface OrganizationServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-organization
     */
    public static final String API_CONTEXT_PATH = "hrm-organization";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加组织层级
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除组织层级
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除组织层级
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新组织层级
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存组织层级
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个组织层级
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个组织层级
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询组织层级
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 查询组织节点(带层级)
     */
    public static final String QUERY_NODES = API_PREFIX + "query-nodes";

    /**
     * 查询组织节点(展平)
     */
    public static final String QUERY_NODES_FLATTEN = API_PREFIX + "query-nodes-flatten";

    /**
     * 搜索节点
     */
    public static final String SEARCH = API_PREFIX + "search";

    /**
     * 保存层级关系
     */
    public static final String SAVE_HIERARCHY = API_PREFIX + "save-hierarchy";

    /**
     * 分页查询组织层级
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出组织层级数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载组织层级导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入组织层级数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加组织层级
     */
    @RequestMapping(OrganizationServiceProxy.INSERT)
    @ParameterNames(value = {"organizationVO"})
    Result insert(OrganizationVO organizationVO);

    /**
     * 删除组织层级
     */
    @RequestMapping(OrganizationServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除组织层级
     */
    @RequestMapping(OrganizationServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新组织层级
     */
    @RequestMapping(OrganizationServiceProxy.UPDATE)
    @ParameterNames(value = {"organizationVO"})
    Result update(OrganizationVO organizationVO);

    /**
     * 更新组织层级
     */
    @RequestMapping(OrganizationServiceProxy.SAVE)
    @ParameterNames(value = {"organizationVO"})
    Result save(OrganizationVO organizationVO);

    /**
     * 获取组织层级
     */
    @RequestMapping(OrganizationServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<Organization> getById(String id);

    /**
     * 批量删除组织层级
     */
    @RequestMapping(OrganizationServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<Organization>> getByIds(List<String> ids);

    /**
     * 查询组织层级
     */
    @RequestMapping(OrganizationServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<Organization>> queryList(OrganizationVO sample);

    /**
     * 分页查询组织层级
     */
    @RequestMapping(OrganizationServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<Organization>> queryPagedList(OrganizationVO sample);

    /**
     * 查询组织树(带层级)
     */
    @RequestMapping(OrganizationServiceProxy.QUERY_NODES)
    @ParameterNames(value = {"sample"})
    Result<List<ZTreeNode>> queryNodes(OrganizationVO sample);

    /**
     * 查询组节点(展平)
     */
    @RequestMapping(OrganizationServiceProxy.QUERY_NODES_FLATTEN)
    @ParameterNames(value = {"sample"})
    Result<List<ZTreeNode>> queryNodesFlatten(OrganizationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.OrganizationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static OrganizationServiceProxy api() {
        return APIProxy.get(OrganizationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
