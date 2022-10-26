package org.github.foxnic.web.proxy.docs;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 错误码
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-20 15:24:48
 * @version
 */
@FeignClient(value = MicroServiceNames.DOCS, contextId = DBTableMetaServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DBTableMetaServiceProxy {

    /**
     * 基础路径 , service-api
     */
    public static final String API_BASIC_PATH = "service-docs";

    /**
     * API 上下文路径 , sys-api-source
     */
    public static final String API_CONTEXT_PATH = "table-meta";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 查询表结构
     */
    public static final String QUERY_TABLE_META = API_PREFIX + "query-table-meta";


    /**
     * 查询表树
     */
    public static final String QUERY_TABLE_NODES = API_PREFIX + "query-table-nodes";

    /**
     * 查询表结构
     */
    @RequestMapping(DBTableMetaServiceProxy.QUERY_TABLE_META)
    Result queryTableMeta(@RequestParam(name = "table") String table);

    /**
     * 获得API接口节点
     * <p>获得API接口节点</p>
     * @return  Result&lt;List&lt;ZTreeNode&gt;&gt; 节点树形结构
     */
    @RequestMapping(QUERY_TABLE_NODES)
    Result<List<ZTreeNode>> queryTableNodes();

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "org.github.foxnic.web.docs.controller.DBTableMetaController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DBTableMetaServiceProxy api() {
        return APIProxy.get(DBTableMetaServiceProxy.class,  CONTROLLER_CLASS_NAME);
    }
}
