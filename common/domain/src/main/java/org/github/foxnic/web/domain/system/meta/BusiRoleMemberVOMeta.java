package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.BusiRoleMemberVO;
import java.util.List;
import org.github.foxnic.web.domain.system.BusiRoleMember;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:18:40
 * @sign 91B7798AFF270EF43E150699E728B1FC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BusiRoleMemberVOMeta extends BusiRoleMemberMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 角色ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> ROLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,ROLE_ID, java.lang.String.class, "角色ID", "角色ID", java.lang.String.class, null);
	
	/**
	 * 成员ID , 类型: java.lang.String
	*/
	public static final String MEMBER_ID="memberId";
	
	/**
	 * 成员ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> MEMBER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,MEMBER_ID, java.lang.String.class, "成员ID", "成员ID", java.lang.String.class, null);
	
	/**
	 * 成员类型 , UnifiedUserType枚举 , 类型: java.lang.String
	*/
	public static final String MEMBER_TYPE="memberType";
	
	/**
	 * 成员类型 , UnifiedUserType枚举 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> MEMBER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,MEMBER_TYPE, java.lang.String.class, "成员类型", "UnifiedUserType枚举", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * 员工 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.BusiRoleMemberVO,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.BusiRoleMemberVO.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "员工", "员工", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , ROLE_ID , MEMBER_ID , MEMBER_TYPE , CREATE_BY , CREATE_TIME , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.BusiRoleMemberVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public BusiRoleMemberVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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

		/**
		 * 克隆当前对象
		*/
		@Transient
		public BusiRoleMemberVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public BusiRoleMemberVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCreateBy(this.getCreateBy());
			inst.setCreateTime(this.getCreateTime());
			inst.setRoleId(this.getRoleId());
			inst.setId(this.getId());
			inst.setMemberType(this.getMemberType());
			inst.setMemberId(this.getMemberId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setIds(this.getIds());
				inst.setEmployee(this.getEmployee());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}