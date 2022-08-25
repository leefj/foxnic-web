package org.github.foxnic.web.proxy.changes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.changes.ChangeDefinitionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 变更定义表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:44:55
 */
@FeignClient(value = MicroServiceNames.CHS, contextId = ChangeDefinitionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ChangeDefinitionServiceProxy {

    /**
     * 基础路径 , service-changes
     */
    public static final String API_BASIC_PATH = "service-changes";

    /**
     * API 上下文路径 , chs-change-definition
     */
    public static final String API_CONTEXT_PATH = "chs-change-definition";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加变更定义
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除变更定义
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除变更定义
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新变更定义
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存变更定义
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个变更定义
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个变更定义
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询变更定义
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询变更定义
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "changeDefinitionVO") ChangeDefinitionVO changeDefinitionVO);

    /**
     * 删除变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "changeDefinitionVO") ChangeDefinitionVO changeDefinitionVO);

    /**
     * 更新变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.SAVE)
    Result save(@RequestParam(name = "changeDefinitionVO") ChangeDefinitionVO changeDefinitionVO);

    /**
     * 获取变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.GET_BY_ID)
    Result<ChangeDefinition> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.GET_BY_IDS)
    Result<List<ChangeDefinition>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.QUERY_LIST)
    Result<List<ChangeDefinition>> queryList(@RequestParam(name = "sample") ChangeDefinitionVO sample);

    /**
     * 分页查询变更定义
     */
    @RequestMapping(ChangeDefinitionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ChangeDefinition>> queryPagedList(@RequestParam(name = "sample") ChangeDefinitionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.changes.controller.ChangeDefinitionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ChangeDefinitionServiceProxy api() {
        return APIProxy.get(ChangeDefinitionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
