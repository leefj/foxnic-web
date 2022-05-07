package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.TaskVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.Task;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.oauth.User;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-07 13:57:07
 * @sign 4A14B4C5D7918A4E9CA4AE65A58E6E5D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TaskVOMeta extends TaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,NODE_ID, java.lang.String.class, "节点ID", "节点ID", java.lang.String.class, null);
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 节点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> NODE_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,NODE_NAME, java.lang.String.class, "节点名称", "节点名称", java.lang.String.class, null);
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final String PROCESS_INSTANCE_ID="processInstanceId";
	
	/**
	 * 流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> PROCESS_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PROCESS_INSTANCE_ID, java.lang.String.class, "流程实例ID", "流程实例ID", java.lang.String.class, null);
	
	/**
	 * 审批人账户ID , 实际的审批人 , 类型: java.lang.String
	*/
	public static final String APPROVER_USER_ID="approverUserId";
	
	/**
	 * 审批人账户ID , 实际的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVER_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER_USER_ID, java.lang.String.class, "审批人账户ID", "实际的审批人", java.lang.String.class, null);
	
	/**
	 * 审批人账户类型 , 实际的审批人类型 , 类型: java.lang.String
	*/
	public static final String APPROVER_TYPE="approverType";
	
	/**
	 * 审批人账户类型 , 实际的审批人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER_TYPE, java.lang.String.class, "审批人账户类型", "实际的审批人类型", java.lang.String.class, null);
	
	/**
	 * 审批人身份ID , 实际的审批人身份 , 类型: java.lang.String
	*/
	public static final String APPROVER_ID="approverId";
	
	/**
	 * 审批人身份ID , 实际的审批人身份 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER_ID, java.lang.String.class, "审批人身份ID", "实际的审批人身份", java.lang.String.class, null);
	
	/**
	 * 审批人账户ID , 预计的审批人 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_ID="assigneeId";
	
	/**
	 * 审批人账户ID , 预计的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> ASSIGNEE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,ASSIGNEE_ID, java.lang.String.class, "审批人账户ID", "预计的审批人", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String APPROVAL_TIME="approvalTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.util.Date> APPROVAL_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVAL_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final String APPROVAL_RESULT="approvalResult";
	
	/**
	 * 审批结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVAL_RESULT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVAL_RESULT, java.lang.String.class, "审批结果", "审批结果", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_COMMENT="approvalComment";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVAL_COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVAL_COMMENT, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 变量数据 , 类型: java.lang.String
	*/
	public static final String VARIABLES="variables";
	
	/**
	 * 变量数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> VARIABLES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,VARIABLES, java.lang.String.class, "变量数据", "变量数据", java.lang.String.class, null);
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_TASK_ID="camundaTaskId";
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> CAMUNDA_TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,CAMUNDA_TASK_ID, java.lang.String.class, "任务ID", "Camunda 任务ID", java.lang.String.class, null);
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * create_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,CREATE_BY, java.lang.String.class, "create_by", "create_by", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * update_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,UPDATE_BY, java.lang.String.class, "update_by", "update_by", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * delete_by , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,DELETE_BY, java.lang.String.class, "delete_by", "delete_by", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant_id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,TENANT_ID, java.lang.String.class, "tenant_id", "tenant_id", java.lang.String.class, null);
	
	/**
	 * 流程类型 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final String PROCESS_DEFINITION="processDefinition";
	
	/**
	 * 流程类型 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.ProcessDefinition> PROCESS_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PROCESS_DEFINITION, org.github.foxnic.web.domain.bpm.ProcessDefinition.class, "流程类型", "流程类型", org.github.foxnic.web.domain.bpm.ProcessDefinition.class, null);
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String PROCESS_INSTANCE="processInstance";
	
	/**
	 * 流程实例 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.ProcessInstance> PROCESS_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,PROCESS_INSTANCE, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "流程实例", "流程实例", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 审批人身份 , 审批人身份，实际审批人 , 类型: org.github.foxnic.web.domain.bpm.Appover
	*/
	public static final String APPROVER="approver";
	
	/**
	 * 审批人身份 , 审批人身份，实际审批人 , 类型: org.github.foxnic.web.domain.bpm.Appover
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.Appover> APPROVER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER, org.github.foxnic.web.domain.bpm.Appover.class, "审批人身份", "审批人身份，实际审批人", org.github.foxnic.web.domain.bpm.Appover.class, null);
	
	/**
	 * 审批人名称 , 审批人名称，实际审批人 , 类型: java.lang.String
	*/
	public static final String APPROVER_NAME="approverName";
	
	/**
	 * 审批人名称 , 审批人名称，实际审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER_NAME, java.lang.String.class, "审批人名称", "审批人名称，实际审批人", java.lang.String.class, null);
	
	/**
	 * 审批人账户 , 审批人账户，实际审批人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String APPROVER_USER="approverUser";
	
	/**
	 * 审批人账户 , 审批人账户，实际审批人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.oauth.User> APPROVER_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVER_USER, org.github.foxnic.web.domain.oauth.User.class, "审批人账户", "审批人账户，实际审批人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 代理人账户 , 代理人账户，预计审批人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String ASSIGNEE_USER="assigneeUser";
	
	/**
	 * 代理人账户 , 代理人账户，预计审批人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.oauth.User> ASSIGNEE_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,ASSIGNEE_USER, org.github.foxnic.web.domain.oauth.User.class, "代理人账户", "代理人账户，预计审批人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PROCESS_DEFINITION_ID , NODE_ID , NODE_NAME , PROCESS_INSTANCE_ID , APPROVER_USER_ID , APPROVER_TYPE , APPROVER_ID , ASSIGNEE_ID , STATUS , APPROVAL_TIME , APPROVAL_RESULT , APPROVAL_COMMENT , VARIABLES , CAMUNDA_TASK_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PROCESS_DEFINITION , PROCESS_INSTANCE , APPROVER , APPROVER_NAME , APPROVER_USER , ASSIGNEE_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.TaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public TaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public TaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public TaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public TaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public TaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public TaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public TaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public TaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public TaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public Task setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public Task setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 节点ID
		 * @param nodeId 节点ID
		 * @return 当前对象
		*/
		public Task setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 节点名称
		 * @param nodeName 节点名称
		 * @return 当前对象
		*/
		public Task setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 流程实例ID
		 * @param processInstanceId 流程实例ID
		 * @return 当前对象
		*/
		public Task setProcessInstanceId(String processInstanceId) {
			super.change(PROCESS_INSTANCE_ID,super.getProcessInstanceId(),processInstanceId);
			super.setProcessInstanceId(processInstanceId);
			return this;
		}
		
		/**
		 * 设置 审批人账户ID
		 * @param approverUserId 审批人账户ID
		 * @return 当前对象
		*/
		public Task setApproverUserId(String approverUserId) {
			super.change(APPROVER_USER_ID,super.getApproverUserId(),approverUserId);
			super.setApproverUserId(approverUserId);
			return this;
		}
		
		/**
		 * 设置 审批人账户类型
		 * @param approverType 审批人账户类型
		 * @return 当前对象
		*/
		public Task setApproverType(String approverType) {
			super.change(APPROVER_TYPE,super.getApproverType(),approverType);
			super.setApproverType(approverType);
			return this;
		}
		
		/**
		 * 设置 审批人身份ID
		 * @param approverId 审批人身份ID
		 * @return 当前对象
		*/
		public Task setApproverId(String approverId) {
			super.change(APPROVER_ID,super.getApproverId(),approverId);
			super.setApproverId(approverId);
			return this;
		}
		
		/**
		 * 设置 审批人账户ID
		 * @param assigneeId 审批人账户ID
		 * @return 当前对象
		*/
		public Task setAssigneeId(String assigneeId) {
			super.change(ASSIGNEE_ID,super.getAssigneeId(),assigneeId);
			super.setAssigneeId(assigneeId);
			return this;
		}
		
		/**
		 * 设置 任务状态
		 * @param status 任务状态
		 * @return 当前对象
		*/
		public Task setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param approvalTime 处理时间
		 * @return 当前对象
		*/
		public Task setApprovalTime(Date approvalTime) {
			super.change(APPROVAL_TIME,super.getApprovalTime(),approvalTime);
			super.setApprovalTime(approvalTime);
			return this;
		}
		
		/**
		 * 设置 审批结果
		 * @param approvalResult 审批结果
		 * @return 当前对象
		*/
		public Task setApprovalResult(String approvalResult) {
			super.change(APPROVAL_RESULT,super.getApprovalResult(),approvalResult);
			super.setApprovalResult(approvalResult);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalComment 审批意见
		 * @return 当前对象
		*/
		public Task setApprovalComment(String approvalComment) {
			super.change(APPROVAL_COMMENT,super.getApprovalComment(),approvalComment);
			super.setApprovalComment(approvalComment);
			return this;
		}
		
		/**
		 * 设置 变量数据
		 * @param variables 变量数据
		 * @return 当前对象
		*/
		public Task setVariables(String variables) {
			super.change(VARIABLES,super.getVariables(),variables);
			super.setVariables(variables);
			return this;
		}
		
		/**
		 * 设置 任务ID
		 * @param camundaTaskId 任务ID
		 * @return 当前对象
		*/
		public Task setCamundaTaskId(String camundaTaskId) {
			super.change(CAMUNDA_TASK_ID,super.getCamundaTaskId(),camundaTaskId);
			super.setCamundaTaskId(camundaTaskId);
			return this;
		}
		
		/**
		 * 设置 create_by
		 * @param createBy create_by
		 * @return 当前对象
		*/
		public Task setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Task setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 update_by
		 * @param updateBy update_by
		 * @return 当前对象
		*/
		public Task setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Task setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Task setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 delete_by
		 * @param deleteBy delete_by
		 * @return 当前对象
		*/
		public Task setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Task setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Task setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant_id
		 * @param tenantId tenant_id
		 * @return 当前对象
		*/
		public Task setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程类型
		 * @param processDefinition 流程类型
		 * @return 当前对象
		*/
		public Task setProcessDefinition(ProcessDefinition processDefinition) {
			super.change(PROCESS_DEFINITION,super.getProcessDefinition(),processDefinition);
			super.setProcessDefinition(processDefinition);
			return this;
		}
		
		/**
		 * 设置 流程实例
		 * @param processInstance 流程实例
		 * @return 当前对象
		*/
		public Task setProcessInstance(ProcessInstance processInstance) {
			super.change(PROCESS_INSTANCE,super.getProcessInstance(),processInstance);
			super.setProcessInstance(processInstance);
			return this;
		}
		
		/**
		 * 设置 审批人身份
		 * @param approver 审批人身份
		 * @return 当前对象
		*/
		public Task setApprover(Appover approver) {
			super.change(APPROVER,super.getApprover(),approver);
			super.setApprover(approver);
			return this;
		}
		
		/**
		 * 设置 审批人名称
		 * @param approverName 审批人名称
		 * @return 当前对象
		*/
		public Task setApproverName(String approverName) {
			super.change(APPROVER_NAME,super.getApproverName(),approverName);
			super.setApproverName(approverName);
			return this;
		}
		
		/**
		 * 设置 审批人账户
		 * @param approverUser 审批人账户
		 * @return 当前对象
		*/
		public Task setApproverUser(User approverUser) {
			super.change(APPROVER_USER,super.getApproverUser(),approverUser);
			super.setApproverUser(approverUser);
			return this;
		}
		
		/**
		 * 设置 代理人账户
		 * @param assigneeUser 代理人账户
		 * @return 当前对象
		*/
		public Task setAssigneeUser(User assigneeUser) {
			super.change(ASSIGNEE_USER,super.getAssigneeUser(),assigneeUser);
			super.setAssigneeUser(assigneeUser);
			return this;
		}
	}
}