package com.scientific.tailoring.crm.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.crm.service.IDepartmentService;
import com.scientific.tailoring.domain.crm.Department;
import com.scientific.tailoring.framework.DBConfigs;

/**
 * <p>
 * 客户部门表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Service("CrmDepartmentServiceImpl")
public class DepartmentServiceImpl extends SuperService<Department> implements IDepartmentService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除客户部门
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Department对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Department department = new Department();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		department.setId(id);
		return dao.deleteEntity(department);
	}
	
	/**
	 * 按主键删除客户部门
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Department对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Department department = new Department();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		department.setId(id);
		department.setDeleted(true);
		department.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		department.setDeleteTime(new Date());
		return dao.updateEntity(department,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取客户部门
	 *
	 * @param id ID
	 * @return 查询结果 , Department对象
	 */
	public Department getById(Long id) {
		Department sample = new Department();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

}