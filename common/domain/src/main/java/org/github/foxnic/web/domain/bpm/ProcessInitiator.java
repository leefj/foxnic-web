package org.github.foxnic.web.domain.bpm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.BPM_PROCESS_INITIATOR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.oauth.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.bpm.meta.ProcessInitiatorMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程发起人权限
 * <p>流程发起人权限 , 数据表 bpm_process_initiator 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-23 15:57:21
 * @sign 409AA892F8546EDB115A7C4D5078FE39
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "bpm_process_initiator")
@ApiModel(description = "流程发起人权限 ; 流程发起人权限 , 数据表 bpm_process_initiator 的PO类型")
public class ProcessInitiator extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =BPM_PROCESS_INITIATOR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 流程定义ID：流程定义ID
	*/
	@ApiModelProperty(required = false,value="流程定义ID" , notes = "流程定义ID")
	private String definitionId;
	
	/**
	 * 发起人ID：发起人ID
	*/
	@ApiModelProperty(required = false,value="发起人ID" , notes = "发起人ID")
	private String initiatorId;
	
	/**
	 * 发起类型：参考枚举 InitiatorType
	*/
	@ApiModelProperty(required = false,value="发起类型" , notes = "参考枚举 InitiatorType")
	private String initiatorType;
	
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
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
	/**
	 * 最后修改人：最后修改人
	*/
	@ApiModelProperty(required = false,value="最后修改人" , notes = "最后修改人")
	private User lastUpdateUser;
	
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
	public ProcessInitiator setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 流程定义ID<br>
	 * 流程定义ID
	 * @return 流程定义ID
	*/
	public String getDefinitionId() {
		return definitionId;
	}
	
	/**
	 * 设置 流程定义ID
	 * @param definitionId 流程定义ID
	 * @return 当前对象
	*/
	public ProcessInitiator setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
		return this;
	}
	
	/**
	 * 获得 发起人ID<br>
	 * 发起人ID
	 * @return 发起人ID
	*/
	public String getInitiatorId() {
		return initiatorId;
	}
	
	/**
	 * 设置 发起人ID
	 * @param initiatorId 发起人ID
	 * @return 当前对象
	*/
	public ProcessInitiator setInitiatorId(String initiatorId) {
		this.initiatorId=initiatorId;
		return this;
	}
	
	/**
	 * 获得 发起类型<br>
	 * 参考枚举 InitiatorType
	 * @return 发起类型
	*/
	public String getInitiatorType() {
		return initiatorType;
	}
	
	/**
	 * 设置 发起类型
	 * @param initiatorType 发起类型
	 * @return 当前对象
	*/
	public ProcessInitiator setInitiatorType(String initiatorType) {
		this.initiatorType=initiatorType;
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
	public ProcessInitiator setCreateBy(String createBy) {
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
	public ProcessInitiator setCreateTime(Date createTime) {
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
	public ProcessInitiator setUpdateBy(String updateBy) {
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
	public ProcessInitiator setUpdateTime(Date updateTime) {
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
	public ProcessInitiator setDeleted(Integer deleted) {
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
	public ProcessInitiator setDeleted(Boolean deletedBool) {
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
	public ProcessInitiator setDeleteBy(String deleteBy) {
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
	public ProcessInitiator setDeleteTime(Date deleteTime) {
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
	public ProcessInitiator setVersion(Integer version) {
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
	public ProcessInitiator setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 最后修改人<br>
	 * 最后修改人
	 * @return 最后修改人
	*/
	public User getLastUpdateUser() {
		return lastUpdateUser;
	}
	
	/**
	 * 设置 最后修改人
	 * @param lastUpdateUser 最后修改人
	 * @return 当前对象
	*/
	public ProcessInitiator setLastUpdateUser(User lastUpdateUser) {
		this.lastUpdateUser=lastUpdateUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProcessInitiator , 转换好的 ProcessInitiator 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProcessInitiator , 转换好的 PoJo 对象
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
	public ProcessInitiator clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProcessInitiator duplicate(boolean all) {
		org.github.foxnic.web.domain.bpm.meta.ProcessInitiatorMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.bpm.meta.ProcessInitiatorMeta.$$proxy$$();
		inst.setInitiatorId(this.getInitiatorId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setDefinitionId(this.getDefinitionId());
		inst.setInitiatorType(this.getInitiatorType());
		if(all) {
			inst.setLastUpdateUser(this.getLastUpdateUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProcessInitiator clone(boolean deep) {
		return EntityContext.clone(ProcessInitiator.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProcessInitiator
	 * @param processInitiatorMap 包含实体信息的 Map 对象
	 * @return ProcessInitiator , 转换好的的 ProcessInitiator 对象
	*/
	@Transient
	public static ProcessInitiator createFrom(Map<String,Object> processInitiatorMap) {
		if(processInitiatorMap==null) return null;
		ProcessInitiator po = create();
		EntityContext.copyProperties(po,processInitiatorMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProcessInitiator
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProcessInitiator , 转换好的的 ProcessInitiator 对象
	*/
	@Transient
	public static ProcessInitiator createFrom(Object pojo) {
		if(pojo==null) return null;
		ProcessInitiator po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProcessInitiator，等同于 new
	 * @return ProcessInitiator 对象
	*/
	@Transient
	public static ProcessInitiator create() {
		return new org.github.foxnic.web.domain.bpm.meta.ProcessInitiatorMeta.$$proxy$$();
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
			this.setInitiatorId(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.INITIATOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProcessInitiatorMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProcessInitiatorMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProcessInitiatorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProcessInitiatorMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProcessInitiatorMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.ID)));
			this.setDefinitionId(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.DEFINITION_ID)));
			this.setInitiatorType(DataParser.parse(String.class, map.get(ProcessInitiatorMeta.INITIATOR_TYPE)));
			// others
			this.setLastUpdateUser(DataParser.parse(User.class, map.get(ProcessInitiatorMeta.LAST_UPDATE_USER)));
			return true;
		} else {
			try {
				this.setInitiatorId( (String)map.get(ProcessInitiatorMeta.INITIATOR_ID));
				this.setUpdateTime( (Date)map.get(ProcessInitiatorMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ProcessInitiatorMeta.VERSION));
				this.setCreateBy( (String)map.get(ProcessInitiatorMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProcessInitiatorMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProcessInitiatorMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProcessInitiatorMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProcessInitiatorMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ProcessInitiatorMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProcessInitiatorMeta.DELETE_BY));
				this.setId( (String)map.get(ProcessInitiatorMeta.ID));
				this.setDefinitionId( (String)map.get(ProcessInitiatorMeta.DEFINITION_ID));
				this.setInitiatorType( (String)map.get(ProcessInitiatorMeta.INITIATOR_TYPE));
				// others
				this.setLastUpdateUser( (User)map.get(ProcessInitiatorMeta.LAST_UPDATE_USER));
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
			this.setInitiatorId(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.INITIATOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProcessInitiatorMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProcessInitiatorMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProcessInitiatorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProcessInitiatorMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProcessInitiatorMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.ID)));
			this.setDefinitionId(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.DEFINITION_ID)));
			this.setInitiatorType(DataParser.parse(String.class, r.getValue(ProcessInitiatorMeta.INITIATOR_TYPE)));
			return true;
		} else {
			try {
				this.setInitiatorId( (String)r.getValue(ProcessInitiatorMeta.INITIATOR_ID));
				this.setUpdateTime( (Date)r.getValue(ProcessInitiatorMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ProcessInitiatorMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProcessInitiatorMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProcessInitiatorMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProcessInitiatorMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProcessInitiatorMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProcessInitiatorMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ProcessInitiatorMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProcessInitiatorMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProcessInitiatorMeta.ID));
				this.setDefinitionId( (String)r.getValue(ProcessInitiatorMeta.DEFINITION_ID));
				this.setInitiatorType( (String)r.getValue(ProcessInitiatorMeta.INITIATOR_TYPE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}