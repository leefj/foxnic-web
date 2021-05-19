package com.scientific.tailoring.domain.crm.meta;

import com.scientific.tailoring.domain.crm.Employee;
import java.util.Date;
import com.scientific.tailoring.domain.system.User;



/**
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 5145FEAD94802E8B5CFC8AD8065896B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EmployeeMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 所属部门ID
	*/
	public static final String DEPARTMENT_ID="departmentId";
	
	/**
	 * 公司ID
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 用户ID
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 员工姓名
	*/
	public static final String NAME="name";
	
	/**
	 * 员工性别
	*/
	public static final String SEX="sex";
	
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
	 * 账户 , 当前员工对应的账户
	*/
	public static final String USER="user";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DEPARTMENT_ID , COMPANY_ID , USER_ID , NAME , SEX , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.crm.Employee {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Employee setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属部门ID
		 * @param departmentId 所属部门ID
		 * @return 当前对象
		*/
		public Employee setDepartmentId(Long departmentId) {
			super.change(DEPARTMENT_ID,super.getDepartmentId(),departmentId);
			super.setDepartmentId(departmentId);
			return this;
		}
		
		/**
		 * 设置 公司ID
		 * @param companyId 公司ID
		 * @return 当前对象
		*/
		public Employee setCompanyId(Long companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 用户ID
		 * @param userId 用户ID
		 * @return 当前对象
		*/
		public Employee setUserId(Long userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 员工姓名
		 * @param name 员工姓名
		 * @return 当前对象
		*/
		public Employee setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 员工性别
		 * @param sex 员工性别
		 * @return 当前对象
		*/
		public Employee setSex(String sex) {
			super.change(SEX,super.getSex(),sex);
			super.setSex(sex);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Employee setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Employee setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Employee setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Employee setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Employee setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Employee setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Employee setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Employee setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 账户
		 * @param user 账户
		 * @return 当前对象
		*/
		public Employee setUser(User user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
}
}