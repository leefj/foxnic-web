package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.User;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.Role;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.RoleMenu;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-04 13:33:08
 * @sign 8B2FC9A375D6AC8EE2713F195A336928
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 账户
	*/
	public static final String NAME="name";
	
	/**
	 * 密码
	*/
	public static final String PASSWD="passwd";
	
	/**
	 * 盐
	*/
	public static final String SALT="salt";
	
	/**
	 * 手机号码
	*/
	public static final String MOBILE="mobile";
	
	/**
	 * 人员ID
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 员工ID
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 是否有效
	*/
	public static final String VALID="valid";
	
	/**
	 * 最后登录时间
	*/
	public static final String LAST_LOGIN_TIME="lastLoginTime";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 角色清单 , 当前用户的所有角色清单
	*/
	public static final String ROLES="roles";
	
	/**
	 * 菜单清单 , 当前用户的所有菜单清单
	*/
	public static final String MENUS="menus";
	
	/**
	 * 角色菜单关系清单 , 当前用户的所有角色菜单关系清单
	*/
	public static final String ROLE_MENUS="roleMenus";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PASSWD , SALT , MOBILE , PERSON_ID , EMPLOYEE_ID , VALID , LAST_LOGIN_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ROLES , MENUS , ROLE_MENUS };
	
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
		 * 设置 盐
		 * @param salt 盐
		 * @return 当前对象
		*/
		public User setSalt(String salt) {
			super.change(SALT,super.getSalt(),salt);
			super.setSalt(salt);
			return this;
		}
		
		/**
		 * 设置 手机号码
		 * @param mobile 手机号码
		 * @return 当前对象
		*/
		public User setMobile(String mobile) {
			super.change(MOBILE,super.getMobile(),mobile);
			super.setMobile(mobile);
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