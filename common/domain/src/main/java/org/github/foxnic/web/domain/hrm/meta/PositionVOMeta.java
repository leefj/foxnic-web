package org.github.foxnic.web.domain.hrm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.hrm.PositionVO;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Position;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-22 09:54:44
 * @sign 57B4E87C769EDE2B2E63B3010FE13C38
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PositionVOMeta extends PositionMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属组织ID , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 所属组织ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> ORG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,ORG_ID, java.lang.String.class, "所属组织ID", "所属组织ID", java.lang.String.class, null);
	
	/**
	 * 岗位代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 岗位代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,CODE, java.lang.String.class, "岗位代码", "岗位代码", java.lang.String.class, null);
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final String FULL_NAME="fullName";
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> FULL_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,FULL_NAME, java.lang.String.class, "全称", "全称", java.lang.String.class, null);
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final String SHORT_NAME="shortName";
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> SHORT_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SHORT_NAME, java.lang.String.class, "简称", "简称", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 总公司ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> COMPANY_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,COMPANY_ID, java.lang.String.class, "总公司ID", "总公司ID", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 岗位类型 , 关联字典 position_type , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 岗位类型 , 关联字典 position_type , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,TYPE, java.lang.String.class, "岗位类型", "关联字典 position_type", java.lang.String.class, null);
	
	/**
	 * 所属组织节点 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 所属组织节点 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.hrm.PositionVO,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(org.github.foxnic.web.domain.hrm.PositionVO.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "所属组织节点", "所属组织节点", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , ORG_ID , CODE , FULL_NAME , SHORT_NAME , VALID , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TYPE , ORGANIZATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.hrm.PositionVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PositionVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PositionVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PositionVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PositionVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PositionVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PositionVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PositionVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PositionVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PositionVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Position setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属组织ID
		 * @param orgId 所属组织ID
		 * @return 当前对象
		*/
		public Position setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 岗位代码
		 * @param code 岗位代码
		 * @return 当前对象
		*/
		public Position setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param fullName 全称
		 * @return 当前对象
		*/
		public Position setFullName(String fullName) {
			super.change(FULL_NAME,super.getFullName(),fullName);
			super.setFullName(fullName);
			return this;
		}
		
		/**
		 * 设置 简称
		 * @param shortName 简称
		 * @return 当前对象
		*/
		public Position setShortName(String shortName) {
			super.change(SHORT_NAME,super.getShortName(),shortName);
			super.setShortName(shortName);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Position setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public Position setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 总公司ID
		 * @param companyId 总公司ID
		 * @return 当前对象
		*/
		public Position setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Position setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Position setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Position setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Position setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Position setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Position setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Position setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Position setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Position setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 岗位类型
		 * @param type 岗位类型
		 * @return 当前对象
		*/
		public Position setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 所属组织节点
		 * @param organization 所属组织节点
		 * @return 当前对象
		*/
		public Position setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
	}
}