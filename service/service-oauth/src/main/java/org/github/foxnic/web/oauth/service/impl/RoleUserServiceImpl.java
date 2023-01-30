package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.oauth.RoleUser;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IRoleUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色账户关系表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:29
*/


@Service("SysRoleUserService")
public class RoleUserServiceImpl extends SuperService<RoleUser> implements IRoleUserService {

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
	 * @param roleUser 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RoleUser roleUser) {
		return super.insert(roleUser);
	}

	/**
	 * 批量插入实体，事务内
	 * @param roleUserList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RoleUser> roleUserList) {
		return super.insertList(roleUserList);
	}


	/**
	 * 按主键删除 角色账户关系
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RoleUser roleUser = new RoleUser();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		roleUser.setId(id);
		boolean suc= dao.deleteEntity(roleUser);
		return ErrorDesc.create(suc);
	}

	/**
	 * 按主键删除 角色账户关系
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RoleUser roleUser = new RoleUser();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		roleUser.setId(id);
		roleUser.setDeleted(true);
		roleUser.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		roleUser.setDeleteTime(new Date());
		boolean suc=dao.updateEntity(roleUser,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.create(suc);
	}

	/**
	 * 更新实体
	 * @param roleUser 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RoleUser roleUser , SaveMode mode) {
		return super.update(roleUser , mode);
	}

	/**
	 * 更新实体集，事务内
	 * @param roleUserList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RoleUser> roleUserList , SaveMode mode) {
		return super.updateList(roleUserList , mode);
	}

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		 return MapUtil.asMap(ids,new ReferCause(false));
	}


	/**
	 * 按主键更新字段 角色账户关系
	 *
	 * @param id id
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}


	/**
	 * 按主键获取 角色账户关系
	 *
	 * @param id id
	 * @return RoleUser 数据对象
	 */
	public RoleUser getById(String id) {
		RoleUser sample = new RoleUser();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RoleUser> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RoleUser> queryList(RoleUser sample) {
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
	public PagedList<RoleUser> queryPagedList(RoleUser sample, int pageSize, int pageIndex) {
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
	public PagedList<RoleUser> queryPagedList(RoleUser sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	public void saveRoles(String userId, List<String> roleIds) {
		this.dao().execute("delete from "+table()+" where "+ FoxnicWeb.SYS_ROLE_USER.USER_ID+" = ?",userId);
		for (String roleId : roleIds) {
			RoleUser ru=new RoleUser();
			ru.setRoleId(roleId).setUserId(userId);
			this.insert(ru);
		}
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param role 数据对象
	 * @return 判断结果
	 */
	public Result<RoleUser> checkExists(RoleUser role) {
		//TDOD 此处添加判断段的代码
		boolean exists=this.checkExists(role, FoxnicWeb.SYS_ROLE.NAME);
		return ErrorDesc.success();
	}

}
