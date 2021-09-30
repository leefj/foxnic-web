package org.github.foxnic.web.proxy.changes;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.changes.ChangeInstanceVO;
import org.github.foxnic.web.domain.changes.ChangeRequestBody;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 变更实例表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-29 10:50:33
 * @version
*/

@FeignClient(value = MicroServiceNames.CHS, contextId = ChangeInstanceServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ChangeInstanceServiceProxy {
	
	/**
	 * 基础路径 , service-changes
	*/
	public static final String API_BASIC_PATH = "service-changes";
	
	/**
	 * API 上下文路径 , chs-change-instance
	*/
	public static final String API_CONTEXT_PATH = "chs-change-instance";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加变更实例
	 */
	public static final String INSERT = API_PREFIX + "insert";

	/**
	 * 请求变更
	 */
	public static final String REQUEST = API_PREFIX + "request";
	
	/**
	 * 删除变更实例
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除变更实例
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新变更实例
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存变更实例
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个变更实例
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个变更实例
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询变更实例
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询变更实例
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出变更实例数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载变更实例导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入变更实例数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 请求变更
	*/
	@RequestMapping(ChangeInstanceServiceProxy.REQUEST)
	Result<ChangeInstance> request(ChangeRequestBody request);
	
	/**
	 * 删除变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.UPDATE)
	Result update(ChangeInstanceVO changeInstanceVO);
	
	/**
	 * 更新变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.SAVE)
	Result save(ChangeInstanceVO changeInstanceVO);
	
	/**
	 * 获取变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.GET_BY_ID)
	Result<ChangeInstance> getById(String id);

	/**
	 * 批量删除变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.GET_BY_IDS)
	Result<List<ChangeInstance>> getByIds(List<String> ids);
	/**
	 * 查询变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.QUERY_LIST)
	Result<List<ChangeInstance>> queryList(ChangeInstanceVO sample);
	
	/**
	 * 分页查询变更实例
	*/
	@RequestMapping(ChangeInstanceServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ChangeInstance>> queryPagedList(ChangeInstanceVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.changes.controller.ChangeInstanceController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ChangeInstanceServiceProxy api() {
		return APIProxy.get(ChangeInstanceServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}