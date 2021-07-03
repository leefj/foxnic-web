package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据库缓存表，内存表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-03 16:01:50
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = DbCacheServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface DbCacheServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-db-cache
	*/
	public static final String API_CONTEXT_PATH = "sys-db-cache";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加数据库缓存
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除数据库缓存
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据库缓存
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新数据库缓存
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存数据库缓存
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个数据库缓存
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据库缓存
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询数据库缓存
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询数据库缓存
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出数据库缓存数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据库缓存导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入数据库缓存数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.INSERT)
	Result insert(DbCacheVO dbCacheVO);
	
	/**
	 * 删除数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.UPDATE)
	Result update(DbCacheVO dbCacheVO);
	
	/**
	 * 更新数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.SAVE)
	Result save(DbCacheVO dbCacheVO);
	
	/**
	 * 获取数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.GET_BY_ID)
	Result<DbCache> getById(String id);

	/**
	 * 批量删除数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.GET_BY_IDS)
	Result<List<DbCache>> getByIds(List<String> ids);
	/**
	 * 查询数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.QUERY_LIST)
	Result<List<DbCache>> queryList(DbCacheVO sample);
	
	/**
	 * 分页查询数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<DbCache>> queryPagedList(DbCacheVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.DbCacheController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static DbCacheServiceProxy api() {
		return APIProxy.get(DbCacheServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}