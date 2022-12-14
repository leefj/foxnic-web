package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ChangeInstanceVO;
import java.util.List;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import java.util.Date;
import org.github.foxnic.web.domain.changes.ChangeData;
import org.github.foxnic.web.domain.changes.ChangeDefinition;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.changes.ChangeApprover;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-28 13:39:20
 * @sign 938B86AB6939C7C39E123ACD9DA94EEF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ChangeInstanceVOMeta extends ChangeInstanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 流程分类 , 类型: java.lang.String
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 流程分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CATALOG, java.lang.String.class, "流程分类", "流程分类", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 变更定义ID , 类型: java.lang.String
	*/
	public static final String DEFINITION_ID="definitionId";
	
	/**
	 * 变更定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DEFINITION_ID, java.lang.String.class, "变更定义ID", "变更定义ID", java.lang.String.class, null);
	
	/**
	 * 审批模式 , 类型: java.lang.String
	*/
	public static final String MODE="mode";
	
	/**
	 * 审批模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> MODE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,MODE, java.lang.String.class, "审批模式", "审批模式", java.lang.String.class, null);
	
	/**
	 * 起草人ID , 员工ID , 类型: java.lang.String
	*/
	public static final String DRAFTER_ID="drafterId";
	
	/**
	 * 起草人ID , 员工ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> DRAFTER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DRAFTER_ID, java.lang.String.class, "起草人ID", "员工ID", java.lang.String.class, null);
	
	/**
	 * 起草人姓名 , 类型: java.lang.String
	*/
	public static final String DRAFTER_NAME="drafterName";
	
	/**
	 * 起草人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> DRAFTER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DRAFTER_NAME, java.lang.String.class, "起草人姓名", "起草人姓名", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final String PROCESS_ID="processId";
	
	/**
	 * 流程ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> PROCESS_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,PROCESS_ID, java.lang.String.class, "流程ID", "流程ID", java.lang.String.class, null);
	
	/**
	 * 当前审批节点 , 对于当前审批节点的描述性信息 , 类型: java.lang.String
	*/
	public static final String PROCESS_NODE_SUMMARY="processNodeSummary";
	
	/**
	 * 当前审批节点 , 对于当前审批节点的描述性信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> PROCESS_NODE_SUMMARY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,PROCESS_NODE_SUMMARY, java.lang.String.class, "当前审批节点", "对于当前审批节点的描述性信息", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 针对流程审批的概要描述 , 类型: java.lang.String
	*/
	public static final String PROCESS_SUMMARY="processSummary";
	
	/**
	 * 流程概要 , 针对流程审批的概要描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> PROCESS_SUMMARY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,PROCESS_SUMMARY, java.lang.String.class, "流程概要", "针对流程审批的概要描述", java.lang.String.class, null);
	
	/**
	 * 变更开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 变更开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.util.Date> START_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,START_TIME, java.util.Date.class, "变更开始时间", "变更开始时间", java.util.Date.class, null);
	
	/**
	 * 变更结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 变更结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.util.Date> FINISH_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,FINISH_TIME, java.util.Date.class, "变更结束时间", "变更结束时间", java.util.Date.class, null);
	
	/**
	 * 默认审批人信息JSONArray格式 , 适用于简单审批模式 , 类型: java.lang.String
	*/
	public static final String SIMPLE_APPROVERS="simpleApprovers";
	
	/**
	 * 默认审批人信息JSONArray格式 , 适用于简单审批模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SIMPLE_APPROVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SIMPLE_APPROVERS, java.lang.String.class, "默认审批人信息JSONArray格式", "适用于简单审批模式", java.lang.String.class, null);
	
	/**
	 * 简单模式的节点ID , 类型: java.lang.String
	*/
	public static final String SIMPLE_NODE_ID="simpleNodeId";
	
	/**
	 * 简单模式的节点ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,java.lang.String> SIMPLE_NODE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,SIMPLE_NODE_ID, java.lang.String.class, "简单模式的节点ID", "简单模式的节点ID", java.lang.String.class, null);
	
	/**
	 * 变更前的数据 , 类型: org.github.foxnic.web.domain.changes.ChangeData
	*/
	public static final String DATA_BEFORE="dataBefore";
	
	/**
	 * 变更前的数据 , 类型: org.github.foxnic.web.domain.changes.ChangeData
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.changes.ChangeData> DATA_BEFORE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DATA_BEFORE, org.github.foxnic.web.domain.changes.ChangeData.class, "变更前的数据", "变更前的数据", org.github.foxnic.web.domain.changes.ChangeData.class, null);
	
	/**
	 * 变更后的数据 , 类型: org.github.foxnic.web.domain.changes.ChangeData
	*/
	public static final String DATA_AFTER="dataAfter";
	
	/**
	 * 变更后的数据 , 类型: org.github.foxnic.web.domain.changes.ChangeData
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.changes.ChangeData> DATA_AFTER_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DATA_AFTER, org.github.foxnic.web.domain.changes.ChangeData.class, "变更后的数据", "变更后的数据", org.github.foxnic.web.domain.changes.ChangeData.class, null);
	
	/**
	 * 流程定义对象 , 流程定义 , 类型: org.github.foxnic.web.domain.changes.ChangeDefinition
	*/
	public static final String DEFINITION="definition";
	
	/**
	 * 流程定义对象 , 流程定义 , 类型: org.github.foxnic.web.domain.changes.ChangeDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.changes.ChangeDefinition> DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,DEFINITION, org.github.foxnic.web.domain.changes.ChangeDefinition.class, "流程定义对象", "流程定义", org.github.foxnic.web.domain.changes.ChangeDefinition.class, null);
	
	/**
	 * 当前可审批员工清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String CURR_EMPLOYEE_APPROVERS="currEmployeeApprovers";
	
	/**
	 * 当前可审批员工清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.hrm.Employee> CURR_EMPLOYEE_APPROVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CURR_EMPLOYEE_APPROVERS, java.util.List.class, "当前可审批员工清单", "", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 当前可审批流程角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String CURR_BUSI_ROLE_APPROVERS="currBusiRoleApprovers";
	
	/**
	 * 当前可审批流程角色清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.system.BusiRole> CURR_BUSI_ROLE_APPROVERS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CURR_BUSI_ROLE_APPROVERS, java.util.List.class, "当前可审批流程角色清单", "", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 当前可审批员工ID清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ChangeApprover
	*/
	public static final String CURR_EMPLOYEE_APPROVER_IDS="currEmployeeApproverIds";
	
	/**
	 * 当前可审批员工ID清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ChangeApprover
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.changes.ChangeApprover> CURR_EMPLOYEE_APPROVER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CURR_EMPLOYEE_APPROVER_IDS, java.util.List.class, "当前可审批员工ID清单", "", org.github.foxnic.web.domain.changes.ChangeApprover.class, null);
	
	/**
	 * 当前可审批流程角色ID清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ChangeApprover
	*/
	public static final String CURR_BUSI_ROLE_APPROVER_IDS="currBusiRoleApproverIds";
	
	/**
	 * 当前可审批流程角色ID清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.changes.ChangeApprover
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ChangeInstanceVO,org.github.foxnic.web.domain.changes.ChangeApprover> CURR_BUSI_ROLE_APPROVER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ChangeInstanceVO.class ,CURR_BUSI_ROLE_APPROVER_IDS, java.util.List.class, "当前可审批流程角色ID清单", "", org.github.foxnic.web.domain.changes.ChangeApprover.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , CATALOG , ID , DEFINITION_ID , MODE , DRAFTER_ID , DRAFTER_NAME , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , STATUS , TYPE , PROCESS_ID , PROCESS_NODE_SUMMARY , PROCESS_SUMMARY , START_TIME , FINISH_TIME , SIMPLE_APPROVERS , SIMPLE_NODE_ID , DATA_BEFORE , DATA_AFTER , DEFINITION , CURR_EMPLOYEE_APPROVERS , CURR_BUSI_ROLE_APPROVERS , CURR_EMPLOYEE_APPROVER_IDS , CURR_BUSI_ROLE_APPROVER_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ChangeInstanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ChangeInstanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ChangeInstanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ChangeInstanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ChangeInstanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ChangeInstanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ChangeInstanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ChangeInstanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ChangeInstanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ChangeInstanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 流程分类
		 * @param catalog 流程分类
		 * @return 当前对象
		*/
		public ChangeInstanceVO setCatalog(String catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ChangeInstance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 变更定义ID
		 * @param definitionId 变更定义ID
		 * @return 当前对象
		*/
		public ChangeInstance setDefinitionId(String definitionId) {
			super.change(DEFINITION_ID,super.getDefinitionId(),definitionId);
			super.setDefinitionId(definitionId);
			return this;
		}
		
		/**
		 * 设置 审批模式
		 * @param mode 审批模式
		 * @return 当前对象
		*/
		public ChangeInstance setMode(String mode) {
			super.change(MODE,super.getMode(),mode);
			super.setMode(mode);
			return this;
		}
		
		/**
		 * 设置 起草人ID
		 * @param drafterId 起草人ID
		 * @return 当前对象
		*/
		public ChangeInstance setDrafterId(String drafterId) {
			super.change(DRAFTER_ID,super.getDrafterId(),drafterId);
			super.setDrafterId(drafterId);
			return this;
		}
		
		/**
		 * 设置 起草人姓名
		 * @param drafterName 起草人姓名
		 * @return 当前对象
		*/
		public ChangeInstance setDrafterName(String drafterName) {
			super.change(DRAFTER_NAME,super.getDrafterName(),drafterName);
			super.setDrafterName(drafterName);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ChangeInstance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ChangeInstance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ChangeInstance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ChangeInstance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ChangeInstance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ChangeInstance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ChangeInstance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ChangeInstance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ChangeInstance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param status 变更状态
		 * @return 当前对象
		*/
		public ChangeInstance setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param type 变更类型
		 * @return 当前对象
		*/
		public ChangeInstance setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param processId 流程ID
		 * @return 当前对象
		*/
		public ChangeInstance setProcessId(String processId) {
			super.change(PROCESS_ID,super.getProcessId(),processId);
			super.setProcessId(processId);
			return this;
		}
		
		/**
		 * 设置 当前审批节点
		 * @param processNodeSummary 当前审批节点
		 * @return 当前对象
		*/
		public ChangeInstance setProcessNodeSummary(String processNodeSummary) {
			super.change(PROCESS_NODE_SUMMARY,super.getProcessNodeSummary(),processNodeSummary);
			super.setProcessNodeSummary(processNodeSummary);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param processSummary 流程概要
		 * @return 当前对象
		*/
		public ChangeInstance setProcessSummary(String processSummary) {
			super.change(PROCESS_SUMMARY,super.getProcessSummary(),processSummary);
			super.setProcessSummary(processSummary);
			return this;
		}
		
		/**
		 * 设置 变更开始时间
		 * @param startTime 变更开始时间
		 * @return 当前对象
		*/
		public ChangeInstance setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 变更结束时间
		 * @param finishTime 变更结束时间
		 * @return 当前对象
		*/
		public ChangeInstance setFinishTime(Date finishTime) {
			super.change(FINISH_TIME,super.getFinishTime(),finishTime);
			super.setFinishTime(finishTime);
			return this;
		}
		
		/**
		 * 设置 默认审批人信息JSONArray格式
		 * @param simpleApprovers 默认审批人信息JSONArray格式
		 * @return 当前对象
		*/
		public ChangeInstance setSimpleApprovers(String simpleApprovers) {
			super.change(SIMPLE_APPROVERS,super.getSimpleApprovers(),simpleApprovers);
			super.setSimpleApprovers(simpleApprovers);
			return this;
		}
		
		/**
		 * 设置 简单模式的节点ID
		 * @param simpleNodeId 简单模式的节点ID
		 * @return 当前对象
		*/
		public ChangeInstance setSimpleNodeId(String simpleNodeId) {
			super.change(SIMPLE_NODE_ID,super.getSimpleNodeId(),simpleNodeId);
			super.setSimpleNodeId(simpleNodeId);
			return this;
		}
		
		/**
		 * 设置 变更前的数据
		 * @param dataBefore 变更前的数据
		 * @return 当前对象
		*/
		public ChangeInstance setDataBefore(ChangeData dataBefore) {
			super.change(DATA_BEFORE,super.getDataBefore(),dataBefore);
			super.setDataBefore(dataBefore);
			return this;
		}
		
		/**
		 * 设置 变更后的数据
		 * @param dataAfter 变更后的数据
		 * @return 当前对象
		*/
		public ChangeInstance setDataAfter(ChangeData dataAfter) {
			super.change(DATA_AFTER,super.getDataAfter(),dataAfter);
			super.setDataAfter(dataAfter);
			return this;
		}
		
		/**
		 * 设置 流程定义对象
		 * @param definition 流程定义对象
		 * @return 当前对象
		*/
		public ChangeInstance setDefinition(ChangeDefinition definition) {
			super.change(DEFINITION,super.getDefinition(),definition);
			super.setDefinition(definition);
			return this;
		}
		
		/**
		 * 设置 当前可审批员工清单
		 * @param currEmployeeApprovers 当前可审批员工清单
		 * @return 当前对象
		*/
		public ChangeInstance setCurrEmployeeApprovers(List<Employee> currEmployeeApprovers) {
			super.change(CURR_EMPLOYEE_APPROVERS,super.getCurrEmployeeApprovers(),currEmployeeApprovers);
			super.setCurrEmployeeApprovers(currEmployeeApprovers);
			return this;
		}
		
		/**
		 * 设置 当前可审批流程角色清单
		 * @param currBusiRoleApprovers 当前可审批流程角色清单
		 * @return 当前对象
		*/
		public ChangeInstance setCurrBusiRoleApprovers(List<BusiRole> currBusiRoleApprovers) {
			super.change(CURR_BUSI_ROLE_APPROVERS,super.getCurrBusiRoleApprovers(),currBusiRoleApprovers);
			super.setCurrBusiRoleApprovers(currBusiRoleApprovers);
			return this;
		}
		
		/**
		 * 设置 当前可审批员工ID清单
		 * @param currEmployeeApproverIds 当前可审批员工ID清单
		 * @return 当前对象
		*/
		public ChangeInstance setCurrEmployeeApproverIds(List<ChangeApprover> currEmployeeApproverIds) {
			super.change(CURR_EMPLOYEE_APPROVER_IDS,super.getCurrEmployeeApproverIds(),currEmployeeApproverIds);
			super.setCurrEmployeeApproverIds(currEmployeeApproverIds);
			return this;
		}
		
		/**
		 * 设置 当前可审批流程角色ID清单
		 * @param currBusiRoleApproverIds 当前可审批流程角色ID清单
		 * @return 当前对象
		*/
		public ChangeInstance setCurrBusiRoleApproverIds(List<ChangeApprover> currBusiRoleApproverIds) {
			super.change(CURR_BUSI_ROLE_APPROVER_IDS,super.getCurrBusiRoleApproverIds(),currBusiRoleApproverIds);
			super.setCurrBusiRoleApproverIds(currBusiRoleApproverIds);
			return this;
		}
	}
}