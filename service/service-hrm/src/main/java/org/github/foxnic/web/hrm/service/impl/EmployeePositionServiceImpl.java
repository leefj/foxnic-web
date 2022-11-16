package org.github.foxnic.web.hrm.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_EMPLOYEE_POSITION;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeePosition;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.hrm.service.IEmployeePositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-14 21:43:33
 * @version
*/


@Service("HrmEmployeePositionService")
public class EmployeePositionServiceImpl extends SuperService<EmployeePosition> implements IEmployeePositionService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param employeePosition 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(EmployeePosition employeePosition) {
		Result r=super.insert(employeePosition);
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param employeePositionList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<EmployeePosition> employeePositionList) {
		return super.insertList(employeePositionList);
	}


	/**
	 * 按主键删除 hrm_employee_position
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		EmployeePosition employeePosition = new EmployeePosition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		employeePosition.setId(id);
		try {
			boolean suc = dao.deleteEntity(employeePosition);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 hrm_employee_position
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		EmployeePosition employeePosition = new EmployeePosition();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		employeePosition.setId(id);
		employeePosition.setDeleted(true);
		employeePosition.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		employeePosition.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(employeePosition,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新实体
	 * @param employeePosition 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(EmployeePosition employeePosition , SaveMode mode) {
		Result r=super.update(employeePosition , mode);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param employeePositionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<EmployeePosition> employeePositionList , SaveMode mode) {
		return super.updateList(employeePositionList , mode);
	}


	/**
	 * 按主键更新字段 hrm_employee_position
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 hrm_employee_position
	 *
	 * @param id 主键
	 * @return EmployeePosition 数据对象
	 */
	public EmployeePosition getById(String id) {
		EmployeePosition sample = new EmployeePosition();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<EmployeePosition> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<EmployeePosition> queryList(EmployeePosition sample) {
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
	public PagedList<EmployeePosition> queryPagedList(EmployeePosition sample, int pageSize, int pageIndex) {
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
	public PagedList<EmployeePosition> queryPagedList(EmployeePosition sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param employeePosition 数据对象
	 * @return 判断结果
	 */
	public Result<EmployeePosition> checkExists(EmployeePosition employeePosition) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(employeePosition, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(EmployeePosition sample) {
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
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

	/**
     * 保存关系
     * @param employeeId 员工ID
     * @param positionIds 岗位ID清单
     */
	public void saveRelation(String employeeId,List<String> positionIds) {
		super.saveRelation(Employee.class,HRM_EMPLOYEE_POSITION.EMPLOYEE_ID,employeeId, Position.class,HRM_EMPLOYEE_POSITION.POSITION_ID,positionIds,true);
	}

	@Override
	@Transactional
	/**
	 * 如果没有主岗有找一个最早创建的作为主岗
	 * */
	public void activePrimaryPosition(String employeeId) {
		int ex=dao().queryInteger("select count(1) from "+table()+" where employee_id=? and is_primary=1 and deleted=0",employeeId);
		if(ex==0) {
			Rcd ep=dao().queryRecord("select * from "+table()+" where  employee_id=? "+(OrderBy.byAscNullsLast("create_time").getSQL()),employeeId);
			this.dao().update(this.table()).set("is_primary",1).where("id=?",ep.getString("id")).top().execute();
		}
	}

	@Override
	@Transactional
	public void activePrimaryPosition(String employeeId,String positionId) {
		this.dao().update(this.table()).set("is_primary",0).where("employee_id=?",employeeId).top().execute();
		this.dao().update(this.table()).set("is_primary",1).where("employee_id=? and position_id=?",employeeId,positionId).top().execute();
	}

}
