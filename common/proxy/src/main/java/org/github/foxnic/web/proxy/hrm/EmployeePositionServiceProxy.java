package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.hrm.EmployeePosition;
import org.github.foxnic.web.domain.hrm.EmployeePositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 *   控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-14 21:43:33
*/

@FeignClient(value = MicroServiceNames.HRM, contextId = EmployeePositionServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface EmployeePositionServiceProxy {
	
	/**
	 * 基础路径 , service-hrm
	*/
	public static final String API_BASIC_PATH = "service-hrm";
	
	/**
	 * API 上下文路径 , hrm-employee-position
	*/
	public static final String API_CONTEXT_PATH = "hrm-employee-position";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加hrm_employee_position
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除hrm_employee_position
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除hrm_employee_position
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新hrm_employee_position
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存hrm_employee_position
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个hrm_employee_position
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个hrm_employee_position
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询hrm_employee_position
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询hrm_employee_position
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出hrm_employee_position数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载hrm_employee_position导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入hrm_employee_position数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.INSERT)
	Result insert(EmployeePositionVO employeePositionVO);
	
	/**
	 * 删除hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.UPDATE)
	Result update(EmployeePositionVO employeePositionVO);
	
	/**
	 * 更新hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.SAVE)
	Result save(EmployeePositionVO employeePositionVO);
	
	/**
	 * 获取hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.GET_BY_ID)
	Result<EmployeePosition> getById(String id);

	/**
	 * 批量删除hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.GET_BY_IDS)
	Result<List<EmployeePosition>> getByIds(List<String> ids);
	/**
	 * 查询hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.QUERY_LIST)
	Result<List<EmployeePosition>> queryList(EmployeePositionVO sample);
	
	/**
	 * 分页查询hrm_employee_position
	*/
	@RequestMapping(EmployeePositionServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<EmployeePosition>> queryPagedList(EmployeePositionVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.hrm.controller.EmployeePositionController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static EmployeePositionServiceProxy api() {
		return APIProxy.get(EmployeePositionServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}