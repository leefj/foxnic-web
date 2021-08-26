package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.Company;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 20:50:10
 * @sign 4981EDA388615A41983B8FA43A99137B
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
	 * 对否开通账号 , 类型: java.lang.Integer
	*/
	public static final String KEEP_ACCOUNT="keepAccount";
	
	/**
	 * 对否开通账号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.Employee,java.lang.Integer> KEEP_ACCOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.Employee.class ,KEEP_ACCOUNT, java.lang.Integer.class, "对否开通账号", "对否开通账号", java.lang.Integer.class, null);
	
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
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BADGE , PERSON_ID , COMPANY_ID , KEEP_ACCOUNT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PERSON , COMPANY , NAME_AND_BADGE };
	
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
		 * 设置 对否开通账号
		 * @param keepAccount 对否开通账号
		 * @return 当前对象
		*/
		public Employee setKeepAccount(Integer keepAccount) {
			super.change(KEEP_ACCOUNT,super.getKeepAccount(),keepAccount);
			super.setKeepAccount(keepAccount);
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
	}
}