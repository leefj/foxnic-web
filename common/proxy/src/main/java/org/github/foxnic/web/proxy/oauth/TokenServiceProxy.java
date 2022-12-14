package org.github.foxnic.web.proxy.oauth;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.Token;
import org.github.foxnic.web.domain.oauth.TokenVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * Token表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-02 14:46:36
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = TokenServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TokenServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-token
     */
    public static final String API_CONTEXT_PATH = "sys-token";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加Token
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除Token
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除Token
     */
    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";

    /**
     * 更新Token
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存Token
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取Token
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 查询Token
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询Token
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出Token数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 导入Token数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加Token
     */
    @RequestMapping(TokenServiceProxy.INSERT)
    Result insert(@RequestParam(name = "tokenVO") TokenVO tokenVO);

    /**
     * 删除Token
     */
    @RequestMapping(TokenServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") Integer id);

    /**
     * 批量删除Token
     */
    @RequestMapping(TokenServiceProxy.BATCH_DELETE)
    Result deleteByIds(@RequestParam(name = "id") List<Integer> id);

    /**
     * 更新Token
     */
    @RequestMapping(TokenServiceProxy.UPDATE)
    Result update(@RequestParam(name = "tokenVO") TokenVO tokenVO);

    /**
     * 更新Token
     */
    @RequestMapping(TokenServiceProxy.SAVE)
    Result save(@RequestParam(name = "tokenVO") TokenVO tokenVO);

    /**
     * 获取Token
     */
    @RequestMapping(TokenServiceProxy.GET_BY_ID)
    Result<Token> getById(@RequestParam(name = "id") Integer id);

    /**
     * 查询Token
     */
    @RequestMapping(TokenServiceProxy.QUERY_LIST)
    Result<List<Token>> queryList(@RequestParam(name = "sample") TokenVO sample);

    /**
     * 分页查询Token
     */
    @RequestMapping(TokenServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Token>> queryPagedList(@RequestParam(name = "sample") TokenVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.TokenController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TokenServiceProxy api() {
        return APIProxy.get(TokenServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
