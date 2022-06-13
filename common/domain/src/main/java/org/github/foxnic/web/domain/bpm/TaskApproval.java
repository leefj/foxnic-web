package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_APPROVAL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.oauth.User;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程任务审批结果
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-13 14:46:25
 * @sign A70B1539DC7FFD511D745C976A054497
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task_approval")
public class TaskApproval extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK_APPROVAL.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 任务ID：任务ID
	*/
	@ApiModelProperty(required = false,value="任务ID" , notes = "任务ID")
	private String taskId;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 审批人账户ID：实际的审批人
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "实际的审批人")
	private String approvalUserId;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间")
	private Date approvalTime;
	
	/**
	 * 审批结果：审批结果
	*/
	@ApiModelProperty(required = false,value="审批结果" , notes = "审批结果")
	private String approvalResult;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String approvalComment;
	
	/**
	 * 审批人类型：预计的审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "预计的审批人类型")
	private String assigneeType;
	
	/**
	 * 审批人ID：预计的审批人
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "预计的审批人")
	private String assigneeId;
	
	/**
	 * 变量数据：变量数据
	*/
	@ApiModelProperty(required = false,value="变量数据" , notes = "变量数据")
	private String variables;
	
	/**
	 * create_by：create_by
	*/
	@ApiModelProperty(required = false,value="create_by" , notes = "create_by")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * update_by：update_by
	*/
	@ApiModelProperty(required = false,value="update_by" , notes = "update_by")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * tenant_id：tenant_id
	*/
	@ApiModelProperty(required = false,value="tenant_id" , notes = "tenant_id")
	private String tenantId;
	
	/**
	 * CAM结果：Camunda返回的结果
	*/
	@ApiModelProperty(required = false,value="CAM结果" , notes = "Camunda返回的结果")
	private String camundaResult;
	
	/**
	 * CAM成功：Camunda处理是否成功
	*/
	@ApiModelProperty(required = false,value="CAM成功" , notes = "Camunda处理是否成功")
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
	 * 设置 审批结果
	 * @param approvalResult 审批结果
	 * @return 当前对象
	*/
	public TaskApproval setApprovalResult(String approvalResult) {
		this.approvalResult=approvalResult;
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
	 * 将 Map 转换成 TaskApproval
	 * @param taskApprovalMap 包含实体信息的 Map 对象
	 * @return TaskApproval , 转换好的的 TaskApproval 对象
	*/
	@Transient
	public static TaskApproval createFrom(Map<String,Object> taskApprovalMap) {
		if(taskApprovalMap==null) return null;
		TaskApproval po = EntityContext.create(TaskApproval.class, taskApprovalMap);
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
		TaskApproval po = EntityContext.create(TaskApproval.class,pojo);
		return po;
	}

	/**
	 * 创建一个 TaskApproval，等同于 new
	 * @return TaskApproval 对象
	*/
	@Transient
	public static TaskApproval create() {
		return EntityContext.create(TaskApproval.class);
	}
}