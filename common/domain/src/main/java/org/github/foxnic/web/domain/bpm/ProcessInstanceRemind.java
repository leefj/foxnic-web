package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE_REMIND;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程实例提醒
 * <p>流程实例提醒 , 数据表 bpm_process_instance_remind 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-19 21:00:31
 * @sign 08E364A972733563576C13B3065F05D1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_instance_remind")
@ApiModel(description = "流程实例提醒 ; 流程实例提醒 , 数据表 bpm_process_instance_remind 的PO类型")
public class ProcessInstanceRemind extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INSTANCE_REMIND.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 流程实例ID：流程实例ID
	*/
	@ApiModelProperty(required = false,value="流程实例ID" , notes = "流程实例ID")
	private String processInstanceId;
	
	/**
	 * 监控的目标节点ID：监控的目标节点ID
	*/
	@ApiModelProperty(required = false,value="监控的目标节点ID" , notes = "监控的目标节点ID")
	private String targetNodeId;
	
	/**
	 * 设置提醒的节点ID：设置提醒的节点ID
	*/
	@ApiModelProperty(required = false,value="设置提醒的节点ID" , notes = "设置提醒的节点ID")
	private String sourceNodeId;
	
	/**
	 * 提醒内容：提醒内容
	*/
	@ApiModelProperty(required = false,value="提醒内容" , notes = "提醒内容")
	private String content;
	
	/**
	 * 提醒日期：提醒日期
	*/
	@ApiModelProperty(required = false,value="提醒日期" , notes = "提醒日期")
	private String remindDate;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 是否生效：是否生效
	*/
	@ApiModelProperty(required = false,value="是否生效" , notes = "是否生效")
	private Integer valid;
	
	/**
	 * 接收人清单：接收人清单
	*/
	@ApiModelProperty(required = false,value="接收人清单" , notes = "接收人清单")
	private List<ProcessInstanceRemindReceiver> receivers;
	
	/**
	 * 监控的目标节点：监控的目标节点
	*/
	@ApiModelProperty(required = false,value="监控的目标节点" , notes = "监控的目标节点")
	private ProcessDefinitionNode targetNode;
	
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
	public ProcessInstanceRemind setId(String id) {
		this.id=id;
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
	public ProcessInstanceRemind setProcessInstanceId(String processInstanceId) {
		this.processInstanceId=processInstanceId;
		return this;
	}
	
	/**
	 * 获得 监控的目标节点ID<br>
	 * 监控的目标节点ID
	 * @return 监控的目标节点ID
	*/
	public String getTargetNodeId() {
		return targetNodeId;
	}
	
	/**
	 * 设置 监控的目标节点ID
	 * @param targetNodeId 监控的目标节点ID
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setTargetNodeId(String targetNodeId) {
		this.targetNodeId=targetNodeId;
		return this;
	}
	
	/**
	 * 获得 设置提醒的节点ID<br>
	 * 设置提醒的节点ID
	 * @return 设置提醒的节点ID
	*/
	public String getSourceNodeId() {
		return sourceNodeId;
	}
	
	/**
	 * 设置 设置提醒的节点ID
	 * @param sourceNodeId 设置提醒的节点ID
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setSourceNodeId(String sourceNodeId) {
		this.sourceNodeId=sourceNodeId;
		return this;
	}
	
	/**
	 * 获得 提醒内容<br>
	 * 提醒内容
	 * @return 提醒内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 提醒内容
	 * @param content 提醒内容
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 提醒日期<br>
	 * 提醒日期
	 * @return 提醒日期
	*/
	public String getRemindDate() {
		return remindDate;
	}
	
	/**
	 * 设置 提醒日期
	 * @param remindDate 提醒日期
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setRemindDate(String remindDate) {
		this.remindDate=remindDate;
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
	public ProcessInstanceRemind setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ProcessInstanceRemind setCreateBy(String createBy) {
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
	public ProcessInstanceRemind setCreateTime(Date createTime) {
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
	public ProcessInstanceRemind setUpdateBy(String updateBy) {
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
	public ProcessInstanceRemind setUpdateTime(Date updateTime) {
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
	public ProcessInstanceRemind setDeleted(Integer deleted) {
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
	public ProcessInstanceRemind setDeleted(Boolean deletedBool) {
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
	public ProcessInstanceRemind setDeleteBy(String deleteBy) {
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
	public ProcessInstanceRemind setDeleteTime(Date deleteTime) {
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
	public ProcessInstanceRemind setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 是否生效<br>
	 * 是否生效
	 * @return 是否生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否生效
	 * @param valid 是否生效
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 接收人清单<br>
	 * 接收人清单
	 * @return 接收人清单
	*/
	public List<ProcessInstanceRemindReceiver> getReceivers() {
		return receivers;
	}
	
	/**
	 * 设置 接收人清单
	 * @param receivers 接收人清单
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setReceivers(List<ProcessInstanceRemindReceiver> receivers) {
		this.receivers=receivers;
		return this;
	}
	
	/**
	 * 添加 接收人清单
	 * @param receiver 接收人清单
	 * @return 当前对象
	*/
	public ProcessInstanceRemind addReceiver(ProcessInstanceRemindReceiver... receiver) {
		if(this.receivers==null) receivers=new ArrayList<>();
		this.receivers.addAll(Arrays.asList(receiver));
		return this;
	}
	
	/**
	 * 获得 监控的目标节点<br>
	 * 监控的目标节点
	 * @return 监控的目标节点
	*/
	public ProcessDefinitionNode getTargetNode() {
		return targetNode;
	}
	
	/**
	 * 设置 监控的目标节点
	 * @param targetNode 监控的目标节点
	 * @return 当前对象
	*/
	public ProcessInstanceRemind setTargetNode(ProcessDefinitionNode targetNode) {
		this.targetNode=targetNode;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessInstanceRemind , 转换好的 ProcessInstanceRemind 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstanceRemind , 转换好的 PoJo 对象
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
	public ProcessInstanceRemind clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInstanceRemind duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindMeta.$$proxy$$();
		inst.setProcessInstanceId(this.getProcessInstanceId());
		inst.setRemindDate(this.getRemindDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setSourceNodeId(this.getSourceNodeId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTargetNodeId(this.getTargetNodeId());
		if(all) {
			inst.setReceivers(this.getReceivers());
			inst.setTargetNode(this.getTargetNode());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInstanceRemind clone(boolean deep) {
		return EntityContext.clone(ProcessInstanceRemind.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInstanceRemind
	 * @param processInstanceRemindMap 包含实体信息的 Map 对象
	 * @return ProcessInstanceRemind , 转换好的的 ProcessInstanceRemind 对象
	*/
	@Transient
	public static ProcessInstanceRemind createFrom(Map<String,Object> processInstanceRemindMap) {
		if(processInstanceRemindMap==null) return null;
		ProcessInstanceRemind po = create();
		EntityContext.copyProperties(po,processInstanceRemindMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstanceRemind
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstanceRemind , 转换好的的 ProcessInstanceRemind 对象
	*/
	@Transient
	public static ProcessInstanceRemind createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstanceRemind po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProcessInstanceRemind，等同于 new
	 * @return ProcessInstanceRemind 对象
	*/
	@Transient
	public static ProcessInstanceRemind create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindMeta.$$proxy$$();
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
			this.setProcessInstanceId(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.PROCESS_INSTANCE_ID)));
			this.setRemindDate(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.REMIND_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.CONTENT)));
			this.setValid(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindMeta.DELETE_TIME)));
			this.setSourceNodeId(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.SOURCE_NODE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.ID)));
			this.setTargetNodeId(DataParser.parse(String.class, map.get(ProcessInstanceRemindMeta.TARGET_NODE_ID)));
			// others
			this.setTargetNode(DataParser.parse(ProcessDefinitionNode.class, map.get(ProcessInstanceRemindMeta.TARGET_NODE)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)map.get(ProcessInstanceRemindMeta.PROCESS_INSTANCE_ID));
				this.setRemindDate( (String)map.get(ProcessInstanceRemindMeta.REMIND_DATE));
				this.setUpdateTime( (Date)map.get(ProcessInstanceRemindMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ProcessInstanceRemindMeta.VERSION));
				this.setContent( (String)map.get(ProcessInstanceRemindMeta.CONTENT));
				this.setValid( (Integer)map.get(ProcessInstanceRemindMeta.VALID));
				this.setCreateBy( (String)map.get(ProcessInstanceRemindMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessInstanceRemindMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInstanceRemindMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProcessInstanceRemindMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProcessInstanceRemindMeta.DELETE_TIME));
				this.setSourceNodeId( (String)map.get(ProcessInstanceRemindMeta.SOURCE_NODE_ID));
				this.setTenantId( (String)map.get(ProcessInstanceRemindMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInstanceRemindMeta.DELETE_BY));
				this.setId( (String)map.get(ProcessInstanceRemindMeta.ID));
				this.setTargetNodeId( (String)map.get(ProcessInstanceRemindMeta.TARGET_NODE_ID));
				// others
				this.setTargetNode( (ProcessDefinitionNode)map.get(ProcessInstanceRemindMeta.TARGET_NODE));
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
			this.setProcessInstanceId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.PROCESS_INSTANCE_ID)));
			this.setRemindDate(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.REMIND_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.CONTENT)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindMeta.DELETE_TIME)));
			this.setSourceNodeId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.SOURCE_NODE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.ID)));
			this.setTargetNodeId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindMeta.TARGET_NODE_ID)));
			return true;
		} else {
			try {
				this.setProcessInstanceId( (String)r.getValue(ProcessInstanceRemindMeta.PROCESS_INSTANCE_ID));
				this.setRemindDate( (String)r.getValue(ProcessInstanceRemindMeta.REMIND_DATE));
				this.setUpdateTime( (Date)r.getValue(ProcessInstanceRemindMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ProcessInstanceRemindMeta.VERSION));
				this.setContent( (String)r.getValue(ProcessInstanceRemindMeta.CONTENT));
				this.setValid( (Integer)r.getValue(ProcessInstanceRemindMeta.VALID));
				this.setCreateBy( (String)r.getValue(ProcessInstanceRemindMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessInstanceRemindMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInstanceRemindMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInstanceRemindMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProcessInstanceRemindMeta.DELETE_TIME));
				this.setSourceNodeId( (String)r.getValue(ProcessInstanceRemindMeta.SOURCE_NODE_ID));
				this.setTenantId( (String)r.getValue(ProcessInstanceRemindMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInstanceRemindMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProcessInstanceRemindMeta.ID));
				this.setTargetNodeId( (String)r.getValue(ProcessInstanceRemindMeta.TARGET_NODE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}