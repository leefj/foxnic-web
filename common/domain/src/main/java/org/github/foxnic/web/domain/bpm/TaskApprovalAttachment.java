package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_TASK_APPROVAL_ATTACHMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.TaskApprovalAttachmentMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程任务审批附件
 * <p>流程任务审批附件 , 数据表 bpm_task_approval_attachment 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-23 15:57:21
 * @sign D175BB9B30BBE9B2617D250918938A80
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_task_approval_attachment")
@ApiModel(description = "流程任务审批附件 ; 流程任务审批附件 , 数据表 bpm_task_approval_attachment 的PO类型")
public class TaskApprovalAttachment extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_TASK_APPROVAL_ATTACHMENT.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id" , example = "681081985065549824")
	private String id;
	
	/**
	 * 审批ID：审批ID
	*/
	@ApiModelProperty(required = false,value="审批ID" , notes = "审批ID" , example = "681081982213423104")
	private String approvalId;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID" , example = "681076426912301056")
	private String processInstanceId;
	
	/**
	 * 附件ID：附件ID
	*/
	@ApiModelProperty(required = false,value="附件ID" , notes = "附件ID" , example = "581798649130909696")
	private String fileId;
	
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
	public TaskApprovalAttachment setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 审批ID<br>
	 * 审批ID
	 * @return 审批ID
	*/
	public String getApprovalId() {
		return approvalId;
	}
	
	/**
	 * 设置 审批ID
	 * @param approvalId 审批ID
	 * @return 当前对象
	*/
	public TaskApprovalAttachment setApprovalId(String approvalId) {
		this.approvalId=approvalId;
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
	public TaskApprovalAttachment setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 附件ID<br>
	 * 附件ID
	 * @return 附件ID
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件ID
	 * @param fileId 附件ID
	 * @return 当前对象
	*/
	public TaskApprovalAttachment setFileId(String fileId) {
		this.fileId=fileId;
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
	public TaskApprovalAttachment setCreateBy(String createBy) {
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
	public TaskApprovalAttachment setCreateTime(Date createTime) {
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
	public TaskApprovalAttachment setUpdateBy(String updateBy) {
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
	public TaskApprovalAttachment setUpdateTime(Date updateTime) {
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
	public TaskApprovalAttachment setDeleted(Integer deleted) {
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
	public TaskApprovalAttachment setDeleted(Boolean deletedBool) {
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
	public TaskApprovalAttachment setDeleteBy(String deleteBy) {
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
	public TaskApprovalAttachment setDeleteTime(Date deleteTime) {
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
	public TaskApprovalAttachment setVersion(Integer version) {
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
	public TaskApprovalAttachment setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TaskApprovalAttachment , 转换好的 TaskApprovalAttachment 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TaskApprovalAttachment , 转换好的 PoJo 对象
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
	public TaskApprovalAttachment clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TaskApprovalAttachment duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.TaskApprovalAttachmentMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.TaskApprovalAttachmentMeta.$$proxy$$();
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setApprovalId(this.getApprovalId());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TaskApprovalAttachment clone(boolean deep) {
		return EntityContext.clone(TaskApprovalAttachment.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TaskApprovalAttachment
	 * @param taskApprovalAttachmentMap 包含实体信息的 Map 对象
	 * @return TaskApprovalAttachment , 转换好的的 TaskApprovalAttachment 对象
	*/
	@Transient
	public static TaskApprovalAttachment createFrom(Map<String,Object> taskApprovalAttachmentMap) {
		if(taskApprovalAttachmentMap==null) return null;
		TaskApprovalAttachment po = create();
		EntityContext.copyProperties(po,taskApprovalAttachmentMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 TaskApprovalAttachment
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TaskApprovalAttachment , 转换好的的 TaskApprovalAttachment 对象
	*/
	@Transient
	public static TaskApprovalAttachment createFrom(Object pojo) {
		if(pojo==null) return null;
		TaskApprovalAttachment po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 TaskApprovalAttachment，等同于 new
	 * @return TaskApprovalAttachment 对象
	*/
	@Transient
	public static TaskApprovalAttachment create() {
		return new org.github.foxnic.web.domain.bpm.meta.TaskApprovalAttachmentMeta.$$proxy$$();
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
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.PROCESS_INSTANCE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TaskApprovalAttachmentMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TaskApprovalAttachmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TaskApprovalAttachmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TaskApprovalAttachmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TaskApprovalAttachmentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.DELETE_BY)));
			this.setApprovalId(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.APPROVAL_ID)));
			this.setId(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(TaskApprovalAttachmentMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)map.get(TaskApprovalAttachmentMeta.PROCESS_INSTANCE_ID));
				this.setUpdateTime( (Date)map.get(TaskApprovalAttachmentMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(TaskApprovalAttachmentMeta.VERSION));
				this.setCreateBy( (String)map.get(TaskApprovalAttachmentMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(TaskApprovalAttachmentMeta.DELETED));
				this.setCreateTime( (Date)map.get(TaskApprovalAttachmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TaskApprovalAttachmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TaskApprovalAttachmentMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(TaskApprovalAttachmentMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TaskApprovalAttachmentMeta.DELETE_BY));
				this.setApprovalId( (String)map.get(TaskApprovalAttachmentMeta.APPROVAL_ID));
				this.setId( (String)map.get(TaskApprovalAttachmentMeta.ID));
				this.setFileId( (String)map.get(TaskApprovalAttachmentMeta.FILE_ID));
				// others
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
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.PROCESS_INSTANCE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalAttachmentMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TaskApprovalAttachmentMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TaskApprovalAttachmentMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TaskApprovalAttachmentMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TaskApprovalAttachmentMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.DELETE_BY)));
			this.setApprovalId(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.APPROVAL_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(TaskApprovalAttachmentMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)r.getValue(TaskApprovalAttachmentMeta.PROCESS_INSTANCE_ID));
				this.setUpdateTime( (Date)r.getValue(TaskApprovalAttachmentMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(TaskApprovalAttachmentMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TaskApprovalAttachmentMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(TaskApprovalAttachmentMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TaskApprovalAttachmentMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TaskApprovalAttachmentMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TaskApprovalAttachmentMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(TaskApprovalAttachmentMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TaskApprovalAttachmentMeta.DELETE_BY));
				this.setApprovalId( (String)r.getValue(TaskApprovalAttachmentMeta.APPROVAL_ID));
				this.setId( (String)r.getValue(TaskApprovalAttachmentMeta.ID));
				this.setFileId( (String)r.getValue(TaskApprovalAttachmentMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}