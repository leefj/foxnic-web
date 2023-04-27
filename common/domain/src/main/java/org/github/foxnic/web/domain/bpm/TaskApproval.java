package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_APPROVAL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.constants.enums.bpm.ApprovalResult;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
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
import org.github.foxnic.web.domain.bpm.meta.TaskApprovalMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程任务审批结果
 * <p>流程任务审批结果 , 数据表 bpm_task_approval 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-27 17:03:09
 * @sign FFA2DA3FD0DB048AC71DA7635833F4E6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task_approval")
@ApiModel(description = "流程任务审批结果 ; 流程任务审批结果 , 数据表 bpm_task_approval 的PO类型")
public class TaskApproval extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK_APPROVAL.$TABLE;

	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id" , example = "681081985065549824")
	private String id;

	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID" , example = "681081982213423104")
	private String taskId;

	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID" , example = "681076426912301056")
	private String processInstanceId;

	/**
	 * 审批人账户ID：实际的审批人
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "实际的审批人" , example = "581798649130909696")
	private String approvalUserId;

	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间" , example = "2023-02-23 10:16:39")
	private Date approvalTime;

	/**
	 * 审批结果：审批结果
	*/
	@ApiModelProperty(required = false,value="审批结果" , notes = "审批结果" , example = "skip")
	private String approvalResult;
	@Transient
	@EnumFor("approvalResult")
	private ApprovalResult approvalResultEnum;

	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见" , example = "跳过起草节点")
	private String approvalComment;

	/**
	 * 审批人类型：预计的审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "预计的审批人类型" , example = "user")
	private String assigneeType;

	/**
	 * 审批人ID：预计的审批人
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "预计的审批人" , example = "581798649130909696")
	private String assigneeId;

	/**
	 * 变量数据：变量数据
	*/
	@ApiModelProperty(required = false,value="变量数据" , notes = "变量数据" , example = "{}")
	private String variables;

	/**
	 * create_by：create_by
	*/
	@ApiModelProperty(required = false,value="create_by" , notes = "create_by")
	private String createBy;

	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-02-23 10:16:39")
	private Date createTime;

	/**
	 * update_by：update_by
	*/
	@ApiModelProperty(required = false,value="update_by" , notes = "update_by")
	private String updateBy;

	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-02-23 10:16:40")
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
	 * delete_by：delete_by
	*/
	@ApiModelProperty(required = false,value="delete_by" , notes = "delete_by")
	private String deleteBy;

	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;

	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;

	/**
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id")
	private String tenantId;

	/**
	 * CAM结果：Camunda返回的结果
	*/
	@ApiModelProperty(required = false,value="CAM结果" , notes = "Camunda返回的结果" , example = "")
	private String camundaResult;

	/**
	 * CAM成功：Camunda处理是否成功
	*/
	@ApiModelProperty(required = false,value="CAM成功" , notes = "Camunda处理是否成功" , example = "1")
	private Integer camundaSuccess;

	/**
	 * 审批人身份：审批人身份
	*/
	@ApiModelProperty(required = false,value="审批人身份" , notes = "审批人身份")
	private Assignee approver;

	/**
	 * 审批人账户：审批人账户
	*/
	@ApiModelProperty(required = false,value="审批人账户" , notes = "审批人账户")
	private User approvalUser;

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
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}

	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public TaskApproval setId(String id) {
		this.id=id;
		return this;
	}

	/**
	 * 获得 任务ID<br>
	 * 任务ID
	 * @return 任务ID
	*/
	public String getTaskId() {
		return taskId;
	}

	/**
	 * 设置 任务ID
	 * @param taskId 任务ID
	 * @return 当前对象
	*/
	public TaskApproval setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}

	/**
	 * 获得 流程实例ID<br>
	 * 流程实例ID
	 * @return 流程实例ID
	*/
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	/**
	 * 设置 流程实例ID
	 * @param processInstanceId 流程实例ID
	 * @return 当前对象
	*/
	public TaskApproval setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}

	/**
	 * 获得 审批人账户ID<br>
	 * 实际的审批人
	 * @return 审批人账户ID
	*/
	public String getApprovalUserId() {
		return approvalUserId;
	}

	/**
	 * 设置 审批人账户ID
	 * @param approvalUserId 审批人账户ID
	 * @return 当前对象
	*/
	public TaskApproval setApprovalUserId(String approvalUserId) {
		this.approvalUserId=approvalUserId;
		return this;
	}

	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getApprovalTime() {
		return approvalTime;
	}

	/**
	 * 设置 处理时间
	 * @param approvalTime 处理时间
	 * @return 当前对象
	*/
	public TaskApproval setApprovalTime(Date approvalTime) {
		this.approvalTime=approvalTime;
		return this;
	}

	/**
	 * 获得 审批结果<br>
	 * 审批结果
	 * @return 审批结果
	*/
	public String getApprovalResult() {
		return approvalResult;
	}

	/**
	 * 获得 审批结果 的投影属性<br>
	 * 等价于 getApprovalResult 方法，获得对应的枚举类型
	 * @return 审批结果
	*/
	@Transient
	public ApprovalResult getApprovalResultEnum() {
		if(this.approvalResultEnum==null) {
			this.approvalResultEnum = (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),approvalResult);
		}
		return this.approvalResultEnum ;
	}

	/**
	 * 设置 审批结果
	 * @param approvalResult 审批结果
	 * @return 当前对象
	*/
	@JsonProperty("approvalResult")
	public TaskApproval setApprovalResult(String approvalResult) {
		this.approvalResult=approvalResult;
		this.approvalResultEnum= (ApprovalResult) EnumUtil.parseByCode(ApprovalResult.values(),approvalResult) ;
		if(StringUtil.hasContent(approvalResult) && this.approvalResultEnum==null) {
			throw new IllegalArgumentException( approvalResult + " is not one of ApprovalResult");
		}
		return this;
	}

	/**
	 * 设置 审批结果的投影属性，等同于设置 审批结果
	 * @param approvalResultEnum 审批结果
	 * @return 当前对象
	*/
	@Transient
	public TaskApproval setApprovalResultEnum(ApprovalResult approvalResultEnum) {
		if(approvalResultEnum==null) {
			this.setApprovalResult(null);
		} else {
			this.setApprovalResult(approvalResultEnum.code());
		}
		this.approvalResultEnum=approvalResultEnum;
		return this;
	}

	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getApprovalComment() {
		return approvalComment;
	}

	/**
	 * 设置 审批意见
	 * @param approvalComment 审批意见
	 * @return 当前对象
	*/
	public TaskApproval setApprovalComment(String approvalComment) {
		this.approvalComment=approvalComment;
		return this;
	}

	/**
	 * 获得 审批人类型<br>
	 * 预计的审批人类型
	 * @return 审批人类型
	*/
	public String getAssigneeType() {
		return assigneeType;
	}

	/**
	 * 设置 审批人类型
	 * @param assigneeType 审批人类型
	 * @return 当前对象
	*/
	public TaskApproval setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		return this;
	}

	/**
	 * 获得 审批人ID<br>
	 * 预计的审批人
	 * @return 审批人ID
	*/
	public String getAssigneeId() {
		return assigneeId;
	}

	/**
	 * 设置 审批人ID
	 * @param assigneeId 审批人ID
	 * @return 当前对象
	*/
	public TaskApproval setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}

	/**
	 * 获得 变量数据<br>
	 * 变量数据
	 * @return 变量数据
	*/
	public String getVariables() {
		return variables;
	}

	/**
	 * 设置 变量数据
	 * @param variables 变量数据
	 * @return 当前对象
	*/
	public TaskApproval setVariables(String variables) {
		this.variables=variables;
		return this;
	}

	/**
	 * 获得 create_by<br>
	 * create_by
	 * @return create_by
	*/
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 create_by
	 * @param createBy create_by
	 * @return 当前对象
	*/
	public TaskApproval setCreateBy(String createBy) {
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
	public TaskApproval setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}

	/**
	 * 获得 update_by<br>
	 * update_by
	 * @return update_by
	*/
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 update_by
	 * @param updateBy update_by
	 * @return 当前对象
	*/
	public TaskApproval setUpdateBy(String updateBy) {
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
	public TaskApproval setUpdateTime(Date updateTime) {
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
	public TaskApproval setDeleted(Integer deleted) {
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
	public TaskApproval setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}

	/**
	 * 获得 delete_by<br>
	 * delete_by
	 * @return delete_by
	*/
	public String getDeleteBy() {
		return deleteBy;
	}

	/**
	 * 设置 delete_by
	 * @param deleteBy delete_by
	 * @return 当前对象
	*/
	public TaskApproval setDeleteBy(String deleteBy) {
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
	public TaskApproval setDeleteTime(Date deleteTime) {
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
	public TaskApproval setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 获得 tenant_id<br>
	 * tenant_id
	 * @return tenant_id
	*/
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * 设置 tenant_id
	 * @param tenantId tenant_id
	 * @return 当前对象
	*/
	public TaskApproval setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 获得 CAM结果<br>
	 * Camunda返回的结果
	 * @return CAM结果
	*/
	public String getCamundaResult() {
		return camundaResult;
	}

	/**
	 * 设置 CAM结果
	 * @param camundaResult CAM结果
	 * @return 当前对象
	*/
	public TaskApproval setCamundaResult(String camundaResult) {
		this.camundaResult=camundaResult;
		return this;
	}

	/**
	 * 获得 CAM成功<br>
	 * Camunda处理是否成功
	 * @return CAM成功
	*/
	public Integer getCamundaSuccess() {
		return camundaSuccess;
	}

	/**
	 * 设置 CAM成功
	 * @param camundaSuccess CAM成功
	 * @return 当前对象
	*/
	public TaskApproval setCamundaSuccess(Integer camundaSuccess) {
		this.camundaSuccess=camundaSuccess;
		return this;
	}

	/**
	 * 获得 审批人身份<br>
	 * 审批人身份
	 * @return 审批人身份
	*/
	public Assignee getApprover() {
		return approver;
	}

	/**
	 * 设置 审批人身份
	 * @param approver 审批人身份
	 * @return 当前对象
	*/
	public TaskApproval setApprover(Assignee approver) {
		this.approver=approver;
		return this;
	}

	/**
	 * 获得 审批人账户<br>
	 * 审批人账户
	 * @return 审批人账户
	*/
	public User getApprovalUser() {
		return approvalUser;
	}

	/**
	 * 设置 审批人账户
	 * @param approvalUser 审批人账户
	 * @return 当前对象
	*/
	public TaskApproval setApprovalUser(User approvalUser) {
		this.approvalUser=approvalUser;
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
	public TaskApproval setAttachmentFileIds(List<String> attachmentFileIds) {
		this.attachmentFileIds=attachmentFileIds;
		return this;
	}

	/**
	 * 添加 附件ID清单
	 * @param attachmentFileId 附件ID清单
	 * @return 当前对象
	*/
	public TaskApproval addAttachmentFileId(String... attachmentFileId) {
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
	public TaskApproval setAttachments(List<TaskApprovalAttachment> attachments) {
		this.attachments=attachments;
		return this;
	}

	/**
	 * 添加 附件清单
	 * @param attachment 附件清单
	 * @return 当前对象
	*/
	public TaskApproval addAttachment(TaskApprovalAttachment... attachment) {
		if(this.attachments==null) attachments=new ArrayList<>();
		this.attachments.addAll(Arrays.asList(attachment));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TaskApproval , 转换好的 TaskApproval 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskApproval , 转换好的 PoJo 对象
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
	public TaskApproval clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskApproval duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.TaskApprovalMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.TaskApprovalMeta.$$proxy$$();
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
			inst.setAttachments(this.getAttachments());
			inst.setApprovalUser(this.getApprovalUser());
			inst.setAttachmentFileIds(this.getAttachmentFileIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskApproval clone(boolean deep) {
		return EntityContext.clone(TaskApproval.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TaskApproval
	 * @param taskApprovalMap 包含实体信息的 Map 对象
	 * @return TaskApproval , 转换好的的 TaskApproval 对象
	*/
	@Transient
	public static TaskApproval createFrom(Map<String,Object> taskApprovalMap) {
		if(taskApprovalMap==null) return null;
		TaskApproval po = create();
		EntityContext.copyProperties(po,taskApprovalMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskApproval
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskApproval , 转换好的的 TaskApproval 对象
	*/
	@Transient
	public static TaskApproval createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskApproval po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 TaskApproval，等同于 new
	 * @return TaskApproval 对象
	*/
	@Transient
	public static TaskApproval create() {
		return new org.github.foxnic.web.domain.bpm.meta.TaskApprovalMeta.$$proxy$$();
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
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(TaskApprovalMeta.PROCESS_INSTANCE_ID)));
			this.setVariables(DataParser.parse(String.class, map.get(TaskApprovalMeta.VARIABLES)));
			this.setCamundaSuccess(DataParser.parse(Integer.class, map.get(TaskApprovalMeta.CAMUNDA_SUCCESS)));
			this.setApprovalTime(DataParser.parse(Date.class, map.get(TaskApprovalMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TaskApprovalMeta.UPDATE_TIME)));
			this.setAssigneeId(DataParser.parse(String.class, map.get(TaskApprovalMeta.ASSIGNEE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TaskApprovalMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TaskApprovalMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TaskApprovalMeta.DELETED)));
			this.setApprovalResult(DataParser.parse(String.class, map.get(TaskApprovalMeta.APPROVAL_RESULT)));
			this.setApprovalComment(DataParser.parse(String.class, map.get(TaskApprovalMeta.APPROVAL_COMMENT)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TaskApprovalMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TaskApprovalMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TaskApprovalMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TaskApprovalMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TaskApprovalMeta.DELETE_BY)));
			this.setCamundaResult(DataParser.parse(String.class, map.get(TaskApprovalMeta.CAMUNDA_RESULT)));
			this.setId(DataParser.parse(String.class, map.get(TaskApprovalMeta.ID)));
			this.setApprovalUserId(DataParser.parse(String.class, map.get(TaskApprovalMeta.APPROVAL_USER_ID)));
			this.setAssigneeType(DataParser.parse(String.class, map.get(TaskApprovalMeta.ASSIGNEE_TYPE)));
			this.setTaskId(DataParser.parse(String.class, map.get(TaskApprovalMeta.TASK_ID)));
			// others
			this.setApprover(DataParser.parse(Assignee.class, map.get(TaskApprovalMeta.APPROVER)));
			this.setApprovalUser(DataParser.parse(User.class, map.get(TaskApprovalMeta.APPROVAL_USER)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)map.get(TaskApprovalMeta.PROCESS_INSTANCE_ID));
				this.setVariables( (String)map.get(TaskApprovalMeta.VARIABLES));
				this.setCamundaSuccess( (Integer)map.get(TaskApprovalMeta.CAMUNDA_SUCCESS));
				this.setApprovalTime( (Date)map.get(TaskApprovalMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)map.get(TaskApprovalMeta.UPDATE_TIME));
				this.setAssigneeId( (String)map.get(TaskApprovalMeta.ASSIGNEE_ID));
				this.setVersion( (Integer)map.get(TaskApprovalMeta.VERSION));
				this.setCreateBy( (String)map.get(TaskApprovalMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(TaskApprovalMeta.DELETED));
				this.setApprovalResult( (String)map.get(TaskApprovalMeta.APPROVAL_RESULT));
				this.setApprovalComment( (String)map.get(TaskApprovalMeta.APPROVAL_COMMENT));
				this.setCreateTime( (Date)map.get(TaskApprovalMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TaskApprovalMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TaskApprovalMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(TaskApprovalMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TaskApprovalMeta.DELETE_BY));
				this.setCamundaResult( (String)map.get(TaskApprovalMeta.CAMUNDA_RESULT));
				this.setId( (String)map.get(TaskApprovalMeta.ID));
				this.setApprovalUserId( (String)map.get(TaskApprovalMeta.APPROVAL_USER_ID));
				this.setAssigneeType( (String)map.get(TaskApprovalMeta.ASSIGNEE_TYPE));
				this.setTaskId( (String)map.get(TaskApprovalMeta.TASK_ID));
				// others
				this.setApprover( (Assignee)map.get(TaskApprovalMeta.APPROVER));
				this.setApprovalUser( (User)map.get(TaskApprovalMeta.APPROVAL_USER));
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
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.PROCESS_INSTANCE_ID)));
			this.setVariables(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.VARIABLES)));
			this.setCamundaSuccess(DataParser.parse(Integer.class, r.getValue(TaskApprovalMeta.CAMUNDA_SUCCESS)));
			this.setApprovalTime(DataParser.parse(Date.class, r.getValue(TaskApprovalMeta.APPROVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalMeta.UPDATE_TIME)));
			this.setAssigneeId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.ASSIGNEE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TaskApprovalMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TaskApprovalMeta.DELETED)));
			this.setApprovalResult(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.APPROVAL_RESULT)));
			this.setApprovalComment(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.APPROVAL_COMMENT)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TaskApprovalMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.DELETE_BY)));
			this.setCamundaResult(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.CAMUNDA_RESULT)));
			this.setId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.ID)));
			this.setApprovalUserId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.APPROVAL_USER_ID)));
			this.setAssigneeType(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.ASSIGNEE_TYPE)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(TaskApprovalMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)r.getValue(TaskApprovalMeta.PROCESS_INSTANCE_ID));
				this.setVariables( (String)r.getValue(TaskApprovalMeta.VARIABLES));
				this.setCamundaSuccess( (Integer)r.getValue(TaskApprovalMeta.CAMUNDA_SUCCESS));
				this.setApprovalTime( (Date)r.getValue(TaskApprovalMeta.APPROVAL_TIME));
				this.setUpdateTime( (Date)r.getValue(TaskApprovalMeta.UPDATE_TIME));
				this.setAssigneeId( (String)r.getValue(TaskApprovalMeta.ASSIGNEE_ID));
				this.setVersion( (Integer)r.getValue(TaskApprovalMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TaskApprovalMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(TaskApprovalMeta.DELETED));
				this.setApprovalResult( (String)r.getValue(TaskApprovalMeta.APPROVAL_RESULT));
				this.setApprovalComment( (String)r.getValue(TaskApprovalMeta.APPROVAL_COMMENT));
				this.setCreateTime( (Date)r.getValue(TaskApprovalMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TaskApprovalMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TaskApprovalMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(TaskApprovalMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TaskApprovalMeta.DELETE_BY));
				this.setCamundaResult( (String)r.getValue(TaskApprovalMeta.CAMUNDA_RESULT));
				this.setId( (String)r.getValue(TaskApprovalMeta.ID));
				this.setApprovalUserId( (String)r.getValue(TaskApprovalMeta.APPROVAL_USER_ID));
				this.setAssigneeType( (String)r.getValue(TaskApprovalMeta.ASSIGNEE_TYPE));
				this.setTaskId( (String)r.getValue(TaskApprovalMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}
