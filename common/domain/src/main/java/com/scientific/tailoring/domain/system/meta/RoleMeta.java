package com.scientific.tailoring.domain.system.meta;

import com.scientific.tailoring.domain.system.Role;
import java.util.Date;
import com.scientific.tailoring.domain.system.User;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 10:48:51
 * @sign 690A28FC5421591881B58F41206F4728
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RoleMeta {
	
	/**
	 * 编号
	*/
	public static final String ID="id";
	
	/**
	 * 代码
	*/
	public static final String CODE="code";
	
	/**
	 * 名称
	*/
	public static final String NAME="name";
	
	/**
	 * 是否有效
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
	 * 用户清单 , 拥有当前角色的用户清单
	*/
	public static final String USERS="users";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USERS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.system.Role {
		
		/**
		 * 设置 编号
		 * @param id 编号
		 * @return 当前对象
		*/
		public Role setId(Integer id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
				return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public Role setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
				return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Role setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
				return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Role setValid(Boolean valid) {
			super.change(VALID,super.isValid(),valid);
			super.setValid(valid);
				return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Role setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
				return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Role setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
				return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Role setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
				return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Role setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
				return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Role setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
				return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Role setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
				return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Role setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
				return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Role setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
				return this;
		}
		
		/**
		 * 设置 用户清单
		 * @param users 用户清单
		 * @return 当前对象
		*/
		public Role setUsers(List<User> users) {
			super.change(USERS,super.getUsers(),users);
			super.setUsers(users);
				return this;
		}
}
}