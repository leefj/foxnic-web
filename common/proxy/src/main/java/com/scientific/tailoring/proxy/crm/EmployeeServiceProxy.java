package com.scientific.tailoring.proxy.crm;
import java.util.List;

import com.scientific.tailoring.domain.crm.Employee;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.crm.EmployeeVO;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = EmployeeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface EmployeeServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , crm-employee
	*/
	public static final String API_CONTEXT_PATH = "crm-employee";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加公司员工关系
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除公司员工关系
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新公司员工关系
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取公司员工关系
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的公司员工关系
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的公司员工关系
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.INSERT)
	Result<Employee> insert(EmployeeVO employeeVO);
	
	/**
	 * 按主键删除公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.DELETE)
	Result<Employee> deleteById(Long id);
	
	/**
	 * 更新公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.UPDATE)
	Result<Employee> update(EmployeeVO employeeVO);
	
	/**
	 * 按主键获取公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.GET_BY_ID)
	Result<Employee> getById(Long id);
	
	/**
	 * 查询全部符合条件的公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.QUERY_LIST)
	Result<List<Employee>> queryList(EmployeeVO sample);
	
	/**
	 * 分页查询符合条件的公司员工关系
	*/
	@RequestMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Employee>> queryPagedList(EmployeeVO sample);

}