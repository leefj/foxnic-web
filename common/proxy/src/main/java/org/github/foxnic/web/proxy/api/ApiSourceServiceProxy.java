package org.github.foxnic.web.proxy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.api.ApiSource;
import org.github.foxnic.web.domain.api.ApiSourceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.misc.ztree.ZTreeNode;

/**
 * <p>
 * 接口数据来源定义  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-20 15:24:48
 */
@FeignClient(value = MicroServiceNames.API, contextId = ApiSourceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ApiSourceServiceProxy {

    /**
     * 基础路径 , service-api
     */
    public static final String API_BASIC_PATH = "service-api";

    /**
     * API 上下文路径 , sys-api-source
     */
    public static final String API_CONTEXT_PATH = "sys-api-source";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加接口数据来源定义
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除接口数据来源定义
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除接口数据来源定义
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新接口数据来源定义
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存接口数据来源定义
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个接口数据来源定义
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个接口数据来源定义
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询接口数据来源定义
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询接口数据来源定义
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 立即取数
     * <p>获取API文档</p>
     */
    public static final String FETCH_API_DOC = API_PREFIX + "fetch-api-doc";

    /**
     * 获得API接口节点
     * <p>获得API接口节点</p>
     */
    public static final String QUERY_API_NODES = API_PREFIX + "query-api-nodes";

    /**
     * 获得API接口详情
     * <p>获得API接口详情</p>
     */
    public static final String QUERY_API_DETAIL = API_PREFIX + "query-api-detail";

    /**
     * 添加接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "apiSourceVO") ApiSourceVO apiSourceVO);

    /**
     * 删除接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "apiSourceVO") ApiSourceVO apiSourceVO);

    /**
     * 更新接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.SAVE)
    Result save(@RequestParam(name = "apiSourceVO") ApiSourceVO apiSourceVO);

    /**
     * 获取接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.GET_BY_ID)
    Result<ApiSource> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.GET_BY_IDS)
    Result<List<ApiSource>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.QUERY_LIST)
    Result<List<ApiSource>> queryList(@RequestParam(name = "sample") ApiSourceVO sample);

    /**
     * 分页查询接口数据来源定义
     */
    @RequestMapping(ApiSourceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ApiSource>> queryPagedList(@RequestParam(name = "sample") ApiSourceVO sample);

    /**
     * 立即取数
     * <p>获取API文档</p>
     * @param id 来源ID
     * @return  Result
     */
    @RequestMapping(FETCH_API_DOC)
    Result fetchApiDoc(@RequestParam(name = "id") String id);

    /**
     * 获得API接口节点
     * <p>获得API接口节点</p>
     * @param id id
     * @return  Result&lt;List&lt;ZTreeNode&gt;&gt; 节点树形结构
     */
    @RequestMapping(QUERY_API_NODES)
    Result<List<ZTreeNode>> queryApiNodes(@RequestParam(name = "id") String id);

    /**
     * 获得API接口详情
     * <p>获得API接口详情</p>
     * @param path path
     * @param method method
     * @return  Result
     */
    @RequestMapping(QUERY_API_DETAIL)
    Result queryApiDetail(@RequestParam(name = "path") String path, @RequestParam(name = "method") String method);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.api.controller.ApiSourceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ApiSourceServiceProxy api() {
        return APIProxy.get(ApiSourceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
