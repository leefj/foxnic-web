package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.FavouriteGroupItem;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-20 06:12:37
 * @sign 4148054337F801F7EBB7B1A828385A53
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavouriteGroupItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 对象ID , 类型: java.lang.String
	*/
	public static final String TARGET_ID="targetId";
	
	/**
	 * 对象ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> TARGET_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,TARGET_ID, java.lang.String.class, "对象ID", "对象ID", java.lang.String.class, null);
	
	/**
	 * 对象类型 , 类型: java.lang.String
	*/
	public static final String TARGET_TYPE="targetType";
	
	/**
	 * 对象类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> TARGET_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,TARGET_TYPE, java.lang.String.class, "对象类型", "对象类型", java.lang.String.class, null);
	
	/**
	 * 对象名称 , 类型: java.lang.String
	*/
	public static final String TARGET_NAME="targetName";
	
	/**
	 * 对象名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> TARGET_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,TARGET_NAME, java.lang.String.class, "对象名称", "对象名称", java.lang.String.class, null);
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 层级路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> GROUP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,GROUP_ID, java.lang.String.class, "层级路径", "层级路径", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 所有者ID , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 所有者ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,EMPLOYEE_ID, java.lang.String.class, "所有者ID", "所有者ID", java.lang.String.class, null);
	
	/**
	 * 是否临时 , 类型: java.lang.Integer
	*/
	public static final String TEMPORARY="temporary";
	
	/**
	 * 是否临时 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.Integer> TEMPORARY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,TEMPORARY, java.lang.Integer.class, "是否临时", "是否临时", java.lang.Integer.class, null);
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> COMPANY_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,COMPANY_ID, java.lang.String.class, "总公司ID", "总公司ID", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 关联的员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 关联的员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "关联的员工", "", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 关联的部门 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 关联的部门 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,org.github.foxnic.web.domain.hrm.Employee> ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Employee.class, "关联的部门", "", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 关联的岗位 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String POSITION="position";
	
	/**
	 * 关联的岗位 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.FavouriteGroupItem,org.github.foxnic.web.domain.hrm.Employee> POSITION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.FavouriteGroupItem.class ,POSITION, org.github.foxnic.web.domain.hrm.Employee.class, "关联的岗位", "", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TARGET_ID , TARGET_TYPE , TARGET_NAME , GROUP_ID , SORT , EMPLOYEE_ID , TEMPORARY , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EMPLOYEE , ORGANIZATION , POSITION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.FavouriteGroupItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public FavouriteGroupItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 对象ID
		 * @param targetId 对象ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setTargetId(String targetId) {
			super.change(TARGET_ID,super.getTargetId(),targetId);
			super.setTargetId(targetId);
			return this;
		}
		
		/**
		 * 设置 对象类型
		 * @param targetType 对象类型
		 * @return 当前对象
		*/
		public FavouriteGroupItem setTargetType(String targetType) {
			super.change(TARGET_TYPE,super.getTargetType(),targetType);
			super.setTargetType(targetType);
			return this;
		}
		
		/**
		 * 设置 对象名称
		 * @param targetName 对象名称
		 * @return 当前对象
		*/
		public FavouriteGroupItem setTargetName(String targetName) {
			super.change(TARGET_NAME,super.getTargetName(),targetName);
			super.setTargetName(targetName);
			return this;
		}
		
		/**
		 * 设置 层级路径
		 * @param groupId 层级路径
		 * @return 当前对象
		*/
		public FavouriteGroupItem setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public FavouriteGroupItem setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 所有者ID
		 * @param employeeId 所有者ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 是否临时
		 * @param temporary 是否临时
		 * @return 当前对象
		*/
		public FavouriteGroupItem setTemporary(Integer temporary) {
			super.change(TEMPORARY,super.getTemporary(),temporary);
			super.setTemporary(temporary);
			return this;
		}
		
		/**
		 * 设置 总公司ID
		 * @param companyId 总公司ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public FavouriteGroupItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public FavouriteGroupItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public FavouriteGroupItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public FavouriteGroupItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public FavouriteGroupItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public FavouriteGroupItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 关联的员工
		 * @param employee 关联的员工
		 * @return 当前对象
		*/
		public FavouriteGroupItem setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}
		
		/**
		 * 设置 关联的部门
		 * @param organization 关联的部门
		 * @return 当前对象
		*/
		public FavouriteGroupItem setOrganization(Employee organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 关联的岗位
		 * @param position 关联的岗位
		 * @return 当前对象
		*/
		public FavouriteGroupItem setPosition(Employee position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
	}
}