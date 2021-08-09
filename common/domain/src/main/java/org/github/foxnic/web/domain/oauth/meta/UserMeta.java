package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.User;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Role;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.RoleMenu;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-09 15:00:49
 * @sign 74625812E46BFC5FC6705C4D34ACFA64
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,NAME, java.lang.String.class, "账户", "账户", java.lang.String.class, null);
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 密码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> PASSWD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,PASSWD, java.lang.String.class, "密码", "密码", java.lang.String.class, null);
	
	/**
	 * 手机号码 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,PHONE, java.lang.String.class, "手机号码", "手机号码", java.lang.String.class, null);
	
	/**
	 * 头像ID , 类型: java.lang.String
	*/
	public static final String PORTRAIT_ID="portraitId";
	
	/**
	 * 头像ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> PORTRAIT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,PORTRAIT_ID, java.lang.String.class, "头像ID", "头像ID", java.lang.String.class, null);
	
	/**
	 * 人员ID , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> PERSON_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,PERSON_ID, java.lang.String.class, "人员ID", "人员ID", java.lang.String.class, null);
	
	/**
	 * 语言 , 类型: java.lang.String
	*/
	public static final String LANGUAGE="language";
	
	/**
	 * 语言 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> LANGUAGE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,LANGUAGE, java.lang.String.class, "语言", "语言", java.lang.String.class, null);
	
	/**
	 * 员工ID , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,EMPLOYEE_ID, java.lang.String.class, "员工ID", "员工ID", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 缓存键 , 改变这个值，可使浏览器重新请求静态资源 , 类型: java.lang.String
	*/
	public static final String CACHE_KEY="cacheKey";
	
	/**
	 * 缓存键 , 改变这个值，可使浏览器重新请求静态资源 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> CACHE_KEY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,CACHE_KEY, java.lang.String.class, "缓存键", "改变这个值，可使浏览器重新请求静态资源", java.lang.String.class, null);
	
	/**
	 * 最后登录时间 , 类型: java.util.Date
	*/
	public static final String LAST_LOGIN_TIME="lastLoginTime";
	
	/**
	 * 最后登录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.util.Date> LAST_LOGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,LAST_LOGIN_TIME, java.util.Date.class, "最后登录时间", "最后登录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 角色清单 , 当前用户的所有角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final String ROLES="roles";
	
	/**
	 * 角色清单 , 当前用户的所有角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Role
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,org.github.foxnic.web.domain.oauth.Role> ROLES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,ROLES, java.util.List.class, "角色清单", "当前用户的所有角色清单", org.github.foxnic.web.domain.oauth.Role.class, null);
	
	/**
	 * 菜单清单 , 当前用户的所有菜单清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final String MENUS="menus";
	
	/**
	 * 菜单清单 , 当前用户的所有菜单清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.Menu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,org.github.foxnic.web.domain.oauth.Menu> MENUS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,MENUS, java.util.List.class, "菜单清单", "当前用户的所有菜单清单", org.github.foxnic.web.domain.oauth.Menu.class, null);
	
	/**
	 * 角色菜单关系清单 , 当前用户的所有角色菜单关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.RoleMenu
	*/
	public static final String ROLE_MENUS="roleMenus";
	
	/**
	 * 角色菜单关系清单 , 当前用户的所有角色菜单关系清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.oauth.RoleMenu
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.User,org.github.foxnic.web.domain.oauth.RoleMenu> ROLE_MENUS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.User.class ,ROLE_MENUS, java.util.List.class, "角色菜单关系清单", "当前用户的所有角色菜单关系清单", org.github.foxnic.web.domain.oauth.RoleMenu.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PASSWD , PHONE , PORTRAIT_ID , PERSON_ID , LANGUAGE , EMPLOYEE_ID , VALID , CACHE_KEY , LAST_LOGIN_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ROLES , MENUS , ROLE_MENUS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.User {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public User setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param name 账户
		 * @return 当前对象
		*/
		public User setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 密码
		 * @param passwd 密码
		 * @return 当前对象
		*/
		public User setPasswd(String passwd) {
			super.change(PASSWD,super.getPasswd(),passwd);
			super.setPasswd(passwd);
			return this;
		}
		
		/**
		 * 设置 手机号码
		 * @param phone 手机号码
		 * @return 当前对象
		*/
		public User setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 头像ID
		 * @param portraitId 头像ID
		 * @return 当前对象
		*/
		public User setPortraitId(String portraitId) {
			super.change(PORTRAIT_ID,super.getPortraitId(),portraitId);
			super.setPortraitId(portraitId);
			return this;
		}
		
		/**
		 * 设置 人员ID
		 * @param personId 人员ID
		 * @return 当前对象
		*/
		public User setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 语言
		 * @param language 语言
		 * @return 当前对象
		*/
		public User setLanguage(String language) {
			super.change(LANGUAGE,super.getLanguage(),language);
			super.setLanguage(language);
			return this;
		}
		
		/**
		 * 设置 员工ID
		 * @param employeeId 员工ID
		 * @return 当前对象
		*/
		public User setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public User setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 缓存键
		 * @param cacheKey 缓存键
		 * @return 当前对象
		*/
		public User setCacheKey(String cacheKey) {
			super.change(CACHE_KEY,super.getCacheKey(),cacheKey);
			super.setCacheKey(cacheKey);
			return this;
		}
		
		/**
		 * 设置 最后登录时间
		 * @param lastLoginTime 最后登录时间
		 * @return 当前对象
		*/
		public User setLastLoginTime(Date lastLoginTime) {
			super.change(LAST_LOGIN_TIME,super.getLastLoginTime(),lastLoginTime);
			super.setLastLoginTime(lastLoginTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public User setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public User setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public User setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public User setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public User setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public User setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public User setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public User setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 角色清单
		 * @param roles 角色清单
		 * @return 当前对象
		*/
		public User setRoles(List<Role> roles) {
			super.change(ROLES,super.getRoles(),roles);
			super.setRoles(roles);
			return this;
		}
		
		/**
		 * 设置 菜单清单
		 * @param menus 菜单清单
		 * @return 当前对象
		*/
		public User setMenus(List<Menu> menus) {
			super.change(MENUS,super.getMenus(),menus);
			super.setMenus(menus);
			return this;
		}
		
		/**
		 * 设置 角色菜单关系清单
		 * @param roleMenus 角色菜单关系清单
		 * @return 当前对象
		*/
		public User setRoleMenus(List<RoleMenu> roleMenus) {
			super.change(ROLE_MENUS,super.getRoleMenus(),roleMenus);
			super.setRoleMenus(roleMenus);
			return this;
		}
	}
}