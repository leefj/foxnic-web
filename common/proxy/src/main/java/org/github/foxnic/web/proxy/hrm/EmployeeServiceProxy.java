package org.github.foxnic.web.proxy.hrm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.MicroServiceNames;

/**
 * <p>
 * 员工表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 17:26:51
*/

@FeignClient(value = MicroServiceNames.HRM, contextId = EmployeeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface EmployeeServiceProxy {
	
	/**
	 * 基础路径 , service-hrm
	*/
	public static final String API_BASIC_PATH = "service-hrm";
	
	/**
	 * API 上下文路径 , hrm-employee
	*/
	public static final String API_CONTEXT_PATH = "hrm-employee";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加员工
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除员工
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除员工
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新员工
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存员工
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个员工
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个员工
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询员工
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询员工
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出员工数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载员工导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入员工数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加员工
	*/
	@RequestMapping(EmployeeServiceProxy.INSERT)
	Result insert(EmployeeVO employeeVO);
	
	/**
	 * 删除员工
	*/
	@RequestMapping(EmployeeServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除员工
	*/
	@RequestMapping(EmployeeServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新员工
	*/
	@RequestMapping(EmployeeServiceProxy.UPDATE)
	Result update(EmployeeVO employeeVO);
	
	/**
	 * 更新员工
	*/
	@RequestMapping(EmployeeServiceProxy.SAVE)
	Result save(EmployeeVO employeeVO);
	
	/**
	 * 获取员工
	*/
	@RequestMapping(EmployeeServiceProxy.GET_BY_ID)
	Result<Employee> getById(String id);

	/**
	 * 批量删除员工
	*/
	@RequestMapping(EmployeeServiceProxy.GET_BY_IDS)
	Result<List<Employee>> getByIds(List<String> ids);
	/**
	 * 查询员工
	*/
	@RequestMapping(EmployeeServiceProxy.QUERY_LIST)
	Result<List<Employee>> queryList(EmployeeVO sample);
	
	/**
	 * 分页查询员工
	*/
	@RequestMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Employee>> queryPagedList(EmployeeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.hrm.controller.EmployeeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static EmployeeServiceProxy api() {
		return APIProxy.get(EmployeeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}