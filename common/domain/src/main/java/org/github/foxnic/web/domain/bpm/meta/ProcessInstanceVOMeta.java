package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessInstanceVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.FormInstance;
import org.github.foxnic.web.domain.bpm.Assignee;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.bpm.Task;
import org.github.foxnic.web.domain.bpm.FormInstanceBill;
import org.github.foxnic.web.domain.bpm.ProcessError;
import org.github.foxnic.web.domain.bpm.TaskRead;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.TaskApproval;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-04 15:56:25
 * @sign 99EF60040ABA6FDEABA02D0468A47EF5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessInstanceVOMeta extends ProcessInstanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 已审批人ID清单 , 查询已审批人ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String APPROVED_USER_IDS="approvedUserIds";
	
	/**
	 * 已审批人ID清单 , 查询已审批人ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> APPROVED_USER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,APPROVED_USER_IDS, java.util.List.class, "已审批人ID清单", "查询已审批人ID清单", java.lang.String.class, null);
	
	/**
	 * 待审批人ID清单 , 查询待审批人ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String APPROVING_USER_IDS="approvingUserIds";
	
	/**
	 * 待审批人ID清单 , 查询待审批人ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> APPROVING_USER_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,APPROVING_USER_IDS, java.util.List.class, "待审批人ID清单", "查询待审批人ID清单", java.lang.String.class, null);
	
	/**
	 * 是否我的流程 , 类型: java.lang.Boolean
	*/
	public static final String MINE="mine";
	
	/**
	 * 是否我的流程 , 类型: java.lang.Boolean
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Boolean> MINE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,MINE, java.lang.Boolean.class, "是否我的流程", "是否我的流程", java.lang.Boolean.class, null);
	
	/**
	 * 流程审批分类 , 类型: java.lang.String
	*/
	public static final String APPROVAL_CATALOG="approvalCatalog";
	
	/**
	 * 流程审批分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> APPROVAL_CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,APPROVAL_CATALOG, java.lang.String.class, "流程审批分类", "流程审批分类", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 起草人账户ID , 类型: java.lang.String
	*/
	public static final String DRAFTER_USER_ID="drafterUserId";
	
	/**
	 * 起草人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DRAFTER_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER_USER_ID, java.lang.String.class, "起草人账户ID", "起草人账户ID", java.lang.String.class, null);
	
	/**
	 * 起草人ID , 可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID , 类型: java.lang.String
	*/
	public static final String DRAFTER_ID="drafterId";
	
	/**
	 * 起草人ID , 可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DRAFTER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER_ID, java.lang.String.class, "起草人ID", "可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID", java.lang.String.class, null);
	
	/**
	 * 起草人类型 , 类型: java.lang.String
	*/
	public static final String DRAFTER_TYPE="drafterType";
	
	/**
	 * 起草人类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DRAFTER_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER_TYPE, java.lang.String.class, "起草人类型", "起草人类型", java.lang.String.class, null);
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final String FORM_INSTANCE_ID="formInstanceId";
	
	/**
	 * 表单实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> FORM_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,FORM_INSTANCE_ID, java.lang.String.class, "表单实例ID", "表单实例ID", java.lang.String.class, null);
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_ID="processDefinitionId";
	
	/**
	 * 流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> PROCESS_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PROCESS_DEFINITION_ID, java.lang.String.class, "流程定义ID", "流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程定义文件ID , 类型: java.lang.String
	*/
	public static final String PROCESS_DEFINITION_FILE_ID="processDefinitionFileId";
	
	/**
	 * 流程定义文件ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> PROCESS_DEFINITION_FILE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PROCESS_DEFINITION_FILE_ID, java.lang.String.class, "流程定义文件ID", "流程定义文件ID", java.lang.String.class, null);
	
	/**
	 * 表单定义ID , 类型: java.lang.String
	*/
	public static final String FORM_DEFINITION_ID="formDefinitionId";
	
	/**
	 * 表单定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> FORM_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,FORM_DEFINITION_ID, java.lang.String.class, "表单定义ID", "表单定义ID", java.lang.String.class, null);
	
	/**
	 * 流程标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 流程标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> TITLE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,TITLE, java.lang.String.class, "流程标题", "流程标题", java.lang.String.class, null);
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final String PRIORITY="priority";
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> PRIORITY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PRIORITY, java.lang.String.class, "紧急程度", "紧急程度", java.lang.String.class, null);
	
	/**
	 * 流程说明 , 类型: java.lang.String
	*/
	public static final String COMMENT="comment";
	
	/**
	 * 流程说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,COMMENT, java.lang.String.class, "流程说明", "流程说明", java.lang.String.class, null);
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final String APPROVAL_STATUS="approvalStatus";
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> APPROVAL_STATUS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,APPROVAL_STATUS, java.lang.String.class, "审批状态", "审批状态", java.lang.String.class, null);
	
	/**
	 * camunda流程实例ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_INSTANCE_ID="camundaInstanceId";
	
	/**
	 * camunda流程实例ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> CAMUNDA_INSTANCE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,CAMUNDA_INSTANCE_ID, java.lang.String.class, "camunda流程实例ID", "camunda流程实例ID", java.lang.String.class, null);
	
	/**
	 * 提交时间 , 类型: java.util.Date
	*/
	public static final String COMMIT_TIME="commitTime";
	
	/**
	 * 提交时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> COMMIT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,COMMIT_TIME, java.util.Date.class, "提交时间", "提交时间", java.util.Date.class, null);
	
	/**
	 * 废弃人账户ID , 类型: java.lang.String
	*/
	public static final String ABANDON_USER_ID="abandonUserId";
	
	/**
	 * 废弃人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> ABANDON_USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,ABANDON_USER_ID, java.lang.String.class, "废弃人账户ID", "废弃人账户ID", java.lang.String.class, null);
	
	/**
	 * 流程废弃时间 , 类型: java.util.Date
	*/
	public static final String ABANDON_TIME="abandonTime";
	
	/**
	 * 流程废弃时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> ABANDON_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,ABANDON_TIME, java.util.Date.class, "流程废弃时间", "流程废弃时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 流程完成时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 流程完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,END_TIME, java.util.Date.class, "流程完成时间", "流程完成时间", java.util.Date.class, null);
	
	/**
	 * 是否需要同步 , 类型: java.lang.Integer
	*/
	public static final String NEED_SYNC="needSync";
	
	/**
	 * 是否需要同步 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.Integer> NEED_SYNC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,NEED_SYNC, java.lang.Integer.class, "是否需要同步", "是否需要同步", java.lang.Integer.class, null);
	
	/**
	 * 状态同步时间 , 类型: java.util.Date
	*/
	public static final String SYNC_TIME="syncTime";
	
	/**
	 * 状态同步时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.util.Date> SYNC_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,SYNC_TIME, java.util.Date.class, "状态同步时间", "状态同步时间", java.util.Date.class, null);
	
	/**
	 * 流程定义 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final String PROCESS_DEFINITION="processDefinition";
	
	/**
	 * 流程定义 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.ProcessDefinition> PROCESS_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PROCESS_DEFINITION, org.github.foxnic.web.domain.bpm.ProcessDefinition.class, "流程定义", "流程定义", org.github.foxnic.web.domain.bpm.ProcessDefinition.class, null);
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final String FORM_DEFINITION="formDefinition";
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.FormDefinition> FORM_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,FORM_DEFINITION, org.github.foxnic.web.domain.bpm.FormDefinition.class, "表单定义", "表单定义", org.github.foxnic.web.domain.bpm.FormDefinition.class, null);
	
	/**
	 * 表单实例 , 类型: org.github.foxnic.web.domain.bpm.FormInstance
	*/
	public static final String FORM_INSTANCE="formInstance";
	
	/**
	 * 表单实例 , 类型: org.github.foxnic.web.domain.bpm.FormInstance
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.FormInstance> FORM_INSTANCE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,FORM_INSTANCE, org.github.foxnic.web.domain.bpm.FormInstance.class, "表单实例", "表单实例", org.github.foxnic.web.domain.bpm.FormInstance.class, null);
	
	/**
	 * 起草人身份 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final String DRAFTER="drafter";
	
	/**
	 * 起草人身份 , 类型: org.github.foxnic.web.domain.bpm.Assignee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.Assignee> DRAFTER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER, org.github.foxnic.web.domain.bpm.Assignee.class, "起草人身份", "起草人身份", org.github.foxnic.web.domain.bpm.Assignee.class, null);
	
	/**
	 * 起草人名称 , 类型: java.lang.String
	*/
	public static final String DRAFTER_NAME="drafterName";
	
	/**
	 * 起草人名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> DRAFTER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER_NAME, java.lang.String.class, "起草人名称", "起草人名称", java.lang.String.class, null);
	
	/**
	 * 起草人账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String DRAFTER_USER="drafterUser";
	
	/**
	 * 起草人账户 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.oauth.User> DRAFTER_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,DRAFTER_USER, org.github.foxnic.web.domain.oauth.User.class, "起草人账户", "起草人账户", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 流程任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final String TASKS="tasks";
	
	/**
	 * 流程任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.Task> TASKS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,TASKS, java.util.List.class, "流程任务清单", "流程任务清单", org.github.foxnic.web.domain.bpm.Task.class, null);
	
	/**
	 * 待办的流程任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final String TODO_TASKS="todoTasks";
	
	/**
	 * 待办的流程任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.Task> TODO_TASKS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,TODO_TASKS, java.util.List.class, "待办的流程任务清单", "待办的流程任务清单", org.github.foxnic.web.domain.bpm.Task.class, null);
	
	/**
	 * 可处理的任务清单 , 当前登录账户可以处理的任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final String USER_TASKS="userTasks";
	
	/**
	 * 可处理的任务清单 , 当前登录账户可以处理的任务清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.Task
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.Task> USER_TASKS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,USER_TASKS, java.util.List.class, "可处理的任务清单", "当前登录账户可以处理的任务清单", org.github.foxnic.web.domain.bpm.Task.class, null);
	
	/**
	 * 业务单据 , 关联的业务单据清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.FormInstanceBill
	*/
	public static final String BILLS="bills";
	
	/**
	 * 业务单据 , 关联的业务单据清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.FormInstanceBill
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.FormInstanceBill> BILLS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,BILLS, java.util.List.class, "业务单据", "关联的业务单据清单", org.github.foxnic.web.domain.bpm.FormInstanceBill.class, null);
	
	/**
	 * 业务单据ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String BILL_IDS="billIds";
	
	/**
	 * 业务单据ID清单 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> BILL_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,BILL_IDS, java.util.List.class, "业务单据ID清单", "业务单据ID清单", java.lang.String.class, null);
	
	/**
	 * 流程异常清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessError
	*/
	public static final String ERRORS="errors";
	
	/**
	 * 流程异常清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessError
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.ProcessError> ERRORS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,ERRORS, java.util.List.class, "流程异常清单", "流程异常清单", org.github.foxnic.web.domain.bpm.ProcessError.class, null);
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final String READERS="readers";
	
	/**
	 * 已读清单 , 已读人员清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskRead
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.TaskRead> READERS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,READERS, java.util.List.class, "已读清单", "已读人员清单", org.github.foxnic.web.domain.bpm.TaskRead.class, null);
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final String APPROVAL_STATUS_NAME="approvalStatusName";
	
	/**
	 * 审批状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,java.lang.String> APPROVAL_STATUS_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,APPROVAL_STATUS_NAME, java.lang.String.class, "审批状态", "审批状态", java.lang.String.class, null);
	
	/**
	 * 流程定义文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final String PROCESS_DEFINITION_FILE="processDefinitionFile";
	
	/**
	 * 流程定义文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.ProcessDefinitionFile> PROCESS_DEFINITION_FILE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,PROCESS_DEFINITION_FILE, org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, "流程定义文件", "流程定义文件", org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, null);
	
	/**
	 * 审批动作清单 , 已完成的审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final String TASK_APPROVALS="taskApprovals";
	
	/**
	 * 审批动作清单 , 已完成的审批动作清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.TaskApproval
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessInstanceVO,org.github.foxnic.web.domain.bpm.TaskApproval> TASK_APPROVALS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessInstanceVO.class ,TASK_APPROVALS, java.util.List.class, "审批动作清单", "已完成的审批动作清单", org.github.foxnic.web.domain.bpm.TaskApproval.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , APPROVED_USER_IDS , APPROVING_USER_IDS , MINE , APPROVAL_CATALOG , ID , DRAFTER_USER_ID , DRAFTER_ID , DRAFTER_TYPE , FORM_INSTANCE_ID , PROCESS_DEFINITION_ID , PROCESS_DEFINITION_FILE_ID , FORM_DEFINITION_ID , TITLE , PRIORITY , COMMENT , APPROVAL_STATUS , CAMUNDA_INSTANCE_ID , COMMIT_TIME , ABANDON_USER_ID , ABANDON_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , END_TIME , NEED_SYNC , SYNC_TIME , PROCESS_DEFINITION , FORM_DEFINITION , FORM_INSTANCE , DRAFTER , DRAFTER_NAME , DRAFTER_USER , TASKS , TODO_TASKS , USER_TASKS , BILLS , BILL_IDS , ERRORS , READERS , APPROVAL_STATUS_NAME , PROCESS_DEFINITION_FILE , TASK_APPROVALS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessInstanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProcessInstanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProcessInstanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProcessInstanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProcessInstanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProcessInstanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProcessInstanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProcessInstanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProcessInstanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProcessInstanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 已审批人ID清单
		 * @param approvedUserIds 已审批人ID清单
		 * @return 当前对象
		*/
		public ProcessInstanceVO setApprovedUserIds(List<String> approvedUserIds) {
			super.change(APPROVED_USER_IDS,super.getApprovedUserIds(),approvedUserIds);
			super.setApprovedUserIds(approvedUserIds);
			return this;
		}
		
		/**
		 * 设置 待审批人ID清单
		 * @param approvingUserIds 待审批人ID清单
		 * @return 当前对象
		*/
		public ProcessInstanceVO setApprovingUserIds(List<String> approvingUserIds) {
			super.change(APPROVING_USER_IDS,super.getApprovingUserIds(),approvingUserIds);
			super.setApprovingUserIds(approvingUserIds);
			return this;
		}
		
		/**
		 * 设置 是否我的流程
		 * @param mine 是否我的流程
		 * @return 当前对象
		*/
		public ProcessInstanceVO setMine(Boolean mine) {
			super.change(MINE,super.isMine(),mine);
			super.setMine(mine);
			return this;
		}
		
		/**
		 * 设置 流程审批分类
		 * @param approvalCatalog 流程审批分类
		 * @return 当前对象
		*/
		public ProcessInstanceVO setApprovalCatalog(String approvalCatalog) {
			super.change(APPROVAL_CATALOG,super.getApprovalCatalog(),approvalCatalog);
			super.setApprovalCatalog(approvalCatalog);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ProcessInstance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 起草人账户ID
		 * @param drafterUserId 起草人账户ID
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterUserId(String drafterUserId) {
			super.change(DRAFTER_USER_ID,super.getDrafterUserId(),drafterUserId);
			super.setDrafterUserId(drafterUserId);
			return this;
		}
		
		/**
		 * 设置 起草人ID
		 * @param drafterId 起草人ID
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterId(String drafterId) {
			super.change(DRAFTER_ID,super.getDrafterId(),drafterId);
			super.setDrafterId(drafterId);
			return this;
		}
		
		/**
		 * 设置 起草人类型
		 * @param drafterType 起草人类型
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterType(String drafterType) {
			super.change(DRAFTER_TYPE,super.getDrafterType(),drafterType);
			super.setDrafterType(drafterType);
			return this;
		}
		
		/**
		 * 设置 表单实例ID
		 * @param formInstanceId 表单实例ID
		 * @return 当前对象
		*/
		public ProcessInstance setFormInstanceId(String formInstanceId) {
			super.change(FORM_INSTANCE_ID,super.getFormInstanceId(),formInstanceId);
			super.setFormInstanceId(formInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程定义ID
		 * @param processDefinitionId 流程定义ID
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinitionId(String processDefinitionId) {
			super.change(PROCESS_DEFINITION_ID,super.getProcessDefinitionId(),processDefinitionId);
			super.setProcessDefinitionId(processDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程定义文件ID
		 * @param processDefinitionFileId 流程定义文件ID
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinitionFileId(String processDefinitionFileId) {
			super.change(PROCESS_DEFINITION_FILE_ID,super.getProcessDefinitionFileId(),processDefinitionFileId);
			super.setProcessDefinitionFileId(processDefinitionFileId);
			return this;
		}
		
		/**
		 * 设置 表单定义ID
		 * @param formDefinitionId 表单定义ID
		 * @return 当前对象
		*/
		public ProcessInstance setFormDefinitionId(String formDefinitionId) {
			super.change(FORM_DEFINITION_ID,super.getFormDefinitionId(),formDefinitionId);
			super.setFormDefinitionId(formDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程标题
		 * @param title 流程标题
		 * @return 当前对象
		*/
		public ProcessInstance setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 紧急程度
		 * @param priority 紧急程度
		 * @return 当前对象
		*/
		public ProcessInstance setPriority(String priority) {
			super.change(PRIORITY,super.getPriority(),priority);
			super.setPriority(priority);
			return this;
		}
		
		/**
		 * 设置 流程说明
		 * @param comment 流程说明
		 * @return 当前对象
		*/
		public ProcessInstance setComment(String comment) {
			super.change(COMMENT,super.getComment(),comment);
			super.setComment(comment);
			return this;
		}
		
		/**
		 * 设置 审批状态
		 * @param approvalStatus 审批状态
		 * @return 当前对象
		*/
		public ProcessInstance setApprovalStatus(String approvalStatus) {
			super.change(APPROVAL_STATUS,super.getApprovalStatus(),approvalStatus);
			super.setApprovalStatus(approvalStatus);
			return this;
		}
		
		/**
		 * 设置 camunda流程实例ID
		 * @param camundaInstanceId camunda流程实例ID
		 * @return 当前对象
		*/
		public ProcessInstance setCamundaInstanceId(String camundaInstanceId) {
			super.change(CAMUNDA_INSTANCE_ID,super.getCamundaInstanceId(),camundaInstanceId);
			super.setCamundaInstanceId(camundaInstanceId);
			return this;
		}
		
		/**
		 * 设置 提交时间
		 * @param commitTime 提交时间
		 * @return 当前对象
		*/
		public ProcessInstance setCommitTime(Date commitTime) {
			super.change(COMMIT_TIME,super.getCommitTime(),commitTime);
			super.setCommitTime(commitTime);
			return this;
		}
		
		/**
		 * 设置 废弃人账户ID
		 * @param abandonUserId 废弃人账户ID
		 * @return 当前对象
		*/
		public ProcessInstance setAbandonUserId(String abandonUserId) {
			super.change(ABANDON_USER_ID,super.getAbandonUserId(),abandonUserId);
			super.setAbandonUserId(abandonUserId);
			return this;
		}
		
		/**
		 * 设置 流程废弃时间
		 * @param abandonTime 流程废弃时间
		 * @return 当前对象
		*/
		public ProcessInstance setAbandonTime(Date abandonTime) {
			super.change(ABANDON_TIME,super.getAbandonTime(),abandonTime);
			super.setAbandonTime(abandonTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessInstance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessInstance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessInstance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessInstance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessInstance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessInstance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessInstance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessInstance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessInstance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程完成时间
		 * @param endTime 流程完成时间
		 * @return 当前对象
		*/
		public ProcessInstance setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 是否需要同步
		 * @param needSync 是否需要同步
		 * @return 当前对象
		*/
		public ProcessInstance setNeedSync(Integer needSync) {
			super.change(NEED_SYNC,super.getNeedSync(),needSync);
			super.setNeedSync(needSync);
			return this;
		}
		
		/**
		 * 设置 状态同步时间
		 * @param syncTime 状态同步时间
		 * @return 当前对象
		*/
		public ProcessInstance setSyncTime(Date syncTime) {
			super.change(SYNC_TIME,super.getSyncTime(),syncTime);
			super.setSyncTime(syncTime);
			return this;
		}
		
		/**
		 * 设置 流程定义
		 * @param processDefinition 流程定义
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinition(ProcessDefinition processDefinition) {
			super.change(PROCESS_DEFINITION,super.getProcessDefinition(),processDefinition);
			super.setProcessDefinition(processDefinition);
			return this;
		}
		
		/**
		 * 设置 表单定义
		 * @param formDefinition 表单定义
		 * @return 当前对象
		*/
		public ProcessInstance setFormDefinition(FormDefinition formDefinition) {
			super.change(FORM_DEFINITION,super.getFormDefinition(),formDefinition);
			super.setFormDefinition(formDefinition);
			return this;
		}
		
		/**
		 * 设置 表单实例
		 * @param formInstance 表单实例
		 * @return 当前对象
		*/
		public ProcessInstance setFormInstance(FormInstance formInstance) {
			super.change(FORM_INSTANCE,super.getFormInstance(),formInstance);
			super.setFormInstance(formInstance);
			return this;
		}
		
		/**
		 * 设置 起草人身份
		 * @param drafter 起草人身份
		 * @return 当前对象
		*/
		public ProcessInstance setDrafter(Assignee drafter) {
			super.change(DRAFTER,super.getDrafter(),drafter);
			super.setDrafter(drafter);
			return this;
		}
		
		/**
		 * 设置 起草人名称
		 * @param drafterName 起草人名称
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterName(String drafterName) {
			super.change(DRAFTER_NAME,super.getDrafterName(),drafterName);
			super.setDrafterName(drafterName);
			return this;
		}
		
		/**
		 * 设置 起草人账户
		 * @param drafterUser 起草人账户
		 * @return 当前对象
		*/
		public ProcessInstance setDrafterUser(User drafterUser) {
			super.change(DRAFTER_USER,super.getDrafterUser(),drafterUser);
			super.setDrafterUser(drafterUser);
			return this;
		}
		
		/**
		 * 设置 流程任务清单
		 * @param tasks 流程任务清单
		 * @return 当前对象
		*/
		public ProcessInstance setTasks(List<Task> tasks) {
			super.change(TASKS,super.getTasks(),tasks);
			super.setTasks(tasks);
			return this;
		}
		
		/**
		 * 设置 待办的流程任务清单
		 * @param todoTasks 待办的流程任务清单
		 * @return 当前对象
		*/
		public ProcessInstance setTodoTasks(List<Task> todoTasks) {
			super.change(TODO_TASKS,super.getTodoTasks(),todoTasks);
			super.setTodoTasks(todoTasks);
			return this;
		}
		
		/**
		 * 设置 可处理的任务清单
		 * @param userTasks 可处理的任务清单
		 * @return 当前对象
		*/
		public ProcessInstance setUserTasks(List<Task> userTasks) {
			super.change(USER_TASKS,super.getUserTasks(),userTasks);
			super.setUserTasks(userTasks);
			return this;
		}
		
		/**
		 * 设置 业务单据
		 * @param bills 业务单据
		 * @return 当前对象
		*/
		public ProcessInstance setBills(List<FormInstanceBill> bills) {
			super.change(BILLS,super.getBills(),bills);
			super.setBills(bills);
			return this;
		}
		
		/**
		 * 设置 业务单据ID清单
		 * @param billIds 业务单据ID清单
		 * @return 当前对象
		*/
		public ProcessInstance setBillIds(List<String> billIds) {
			super.change(BILL_IDS,super.getBillIds(),billIds);
			super.setBillIds(billIds);
			return this;
		}
		
		/**
		 * 设置 流程异常清单
		 * @param errors 流程异常清单
		 * @return 当前对象
		*/
		public ProcessInstance setErrors(List<ProcessError> errors) {
			super.change(ERRORS,super.getErrors(),errors);
			super.setErrors(errors);
			return this;
		}
		
		/**
		 * 设置 已读清单
		 * @param readers 已读清单
		 * @return 当前对象
		*/
		public ProcessInstance setReaders(List<TaskRead> readers) {
			super.change(READERS,super.getReaders(),readers);
			super.setReaders(readers);
			return this;
		}
		
		/**
		 * 设置 审批状态
		 * @param approvalStatusName 审批状态
		 * @return 当前对象
		*/
		public ProcessInstance setApprovalStatusName(String approvalStatusName) {
			super.change(APPROVAL_STATUS_NAME,super.getApprovalStatusName(),approvalStatusName);
			super.setApprovalStatusName(approvalStatusName);
			return this;
		}
		
		/**
		 * 设置 流程定义文件
		 * @param processDefinitionFile 流程定义文件
		 * @return 当前对象
		*/
		public ProcessInstance setProcessDefinitionFile(ProcessDefinitionFile processDefinitionFile) {
			super.change(PROCESS_DEFINITION_FILE,super.getProcessDefinitionFile(),processDefinitionFile);
			super.setProcessDefinitionFile(processDefinitionFile);
			return this;
		}
		
		/**
		 * 设置 审批动作清单
		 * @param taskApprovals 审批动作清单
		 * @return 当前对象
		*/
		public ProcessInstance setTaskApprovals(List<TaskApproval> taskApprovals) {
			super.change(TASK_APPROVALS,super.getTaskApprovals(),taskApprovals);
			super.setTaskApprovals(taskApprovals);
			return this;
		}
	}
}