package org.github.foxnic.web.proxy.system;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 语言条目表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = LangServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface LangServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-lang
     */
    public static final String API_CONTEXT_PATH = "sys-lang";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加语言条目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除语言条目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除语言条目
     */
    public static final String BATCH_DELETE = API_PREFIX + "batch-delete";

    /**
     * 更新语言条目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存语言条目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取语言条目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 查询语言条目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询语言条目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出语言条目数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载语言条目导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入语言条目数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加语言条目
     */
    @RequestMapping(LangServiceProxy.INSERT)
    Result insert(@RequestParam(name = "langVO") LangVO langVO);

    /**
     * 删除语言条目
     */
    @RequestMapping(LangServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "code") String code);

    /**
     * 批量删除语言条目
     */
    @RequestMapping(LangServiceProxy.BATCH_DELETE)
    Result deleteByIds(@RequestParam(name = "id") List<String> id);

    /**
     * 更新语言条目
     */
    @RequestMapping(LangServiceProxy.UPDATE)
    Result update(@RequestParam(name = "langVO") LangVO langVO);

    /**
     * 更新语言条目
     */
    @RequestMapping(LangServiceProxy.SAVE)
    Result save(@RequestParam(name = "langVO") LangVO langVO);

    /**
     * 获取语言条目
     */
    @RequestMapping(LangServiceProxy.GET_BY_ID)
    Result<Lang> getById(@RequestParam(name = "code") String code);

    /**
     * 查询语言条目
     */
    @RequestMapping(LangServiceProxy.QUERY_LIST)
    Result<List<Lang>> queryList(@RequestParam(name = "sample") LangVO sample);

    /**
     * 分页查询语言条目
     */
    @RequestMapping(LangServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Lang>> queryPagedList(@RequestParam(name = "sample") LangVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.LangController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static LangServiceProxy api() {
        return APIProxy.get(LangServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
