package com.scientific.tailoring.system.service.impl;
import com.scientific.tailoring.system.service.IUserRoleService;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.CollectorUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.scientific.tailoring.domain.system.UserRole;
import com.github.foxnic.dao.spec.DAO;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.scientific.tailoring.framework.DBConfigs;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-30 02:47:30
*/

@Service("SysUserRoleServiceImpl")
public class UserRoleServiceImpl extends SuperService<UserRole> implements IUserRoleService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除用户角色关系
	 *
	 * @param id 编号 , 详情 : 编号
	 * @return 查询结果 , UserRole对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		UserRole userRole = new UserRole();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		userRole.setId(id);
		return dao.deleteEntity(userRole);
	}
	
	/**
	 * 按主键删除用户角色关系
	 *
	 * @param id 编号 , 详情 : 编号
	 * @return 查询结果 , UserRole对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		UserRole userRole = new UserRole();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		userRole.setId(id);
		userRole.setDeleted(true);
		userRole.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		userRole.setDeleteTime(new Date());
		return dao.updateEntity(userRole,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取用户角色关系
	 *
	 * @param id 编号
	 * @return 查询结果 , UserRole对象
	 */
	public UserRole getById(Integer id) {
		UserRole sample = new UserRole();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Integer> getUserRoleIds(Long userId) {
		List<UserRole> urs= this.queryList(UserRole.create().setUserId(userId));
		return CollectorUtil.collectList(urs, UserRole::getRoleId);
	}

	@Override
	public void deleteUserRoles(Long userId) {
		dao.execute("delete from sys_user_role where user_id=?",userId);
	}

}