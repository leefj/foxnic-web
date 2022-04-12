package org.github.foxnic.web.proxy.oauth;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.SessionOnlineVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 在线会话表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:03
 */
@FeignClient(value = MicroServiceNames.OAUTH, contextId = SessionOnlineServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SessionOnlineServiceProxy {

    /**
     * 基础路径 , service-oauth
     */
    public static final String API_BASIC_PATH = "service-oauth";

    /**
     * API 上下文路径 , sys-session-online
     */
    public static final String API_CONTEXT_PATH = "sys-session-online";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加在线会话
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除在线会话
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除在线会话
     */
    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";

    /**
     * 更新在线会话
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存在线会话
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取在线会话
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 查询在线会话
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询在线会话
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出在线会话数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 导入在线会话数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.INSERT)
    @ParameterNames(value = {"sessionOnlineVO"})
    Result insert(SessionOnlineVO sessionOnlineVO);

    /**
     * 删除在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.BATCH_DELETE)
    @ParameterNames(value = {"id"})
    Result deleteByIds(List<String> id);

    /**
     * 更新在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.UPDATE)
    @ParameterNames(value = {"sessionOnlineVO"})
    Result update(SessionOnlineVO sessionOnlineVO);

    /**
     * 更新在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.SAVE)
    @ParameterNames(value = {"sessionOnlineVO"})
    Result save(SessionOnlineVO sessionOnlineVO);

    /**
     * 获取在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<SessionOnline> getById(String id);

    /**
     * 查询在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<SessionOnline>> queryList(SessionOnlineVO sample);

    /**
     * 分页查询在线会话
     */
    @RequestMapping(SessionOnlineServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<SessionOnline>> queryPagedList(SessionOnlineVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.oauth.controller.SessionOnlineController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SessionOnlineServiceProxy api() {
        return APIProxy.get(SessionOnlineServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
