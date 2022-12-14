package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.domain.system.ProfileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * Profile  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:42
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = ProfileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ProfileServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-profile
     */
    public static final String API_CONTEXT_PATH = "sys-profile";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加Profile
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除Profile
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除Profile
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新Profile
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存Profile
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个Profile
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个Profile
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询Profile
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询Profile
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加Profile
     */
    @RequestMapping(ProfileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "profileVO") ProfileVO profileVO);

    /**
     * 删除Profile
     */
    @RequestMapping(ProfileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除Profile
     */
    @RequestMapping(ProfileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新Profile
     */
    @RequestMapping(ProfileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "profileVO") ProfileVO profileVO);

    /**
     * 更新Profile
     */
    @RequestMapping(ProfileServiceProxy.SAVE)
    Result save(@RequestParam(name = "profileVO") ProfileVO profileVO);

    /**
     * 获取Profile
     */
    @RequestMapping(ProfileServiceProxy.GET_BY_ID)
    Result<Profile> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个Profile
     */
    @RequestMapping(ProfileServiceProxy.GET_BY_IDS)
    Result<List<Profile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询Profile
     */
    @RequestMapping(ProfileServiceProxy.QUERY_LIST)
    Result<List<Profile>> queryList(@RequestParam(name = "sample") ProfileVO sample);

    /**
     * 分页查询Profile
     */
    @RequestMapping(ProfileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Profile>> queryPagedList(@RequestParam(name = "sample") ProfileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.ProfileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ProfileServiceProxy api() {
        return APIProxy.get(ProfileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
