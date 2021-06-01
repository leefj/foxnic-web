package org.github.foxnic.web.proxy.oauth;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 菜单表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:03
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = MenuServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MenuServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-menu
	*/
	public static final String API_CONTEXT_PATH = "sys-menu";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加菜单
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除菜单
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除菜单
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新菜单
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存菜单
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取菜单
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询菜单
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询菜单
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出菜单数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入菜单数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加菜单
	*/
	@RequestMapping(MenuServiceProxy.INSERT)
	Result<Menu> insert(MenuVO menuVO);
	
	/**
	 * 删除菜单
	*/
	@RequestMapping(MenuServiceProxy.DELETE)
	Result<Menu> deleteById(String id);
	
	
	/**
	 * 批量删除菜单
	*/
	@RequestMapping(MenuServiceProxy.BATCH_DELETE)
	Result<Menu> deleteByIds(List<String> id);
	
	/**
	 * 更新菜单
	*/
	@RequestMapping(MenuServiceProxy.UPDATE)
	Result<Menu> update(MenuVO menuVO);
	
	/**
	 * 更新菜单
	*/
	@RequestMapping(MenuServiceProxy.SAVE)
	Result<Menu> save(MenuVO menuVO);
	
	/**
	 * 获取菜单
	*/
	@RequestMapping(MenuServiceProxy.GET_BY_ID)
	Result<Menu> getById(String id);
	
	/**
	 * 查询菜单
	*/
	@RequestMapping(MenuServiceProxy.QUERY_LIST)
	Result<List<Menu>> queryList(MenuVO sample);
	
	/**
	 * 分页查询菜单
	*/
	@RequestMapping(MenuServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Menu>> queryPagedList(MenuVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.MenuController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MenuServiceProxy api() {
		return APIProxy.get(MenuServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}