package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.system.UserRole;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.domain.system.UserRoleVO;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-30 01:30:12
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = UserRoleServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface UserRoleServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-user-role
	*/
	public static final String API_CONTEXT_PATH = "sys-user-role";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加用户角色关系
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除用户角色关系
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新用户角色关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取用户角色关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的用户角色关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的用户角色关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.INSERT)
	Result<UserRole> insert(UserRoleVO userRoleVO);
	
	/**
	 * 按主键删除用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.DELETE)
	Result<UserRole> deleteById(Integer id);
	
	/**
	 * 更新用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.UPDATE)
	Result<UserRole> update(UserRoleVO userRoleVO);
	
	/**
	 * 按主键获取用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.GET_BY_ID)
	Result<UserRole> getById(Integer id);
	
	/**
	 * 查询全部符合条件的用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.QUERY_LIST)
	Result<List<UserRole>> queryList(UserRoleVO sample);
	
	/**
	 * 分页查询符合条件的用户角色关系
	*/
	@RequestMapping(UserRoleServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<UserRole>> queryPagedList(UserRoleVO sample);

}