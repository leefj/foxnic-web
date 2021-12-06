package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.UserTenantVO;
import java.util.List;
import org.github.foxnic.web.domain.system.UserTenant;
import java.util.Date;
import org.github.foxnic.web.domain.system.Tenant;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-06 15:56:15
 * @sign 8CA490A5122A70352BFEA50988BB52B9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserTenantVOMeta extends UserTenantMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,USER_ID, java.lang.String.class, "用户ID", "用户ID", java.lang.String.class, null);
	
	/**
	 * 所属的租户ID , 类型: java.lang.String
	*/
	public static final String OWNER_TENANT_ID="ownerTenantId";
	
	/**
	 * 所属的租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> OWNER_TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,OWNER_TENANT_ID, java.lang.String.class, "所属的租户ID", "所属的租户ID", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 是否激活 , 激活时为当前默认租户 , 类型: java.lang.Integer
	*/
	public static final String ACTIVATED="activated";
	
	/**
	 * 是否激活 , 激活时为当前默认租户 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> ACTIVATED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,ACTIVATED, java.lang.Integer.class, "是否激活", "激活时为当前默认租户", java.lang.Integer.class, null);
	
	/**
	 * 员工ID , 账户在指定租户下的员工ID , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 员工ID , 账户在指定租户下的员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,EMPLOYEE_ID, java.lang.String.class, "员工ID", "账户在指定租户下的员工ID", java.lang.String.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户对象 , 类型: org.github.foxnic.web.domain.system.Tenant
	*/
	public static final String TENANT="tenant";
	
	/**
	 * 租户对象 , 类型: org.github.foxnic.web.domain.system.Tenant
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,org.github.foxnic.web.domain.system.Tenant> TENANT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,TENANT, org.github.foxnic.web.domain.system.Tenant.class, "租户对象", "租户对象", org.github.foxnic.web.domain.system.Tenant.class, null);
	
	/**
	 * 当前激活的租户对应的员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 当前激活的租户对应的员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.UserTenantVO,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.UserTenantVO.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "当前激活的租户对应的员工", "当前激活的租户对应的员工", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , USER_ID , OWNER_TENANT_ID , VALID , ACTIVATED , EMPLOYEE_ID , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.UserTenantVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public UserTenantVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public UserTenantVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public UserTenantVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public UserTenantVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public UserTenantVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public UserTenantVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public UserTenantVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public UserTenantVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public UserTenantVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public UserTenant setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户ID
		 * @param userId 用户ID
		 * @return 当前对象
		*/
		public UserTenant setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 所属的租户ID
		 * @param ownerTenantId 所属的租户ID
		 * @return 当前对象
		*/
		public UserTenant setOwnerTenantId(String ownerTenantId) {
			super.change(OWNER_TENANT_ID,super.getOwnerTenantId(),ownerTenantId);
			super.setOwnerTenantId(ownerTenantId);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public UserTenant setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 是否激活
		 * @param activated 是否激活
		 * @return 当前对象
		*/
		public UserTenant setActivated(Integer activated) {
			super.change(ACTIVATED,super.getActivated(),activated);
			super.setActivated(activated);
			return this;
		}
		
		/**
		 * 设置 员工ID
		 * @param employeeId 员工ID
		 * @return 当前对象
		*/
		public UserTenant setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public UserTenant setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public UserTenant setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public UserTenant setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public UserTenant setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public UserTenant setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public UserTenant setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public UserTenant setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public UserTenant setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public UserTenant setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户对象
		 * @param tenant 租户对象
		 * @return 当前对象
		*/
		public UserTenant setTenant(Tenant tenant) {
			super.change(TENANT,super.getTenant(),tenant);
			super.setTenant(tenant);
			return this;
		}
		
		/**
		 * 设置 当前激活的租户对应的员工
		 * @param employee 当前激活的租户对应的员工
		 * @return 当前对象
		*/
		public UserTenant setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}
	}
}