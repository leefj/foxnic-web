package com.scientific.tailoring.crm.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.crm.Department;
import com.scientific.tailoring.domain.crm.meta.DepartmentMeta;
/**
 * <p>
 * 客户部门表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

public interface IDepartmentService extends ISuperService<Department> {

	/**
	 * 按主键删除客户部门
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Department对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除客户部门
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Department对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取客户部门
	 *
	 * @param id ID
	 * @return 查询结果 , Department对象
	 */
	Department getById(Long id);

}