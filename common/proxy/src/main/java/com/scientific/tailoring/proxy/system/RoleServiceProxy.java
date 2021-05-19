package com.scientific.tailoring.proxy.system;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.Role;
import com.scientific.tailoring.domain.system.RoleVO;

/**
 * <p>
 * 角色表  控制器服务代理
 * </p>
 * @author 李方捷
 * @since 2021-04-29 02:38:17
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = RoleServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface RoleServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-role
	*/
	public static final String API_CONTEXT_PATH = "sys-role";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加角色
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除角色
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除角色
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新角色
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存角色
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取角色
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的角色
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的角色
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加角色
	*/
	@RequestMapping(RoleServiceProxy.INSERT)
	Result<Role> insert(RoleVO roleVO);
	
	/**
	 * 按主键删除角色
	*/
	@RequestMapping(RoleServiceProxy.DELETE)
	Result<Role> deleteById(Integer id);
	
	
	/**
	 * 按主键删除角色
	*/
	@RequestMapping(RoleServiceProxy.BATCH_DELETE)
	Result<Role> deleteByIds(List<Integer> id);
	
	/**
	 * 更新角色
	*/
	@RequestMapping(RoleServiceProxy.UPDATE)
	Result<Role> update(RoleVO roleVO);
	
	/**
	 * 更新角色
	*/
	@RequestMapping(RoleServiceProxy.SAVE)
	Result<Role> save(RoleVO roleVO);
	
	/**
	 * 按主键获取角色
	*/
	@RequestMapping(RoleServiceProxy.GET_BY_ID)
	Result<Role> getById(Integer id);
	
	/**
	 * 查询全部符合条件的角色
	*/
	@RequestMapping(RoleServiceProxy.QUERY_LIST)
	Result<List<Role>> queryList(RoleVO sample);
	
	/**
	 * 分页查询符合条件的角色
	*/
	@RequestMapping(RoleServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Role>> queryPagedList(RoleVO sample);

}