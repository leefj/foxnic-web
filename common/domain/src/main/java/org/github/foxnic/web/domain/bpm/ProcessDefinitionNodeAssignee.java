package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_DEFINITION_NODE_ASSIGNEE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 流程审批人
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-08 07:30:34
 * @sign 4B2A5AB0D4079F3555CF560983662A0D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_definition_node_assignee")
public class ProcessDefinitionNodeAssignee extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_DEFINITION_NODE_ASSIGNEE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 流程节点ID：流程节点ID
	*/
	@ApiModelProperty(required = false,value="流程节点ID" , notes = "流程节点ID")
	private String nodeId;
	
	/**
	 * 审批人类型：审批人类型
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "审批人类型")
	private String assigneeType;
	
	/**
	 * 审批人ID：审批人ID
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "审批人ID")
	private String assigneeId;
	
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
	 * 序号：序号
	*/
	@ApiModelProperty(required = false,value="序号" , notes = "序号")
	private Integer sort;
	
	/**
	 * 审批人：审批人
	*/
	@ApiModelProperty(required = false,value="审批人" , notes = "审批人")
	private Approver assignee;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public ProcessDefinitionNodeAssignee setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程节点ID<br>
	 * 流程节点ID
	 * @return 流程节点ID
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 流程节点ID
	 * @param nodeId 流程节点ID
	 * @return 当前对象
	*/
	public ProcessDefinitionNodeAssignee setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 审批人类型<br>
	 * 审批人类型
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
	public ProcessDefinitionNodeAssignee setAssigneeType(String assigneeType) {
		this.assigneeType=assigneeType;
		return this;
	}
	
	/**
	 * 获得 审批人ID<br>
	 * 审批人ID
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
	public ProcessDefinitionNodeAssignee setAssigneeId(String assigneeId) {
		this.assigneeId=assigneeId;
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
	public ProcessDefinitionNodeAssignee setCreateBy(String createBy) {
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
	public ProcessDefinitionNodeAssignee setCreateTime(Date createTime) {
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
	public ProcessDefinitionNodeAssignee setUpdateBy(String updateBy) {
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
	public ProcessDefinitionNodeAssignee setUpdateTime(Date updateTime) {
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
	public ProcessDefinitionNodeAssignee setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public ProcessDefinitionNodeAssignee setDeleteBy(String deleteBy) {
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
	public ProcessDefinitionNodeAssignee setDeleteTime(Date deleteTime) {
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
	public ProcessDefinitionNodeAssignee setVersion(Integer version) {
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
	public ProcessDefinitionNodeAssignee setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 序号<br>
	 * 序号
	 * @return 序号
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 序号
	 * @param sort 序号
	 * @return 当前对象
	*/
	public ProcessDefinitionNodeAssignee setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 审批人<br>
	 * 审批人
	 * @return 审批人
	*/
	public Approver getAssignee() {
		return assignee;
	}
	
	/**
	 * 设置 审批人
	 * @param assignee 审批人
	 * @return 当前对象
	*/
	public ProcessDefinitionNodeAssignee setAssignee(Approver assignee) {
		this.assignee=assignee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessDefinitionNodeAssignee , 转换好的 ProcessDefinitionNodeAssignee 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessDefinitionNodeAssignee , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProcessDefinitionNodeAssignee
	 * @param processDefinitionNodeAssigneeMap 包含实体信息的 Map 对象
	 * @return ProcessDefinitionNodeAssignee , 转换好的的 ProcessDefinitionNodeAssignee 对象
	*/
	@Transient
	public static ProcessDefinitionNodeAssignee createFrom(Map<String,Object> processDefinitionNodeAssigneeMap) {
		if(processDefinitionNodeAssigneeMap==null) return null;
		ProcessDefinitionNodeAssignee po = EntityContext.create(ProcessDefinitionNodeAssignee.class, processDefinitionNodeAssigneeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessDefinitionNodeAssignee
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessDefinitionNodeAssignee , 转换好的的 ProcessDefinitionNodeAssignee 对象
	*/
	@Transient
	public static ProcessDefinitionNodeAssignee createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessDefinitionNodeAssignee po = EntityContext.create(ProcessDefinitionNodeAssignee.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProcessDefinitionNodeAssignee，等同于 new
	 * @return ProcessDefinitionNodeAssignee 对象
	*/
	@Transient
	public static ProcessDefinitionNodeAssignee create() {
		return EntityContext.create(ProcessDefinitionNodeAssignee.class);
	}
}