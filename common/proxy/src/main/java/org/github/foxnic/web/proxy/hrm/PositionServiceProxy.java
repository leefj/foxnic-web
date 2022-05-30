package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.PositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 岗位表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-12 15:26:13
 */
@FeignClient(value = MicroServiceNames.HRM, contextId = PositionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PositionServiceProxy {

    /**
     * 基础路径 , service-hrm
     */
    public static final String API_BASIC_PATH = "service-hrm";

    /**
     * API 上下文路径 , hrm-position
     */
    public static final String API_CONTEXT_PATH = "hrm-position";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加岗位
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除岗位
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除岗位
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新岗位
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存岗位
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个岗位
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个岗位
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询岗位
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询岗位
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出岗位数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载岗位导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入岗位数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加岗位
     */
    @RequestMapping(PositionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 删除岗位
     */
    @RequestMapping(PositionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除岗位
     */
    @RequestMapping(PositionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新岗位
     */
    @RequestMapping(PositionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 更新岗位
     */
    @RequestMapping(PositionServiceProxy.SAVE)
    Result save(@RequestParam(name = "positionVO") PositionVO positionVO);

    /**
     * 获取岗位
     */
    @RequestMapping(PositionServiceProxy.GET_BY_ID)
    Result<Position> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个岗位
     */
    @RequestMapping(PositionServiceProxy.GET_BY_IDS)
    Result<List<Position>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询岗位
     */
    @RequestMapping(PositionServiceProxy.QUERY_LIST)
    Result<List<Position>> queryList(@RequestParam(name = "sample") PositionVO sample);

    /**
     * 分页查询岗位
     */
    @RequestMapping(PositionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Position>> queryPagedList(@RequestParam(name = "sample") PositionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.hrm.controller.PositionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PositionServiceProxy api() {
        return APIProxy.get(PositionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
