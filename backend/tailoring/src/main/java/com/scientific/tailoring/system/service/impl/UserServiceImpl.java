package com.scientific.tailoring.system.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.CommonError;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.constants.db.Tailoring.SYS_USER;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.domain.system.UserEditModel;
import com.scientific.tailoring.domain.system.UserRole;
import com.scientific.tailoring.domain.system.UserVO;
import com.scientific.tailoring.domain.system.meta.UserMeta;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.system.service.IUserRoleService;
import com.scientific.tailoring.system.service.IUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-28 05:57:35
*/

@Service("SysUserServiceImpl")
public class UserServiceImpl extends SuperService<User> implements IUserService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	@Autowired
	private IUserRoleService userRoleService;
	
	
	
	
	/**
	 * 存在性检查
	 * */
	public Result<User> isUserExists(User user) { 
		
		boolean exists=false;
		exists=this.checkExists(user, SYS_USER.ACCOUNT);
		if(exists) {
			return ErrorDesc.failureMessage("账户已经存在",CommonError.DATA_REPETITION);
		}
		exists=this.checkExists(user, SYS_USER.MOBILE);
		if(exists) {
			return ErrorDesc.failureMessage("手机号已经存在",CommonError.DATA_REPETITION);
		}
		return ErrorDesc.success();
		
	}
	
	
//	@Transactional
	public boolean insertEntityAndRole(UserVO user) {
 
		dao.insertEntity(user);
		
		updateUserRoles(user.getId(),user.getRoleIds());

		return true;
	}


	private void updateUserRoles(Long userId,List<Integer> roleIds) {
		if(roleIds==null) return ;
		userRoleService.deleteUserRoles(userId);
		for (Integer roleId : roleIds) {
			UserRole ur = new UserRole();
			ur.setUserId(userId);
			ur.setRoleId(roleId);
			userRoleService.insert(ur);
			System.out.println("insert role "+roleId);
		}
	}
	
	public boolean updateEntity(UserVO entity) {
		dao().updateEntity(entity, SaveMode.DIRTY_FIELDS);
		updateUserRoles(entity.getId(), entity.getRoleIds());
		return true;
		
	}
	
	/**
	 * 按主键删除用户
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , User对象
	 */
	public boolean deleteByIdPhysical(Long id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		user.setId(id);
		return dao.deleteEntity(user);
	}
	
	/**
	 * 按主键删除用户
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , User对象
	 */
	public boolean deleteByIdLogical(Long id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		user.setId(id);
		user.setDeleted(true);
		user.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		user.setDeleteTime(new Date());
		return dao.updateEntity(user,SaveMode.NOT_NULL_FIELDS);
	}

	/**
	 * 按主键获取用户
	 *
	 * @param id ID
	 * @return 查询结果 , User对象
	 */
	public User getById(Long id) {
		return getById(id,false);
	}
	/**
	 * 按主键获取用户
	 *
	 * @param id ID
	 * @param keepPaswd 是否保留密码
	 * @return 查询结果 , User对象
	 */
	public User getById(Long id,boolean keepPaswd) {
		User sample = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		User usr=dao.queryEntity(sample);
		if(!keepPaswd) {
			usr.setPassword("******");
		}
		return usr;
	}


	@Override
	public UserEditModel getUserEditModel(Long id) {
		UserEditModel uem=this.getById(id).toPojo(UserEditModel.class);
		List<Integer> roleIds = userRoleService.getUserRoleIds(id);
		if(uem!=null) {
			uem.setRoleIds(roleIds);
		}
		return uem;
	}


	@Override
	public void resetPasswd(Long userId) {
		dao.execute("update "+this.table()+" set password='123321' where id=?",userId);
	}
	
	public PagedList<User> queryPagedList(User sample,int pageSize,int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}
 
 

}