package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-11 15:25:29
 * @sign 293B3392AEBA621BE52D89818B2B5BF8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BusiRoleMemberMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.lang.String> ROLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,ROLE_ID, java.lang.String.class, "角色ID", "角色ID", java.lang.String.class, null);
	
	/**
	 * 成员ID , 类型: java.lang.String
	*/
	public static final String MEMBER_ID="memberId";
	
	/**
	 * 成员ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.lang.String> MEMBER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,MEMBER_ID, java.lang.String.class, "成员ID", "成员ID", java.lang.String.class, null);
	
	/**
	 * 成员类型 , UnifiedUserType枚举 , 类型: java.lang.String
	*/
	public static final String MEMBER_TYPE="memberType";
	
	/**
	 * 成员类型 , UnifiedUserType枚举 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.lang.String> MEMBER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,MEMBER_TYPE, java.lang.String.class, "成员类型", "UnifiedUserType枚举", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMember,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMember.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "员工", "员工", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ROLE_ID , MEMBER_ID , MEMBER_TYPE , CREATE_BY , CREATE_TIME , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.BusiRoleMember {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BusiRoleMember setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 角色ID
		 * @param roleId 角色ID
		 * @return 当前对象
		*/
		public BusiRoleMember setRoleId(String roleId) {
			super.change(ROLE_ID,super.getRoleId(),roleId);
			super.setRoleId(roleId);
			return this;
		}
		
		/**
		 * 设置 成员ID
		 * @param memberId 成员ID
		 * @return 当前对象
		*/
		public BusiRoleMember setMemberId(String memberId) {
			super.change(MEMBER_ID,super.getMemberId(),memberId);
			super.setMemberId(memberId);
			return this;
		}
		
		/**
		 * 设置 成员类型
		 * @param memberType 成员类型
		 * @return 当前对象
		*/
		public BusiRoleMember setMemberType(String memberType) {
			super.change(MEMBER_TYPE,super.getMemberType(),memberType);
			super.setMemberType(memberType);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BusiRoleMember setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BusiRoleMember setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param employee 员工
		 * @return 当前对象
		*/
		public BusiRoleMember setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}
	}
}