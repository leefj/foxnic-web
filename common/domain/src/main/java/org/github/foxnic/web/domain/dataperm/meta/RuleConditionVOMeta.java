package org.github.foxnic.web.domain.dataperm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.dataperm.RuleConditionVO;
import java.util.List;
import org.github.foxnic.web.domain.dataperm.RuleCondition;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:34
 * @sign 3A5FCE05AD12468E53F9CCE628938C3F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RuleConditionVOMeta extends RuleConditionMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 抬头 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 抬头 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> TITLE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,TITLE, java.lang.String.class, "抬头", "抬头", java.lang.String.class, null);
	
	/**
	 * 应用条件 , SpringEL表达式，返回 true / false , 类型: java.lang.String
	*/
	public static final String CONDITION_EXPR="conditionExpr";
	
	/**
	 * 应用条件 , SpringEL表达式，返回 true / false , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> CONDITION_EXPR_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,CONDITION_EXPR, java.lang.String.class, "应用条件", "SpringEL表达式，返回 true / false", java.lang.String.class, null);
	
	/**
	 * 应用条件测试值 , JSON , 类型: java.lang.String
	*/
	public static final String CONDITION_TEST_VALUE="conditionTestValue";
	
	/**
	 * 应用条件测试值 , JSON , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> CONDITION_TEST_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,CONDITION_TEST_VALUE, java.lang.String.class, "应用条件测试值", "JSON", java.lang.String.class, null);
	
	/**
	 * 规则ID , 类型: java.lang.String
	*/
	public static final String RULE_ID="ruleId";
	
	/**
	 * 规则ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> RULE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,RULE_ID, java.lang.String.class, "规则ID", "规则ID", java.lang.String.class, null);
	
	/**
	 * range , id , 类型: java.lang.String
	*/
	public static final String RANGE_ID="rangeId";
	
	/**
	 * range , id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> RANGE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,RANGE_ID, java.lang.String.class, "range", "id", java.lang.String.class, null);
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 上级ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> PARENT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,PARENT_ID, java.lang.String.class, "上级ID", "上级ID", java.lang.String.class, null);
	
	/**
	 * 查询的属性路径 , 类型: java.lang.String
	*/
	public static final String QUERY_PROPERTY="queryProperty";
	
	/**
	 * 查询的属性路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> QUERY_PROPERTY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,QUERY_PROPERTY, java.lang.String.class, "查询的属性路径", "查询的属性路径", java.lang.String.class, null);
	
	/**
	 * 查询字段 , 类型: java.lang.String
	*/
	public static final String QUERY_FIELD="queryField";
	
	/**
	 * 查询字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> QUERY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,QUERY_FIELD, java.lang.String.class, "查询字段", "查询字段", java.lang.String.class, null);
	
	/**
	 * 节点类型 , 逻辑组/表达式 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 节点类型 , 逻辑组/表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,TYPE, java.lang.String.class, "节点类型", "逻辑组/表达式", java.lang.String.class, null);
	
	/**
	 * 前置逻辑关系 , and/or , 类型: java.lang.String
	*/
	public static final String LOGIC="logic";
	
	/**
	 * 前置逻辑关系 , and/or , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> LOGIC_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,LOGIC, java.lang.String.class, "前置逻辑关系", "and/or", java.lang.String.class, null);
	
	/**
	 * 表达式类型 , 类型: java.lang.String
	*/
	public static final String EXPR_TYPE="exprType";
	
	/**
	 * 表达式类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> EXPR_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,EXPR_TYPE, java.lang.String.class, "表达式类型", "表达式类型", java.lang.String.class, null);
	
	/**
	 * 是否生效 , 相同的代码仅可以有一个是生效的 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否生效 , 相同的代码仅可以有一个是生效的 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,VALID, java.lang.Integer.class, "是否生效", "相同的代码仅可以有一个是生效的", java.lang.Integer.class, null);
	
	/**
	 * 变量 , 数组或Map结构 , 类型: java.lang.String
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 变量 , 数组或Map结构 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,VARIABLES, java.lang.String.class, "变量", "数组或Map结构", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.RuleConditionVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.RuleConditionVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TITLE , CONDITION_EXPR , CONDITION_TEST_VALUE , RULE_ID , RANGE_ID , PARENT_ID , QUERY_PROPERTY , QUERY_FIELD , TYPE , LOGIC , EXPR_TYPE , VALID , VARIABLES , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.dataperm.RuleConditionVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RuleConditionVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RuleConditionVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RuleConditionVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RuleConditionVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RuleConditionVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RuleConditionVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RuleConditionVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RuleConditionVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RuleConditionVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RuleCondition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 抬头
		 * @param title 抬头
		 * @return 当前对象
		*/
		public RuleCondition setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 应用条件
		 * @param conditionExpr 应用条件
		 * @return 当前对象
		*/
		public RuleCondition setConditionExpr(String conditionExpr) {
			super.change(CONDITION_EXPR,super.getConditionExpr(),conditionExpr);
			super.setConditionExpr(conditionExpr);
			return this;
		}
		
		/**
		 * 设置 应用条件测试值
		 * @param conditionTestValue 应用条件测试值
		 * @return 当前对象
		*/
		public RuleCondition setConditionTestValue(String conditionTestValue) {
			super.change(CONDITION_TEST_VALUE,super.getConditionTestValue(),conditionTestValue);
			super.setConditionTestValue(conditionTestValue);
			return this;
		}
		
		/**
		 * 设置 规则ID
		 * @param ruleId 规则ID
		 * @return 当前对象
		*/
		public RuleCondition setRuleId(String ruleId) {
			super.change(RULE_ID,super.getRuleId(),ruleId);
			super.setRuleId(ruleId);
			return this;
		}
		
		/**
		 * 设置 range
		 * @param rangeId range
		 * @return 当前对象
		*/
		public RuleCondition setRangeId(String rangeId) {
			super.change(RANGE_ID,super.getRangeId(),rangeId);
			super.setRangeId(rangeId);
			return this;
		}
		
		/**
		 * 设置 上级ID
		 * @param parentId 上级ID
		 * @return 当前对象
		*/
		public RuleCondition setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 查询的属性路径
		 * @param queryProperty 查询的属性路径
		 * @return 当前对象
		*/
		public RuleCondition setQueryProperty(String queryProperty) {
			super.change(QUERY_PROPERTY,super.getQueryProperty(),queryProperty);
			super.setQueryProperty(queryProperty);
			return this;
		}
		
		/**
		 * 设置 查询字段
		 * @param queryField 查询字段
		 * @return 当前对象
		*/
		public RuleCondition setQueryField(String queryField) {
			super.change(QUERY_FIELD,super.getQueryField(),queryField);
			super.setQueryField(queryField);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param type 节点类型
		 * @return 当前对象
		*/
		public RuleCondition setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 前置逻辑关系
		 * @param logic 前置逻辑关系
		 * @return 当前对象
		*/
		public RuleCondition setLogic(String logic) {
			super.change(LOGIC,super.getLogic(),logic);
			super.setLogic(logic);
			return this;
		}
		
		/**
		 * 设置 表达式类型
		 * @param exprType 表达式类型
		 * @return 当前对象
		*/
		public RuleCondition setExprType(String exprType) {
			super.change(EXPR_TYPE,super.getExprType(),exprType);
			super.setExprType(exprType);
			return this;
		}
		
		/**
		 * 设置 是否生效
		 * @param valid 是否生效
		 * @return 当前对象
		*/
		public RuleCondition setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 变量
		 * @param variables 变量
		 * @return 当前对象
		*/
		public RuleCondition setVariables(String variables) {
			super.change(VARIABLES,super.getVariables(),variables);
			super.setVariables(variables);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public RuleCondition setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public RuleCondition setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RuleCondition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RuleCondition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RuleCondition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RuleCondition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RuleCondition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RuleCondition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RuleCondition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public RuleCondition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public RuleConditionVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public RuleConditionVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setExprType(this.getExprType());
			inst.setVariables(this.getVariables());
			inst.setNotes(this.getNotes());
			inst.setQueryField(this.getQueryField());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setQueryProperty(this.getQueryProperty());
			inst.setSort(this.getSort());
			inst.setTitle(this.getTitle());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setParentId(this.getParentId());
			inst.setValid(this.getValid());
			inst.setRangeId(this.getRangeId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setConditionTestValue(this.getConditionTestValue());
			inst.setConditionExpr(this.getConditionExpr());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setLogic(this.getLogic());
			inst.setRuleId(this.getRuleId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}