package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.constants.enums.Language;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.oauth.*;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.oauth.service.IRoleUserService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 账户表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
*/


@Service("SysUserService")
public class UserServiceImpl extends SuperService<User> implements IUserService {
	
	@Value("${develop.language:}")
	private String devLang;

	@Autowired
	private IRoleUserService roleUserService;
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;


	private PasswordEncoder passwordEncoder;

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
	 * @param user 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(User user) {
		Result r=super.insert(user);
		if(r.success()) {
			saveRoles(user);
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param userList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<User> userList) {
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
	 * @param user 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(User user , SaveMode mode) {

		Result r=super.update(user , mode);
		if(r.success()) {
			saveRoles(user);
		}
		return r;

	}

	private void saveRoles(User user) {
		if(user instanceof UserVO) {
			UserVO vo=(UserVO) user;
			List<String> roleIds=vo.getRoleIds();
			if(roleIds!=null) {
				roleUserService.saveRoles(user.getId(),roleIds);
			}
		}
	}

	/**
	 * 更新实体集，事务内
	 * @param userList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<User> userList , SaveMode mode) {
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
		User user=dao.queryEntity(sample);
		dao.join(user,Role.class);
		return user;
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
	 * @param user 数据对象
	 * @return 判断结果
	 */
	public Result<User> checkExists(User user) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}
	
	/**
	 * 提供给 SpringSecurity 的查询接口
	 * */
	public User getUserByIdentity(String identity) {
		User user=dao.queryEntity(User.class, new ConditionExpr(SYS_USER.ID+" = ?",identity));
    	if(user==null) {
    		user=dao.queryEntity(User.class, new ConditionExpr(SYS_USER.NAME+" = ?",identity));
    	}
    	if(user==null) {
    		user=dao.queryEntity(User.class, new ConditionExpr(SYS_USER.PHONE+" = ?",identity));
    	}
    	
    	//授权
    	if (user!=null) {
    		dao.join(user, Person.class, Employee.class);
    		dao.join(user,Role.class,Menu.class,RoleMenu.class);
			dao.join(user.getMenus(),Resourze.class);
    	}

//    	//拷贝数据
//    	if(user.getEmployee()!=null && user.getPerson()!=null) {
//			user.getEmployee().setName(user.getPerson().getName());
//			user.getEmployee().setSex(user.getPerson().getSex());
//			user.getEmployee().setIdentity(user.getPerson().getIdentity());
//		}




    	//设置用户语言
    	String usrLang=user.getLanguage();
    	if(!StringUtil.isBlank(devLang)) {
    		user.setLanguage(devLang);
    	} else {
    		if(StringUtil.isBlank(usrLang)) {
    			//获得系统配置的语言
    	    	String sysLang= SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_LANGUAGE);
    			user.setLanguage(sysLang);
    		}
    	}

		if(StringUtil.isBlank(user.getLanguage())) {
			user.setLanguage(Language.defaults.name());
		}

        return user;
    }

	@Override
	public Result changePasswd(String sessionUserId, String oldpwd, String newpwd) {
		if(passwordEncoder==null) {
			passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
		User user=this.getById(sessionUserId);
		boolean march = passwordEncoder.matches(oldpwd, user.getPasswd());
		if(!march) {
			return ErrorDesc.failure(CommonError.PASSWORD_INVALID).message("原始密码错误");
		}
		newpwd=passwordEncoder.encode(newpwd);
		user.setPasswd(newpwd);
		this.update(user,SaveMode.DIRTY_FIELDS);
		return ErrorDesc.success().message("密码已修改，请记住您的新密码！");
	}

}