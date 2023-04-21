package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemind;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-21 14:49:09
 * @sign 59CE4356DAE7C66615715B0647A7EE65
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceRemindVOMeta extends ProcessInstanceRemindMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 接收人参数 , 类型: java.lang.String
	*/
	public static final String RECEIVER_INFO="receiverInfo";
	
	/**
	 * 接收人参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> RECEIVER_INFO_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,RECEIVER_INFO, java.lang.String.class, "接收人参数", "接收人参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 监控的目标节点ID , 类型: java.lang.String
	*/
	public static final String TARGET_NODE_ID="targetNodeId";
	
	/**
	 * 监控的目标节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> TARGET_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,TARGET_NODE_ID, java.lang.String.class, "监控的目标节点ID", "监控的目标节点ID", java.lang.String.class, null);
	
	/**
	 * 设置提醒的节点ID , 类型: java.lang.String
	*/
	public static final String SOURCE_NODE_ID="sourceNodeId";
	
	/**
	 * 设置提醒的节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> SOURCE_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,SOURCE_NODE_ID, java.lang.String.class, "设置提醒的节点ID", "设置提醒的节点ID", java.lang.String.class, null);
	
	/**
	 * 提醒内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 提醒内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> CONTENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,CONTENT, java.lang.String.class, "提醒内容", "提醒内容", java.lang.String.class, null);
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final String REMIND_TIME="remindTime";
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.util.Date> REMIND_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,REMIND_TIME, java.util.Date.class, "提醒时间", "提醒时间", java.util.Date.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 提醒时长 , 类型: java.lang.Integer
	*/
	public static final String REMIND_TERM="remindTerm";
	
	/**
	 * 提醒时长 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.Integer> REMIND_TERM_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,REMIND_TERM, java.lang.Integer.class, "提醒时长", "提醒时长", java.lang.Integer.class, null);
	
	/**
	 * 提醒时长单位 , 类型: java.lang.String
	*/
	public static final String REMIND_TERM_UNIT="remindTermUnit";
	
	/**
	 * 提醒时长单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.lang.String> REMIND_TERM_UNIT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,REMIND_TERM_UNIT, java.lang.String.class, "提醒时长单位", "提醒时长单位", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String COMPLETE_TIME="completeTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,java.util.Date> COMPLETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,COMPLETE_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 接收人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver
	*/
	public static final String RECEIVERS="receivers";
	
	/**
	 * 接收人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver> RECEIVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,RECEIVERS, java.util.List.class, "接收人清单", "接收人清单", org.github.foxnic.web.domain.bpm.ProcessInstanceRemindReceiver.class, null);
	
	/**
	 * 监控的目标节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final String TARGET_NODE="targetNode";
	
	/**
	 * 监控的目标节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,org.github.foxnic.web.domain.bpm.ProcessDefinitionNode> TARGET_NODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,TARGET_NODE, org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, "监控的目标节点", "监控的目标节点", org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, null);
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String PROCESS_INSTANCE="processInstance";
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO,org.github.foxnic.web.domain.bpm.ProcessInstance> PROCESS_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO.class ,PROCESS_INSTANCE, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "流程实例", "流程实例", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , RECEIVER_INFO , ID , PROCESS_INSTANCE_ID , TARGET_NODE_ID , SOURCE_NODE_ID , CONTENT , REMIND_TIME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , STATUS , REMIND_TERM , REMIND_TERM_UNIT , COMPLETE_TIME , RECEIVERS , TARGET_NODE , PROCESS_INSTANCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessInstanceRemindVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 接收人参数
		 * @param receiverInfo 接收人参数
		 * @return 当前对象
		*/
		public ProcessInstanceRemindVO setReceiverInfo(String receiverInfo) {
			super.change(RECEIVER_INFO,super.getReceiverInfo(),receiverInfo);
			super.setReceiverInfo(receiverInfo);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 监控的目标节点ID
		 * @param targetNodeId 监控的目标节点ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTargetNodeId(String targetNodeId) {
			super.change(TARGET_NODE_ID,super.getTargetNodeId(),targetNodeId);
			super.setTargetNodeId(targetNodeId);
			return this;
		}
		
		/**
		 * 设置 设置提醒的节点ID
		 * @param sourceNodeId 设置提醒的节点ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setSourceNodeId(String sourceNodeId) {
			super.change(SOURCE_NODE_ID,super.getSourceNodeId(),sourceNodeId);
			super.setSourceNodeId(sourceNodeId);
			return this;
		}
		
		/**
		 * 设置 提醒内容
		 * @param content 提醒内容
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 提醒时间
		 * @param remindTime 提醒时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTime(Date remindTime) {
			super.change(REMIND_TIME,super.getRemindTime(),remindTime);
			super.setRemindTime(remindTime);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 提醒时长
		 * @param remindTerm 提醒时长
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTerm(Integer remindTerm) {
			super.change(REMIND_TERM,super.getRemindTerm(),remindTerm);
			super.setRemindTerm(remindTerm);
			return this;
		}
		
		/**
		 * 设置 提醒时长单位
		 * @param remindTermUnit 提醒时长单位
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setRemindTermUnit(String remindTermUnit) {
			super.change(REMIND_TERM_UNIT,super.getRemindTermUnit(),remindTermUnit);
			super.setRemindTermUnit(remindTermUnit);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param completeTime 处理时间
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setCompleteTime(Date completeTime) {
			super.change(COMPLETE_TIME,super.getCompleteTime(),completeTime);
			super.setCompleteTime(completeTime);
			return this;
		}
		
		/**
		 * 设置 接收人清单
		 * @param receivers 接收人清单
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setReceivers(List<ProcessInstanceRemindReceiver> receivers) {
			super.change(RECEIVERS,super.getReceivers(),receivers);
			super.setReceivers(receivers);
			return this;
		}
		
		/**
		 * 设置 监控的目标节点
		 * @param targetNode 监控的目标节点
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setTargetNode(ProcessDefinitionNode targetNode) {
			super.change(TARGET_NODE,super.getTargetNode(),targetNode);
			super.setTargetNode(targetNode);
			return this;
		}
		
		/**
		 * 设置 流程实例
		 * @param processInstance 流程实例
		 * @return 当前对象
		*/
		public ProcessInstanceRemind setProcessInstance(ProcessInstance processInstance) {
			super.change(PROCESS_INSTANCE,super.getProcessInstance(),processInstance);
			super.setProcessInstance(processInstance);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessInstanceRemindVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessInstanceRemindVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setCompleteTime(this.getCompleteTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setRemindTermUnit(this.getRemindTermUnit());
			inst.setContent(this.getContent());
			inst.setRemindTerm(this.getRemindTerm());
			inst.setRemindTime(this.getRemindTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setSourceNodeId(this.getSourceNodeId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTargetNodeId(this.getTargetNodeId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setReceiverInfo(this.getReceiverInfo());
				inst.setProcessInstance(this.getProcessInstance());
				inst.setPageSize(this.getPageSize());
				inst.setTargetNode(this.getTargetNode());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setReceivers(this.getReceivers());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}