package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.system.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;

import com.scientific.tailoring.domain.system.Menu;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-19 09:11:17
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = MenuServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface MenuServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-menu
	*/
	public static final String API_CONTEXT_PATH = "sys-menu";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加功能菜单
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除功能菜单
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新功能菜单
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取功能菜单
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的功能菜单
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的功能菜单
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加功能菜单
	*/
	@RequestMapping(MenuServiceProxy.INSERT)
	Result<Menu> insert(MenuVO menuVO);
	
	/**
	 * 按主键删除功能菜单
	*/
	@RequestMapping(MenuServiceProxy.DELETE)
	Result<Menu> deleteById(Integer id);
	
	/**
	 * 更新功能菜单
	*/
	@RequestMapping(MenuServiceProxy.UPDATE)
	Result<Menu> update(MenuVO menuVO);
	
	/**
	 * 按主键获取功能菜单
	*/
	@RequestMapping(MenuServiceProxy.GET_BY_ID)
	Result<Menu> getById(Integer id);
	
	/**
	 * 查询全部符合条件的功能菜单
	*/
	@RequestMapping(MenuServiceProxy.QUERY_LIST)
	Result<List<Menu>> queryList(MenuVO sample);
	
	/**
	 * 分页查询符合条件的功能菜单
	*/
	@RequestMapping(MenuServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Menu>> queryPagedList(MenuVO sample);

}