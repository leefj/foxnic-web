package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import org.github.foxnic.web.domain.system.BusiRoleMemberVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 业务角色成员关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-15 14:49:50
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
     * 导出业务角色成员关系数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载业务角色成员关系导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入业务角色成员关系数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.INSERT)
    @ParameterNames(value = {"busiRoleMemberVO"})
    Result insert(BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 删除业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.DELETE)
    @ParameterNames(value = {"id"})
    Result deleteById(String id);

    /**
     * 批量删除业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result deleteByIds(List<String> ids);

    /**
     * 更新业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.UPDATE)
    @ParameterNames(value = {"busiRoleMemberVO"})
    Result update(BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 更新业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.SAVE)
    @ParameterNames(value = {"busiRoleMemberVO"})
    Result save(BusiRoleMemberVO busiRoleMemberVO);

    /**
     * 获取业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"id"})
    Result<BusiRoleMember> getById(String id);

    /**
     * 批量删除业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"ids"})
    Result<List<BusiRoleMember>> getByIds(List<String> ids);

    /**
     * 查询业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<BusiRoleMember>> queryList(BusiRoleMemberVO sample);

    /**
     * 分页查询业务角色成员关系
     */
    @RequestMapping(BusiRoleMemberServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<BusiRoleMember>> queryPagedList(BusiRoleMemberVO sample);

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
