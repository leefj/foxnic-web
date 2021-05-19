package com.scientific.tailoring.crm.service.impl;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.crm.service.ICompanyService;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.proxy.system.UserServiceProxy;

/**
 * <p>
 * 客户公司表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:36
*/

@Service("CrmCompanyServiceImpl")
public class CompanyServiceImpl extends SuperService<Company> implements  ICompanyService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	@Autowired
	UserServiceProxy userServiceAgent;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除客户公司
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Company对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		Company company = new Company();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		company.setId(id);
		return dao.deleteEntity(company);
	}
	
	/**
	 * 按主键删除客户公司
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , Company对象
	 */
	public boolean deleteByIdLogical(Long id) {
		Company company = new Company();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		company.setId(id);
		company.setDeleted(true);
		company.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		company.setDeleteTime(new Date());
		return dao.updateEntity(company,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取客户公司
	 *
	 * @param id ID
	 * @return 查询结果 , Company对象
	 */
	public Company getById(Long id) {
		Company sample = new Company();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

}