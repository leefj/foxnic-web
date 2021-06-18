package org.github.foxnic.web.proxy.oauth;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.api.transter.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.RoleMenuVO;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 角色账户关系表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:04
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = RoleMenuServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface RoleMenuServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-role-menu
	*/
	public static final String API_CONTEXT_PATH = "sys-role-menu";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加角色账户关系
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除角色账户关系
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除角色账户关系
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新角色账户关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存角色账户关系
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取角色账户关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询角色账户关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询角色账户关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出角色账户关系数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入角色账户关系数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.INSERT)
	Result<RoleMenu> insert(RoleMenuVO roleMenuVO);
	
	/**
	 * 删除角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.DELETE)
	Result<RoleMenu> deleteById(String id);
	
	
	/**
	 * 批量删除角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.BATCH_DELETE)
	Result<RoleMenu> deleteByIds(List<String> id);
	
	/**
	 * 更新角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.UPDATE)
	Result<RoleMenu> update(RoleMenuVO roleMenuVO);
	
	/**
	 * 更新角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.SAVE)
	Result<RoleMenu> save(RoleMenuVO roleMenuVO);
	
	/**
	 * 获取角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.GET_BY_ID)
	Result<RoleMenu> getById(String id);
	
	/**
	 * 查询角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.QUERY_LIST)
	Result<List<RoleMenu>> queryList(RoleMenuVO sample);
	
	/**
	 * 分页查询角色账户关系
	*/
	@RequestMapping(RoleMenuServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<RoleMenu>> queryPagedList(RoleMenuVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.RoleMenuController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static RoleMenuServiceProxy api() {
		return APIProxy.get(RoleMenuServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}