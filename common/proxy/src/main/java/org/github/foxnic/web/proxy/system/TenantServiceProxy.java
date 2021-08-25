package org.github.foxnic.web.proxy.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.system.TenantVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 租户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-25 09:33:33
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = TenantServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface TenantServiceProxy {
	
	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";
	
	/**
	 * API 上下文路径 , sys-tenant
	*/
	public static final String API_CONTEXT_PATH = "sys-tenant";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加租户
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除租户
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除租户
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新租户
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存租户
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个租户
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个租户
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询租户
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询租户
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出租户数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载租户导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入租户数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加租户
	*/
	@RequestMapping(TenantServiceProxy.INSERT)
	Result insert(TenantVO tenantVO);
	
	/**
	 * 删除租户
	*/
	@RequestMapping(TenantServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除租户
	*/
	@RequestMapping(TenantServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新租户
	*/
	@RequestMapping(TenantServiceProxy.UPDATE)
	Result update(TenantVO tenantVO);
	
	/**
	 * 更新租户
	*/
	@RequestMapping(TenantServiceProxy.SAVE)
	Result save(TenantVO tenantVO);
	
	/**
	 * 获取租户
	*/
	@RequestMapping(TenantServiceProxy.GET_BY_ID)
	Result<Tenant> getById(String id);

	/**
	 * 批量删除租户
	*/
	@RequestMapping(TenantServiceProxy.GET_BY_IDS)
	Result<List<Tenant>> getByIds(List<String> ids);
	/**
	 * 查询租户
	*/
	@RequestMapping(TenantServiceProxy.QUERY_LIST)
	Result<List<Tenant>> queryList(TenantVO sample);
	
	/**
	 * 分页查询租户
	*/
	@RequestMapping(TenantServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Tenant>> queryPagedList(TenantVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.TenantController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static TenantServiceProxy api() {
		return APIProxy.get(TenantServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}