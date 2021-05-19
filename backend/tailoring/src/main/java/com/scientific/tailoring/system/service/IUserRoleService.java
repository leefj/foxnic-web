package com.scientific.tailoring.system.service;
import java.util.List;

import com.github.foxnic.dao.entity.ISuperService;
import com.scientific.tailoring.domain.system.UserRole;
import com.scientific.tailoring.domain.system.meta.UserRoleMeta;
/**
 * <p>
 * 用户角色关系表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-30 01:30:12
*/

public interface IUserRoleService extends ISuperService<UserRole> {

	/**
	 * 按主键删除用户角色关系
	 *
	 * @param id 编号 , 详情 : 编号
	 * @return 查询结果 , UserRole对象
	 */
	boolean deleteByIdPhysical(Integer id);
	
	/**
	 * 按主键删除用户角色关系
	 *
	 * @param id 编号 , 详情 : 编号
	 * @return 查询结果 , UserRole对象
	 */
	boolean deleteByIdLogical(Integer id);
	
	/**
	 * 按主键获取用户角色关系
	 *
	 * @param id 编号
	 * @return 查询结果 , UserRole对象
	 */
	UserRole getById(Integer id);

	/**
	 * 获得用户的角色ID
	 * */
	List<Integer> getUserRoleIds(Long userId);

	/**
	 * 删除用户的角色ID
	 * */
	void deleteUserRoles(Long userId);

}