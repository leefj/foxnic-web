package org.github.foxnic.web.oauth.service.impl;

import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.log.PerformanceLogger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.FieldsBuilder;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.springboot.mvc.RequestParameter;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.SQLKeyword;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_USER;
import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.system.LoginIdentityType;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;
import org.github.foxnic.web.domain.oauth.*;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.domain.oauth.meta.RoleMeta;
import org.github.foxnic.web.domain.oauth.meta.UserMeta;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import org.github.foxnic.web.domain.system.meta.UserTenantMeta;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.licence.LicenceProxy;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.oauth.service.IMenuService;
import org.github.foxnic.web.oauth.service.IRoleUserService;
import org.github.foxnic.web.oauth.service.IUserService;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.DynamicMenuHandler;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 账户表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-01 09:27:27
 * @version 20210827
*/


@Service("SysUserService")
public class UserServiceImpl extends SuperService<User> implements IUserService {

	/**
	 * 预热
	 * */
	@PostConstruct
	private void startup() {
		SimpleTaskManager.doParallelTask(()->{
			dao().pausePrintThreadSQL();
			List<String> identities= dao().queryPage("select distinct u."+LoginIdentityType.user_id.getIdentityField().name()+" from sys_role r,sys_role_user ru,sys_user u where r.id=ru.role_id and ru.user_id=u.id and r.code=? and u.deleted=0",2,1,"super_admin").getValueList(LoginIdentityType.user_id.getIdentityField().name(),String.class);
			for (String identity : identities) {
				try {
					User user = UserServiceImpl.this.getUserByIdentity(identity);
					if(user!=null) {
						break;
					}
				} catch (Exception e) {
					Logger.exception(e);
				}
			}
			dao().resumePrintThreadSQL();

		},2000);
	}

	@Value("${develop.language:}")
	private String devLang;

	@Autowired
	private IRoleUserService roleUserService;

	@Autowired
	private IMenuService menuService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;


	private PasswordEncoder passwordEncoder;

	public PasswordEncoder getPasswordEncoder() {
		if(passwordEncoder==null) {
			passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		}
		return passwordEncoder;
	}

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
		if(StringUtil.isBlank(user.getPasswd())){
			String defaultPasswd=SystemConfigProxyUtil.getString(SystemConfigEnum.SYSTEM_PASSWORD_DEFAULT);
			defaultPasswd=getPasswordEncoder().encode(defaultPasswd);
			user.setPasswd(defaultPasswd);
		}
		Result r=super.insert(user,false);
		if(r.success()) {
			saveRoles(user);
		}
		user.setPasswd("******");
		r.data(user);
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
	public Result deleteByIdPhysical(String id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		user.setId(id);
		boolean suc=dao.deleteEntity(user);
		return ErrorDesc.create(suc);
	}

	/**
	 * 按主键删除 账户
	 *
	 * @param id ID
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		User user = new User();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		user.setId(id);
		user.setDeleted(true);
		user.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		user.setDeleteTime(new Date());
		boolean suc=dao.updateEntity(user,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.create(suc);
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

	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
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
		this.dao().fill(user)
//				.with(UserMeta.MENUS)
//				.with(UserMeta.MENUS, MenuMeta.RESOURCES)
//				.with(UserMeta.MENUS, MenuMeta.PATH_RESOURCE)
				.with(UserMeta.ROLES)
//				.with(UserMeta.ROLE_MENUS)
//				.with(UserMeta.JOINED_TENANTS, UserTenantMeta.TENANT, TenantMeta.COMPANY)
				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON)
				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.POSITIONS)
//				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.ORGANIZATIONS)
				.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.BUSI_ROLES)
				.execute();
		return user;
	}

	@Override
	public List<User> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
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

		FieldsBuilder fieldsBuilder = this.createFieldsBuilder()
				// 加入所有字段
				.addAll()
				// 移除规约字段
				.removeDBTreatyFields()
				// 移除密码字段
				.remove(SYS_USER.PASSWD)
				// 加入创建时间字段
				.add(SYS_USER.CREATE_TIME);

		return super.queryPagedList(sample, fieldsBuilder,pageSize, pageIndex);
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
	 * 检查 角色 是否已经存在 :
	 *
	 * @param user 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(User user) {
		//TDOD 此处添加判断段的代码
//		boolean exists=this.checkExists(role, SYS_ROLE.NAME);
		//return exists;
		return false;
	}


	private LoginIdentityType[] identityPriorities={LoginIdentityType.user_account,LoginIdentityType.user_phone,LoginIdentityType.user_id};

	@Value("${security.login-identity-priority}")
	public void setIdentityPriorities(String priorities) {
		if(StringUtil.isBlank(priorities)) return;
		List<LoginIdentityType> types=new ArrayList<>();
		for (String typeStr : priorities.split(",")) {
			if(StringUtil.isBlank(typeStr)) continue;
			LoginIdentityType type=LoginIdentityType.parseByCode(typeStr.trim());
			types.add(type);
		}
		if(!types.isEmpty()) {
			this.identityPriorities = types.toArray(this.identityPriorities);
		}
	}

	public List<Menu> makeUserMenus(User user, boolean gerDyMenu) {

		List<Menu> menus =menuService.queryCachedMenus(user.getMenuIds());

		List excludedMenuIds= LicenceProxy.getExcludedMenuIds();
		List<Menu> remMenus=new ArrayList<>();
		List<Menu> dySubMenus=new ArrayList<>();
		for (int i=0;i<menus.size();i++) {
			Menu menu = menus.get(i);
			if("/business/oauth/role/role_list.html".equals(menu.getPath())) {
				System.out.println();
			}
			//
			if (gerDyMenu && !StringUtil.isBlank(menu.getDynamicHandler())) {
				//logger.collect("G1-START : "+menu.getDynamicHandler());
				DynamicMenuHandler dy = DynamicMenuHandler.getHandler(menu.getDynamicHandler());
				//logger.collect("G1-END : "+menu.getDynamicHandler());
				if(dy!=null) {
					menu=menu.clone();
					menus.set(i,menu);
					boolean has = dy.hasPermission(menu, user);
					if (!has) {
						remMenus.add(menu);
					}
					String title = dy.getLabel(menu, user);
					menu.setLabel(title);
					List<Menu> subs = dy.generateExtraChildNodes(menu, user);
					if (subs != null) {
						dySubMenus.addAll(subs);
					}
				}
			}

			if(excludedMenuIds.contains(menu.getId())) {
				remMenus.add(menu);
			}

		}

		menus.addAll(dySubMenus);

		for (Menu remMenu : remMenus) {
			menus.remove(remMenu);
		}



		// 按 ID distinct
		menus = CollectorUtil.distinct(menus, (menu) -> {
			return menu.getId();
		});
		// 排序
		CollectorUtil.sort(menus,(me)->{
			me.clearModifies();
			return me.getSort();
		},true,true);

		// 设置用户菜单
		user.setMenus(menus);

		return menus;
	}

	/**
	 * 提供给 SpringSecurity 的查询接口
	 * */
	public User getUserByIdentity(String identity) {

		PerformanceLogger logger=new PerformanceLogger();

		logger.collect("Query Login User");

		User user = this.queryLoginUser(identity);

		logger.collect("Unique Identity");

		if(user==null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		FieldsBuilder sysRoleFields=FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_ROLE.$TABLE).addAll().removeDBTreatyFields();

		FieldsBuilder busiRoleFields=FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_BUSI_ROLE.$TABLE).addAll().removeDBTreatyFields();

		FieldsBuilder resourzeFields=FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_RESOURZE.$TABLE)
				.add(FoxnicWeb.SYS_RESOURZE.ID).add(FoxnicWeb.SYS_RESOURZE.URL);



		FieldsBuilder menuFields=FieldsBuilder.build(this.dao(), FoxnicWeb.SYS_MENU.$TABLE)
				.add(FoxnicWeb.SYS_MENU.ID,FoxnicWeb.SYS_MENU.AUTHORITY);

		logger.collect("Start Join");
 		//填充账户模型
 		dao.fill(user).tag("login")
			.with(UserMeta.ROLES, RoleMeta.MENUS, MenuMeta.RESOURCES)
			.with(UserMeta.ROLES, RoleMeta.MENUS,MenuMeta.PATH_RESOURCE)
			.with(UserMeta.JOINED_TENANTS, UserTenantMeta.TENANT, TenantMeta.COMPANY)
			.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.PERSON)
			.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.POSITIONS)
			.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.ORGANIZATIONS)
			.with(UserMeta.JOINED_TENANTS,UserTenantMeta.EMPLOYEE, EmployeeMeta.BUSI_ROLES)
			.fields(sysRoleFields,busiRoleFields,menuFields,resourzeFields)
			.execute();

		logger.collect("End Join");


		Set<String> menuIds=new HashSet<>();

		for (Role role : user.getRoles()) {
			if(role.getMenus()!=null) {
				menuIds.addAll(CollectorUtil.collectSet(role.getMenus(),Menu::getId));
			}
		}
		EntityContext.cloneProperty(user,UserMeta.ROLES_PROP);
		user.setMenuIds(new ArrayList<>(menuIds));

		logger.collect("End Process Role&Menu");

		LOGIN_USER_MENUS.set(this.makeUserMenus(user,true));

		logger.collect("Tenant Process");

		//
 		if(user.getActivatedTenant()!=null){
			EntityContext.clonePropertyChain(user,false,UserMeta.ACTIVATED_TENANT_PROP,UserTenantMeta.EMPLOYEE_PROP);
 			Employee employee=user.getActivatedTenant().getEmployee();
 			if(employee!=null) {

				EntityContext.cloneProperty(employee,EmployeeMeta.PRIMARY_ORGANIZATION_PROP);
				EntityContext.cloneProperty(employee,EmployeeMeta.PRIMARY_POSITION_PROP);
				EntityContext.cloneProperty(employee,EmployeeMeta.POSITIONS_PROP);
				EntityContext.cloneProperty(employee,EmployeeMeta.BUSI_ROLES_PROP);

 				Person person=employee.getPerson();
 				if(person!=null) {
 					user.setActivatedEmployeeName(person.getName());
				}
			}
		}

		logger.collect("Language");
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
		logger.collect("Done");
		logger.info("Login");
        return user;
    }



	private SQL buildUserQuerySQL(String identity,boolean isUserLogin) {
		FieldsBuilder userFields = this.createFieldsBuilder().addAll().removeDBTreatyFields().add(SYS_USER.DELETED);
		if(isUserLogin) {
			Expr select = new Expr();
			for (int i = 0; i < this.identityPriorities.length; i++) {
				LoginIdentityType identityType = this.identityPriorities[i];
				select.append(identityType.getQuerySQL(userFields.getFieldsSQL(LoginIdentityType.USER_TABLE_ALIAS), identity));
				if (i < this.identityPriorities.length - 1) {
					select.append(SQLKeyword.UNION_ALL.toString());
				}
			}
			return select;
		} else {
			return LoginIdentityType.user_id.getQuerySQL(userFields.getFieldsSQL(LoginIdentityType.USER_TABLE_ALIAS),identity);
		}
	}

	private User queryLoginUser(String identity) {

		RequestParameter request=RequestParameter.get();
		LoginIdentityVO loginIdentityVO = null;
		String passwd = null;
		boolean isUserLogin = false;
		if(request!=null) {
			if(request.getRequest()!=null) {
				isUserLogin = true;
			}
			loginIdentityVO= request.toPojo(LoginIdentityVO.class);
			if(loginIdentityVO!=null) {
				passwd=loginIdentityVO.getPasswd();
			}
		}

		if(StringUtil.isBlank(passwd)) {
			passwd = this.getClass().getName();
		}

		SQL select=this.buildUserQuerySQL(identity,isUserLogin);
		RcdSet rs=this.dao().query(select);
		User user = null ;
		if(rs.size()==1) {
			user = rs.getRcd(0).toEntity(User.class);
		} else {
			Map<String, Rcd> userMap=rs.getMappedRcds(LoginIdentityType.IDENTITY_TYPE_FIELD,String.class);
			for (LoginIdentityType priority : identityPriorities) {
				Rcd r = userMap.get(priority.code());
				if(r!=null) {
					User localUser=r.toEntity(User.class);
					// 如果是登录，校验密码，以确定身份
					if(isUserLogin) {
						if(getPasswordEncoder().matches(passwd,localUser.getPasswd())) {
							user = localUser;
							break;
						}
					} else {
						user = localUser;
						break;
					}
				}
			}
		}


		if(isUserLogin && rs.size()>0 && user==null) {
			throw new BadClientCredentialsException();
		}

		return user;
	}

	@Override
	public Result changePasswd(String sessionUserId, String oldpwd, String newpwd) {
		PasswordEncoder passwordEncoder=getPasswordEncoder();
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

	@Override
	public Result resetPasswd(String userId, String adminPwd, String pwd) {
		PasswordEncoder passwordEncoder=getPasswordEncoder();
		User admin=this.getById(SessionUser.getCurrent().getUserId());
		boolean march = passwordEncoder.matches(adminPwd, admin.getPasswd());
		if(!march) {
			return ErrorDesc.failure(CommonError.PASSWORD_INVALID).message("您的密码错误");
		}
		User user=this.getById(userId);
		pwd=passwordEncoder.encode(pwd);
		user.setPasswd(pwd);
		this.update(user,SaveMode.DIRTY_FIELDS);
		return ErrorDesc.success();
	}

}
