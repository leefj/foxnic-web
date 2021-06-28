package org.github.foxnic.web.proxy.oauth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.ResourzeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 系统资源  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-28 15:36:23
*/

@FeignClient(value = MicroServiceNames.OAUTH, contextId = ResourzeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ResourzeServiceProxy {
	
	/**
	 * 基础路径 , service-oauth
	*/
	public static final String API_BASIC_PATH = "service-oauth";
	
	/**
	 * API 上下文路径 , sys-resourze
	*/
	public static final String API_CONTEXT_PATH = "sys-resourze";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加系统资源
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除系统资源
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除系统资源
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新系统资源
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存系统资源
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个系统资源
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个系统资源
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询系统资源
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询系统资源
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出系统资源数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载系统资源导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入系统资源数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.INSERT)
	Result<Resourze> insert(ResourzeVO resourzeVO);
	
	/**
	 * 删除系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.DELETE)
	Result<Resourze> deleteById(String id);

	/**
	 * 批量删除系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.DELETE_BY_IDS)
	Result<Resourze> deleteByIds(List<String> ids);

	/**
	 * 更新系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.UPDATE)
	Result<Resourze> update(ResourzeVO resourzeVO);
	
	/**
	 * 更新系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.SAVE)
	Result<Resourze> save(ResourzeVO resourzeVO);
	
	/**
	 * 获取系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.GET_BY_ID)
	Result<Resourze> getById(String id);

	/**
	 * 批量删除系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.GET_BY_IDS)
	Result<List<Resourze>> getByIds(List<String> ids);
	/**
	 * 查询系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.QUERY_LIST)
	Result<List<Resourze>> queryList(ResourzeVO sample);
	
	/**
	 * 分页查询系统资源
	*/
	@RequestMapping(ResourzeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Resourze>> queryPagedList(ResourzeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.oauth.controller.ResourzeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ResourzeServiceProxy api() {
		return APIProxy.get(ResourzeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}