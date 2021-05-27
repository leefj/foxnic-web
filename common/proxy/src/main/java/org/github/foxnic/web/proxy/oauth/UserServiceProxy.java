package org.github.foxnic.web.proxy.oauth;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 账户表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 01:57:42
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = UserServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface UserServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-user
	*/
	public static final String API_CONTEXT_PATH = "sys-user";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加账户
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除账户
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除账户
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新账户
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存账户
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取账户
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的账户
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的账户
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出Excel
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入Excel
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	
	/**
	 * 登录地址
	 * */
	public static String LOGIN_URI = "/security/login";
	
	/**
	 * 添加账户
	*/
	@RequestMapping(UserServiceProxy.INSERT)
	Result<User> insert(UserVO userVO);
	
	/**
	 * 按主键删除账户
	*/
	@RequestMapping(UserServiceProxy.DELETE)
	Result<User> deleteById(String id);
	
	
	/**
	 * 按主键删除账户
	*/
	@RequestMapping(UserServiceProxy.BATCH_DELETE)
	Result<User> deleteByIds(List<String> id);
	
	/**
	 * 更新账户
	*/
	@RequestMapping(UserServiceProxy.UPDATE)
	Result<User> update(UserVO userVO);
	
	/**
	 * 更新账户
	*/
	@RequestMapping(UserServiceProxy.SAVE)
	Result<User> save(UserVO userVO);
	
	/**
	 * 按主键获取账户
	*/
	@RequestMapping(UserServiceProxy.GET_BY_ID)
	Result<User> getById(String id);
	
	/**
	 * 查询全部符合条件的账户
	*/
	@RequestMapping(UserServiceProxy.QUERY_LIST)
	Result<List<User>> queryList(UserVO sample);
	
	/**
	 * 分页查询符合条件的账户
	*/
	@RequestMapping(UserServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<User>> queryPagedList(UserVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.UserController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static UserServiceProxy api() {
		return APIProxy.get(UserServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}