package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.BusiRole;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Position;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-10 16:27:20
 * @sign 87825961170D009F1E08F946FB545755
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BusiRoleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属组织ID , 类型: java.lang.Integer
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 所属组织ID , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.Integer> ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,ORG_ID, java.lang.Integer.class, "所属组织ID", "所属组织ID", java.lang.Integer.class, null);
	
	/**
	 * 角色代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 角色代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,CODE, java.lang.String.class, "角色代码", "角色代码", java.lang.String.class, null);
	
	/**
	 * 角色名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 角色名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,NAME, java.lang.String.class, "角色名称", "角色名称", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 成员路由 , Java类型用于检索扩展成员 , 类型: java.lang.String
	*/
	public static final String MEMBER_ROUTER="memberRouter";
	
	/**
	 * 成员路由 , Java类型用于检索扩展成员 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.String> MEMBER_ROUTER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,MEMBER_ROUTER, java.lang.String.class, "成员路由", "Java类型用于检索扩展成员", java.lang.String.class, null);
	
	/**
	 * 内置角色 , 系统内置角色 , 类型: java.lang.Integer
	*/
	public static final String BUILD_IN="buildIn";
	
	/**
	 * 内置角色 , 系统内置角色 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,java.lang.Integer> BUILD_IN_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,BUILD_IN, java.lang.Integer.class, "内置角色", "系统内置角色", java.lang.Integer.class, null);
	
	/**
	 * 关联员工清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEES="employees";
	
	/**
	 * 关联员工清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEES_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,EMPLOYEES, java.util.List.class, "关联员工清单", "关联员工清单", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 关联岗位清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String POSITIONS="positions";
	
	/**
	 * 关联岗位清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRole,org.github.foxnic.web.domain.hrm.Position> POSITIONS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRole.class ,POSITIONS, java.util.List.class, "关联岗位清单", "关联岗位清单", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORG_ID , CODE , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , NOTES , MEMBER_ROUTER , BUILD_IN , EMPLOYEES , POSITIONS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.BusiRole {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BusiRole setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属组织ID
		 * @param orgId 所属组织ID
		 * @return 当前对象
		*/
		public BusiRole setOrgId(Integer orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 角色代码
		 * @param code 角色代码
		 * @return 当前对象
		*/
		public BusiRole setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 角色名称
		 * @param name 角色名称
		 * @return 当前对象
		*/
		public BusiRole setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public BusiRole setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BusiRole setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BusiRole setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public BusiRole setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public BusiRole setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public BusiRole setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public BusiRole setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public BusiRole setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public BusiRole setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public BusiRole setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 成员路由
		 * @param memberRouter 成员路由
		 * @return 当前对象
		*/
		public BusiRole setMemberRouter(String memberRouter) {
			super.change(MEMBER_ROUTER,super.getMemberRouter(),memberRouter);
			super.setMemberRouter(memberRouter);
			return this;
		}
		
		/**
		 * 设置 内置角色
		 * @param buildIn 内置角色
		 * @return 当前对象
		*/
		public BusiRole setBuildIn(Integer buildIn) {
			super.change(BUILD_IN,super.getBuildIn(),buildIn);
			super.setBuildIn(buildIn);
			return this;
		}
		
		/**
		 * 设置 关联员工清单
		 * @param employees 关联员工清单
		 * @return 当前对象
		*/
		public BusiRole setEmployees(List<Employee> employees) {
			super.change(EMPLOYEES,super.getEmployees(),employees);
			super.setEmployees(employees);
			return this;
		}
		
		/**
		 * 设置 关联岗位清单
		 * @param positions 关联岗位清单
		 * @return 当前对象
		*/
		public BusiRole setPositions(List<Position> positions) {
			super.change(POSITIONS,super.getPositions(),positions);
			super.setPositions(positions);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public BusiRole clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public BusiRole duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setOrgId(this.getOrgId());
			inst.setValid(this.getValid());
			inst.setMemberRouter(this.getMemberRouter());
			inst.setBuildIn(this.getBuildIn());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setPositions(this.getPositions());
				inst.setEmployees(this.getEmployees());
			}
			inst.clearModifies();
			return inst;
		}

	}
}