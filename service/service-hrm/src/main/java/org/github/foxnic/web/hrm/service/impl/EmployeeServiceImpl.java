package org.github.foxnic.web.hrm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.IEmployeeService;
import org.github.foxnic.web.hrm.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 员工表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 16:34:10
 * @auto-code false
*/


@Service("HrmEmployeeService")
public class EmployeeServiceImpl extends SuperService<Employee> implements IEmployeeService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired 
	private IPersonService personService;

	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param employee 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Employee employee) {
		Person person= BeanUtil.copy(employee,Person.create(),false);
		Result r = personService.insert(person);
		if(r.success()) {
			employee.setPersonId(person.getId());
			r = super.insert(employee);
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param employeeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Employee> employeeList) {
		return super.insertList(employeeList);
	}
	
	
	/**
	 * 按主键删除 员工
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	@Transactional
	public Result deleteByIdPhysical(String id) {

		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		Employee employee = this.getById(id);
		try {
			boolean suc = dao.deleteEntity(employee);
			if(suc) {
				Result r=personService.deleteByIdPhysical(employee.getPersonId());
				if(r.failure()) return r;
			}
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 员工
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	@Transactional
	public Result deleteByIdLogical(String id) {
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		Employee employee = this.getById(id);
		employee.setDeleted(dao.getDBTreaty().getTrueValue());
		employee.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		employee.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(employee,SaveMode.NOT_NULL_FIELDS);
			if(suc) {
				Result r=personService.deleteByIdLogical(employee.getPersonId());
				if(r.failure()) return r;
			}
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	@Override
	@Transactional
	public <T> Result deleteByIdsLogical(List<T> ids) {
		List<Employee> emps= this.getByIds((List<String>)ids);
		List<String> pIds= CollectorUtil.collectList(emps,Employee::getPersonId);
		Result r=personService.deleteByIdsLogical(pIds);
		if(r.failure()) return  r;
		return super.deleteByIdsLogical(ids);
	}

	/**
	 * 更新实体
	 * @param employee 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Employee employee , SaveMode mode) {
		Person person= personService.getById(employee.getPersonId());
		BeanUtil.copyDiff(employee,person,false);
		person.setId(employee.getPersonId());
		Result r = personService.updateDirtyFields(person);
		if(r.success()) {
			r = super.update(employee, mode);
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param employeeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Employee> employeeList , SaveMode mode) {
		return super.updateList(employeeList , mode);
	}
	
	
	/**
	 * 按主键更新字段 员工
	 *
	 * @param id ID
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 员工
	 *
	 * @param id ID
	 * @return Employee 数据对象
	 */
	public Employee getById(String id) {
		Employee sample = new Employee();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Employee> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Employee> queryList(Employee sample) {
		return super.queryList(sample);
	}
	
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Employee> queryPagedList(Employee sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<Employee> queryPagedList(Employee sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param employee 数据对象
	 * @return 判断结果
	 */
	public Result<Employee> checkExists(Employee employee) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(employee, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Employee sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}