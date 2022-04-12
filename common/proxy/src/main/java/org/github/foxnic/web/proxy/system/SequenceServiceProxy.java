package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.Sequence;
import org.github.foxnic.web.domain.system.SequenceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 序列表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-23 14:14:07
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
     * 导出序列数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载序列导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入序列数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加序列
     */
    @RequestMapping(SequenceServiceProxy.INSERT)
    @ParameterNames(value = {"sequenceVO"})
    Result insert(SequenceVO sequenceVO);

    /**
     * 删除序列
     */
    @RequestMapping(SequenceServiceProxy.DELETE)
    @ParameterNames(value = {"pk"})
    Result deleteById(String pk);

    /**
     * 批量删除序列
     */
    @RequestMapping(SequenceServiceProxy.DELETE_BY_IDS)
    @ParameterNames(value = {"pks"})
    Result deleteByIds(List<String> pks);

    /**
     * 更新序列
     */
    @RequestMapping(SequenceServiceProxy.UPDATE)
    @ParameterNames(value = {"sequenceVO"})
    Result update(SequenceVO sequenceVO);

    /**
     * 更新序列
     */
    @RequestMapping(SequenceServiceProxy.SAVE)
    @ParameterNames(value = {"sequenceVO"})
    Result save(SequenceVO sequenceVO);

    /**
     * 获取序列
     */
    @RequestMapping(SequenceServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"pk"})
    Result<Sequence> getById(String pk);

    /**
     * 批量删除序列
     */
    @RequestMapping(SequenceServiceProxy.GET_BY_IDS)
    @ParameterNames(value = {"pks"})
    Result<List<Sequence>> getByIds(List<String> pks);

    /**
     * 查询序列
     */
    @RequestMapping(SequenceServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<Sequence>> queryList(SequenceVO sample);

    /**
     * 分页查询序列
     */
    @RequestMapping(SequenceServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<Sequence>> queryPagedList(SequenceVO sample);

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
