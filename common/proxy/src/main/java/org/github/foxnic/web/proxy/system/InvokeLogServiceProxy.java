package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.InvokeLog;
import org.github.foxnic.web.domain.system.InvokeLogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 调用统计日志  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-26 10:48:09
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = InvokeLogServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface InvokeLogServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-invoke-log
	*/
	public static final String API_CONTEXT_PATH = "sys-invoke-log";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加调用统计日志
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除调用统计日志
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除调用统计日志
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新调用统计日志
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存调用统计日志
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取调用统计日志
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询调用统计日志
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询调用统计日志
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出调用统计日志数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载调用统计日志导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入调用统计日志数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.INSERT)
	Result<InvokeLog> insert(InvokeLogVO invokeLogVO);
	
	/**
	 * 删除调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.DELETE)
	Result<InvokeLog> deleteById(Long id);
	
	
	/**
	 * 批量删除调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.BATCH_DELETE)
	Result<InvokeLog> deleteByIds(List<Long> id);
	
	/**
	 * 更新调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.UPDATE)
	Result<InvokeLog> update(InvokeLogVO invokeLogVO);
	
	/**
	 * 更新调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.SAVE)
	Result<InvokeLog> save(InvokeLogVO invokeLogVO);
	
	/**
	 * 获取调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.GET_BY_ID)
	Result<InvokeLog> getById(Long id);
	
	/**
	 * 查询调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.QUERY_LIST)
	Result<List<InvokeLog>> queryList(InvokeLogVO sample);
	
	/**
	 * 分页查询调用统计日志
	*/
	@RequestMapping(InvokeLogServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<InvokeLog>> queryPagedList(InvokeLogVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.InvokeLogController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static InvokeLogServiceProxy api() {
		return APIProxy.get(InvokeLogServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}