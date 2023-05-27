package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.constants.enums.bpm.PriorityLevel;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程实例
 * <p>流程实例 , 数据表 bpm_process_instance 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-28 06:37:34
 * @sign B7F6F376B8A2065798237B7904E2C617
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_instance")
@ApiModel(description = "流程实例 ; 流程实例 , 数据表 bpm_process_instance 的PO类型")
public class ProcessInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INSTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "708715722301243392")
	private String id;
	
	/**
	 * 起草人账户ID：起草人账户ID
	*/
	@ApiModelProperty(required = true,value="起草人账户ID" , notes = "起草人账户ID" , example = "110588348101165911")
	private String drafterUserId;
	
	/**
	 * 起草人ID：可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID
	*/
	@ApiModelProperty(required = true,value="起草人ID" , notes = "可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID" , example = "E001")
	private String drafterId;
	
	/**
	 * 起草人类型：起草人类型
	*/
	@ApiModelProperty(required = true,value="起草人类型" , notes = "起草人类型" , example = "employee")
	private String drafterType;
	@Transient
	@EnumFor("drafterType")
	private UnifiedUserType drafterTypeEnum;
	
	/**
	 * 表单实例ID：表单实例ID
	*/
	@ApiModelProperty(required = false,value="表单实例ID" , notes = "表单实例ID" , example = "708715724696190976")
	private String formInstanceId;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = true,value="流程定义ID" , notes = "流程定义ID" , example = "594979254974816256")
	private String processDefinitionId;
	
	/**
	 * 流程定义文件ID：流程定义文件ID
	*/
	@ApiModelProperty(required = false,value="流程定义文件ID" , notes = "流程定义文件ID" , example = "703993531739406336")
	private String processDefinitionFileId;
	
	/**
	 * 表单定义ID：表单定义ID
	*/
	@ApiModelProperty(required = true,value="表单定义ID" , notes = "表单定义ID" , example = "594970787358703616")
	private String formDefinitionId;
	
	/**
	 * 流程标题：流程标题
	*/
	@ApiModelProperty(required = false,value="流程标题" , notes = "流程标题" , example = "资产领用申请")
	private String title;
	
	/**
	 * 紧急程度：紧急程度
	*/
	@ApiModelProperty(required = false,value="紧急程度" , notes = "紧急程度" , example = "normal")
	private String priority;
	@Transient
	@EnumFor("priority")
	private PriorityLevel priorityEnum;
	
	/**
	 * 流程说明：流程说明
	*/
	@ApiModelProperty(required = false,value="流程说明" , notes = "流程说明")
	private String comment;
	
	/**
	 * 审批状态：审批状态
	*/
	@ApiModelProperty(required = false,value="审批状态" , notes = "审批状态" , example = "completed")
	private String approvalStatus;
	@Transient
	@EnumFor("approvalStatus")
	private ApprovalStatus approvalStatusEnum;
	
	/**
	 * camunda流程实例ID：camunda流程实例ID
	*/
	@ApiModelProperty(required = false,value="camunda流程实例ID" , notes = "camunda流程实例ID" , example = "ea4f5674-ef0b-11ed-b86f-a2cc740bf173")
	private String camundaInstanceId;
	
	/**
	 * 提交时间：提交时间
	*/
	@ApiModelProperty(required = false,value="提交时间" , notes = "提交时间" , example = "2023-05-10 04:23:20")
	private Date commitTime;
	
	/**
	 * 废弃人账户ID：废弃人账户ID
	*/
	@ApiModelProperty(required = false,value="废弃人账户ID" , notes = "废弃人账户ID")
	private String abandonUserId;
	
	/**
	 * 流程废弃时间：流程废弃时间
	*/
	@ApiModelProperty(required = false,value="流程废弃时间" , notes = "流程废弃时间")
	private Date abandonTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-10 04:23:15")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-10 04:26:41")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "87")
	private Integer version;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID" , example = "T001")
	private String tenantId;
	
	/**
	 * 流程完成时间：流程完成时间
	*/
	@ApiModelProperty(required = false,value="流程完成时间" , notes = "流程完成时间" , example = "2023-05-10 04:25:39")
	private Date endTime;
	
	/**
	 * 是否需要同步：是否需要同步
	*/
	@ApiModelProperty(required = false,value="是否需要同步" , notes = "是否需要同步" , example = "0")
	private Integer needSync;
	
	/**
	 * 状态同步时间：状态同步时间
	*/
	@ApiModelProperty(required = false,value="状态同步时间" , notes = "状态同步时间" , example = "2023-05-10 04:26:41")
	private Date syncTime;
	
	/**
	 * 最近一次审批时间：最近一次审批时间
	*/
	@ApiModelProperty(required = false,value="最近一次审批时间" , notes = "最近一次审批时间")
	private Date latestAppralTime;
	
	/**
	 * 流程定义：流程定义
	*/
	@ApiModelProperty(required = false,value="流程定义" , notes = "流程定义")
	private ProcessDefinition processDefinition;
	
	/**
	 * 表单定义：表单定义
	*/
	@ApiModelProperty(required = false,value="表单定义" , notes = "表单定义")
	private FormDefinition formDefinition;
	
	/**
	 * 表单实例：表单实例
	*/
	@ApiModelProperty(required = false,value="表单实例" , notes = "表单实例")
	private FormInstance formInstance;
	
	/**
	 * 起草人身份：起草人身份
	*/
	@ApiModelProperty(required = false,value="起草人身份" , notes = "起草人身份")
	private Assignee drafter;
	
	/**
	 * 起草人名称：起草人名称
	*/
	@ApiModelProperty(required = false,value="起草人名称" , notes = "起草人名称")
	private String drafterName;
	
	/**
	 * 起草人账户：起草人账户
	*/
	@ApiModelProperty(required = false,value="起草人账户" , notes = "起草人账户")
	private User drafterUser;
	
	/**
	 * 流程任务清单：流程任务清单
	*/
	@ApiModelProperty(required = false,value="流程任务清单" , notes = "流程任务清单")
	private List<Task> tasks;
	
	/**
	 * 待办的流程任务清单：待办的流程任务清单
	*/
	@ApiModelProperty(required = false,value="待办的流程任务清单" , notes = "待办的流程任务清单")
	private List<Task> todoTasks;
	
	/**
	 * 可处理的任务清单：当前登录账户可以处理的任务清单
	*/
	@ApiModelProperty(required = false,value="可处理的任务清单" , notes = "当前登录账户可以处理的任务清单")
	private List<Task> userTasks;
	
	/**
	 * 业务单据：关联的业务单据清单
	*/
	@ApiModelProperty(required = false,value="业务单据" , notes = "关联的业务单据清单")
	private List<FormInstanceBill> bills;
	
	/**
	 * 业务单据ID清单：业务单据ID清单
	*/
	@ApiModelProperty(required = false,value="业务单据ID清单" , notes = "业务单据ID清单")
	private List<String> billIds;
	
	/**
	 * 流程异常清单：流程异常清单
	*/
	@ApiModelProperty(required = false,value="流程异常清单" , notes = "流程异常清单")
	private List<ProcessError> errors;
	
	/**
	 * 已读清单：已读人员清单
	*/
	@ApiModelProperty(required = false,value="已读清单" , notes = "已读人员清单")
	private List<TaskRead> readers;
	
	/**
	 * 审批状态：审批状态
	*/
	@ApiModelProperty(required = false,value="审批状态" , notes = "审批状态")
	private String approvalStatusName;
	
	/**
	 * 流程定义文件：流程定义文件
	*/
	@ApiModelProperty(required = false,value="流程定义文件" , notes = "流程定义文件")
	private ProcessDefinitionFile processDefinitionFile;
	
	/**
	 * 审批动作清单：已完成的审批动作清单
	*/
	@ApiModelProperty(required = false,value="审批动作清单" , notes = "已完成的审批动作清单")
	private List<TaskApproval> taskApprovals;
	
	/**
	 * 附件ID清单：附件ID清单
	*/
	@ApiModelProperty(required = false,value="附件ID清单" , notes = "附件ID清单")
	private List<String> attachmentFileIds;
	
	/**
	 * 附件清单：附件清单
	*/
	@ApiModelProperty(required = false,value="附件清单" , notes = "附件清单")
	private List<TaskApprovalAttachment> attachments;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public ProcessInstance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 起草人账户ID<br>
	 * 起草人账户ID
	 * @return 起草人账户ID
	*/
	public String getDrafterUserId() {
		return drafterUserId;
	}
	
	/**
	 * 设置 起草人账户ID
	 * @param drafterUserId 起草人账户ID
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterUserId(String drafterUserId) {
		this.drafterUserId=drafterUserId;
		return this;
	}
	
	/**
	 * 获得 起草人ID<br>
	 * 可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID
	 * @return 起草人ID
	*/
	public String getDrafterId() {
		return drafterId;
	}
	
	/**
	 * 设置 起草人ID
	 * @param drafterId 起草人ID
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterId(String drafterId) {
		this.drafterId=drafterId;
		return this;
	}
	
	/**
	 * 获得 起草人类型<br>
	 * 起草人类型
	 * @return 起草人类型
	*/
	public String getDrafterType() {
		return drafterType;
	}
	
	/**
	 * 获得 起草人类型 的投影属性<br>
	 * 等价于 getDrafterType 方法，获得对应的枚举类型
	 * @return 起草人类型
	*/
	@Transient
	public UnifiedUserType getDrafterTypeEnum() {
		if(this.drafterTypeEnum==null) {
			this.drafterTypeEnum = (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),drafterType);
		}
		return this.drafterTypeEnum ;
	}
	
	/**
	 * 设置 起草人类型
	 * @param drafterType 起草人类型
	 * @return 当前对象
	*/
	@JsonProperty("drafterType")
	public ProcessInstance setDrafterType(String drafterType) {
		this.drafterType=drafterType;
		this.drafterTypeEnum= (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),drafterType) ;
		if(StringUtil.hasContent(drafterType) && this.drafterTypeEnum==null) {
			throw new IllegalArgumentException( drafterType + " is not one of UnifiedUserType");
		}
		return this;
	}
	
	/**
	 * 设置 起草人类型的投影属性，等同于设置 起草人类型
	 * @param drafterTypeEnum 起草人类型
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstance setDrafterTypeEnum(UnifiedUserType drafterTypeEnum) {
		if(drafterTypeEnum==null) {
			this.setDrafterType(null);
		} else {
			this.setDrafterType(drafterTypeEnum.code());
		}
		this.drafterTypeEnum=drafterTypeEnum;
		return this;
	}
	
	/**
	 * 获得 表单实例ID<br>
	 * 表单实例ID
	 * @return 表单实例ID
	*/
	public String getFormInstanceId() {
		return formInstanceId;
	}
	
	/**
	 * 设置 表单实例ID
	 * @param formInstanceId 表单实例ID
	 * @return 当前对象
	*/
	public ProcessInstance setFormInstanceId(String formInstanceId) {
		this.formInstanceId=formInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程定义ID<br>
	 * 流程定义ID
	 * @return 流程定义ID
	*/
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	
	/**
	 * 设置 流程定义ID
	 * @param processDefinitionId 流程定义ID
	 * @return 当前对象
	*/
	public ProcessInstance setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程定义文件ID<br>
	 * 流程定义文件ID
	 * @return 流程定义文件ID
	*/
	public String getProcessDefinitionFileId() {
		return processDefinitionFileId;
	}
	
	/**
	 * 设置 流程定义文件ID
	 * @param processDefinitionFileId 流程定义文件ID
	 * @return 当前对象
	*/
	public ProcessInstance setProcessDefinitionFileId(String processDefinitionFileId) {
		this.processDefinitionFileId=processDefinitionFileId;
		return this;
	}
	
	/**
	 * 获得 表单定义ID<br>
	 * 表单定义ID
	 * @return 表单定义ID
	*/
	public String getFormDefinitionId() {
		return formDefinitionId;
	}
	
	/**
	 * 设置 表单定义ID
	 * @param formDefinitionId 表单定义ID
	 * @return 当前对象
	*/
	public ProcessInstance setFormDefinitionId(String formDefinitionId) {
		this.formDefinitionId=formDefinitionId;
		return this;
	}
	
	/**
	 * 获得 流程标题<br>
	 * 流程标题
	 * @return 流程标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 流程标题
	 * @param title 流程标题
	 * @return 当前对象
	*/
	public ProcessInstance setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 紧急程度<br>
	 * 紧急程度
	 * @return 紧急程度
	*/
	public String getPriority() {
		return priority;
	}
	
	/**
	 * 获得 紧急程度 的投影属性<br>
	 * 等价于 getPriority 方法，获得对应的枚举类型
	 * @return 紧急程度
	*/
	@Transient
	public PriorityLevel getPriorityEnum() {
		if(this.priorityEnum==null) {
			this.priorityEnum = (PriorityLevel) EnumUtil.parseByCode(PriorityLevel.values(),priority);
		}
		return this.priorityEnum ;
	}
	
	/**
	 * 设置 紧急程度
	 * @param priority 紧急程度
	 * @return 当前对象
	*/
	@JsonProperty("priority")
	public ProcessInstance setPriority(String priority) {
		this.priority=priority;
		this.priorityEnum= (PriorityLevel) EnumUtil.parseByCode(PriorityLevel.values(),priority) ;
		if(StringUtil.hasContent(priority) && this.priorityEnum==null) {
			throw new IllegalArgumentException( priority + " is not one of PriorityLevel");
		}
		return this;
	}
	
	/**
	 * 设置 紧急程度的投影属性，等同于设置 紧急程度
	 * @param priorityEnum 紧急程度
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstance setPriorityEnum(PriorityLevel priorityEnum) {
		if(priorityEnum==null) {
			this.setPriority(null);
		} else {
			this.setPriority(priorityEnum.code());
		}
		this.priorityEnum=priorityEnum;
		return this;
	}
	
	/**
	 * 获得 流程说明<br>
	 * 流程说明
	 * @return 流程说明
	*/
	public String getComment() {
		return comment;
	}
	
	/**
	 * 设置 流程说明
	 * @param comment 流程说明
	 * @return 当前对象
	*/
	public ProcessInstance setComment(String comment) {
		this.comment=comment;
		return this;
	}
	
	/**
	 * 获得 审批状态<br>
	 * 审批状态
	 * @return 审批状态
	*/
	public String getApprovalStatus() {
		return approvalStatus;
	}
	
	/**
	 * 获得 审批状态 的投影属性<br>
	 * 等价于 getApprovalStatus 方法，获得对应的枚举类型
	 * @return 审批状态
	*/
	@Transient
	public ApprovalStatus getApprovalStatusEnum() {
		if(this.approvalStatusEnum==null) {
			this.approvalStatusEnum = (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),approvalStatus);
		}
		return this.approvalStatusEnum ;
	}
	
	/**
	 * 设置 审批状态
	 * @param approvalStatus 审批状态
	 * @return 当前对象
	*/
	@JsonProperty("approvalStatus")
	public ProcessInstance setApprovalStatus(String approvalStatus) {
		this.approvalStatus=approvalStatus;
		this.approvalStatusEnum= (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),approvalStatus) ;
		if(StringUtil.hasContent(approvalStatus) && this.approvalStatusEnum==null) {
			throw new IllegalArgumentException( approvalStatus + " is not one of ApprovalStatus");
		}
		return this;
	}
	
	/**
	 * 设置 审批状态的投影属性，等同于设置 审批状态
	 * @param approvalStatusEnum 审批状态
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstance setApprovalStatusEnum(ApprovalStatus approvalStatusEnum) {
		if(approvalStatusEnum==null) {
			this.setApprovalStatus(null);
		} else {
			this.setApprovalStatus(approvalStatusEnum.code());
		}
		this.approvalStatusEnum=approvalStatusEnum;
		return this;
	}
	
	/**
	 * 获得 camunda流程实例ID<br>
	 * camunda流程实例ID
	 * @return camunda流程实例ID
	*/
	public String getCamundaInstanceId() {
		return camundaInstanceId;
	}
	
	/**
	 * 设置 camunda流程实例ID
	 * @param camundaInstanceId camunda流程实例ID
	 * @return 当前对象
	*/
	public ProcessInstance setCamundaInstanceId(String camundaInstanceId) {
		this.camundaInstanceId=camundaInstanceId;
		return this;
	}
	
	/**
	 * 获得 提交时间<br>
	 * 提交时间
	 * @return 提交时间
	*/
	public Date getCommitTime() {
		return commitTime;
	}
	
	/**
	 * 设置 提交时间
	 * @param commitTime 提交时间
	 * @return 当前对象
	*/
	public ProcessInstance setCommitTime(Date commitTime) {
		this.commitTime=commitTime;
		return this;
	}
	
	/**
	 * 获得 废弃人账户ID<br>
	 * 废弃人账户ID
	 * @return 废弃人账户ID
	*/
	public String getAbandonUserId() {
		return abandonUserId;
	}
	
	/**
	 * 设置 废弃人账户ID
	 * @param abandonUserId 废弃人账户ID
	 * @return 当前对象
	*/
	public ProcessInstance setAbandonUserId(String abandonUserId) {
		this.abandonUserId=abandonUserId;
		return this;
	}
	
	/**
	 * 获得 流程废弃时间<br>
	 * 流程废弃时间
	 * @return 流程废弃时间
	*/
	public Date getAbandonTime() {
		return abandonTime;
	}
	
	/**
	 * 设置 流程废弃时间
	 * @param abandonTime 流程废弃时间
	 * @return 当前对象
	*/
	public ProcessInstance setAbandonTime(Date abandonTime) {
		this.abandonTime=abandonTime;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public ProcessInstance setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public ProcessInstance setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public ProcessInstance setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public ProcessInstance setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public ProcessInstance setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstance setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public ProcessInstance setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public ProcessInstance setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public ProcessInstance setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public ProcessInstance setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 流程完成时间<br>
	 * 流程完成时间
	 * @return 流程完成时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 流程完成时间
	 * @param endTime 流程完成时间
	 * @return 当前对象
	*/
	public ProcessInstance setEndTime(Date endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 是否需要同步<br>
	 * 是否需要同步
	 * @return 是否需要同步
	*/
	public Integer getNeedSync() {
		return needSync;
	}
	
	/**
	 * 设置 是否需要同步
	 * @param needSync 是否需要同步
	 * @return 当前对象
	*/
	public ProcessInstance setNeedSync(Integer needSync) {
		this.needSync=needSync;
		return this;
	}
	
	/**
	 * 获得 状态同步时间<br>
	 * 状态同步时间
	 * @return 状态同步时间
	*/
	public Date getSyncTime() {
		return syncTime;
	}
	
	/**
	 * 设置 状态同步时间
	 * @param syncTime 状态同步时间
	 * @return 当前对象
	*/
	public ProcessInstance setSyncTime(Date syncTime) {
		this.syncTime=syncTime;
		return this;
	}
	
	/**
	 * 获得 最近一次审批时间<br>
	 * 最近一次审批时间
	 * @return 最近一次审批时间
	*/
	public Date getLatestAppralTime() {
		return latestAppralTime;
	}
	
	/**
	 * 设置 最近一次审批时间
	 * @param latestAppralTime 最近一次审批时间
	 * @return 当前对象
	*/
	public ProcessInstance setLatestAppralTime(Date latestAppralTime) {
		this.latestAppralTime=latestAppralTime;
		return this;
	}
	
	/**
	 * 获得 流程定义<br>
	 * 流程定义
	 * @return 流程定义
	*/
	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}
	
	/**
	 * 设置 流程定义
	 * @param processDefinition 流程定义
	 * @return 当前对象
	*/
	public ProcessInstance setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition=processDefinition;
		return this;
	}
	
	/**
	 * 获得 表单定义<br>
	 * 表单定义
	 * @return 表单定义
	*/
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}
	
	/**
	 * 设置 表单定义
	 * @param formDefinition 表单定义
	 * @return 当前对象
	*/
	public ProcessInstance setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition=formDefinition;
		return this;
	}
	
	/**
	 * 获得 表单实例<br>
	 * 表单实例
	 * @return 表单实例
	*/
	public FormInstance getFormInstance() {
		return formInstance;
	}
	
	/**
	 * 设置 表单实例
	 * @param formInstance 表单实例
	 * @return 当前对象
	*/
	public ProcessInstance setFormInstance(FormInstance formInstance) {
		this.formInstance=formInstance;
		return this;
	}
	
	/**
	 * 获得 起草人身份<br>
	 * 起草人身份
	 * @return 起草人身份
	*/
	public Assignee getDrafter() {
		return drafter;
	}
	
	/**
	 * 设置 起草人身份
	 * @param drafter 起草人身份
	 * @return 当前对象
	*/
	public ProcessInstance setDrafter(Assignee drafter) {
		this.drafter=drafter;
		return this;
	}
	
	/**
	 * 获得 起草人名称<br>
	 * 起草人名称
	 * @return 起草人名称
	*/
	public String getDrafterName() {
		return drafterName;
	}
	
	/**
	 * 设置 起草人名称
	 * @param drafterName 起草人名称
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterName(String drafterName) {
		this.drafterName=drafterName;
		return this;
	}
	
	/**
	 * 获得 起草人账户<br>
	 * 起草人账户
	 * @return 起草人账户
	*/
	public User getDrafterUser() {
		return drafterUser;
	}
	
	/**
	 * 设置 起草人账户
	 * @param drafterUser 起草人账户
	 * @return 当前对象
	*/
	public ProcessInstance setDrafterUser(User drafterUser) {
		this.drafterUser=drafterUser;
		return this;
	}
	
	/**
	 * 获得 流程任务清单<br>
	 * 流程任务清单
	 * @return 流程任务清单
	*/
	public List<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * 设置 流程任务清单
	 * @param tasks 流程任务清单
	 * @return 当前对象
	*/
	public ProcessInstance setTasks(List<Task> tasks) {
		this.tasks=tasks;
		return this;
	}
	
	/**
	 * 添加 流程任务清单
	 * @param task 流程任务清单
	 * @return 当前对象
	*/
	public ProcessInstance addTask(Task... task) {
		if(this.tasks==null) tasks=new ArrayList<>();
		this.tasks.addAll(Arrays.asList(task));
		return this;
	}
	
	/**
	 * 获得 待办的流程任务清单<br>
	 * 待办的流程任务清单
	 * @return 待办的流程任务清单
	*/
	public List<Task> getTodoTasks() {
		return todoTasks;
	}
	
	/**
	 * 设置 待办的流程任务清单
	 * @param todoTasks 待办的流程任务清单
	 * @return 当前对象
	*/
	public ProcessInstance setTodoTasks(List<Task> todoTasks) {
		this.todoTasks=todoTasks;
		return this;
	}
	
	/**
	 * 添加 待办的流程任务清单
	 * @param todoTask 待办的流程任务清单
	 * @return 当前对象
	*/
	public ProcessInstance addTodoTask(Task... todoTask) {
		if(this.todoTasks==null) todoTasks=new ArrayList<>();
		this.todoTasks.addAll(Arrays.asList(todoTask));
		return this;
	}
	
	/**
	 * 获得 可处理的任务清单<br>
	 * 当前登录账户可以处理的任务清单
	 * @return 可处理的任务清单
	*/
	public List<Task> getUserTasks() {
		return userTasks;
	}
	
	/**
	 * 设置 可处理的任务清单
	 * @param userTasks 可处理的任务清单
	 * @return 当前对象
	*/
	public ProcessInstance setUserTasks(List<Task> userTasks) {
		this.userTasks=userTasks;
		return this;
	}
	
	/**
	 * 添加 可处理的任务清单
	 * @param userTask 可处理的任务清单
	 * @return 当前对象
	*/
	public ProcessInstance addUserTask(Task... userTask) {
		if(this.userTasks==null) userTasks=new ArrayList<>();
		this.userTasks.addAll(Arrays.asList(userTask));
		return this;
	}
	
	/**
	 * 获得 业务单据<br>
	 * 关联的业务单据清单
	 * @return 业务单据
	*/
	public List<FormInstanceBill> getBills() {
		return bills;
	}
	
	/**
	 * 设置 业务单据
	 * @param bills 业务单据
	 * @return 当前对象
	*/
	public ProcessInstance setBills(List<FormInstanceBill> bills) {
		this.bills=bills;
		return this;
	}
	
	/**
	 * 添加 业务单据
	 * @param bill 业务单据
	 * @return 当前对象
	*/
	public ProcessInstance addBill(FormInstanceBill... bill) {
		if(this.bills==null) bills=new ArrayList<>();
		this.bills.addAll(Arrays.asList(bill));
		return this;
	}
	
	/**
	 * 获得 业务单据ID清单<br>
	 * 业务单据ID清单
	 * @return 业务单据ID清单
	*/
	public List<String> getBillIds() {
		return billIds;
	}
	
	/**
	 * 设置 业务单据ID清单
	 * @param billIds 业务单据ID清单
	 * @return 当前对象
	*/
	public ProcessInstance setBillIds(List<String> billIds) {
		this.billIds=billIds;
		return this;
	}
	
	/**
	 * 添加 业务单据ID清单
	 * @param billId 业务单据ID清单
	 * @return 当前对象
	*/
	public ProcessInstance addBillId(String... billId) {
		if(this.billIds==null) billIds=new ArrayList<>();
		this.billIds.addAll(Arrays.asList(billId));
		return this;
	}
	
	/**
	 * 获得 流程异常清单<br>
	 * 流程异常清单
	 * @return 流程异常清单
	*/
	public List<ProcessError> getErrors() {
		return errors;
	}
	
	/**
	 * 设置 流程异常清单
	 * @param errors 流程异常清单
	 * @return 当前对象
	*/
	public ProcessInstance setErrors(List<ProcessError> errors) {
		this.errors=errors;
		return this;
	}
	
	/**
	 * 添加 流程异常清单
	 * @param error 流程异常清单
	 * @return 当前对象
	*/
	public ProcessInstance addError(ProcessError... error) {
		if(this.errors==null) errors=new ArrayList<>();
		this.errors.addAll(Arrays.asList(error));
		return this;
	}
	
	/**
	 * 获得 已读清单<br>
	 * 已读人员清单
	 * @return 已读清单
	*/
	public List<TaskRead> getReaders() {
		return readers;
	}
	
	/**
	 * 设置 已读清单
	 * @param readers 已读清单
	 * @return 当前对象
	*/
	public ProcessInstance setReaders(List<TaskRead> readers) {
		this.readers=readers;
		return this;
	}
	
	/**
	 * 添加 已读清单
	 * @param reader 已读清单
	 * @return 当前对象
	*/
	public ProcessInstance addReader(TaskRead... reader) {
		if(this.readers==null) readers=new ArrayList<>();
		this.readers.addAll(Arrays.asList(reader));
		return this;
	}
	
	/**
	 * 获得 审批状态<br>
	 * 审批状态
	 * @return 审批状态
	*/
	public String getApprovalStatusName() {
		return approvalStatusName;
	}
	
	/**
	 * 设置 审批状态
	 * @param approvalStatusName 审批状态
	 * @return 当前对象
	*/
	public ProcessInstance setApprovalStatusName(String approvalStatusName) {
		this.approvalStatusName=approvalStatusName;
		return this;
	}
	
	/**
	 * 获得 流程定义文件<br>
	 * 流程定义文件
	 * @return 流程定义文件
	*/
	public ProcessDefinitionFile getProcessDefinitionFile() {
		return processDefinitionFile;
	}
	
	/**
	 * 设置 流程定义文件
	 * @param processDefinitionFile 流程定义文件
	 * @return 当前对象
	*/
	public ProcessInstance setProcessDefinitionFile(ProcessDefinitionFile processDefinitionFile) {
		this.processDefinitionFile=processDefinitionFile;
		return this;
	}
	
	/**
	 * 获得 审批动作清单<br>
	 * 已完成的审批动作清单
	 * @return 审批动作清单
	*/
	public List<TaskApproval> getTaskApprovals() {
		return taskApprovals;
	}
	
	/**
	 * 设置 审批动作清单
	 * @param taskApprovals 审批动作清单
	 * @return 当前对象
	*/
	public ProcessInstance setTaskApprovals(List<TaskApproval> taskApprovals) {
		this.taskApprovals=taskApprovals;
		return this;
	}
	
	/**
	 * 添加 审批动作清单
	 * @param taskApproval 审批动作清单
	 * @return 当前对象
	*/
	public ProcessInstance addTaskApproval(TaskApproval... taskApproval) {
		if(this.taskApprovals==null) taskApprovals=new ArrayList<>();
		this.taskApprovals.addAll(Arrays.asList(taskApproval));
		return this;
	}
	
	/**
	 * 获得 附件ID清单<br>
	 * 附件ID清单
	 * @return 附件ID清单
	*/
	public List<String> getAttachmentFileIds() {
		return attachmentFileIds;
	}
	
	/**
	 * 设置 附件ID清单
	 * @param attachmentFileIds 附件ID清单
	 * @return 当前对象
	*/
	public ProcessInstance setAttachmentFileIds(List<String> attachmentFileIds) {
		this.attachmentFileIds=attachmentFileIds;
		return this;
	}
	
	/**
	 * 添加 附件ID清单
	 * @param attachmentFileId 附件ID清单
	 * @return 当前对象
	*/
	public ProcessInstance addAttachmentFileId(String... attachmentFileId) {
		if(this.attachmentFileIds==null) attachmentFileIds=new ArrayList<>();
		this.attachmentFileIds.addAll(Arrays.asList(attachmentFileId));
		return this;
	}
	
	/**
	 * 获得 附件清单<br>
	 * 附件清单
	 * @return 附件清单
	*/
	public List<TaskApprovalAttachment> getAttachments() {
		return attachments;
	}
	
	/**
	 * 设置 附件清单
	 * @param attachments 附件清单
	 * @return 当前对象
	*/
	public ProcessInstance setAttachments(List<TaskApprovalAttachment> attachments) {
		this.attachments=attachments;
		return this;
	}
	
	/**
	 * 添加 附件清单
	 * @param attachment 附件清单
	 * @return 当前对象
	*/
	public ProcessInstance addAttachment(TaskApprovalAttachment... attachment) {
		if(this.attachments==null) attachments=new ArrayList<>();
		this.attachments.addAll(Arrays.asList(attachment));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessInstance , 转换好的 ProcessInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstance , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInstance clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInstance duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta.$$proxy$$();
		inst.setSyncTime(this.getSyncTime());
		inst.setNeedSync(this.getNeedSync());
		inst.setFormInstanceId(this.getFormInstanceId());
		inst.setTitle(this.getTitle());
		inst.setDrafterUserId(this.getDrafterUserId());
		inst.setCommitTime(this.getCommitTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDrafterId(this.getDrafterId());
		inst.setFormDefinitionId(this.getFormDefinitionId());
		inst.setId(this.getId());
		inst.setApprovalStatus(this.getApprovalStatus());
		inst.setProcessDefinitionId(this.getProcessDefinitionId());
		inst.setAbandonTime(this.getAbandonTime());
		inst.setDrafterType(this.getDrafterType());
		inst.setAbandonUserId(this.getAbandonUserId());
		inst.setProcessDefinitionFileId(this.getProcessDefinitionFileId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPriority(this.getPriority());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setComment(this.getComment());
		inst.setCamundaInstanceId(this.getCamundaInstanceId());
		inst.setEndTime(this.getEndTime());
		inst.setLatestAppralTime(this.getLatestAppralTime());
		if(all) {
			inst.setBillIds(this.getBillIds());
			inst.setFormInstance(this.getFormInstance());
			inst.setTodoTasks(this.getTodoTasks());
			inst.setAttachments(this.getAttachments());
			inst.setProcessDefinition(this.getProcessDefinition());
			inst.setDrafter(this.getDrafter());
			inst.setApprovalStatusName(this.getApprovalStatusName());
			inst.setDrafterUser(this.getDrafterUser());
			inst.setFormDefinition(this.getFormDefinition());
			inst.setAttachmentFileIds(this.getAttachmentFileIds());
			inst.setReaders(this.getReaders());
			inst.setUserTasks(this.getUserTasks());
			inst.setBills(this.getBills());
			inst.setProcessDefinitionFile(this.getProcessDefinitionFile());
			inst.setTaskApprovals(this.getTaskApprovals());
			inst.setDrafterName(this.getDrafterName());
			inst.setTasks(this.getTasks());
			inst.setErrors(this.getErrors());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInstance clone(boolean deep) {
		return EntityContext.clone(ProcessInstance.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInstance
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessInstance , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessInstance po = create();
		EntityContext.copyProperties(po,processInstanceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstance , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstance po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProcessInstance，等同于 new
	 * @return ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setSyncTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.SYNC_TIME)));
			this.setNeedSync(DataParser.parse(Integer.class, map.get(ProcessInstanceMeta.NEED_SYNC)));
			this.setFormInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.FORM_INSTANCE_ID)));
			this.setTitle(DataParser.parse(String.class, map.get(ProcessInstanceMeta.TITLE)));
			this.setDrafterUserId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.DRAFTER_USER_ID)));
			this.setCommitTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.COMMIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInstanceMeta.UPDATE_BY)));
			this.setDrafterId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.DRAFTER_ID)));
			this.setFormDefinitionId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.ID)));
			this.setApprovalStatus(DataParser.parse(String.class, map.get(ProcessInstanceMeta.APPROVAL_STATUS)));
			this.setProcessDefinitionId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.PROCESS_DEFINITION_ID)));
			this.setAbandonTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.ABANDON_TIME)));
			this.setDrafterType(DataParser.parse(String.class, map.get(ProcessInstanceMeta.DRAFTER_TYPE)));
			this.setAbandonUserId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.ABANDON_USER_ID)));
			this.setProcessDefinitionFileId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.PROCESS_DEFINITION_FILE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(String.class, map.get(ProcessInstanceMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInstanceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInstanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInstanceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInstanceMeta.DELETE_BY)));
			this.setComment(DataParser.parse(String.class, map.get(ProcessInstanceMeta.COMMENT)));
			this.setCamundaInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceMeta.CAMUNDA_INSTANCE_ID)));
			this.setEndTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.END_TIME)));
			this.setLatestAppralTime(DataParser.parse(Date.class, map.get(ProcessInstanceMeta.LATEST_APPRAL_TIME)));
			// others
			this.setFormInstance(DataParser.parse(FormInstance.class, map.get(ProcessInstanceMeta.FORM_INSTANCE)));
			this.setProcessDefinition(DataParser.parse(ProcessDefinition.class, map.get(ProcessInstanceMeta.PROCESS_DEFINITION)));
			this.setDrafter(DataParser.parse(Assignee.class, map.get(ProcessInstanceMeta.DRAFTER)));
			this.setApprovalStatusName(DataParser.parse(String.class, map.get(ProcessInstanceMeta.APPROVAL_STATUS_NAME)));
			this.setDrafterUser(DataParser.parse(User.class, map.get(ProcessInstanceMeta.DRAFTER_USER)));
			this.setFormDefinition(DataParser.parse(FormDefinition.class, map.get(ProcessInstanceMeta.FORM_DEFINITION)));
			this.setProcessDefinitionFile(DataParser.parse(ProcessDefinitionFile.class, map.get(ProcessInstanceMeta.PROCESS_DEFINITION_FILE)));
			this.setDrafterName(DataParser.parse(String.class, map.get(ProcessInstanceMeta.DRAFTER_NAME)));
			return true;
		} else {
			try {
				this.setSyncTime( (Date)map.get(ProcessInstanceMeta.SYNC_TIME));
				this.setNeedSync( (Integer)map.get(ProcessInstanceMeta.NEED_SYNC));
				this.setFormInstanceId( (String)map.get(ProcessInstanceMeta.FORM_INSTANCE_ID));
				this.setTitle( (String)map.get(ProcessInstanceMeta.TITLE));
				this.setDrafterUserId( (String)map.get(ProcessInstanceMeta.DRAFTER_USER_ID));
				this.setCommitTime( (Date)map.get(ProcessInstanceMeta.COMMIT_TIME));
				this.setUpdateBy( (String)map.get(ProcessInstanceMeta.UPDATE_BY));
				this.setDrafterId( (String)map.get(ProcessInstanceMeta.DRAFTER_ID));
				this.setFormDefinitionId( (String)map.get(ProcessInstanceMeta.FORM_DEFINITION_ID));
				this.setId( (String)map.get(ProcessInstanceMeta.ID));
				this.setApprovalStatus( (String)map.get(ProcessInstanceMeta.APPROVAL_STATUS));
				this.setProcessDefinitionId( (String)map.get(ProcessInstanceMeta.PROCESS_DEFINITION_ID));
				this.setAbandonTime( (Date)map.get(ProcessInstanceMeta.ABANDON_TIME));
				this.setDrafterType( (String)map.get(ProcessInstanceMeta.DRAFTER_TYPE));
				this.setAbandonUserId( (String)map.get(ProcessInstanceMeta.ABANDON_USER_ID));
				this.setProcessDefinitionFileId( (String)map.get(ProcessInstanceMeta.PROCESS_DEFINITION_FILE_ID));
				this.setUpdateTime( (Date)map.get(ProcessInstanceMeta.UPDATE_TIME));
				this.setPriority( (String)map.get(ProcessInstanceMeta.PRIORITY));
				this.setVersion( (Integer)map.get(ProcessInstanceMeta.VERSION));
				this.setCreateBy( (String)map.get(ProcessInstanceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessInstanceMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInstanceMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProcessInstanceMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ProcessInstanceMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInstanceMeta.DELETE_BY));
				this.setComment( (String)map.get(ProcessInstanceMeta.COMMENT));
				this.setCamundaInstanceId( (String)map.get(ProcessInstanceMeta.CAMUNDA_INSTANCE_ID));
				this.setEndTime( (Date)map.get(ProcessInstanceMeta.END_TIME));
				this.setLatestAppralTime( (Date)map.get(ProcessInstanceMeta.LATEST_APPRAL_TIME));
				// others
				this.setFormInstance( (FormInstance)map.get(ProcessInstanceMeta.FORM_INSTANCE));
				this.setProcessDefinition( (ProcessDefinition)map.get(ProcessInstanceMeta.PROCESS_DEFINITION));
				this.setDrafter( (Assignee)map.get(ProcessInstanceMeta.DRAFTER));
				this.setApprovalStatusName( (String)map.get(ProcessInstanceMeta.APPROVAL_STATUS_NAME));
				this.setDrafterUser( (User)map.get(ProcessInstanceMeta.DRAFTER_USER));
				this.setFormDefinition( (FormDefinition)map.get(ProcessInstanceMeta.FORM_DEFINITION));
				this.setProcessDefinitionFile( (ProcessDefinitionFile)map.get(ProcessInstanceMeta.PROCESS_DEFINITION_FILE));
				this.setDrafterName( (String)map.get(ProcessInstanceMeta.DRAFTER_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setSyncTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.SYNC_TIME)));
			this.setNeedSync(DataParser.parse(Integer.class, r.getValue(ProcessInstanceMeta.NEED_SYNC)));
			this.setFormInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.FORM_INSTANCE_ID)));
			this.setTitle(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.TITLE)));
			this.setDrafterUserId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.DRAFTER_USER_ID)));
			this.setCommitTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.COMMIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.UPDATE_BY)));
			this.setDrafterId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.DRAFTER_ID)));
			this.setFormDefinitionId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.FORM_DEFINITION_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.ID)));
			this.setApprovalStatus(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.APPROVAL_STATUS)));
			this.setProcessDefinitionId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.PROCESS_DEFINITION_ID)));
			this.setAbandonTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.ABANDON_TIME)));
			this.setDrafterType(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.DRAFTER_TYPE)));
			this.setAbandonUserId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.ABANDON_USER_ID)));
			this.setProcessDefinitionFileId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.PROCESS_DEFINITION_FILE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInstanceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInstanceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.DELETE_BY)));
			this.setComment(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.COMMENT)));
			this.setCamundaInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceMeta.CAMUNDA_INSTANCE_ID)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.END_TIME)));
			this.setLatestAppralTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceMeta.LATEST_APPRAL_TIME)));
			return true;
		} else {
			try {
				this.setSyncTime( (Date)r.getValue(ProcessInstanceMeta.SYNC_TIME));
				this.setNeedSync( (Integer)r.getValue(ProcessInstanceMeta.NEED_SYNC));
				this.setFormInstanceId( (String)r.getValue(ProcessInstanceMeta.FORM_INSTANCE_ID));
				this.setTitle( (String)r.getValue(ProcessInstanceMeta.TITLE));
				this.setDrafterUserId( (String)r.getValue(ProcessInstanceMeta.DRAFTER_USER_ID));
				this.setCommitTime( (Date)r.getValue(ProcessInstanceMeta.COMMIT_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInstanceMeta.UPDATE_BY));
				this.setDrafterId( (String)r.getValue(ProcessInstanceMeta.DRAFTER_ID));
				this.setFormDefinitionId( (String)r.getValue(ProcessInstanceMeta.FORM_DEFINITION_ID));
				this.setId( (String)r.getValue(ProcessInstanceMeta.ID));
				this.setApprovalStatus( (String)r.getValue(ProcessInstanceMeta.APPROVAL_STATUS));
				this.setProcessDefinitionId( (String)r.getValue(ProcessInstanceMeta.PROCESS_DEFINITION_ID));
				this.setAbandonTime( (Date)r.getValue(ProcessInstanceMeta.ABANDON_TIME));
				this.setDrafterType( (String)r.getValue(ProcessInstanceMeta.DRAFTER_TYPE));
				this.setAbandonUserId( (String)r.getValue(ProcessInstanceMeta.ABANDON_USER_ID));
				this.setProcessDefinitionFileId( (String)r.getValue(ProcessInstanceMeta.PROCESS_DEFINITION_FILE_ID));
				this.setUpdateTime( (Date)r.getValue(ProcessInstanceMeta.UPDATE_TIME));
				this.setPriority( (String)r.getValue(ProcessInstanceMeta.PRIORITY));
				this.setVersion( (Integer)r.getValue(ProcessInstanceMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProcessInstanceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessInstanceMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInstanceMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProcessInstanceMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ProcessInstanceMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInstanceMeta.DELETE_BY));
				this.setComment( (String)r.getValue(ProcessInstanceMeta.COMMENT));
				this.setCamundaInstanceId( (String)r.getValue(ProcessInstanceMeta.CAMUNDA_INSTANCE_ID));
				this.setEndTime( (Date)r.getValue(ProcessInstanceMeta.END_TIME));
				this.setLatestAppralTime( (Date)r.getValue(ProcessInstanceMeta.LATEST_APPRAL_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}