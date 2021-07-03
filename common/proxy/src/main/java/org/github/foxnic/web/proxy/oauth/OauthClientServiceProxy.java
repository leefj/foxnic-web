package org.github.foxnic.web.proxy.oauth;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.oauth.OauthClient;
import org.github.foxnic.web.domain.oauth.OauthClientVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 认证客户端  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 14:17:03
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = OauthClientServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface OauthClientServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-oauth-client
	*/
	public static final String API_CONTEXT_PATH = "sys-oauth-client";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加认证客户端
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除认证客户端
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除认证客户端
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新认证客户端
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存认证客户端
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取认证客户端
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询认证客户端
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询认证客户端
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出认证客户端数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入认证客户端数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.INSERT)
	Result insert(OauthClientVO oauthClientVO);
	
	/**
	 * 删除认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.DELETE)
	Result deleteById(String id);
	
	
	/**
	 * 批量删除认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.BATCH_DELETE)
	Result deleteByIds(List<String> id);
	
	/**
	 * 更新认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.UPDATE)
	Result update(OauthClientVO oauthClientVO);
	
	/**
	 * 更新认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.SAVE)
	Result save(OauthClientVO oauthClientVO);
	
	/**
	 * 获取认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.GET_BY_ID)
	Result<OauthClient> getById(String id);
	
	/**
	 * 查询认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.QUERY_LIST)
	Result<List<OauthClient>> queryList(OauthClientVO sample);
	
	/**
	 * 分页查询认证客户端
	*/
	@RequestMapping(OauthClientServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<OauthClient>> queryPagedList(OauthClientVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.OauthClientController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static OauthClientServiceProxy api() {
		return APIProxy.get(OauthClientServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}