package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessErrorVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessError;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-29 14:36:05
 * @sign 23D7B501483EF32F33CA062A375B9A2C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessErrorVOMeta extends ProcessErrorMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程ID", "流程ID", java.lang.String.class, null);
	
	/**
	 * 审批节点 , 类型: java.lang.String
	*/
	public static final String APPROVAL_NODE_ID="approvalNodeId";
	
	/**
	 * 审批节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> APPROVAL_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,APPROVAL_NODE_ID, java.lang.String.class, "审批节点", "审批节点", java.lang.String.class, null);
	
	/**
	 * 错误节点 , 类型: java.lang.String
	*/
	public static final String ERROR_NODE_ID="errorNodeId";
	
	/**
	 * 错误节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> ERROR_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,ERROR_NODE_ID, java.lang.String.class, "错误节点", "错误节点", java.lang.String.class, null);
	
	/**
	 * 错误消息 , 类型: java.lang.String
	*/
	public static final String ERROR_MESSAGE="errorMessage";
	
	/**
	 * 错误消息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> ERROR_MESSAGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,ERROR_MESSAGE, java.lang.String.class, "错误消息", "错误消息", java.lang.String.class, null);
	
	/**
	 * 错误时间 , 类型: java.util.Date
	*/
	public static final String ERROR_TIME="errorTime";
	
	/**
	 * 错误时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.util.Date> ERROR_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,ERROR_TIME, java.util.Date.class, "错误时间", "错误时间", java.util.Date.class, null);
	
	/**
	 * 原始 , incident id , 类型: java.lang.String
	*/
	public static final String CAMUNDA_INCIDENT_ID="camundaIncidentId";
	
	/**
	 * 原始 , incident id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> CAMUNDA_INCIDENT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,CAMUNDA_INCIDENT_ID, java.lang.String.class, "原始", "incident id", java.lang.String.class, null);
	
	/**
	 * 错误类型 , 类型: java.lang.String
	*/
	public static final String ERROR_TYPE="errorType";
	
	/**
	 * 错误类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessErrorVO,java.lang.String> ERROR_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessErrorVO.class ,ERROR_TYPE, java.lang.String.class, "错误类型", "错误类型", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PROCESS_INSTANCE_ID , APPROVAL_NODE_ID , ERROR_NODE_ID , ERROR_MESSAGE , ERROR_TIME , CAMUNDA_INCIDENT_ID , ERROR_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessErrorVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProcessErrorVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProcessErrorVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProcessErrorVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProcessErrorVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProcessErrorVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProcessErrorVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProcessErrorVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProcessErrorVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProcessErrorVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessError setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param processInstanceId 流程ID
		 * @return 当前对象
		*/
		public ProcessError setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 审批节点
		 * @param approvalNodeId 审批节点
		 * @return 当前对象
		*/
		public ProcessError setApprovalNodeId(String approvalNodeId) {
			super.change(APPROVAL_NODE_ID,super.getApprovalNodeId(),approvalNodeId);
			super.setApprovalNodeId(approvalNodeId);
			return this;
		}
		
		/**
		 * 设置 错误节点
		 * @param errorNodeId 错误节点
		 * @return 当前对象
		*/
		public ProcessError setErrorNodeId(String errorNodeId) {
			super.change(ERROR_NODE_ID,super.getErrorNodeId(),errorNodeId);
			super.setErrorNodeId(errorNodeId);
			return this;
		}
		
		/**
		 * 设置 错误消息
		 * @param errorMessage 错误消息
		 * @return 当前对象
		*/
		public ProcessError setErrorMessage(String errorMessage) {
			super.change(ERROR_MESSAGE,super.getErrorMessage(),errorMessage);
			super.setErrorMessage(errorMessage);
			return this;
		}
		
		/**
		 * 设置 错误时间
		 * @param errorTime 错误时间
		 * @return 当前对象
		*/
		public ProcessError setErrorTime(Date errorTime) {
			super.change(ERROR_TIME,super.getErrorTime(),errorTime);
			super.setErrorTime(errorTime);
			return this;
		}
		
		/**
		 * 设置 原始
		 * @param camundaIncidentId 原始
		 * @return 当前对象
		*/
		public ProcessError setCamundaIncidentId(String camundaIncidentId) {
			super.change(CAMUNDA_INCIDENT_ID,super.getCamundaIncidentId(),camundaIncidentId);
			super.setCamundaIncidentId(camundaIncidentId);
			return this;
		}
		
		/**
		 * 设置 错误类型
		 * @param errorType 错误类型
		 * @return 当前对象
		*/
		public ProcessError setErrorType(String errorType) {
			super.change(ERROR_TYPE,super.getErrorType(),errorType);
			super.setErrorType(errorType);
			return this;
		}
	}
}