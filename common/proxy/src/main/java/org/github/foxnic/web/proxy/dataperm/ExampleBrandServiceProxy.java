package org.github.foxnic.web.proxy.dataperm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.dataperm.ExampleBrand;
import org.github.foxnic.web.domain.dataperm.ExampleBrandVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 商品品牌表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:38
 */
@FeignClient(value = MicroServiceNames.DATA_PERM, contextId = ExampleBrandServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ExampleBrandServiceProxy {

    /**
     * 基础路径 , service-dataperm
     */
    public static final String API_BASIC_PATH = "service-dataperm";

    /**
     * API 上下文路径 , dp-example-brand
     */
    public static final String API_CONTEXT_PATH = "dp-example-brand";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加商品品牌
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除商品品牌
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除商品品牌
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新商品品牌
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存商品品牌
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个商品品牌
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个商品品牌
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询商品品牌
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询商品品牌
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.INSERT)
    Result insert(@RequestParam(name = "exampleBrandVO") ExampleBrandVO exampleBrandVO);

    /**
     * 删除商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.UPDATE)
    Result update(@RequestParam(name = "exampleBrandVO") ExampleBrandVO exampleBrandVO);

    /**
     * 更新商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.SAVE)
    Result save(@RequestParam(name = "exampleBrandVO") ExampleBrandVO exampleBrandVO);

    /**
     * 获取商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.GET_BY_ID)
    Result<ExampleBrand> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.GET_BY_IDS)
    Result<List<ExampleBrand>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.QUERY_LIST)
    Result<List<ExampleBrand>> queryList(@RequestParam(name = "sample") ExampleBrandVO sample);

    /**
     * 分页查询商品品牌
     */
    @RequestMapping(ExampleBrandServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ExampleBrand>> queryPagedList(@RequestParam(name = "sample") ExampleBrandVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.dataperm.controller.ExampleBrandController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ExampleBrandServiceProxy api() {
        return APIProxy.get(ExampleBrandServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
