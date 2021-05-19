package com.scientific.tailoring.proxy.system;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.domain.system.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-28 05:57:35
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = UserServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface UserServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , sys-user
	*/
	public static final String API_CONTEXT_PATH = "sys-user";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加用户
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除用户
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	/**
	 * 更新用户
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取用户
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	
	/**
	 * 按主键获取用户
	 */
	public static final String RESET_PASSWD = API_PREFIX + "reset-passwd";
	
	/**
	 * 查询全部符合条件的用户
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的用户
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加用户
	*/
	@RequestMapping(UserServiceProxy.INSERT)
	Result<User> insert(UserVO userVO);
	
	/**
	 * 按主键删除用户
	*/
	@RequestMapping(UserServiceProxy.DELETE)
	Result<User> deleteById(Long id);
	
	/**
	 * 更新用户
	*/
	@RequestMapping(UserServiceProxy.UPDATE)
	Result<User> update(UserVO userVO);
	
	/**
	 * 按主键获取用户
	*/
	@RequestMapping(UserServiceProxy.GET_BY_ID)
	Result<User> getById(Long id);
	
	/**
	 * 查询全部符合条件的用户
	*/
	@RequestMapping(UserServiceProxy.QUERY_LIST)
	Result<List<User>> queryList(UserVO sample);
	
	/**
	 * 分页查询符合条件的用户
	*/
	@RequestMapping(UserServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<User>> queryPagedList(UserVO sample);

}