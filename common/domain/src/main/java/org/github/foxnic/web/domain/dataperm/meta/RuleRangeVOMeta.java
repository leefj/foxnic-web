package org.github.foxnic.web.domain.dataperm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.dataperm.RuleRangeVO;
import java.util.List;
import org.github.foxnic.web.domain.dataperm.RuleRange;
import java.util.Date;
import org.github.foxnic.web.domain.dataperm.RuleCondition;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:43:26
 * @sign C9267E2EA7C5785364F5F108D7177760
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RuleRangeVOMeta extends RuleRangeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 规则ID , 类型: java.lang.String
	*/
	public static final String RULE_ID="ruleId";
	
	/**
	 * 规则ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> RULE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,RULE_ID, java.lang.String.class, "规则ID", "规则ID", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 是否生效 , 相同的代码仅可以有一个是生效的 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否生效 , 相同的代码仅可以有一个是生效的 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,VALID, java.lang.Integer.class, "是否生效", "相同的代码仅可以有一个是生效的", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 条件列表 , 用于构建条件语句 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.dataperm.RuleCondition
	*/
	public static final String CONDITIONS="conditions";
	
	/**
	 * 条件列表 , 用于构建条件语句 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.dataperm.RuleCondition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleRangeVO,org.github.foxnic.web.domain.dataperm.RuleCondition> CONDITIONS_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleRangeVO.class ,CONDITIONS, java.util.List.class, "条件列表", "用于构建条件语句", org.github.foxnic.web.domain.dataperm.RuleCondition.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , RULE_ID , NAME , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CONDITIONS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.dataperm.RuleRangeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RuleRangeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RuleRangeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RuleRangeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RuleRangeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RuleRangeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RuleRangeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RuleRangeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RuleRangeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RuleRangeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RuleRange setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 规则ID
		 * @param ruleId 规则ID
		 * @return 当前对象
		*/
		public RuleRange setRuleId(String ruleId) {
			super.change(RULE_ID,super.getRuleId(),ruleId);
			super.setRuleId(ruleId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public RuleRange setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 是否生效
		 * @param valid 是否生效
		 * @return 当前对象
		*/
		public RuleRange setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RuleRange setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RuleRange setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RuleRange setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RuleRange setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RuleRange setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RuleRange setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RuleRange setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public RuleRange setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 条件列表
		 * @param conditions 条件列表
		 * @return 当前对象
		*/
		public RuleRange setConditions(List<RuleCondition> conditions) {
			super.change(CONDITIONS,super.getConditions(),conditions);
			super.setConditions(conditions);
			return this;
		}
	}
}