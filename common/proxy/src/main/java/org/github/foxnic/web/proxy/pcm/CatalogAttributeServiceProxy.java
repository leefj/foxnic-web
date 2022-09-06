package org.github.foxnic.web.proxy.pcm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogAttributeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 分类属性表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:40:38
 */
@FeignClient(value = MicroServiceNames.PCM, contextId = CatalogAttributeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CatalogAttributeServiceProxy {

    /**
     * 基础路径 , service-pcm
     */
    public static final String API_BASIC_PATH = "service-pcm";

    /**
     * API 上下文路径 , pcm-catalog-attribute
     */
    public static final String API_CONTEXT_PATH = "pcm-catalog-attribute";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加分类属性
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除分类属性
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除分类属性
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新分类属性
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存分类属性
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个分类属性
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个分类属性
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询分类属性
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询分类属性
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "catalogAttributeVO") CatalogAttributeVO catalogAttributeVO);

    /**
     * 删除分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "catalogAttributeVO") CatalogAttributeVO catalogAttributeVO);

    /**
     * 更新分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.SAVE)
    Result save(@RequestParam(name = "catalogAttributeVO") CatalogAttributeVO catalogAttributeVO);

    /**
     * 获取分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.GET_BY_ID)
    Result<CatalogAttribute> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.GET_BY_IDS)
    Result<List<CatalogAttribute>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.QUERY_LIST)
    Result<List<CatalogAttribute>> queryList(@RequestParam(name = "sample") CatalogAttributeVO sample);

    /**
     * 分页查询分类属性
     */
    @RequestMapping(CatalogAttributeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CatalogAttribute>> queryPagedList(@RequestParam(name = "sample") CatalogAttributeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.pcm.controller.CatalogAttributeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CatalogAttributeServiceProxy api() {
        return APIProxy.get(CatalogAttributeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
