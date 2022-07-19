package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.CodeExample;
import org.github.foxnic.web.domain.system.CodeExampleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 代码生成示例主表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-19 15:10:31
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = CodeExampleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeExampleServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-code-example
     */
    public static final String API_CONTEXT_PATH = "sys-code-example";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加代码生成示例主
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除代码生成示例主
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除代码生成示例主
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新代码生成示例主
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存代码生成示例主
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个代码生成示例主
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个代码生成示例主
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询代码生成示例主
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询代码生成示例主
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codeExampleVO") CodeExampleVO codeExampleVO);

    /**
     * 删除代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codeExampleVO") CodeExampleVO codeExampleVO);

    /**
     * 更新代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.SAVE)
    Result save(@RequestParam(name = "codeExampleVO") CodeExampleVO codeExampleVO);

    /**
     * 获取代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.GET_BY_ID)
    Result<CodeExample> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.GET_BY_IDS)
    Result<List<CodeExample>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.QUERY_LIST)
    Result<List<CodeExample>> queryList(@RequestParam(name = "sample") CodeExampleVO sample);

    /**
     * 分页查询代码生成示例主
     */
    @RequestMapping(CodeExampleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodeExample>> queryPagedList(@RequestParam(name = "sample") CodeExampleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.CodeExampleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeExampleServiceProxy api() {
        return APIProxy.get(CodeExampleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
