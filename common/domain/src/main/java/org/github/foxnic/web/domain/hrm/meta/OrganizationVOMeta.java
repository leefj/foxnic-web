package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-29 17:12:26
 * @sign E0D27372A47B51669D48690ECC93B690
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OrganizationVOMeta extends OrganizationMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 是否加载所有子孙节点 , 1：是；0：否 , 类型: java.lang.Integer
	*/
	public static final String IS_LOAD_ALL_DESCENDANTS="isLoadAllDescendants";
	
	/**
	 * 是否加载所有子孙节点 , 1：是；0：否 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.Integer> IS_LOAD_ALL_DESCENDANTS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,IS_LOAD_ALL_DESCENDANTS, java.lang.Integer.class, "是否加载所有子孙节点", "1：是；0：否", java.lang.Integer.class, null);
	
	/**
	 * 根节点id或code , 根节点id , 类型: java.lang.String
	*/
	public static final String ROOT="root";
	
	/**
	 * 根节点id或code , 根节点id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> ROOT_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,ROOT, java.lang.String.class, "根节点id或code", "根节点id", java.lang.String.class, null);
	
	/**
	 * 呈现模式 , 呈现模式:pos,org,com,dept , 类型: java.lang.String
	*/
	public static final String TARGET_TYPE="targetType";
	
	/**
	 * 呈现模式 , 呈现模式:pos,org,com,dept , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.OrganizationVO,java.lang.String> TARGET_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.OrganizationVO.class ,TARGET_TYPE, java.lang.String.class, "呈现模式", "呈现模式:pos,org,com,dept", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , IS_LOAD_ALL_DESCENDANTS , ROOT , TARGET_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.OrganizationVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public OrganizationVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public OrganizationVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public OrganizationVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public OrganizationVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public OrganizationVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public OrganizationVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public OrganizationVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public OrganizationVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public OrganizationVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 是否加载所有子孙节点
		 * @param isLoadAllDescendants 是否加载所有子孙节点
		 * @return 当前对象
		*/
		public OrganizationVO setIsLoadAllDescendants(Integer isLoadAllDescendants) {
			super.change(IS_LOAD_ALL_DESCENDANTS,super.getIsLoadAllDescendants(),isLoadAllDescendants);
			super.setIsLoadAllDescendants(isLoadAllDescendants);
			return this;
		}
		
		/**
		 * 设置 根节点id或code
		 * @param root 根节点id或code
		 * @return 当前对象
		*/
		public OrganizationVO setRoot(String root) {
			super.change(ROOT,super.getRoot(),root);
			super.setRoot(root);
			return this;
		}
		
		/**
		 * 设置 呈现模式
		 * @param targetType 呈现模式
		 * @return 当前对象
		*/
		public OrganizationVO setTargetType(String targetType) {
			super.change(TARGET_TYPE,super.getTargetType(),targetType);
			super.setTargetType(targetType);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Organization setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 代码
		 * @param code 代码
		 * @return 当前对象
		*/
		public Organization setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 简称
		 * @param shortName 简称
		 * @return 当前对象
		*/
		public Organization setShortName(String shortName) {
			super.change(SHORT_NAME,super.getShortName(),shortName);
			super.setShortName(shortName);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param fullName 全称
		 * @return 当前对象
		*/
		public Organization setFullName(String fullName) {
			super.change(FULL_NAME,super.getFullName(),fullName);
			super.setFullName(fullName);
			return this;
		}
		
		/**
		 * 设置 组织类型
		 * @param type 组织类型
		 * @return 当前对象
		*/
		public Organization setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 上级ID
		 * @param parentId 上级ID
		 * @return 当前对象
		*/
		public Organization setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Organization setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 层级路径
		 * @param hierarchy 层级路径
		 * @return 当前对象
		*/
		public Organization setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public Organization setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 总公司ID
		 * @param companyId 总公司ID
		 * @return 当前对象
		*/
		public Organization setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Organization setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Organization setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Organization setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Organization setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Organization setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Organization setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Organization setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Organization setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Organization setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}