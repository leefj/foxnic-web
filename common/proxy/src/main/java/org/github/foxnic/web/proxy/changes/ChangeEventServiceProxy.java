package org.github.foxnic.web.proxy.changes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ChangeEventVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-29 16:28:18
*/

@FeignClient(value = MicroServiceNames.CHS, contextId = ChangeEventServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ChangeEventServiceProxy {
	
	/**
	 * 基础路径 , service-changes
	*/
	public static final String API_BASIC_PATH = "service-changes";
	
	/**
	 * API 上下文路径 , chs-change-event
	*/
	public static final String API_CONTEXT_PATH = "chs-change-event";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加chs_change_event
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除chs_change_event
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除chs_change_event
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新chs_change_event
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存chs_change_event
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个chs_change_event
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个chs_change_event
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询chs_change_event
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询chs_change_event
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出chs_change_event数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载chs_change_event导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入chs_change_event数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.INSERT)
	Result insert(ChangeEventVO changeEventVO);
	
	/**
	 * 删除chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.UPDATE)
	Result update(ChangeEventVO changeEventVO);
	
	/**
	 * 更新chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.SAVE)
	Result save(ChangeEventVO changeEventVO);
	
	/**
	 * 获取chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.GET_BY_ID)
	Result<ChangeEvent> getById(String id);

	/**
	 * 批量删除chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.GET_BY_IDS)
	Result<List<ChangeEvent>> getByIds(List<String> ids);
	/**
	 * 查询chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.QUERY_LIST)
	Result<List<ChangeEvent>> queryList(ChangeEventVO sample);
	
	/**
	 * 分页查询chs_change_event
	*/
	@RequestMapping(ChangeEventServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ChangeEvent>> queryPagedList(ChangeEventVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.changes.controller.ChangeEventController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ChangeEventServiceProxy api() {
		return APIProxy.get(ChangeEventServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}