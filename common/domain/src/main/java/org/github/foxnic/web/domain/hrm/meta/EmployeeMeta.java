package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.Company;
import org.github.foxnic.web.domain.hrm.Position;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.BusiRole;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:08:39
 * @sign 361D2893BFB110ABFAEB8B961A725C31
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EmployeeMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String BADGE="badge";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> BADGE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,BADGE, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> PHONE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 人员ID , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> PERSON_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PERSON_ID, java.lang.String.class, "人员ID", "人员ID", java.lang.String.class, null);
	
	/**
	 * 公司ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 公司ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> COMPANY_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,COMPANY_ID, java.lang.String.class, "公司ID", "公司ID", java.lang.String.class, null);
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,STATUS, java.lang.String.class, "状态", "字典代码：employee_status", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 对应的人员信息 , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * 对应的人员信息 , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Person> PERSON_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PERSON, org.github.foxnic.web.domain.hrm.Person.class, "对应的人员信息", "对应的人员信息", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Company
	*/
	public static final String COMPANY="company";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Company
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Company> COMPANY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,COMPANY, org.github.foxnic.web.domain.hrm.Company.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Company.class, null);
	
	/**
	 * 姓名与工号 , 虚拟属性 , 类型: java.lang.String
	*/
	public static final String NAME_AND_BADGE="nameAndBadge";
	
	/**
	 * 姓名与工号 , 虚拟属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> NAME_AND_BADGE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,NAME_AND_BADGE, java.lang.String.class, "姓名与工号", "虚拟属性", java.lang.String.class, null);
	
	/**
	 * 岗位清单 , 作为员工时，所属的岗位清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String POSITIONS="positions";
	
	/**
	 * 岗位清单 , 作为员工时，所属的岗位清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Position> POSITIONS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,POSITIONS, java.util.List.class, "岗位清单", "作为员工时，所属的岗位清单", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * 组织清单 , 作为员工时，所属的组织清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATIONS="organizations";
	
	/**
	 * 组织清单 , 作为员工时，所属的组织清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATIONS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,ORGANIZATIONS, java.util.List.class, "组织清单", "作为员工时，所属的组织清单", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 主岗 , 作为员工时，所属的主岗 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String PRIMARY_POSITION="primaryPosition";
	
	/**
	 * 主岗 , 作为员工时，所属的主岗 , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Position> PRIMARY_POSITION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PRIMARY_POSITION, org.github.foxnic.web.domain.hrm.Position.class, "主岗", "作为员工时，所属的主岗", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * 主岗部门 , 作为员工时，所属的主岗部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String PRIMARY_ORGANIZATION="primaryOrganization";
	
	/**
	 * 主岗部门 , 作为员工时，所属的主岗部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Organization> PRIMARY_ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PRIMARY_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "主岗部门", "作为员工时，所属的主岗部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 业务角色清单 , 作为员工时，所属的业务角色 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String BUSI_ROLES="busiRoles";
	
	/**
	 * 业务角色清单 , 作为员工时，所属的业务角色 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.system.BusiRole> BUSI_ROLES_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,BUSI_ROLES, java.util.List.class, "业务角色清单", "作为员工时，所属的业务角色", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 主岗ID , 只有一个 , 类型: java.lang.String
	*/
	public static final String PRIMARY_POSITION_ID="primaryPositionId";
	
	/**
	 * 主岗ID , 只有一个 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> PRIMARY_POSITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,PRIMARY_POSITION_ID, java.lang.String.class, "主岗ID", "只有一个", java.lang.String.class, null);
	
	/**
	 * 兼岗ID , 多个用逗号隔开 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String VICE_POSITION_IDS="vicePositionIds";
	
	/**
	 * 兼岗ID , 多个用逗号隔开 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> VICE_POSITION_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,VICE_POSITION_IDS, java.util.List.class, "兼岗ID", "多个用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 兼岗 , 作为员工时，所属的兼岗 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final String VICE_POSITIONS="vicePositions";
	
	/**
	 * 兼岗 , 作为员工时，所属的兼岗 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Position
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,org.github.foxnic.web.domain.hrm.Position> VICE_POSITIONS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,VICE_POSITIONS, java.util.List.class, "兼岗", "作为员工时，所属的兼岗", org.github.foxnic.web.domain.hrm.Position.class, null);
	
	/**
	 * name , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * name , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,NAME, java.lang.String.class, "name", "name", java.lang.String.class, null);
	
	/**
	 * sex , 类型: java.lang.String
	*/
	public static final String SEX="sex";
	
	/**
	 * sex , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> SEX_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,SEX, java.lang.String.class, "sex", "sex", java.lang.String.class, null);
	
	/**
	 * source , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * source , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> SOURCE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,SOURCE, java.lang.String.class, "source", "source", java.lang.String.class, null);
	
	/**
	 * identity , 类型: java.lang.String
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * identity , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.String> IDENTITY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,IDENTITY, java.lang.String.class, "identity", "identity", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BADGE , PHONE , PERSON_ID , COMPANY_ID , STATUS , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PERSON , COMPANY , NAME_AND_BADGE , POSITIONS , ORGANIZATIONS , PRIMARY_POSITION , PRIMARY_ORGANIZATION , BUSI_ROLES , PRIMARY_POSITION_ID , VICE_POSITION_IDS , VICE_POSITIONS , NAME , SEX , SOURCE , IDENTITY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.Employee {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Employee setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param badge 工号
		 * @return 当前对象
		*/
		public Employee setBadge(String badge) {
			super.change(BADGE,super.getBadge(),badge);
			super.setBadge(badge);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public Employee setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 人员ID
		 * @param personId 人员ID
		 * @return 当前对象
		*/
		public Employee setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 公司ID
		 * @param companyId 公司ID
		 * @return 当前对象
		*/
		public Employee setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Employee setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Employee setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Employee setCreateBy(String createBy) {
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
		public Employee setUpdateBy(String updateBy) {
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
		public Employee setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Employee setDeleteBy(String deleteBy) {
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
		 * 设置 对应的人员信息
		 * @param person 对应的人员信息
		 * @return 当前对象
		*/
		public Employee setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param company 所属公司
		 * @return 当前对象
		*/
		public Employee setCompany(Company company) {
			super.change(COMPANY,super.getCompany(),company);
			super.setCompany(company);
			return this;
		}
		
		/**
		 * 设置 姓名与工号
		 * @param nameAndBadge 姓名与工号
		 * @return 当前对象
		*/
		public Employee setNameAndBadge(String nameAndBadge) {
			super.change(NAME_AND_BADGE,super.getNameAndBadge(),nameAndBadge);
			super.setNameAndBadge(nameAndBadge);
			return this;
		}
		
		/**
		 * 设置 岗位清单
		 * @param positions 岗位清单
		 * @return 当前对象
		*/
		public Employee setPositions(List<Position> positions) {
			super.change(POSITIONS,super.getPositions(),positions);
			super.setPositions(positions);
			return this;
		}
		
		/**
		 * 设置 组织清单
		 * @param organizations 组织清单
		 * @return 当前对象
		*/
		public Employee setOrganizations(List<Organization> organizations) {
			super.change(ORGANIZATIONS,super.getOrganizations(),organizations);
			super.setOrganizations(organizations);
			return this;
		}
		
		/**
		 * 设置 主岗
		 * @param primaryPosition 主岗
		 * @return 当前对象
		*/
		public Employee setPrimaryPosition(Position primaryPosition) {
			super.change(PRIMARY_POSITION,super.getPrimaryPosition(),primaryPosition);
			super.setPrimaryPosition(primaryPosition);
			return this;
		}
		
		/**
		 * 设置 主岗部门
		 * @param primaryOrganization 主岗部门
		 * @return 当前对象
		*/
		public Employee setPrimaryOrganization(Organization primaryOrganization) {
			super.change(PRIMARY_ORGANIZATION,super.getPrimaryOrganization(),primaryOrganization);
			super.setPrimaryOrganization(primaryOrganization);
			return this;
		}
		
		/**
		 * 设置 业务角色清单
		 * @param busiRoles 业务角色清单
		 * @return 当前对象
		*/
		public Employee setBusiRoles(List<BusiRole> busiRoles) {
			super.change(BUSI_ROLES,super.getBusiRoles(),busiRoles);
			super.setBusiRoles(busiRoles);
			return this;
		}
		
		/**
		 * 设置 主岗ID
		 * @param primaryPositionId 主岗ID
		 * @return 当前对象
		*/
		public Employee setPrimaryPositionId(String primaryPositionId) {
			super.change(PRIMARY_POSITION_ID,super.getPrimaryPositionId(),primaryPositionId);
			super.setPrimaryPositionId(primaryPositionId);
			return this;
		}
		
		/**
		 * 设置 兼岗ID
		 * @param vicePositionIds 兼岗ID
		 * @return 当前对象
		*/
		public Employee setVicePositionIds(List<String> vicePositionIds) {
			super.change(VICE_POSITION_IDS,super.getVicePositionIds(),vicePositionIds);
			super.setVicePositionIds(vicePositionIds);
			return this;
		}
		
		/**
		 * 设置 兼岗
		 * @param vicePositions 兼岗
		 * @return 当前对象
		*/
		public Employee setVicePositions(List<Position> vicePositions) {
			super.change(VICE_POSITIONS,super.getVicePositions(),vicePositions);
			super.setVicePositions(vicePositions);
			return this;
		}
		
		/**
		 * 设置 name
		 * @param name name
		 * @return 当前对象
		*/
		public Employee setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 sex
		 * @param sex sex
		 * @return 当前对象
		*/
		public Employee setSex(String sex) {
			super.change(SEX,super.getSex(),sex);
			super.setSex(sex);
			return this;
		}
		
		/**
		 * 设置 source
		 * @param source source
		 * @return 当前对象
		*/
		public Employee setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 identity
		 * @param identity identity
		 * @return 当前对象
		*/
		public Employee setIdentity(String identity) {
			super.change(IDENTITY,super.getIdentity(),identity);
			super.setIdentity(identity);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Employee clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Employee duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setBadge(this.getBadge());
			inst.setCompanyId(this.getCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSex(this.getSex());
				inst.setPrimaryPositionId(this.getPrimaryPositionId());
				inst.setPositions(this.getPositions());
				inst.setVicePositions(this.getVicePositions());
				inst.setSource(this.getSource());
				inst.setVicePositionIds(this.getVicePositionIds());
				inst.setPrimaryPosition(this.getPrimaryPosition());
				inst.setPerson(this.getPerson());
				inst.setIdentity(this.getIdentity());
				inst.setNameAndBadge(this.getNameAndBadge());
				inst.setOrganizations(this.getOrganizations());
				inst.setName(this.getName());
				inst.setBusiRoles(this.getBusiRoles());
				inst.setCompany(this.getCompany());
				inst.setPrimaryOrganization(this.getPrimaryOrganization());
			}
			inst.clearModifies();
			return inst;
		}

	}
}