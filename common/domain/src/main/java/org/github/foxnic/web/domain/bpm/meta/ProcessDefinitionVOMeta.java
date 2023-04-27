package org.github.foxnic.web.domain.bpm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionVO;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessDefinition;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.domain.bpm.ProcessDefinitionFile;
import org.github.foxnic.web.domain.bpm.FormDefinition;
import org.github.foxnic.web.domain.bpm.Catalog;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-27 11:51:22
 * @sign F1102AEA99CE04092FD9D852373AA545
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProcessDefinitionVOMeta extends ProcessDefinitionMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 表单定义代码 , 类型: java.lang.String
	*/
	public static final String FORM_DEFINITION_CODE="formDefinitionCode";
	
	/**
	 * 表单定义代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> FORM_DEFINITION_CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,FORM_DEFINITION_CODE, java.lang.String.class, "表单定义代码", "表单定义代码", java.lang.String.class, null);
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 流程代码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 流程代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CODE, java.lang.String.class, "流程代码", "流程代码", java.lang.String.class, null);
	
	/**
	 * 关联表单 , 表单定义ID , 类型: java.lang.String
	*/
	public static final String FORM_DEFINITION_ID="formDefinitionId";
	
	/**
	 * 关联表单 , 表单定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> FORM_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,FORM_DEFINITION_ID, java.lang.String.class, "关联表单", "表单定义ID", java.lang.String.class, null);
	
	/**
	 * 驳回配置 , 流程在驳回时的表现 , 类型: java.lang.String
	*/
	public static final String REJECT_OPTION="rejectOption";
	
	/**
	 * 驳回配置 , 流程在驳回时的表现 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> REJECT_OPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,REJECT_OPTION, java.lang.String.class, "驳回配置", "流程在驳回时的表现", java.lang.String.class, null);
	
	/**
	 * 审批人身份范围 , 审批人身份类型的范围 , 类型: java.lang.String
	*/
	public static final String ASSIGNEE_TYPE_RANGE="assigneeTypeRange";
	
	/**
	 * 审批人身份范围 , 审批人身份类型的范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> ASSIGNEE_TYPE_RANGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ASSIGNEE_TYPE_RANGE, java.lang.String.class, "审批人身份范围", "审批人身份类型的范围", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 生效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,VALID, java.lang.Integer.class, "生效", "生效", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 流程ID , 在 camunda 中的流程定义ID , 类型: java.lang.String
	*/
	public static final String CAMUNDA_DEFINITION_ID="camundaDefinitionId";
	
	/**
	 * 流程ID , 在 camunda 中的流程定义ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> CAMUNDA_DEFINITION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CAMUNDA_DEFINITION_ID, java.lang.String.class, "流程ID", "在 camunda 中的流程定义ID", java.lang.String.class, null);
	
	/**
	 * 流程Key , 在 camunda 中的流程定义KEY , 类型: java.lang.String
	*/
	public static final String CAMUNDA_DEFINITION_KEY="camundaDefinitionKey";
	
	/**
	 * 流程Key , 在 camunda 中的流程定义KEY , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> CAMUNDA_DEFINITION_KEY_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CAMUNDA_DEFINITION_KEY, java.lang.String.class, "流程Key", "在 camunda 中的流程定义KEY", java.lang.String.class, null);
	
	/**
	 * PC端图标 , 类型: java.lang.String
	*/
	public static final String ICON_FILE_PC="iconFilePc";
	
	/**
	 * PC端图标 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> ICON_FILE_PC_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ICON_FILE_PC, java.lang.String.class, "PC端图标", "PC端图标", java.lang.String.class, null);
	
	/**
	 * 移动端图标 , 类型: java.lang.String
	*/
	public static final String ICON_FILE_MOBILE="iconFileMobile";
	
	/**
	 * 移动端图标 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> ICON_FILE_MOBILE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ICON_FILE_MOBILE, java.lang.String.class, "移动端图标", "移动端图标", java.lang.String.class, null);
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 序号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> SORT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,SORT, java.lang.Integer.class, "序号", "序号", java.lang.Integer.class, null);
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final String CATALOG_ID="catalogId";
	
	/**
	 * 分类ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> CATALOG_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CATALOG_ID, java.lang.String.class, "分类ID", "分类ID", java.lang.String.class, null);
	
	/**
	 * 是否允许撤回 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_FETCH_BACK="allowFetchBack";
	
	/**
	 * 是否允许撤回 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_FETCH_BACK_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_FETCH_BACK, java.lang.Integer.class, "是否允许撤回", "是否允许撤回", java.lang.Integer.class, null);
	
	/**
	 * 是否允许有条件同意 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_AGREE_WITH_CONDITION="allowAgreeWithCondition";
	
	/**
	 * 是否允许有条件同意 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_AGREE_WITH_CONDITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_AGREE_WITH_CONDITION, java.lang.Integer.class, "是否允许有条件同意", "是否允许有条件同意", java.lang.Integer.class, null);
	
	/**
	 * 是否允许驳回 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_REJECT="allowReject";
	
	/**
	 * 是否允许驳回 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_REJECT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_REJECT, java.lang.Integer.class, "是否允许驳回", "是否允许驳回", java.lang.Integer.class, null);
	
	/**
	 * 是否允许跳过 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_SKIP="allowSkip";
	
	/**
	 * 是否允许跳过 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_SKIP_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_SKIP, java.lang.Integer.class, "是否允许跳过", "是否允许跳过", java.lang.Integer.class, null);
	
	/**
	 * 是否允许废弃 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_ABANDON="allowAbandon";
	
	/**
	 * 是否允许废弃 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_ABANDON_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_ABANDON, java.lang.Integer.class, "是否允许废弃", "是否允许废弃", java.lang.Integer.class, null);
	
	/**
	 * 是否允许起草意见 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_DRAFTING_COMMENT="allowDraftingComment";
	
	/**
	 * 是否允许起草意见 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_DRAFTING_COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_DRAFTING_COMMENT, java.lang.Integer.class, "是否允许起草意见", "是否允许起草意见", java.lang.Integer.class, null);
	
	/**
	 * 是否允许审批意见 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_APPROVE_COMMENT="allowApproveComment";
	
	/**
	 * 是否允许审批意见 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_APPROVE_COMMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_APPROVE_COMMENT, java.lang.Integer.class, "是否允许审批意见", "是否允许审批意见", java.lang.Integer.class, null);
	
	/**
	 * 是否允许起草附件 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_DRAFTING_ATTACHMENT="allowDraftingAttachment";
	
	/**
	 * 是否允许起草附件 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_DRAFTING_ATTACHMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_DRAFTING_ATTACHMENT, java.lang.Integer.class, "是否允许起草附件", "是否允许起草附件", java.lang.Integer.class, null);
	
	/**
	 * 是否允许审批附件 , 类型: java.lang.Integer
	*/
	public static final String ALLOW_APPROVE_ATTACHMENT="allowApproveAttachment";
	
	/**
	 * 是否允许审批附件 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.Integer> ALLOW_APPROVE_ATTACHMENT_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,ALLOW_APPROVE_ATTACHMENT, java.lang.Integer.class, "是否允许审批附件", "是否允许审批附件", java.lang.Integer.class, null);
	
	/**
	 * 起草人范围 , 类型: java.lang.String
	*/
	public static final String DRAFTER_RANGE="drafterRange";
	
	/**
	 * 起草人范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,java.lang.String> DRAFTER_RANGE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DRAFTER_RANGE, java.lang.String.class, "起草人范围", "起草人范围", java.lang.String.class, null);
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final String LAST_UPDATE_USER="lastUpdateUser";
	
	/**
	 * 最后修改人 , 类型: org.github.foxnic.web.domain.oauth.User
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,org.github.foxnic.web.domain.oauth.User> LAST_UPDATE_USER_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,LAST_UPDATE_USER, org.github.foxnic.web.domain.oauth.User.class, "最后修改人", "最后修改人", org.github.foxnic.web.domain.oauth.User.class, null);
	
	/**
	 * 流程模型定义 , 流程模型文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final String DEFINITION_FILE="definitionFile";
	
	/**
	 * 流程模型定义 , 流程模型文件 , 类型: org.github.foxnic.web.domain.bpm.ProcessDefinitionFile
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,org.github.foxnic.web.domain.bpm.ProcessDefinitionFile> DEFINITION_FILE_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,DEFINITION_FILE, org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, "流程模型定义", "流程模型文件", org.github.foxnic.web.domain.bpm.ProcessDefinitionFile.class, null);
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final String FORM_DEFINITION="formDefinition";
	
	/**
	 * 表单定义 , 类型: org.github.foxnic.web.domain.bpm.FormDefinition
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,org.github.foxnic.web.domain.bpm.FormDefinition> FORM_DEFINITION_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,FORM_DEFINITION, org.github.foxnic.web.domain.bpm.FormDefinition.class, "表单定义", "表单定义", org.github.foxnic.web.domain.bpm.FormDefinition.class, null);
	
	/**
	 * 分类对象 , 类型: org.github.foxnic.web.domain.bpm.Catalog
	*/
	public static final String CATALOG="catalog";
	
	/**
	 * 分类对象 , 类型: org.github.foxnic.web.domain.bpm.Catalog
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.bpm.ProcessDefinitionVO,org.github.foxnic.web.domain.bpm.Catalog> CATALOG_PROP = new BeanProperty(org.github.foxnic.web.domain.bpm.ProcessDefinitionVO.class ,CATALOG, org.github.foxnic.web.domain.bpm.Catalog.class, "分类对象", "分类对象", org.github.foxnic.web.domain.bpm.Catalog.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , FORM_DEFINITION_CODE , ID , CODE , FORM_DEFINITION_ID , REJECT_OPTION , ASSIGNEE_TYPE_RANGE , NAME , VALID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CAMUNDA_DEFINITION_ID , CAMUNDA_DEFINITION_KEY , ICON_FILE_PC , ICON_FILE_MOBILE , SORT , CATALOG_ID , ALLOW_FETCH_BACK , ALLOW_AGREE_WITH_CONDITION , ALLOW_REJECT , ALLOW_SKIP , ALLOW_ABANDON , ALLOW_DRAFTING_COMMENT , ALLOW_APPROVE_COMMENT , ALLOW_DRAFTING_ATTACHMENT , ALLOW_APPROVE_ATTACHMENT , DRAFTER_RANGE , LAST_UPDATE_USER , DEFINITION_FILE , FORM_DEFINITION , CATALOG };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.bpm.ProcessDefinitionVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 表单定义代码
		 * @param formDefinitionCode 表单定义代码
		 * @return 当前对象
		*/
		public ProcessDefinitionVO setFormDefinitionCode(String formDefinitionCode) {
			super.change(FORM_DEFINITION_CODE,super.getFormDefinitionCode(),formDefinitionCode);
			super.setFormDefinitionCode(formDefinitionCode);
			return this;
		}
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public ProcessDefinition setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程代码
		 * @param code 流程代码
		 * @return 当前对象
		*/
		public ProcessDefinition setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 关联表单
		 * @param formDefinitionId 关联表单
		 * @return 当前对象
		*/
		public ProcessDefinition setFormDefinitionId(String formDefinitionId) {
			super.change(FORM_DEFINITION_ID,super.getFormDefinitionId(),formDefinitionId);
			super.setFormDefinitionId(formDefinitionId);
			return this;
		}
		
		/**
		 * 设置 驳回配置
		 * @param rejectOption 驳回配置
		 * @return 当前对象
		*/
		public ProcessDefinition setRejectOption(String rejectOption) {
			super.change(REJECT_OPTION,super.getRejectOption(),rejectOption);
			super.setRejectOption(rejectOption);
			return this;
		}
		
		/**
		 * 设置 审批人身份范围
		 * @param assigneeTypeRange 审批人身份范围
		 * @return 当前对象
		*/
		public ProcessDefinition setAssigneeTypeRange(String assigneeTypeRange) {
			super.change(ASSIGNEE_TYPE_RANGE,super.getAssigneeTypeRange(),assigneeTypeRange);
			super.setAssigneeTypeRange(assigneeTypeRange);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ProcessDefinition setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 生效
		 * @param valid 生效
		 * @return 当前对象
		*/
		public ProcessDefinition setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ProcessDefinition setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ProcessDefinition setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ProcessDefinition setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ProcessDefinition setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ProcessDefinition setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ProcessDefinition setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 流程ID
		 * @param camundaDefinitionId 流程ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCamundaDefinitionId(String camundaDefinitionId) {
			super.change(CAMUNDA_DEFINITION_ID,super.getCamundaDefinitionId(),camundaDefinitionId);
			super.setCamundaDefinitionId(camundaDefinitionId);
			return this;
		}
		
		/**
		 * 设置 流程Key
		 * @param camundaDefinitionKey 流程Key
		 * @return 当前对象
		*/
		public ProcessDefinition setCamundaDefinitionKey(String camundaDefinitionKey) {
			super.change(CAMUNDA_DEFINITION_KEY,super.getCamundaDefinitionKey(),camundaDefinitionKey);
			super.setCamundaDefinitionKey(camundaDefinitionKey);
			return this;
		}
		
		/**
		 * 设置 PC端图标
		 * @param iconFilePc PC端图标
		 * @return 当前对象
		*/
		public ProcessDefinition setIconFilePc(String iconFilePc) {
			super.change(ICON_FILE_PC,super.getIconFilePc(),iconFilePc);
			super.setIconFilePc(iconFilePc);
			return this;
		}
		
		/**
		 * 设置 移动端图标
		 * @param iconFileMobile 移动端图标
		 * @return 当前对象
		*/
		public ProcessDefinition setIconFileMobile(String iconFileMobile) {
			super.change(ICON_FILE_MOBILE,super.getIconFileMobile(),iconFileMobile);
			super.setIconFileMobile(iconFileMobile);
			return this;
		}
		
		/**
		 * 设置 序号
		 * @param sort 序号
		 * @return 当前对象
		*/
		public ProcessDefinition setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 分类ID
		 * @param catalogId 分类ID
		 * @return 当前对象
		*/
		public ProcessDefinition setCatalogId(String catalogId) {
			super.change(CATALOG_ID,super.getCatalogId(),catalogId);
			super.setCatalogId(catalogId);
			return this;
		}
		
		/**
		 * 设置 是否允许撤回
		 * @param allowFetchBack 是否允许撤回
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowFetchBack(Integer allowFetchBack) {
			super.change(ALLOW_FETCH_BACK,super.getAllowFetchBack(),allowFetchBack);
			super.setAllowFetchBack(allowFetchBack);
			return this;
		}
		
		/**
		 * 设置 是否允许有条件同意
		 * @param allowAgreeWithCondition 是否允许有条件同意
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowAgreeWithCondition(Integer allowAgreeWithCondition) {
			super.change(ALLOW_AGREE_WITH_CONDITION,super.getAllowAgreeWithCondition(),allowAgreeWithCondition);
			super.setAllowAgreeWithCondition(allowAgreeWithCondition);
			return this;
		}
		
		/**
		 * 设置 是否允许驳回
		 * @param allowReject 是否允许驳回
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowReject(Integer allowReject) {
			super.change(ALLOW_REJECT,super.getAllowReject(),allowReject);
			super.setAllowReject(allowReject);
			return this;
		}
		
		/**
		 * 设置 是否允许跳过
		 * @param allowSkip 是否允许跳过
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowSkip(Integer allowSkip) {
			super.change(ALLOW_SKIP,super.getAllowSkip(),allowSkip);
			super.setAllowSkip(allowSkip);
			return this;
		}
		
		/**
		 * 设置 是否允许废弃
		 * @param allowAbandon 是否允许废弃
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowAbandon(Integer allowAbandon) {
			super.change(ALLOW_ABANDON,super.getAllowAbandon(),allowAbandon);
			super.setAllowAbandon(allowAbandon);
			return this;
		}
		
		/**
		 * 设置 是否允许起草意见
		 * @param allowDraftingComment 是否允许起草意见
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowDraftingComment(Integer allowDraftingComment) {
			super.change(ALLOW_DRAFTING_COMMENT,super.getAllowDraftingComment(),allowDraftingComment);
			super.setAllowDraftingComment(allowDraftingComment);
			return this;
		}
		
		/**
		 * 设置 是否允许审批意见
		 * @param allowApproveComment 是否允许审批意见
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowApproveComment(Integer allowApproveComment) {
			super.change(ALLOW_APPROVE_COMMENT,super.getAllowApproveComment(),allowApproveComment);
			super.setAllowApproveComment(allowApproveComment);
			return this;
		}
		
		/**
		 * 设置 是否允许起草附件
		 * @param allowDraftingAttachment 是否允许起草附件
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowDraftingAttachment(Integer allowDraftingAttachment) {
			super.change(ALLOW_DRAFTING_ATTACHMENT,super.getAllowDraftingAttachment(),allowDraftingAttachment);
			super.setAllowDraftingAttachment(allowDraftingAttachment);
			return this;
		}
		
		/**
		 * 设置 是否允许审批附件
		 * @param allowApproveAttachment 是否允许审批附件
		 * @return 当前对象
		*/
		public ProcessDefinition setAllowApproveAttachment(Integer allowApproveAttachment) {
			super.change(ALLOW_APPROVE_ATTACHMENT,super.getAllowApproveAttachment(),allowApproveAttachment);
			super.setAllowApproveAttachment(allowApproveAttachment);
			return this;
		}
		
		/**
		 * 设置 起草人范围
		 * @param drafterRange 起草人范围
		 * @return 当前对象
		*/
		public ProcessDefinition setDrafterRange(String drafterRange) {
			super.change(DRAFTER_RANGE,super.getDrafterRange(),drafterRange);
			super.setDrafterRange(drafterRange);
			return this;
		}
		
		/**
		 * 设置 最后修改人
		 * @param lastUpdateUser 最后修改人
		 * @return 当前对象
		*/
		public ProcessDefinition setLastUpdateUser(User lastUpdateUser) {
			super.change(LAST_UPDATE_USER,super.getLastUpdateUser(),lastUpdateUser);
			super.setLastUpdateUser(lastUpdateUser);
			return this;
		}
		
		/**
		 * 设置 流程模型定义
		 * @param definitionFile 流程模型定义
		 * @return 当前对象
		*/
		public ProcessDefinition setDefinitionFile(ProcessDefinitionFile definitionFile) {
			super.change(DEFINITION_FILE,super.getDefinitionFile(),definitionFile);
			super.setDefinitionFile(definitionFile);
			return this;
		}
		
		/**
		 * 设置 表单定义
		 * @param formDefinition 表单定义
		 * @return 当前对象
		*/
		public ProcessDefinition setFormDefinition(FormDefinition formDefinition) {
			super.change(FORM_DEFINITION,super.getFormDefinition(),formDefinition);
			super.setFormDefinition(formDefinition);
			return this;
		}
		
		/**
		 * 设置 分类对象
		 * @param catalog 分类对象
		 * @return 当前对象
		*/
		public ProcessDefinition setCatalog(Catalog catalog) {
			super.change(CATALOG,super.getCatalog(),catalog);
			super.setCatalog(catalog);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ProcessDefinitionVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ProcessDefinitionVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAssigneeTypeRange(this.getAssigneeTypeRange());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setAllowSkip(this.getAllowSkip());
			inst.setCamundaDefinitionId(this.getCamundaDefinitionId());
			inst.setIconFileMobile(this.getIconFileMobile());
			inst.setAllowFetchBack(this.getAllowFetchBack());
			inst.setValid(this.getValid());
			inst.setAllowReject(this.getAllowReject());
			inst.setCatalogId(this.getCatalogId());
			inst.setAllowApproveAttachment(this.getAllowApproveAttachment());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setFormDefinitionId(this.getFormDefinitionId());
			inst.setId(this.getId());
			inst.setAllowDraftingAttachment(this.getAllowDraftingAttachment());
			inst.setRejectOption(this.getRejectOption());
			inst.setCamundaDefinitionKey(this.getCamundaDefinitionKey());
			inst.setDrafterRange(this.getDrafterRange());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setVersion(this.getVersion());
			inst.setAllowAgreeWithCondition(this.getAllowAgreeWithCondition());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAllowAbandon(this.getAllowAbandon());
			inst.setAllowApproveComment(this.getAllowApproveComment());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setAllowDraftingComment(this.getAllowDraftingComment());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setIconFilePc(this.getIconFilePc());
			if(all) {
				inst.setFormDefinitionCode(this.getFormDefinitionCode());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setCatalog(this.getCatalog());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setFormDefinition(this.getFormDefinition());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDefinitionFile(this.getDefinitionFile());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setLastUpdateUser(this.getLastUpdateUser());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}