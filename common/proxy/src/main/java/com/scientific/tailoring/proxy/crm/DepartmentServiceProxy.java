package com.scientific.tailoring.proxy.crm;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scientific.tailoring.domain.crm.Department;
import com.scientific.tailoring.domain.crm.DepartmentVO;
import com.github.foxnic.dao.data.PagedList;
import org.springframework.cloud.openfeign.FeignClient;
import com.scientific.tailoring.framework.feign.FeignConfigs;
import com.scientific.tailoring.proxy.MicroServiceNames;
import com.github.foxnic.springboot.mvc.Result;

/**
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@FeignClient(value = MicroServiceNames.TAILORING, contextId = DepartmentServiceProxy.API_CONTEXT_PATH , configuration = FeignConfigs.class)
public interface DepartmentServiceProxy {
	
	/**
	 * 基础路径 , service-tailoring
	*/
	public static final String API_BASIC_PATH = "service-tailoring";
	
	/**
	 * API 上下文路径 , crm-department
	*/
	public static final String API_CONTEXT_PATH = "crm-department";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加客户部门
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 按主键删除客户部门
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 按主键批量删除虚拟试衣
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	/**
	 * 更新客户部门
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	/**
	 * 按主键获取客户部门
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询全部符合条件的客户部门
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询符合条件的客户部门
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 添加客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.INSERT)
	Result<Department> insert(DepartmentVO departmentVO);
	
	/**
	 * 按主键删除客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.DELETE)
	Result<Department> deleteById(Long id);
	
	/**
	 * 更新客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.UPDATE)
	Result<Department> update(DepartmentVO departmentVO);
	
	/**
	 * 按主键获取客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.GET_BY_ID)
	Result<Department> getById(Long id);
	
	/**
	 * 查询全部符合条件的客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.QUERY_LIST)
	Result<List<Department>> queryList(DepartmentVO sample);
	
	/**
	 * 分页查询符合条件的客户部门
	*/
	@RequestMapping(DepartmentServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Department>> queryPagedList(DepartmentVO sample);

}