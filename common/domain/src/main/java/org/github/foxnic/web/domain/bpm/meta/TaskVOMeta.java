package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.TaskVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.Task;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.bpm.TaskApproval;
import org.github.foxnic.web.domain.bpm.TaskAssignee;
import org.github.foxnic.web.domain.bpm.TaskAssigneeUser;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionNode;
import org.github.foxnic.web.domain.bpm.TaskRead;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-28 06:40:58
 * @sign 9C08F2D3A184586F6943BB88C37495D3
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
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 处理人账户ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String APPROVAL_USER_IDS="approvalUserIds";
	
	/**
	 * 处理人账户ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> APPROVAL_USER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVAL_USER_IDS, java.util.List.class, "处理人账户ID清单", "处理人账户ID清单", java.lang.String.class, null);
	
	/**
	 * 是否我的任务 , 类型: java.lang.Boolean
	*/
	public static final String MINE="mine";
	
	/**
	 * 是否我的任务 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.Boolean> MINE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,MINE, java.lang.Boolean.class, "是否我的任务", "是否我的任务", java.lang.Boolean.class, null);
	
	/**
	 * 状态值清单 , 设定状态值的查询范围 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String STATUS_RANGE="statusRange";
	
	/**
	 * 状态值清单 , 设定状态值的查询范围 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> STATUS_RANGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,STATUS_RANGE, java.util.List.class, "状态值清单", "设定状态值的查询范围", java.lang.String.class, null);
	
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
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 原因 , 状态变更的原因 , 类型: java.lang.String
	*/
	public static final String STATUS_REASON="statusReason";
	
	/**
	 * 原因 , 状态变更的原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> STATUS_REASON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,STATUS_REASON, java.lang.String.class, "原因", "状态变更的原因", java.lang.String.class, null);
	
	/**
	 * 最后处理时间 , 类型: java.util.Date
	*/
	public static final String APPROVAL_TIME="approvalTime";
	
	/**
	 * 最后处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.util.Date> APPROVAL_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVAL_TIME, java.util.Date.class, "最后处理时间", "最后处理时间", java.util.Date.class, null);
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_TASK_ID="camundaTaskId";
	
	/**
	 * 任务ID , Camunda 任务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> CAMUNDA_TASK_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,CAMUNDA_TASK_ID, java.lang.String.class, "任务ID", "Camunda 任务ID", java.lang.String.class, null);
	
	/**
	 * cam中指定的审批人 , 类型: java.lang.String
	*/
	public static final String CAMUNDA_ASSIGNEE="camundaAssignee";
	
	/**
	 * cam中指定的审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,java.lang.String> CAMUNDA_ASSIGNEE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,CAMUNDA_ASSIGNEE, java.lang.String.class, "cam中指定的审批人", "cam中指定的审批人", java.lang.String.class, null);
	
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
	 * 审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final String APPROVALS="approvals";
	
	/**
	 * 审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.TaskApproval> APPROVALS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,APPROVALS, java.util.List.class, "审批动作清单", "审批动作清单", org.github.foxnic.web.domain.bpm.TaskApproval.class, null);
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssignee
	*/
	public static final String ASSIGNEES="assignees";
	
	/**
	 * 审批人清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.TaskAssignee> ASSIGNEES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,ASSIGNEES, java.util.List.class, "审批人清单", "审批人清单", org.github.foxnic.web.domain.bpm.TaskAssignee.class, null);
	
	/**
	 * 审批人账户清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssigneeUser
	*/
	public static final String ASSIGNEE_USERS="assigneeUsers";
	
	/**
	 * 审批人账户清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskAssigneeUser
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.TaskAssigneeUser> ASSIGNEE_USERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,ASSIGNEE_USERS, java.util.List.class, "审批人账户清单", "审批人账户清单", org.github.foxnic.web.domain.bpm.TaskAssigneeUser.class, null);
	
	/**
	 * 流程节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final String NODE="node";
	
	/**
	 * 流程节点 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionNode
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.ProcessDefinitionNode> NODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,NODE, org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, "流程节点", "流程节点", org.github.foxnic.web.domain.bpm.ProcessDefinitionNode.class, null);
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final String READERS="readers";
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.TaskVO,org.github.foxnic.web.domain.bpm.TaskRead> READERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.TaskVO.class ,READERS, java.util.List.class, "已读清单", "已读人员清单", org.github.foxnic.web.domain.bpm.TaskRead.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , APPROVAL_USER_IDS , MINE , STATUS_RANGE , ID , PROCESS_DEFINITION_ID , NODE_ID , NODE_NAME , PROCESS_INSTANCE_ID , STATUS , STATUS_REASON , APPROVAL_TIME , CAMUNDA_TASK_ID , CAMUNDA_ASSIGNEE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PROCESS_DEFINITION , PROCESS_INSTANCE , APPROVALS , ASSIGNEES , ASSIGNEE_USERS , NODE , READERS };
	
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
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public TaskVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public TaskVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public TaskVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
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
		 * 设置 处理人账户ID清单
		 * @param approvalUserIds 处理人账户ID清单
		 * @return 当前对象
		*/
		public TaskVO setApprovalUserIds(List<String> approvalUserIds) {
			super.change(APPROVAL_USER_IDS,super.getApprovalUserIds(),approvalUserIds);
			super.setApprovalUserIds(approvalUserIds);
			return this;
		}
		
		/**
		 * 设置 是否我的任务
		 * @param mine 是否我的任务
		 * @return 当前对象
		*/
		public TaskVO setMine(Boolean mine) {
			super.change(MINE,super.isMine(),mine);
			super.setMine(mine);
			return this;
		}
		
		/**
		 * 设置 状态值清单
		 * @param statusRange 状态值清单
		 * @return 当前对象
		*/
		public TaskVO setStatusRange(List<String> statusRange) {
			super.change(STATUS_RANGE,super.getStatusRange(),statusRange);
			super.setStatusRange(statusRange);
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
		 * 设置 原因
		 * @param statusReason 原因
		 * @return 当前对象
		*/
		public Task setStatusReason(String statusReason) {
			super.change(STATUS_REASON,super.getStatusReason(),statusReason);
			super.setStatusReason(statusReason);
			return this;
		}
		
		/**
		 * 设置 最后处理时间
		 * @param approvalTime 最后处理时间
		 * @return 当前对象
		*/
		public Task setApprovalTime(Date approvalTime) {
			super.change(APPROVAL_TIME,super.getApprovalTime(),approvalTime);
			super.setApprovalTime(approvalTime);
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
		 * 设置 cam中指定的审批人
		 * @param camundaAssignee cam中指定的审批人
		 * @return 当前对象
		*/
		public Task setCamundaAssignee(String camundaAssignee) {
			super.change(CAMUNDA_ASSIGNEE,super.getCamundaAssignee(),camundaAssignee);
			super.setCamundaAssignee(camundaAssignee);
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
		 * 设置 审批动作清单
		 * @param approvals 审批动作清单
		 * @return 当前对象
		*/
		public Task setApprovals(List<TaskApproval> approvals) {
			super.change(APPROVALS,super.getApprovals(),approvals);
			super.setApprovals(approvals);
			return this;
		}
		
		/**
		 * 设置 审批人清单
		 * @param assignees 审批人清单
		 * @return 当前对象
		*/
		public Task setAssignees(List<TaskAssignee> assignees) {
			super.change(ASSIGNEES,super.getAssignees(),assignees);
			super.setAssignees(assignees);
			return this;
		}
		
		/**
		 * 设置 审批人账户清单
		 * @param assigneeUsers 审批人账户清单
		 * @return 当前对象
		*/
		public Task setAssigneeUsers(List<TaskAssigneeUser> assigneeUsers) {
			super.change(ASSIGNEE_USERS,super.getAssigneeUsers(),assigneeUsers);
			super.setAssigneeUsers(assigneeUsers);
			return this;
		}
		
		/**
		 * 设置 流程节点
		 * @param node 流程节点
		 * @return 当前对象
		*/
		public Task setNode(ProcessDefinitionNode node) {
			super.change(NODE,super.getNode(),node);
			super.setNode(node);
			return this;
		}
		
		/**
		 * 设置 已读清单
		 * @param readers 已读清单
		 * @return 当前对象
		*/
		public Task setReaders(List<TaskRead> readers) {
			super.change(READERS,super.getReaders(),readers);
			super.setReaders(readers);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public TaskVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public TaskVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNodeName(this.getNodeName());
			inst.setProcessDefinitionId(this.getProcessDefinitionId());
			inst.setProcessInstanceId(this.getProcessInstanceId());
			inst.setApprovalTime(this.getApprovalTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCamundaTaskId(this.getCamundaTaskId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setStatusReason(this.getStatusReason());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setCamundaAssignee(this.getCamundaAssignee());
			inst.setNodeId(this.getNodeId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setMine(this.isMine());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setProcessDefinition(this.getProcessDefinition());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setProcessInstance(this.getProcessInstance());
				inst.setPageSize(this.getPageSize());
				inst.setAssignees(this.getAssignees());
				inst.setStatusRange(this.getStatusRange());
				inst.setNode(this.getNode());
				inst.setAssigneeUsers(this.getAssigneeUsers());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setReaders(this.getReaders());
				inst.setApprovalUserIds(this.getApprovalUserIds());
				inst.setApprovals(this.getApprovals());
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