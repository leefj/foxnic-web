package org.github.foxnic.web.oauth.service.impl;

 
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.config.web.SecurityConfigs;
import org.github.foxnic.web.oauth.service.ISessionOnlineService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.oauth.session.SessionManager;
import org.github.foxnic.web.oauth.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.api.error.ErrorDesc;
import com.github.foxnic.springboot.mvc.Result;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;

 

/**
 * <p>
 * 账户表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 01:25:30
*/


@Service("SysUserService")
public class UserServiceImpl extends SuperService<User> implements IUserService {
	
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
	private SecurityConfigs securityConfigs;
	
	@Autowired
	private ISessionOnlineService onlineService;
	
//	@Autowired
//	private SessionManager sessionManager;
 
	
	/**
	 * 插入实体
	 * @param role 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insert(User user) {
		return super.insert(user);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param roleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public boolean insertList(List<User> userList) {
		return super.insertList(userList);
	}
	
	
	/**
	 * 按主键删除 账户
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdPhysical(String id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		user.setId(id);
		return dao.deleteEntity(user);
	}
	
	/**
	 * 按主键删除 账户
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public boolean deleteByIdLogical(String id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		user.setId(id);
		user.setDeleted(dao.getDBTreaty().getTrueValue());
		user.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		user.setDeleteTime(new Date());
		return dao.updateEntity(user,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 更新实体
	 * @param role 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean update(User user , SaveMode mode) {
		return super.update(user , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param roleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public boolean updateList(List<User> userList , SaveMode mode) {
		return super.updateList(userList , mode);
	}
	
	
	/**
	 * 按主键更新字段 账户
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
	 * 按主键获取 账户
	 *
	 * @param id ID
	 * @return User 数据对象
	 */
	public User getById(String id) {
		User sample = new User();
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
	public List<User> queryList(User sample) {
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
	public PagedList<User> queryPagedList(User sample, int pageSize, int pageIndex) {
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
	public PagedList<User> queryPagedList(User sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param roleVO 数据对象
	 * @return 判断结果
	 */
	public Result<User> checkExists(User role) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}
	
	/**
	 * 提供给 SpringSecurity 的查询接口
	 * */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user=dao.queryEntity(User.class, new ConditionExpr("(name = ? or mobile=? ) and valid = 1 and deleted = 0",username,username));
    	//授权
    	if (user!=null) {
//    		user.privileges().addAll(findPrivileges(user.id()));
    		dao.join(user,Role.class,Menu.class);
    	}
        if (user == null || user.getValid()==0) {
            throw new UsernameNotFoundException("无效账户 [" + username + "]");
        }
        return new SessionUser(null,user,null);
    }
	
	public void updateInteractTime() {
		SessionUser user=SessionUser.getCurrent();
		if(user!=null) {
			Date date=user.interact();
			if(user.getToken()!=null) {
//				sessionManager.putInteract(user.getToken(), date);
//				int i=dao.update(SYS_SESSION_ONLINE.$NAME).set(SYS_SESSION_ONLINE.INTERACT_TIME, new Date()).where().and("token=?",user.getToken()).top().execute();
//				return i>0;
			}
		}
//		return true;
	}

	@Override
	public SessionUser getUserByToken(String token) {
		
		SessionOnline online=onlineService.queryEntity(SessionOnline.create().setToken(token));
		//无效的 Token
		if(online==null) {
			return null;
		}
		SessionUser userDetails=new SessionUser(token,null,online);
		if(userDetails.isSessionExpire()) {
			return userDetails;
		}
 
		//查询登录用户
		User user=this.getById(online.getUserId());
		
		if(user.getValid()!=1 && user.getDeleted()!=0) {
			return null;
		}
		dao.join(user,Menu.class,Role.class);
		userDetails=new SessionUser(token,user,online);
		return userDetails;
	}

}