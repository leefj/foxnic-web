package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.TaskApprovalVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.TaskApproval;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.oauth.User;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:42:57
 * @sign 8AADFC2034A1D7FE4953FB4DB8BCD27E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskApprovalVOMeta extends TaskApprovalMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,TASK_ID, java.lang.String.class, "任务ID", "任务ID", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 审批人账户ID , 实际的审批人 , 类型: java.lang.String
	*/
	public static final String APPROVAL_USER_ID="approvalUserId";
	
	/**
	 * 审批人账户ID , 实际的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> APPROVAL_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVAL_USER_ID, java.lang.String.class, "审批人账户ID", "实际的审批人", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String APPROVAL_TIME="approvalTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.util.Date> APPROVAL_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVAL_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final String APPROVAL_RESULT="approvalResult";
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> APPROVAL_RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVAL_RESULT, java.lang.String.class, "审批结果", "审批结果", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_COMMENT="approvalComment";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> APPROVAL_COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVAL_COMMENT, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 审批人类型 , 预计的审批人类型 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_TYPE="assigneeType";
	
	/**
	 * 审批人类型 , 预计的审批人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> ASSIGNEE_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,ASSIGNEE_TYPE, java.lang.String.class, "审批人类型", "预计的审批人类型", java.lang.String.class, null);
	
	/**
	 * 审批人ID , 预计的审批人 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_ID="assigneeId";
	
	/**
	 * 审批人ID , 预计的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> ASSIGNEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,ASSIGNEE_ID, java.lang.String.class, "审批人ID", "预计的审批人", java.lang.String.class, null);
	
	/**
	 * 变量数据 , 类型: java.lang.String
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 变量数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,VARIABLES, java.lang.String.class, "变量数据", "变量数据", java.lang.String.class, null);
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,CREATE_BY, java.lang.String.class, "create_by", "create_by", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,UPDATE_BY, java.lang.String.class, "update_by", "update_by", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,DELETE_BY, java.lang.String.class, "delete_by", "delete_by", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,TENANT_ID, java.lang.String.class, "tenant_id", "tenant_id", java.lang.String.class, null);
	
	/**
	 * CAM结果 , Camunda返回的结果 , 类型: java.lang.String
	*/
	public static final String CAMUNDA_RESULT="camundaResult";
	
	/**
	 * CAM结果 , Camunda返回的结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.String> CAMUNDA_RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,CAMUNDA_RESULT, java.lang.String.class, "CAM结果", "Camunda返回的结果", java.lang.String.class, null);
	
	/**
	 * CAM成功 , Camunda处理是否成功 , 类型: java.lang.Integer
	*/
	public static final String CAMUNDA_SUCCESS="camundaSuccess";
	
	/**
	 * CAM成功 , Camunda处理是否成功 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,java.lang.Integer> CAMUNDA_SUCCESS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,CAMUNDA_SUCCESS, java.lang.Integer.class, "CAM成功", "Camunda处理是否成功", java.lang.Integer.class, null);
	
	/**
	 * 审批人身份 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final String APPROVER="approver";
	
	/**
	 * 审批人身份 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,org.github.foxnic.web.domain.bpm.Assignee> APPROVER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVER, org.github.foxnic.web.domain.bpm.Assignee.class, "审批人身份", "审批人身份", org.github.foxnic.web.domain.bpm.Assignee.class, null);
	
	/**
	 * 审批人账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String APPROVAL_USER="approvalUser";
	
	/**
	 * 审批人账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskApprovalVO,org.github.foxnic.web.domain.oauth.User> APPROVAL_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskApprovalVO.class ,APPROVAL_USER, org.github.foxnic.web.domain.oauth.User.class, "审批人账户", "审批人账户", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TASK_ID , PROCESS_INSTANCE_ID , APPROVAL_USER_ID , APPROVAL_TIME , APPROVAL_RESULT , APPROVAL_COMMENT , ASSIGNEE_TYPE , ASSIGNEE_ID , VARIABLES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CAMUNDA_RESULT , CAMUNDA_SUCCESS , APPROVER , APPROVAL_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.TaskApprovalVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public TaskApprovalVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public TaskApprovalVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public TaskApprovalVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public TaskApprovalVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public TaskApprovalVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public TaskApprovalVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public TaskApprovalVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public TaskApprovalVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public TaskApprovalVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public TaskApproval setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务ID
		 * @param taskId 任务ID
		 * @return 当前对象
		*/
		public TaskApproval setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public TaskApproval setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 审批人账户ID
		 * @param approvalUserId 审批人账户ID
		 * @return 当前对象
		*/
		public TaskApproval setApprovalUserId(String approvalUserId) {
			super.change(APPROVAL_USER_ID,super.getApprovalUserId(),approvalUserId);
			super.setApprovalUserId(approvalUserId);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param approvalTime 处理时间
		 * @return 当前对象
		*/
		public TaskApproval setApprovalTime(Date approvalTime) {
			super.change(APPROVAL_TIME,super.getApprovalTime(),approvalTime);
			super.setApprovalTime(approvalTime);
			return this;
		}
		
		/**
		 * 设置 审批结果
		 * @param approvalResult 审批结果
		 * @return 当前对象
		*/
		public TaskApproval setApprovalResult(String approvalResult) {
			super.change(APPROVAL_RESULT,super.getApprovalResult(),approvalResult);
			super.setApprovalResult(approvalResult);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalComment 审批意见
		 * @return 当前对象
		*/
		public TaskApproval setApprovalComment(String approvalComment) {
			super.change(APPROVAL_COMMENT,super.getApprovalComment(),approvalComment);
			super.setApprovalComment(approvalComment);
			return this;
		}
		
		/**
		 * 设置 审批人类型
		 * @param assigneeType 审批人类型
		 * @return 当前对象
		*/
		public TaskApproval setAssigneeType(String assigneeType) {
			super.change(ASSIGNEE_TYPE,super.getAssigneeType(),assigneeType);
			super.setAssigneeType(assigneeType);
			return this;
		}
		
		/**
		 * 设置 审批人ID
		 * @param assigneeId 审批人ID
		 * @return 当前对象
		*/
		public TaskApproval setAssigneeId(String assigneeId) {
			super.change(ASSIGNEE_ID,super.getAssigneeId(),assigneeId);
			super.setAssigneeId(assigneeId);
			return this;
		}
		
		/**
		 * 设置 变量数据
		 * @param variables 变量数据
		 * @return 当前对象
		*/
		public TaskApproval setVariables(String variables) {
			super.change(VARIABLES,super.getVariables(),variables);
			super.setVariables(variables);
			return this;
		}
		
		/**
		 * 设置 create_by
		 * @param createBy create_by
		 * @return 当前对象
		*/
		public TaskApproval setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public TaskApproval setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 update_by
		 * @param updateBy update_by
		 * @return 当前对象
		*/
		public TaskApproval setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public TaskApproval setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public TaskApproval setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 delete_by
		 * @param deleteBy delete_by
		 * @return 当前对象
		*/
		public TaskApproval setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public TaskApproval setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public TaskApproval setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant_id
		 * @param tenantId tenant_id
		 * @return 当前对象
		*/
		public TaskApproval setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 CAM结果
		 * @param camundaResult CAM结果
		 * @return 当前对象
		*/
		public TaskApproval setCamundaResult(String camundaResult) {
			super.change(CAMUNDA_RESULT,super.getCamundaResult(),camundaResult);
			super.setCamundaResult(camundaResult);
			return this;
		}
		
		/**
		 * 设置 CAM成功
		 * @param camundaSuccess CAM成功
		 * @return 当前对象
		*/
		public TaskApproval setCamundaSuccess(Integer camundaSuccess) {
			super.change(CAMUNDA_SUCCESS,super.getCamundaSuccess(),camundaSuccess);
			super.setCamundaSuccess(camundaSuccess);
			return this;
		}
		
		/**
		 * 设置 审批人身份
		 * @param approver 审批人身份
		 * @return 当前对象
		*/
		public TaskApproval setApprover(Assignee approver) {
			super.change(APPROVER,super.getApprover(),approver);
			super.setApprover(approver);
			return this;
		}
		
		/**
		 * 设置 审批人账户
		 * @param approvalUser 审批人账户
		 * @return 当前对象
		*/
		public TaskApproval setApprovalUser(User approvalUser) {
			super.change(APPROVAL_USER,super.getApprovalUser(),approvalUser);
			super.setApprovalUser(approvalUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public TaskApprovalVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public TaskApprovalVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setVariables(this.getVariables());
			inst.setCamundaSuccess(this.getCamundaSuccess());
			inst.setApprovalTime(this.getApprovalTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setAssigneeId(this.getAssigneeId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setApprovalResult(this.getApprovalResult());
			inst.setApprovalComment(this.getApprovalComment());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setCamundaResult(this.getCamundaResult());
			inst.setId(this.getId());
			inst.setApprovalUserId(this.getApprovalUserId());
			inst.setAssigneeType(this.getAssigneeType());
			inst.setTaskId(this.getTaskId());
			if(all) {
				inst.setApprover(this.getApprover());
				inst.setSearchField(this.getSearchField());
				inst.setApprovalUser(this.getApprovalUser());
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