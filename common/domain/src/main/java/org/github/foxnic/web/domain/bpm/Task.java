package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程任务
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-07 09:27:45
 * @sign E2496322A53C4B269C943E47F94A7EF2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task")
public class Task extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String processDefinitionId;
	
	/**
	 * 节点ID：节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "节点ID")
	private String nodeId;
	
	/**
	 * 节点名称：节点名称
	*/
	@ApiModelProperty(required = false,value="节点名称" , notes = "节点名称")
	private String nodeName;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 审批人账户ID：实际的审批人
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "实际的审批人")
	private String approverUserId;
	
	/**
	 * 审批人账户类型：实际的审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人账户类型" , notes = "实际的审批人类型")
	private String approverType;
	
	/**
	 * 审批人身份ID：实际的审批人身份
	*/
	@ApiModelProperty(required = false,value="审批人身份ID" , notes = "实际的审批人身份")
	private String appriverId;
	
	/**
	 * 审批人账户ID：预计的审批人
	*/
	@ApiModelProperty(required = false,value="审批人账户ID" , notes = "预计的审批人")
	private String assigneeId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态")
	private String status;
	
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
	 * 变量数据：变量数据
	*/
	@ApiModelProperty(required = false,value="变量数据" , notes = "变量数据")
	private String variables;
	
	/**
	 * 任务ID：Camunda 任务ID
	*/
	@ApiModelProperty(required = true,value="任务ID" , notes = "Camunda 任务ID")
	private String camundaTaskId;
	
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
	public Task setId(String id) {
		this.id=id;
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
	public Task setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId=processDefinitionId;
		return this;
	}
	
	/**
	 * 获得 节点ID<br>
	 * 节点ID
	 * @return 节点ID
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点ID
	 * @param nodeId 节点ID
	 * @return 当前对象
	*/
	public Task setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 节点名称<br>
	 * 节点名称
	 * @return 节点名称
	*/
	public String getNodeName() {
		return nodeName;
	}
	
	/**
	 * 设置 节点名称
	 * @param nodeName 节点名称
	 * @return 当前对象
	*/
	public Task setNodeName(String nodeName) {
		this.nodeName=nodeName;
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
	public Task setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 审批人账户ID<br>
	 * 实际的审批人
	 * @return 审批人账户ID
	*/
	public String getApproverUserId() {
		return approverUserId;
	}
	
	/**
	 * 设置 审批人账户ID
	 * @param approverUserId 审批人账户ID
	 * @return 当前对象
	*/
	public Task setApproverUserId(String approverUserId) {
		this.approverUserId=approverUserId;
		return this;
	}
	
	/**
	 * 获得 审批人账户类型<br>
	 * 实际的审批人类型
	 * @return 审批人账户类型
	*/
	public String getApproverType() {
		return approverType;
	}
	
	/**
	 * 设置 审批人账户类型
	 * @param approverType 审批人账户类型
	 * @return 当前对象
	*/
	public Task setApproverType(String approverType) {
		this.approverType=approverType;
		return this;
	}
	
	/**
	 * 获得 审批人身份ID<br>
	 * 实际的审批人身份
	 * @return 审批人身份ID
	*/
	public String getAppriverId() {
		return appriverId;
	}
	
	/**
	 * 设置 审批人身份ID
	 * @param appriverId 审批人身份ID
	 * @return 当前对象
	*/
	public Task setAppriverId(String appriverId) {
		this.appriverId=appriverId;
		return this;
	}
	
	/**
	 * 获得 审批人账户ID<br>
	 * 预计的审批人
	 * @return 审批人账户ID
	*/
	public String getAssigneeId() {
		return assigneeId;
	}
	
	/**
	 * 设置 审批人账户ID
	 * @param assigneeId 审批人账户ID
	 * @return 当前对象
	*/
	public Task setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 任务状态
	 * @param status 任务状态
	 * @return 当前对象
	*/
	public Task setStatus(String status) {
		this.status=status;
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
	public Task setApprovalTime(Date approvalTime) {
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
	public Task setApprovalResult(String approvalResult) {
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
	public Task setApprovalComment(String approvalComment) {
		this.approvalComment=approvalComment;
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
	public Task setVariables(String variables) {
		this.variables=variables;
		return this;
	}
	
	/**
	 * 获得 任务ID<br>
	 * Camunda 任务ID
	 * @return 任务ID
	*/
	public String getCamundaTaskId() {
		return camundaTaskId;
	}
	
	/**
	 * 设置 任务ID
	 * @param camundaTaskId 任务ID
	 * @return 当前对象
	*/
	public Task setCamundaTaskId(String camundaTaskId) {
		this.camundaTaskId=camundaTaskId;
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
	public Task setCreateBy(String createBy) {
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
	public Task setCreateTime(Date createTime) {
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
	public Task setUpdateBy(String updateBy) {
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
	public Task setUpdateTime(Date updateTime) {
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Task setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public Task setDeleteBy(String deleteBy) {
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
	public Task setDeleteTime(Date deleteTime) {
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
	public Task setVersion(Integer version) {
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
	public Task setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Task , 转换好的 Task 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Task , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Task
	 * @param taskMap 包含实体信息的 Map 对象
	 * @return Task , 转换好的的 Task 对象
	*/
	@Transient
	public static Task createFrom(Map<String,Object> taskMap) {
		if(taskMap==null) return null;
		Task po = EntityContext.create(Task.class, taskMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Task
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Task , 转换好的的 Task 对象
	*/
	@Transient
	public static Task createFrom(Object pojo) {
		if(pojo==null) return null;
		Task po = EntityContext.create(Task.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Task，等同于 new
	 * @return Task 对象
	*/
	@Transient
	public static Task create() {
		return EntityContext.create(Task.class);
	}
}