package org.github.foxnic.web.proxy.bpm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.FormDefinitionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 表单定义表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:56
 */
@FeignClient(value = MicroServiceNames.BPM, contextId = FormDefinitionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FormDefinitionServiceProxy {

    /**
     * 基础路径 , service-bpm
     */
    public static final String API_BASIC_PATH = "service-bpm";

    /**
     * API 上下文路径 , bpm-form-definition
     */
    public static final String API_CONTEXT_PATH = "bpm-form-definition";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加表单定义
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除表单定义
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除表单定义
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新表单定义
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存表单定义
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个表单定义
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个表单定义
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询表单定义
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询表单定义
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "formDefinitionVO") FormDefinitionVO formDefinitionVO);

    /**
     * 删除表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "formDefinitionVO") FormDefinitionVO formDefinitionVO);

    /**
     * 更新表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.SAVE)
    Result save(@RequestParam(name = "formDefinitionVO") FormDefinitionVO formDefinitionVO);

    /**
     * 获取表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.GET_BY_ID)
    Result<FormDefinition> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.GET_BY_IDS)
    Result<List<FormDefinition>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.QUERY_LIST)
    Result<List<FormDefinition>> queryList(@RequestParam(name = "sample") FormDefinitionVO sample);

    /**
     * 分页查询表单定义
     */
    @RequestMapping(FormDefinitionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FormDefinition>> queryPagedList(@RequestParam(name = "sample") FormDefinitionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.bpm.controller.FormDefinitionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FormDefinitionServiceProxy api() {
        return APIProxy.get(FormDefinitionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
