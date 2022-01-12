package org.github.foxnic.web.hrm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DBSequence;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.hrm.PersonSource;
import org.github.foxnic.web.constants.enums.system.YesNo;
import org.github.foxnic.web.domain.hrm.*;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.oauth.UserVO;
import org.github.foxnic.web.domain.system.UserTenantVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.*;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.github.foxnic.web.proxy.system.UserTenantServiceProxy;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.SessionUser;
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
 * @version 20210826
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

	@Autowired
	private IEmployeePositionService employeePositionService;

	@Autowired
	private IPositionService positionService;

	@Autowired
	private IOrganizationService organizationService;


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

		User user = null;
		//如果系统配置是在创建员工是创建账户
		if(SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_EMPLOYEE_CREATEUSER, YesNo.class)==YesNo.yes) {
			UserVO userVO=new UserVO();
			userVO.setName(employee.getPhone());
			userVO.setPhone(employee.getPhone());
			Result ur=UserServiceProxy.api().insert(userVO);
			if(ur.failure()) {
				return ur;
			}
			user=(User)ur.data();
		}

		if(StringUtil.isBlank(employee.getBadge())) {
			DBSequence sequence=dao().getSequence("badge");
			employee.setBadge(sequence.next());
		}

		//指定默认的归属公司
		employee.setCompanyId(SessionUser.getCurrent().getActivatedCompanyId());
		Person person= BeanUtil.copy(employee,Person.create(),false);
		person.setSource(PersonSource.employee.code());
		Result r = personService.insert(person);
		if(r.success()) {
			employee.setPersonId(person.getId());
			r = super.insert(employee);
			//如果账户创建成功，则绑定员工与账户的关系
			if(r.success() && user!=null) {
				//保存员工岗位关系
				if(employee instanceof EmployeeVO) {
					EmployeeVO vo=(EmployeeVO) employee;

					//保存兼岗关系
					if(vo.getVicePositionIds()!=null && !vo.getVicePositionIds().isEmpty()) {
						for (String vicePositionId : vo.getVicePositionIds()) {
							EmployeePosition ep=new EmployeePosition();
							ep.setEmployeeId(employee.getId()).setPositionId(vicePositionId);
							employeePositionService.insert(ep);
						}
					}

					//保存主岗关系
					if(!StringUtil.isBlank(vo.getPrimaryPositionId())) {
						EmployeePosition ep=new EmployeePosition();
						ep.setEmployeeId(employee.getId()).setPositionId(vo.getPrimaryPositionId());
						employeePositionService.insert(ep);
						//激活主岗
						employeePositionService.activePrimaryPosition(employee.getId());
					}


				}
				UserTenantVO userTenant=new UserTenantVO();
				userTenant.setUserId(user.getId());
				userTenant.setOwnerTenantId(SessionUser.getCurrent().getActivatedTenantId());
				userTenant.setEmployeeId(employee.getId());
				userTenant.setActivated(1);
				userTenant.setValid(1);
				r=UserTenantServiceProxy.api().insert(userTenant);
				if(r.failure()) {
					return r;
				}
			}
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
		Result r=null;
		Employee dbEmp=this.getById(employee.getId());
		this.join(dbEmp,Person.class);
		employee.setPersonId(dbEmp.getPersonId());
		if(employee.getPersonId()!=null) {
			Person person = dbEmp.getPerson();
			BeanUtil.copyDiff(employee, person, false);
			person.setId(employee.getPersonId());
			r = personService.update(person,SaveMode.DIRTY_FIELDS,false);
		}
		if(r==null || r.success()) {
			r = super.update(employee, mode);
		}

		//岗位
		List<String> posIds=new ArrayList<>();
		posIds.add(employee.getPrimaryPositionId());
		if(employee.getVicePositionIds()!=null){
			for (String posId : employee.getVicePositionIds()) {
				if(StringUtil.isBlank(posId)) continue;
				if(posIds.contains(posId)) continue;
				posIds.add(posId);
			}
		}
		employeePositionService.saveRelation(employee.getId(),posIds);
		employeePositionService.activePrimaryPosition(employee.getId(),employee.getPrimaryPositionId());

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
		EmployeeVO vo = null;
		if(sample instanceof EmployeeVO) {
			vo=(EmployeeVO) sample;
		}
		Expr select=new Expr("select t.* from "+table()+" t ");
		if("name".equals(vo.getSortField()) || "identity".equals(vo.getSortField()) || "sex".equals(vo.getSortField())) {
				select.append(" join hrm_person p on t.person_id=p.id");
		}

		ConditionExpr expr=new ConditionExpr("t.company_id=?",SessionUser.getCurrent().getActivatedCompanyId());

		//限定到部门或岗位
		if(vo!=null) {
			if(!StringUtil.isBlank(vo.getOrgId())) {
				Organization organization=organizationService.getById(vo.getOrgId());
				if(organization!=null) {
					expr.and("exists(select 1 from hrm_position p,hrm_employee_position ep,hrm_organization org where org.id=p.org_id and p.id=ep.position_id and ep.employee_id=t.id and ep.deleted=0 and p.deleted=0 and (org.hierarchy like ? or p.org_id=?))", organization.getHierarchy()+"/%",organization.getId());
				}
			}
			if(!StringUtil.isBlank(vo.getPositionId())) {
				expr.and("exists(select 1 from hrm_employee_position p where p.employee_id=t.id and p.deleted=0 and position_id=?)",vo.getPositionId());
			}
			vo.setOrgId(null);
			vo.setPositionId(null);
		}
		ConditionExpr base=this.buildQueryCondition(sample,"t");
		expr.and(base);
		select.append(expr.startWithWhere());

		OrderBy orderBy= null;
		String alias="t";
		if(vo!=null && StringUtil.hasContent(vo.getSortField())) {

			orderBy = this.buildOrderBy(sample, alias);

			if (orderBy==null) {
				if("name".equals(vo.getSortField()) || "identity".equals(vo.getSortField()) || "sex".equals(vo.getSortField())) {
					alias="p";
					SortType sortType=SortType.parse(vo.getSortType());
					if (sortType==SortType.ASC) {
						orderBy = OrderBy.byAscNullsLast(alias+"." +vo.getSortField());
					} else if (sortType==SortType.DESC) {
						orderBy = OrderBy.byDescNullsLast(alias+"." + vo.getSortField());
					}
				}

			}
			select.append(orderBy);
		}
		PagedList<Employee> pagedList=this.dao().queryPagedEntities(Employee.class,pageSize,pageIndex,select);
		return pagedList;
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

	/**
	 * 按工号获取员工
	 */
	@Override
	public Employee getByBadge(String badge) {
		String companyId=SessionUser.getCurrent().getActivatedCompanyId();
		Employee sample=Employee.create().setCompanyId(companyId).setBadge(badge);
		return this.queryEntity(sample);
	}

	/**
	 * 批量按工号获取员工 <br>
	 */
	@Override
	public List<Employee> getByBadges(List<String> badges) {
		if(badges==null || badges.isEmpty()) return new ArrayList<>();
		String companyId=SessionUser.getCurrent().getActivatedCompanyId();
		Select select=new Select(this.table());
		In in=new In("badge",badges);
		select.where().and("company_id=? and deleted=0",companyId).and(in);
		return dao().queryEntities(Employee.class,select);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
