package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.User;
import java.util.Date;
import com.scientific.tailoring.domain.system.Role;
import java.util.List;
import com.scientific.tailoring.domain.crm.Employee;



/**
 * @author 李方捷
 * @since 2021-05-17 10:53:40
 * @sign F1B77ED2D9D45ABF2F16C1A5B446DDBB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 登录帐号
	*/
	public static final String ACCOUNT="account";
	
	/**
	 * 姓名
	*/
	public static final String NAME="name";
	
	/**
	 * 登录密码
	*/
	public static final String PASSWORD="password";
	
	/**
	 * 手机号码
	*/
	public static final String MOBILE="mobile";
	
	/**
	 * 头像文件ID
	*/
	public static final String PORTRAIT_ID="portraitId";
	
	/**
	 * 最近登录时间
	*/
	public static final String LATEST_LOGIN_TIME="latestLoginTime";
	
	/**
	 * 是否有效 , 禁用:0/启用:1
	*/
	public static final String VALID="valid";
	
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
	 * 所有角色清单 , 拥有当前用户的所有角色清单
	*/
	public static final String ALL_ROLES="allRoles";
	
	/**
	 * 可用角色清单 , 拥有当前用户的可用角色清单
	*/
	public static final String VALID_ROLES="validRoles";
	
	/**
	 * 员工 , 当前账户对应的员工
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ACCOUNT , NAME , PASSWORD , MOBILE , PORTRAIT_ID , LATEST_LOGIN_TIME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ALL_ROLES , VALID_ROLES , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.User {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public User setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
				return this;
		}
		
		/**
		 * 设置 登录帐号
		 * @param account 登录帐号
		 * @return 当前对象
		*/
		public User setAccount(String account) {
			super.change(ACCOUNT,super.getAccount(),account);
			super.setAccount(account);
				return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public User setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
				return this;
		}
		
		/**
		 * 设置 登录密码
		 * @param password 登录密码
		 * @return 当前对象
		*/
		public User setPassword(String password) {
			super.change(PASSWORD,super.getPassword(),password);
			super.setPassword(password);
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
		 * 设置 头像文件ID
		 * @param portraitId 头像文件ID
		 * @return 当前对象
		*/
		public User setPortraitId(Long portraitId) {
			super.change(PORTRAIT_ID,super.getPortraitId(),portraitId);
			super.setPortraitId(portraitId);
				return this;
		}
		
		/**
		 * 设置 最近登录时间
		 * @param latestLoginTime 最近登录时间
		 * @return 当前对象
		*/
		public User setLatestLoginTime(Date latestLoginTime) {
			super.change(LATEST_LOGIN_TIME,super.getLatestLoginTime(),latestLoginTime);
			super.setLatestLoginTime(latestLoginTime);
				return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public User setValid(Boolean valid) {
			super.change(VALID,super.isValid(),valid);
			super.setValid(valid);
				return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public User setCreateBy(Long createBy) {
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
		public User setUpdateBy(Long updateBy) {
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
		public User setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
				return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public User setDeleteBy(Long deleteBy) {
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
		 * 设置 所有角色清单
		 * @param allRoles 所有角色清单
		 * @return 当前对象
		*/
		public User setAllRoles(List<Role> allRoles) {
			super.change(ALL_ROLES,super.getAllRoles(),allRoles);
			super.setAllRoles(allRoles);
				return this;
		}
		
		/**
		 * 设置 可用角色清单
		 * @param validRoles 可用角色清单
		 * @return 当前对象
		*/
		public User setValidRoles(List<Role> validRoles) {
			super.change(VALID_ROLES,super.getValidRoles(),validRoles);
			super.setValidRoles(validRoles);
				return this;
		}
		
		/**
		 * 设置 员工
		 * @param employee 员工
		 * @return 当前对象
		*/
		public User setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
				return this;
		}
}
}