package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.github.foxnic.web.system.service.IBusiRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务角色表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-16 11:22:37
 * @version
*/


@Service("SysBusiRoleService")
public class BusiRoleServiceImpl extends SuperService<BusiRole> implements IBusiRoleService {

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
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param busiRole  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(BusiRole busiRole,boolean throwsException) {
		SessionUser sessionUser=SessionUser.getCurrent();
		if(sessionUser==null || (sessionUser!=null && !sessionUser.isBuildIn())) {
			if(this.isBuildIn(busiRole)) {
				return ErrorDesc.failure().message("当前用户不允许创建内置角色");
			}
		}
		if(busiRole.getBuildIn()==null) {
			busiRole.setBuildIn(0);
		}
		Result r=super.insert(busiRole,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param busiRole 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(BusiRole busiRole) {
		return this.insert(busiRole,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param busiRoleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<BusiRole> busiRoleList) {
		return super.insertList(busiRoleList);
	}


	/**
	 * 按主键删除 业务角色
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		BusiRole busiRole = new BusiRole();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		BusiRole roleDb=this.getById(id);
		if(this.isBuildIn(roleDb)) {
			return ErrorDesc.failure().message("不允许删除内置角色");
		}
		busiRole.setId(id);
		try {
			boolean suc = dao.deleteEntity(busiRole);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 业务角色
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		BusiRole busiRole = new BusiRole();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");

		BusiRole roleDb=this.getById(id);
		if(this.isBuildIn(roleDb)) {
			return ErrorDesc.failure().message("不允许删除内置角色");
		}
		busiRole.setId(id);
		busiRole.setDeleted(true);
		busiRole.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		busiRole.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(busiRole,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param busiRole 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(BusiRole busiRole , SaveMode mode) {
		return this.update(busiRole,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param busiRole 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(BusiRole busiRole , SaveMode mode,boolean throwsException) {
		SessionUser sessionUser=SessionUser.getCurrent();
		if(sessionUser==null || (sessionUser!=null && !sessionUser.isBuildIn())) {
			BusiRole roleDb=this.getById(busiRole.getId());
			if(this.isBuildIn(roleDb)) {
				return ErrorDesc.failure().message("当前用户不允许修改内置角色");
			}
			if(busiRole.getBuildIn()!=null && !busiRole.getBuildIn().equals(roleDb.getBuildIn())) {
				return ErrorDesc.failure().message("当前账户没有权限修改角色的内置属性");
			}
		}
		Result r=super.update(busiRole , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param busiRoleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<BusiRole> busiRoleList , SaveMode mode) {
		return super.updateList(busiRoleList , mode);
	}


	/**
	 * 按主键更新字段 业务角色
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
	 * 按主键获取 业务角色
	 *
	 * @param id 主键
	 * @return BusiRole 数据对象
	 */
	public BusiRole getById(String id) {
		BusiRole sample = new BusiRole();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 按主键获取 业务角色
	 *
	 * @param codes 主键
	 * @return BusiRole 数据对象
	 */
	public List<BusiRole> getByCodes(List<String> codes) {
		if(codes==null) throw new IllegalArgumentException("codes 不允许为 null");
		List<BusiRole> list=new ArrayList<>();
		if(codes.isEmpty()) return list;
		In in=new In("code",codes);
		return this.queryList(in.toConditionExpr());
	}

	@Override
	public List<BusiRole> getEmployeeRoles(String employeeId) {
		if(employeeId==null) throw new IllegalArgumentException("employeeId 不允许为 null");
		Expr select = new Expr("select r.* from sys_busi_role r join sys_busi_role_member m on r.id=m.role_id and m.member_type=? and m.member_id=? where r.deleted=0 and r.valid=1", UnifiedUserType.employee.code(),employeeId);
		return this.dao().queryEntities(BusiRole.class,select);
	}

	@Override
	public List<BusiRole> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	public boolean isBuildIn(BusiRole role) {
		if(role==null) return false;
		if(role.getBuildIn()==null) return false;
		return role.getBuildIn()==1;
	}

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<BusiRole> queryList(BusiRole sample) {
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
	public PagedList<BusiRole> queryPagedList(BusiRole sample, int pageSize, int pageIndex) {
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
	public PagedList<BusiRole> queryPagedList(BusiRole sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param busiRole 数据对象
	 * @return 判断结果
	 */
	public Result<BusiRole> checkExists(BusiRole busiRole) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(busiRole, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(BusiRole sample) {
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
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}
