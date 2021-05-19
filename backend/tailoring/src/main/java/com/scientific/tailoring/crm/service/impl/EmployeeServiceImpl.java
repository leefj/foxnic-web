package com.scientific.tailoring.crm.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.crm.service.IEmployeeService;
import com.scientific.tailoring.domain.crm.Employee;
import com.scientific.tailoring.framework.DBConfigs;

/**
 * <p>
 * 公司员工关系表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Service("CrmEmployeeServiceImpl")
public class EmployeeServiceImpl extends SuperService<Employee> implements IEmployeeService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除公司员工关系
	 *
	 * @param id ID , 详情 : ID 
	 * @return 查询结果 , Employee对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Employee employee = new Employee();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		employee.setId(id);
		return dao.deleteEntity(employee);
	}
	
	/**
	 * 按主键删除公司员工关系
	 *
	 * @param id ID , 详情 : ID 
	 * @return 查询结果 , Employee对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Employee employee = new Employee();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		employee.setId(id);
		employee.setDeleted(true);
		employee.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		employee.setDeleteTime(new Date());
		return dao.updateEntity(employee,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取公司员工关系
	 *
	 * @param id ID , ID 
	 * @return 查询结果 , Employee对象
	 */
	public Employee getById(Long id) {
		Employee sample = new Employee();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

}