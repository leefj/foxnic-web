package com.scientific.tailoring.crm.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.crm.Employee;
import com.scientific.tailoring.domain.crm.meta.EmployeeMeta;
/**
 * <p>
 * 公司员工关系表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

public interface IEmployeeService extends ISuperService<Employee> {
	
	/**
	 * 按主键删除公司员工关系
	 *
	 * @param id ID , 详情 : ID 
	 * @return 查询结果 , Employee对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除公司员工关系
	 *
	 * @param id ID , 详情 : ID 
	 * @return 查询结果 , Employee对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取公司员工关系
	 *
	 * @param id ID , ID 
	 * @return 查询结果 , Employee对象
	 */
	Employee getById(Long id);

}