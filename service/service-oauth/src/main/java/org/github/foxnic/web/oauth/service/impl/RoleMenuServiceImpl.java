package org.github.foxnic.web.oauth.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;


import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.RoleMenuVO;
import org.github.foxnic.web.oauth.service.IRoleMenuService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 角色账户关系表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 10:53:35
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
	 * @param role 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insert(RoleMenu roleMenu) {
		return super.insert(roleMenu);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param roleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insertList(List<RoleMenu> roleMenuList) {
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
		roleMenu.setDeleted(dao.getDBTreaty().getTrueValue());
		roleMenu.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		roleMenu.setDeleteTime(new Date());
		return dao.updateEntity(roleMenu,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 更新实体
	 * @param role 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean update(RoleMenu roleMenu , SaveMode mode) {
		return super.update(roleMenu , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param roleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean updateList(List<RoleMenu> roleMenuList , SaveMode mode) {
		return super.updateList(roleMenuList , mode);
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
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param roleVO 数据对象
	 * @return 判断结果
	 */
	public Result<RoleMenu> checkExists(RoleMenu role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

}