package com.scientific.tailoring.crm.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.crm.Company;
/**
 * <p>
 * 客户公司表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

public interface ICompanyService extends ISuperService<Company> {
	
	
	/**
	 * 按主键删除客户公司
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Company对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除客户公司
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Company对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取客户公司
	 *
	 * @param id ID
	 * @return 查询结果 , Company对象
	 */
	Company getById(Long id);

}