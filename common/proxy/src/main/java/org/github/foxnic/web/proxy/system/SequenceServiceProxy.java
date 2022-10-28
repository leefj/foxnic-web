package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.Sequence;
import org.github.foxnic.web.domain.system.SequenceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 序列 控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:51
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = SequenceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SequenceServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-sequence
     */
    public static final String API_CONTEXT_PATH = "sys-sequence";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加序列
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除序列
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除序列
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新序列
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存序列
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个序列
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个序列
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询序列
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询序列
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 添加序列
     */
    @RequestMapping(SequenceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "sequenceVO") SequenceVO sequenceVO);

    /**
     * 删除序列
     */
    @RequestMapping(SequenceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "pk") String pk);

    /**
     * 批量删除序列
     */
    @RequestMapping(SequenceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "pks") List<String> pks);

    /**
     * 更新序列
     */
    @RequestMapping(SequenceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "sequenceVO") SequenceVO sequenceVO);

    /**
     * 更新序列
     */
    @RequestMapping(SequenceServiceProxy.SAVE)
    Result save(@RequestParam(name = "sequenceVO") SequenceVO sequenceVO);

    /**
     * 获取序列
     */
    @RequestMapping(SequenceServiceProxy.GET_BY_ID)
    Result<Sequence> getById(@RequestParam(name = "pk") String pk);

    /**
     * 获取多个序列
     */
    @RequestMapping(SequenceServiceProxy.GET_BY_IDS)
    Result<List<Sequence>> getByIds(@RequestParam(name = "pks") List<String> pks);

    /**
     * 查询序列
     */
    @RequestMapping(SequenceServiceProxy.QUERY_LIST)
    Result<List<Sequence>> queryList(@RequestParam(name = "sample") SequenceVO sample);

    /**
     * 分页查询序列
     */
    @RequestMapping(SequenceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Sequence>> queryPagedList(@RequestParam(name = "sample") SequenceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.SequenceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SequenceServiceProxy api() {
        return APIProxy.get(SequenceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
