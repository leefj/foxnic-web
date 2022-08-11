package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.EventCallbackVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.EventCallback;
import java.sql.Timestamp;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-20 15:57:40
 * @sign 8AB138D81375D4D1FEC1DE74A201FC1A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class EventCallbackVOMeta extends EventCallbackMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * BPM流程ID , 类型: java.lang.String
	*/
	public static final String BPM_PROCESS_INSTANCE_ID="bpmProcessInstanceId";
	
	/**
	 * BPM流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> BPM_PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,BPM_PROCESS_INSTANCE_ID, java.lang.String.class, "BPM流程ID", "BPM流程ID", java.lang.String.class, null);
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 变量 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,VARIABLES, java.lang.String.class, "变量", "变量", java.lang.String.class, null);
	
	/**
	 * camunda流程ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_PROCESS_INSTANCE_ID="camundaProcessInstanceId";
	
	/**
	 * camunda流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> CAMUNDA_PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CAMUNDA_PROCESS_INSTANCE_ID, java.lang.String.class, "camunda流程ID", "camunda流程ID", java.lang.String.class, null);
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final String EVENT_TYPE="eventType";
	
	/**
	 * 事件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> EVENT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,EVENT_TYPE, java.lang.String.class, "事件类型", "事件类型", java.lang.String.class, null);
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,NODE_ID, java.lang.String.class, "节点ID", "节点ID", java.lang.String.class, null);
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,NODE_NAME, java.lang.String.class, "节点名称", "节点名称", java.lang.String.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String ERROR="error";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> ERROR_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,ERROR, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,RESULT, java.lang.String.class, "处理结果", "处理结果", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 调用时间 , 类型: java.sql.Timestamp
	*/
	public static final String INVOKE_TIME="invokeTime";
	
	/**
	 * 调用时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.sql.Timestamp> INVOKE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,INVOKE_TIME, java.sql.Timestamp.class, "调用时间", "调用时间", java.sql.Timestamp.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final String RETRYS="retrys";
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.Integer> RETRYS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,RETRYS, java.lang.Integer.class, "失败重试次数", "失败重试次数", java.lang.Integer.class, null);
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final String NODE_TYPE="nodeType";
	
	/**
	 * 节点类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> NODE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,NODE_TYPE, java.lang.String.class, "节点类型", "节点类型", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BPM_PROCESS_INSTANCE_ID , VARIABLES , CAMUNDA_PROCESS_INSTANCE_ID , EVENT_TYPE , NODE_ID , NODE_NAME , ERROR , RESULT , STATUS , INVOKE_TIME , CREATE_TIME , RETRYS , NODE_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.EventCallbackVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public EventCallbackVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public EventCallbackVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public EventCallbackVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public EventCallbackVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public EventCallbackVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public EventCallbackVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public EventCallbackVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public EventCallbackVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public EventCallbackVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public EventCallback setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 BPM流程ID
		 * @param bpmProcessInstanceId BPM流程ID
		 * @return 当前对象
		*/
		public EventCallback setBpmProcessInstanceId(String bpmProcessInstanceId) {
			super.change(BPM_PROCESS_INSTANCE_ID,super.getBpmProcessInstanceId(),bpmProcessInstanceId);
			super.setBpmProcessInstanceId(bpmProcessInstanceId);
			return this;
		}
		
		/**
		 * 设置 变量
		 * @param variables 变量
		 * @return 当前对象
		*/
		public EventCallback setVariables(String variables) {
			super.change(VARIABLES,super.getVariables(),variables);
			super.setVariables(variables);
			return this;
		}
		
		/**
		 * 设置 camunda流程ID
		 * @param camundaProcessInstanceId camunda流程ID
		 * @return 当前对象
		*/
		public EventCallback setCamundaProcessInstanceId(String camundaProcessInstanceId) {
			super.change(CAMUNDA_PROCESS_INSTANCE_ID,super.getCamundaProcessInstanceId(),camundaProcessInstanceId);
			super.setCamundaProcessInstanceId(camundaProcessInstanceId);
			return this;
		}
		
		/**
		 * 设置 事件类型
		 * @param eventType 事件类型
		 * @return 当前对象
		*/
		public EventCallback setEventType(String eventType) {
			super.change(EVENT_TYPE,super.getEventType(),eventType);
			super.setEventType(eventType);
			return this;
		}
		
		/**
		 * 设置 节点ID
		 * @param nodeId 节点ID
		 * @return 当前对象
		*/
		public EventCallback setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 节点名称
		 * @param nodeName 节点名称
		 * @return 当前对象
		*/
		public EventCallback setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param error 异常信息
		 * @return 当前对象
		*/
		public EventCallback setError(String error) {
			super.change(ERROR,super.getError(),error);
			super.setError(error);
			return this;
		}
		
		/**
		 * 设置 处理结果
		 * @param result 处理结果
		 * @return 当前对象
		*/
		public EventCallback setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public EventCallback setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 调用时间
		 * @param invokeTime 调用时间
		 * @return 当前对象
		*/
		public EventCallback setInvokeTime(Timestamp invokeTime) {
			super.change(INVOKE_TIME,super.getInvokeTime(),invokeTime);
			super.setInvokeTime(invokeTime);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public EventCallback setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 失败重试次数
		 * @param retrys 失败重试次数
		 * @return 当前对象
		*/
		public EventCallback setRetrys(Integer retrys) {
			super.change(RETRYS,super.getRetrys(),retrys);
			super.setRetrys(retrys);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param nodeType 节点类型
		 * @return 当前对象
		*/
		public EventCallback setNodeType(String nodeType) {
			super.change(NODE_TYPE,super.getNodeType(),nodeType);
			super.setNodeType(nodeType);
			return this;
		}
	}
}