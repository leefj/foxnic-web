package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.CompanyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 公司表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:19
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = CompanyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CompanyServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-company
     */
    public static final String API_CONTEXT_PATH = "hrm-company";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加公司
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除公司
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除公司
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新公司
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存公司
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个公司
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个公司
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询公司
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询公司
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出公司数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载公司导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入公司数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加公司
     */
    @RequestMapping(CompanyServiceProxy.INSERT)
    @ParameterNames(value = {"companyVO"})
    Result insert(CompanyVO companyVO);

    /**
     * 删除公司
     */
    @RequestMapping(CompanyServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除公司
     */
    @RequestMapping(CompanyServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新公司
     */
    @RequestMapping(CompanyServiceProxy.UPDATE)
    @ParameterNames(value = {"companyVO"})
    Result update(CompanyVO companyVO);

    /**
     * 更新公司
     */
    @RequestMapping(CompanyServiceProxy.SAVE)
    @ParameterNames(value = {"companyVO"})
    Result save(CompanyVO companyVO);

    /**
     * 获取公司
     */
    @RequestMapping(CompanyServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<Company> getById(String id);

    /**
     * 批量删除公司
     */
    @RequestMapping(CompanyServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<Company>> getByIds(List<String> ids);

    /**
     * 查询公司
     */
    @RequestMapping(CompanyServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<Company>> queryList(CompanyVO sample);

    /**
     * 分页查询公司
     */
    @RequestMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<Company>> queryPagedList(CompanyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.CompanyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CompanyServiceProxy api() {
        return APIProxy.get(CompanyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
