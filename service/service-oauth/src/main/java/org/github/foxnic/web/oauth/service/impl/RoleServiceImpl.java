package org.github.foxnic.web.oauth.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
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
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
import org.github.foxnic.web.oauth.service.IRoleService;
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
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-06 16:53:31
 * @version
*/


@Service("SysRoleService")
public class RoleServiceImpl extends SuperService<Role> implements IRoleService {

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
	private IRoleMenuService roleMenuService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 插入实体
	 * @param role 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Role role) {
		Result result = super.insert(role);
		if(result.success()) {
			String userId=SessionUser.getCurrent().getUserId();
			if (role instanceof RoleVO) {

				RoleVO vo = (RoleVO) role;
				if(vo.getMenuIds()!=null && !vo.getMenuIds().isEmpty()) {
					roleMenuService.saveMenuIds(userId, role, vo.getMenuIds());
				}
			}
		}
		return result;
	}

	/**
	 * 批量插入实体，事务内
	 * @param roleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Role> roleList) {
		return super.insertList(roleList);
	}


	/**
	 * 按主键删除 角色
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Role role = new Role();
		if(id==null) return ErrorDesc.failure();
		role.setId(id);
		try {
			boolean suc=dao.deleteEntity(role);
			return ErrorDesc.create(suc);
		} catch(Exception e) {
			 return ErrorDesc.exception(e);
		}
	}

	/**
	 * 按主键删除 角色
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Role role = new Role();
		if(id==null) return ErrorDesc.failure();
		role.setId(id);
		role.setDeleted(true);
		role.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		role.setDeleteTime(new Date());
		try {
			boolean suc=dao.updateEntity(role,SaveMode.NOT_NULL_FIELDS);
			return ErrorDesc.create(suc);
		} catch(Exception e) {
			return ErrorDesc.failure();
		}
	}

	/**
	 * 更新实体
	 * @param role 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Role role , SaveMode mode) {
		Result result=super.update(role , mode);
		if(result.success()) {
			String userId=SessionUser.getCurrent().getUserId();
			if (role instanceof RoleVO) {

				RoleVO vo = (RoleVO) role;
				if(vo.getMenuIds()!=null && !vo.getMenuIds().isEmpty()) {
					roleMenuService.saveMenuIds(userId, role, vo.getMenuIds());
				}
			}
		}
		return result;
	}

	/**
	 * 更新实体集，事务内
	 * @param roleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Role> roleList , SaveMode mode) {
		return super.updateList(roleList , mode);
	}


	/**
	 * 按主键更新字段 角色
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
	 * 按主键获取 角色
	 *
	 * @param id ID
	 * @return Role 数据对象
	 */
	public Role getById(String id) {
		Role sample = new Role();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Role> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Role> queryList(Role sample) {
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
	public PagedList<Role> queryPagedList(Role sample, int pageSize, int pageIndex) {
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
	public PagedList<Role> queryPagedList(Role sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param role 数据对象
	 * @return 判断结果
	 */
	public Result<Role> checkExists(Role role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Role sample) {
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
		return null;
	}

	@Override
	public List<Role> getRelatedRoles(List<String> menuIds) {
		if(menuIds==null || menuIds.isEmpty()) return new ArrayList<>();
		In in = new In("c.id",menuIds);
		Expr select=new Expr("select distinct a.* from sys_role a join sys_role_menu b on a.id=b.role_id and b.deleted=0 join sys_menu c on b.menu_id=c.id and c.deleted=0 where a.deleted=0");
		select.append(in.toConditionExpr().startWithAnd());
		return dao().queryEntities(Role.class,select);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}

}
