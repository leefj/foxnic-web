package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.ResourzeVO;
import java.util.List;
import org.github.foxnic.web.domain.oauth.Resourze;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-03-10 16:43:00
 * @sign C2A151465BF6F5FD70354A6F3F9B69D9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ResourzeVOMeta extends ResourzeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , api/page , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , api/page , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,TYPE, java.lang.String.class, "类型", "api/page", java.lang.String.class, null);
	
	/**
	 * 访问控制类型 , 类型: java.lang.String
	*/
	public static final String ACCESS_TYPE="accessType";
	
	/**
	 * 访问控制类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> ACCESS_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,ACCESS_TYPE, java.lang.String.class, "访问控制类型", "访问控制类型", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String URL="url";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> URL_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,URL, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * HttpMethod , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * HttpMethod , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> METHOD_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,METHOD, java.lang.String.class, "HttpMethod", "HttpMethod", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_ID="batchId";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> BATCH_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,BATCH_ID, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 来源表 , 类型: java.lang.String
	*/
	public static final String TABLE_NAME="tableName";
	
	/**
	 * 来源表 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> TABLE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,TABLE_NAME, java.lang.String.class, "来源表", "来源表", java.lang.String.class, null);
	
	/**
	 * 来源模块 , 类型: java.lang.String
	*/
	public static final String MODULE="module";
	
	/**
	 * 来源模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> MODULE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,MODULE, java.lang.String.class, "来源模块", "来源模块", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.ResourzeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.ResourzeVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NAME , TYPE , ACCESS_TYPE , URL , METHOD , BATCH_ID , CREATE_BY , TABLE_NAME , MODULE , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.ResourzeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ResourzeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ResourzeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ResourzeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ResourzeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ResourzeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ResourzeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ResourzeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ResourzeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ResourzeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Resourze setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Resourze setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Resourze setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 访问控制类型
		 * @param accessType 访问控制类型
		 * @return 当前对象
		*/
		public Resourze setAccessType(String accessType) {
			super.change(ACCESS_TYPE,super.getAccessType(),accessType);
			super.setAccessType(accessType);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param url 地址
		 * @return 当前对象
		*/
		public Resourze setUrl(String url) {
			super.change(URL,super.getUrl(),url);
			super.setUrl(url);
			return this;
		}
		
		/**
		 * 设置 HttpMethod
		 * @param method HttpMethod
		 * @return 当前对象
		*/
		public Resourze setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchId 批次号
		 * @return 当前对象
		*/
		public Resourze setBatchId(String batchId) {
			super.change(BATCH_ID,super.getBatchId(),batchId);
			super.setBatchId(batchId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Resourze setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 来源表
		 * @param tableName 来源表
		 * @return 当前对象
		*/
		public Resourze setTableName(String tableName) {
			super.change(TABLE_NAME,super.getTableName(),tableName);
			super.setTableName(tableName);
			return this;
		}
		
		/**
		 * 设置 来源模块
		 * @param module 来源模块
		 * @return 当前对象
		*/
		public Resourze setModule(String module) {
			super.change(MODULE,super.getModule(),module);
			super.setModule(module);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Resourze setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Resourze setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Resourze setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Resourze setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Resourze setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Resourze setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Resourze setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}