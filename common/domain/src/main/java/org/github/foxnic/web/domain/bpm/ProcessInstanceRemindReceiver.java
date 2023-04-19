package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INSTANCE_REMIND_RECEIVER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindReceiverMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程实例提醒人员
 * <p>流程实例提醒人员 , 数据表 bpm_process_instance_remind_receiver 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-19 20:30:18
 * @sign D2F936E0EEFC3E3D0947EF27474D1953
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_instance_remind_receiver")
@ApiModel(description = "流程实例提醒人员 ; 流程实例提醒人员 , 数据表 bpm_process_instance_remind_receiver 的PO类型")
public class ProcessInstanceRemindReceiver extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INSTANCE_REMIND_RECEIVER.$TABLE;
	
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
	private String remindId;
	
	/**
	 * 需要提醒的接收人ID：需要提醒的接收人ID
	*/
	@ApiModelProperty(required = false,value="需要提醒的接收人ID" , notes = "需要提醒的接收人ID")
	private String receiverId;
	
	/**
	 * 接收人类型：接收人类型
	*/
	@ApiModelProperty(required = false,value="接收人类型" , notes = "接收人类型")
	private String receiverType;
	@Transient
	@EnumFor("receiverType")
	private UnifiedUserType receiverTypeEnum;
	
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
	public ProcessInstanceRemindReceiver setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程实例ID<br>
	 * 流程实例ID
	 * @return 流程实例ID
	*/
	public String getRemindId() {
		return remindId;
	}
	
	/**
	 * 设置 流程实例ID
	 * @param remindId 流程实例ID
	 * @return 当前对象
	*/
	public ProcessInstanceRemindReceiver setRemindId(String remindId) {
		this.remindId=remindId;
		return this;
	}
	
	/**
	 * 获得 需要提醒的接收人ID<br>
	 * 需要提醒的接收人ID
	 * @return 需要提醒的接收人ID
	*/
	public String getReceiverId() {
		return receiverId;
	}
	
	/**
	 * 设置 需要提醒的接收人ID
	 * @param receiverId 需要提醒的接收人ID
	 * @return 当前对象
	*/
	public ProcessInstanceRemindReceiver setReceiverId(String receiverId) {
		this.receiverId=receiverId;
		return this;
	}
	
	/**
	 * 获得 接收人类型<br>
	 * 接收人类型
	 * @return 接收人类型
	*/
	public String getReceiverType() {
		return receiverType;
	}
	
	/**
	 * 获得 接收人类型 的投影属性<br>
	 * 等价于 getReceiverType 方法，获得对应的枚举类型
	 * @return 接收人类型
	*/
	@Transient
	public UnifiedUserType getReceiverTypeEnum() {
		if(this.receiverTypeEnum==null) {
			this.receiverTypeEnum = (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),receiverType);
		}
		return this.receiverTypeEnum ;
	}
	
	/**
	 * 设置 接收人类型
	 * @param receiverType 接收人类型
	 * @return 当前对象
	*/
	@JsonProperty("receiverType")
	public ProcessInstanceRemindReceiver setReceiverType(String receiverType) {
		this.receiverType=receiverType;
		this.receiverTypeEnum= (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),receiverType) ;
		if(StringUtil.hasContent(receiverType) && this.receiverTypeEnum==null) {
			throw new IllegalArgumentException( receiverType + " is not one of UnifiedUserType");
		}
		return this;
	}
	
	/**
	 * 设置 接收人类型的投影属性，等同于设置 接收人类型
	 * @param receiverTypeEnum 接收人类型
	 * @return 当前对象
	*/
	@Transient
	public ProcessInstanceRemindReceiver setReceiverTypeEnum(UnifiedUserType receiverTypeEnum) {
		if(receiverTypeEnum==null) {
			this.setReceiverType(null);
		} else {
			this.setReceiverType(receiverTypeEnum.code());
		}
		this.receiverTypeEnum=receiverTypeEnum;
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
	public ProcessInstanceRemindReceiver setTenantId(String tenantId) {
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
	public ProcessInstanceRemindReceiver setCreateBy(String createBy) {
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
	public ProcessInstanceRemindReceiver setCreateTime(Date createTime) {
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
	public ProcessInstanceRemindReceiver setUpdateBy(String updateBy) {
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
	public ProcessInstanceRemindReceiver setUpdateTime(Date updateTime) {
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
	public ProcessInstanceRemindReceiver setDeleted(Integer deleted) {
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
	public ProcessInstanceRemindReceiver setDeleted(Boolean deletedBool) {
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
	public ProcessInstanceRemindReceiver setDeleteBy(String deleteBy) {
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
	public ProcessInstanceRemindReceiver setDeleteTime(Date deleteTime) {
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
	public ProcessInstanceRemindReceiver setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessInstanceRemindReceiver , 转换好的 ProcessInstanceRemindReceiver 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInstanceRemindReceiver , 转换好的 PoJo 对象
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
	public ProcessInstanceRemindReceiver clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInstanceRemindReceiver duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindReceiverMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindReceiverMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setReceiverId(this.getReceiverId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRemindId(this.getRemindId());
		inst.setReceiverType(this.getReceiverType());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInstanceRemindReceiver clone(boolean deep) {
		return EntityContext.clone(ProcessInstanceRemindReceiver.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInstanceRemindReceiver
	 * @param processInstanceRemindReceiverMap 包含实体信息的 Map 对象
	 * @return ProcessInstanceRemindReceiver , 转换好的的 ProcessInstanceRemindReceiver 对象
	*/
	@Transient
	public static ProcessInstanceRemindReceiver createFrom(Map<String,Object> processInstanceRemindReceiverMap) {
		if(processInstanceRemindReceiverMap==null) return null;
		ProcessInstanceRemindReceiver po = create();
		EntityContext.copyProperties(po,processInstanceRemindReceiverMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessInstanceRemindReceiver
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInstanceRemindReceiver , 转换好的的 ProcessInstanceRemindReceiver 对象
	*/
	@Transient
	public static ProcessInstanceRemindReceiver createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInstanceRemindReceiver po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProcessInstanceRemindReceiver，等同于 new
	 * @return ProcessInstanceRemindReceiver 对象
	*/
	@Transient
	public static ProcessInstanceRemindReceiver create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInstanceRemindReceiverMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindReceiverMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindReceiverMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.CREATE_BY)));
			this.setReceiverId(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.RECEIVER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInstanceRemindReceiverMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindReceiverMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInstanceRemindReceiverMeta.DELETE_TIME)));
			this.setRemindId(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.REMIND_ID)));
			this.setReceiverType(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.RECEIVER_TYPE)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInstanceRemindReceiverMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(ProcessInstanceRemindReceiverMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ProcessInstanceRemindReceiverMeta.VERSION));
				this.setCreateBy( (String)map.get(ProcessInstanceRemindReceiverMeta.CREATE_BY));
				this.setReceiverId( (String)map.get(ProcessInstanceRemindReceiverMeta.RECEIVER_ID));
				this.setDeleted( (Integer)map.get(ProcessInstanceRemindReceiverMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInstanceRemindReceiverMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProcessInstanceRemindReceiverMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProcessInstanceRemindReceiverMeta.DELETE_TIME));
				this.setRemindId( (String)map.get(ProcessInstanceRemindReceiverMeta.REMIND_ID));
				this.setReceiverType( (String)map.get(ProcessInstanceRemindReceiverMeta.RECEIVER_TYPE));
				this.setTenantId( (String)map.get(ProcessInstanceRemindReceiverMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInstanceRemindReceiverMeta.DELETE_BY));
				this.setId( (String)map.get(ProcessInstanceRemindReceiverMeta.ID));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindReceiverMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindReceiverMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.CREATE_BY)));
			this.setReceiverId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.RECEIVER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInstanceRemindReceiverMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindReceiverMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInstanceRemindReceiverMeta.DELETE_TIME)));
			this.setRemindId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.REMIND_ID)));
			this.setReceiverType(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.RECEIVER_TYPE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInstanceRemindReceiverMeta.ID)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(ProcessInstanceRemindReceiverMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ProcessInstanceRemindReceiverMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProcessInstanceRemindReceiverMeta.CREATE_BY));
				this.setReceiverId( (String)r.getValue(ProcessInstanceRemindReceiverMeta.RECEIVER_ID));
				this.setDeleted( (Integer)r.getValue(ProcessInstanceRemindReceiverMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInstanceRemindReceiverMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInstanceRemindReceiverMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProcessInstanceRemindReceiverMeta.DELETE_TIME));
				this.setRemindId( (String)r.getValue(ProcessInstanceRemindReceiverMeta.REMIND_ID));
				this.setReceiverType( (String)r.getValue(ProcessInstanceRemindReceiverMeta.RECEIVER_TYPE));
				this.setTenantId( (String)r.getValue(ProcessInstanceRemindReceiverMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInstanceRemindReceiverMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProcessInstanceRemindReceiverMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}