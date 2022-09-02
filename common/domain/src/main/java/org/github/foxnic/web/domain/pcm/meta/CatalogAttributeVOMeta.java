package org.github.foxnic.web.domain.pcm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.pcm.CatalogAttributeVO;
import java.util.List;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAllocation;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:40:38
 * @sign 81BB19F6E419EE7AFE95B10FD3567030
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CatalogAttributeVOMeta extends CatalogAttributeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 存储ID , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 存储ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> CATALOG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,CATALOG_ID, java.lang.String.class, "存储ID", "存储ID", java.lang.String.class, null);
	
	/**
	 * 字段名 , 自定义的字段别名 , 类型: java.lang.String
	*/
	public static final String FIELD="field";
	
	/**
	 * 字段名 , 自定义的字段别名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,FIELD, java.lang.String.class, "字段名", "自定义的字段别名", java.lang.String.class, null);
	
	/**
	 * 是否必填 , 类型: java.lang.Integer
	*/
	public static final String NOT_NULL="notNull";
	
	/**
	 * 是否必填 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> NOT_NULL_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,NOT_NULL, java.lang.Integer.class, "是否必填", "是否必填", java.lang.Integer.class, null);
	
	/**
	 * 配置版本号 , 类型: java.lang.String
	*/
	public static final String VERSION_NO="versionNo";
	
	/**
	 * 配置版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> VERSION_NO_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,VERSION_NO, java.lang.String.class, "配置版本号", "配置版本号", java.lang.String.class, null);
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final String DATA_TYPE="dataType";
	
	/**
	 * 数据类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> DATA_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DATA_TYPE, java.lang.String.class, "数据类型", "数据类型", java.lang.String.class, null);
	
	/**
	 * 数据长度 , 类型: java.lang.Integer
	*/
	public static final String LENGTH="length";
	
	/**
	 * 数据长度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> LENGTH_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,LENGTH, java.lang.Integer.class, "数据长度", "数据长度", java.lang.Integer.class, null);
	
	/**
	 * 数据精度 , 类型: java.lang.Integer
	*/
	public static final String ACCURACY="accuracy";
	
	/**
	 * 数据精度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> ACCURACY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,ACCURACY, java.lang.Integer.class, "数据精度", "数据精度", java.lang.Integer.class, null);
	
	/**
	 * 小数位数 , 类型: java.lang.Integer
	*/
	public static final String SCALE="scale";
	
	/**
	 * 小数位数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> SCALE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SCALE, java.lang.Integer.class, "小数位数", "小数位数", java.lang.Integer.class, null);
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final String SHORT_NAME="shortName";
	
	/**
	 * 简称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SHORT_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SHORT_NAME, java.lang.String.class, "简称", "简称", java.lang.String.class, null);
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final String FULL_NAME="fullName";
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> FULL_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,FULL_NAME, java.lang.String.class, "全称", "全称", java.lang.String.class, null);
	
	/**
	 * 提示信息 , 类型: java.lang.String
	*/
	public static final String HINT="hint";
	
	/**
	 * 提示信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> HINT_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,HINT, java.lang.String.class, "提示信息", "提示信息", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String DETAIL="detail";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> DETAIL_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DETAIL, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> NOTE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 原属性ID , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 原属性ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> SOURCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SOURCE_ID, java.lang.String.class, "原属性ID", "原属性ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 类目对象 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 类目对象 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,org.github.foxnic.web.domain.pcm.Catalog> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,CATALOG, org.github.foxnic.web.domain.pcm.Catalog.class, "类目对象", "类目对象", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 分配的字段 , 类型: org.github.foxnic.web.domain.pcm.CatalogAllocation
	*/
	public static final String ALLOCATION="allocation";
	
	/**
	 * 分配的字段 , 类型: org.github.foxnic.web.domain.pcm.CatalogAllocation
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,org.github.foxnic.web.domain.pcm.CatalogAllocation> ALLOCATION_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,ALLOCATION, org.github.foxnic.web.domain.pcm.CatalogAllocation.class, "分配的字段", "分配的字段", org.github.foxnic.web.domain.pcm.CatalogAllocation.class, null);
	
	/**
	 * 重新分配前的字段 , 用于字段参数变更时登记 , 类型: org.github.foxnic.web.domain.pcm.CatalogAllocation
	*/
	public static final String ALLOCATION_BEFORE="allocationBefore";
	
	/**
	 * 重新分配前的字段 , 用于字段参数变更时登记 , 类型: org.github.foxnic.web.domain.pcm.CatalogAllocation
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,org.github.foxnic.web.domain.pcm.CatalogAllocation> ALLOCATION_BEFORE_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,ALLOCATION_BEFORE, org.github.foxnic.web.domain.pcm.CatalogAllocation.class, "重新分配前的字段", "用于字段参数变更时登记", org.github.foxnic.web.domain.pcm.CatalogAllocation.class, null);
	
	/**
	 * 来源 , 上一个版本的配置信息 , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final String SOURCE_ATTR="sourceAttr";
	
	/**
	 * 来源 , 上一个版本的配置信息 , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.pcm.CatalogAttributeVO,org.github.foxnic.web.domain.pcm.CatalogAttribute> SOURCE_ATTR_PROP = new BeanProperty(org.github.foxnic.web.domain.pcm.CatalogAttributeVO.class ,SOURCE_ATTR, org.github.foxnic.web.domain.pcm.CatalogAttribute.class, "来源", "上一个版本的配置信息", org.github.foxnic.web.domain.pcm.CatalogAttribute.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CATALOG_ID , FIELD , NOT_NULL , VERSION_NO , DATA_TYPE , LENGTH , ACCURACY , SCALE , SHORT_NAME , FULL_NAME , HINT , DETAIL , NOTE , VALID , SOURCE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CATALOG , ALLOCATION , ALLOCATION_BEFORE , SOURCE_ATTR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.pcm.CatalogAttributeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CatalogAttributeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CatalogAttributeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CatalogAttributeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CatalogAttributeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CatalogAttributeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CatalogAttributeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CatalogAttributeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CatalogAttributeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CatalogAttributeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CatalogAttribute setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 存储ID
		 * @param catalogId 存储ID
		 * @return 当前对象
		*/
		public CatalogAttribute setCatalogId(String catalogId) {
			super.change(CATALOG_ID,super.getCatalogId(),catalogId);
			super.setCatalogId(catalogId);
			return this;
		}
		
		/**
		 * 设置 字段名
		 * @param field 字段名
		 * @return 当前对象
		*/
		public CatalogAttribute setField(String field) {
			super.change(FIELD,super.getField(),field);
			super.setField(field);
			return this;
		}
		
		/**
		 * 设置 是否必填
		 * @param notNull 是否必填
		 * @return 当前对象
		*/
		public CatalogAttribute setNotNull(Integer notNull) {
			super.change(NOT_NULL,super.getNotNull(),notNull);
			super.setNotNull(notNull);
			return this;
		}
		
		/**
		 * 设置 配置版本号
		 * @param versionNo 配置版本号
		 * @return 当前对象
		*/
		public CatalogAttribute setVersionNo(String versionNo) {
			super.change(VERSION_NO,super.getVersionNo(),versionNo);
			super.setVersionNo(versionNo);
			return this;
		}
		
		/**
		 * 设置 数据类型
		 * @param dataType 数据类型
		 * @return 当前对象
		*/
		public CatalogAttribute setDataType(String dataType) {
			super.change(DATA_TYPE,super.getDataType(),dataType);
			super.setDataType(dataType);
			return this;
		}
		
		/**
		 * 设置 数据长度
		 * @param length 数据长度
		 * @return 当前对象
		*/
		public CatalogAttribute setLength(Integer length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 数据精度
		 * @param accuracy 数据精度
		 * @return 当前对象
		*/
		public CatalogAttribute setAccuracy(Integer accuracy) {
			super.change(ACCURACY,super.getAccuracy(),accuracy);
			super.setAccuracy(accuracy);
			return this;
		}
		
		/**
		 * 设置 小数位数
		 * @param scale 小数位数
		 * @return 当前对象
		*/
		public CatalogAttribute setScale(Integer scale) {
			super.change(SCALE,super.getScale(),scale);
			super.setScale(scale);
			return this;
		}
		
		/**
		 * 设置 简称
		 * @param shortName 简称
		 * @return 当前对象
		*/
		public CatalogAttribute setShortName(String shortName) {
			super.change(SHORT_NAME,super.getShortName(),shortName);
			super.setShortName(shortName);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param fullName 全称
		 * @return 当前对象
		*/
		public CatalogAttribute setFullName(String fullName) {
			super.change(FULL_NAME,super.getFullName(),fullName);
			super.setFullName(fullName);
			return this;
		}
		
		/**
		 * 设置 提示信息
		 * @param hint 提示信息
		 * @return 当前对象
		*/
		public CatalogAttribute setHint(String hint) {
			super.change(HINT,super.getHint(),hint);
			super.setHint(hint);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param detail 说明
		 * @return 当前对象
		*/
		public CatalogAttribute setDetail(String detail) {
			super.change(DETAIL,super.getDetail(),detail);
			super.setDetail(detail);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public CatalogAttribute setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public CatalogAttribute setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 原属性ID
		 * @param sourceId 原属性ID
		 * @return 当前对象
		*/
		public CatalogAttribute setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CatalogAttribute setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CatalogAttribute setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CatalogAttribute setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CatalogAttribute setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 类目对象
		 * @param catalog 类目对象
		 * @return 当前对象
		*/
		public CatalogAttribute setCatalog(Catalog catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}
		
		/**
		 * 设置 分配的字段
		 * @param allocation 分配的字段
		 * @return 当前对象
		*/
		public CatalogAttribute setAllocation(CatalogAllocation allocation) {
			super.change(ALLOCATION,super.getAllocation(),allocation);
			super.setAllocation(allocation);
			return this;
		}
		
		/**
		 * 设置 重新分配前的字段
		 * @param allocationBefore 重新分配前的字段
		 * @return 当前对象
		*/
		public CatalogAttribute setAllocationBefore(CatalogAllocation allocationBefore) {
			super.change(ALLOCATION_BEFORE,super.getAllocationBefore(),allocationBefore);
			super.setAllocationBefore(allocationBefore);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceAttr 来源
		 * @return 当前对象
		*/
		public CatalogAttribute setSourceAttr(CatalogAttribute sourceAttr) {
			super.change(SOURCE_ATTR,super.getSourceAttr(),sourceAttr);
			super.setSourceAttr(sourceAttr);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CatalogAttributeVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CatalogAttributeVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSourceId(this.getSourceId());
			inst.setNote(this.getNote());
			inst.setNotNull(this.getNotNull());
			inst.setDataType(this.getDataType());
			inst.setLength(this.getLength());
			inst.setAccuracy(this.getAccuracy());
			inst.setScale(this.getScale());
			inst.setFullName(this.getFullName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setValid(this.getValid());
			inst.setCreateBy(this.getCreateBy());
			inst.setCatalogId(this.getCatalogId());
			inst.setDeleted(this.getDeleted());
			inst.setField(this.getField());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setHint(this.getHint());
			inst.setVersionNo(this.getVersionNo());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setDetail(this.getDetail());
			inst.setShortName(this.getShortName());
			if(all) {
				inst.setAllocation(this.getAllocation());
				inst.setSearchField(this.getSearchField());
				inst.setCatalog(this.getCatalog());
				inst.setAllocationBefore(this.getAllocationBefore());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setSourceAttr(this.getSourceAttr());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}