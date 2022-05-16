package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import javax.persistence.Transient;
import org.github.foxnic.web.constants.enums.bpm.PriorityLevel;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import java.util.Date;
import org.github.foxnic.web.domain.oauth.User;
import java.util.List;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-16 13:57:38
 * @sign FAF1CF9AA4E001EA934E337960AC0863
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_instance")
public class ProcessInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INSTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 起草人账户ID：起草人账户ID
	*/
	@ApiModelProperty(required = false,value="起草人账户ID" , notes = "起草人账户ID")
	private String drafterUserId;
	
	/**
	 * 起草人ID：可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID
	*/
	@ApiModelProperty(required = false,value="起草人ID" , notes = "可以是账户ID、员工ID、职位ID、系统角色ID、业务角色ID")
	private String drafterId;
	
	/**
	 * 起草人类型：起草人类型
	*/
	@ApiModelProperty(required = false,value="起草人类型" , notes = "起草人类型")
	private String drafterType;
	@Transient
	private UnifiedUserType drafterTypeEnum;
	
	/**
	 * 表单实例ID：表单实例ID
	*/
	@ApiModelProperty(required = false,value="表单实例ID" , notes = "表单实例ID")
	private String formInstanceId;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String processDefinitionId;
	
	/**
	 * 流程定义文件ID：流程定义文件ID
	*/
	@ApiModelProperty(required = false,value="流程定义文件ID" , notes = "流程定义文件ID")
	private String processDefinitionFileId;
	
	/**
	 * 表单定义ID：表单定义ID
	*/
	@ApiModelProperty(required = false,value="表单定义ID" , notes = "表单定义ID")
	private String formDefinitionId;
	
	/**
	 * 流程标题：流程标题
	*/
	@ApiModelProperty(required = false,value="流程标题" , notes = "流程标题")
	private String title;
	
	/**
	 * 紧急程度：紧急程度
	*/
	@ApiModelProperty(required = false,value="紧急程度" , notes = "紧急程度")
	private String priority;
	@Transient
	private PriorityLevel priorityEnum;
	
	/**
	 * 流程说明：流程说明
	*/
	@ApiModelProperty(required = false,value="流程说明" , notes = "流程说明")
	private String comment;
	
	/**
	 * 审批状态：审批状态
	*/
	@ApiModelProperty(required = false,value="审批状态" , notes = "审批状态")
	private String approvalStatus;
	@Transient
	private ApprovalStatus approvalStatusEnum;
	
	/**
	 * camunda流程实例ID：camunda流程实例ID
	*/
	@ApiModelProperty(required = false,value="camunda流程实例ID" , notes = "camunda流程实例ID")
	private String camundaInstanceId;
	
	/**
	 * 提交时间：提交时间
	*/
	@ApiModelProperty(required = false,value="提交时间" , notes = "提交时间")
	private Date commitTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
	/**
	 * 流程完成时间：流程完成时间
	*/
	@ApiModelProperty(required = false,value="流程完成时间" , notes = "流程完成时间")
	private Date endTime;
	
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
	 * 流程定义文件：流程定义文件
	*/
	@ApiModelProperty(required = false,value="流程定义文件" , notes = "流程定义文件")
	private ProcessDefinitionFile processDefinitionFile;
	
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
	public ProcessInstance addTask(Task task) {
		if(this.tasks==null) tasks=new ArrayList<>();
		this.tasks.add(task);
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
	 * 将 Map 转换成 ProcessInstance
	 * @param processInstanceMap 包含实体信息的 Map 对象
	 * @return ProcessInstance , 转换好的的 ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance createFrom(Map<String,Object> processInstanceMap) {
		if(processInstanceMap==null) return null;
		ProcessInstance po = EntityContext.create(ProcessInstance.class, processInstanceMap);
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
		ProcessInstance po = EntityContext.create(ProcessInstance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessInstance，等同于 new
	 * @return ProcessInstance 对象
	*/
	@Transient
	public static ProcessInstance create() {
		return EntityContext.create(ProcessInstance.class);
	}
}