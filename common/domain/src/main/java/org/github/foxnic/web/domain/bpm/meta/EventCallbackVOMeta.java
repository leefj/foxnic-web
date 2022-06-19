package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.EventCallbackVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.EventCallback;
import java.sql.Timestamp;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-19 18:51:22
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
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * camunda_process_id , 类型: java.lang.String
	*/
	public static final String CAMUNDA_PROCESS_ID="camundaProcessId";
	
	/**
	 * camunda_process_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> CAMUNDA_PROCESS_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CAMUNDA_PROCESS_ID, java.lang.String.class, "camunda_process_id", "camunda_process_id", java.lang.String.class, null);
	
	/**
	 * event_type , 类型: java.lang.String
	*/
	public static final String EVENT_TYPE="eventType";
	
	/**
	 * event_type , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> EVENT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,EVENT_TYPE, java.lang.String.class, "event_type", "event_type", java.lang.String.class, null);
	
	/**
	 * camunda_node_id , 类型: java.lang.Integer
	*/
	public static final String CAMUNDA_NODE_ID="camundaNodeId";
	
	/**
	 * camunda_node_id , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.Integer> CAMUNDA_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CAMUNDA_NODE_ID, java.lang.Integer.class, "camunda_node_id", "camunda_node_id", java.lang.Integer.class, null);
	
	/**
	 * camunda_node_name , 类型: java.lang.String
	*/
	public static final String CAMUNDA_NODE_NAME="camundaNodeName";
	
	/**
	 * camunda_node_name , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> CAMUNDA_NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CAMUNDA_NODE_NAME, java.lang.String.class, "camunda_node_name", "camunda_node_name", java.lang.String.class, null);
	
	/**
	 * error , 类型: java.lang.String
	*/
	public static final String ERROR="error";
	
	/**
	 * error , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> ERROR_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,ERROR, java.lang.String.class, "error", "error", java.lang.String.class, null);
	
	/**
	 * result , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * result , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,RESULT, java.lang.String.class, "result", "result", java.lang.String.class, null);
	
	/**
	 * queue_status , 类型: java.lang.String
	*/
	public static final String QUEUE_STATUS="queueStatus";
	
	/**
	 * queue_status , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.String> QUEUE_STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,QUEUE_STATUS, java.lang.String.class, "queue_status", "queue_status", java.lang.String.class, null);
	
	/**
	 * queue_time , 类型: java.sql.Timestamp
	*/
	public static final String QUEUE_TIME="queueTime";
	
	/**
	 * queue_time , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.sql.Timestamp> QUEUE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,QUEUE_TIME, java.sql.Timestamp.class, "queue_time", "queue_time", java.sql.Timestamp.class, null);
	
	/**
	 * create_time , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * create_time , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,CREATE_TIME, java.util.Date.class, "create_time", "create_time", java.util.Date.class, null);
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final String QUEUE_RETRYS="queueRetrys";
	
	/**
	 * 失败重试次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.EventCallbackVO,java.lang.Integer> QUEUE_RETRYS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.EventCallbackVO.class ,QUEUE_RETRYS, java.lang.Integer.class, "失败重试次数", "失败重试次数", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CAMUNDA_PROCESS_ID , EVENT_TYPE , CAMUNDA_NODE_ID , CAMUNDA_NODE_NAME , ERROR , RESULT , QUEUE_STATUS , QUEUE_TIME , CREATE_TIME , QUEUE_RETRYS };
	
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
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public EventCallback setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 camunda_process_id
		 * @param camundaProcessId camunda_process_id
		 * @return 当前对象
		*/
		public EventCallback setCamundaProcessId(String camundaProcessId) {
			super.change(CAMUNDA_PROCESS_ID,super.getCamundaProcessId(),camundaProcessId);
			super.setCamundaProcessId(camundaProcessId);
			return this;
		}
		
		/**
		 * 设置 event_type
		 * @param eventType event_type
		 * @return 当前对象
		*/
		public EventCallback setEventType(String eventType) {
			super.change(EVENT_TYPE,super.getEventType(),eventType);
			super.setEventType(eventType);
			return this;
		}
		
		/**
		 * 设置 camunda_node_id
		 * @param camundaNodeId camunda_node_id
		 * @return 当前对象
		*/
		public EventCallback setCamundaNodeId(Integer camundaNodeId) {
			super.change(CAMUNDA_NODE_ID,super.getCamundaNodeId(),camundaNodeId);
			super.setCamundaNodeId(camundaNodeId);
			return this;
		}
		
		/**
		 * 设置 camunda_node_name
		 * @param camundaNodeName camunda_node_name
		 * @return 当前对象
		*/
		public EventCallback setCamundaNodeName(String camundaNodeName) {
			super.change(CAMUNDA_NODE_NAME,super.getCamundaNodeName(),camundaNodeName);
			super.setCamundaNodeName(camundaNodeName);
			return this;
		}
		
		/**
		 * 设置 error
		 * @param error error
		 * @return 当前对象
		*/
		public EventCallback setError(String error) {
			super.change(ERROR,super.getError(),error);
			super.setError(error);
			return this;
		}
		
		/**
		 * 设置 result
		 * @param result result
		 * @return 当前对象
		*/
		public EventCallback setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 queue_status
		 * @param queueStatus queue_status
		 * @return 当前对象
		*/
		public EventCallback setQueueStatus(String queueStatus) {
			super.change(QUEUE_STATUS,super.getQueueStatus(),queueStatus);
			super.setQueueStatus(queueStatus);
			return this;
		}
		
		/**
		 * 设置 queue_time
		 * @param queueTime queue_time
		 * @return 当前对象
		*/
		public EventCallback setQueueTime(Timestamp queueTime) {
			super.change(QUEUE_TIME,super.getQueueTime(),queueTime);
			super.setQueueTime(queueTime);
			return this;
		}
		
		/**
		 * 设置 create_time
		 * @param createTime create_time
		 * @return 当前对象
		*/
		public EventCallback setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 失败重试次数
		 * @param queueRetrys 失败重试次数
		 * @return 当前对象
		*/
		public EventCallback setQueueRetrys(Integer queueRetrys) {
			super.change(QUEUE_RETRYS,super.getQueueRetrys(),queueRetrys);
			super.setQueueRetrys(queueRetrys);
			return this;
		}
	}
}