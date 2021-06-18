package org.github.foxnic.web.proxy.system;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.api.transter.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.DbCache;
import org.github.foxnic.web.domain.system.DbCacheVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 数据库缓存表，内存表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-18 13:12:07
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
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新数据库缓存
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存数据库缓存
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取数据库缓存
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
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
	Result<DbCache> insert(DbCacheVO dbCacheVO);
	
	/**
	 * 删除数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.DELETE)
	Result<DbCache> deleteById(String id);
	
	
	/**
	 * 批量删除数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.BATCH_DELETE)
	Result<DbCache> deleteByIds(List<String> id);
	
	/**
	 * 更新数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.UPDATE)
	Result<DbCache> update(DbCacheVO dbCacheVO);
	
	/**
	 * 更新数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.SAVE)
	Result<DbCache> save(DbCacheVO dbCacheVO);
	
	/**
	 * 获取数据库缓存
	*/
	@RequestMapping(DbCacheServiceProxy.GET_BY_ID)
	Result<DbCache> getById(String id);
	
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