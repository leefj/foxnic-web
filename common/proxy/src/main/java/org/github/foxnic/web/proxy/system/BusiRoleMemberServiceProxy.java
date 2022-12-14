package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import org.github.foxnic.web.domain.system.BusiRoleMemberVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 业务角色成员关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:40
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = BusiRoleMemberServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BusiRoleMemberServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-busi-role-member
     */
    public static final String API_CONTEXT_PATH = "sys-busi-role-member";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加业务角色成员关系
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 批量添加业务角色成员关系
     */
    public static final String INSERTS = API_PREFIX + "inserts";

    /**
     * 删除业务角色成员关系
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除业务角色成员关系
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新业务角色成员关系
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存业务角色成员关系
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个业务角色成员关系
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个业务角色成员关系
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询业务角色成员关系
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询业务角色成员关系
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.INSERT)
    Result insert(@RequestParam(name = "busiRoleMemberVO") BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 删除业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.UPDATE)
    Result update(@RequestParam(name = "busiRoleMemberVO") BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 更新业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.SAVE)
    Result save(@RequestParam(name = "busiRoleMemberVO") BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 获取业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.GET_BY_ID)
    Result<BusiRoleMember> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.GET_BY_IDS)
    Result<List<BusiRoleMember>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.QUERY_LIST)
    Result<List<BusiRoleMember>> queryList(@RequestParam(name = "sample") BusiRoleMemberVO sample);

    /**
     * 分页查询业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BusiRoleMember>> queryPagedList(@RequestParam(name = "sample") BusiRoleMemberVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.BusiRoleMemberController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BusiRoleMemberServiceProxy api() {
        return APIProxy.get(BusiRoleMemberServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
