package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Where;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.parameter.BatchParamBuilder;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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


@Service("SysRoleMenuService")
public class RoleMenuServiceImpl extends SuperService<RoleMenu> implements IRoleMenuService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	/**
	 * 插入实体
	 * @param roleMenu 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RoleMenu roleMenu) {
		return super.insert(roleMenu);
	}

	/**
	 * 批量插入实体，事务内
	 * @param roleMenuList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RoleMenu> roleMenuList) {
		return super.insertList(roleMenuList);
	}


	/**
	 * 按主键删除 角色账户关系
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		RoleMenu roleMenu = new RoleMenu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		roleMenu.setId(id);
		return dao.deleteEntity(roleMenu);
	}

	/**
	 * 按主键删除 角色账户关系
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		RoleMenu roleMenu = new RoleMenu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		roleMenu.setId(id);
		roleMenu.setDeleted(true);
		roleMenu.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		roleMenu.setDeleteTime(new Date());
		return dao.updateEntity(roleMenu,SaveMode.NOT_NULL_FIELDS);
	}

	/**
	 * 更新实体
	 * @param roleMenu 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RoleMenu roleMenu , SaveMode mode) {
		return super.update(roleMenu , mode);
	}

	/**
	 * 更新实体集，事务内
	 * @param roleMenuList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RoleMenu> roleMenuList , SaveMode mode) {
		return super.updateList(roleMenuList , mode);
	}

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
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
	 * @return RoleMenu 数据对象
	 */
	public RoleMenu getById(String id) {
		RoleMenu sample = new RoleMenu();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RoleMenu> queryList(RoleMenu sample) {
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
	public PagedList<RoleMenu> queryPagedList(RoleMenu sample, int pageSize, int pageIndex) {
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
	public PagedList<RoleMenu> queryPagedList(RoleMenu sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	@Override
	@Transactional
	public void saveMenuIds(String sessionUserId,Role role, List<String> menuIds) {
		if(menuIds==null) return;

		//当前的权限
		List<RoleMenu> currRMs= this.queryList(RoleMenu.create().setRoleId(role.getId()));
		List<String> currMenuIds= CollectorUtil.collectList(currRMs,RoleMenu::getMenuId);
		//搜集需要删除的权限
		List<String> toRemove=new ArrayList<>();
		for (String currMenuId : currMenuIds) {
			if(!menuIds.contains(currMenuId)) {
				toRemove.add(currMenuId);
			}
		}
		//收集需要新加的部分
		List<String> toAdd=new ArrayList<>();
		for (String menuId : menuIds) {
			if(!currMenuIds.contains(menuId)) {
				toAdd.add(menuId);
			}
		}

		if(!toRemove.isEmpty()) {
			In in=new In("menu_id",toRemove);
			List<In> ins=in.split(16);
			for (In iin : ins) {
				Where ce=new Where();
				ce.and("role_id=?",role.getId()).and(iin);
				dao().execute("delete from " + table() + " "+ce.getListParameterSQL(), ce.getListParameters());
			}
		}

		BatchParamBuilder pb=new BatchParamBuilder();

		for (String menuId : toAdd) {
			pb.add(IDGenerator.getSnowflakeIdString(),menuId,role.getId(), sessionUserId,new Date());
		}
		this.dao().batchExecute("insert into "+table()+"(id,menu_id,role_id,create_by,create_time)  values(?,?,?,?,?)",pb.getBatchList());

	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param role 数据对象
	 * @return 判断结果
	 */
	public Result<RoleMenu> checkExists(RoleMenu role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

}
