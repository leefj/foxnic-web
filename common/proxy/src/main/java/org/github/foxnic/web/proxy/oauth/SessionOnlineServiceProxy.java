package org.github.foxnic.web.proxy.oauth;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.SessionOnlineVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 在线会话表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-27 05:28:14
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = SessionOnlineServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface SessionOnlineServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-session-online
	*/
	public static final String API_CONTEXT_PATH = "sys-session-online";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加在线会话
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除在线会话
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 按主键删除在线会话
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新在线会话
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存在线会话
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 按主键获取在线会话
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的在线会话
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的在线会话
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
	 * 添加在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.INSERT)
	Result<SessionOnline> insert(SessionOnlineVO sessionOnlineVO);
	
	/**
	 * 按主键删除在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.DELETE)
	Result<SessionOnline> deleteById(String id);
	
	
	/**
	 * 按主键删除在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.BATCH_DELETE)
	Result<SessionOnline> deleteByIds(List<String> id);
	
	/**
	 * 更新在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.UPDATE)
	Result<SessionOnline> update(SessionOnlineVO sessionOnlineVO);
	
	/**
	 * 更新在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.SAVE)
	Result<SessionOnline> save(SessionOnlineVO sessionOnlineVO);
	
	/**
	 * 按主键获取在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.GET_BY_ID)
	Result<SessionOnline> getById(String id);
	
	/**
	 * 查询全部符合条件的在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.QUERY_LIST)
	Result<List<SessionOnline>> queryList(SessionOnlineVO sample);
	
	/**
	 * 分页查询符合条件的在线会话
	*/
	@RequestMapping(SessionOnlineServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<SessionOnline>> queryPagedList(SessionOnlineVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.SessionOnlineController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static SessionOnlineServiceProxy api() {
		return APIProxy.get(SessionOnlineServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}