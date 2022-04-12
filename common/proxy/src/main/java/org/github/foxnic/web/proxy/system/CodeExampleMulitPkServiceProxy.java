package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.system.CodeExampleMulitPk;
import org.github.foxnic.web.domain.system.CodeExampleMulitPkVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import java.util.Date;
import com.github.foxnic.api.proxy.ParameterNames;

/**
 * <p>
 * 主键多字段测试表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
 */
@FeignClient(value = MicroServiceNames.SYSTEM, contextId = CodeExampleMulitPkServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeExampleMulitPkServiceProxy {

    /**
     * 基础路径 , service-system
     */
    public static final String API_BASIC_PATH = "service-system";

    /**
     * API 上下文路径 , sys-code-example-mulit-pk
     */
    public static final String API_CONTEXT_PATH = "sys-code-example-mulit-pk";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加主键多字段测试
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除主键多字段测试
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 更新主键多字段测试
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存主键多字段测试
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个主键多字段测试
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 查询主键多字段测试
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询主键多字段测试
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出主键多字段测试数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载主键多字段测试导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入主键多字段测试数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.INSERT)
    @ParameterNames(value = {"codeExampleMulitPkVO"})
    Result insert(CodeExampleMulitPkVO codeExampleMulitPkVO);

    /**
     * 删除主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.DELETE)
    @ParameterNames(value = {"nid","day"})
    Result deleteById(Long nid, Date day);

    /**
     * 更新主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.UPDATE)
    @ParameterNames(value = {"codeExampleMulitPkVO"})
    Result update(CodeExampleMulitPkVO codeExampleMulitPkVO);

    /**
     * 更新主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.SAVE)
    @ParameterNames(value = {"codeExampleMulitPkVO"})
    Result save(CodeExampleMulitPkVO codeExampleMulitPkVO);

    /**
     * 获取主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.GET_BY_ID)
    @ParameterNames(value = {"nid","day"})
    Result<CodeExampleMulitPk> getById(Long nid, Date day);

    /**
     * 查询主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.QUERY_LIST)
    @ParameterNames(value = {"sample"})
    Result<List<CodeExampleMulitPk>> queryList(CodeExampleMulitPkVO sample);

    /**
     * 分页查询主键多字段测试
     */
    @RequestMapping(CodeExampleMulitPkServiceProxy.QUERY_PAGED_LIST)
    @ParameterNames(value = {"sample"})
    Result<PagedList<CodeExampleMulitPk>> queryPagedList(CodeExampleMulitPkVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.system.controller.CodeExampleMulitPkController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeExampleMulitPkServiceProxy api() {
        return APIProxy.get(CodeExampleMulitPkServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
