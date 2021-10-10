package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import javax.persistence.Transient;
import java.util.Date;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 变更实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-10 13:32:40
 * @sign 28FF5AA328387E83F6D41F2F9C2B76BB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_instance")
public class ChangeInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_INSTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 变更定义ID：变更定义ID
	*/
	@ApiModelProperty(required = false,value="变更定义ID" , notes = "变更定义ID")
	private String definitionId;
	
	/**
	 * 审批模式：审批模式
	*/
	@ApiModelProperty(required = false,value="审批模式" , notes = "审批模式")
	private String mode;
	@Transient
	private ApprovalMode modeEnum;
	
	/**
	 * 起草人ID：起草人ID
	*/
	@ApiModelProperty(required = false,value="起草人ID" , notes = "起草人ID")
	private String drafterId;
	
	/**
	 * 起草人姓名：起草人姓名
	*/
	@ApiModelProperty(required = false,value="起草人姓名" , notes = "起草人姓名")
	private String drafterName;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = true,value="租户ID" , notes = "租户ID")
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
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String status;
	@Transient
	private ApprovalStatus statusEnum;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String type;
	@Transient
	private ChangeType typeEnum;
	
	/**
	 * 流程ID：流程ID
	*/
	@ApiModelProperty(required = false,value="流程ID" , notes = "流程ID")
	private String processId;
	
	/**
	 * 当前审批节点：对于当前审批节点的描述性信息
	*/
	@ApiModelProperty(required = false,value="当前审批节点" , notes = "对于当前审批节点的描述性信息")
	private String processNodeSummary;
	
	/**
	 * 流程概要：针对流程审批的概要描述
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "针对流程审批的概要描述")
	private String processSummary;
	
	/**
	 * 变更开始时间：变更开始时间
	*/
	@ApiModelProperty(required = false,value="变更开始时间" , notes = "变更开始时间")
	private Date startTime;
	
	/**
	 * 变更结束时间：变更结束时间
	*/
	@ApiModelProperty(required = false,value="变更结束时间" , notes = "变更结束时间")
	private Date finishTime;
	
	/**
	 * 下一个审批节点审批人账户ID：用逗号隔开,适用简单模式
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人账户ID" , notes = "用逗号隔开,适用简单模式")
	private String simpleNextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开,适用简单模式
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开,适用简单模式")
	private String simpleNextApproverNames;
	
	/**
	 * 简单模式的节点ID：简单模式的节点ID
	*/
	@ApiModelProperty(required = false,value="简单模式的节点ID" , notes = "简单模式的节点ID")
	private String simpleNodeId;
	
	/**
	 * 变更前的数据：变更前的数据
	*/
	@ApiModelProperty(required = false,value="变更前的数据" , notes = "变更前的数据")
	private ChangeData dataBefore;
	
	/**
	 * 变更后的数据：变更后的数据
	*/
	@ApiModelProperty(required = false,value="变更后的数据" , notes = "变更后的数据")
	private ChangeData dataAfter;
	
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
	public ChangeInstance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 变更定义ID<br>
	 * 变更定义ID
	 * @return 变更定义ID
	*/
	public String getDefinitionId() {
		return definitionId;
	}
	
	/**
	 * 设置 变更定义ID
	 * @param definitionId 变更定义ID
	 * @return 当前对象
	*/
	public ChangeInstance setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
		return this;
	}
	
	/**
	 * 获得 审批模式<br>
	 * 审批模式
	 * @return 审批模式
	*/
	public String getMode() {
		return mode;
	}
	
	/**
	 * 获得 审批模式 的投影属性<br>
	 * 等价于 getMode 方法，获得对应的枚举类型
	 * @return 审批模式
	*/
	@Transient
	public ApprovalMode getModeEnum() {
		if(this.modeEnum==null) {
			this.modeEnum = (ApprovalMode) EnumUtil.parseByCode(ApprovalMode.values(),mode);
		}
		return this.modeEnum ;
	}
	
	/**
	 * 设置 审批模式
	 * @param mode 审批模式
	 * @return 当前对象
	*/
	public ChangeInstance setMode(String mode) {
		this.mode=mode;
		this.modeEnum= (ApprovalMode) EnumUtil.parseByCode(ApprovalMode.values(),mode) ;
		if(StringUtil.hasContent(mode) && this.modeEnum==null) {
			throw new IllegalArgumentException( mode + " is not one of ApprovalMode");
		}
		return this;
	}
	
	/**
	 * 设置 审批模式的投影属性，等同于设置 审批模式
	 * @param modeEnum 审批模式
	 * @return 当前对象
	*/
	@Transient
	public ChangeInstance setModeEnum(ApprovalMode modeEnum) {
		if(modeEnum==null) {
			this.setMode(null);
		} else {
			this.setMode(modeEnum.code());
		}
		this.modeEnum=modeEnum;
		return this;
	}
	
	/**
	 * 获得 起草人ID<br>
	 * 起草人ID
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
	public ChangeInstance setDrafterId(String drafterId) {
		this.drafterId=drafterId;
		return this;
	}
	
	/**
	 * 获得 起草人姓名<br>
	 * 起草人姓名
	 * @return 起草人姓名
	*/
	public String getDrafterName() {
		return drafterName;
	}
	
	/**
	 * 设置 起草人姓名
	 * @param drafterName 起草人姓名
	 * @return 当前对象
	*/
	public ChangeInstance setDrafterName(String drafterName) {
		this.drafterName=drafterName;
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
	public ChangeInstance setTenantId(String tenantId) {
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
	public ChangeInstance setCreateBy(String createBy) {
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
	public ChangeInstance setCreateTime(Date createTime) {
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
	public ChangeInstance setUpdateBy(String updateBy) {
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
	public ChangeInstance setUpdateTime(Date updateTime) {
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
	public ChangeInstance setDeleted(Integer deleted) {
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
	public ChangeInstance setDeleteBy(String deleteBy) {
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
	public ChangeInstance setDeleteTime(Date deleteTime) {
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
	public ChangeInstance setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 获得 变更状态 的投影属性<br>
	 * 等价于 getStatus 方法，获得对应的枚举类型
	 * @return 变更状态
	*/
	@Transient
	public ApprovalStatus getStatusEnum() {
		if(this.statusEnum==null) {
			this.statusEnum = (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),status);
		}
		return this.statusEnum ;
	}
	
	/**
	 * 设置 变更状态
	 * @param status 变更状态
	 * @return 当前对象
	*/
	public ChangeInstance setStatus(String status) {
		this.status=status;
		this.statusEnum= (ApprovalStatus) EnumUtil.parseByCode(ApprovalStatus.values(),status) ;
		if(StringUtil.hasContent(status) && this.statusEnum==null) {
			throw new IllegalArgumentException( status + " is not one of ApprovalStatus");
		}
		return this;
	}
	
	/**
	 * 设置 变更状态的投影属性，等同于设置 变更状态
	 * @param statusEnum 变更状态
	 * @return 当前对象
	*/
	@Transient
	public ChangeInstance setStatusEnum(ApprovalStatus statusEnum) {
		if(statusEnum==null) {
			this.setStatus(null);
		} else {
			this.setStatus(statusEnum.code());
		}
		this.statusEnum=statusEnum;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 变更类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 变更类型
	*/
	@Transient
	public ChangeType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (ChangeType) EnumUtil.parseByCode(ChangeType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 变更类型
	 * @param type 变更类型
	 * @return 当前对象
	*/
	public ChangeInstance setType(String type) {
		this.type=type;
		this.typeEnum= (ChangeType) EnumUtil.parseByCode(ChangeType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of ChangeType");
		}
		return this;
	}
	
	/**
	 * 设置 变更类型的投影属性，等同于设置 变更类型
	 * @param typeEnum 变更类型
	 * @return 当前对象
	*/
	@Transient
	public ChangeInstance setTypeEnum(ChangeType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 流程ID<br>
	 * 流程ID
	 * @return 流程ID
	*/
	public String getProcessId() {
		return processId;
	}
	
	/**
	 * 设置 流程ID
	 * @param processId 流程ID
	 * @return 当前对象
	*/
	public ChangeInstance setProcessId(String processId) {
		this.processId=processId;
		return this;
	}
	
	/**
	 * 获得 当前审批节点<br>
	 * 对于当前审批节点的描述性信息
	 * @return 当前审批节点
	*/
	public String getProcessNodeSummary() {
		return processNodeSummary;
	}
	
	/**
	 * 设置 当前审批节点
	 * @param processNodeSummary 当前审批节点
	 * @return 当前对象
	*/
	public ChangeInstance setProcessNodeSummary(String processNodeSummary) {
		this.processNodeSummary=processNodeSummary;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 针对流程审批的概要描述
	 * @return 流程概要
	*/
	public String getProcessSummary() {
		return processSummary;
	}
	
	/**
	 * 设置 流程概要
	 * @param processSummary 流程概要
	 * @return 当前对象
	*/
	public ChangeInstance setProcessSummary(String processSummary) {
		this.processSummary=processSummary;
		return this;
	}
	
	/**
	 * 获得 变更开始时间<br>
	 * 变更开始时间
	 * @return 变更开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 变更开始时间
	 * @param startTime 变更开始时间
	 * @return 当前对象
	*/
	public ChangeInstance setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 变更结束时间<br>
	 * 变更结束时间
	 * @return 变更结束时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 变更结束时间
	 * @param finishTime 变更结束时间
	 * @return 当前对象
	*/
	public ChangeInstance setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人账户ID<br>
	 * 用逗号隔开,适用简单模式
	 * @return 下一个审批节点审批人账户ID
	*/
	public String getSimpleNextApproverIds() {
		return simpleNextApproverIds;
	}
	
	/**
	 * 设置 下一个审批节点审批人账户ID
	 * @param simpleNextApproverIds 下一个审批节点审批人账户ID
	 * @return 当前对象
	*/
	public ChangeInstance setSimpleNextApproverIds(String simpleNextApproverIds) {
		this.simpleNextApproverIds=simpleNextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开,适用简单模式
	 * @return 下一个审批节点审批人姓名
	*/
	public String getSimpleNextApproverNames() {
		return simpleNextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param simpleNextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public ChangeInstance setSimpleNextApproverNames(String simpleNextApproverNames) {
		this.simpleNextApproverNames=simpleNextApproverNames;
		return this;
	}
	
	/**
	 * 获得 简单模式的节点ID<br>
	 * 简单模式的节点ID
	 * @return 简单模式的节点ID
	*/
	public String getSimpleNodeId() {
		return simpleNodeId;
	}
	
	/**
	 * 设置 简单模式的节点ID
	 * @param simpleNodeId 简单模式的节点ID
	 * @return 当前对象
	*/
	public ChangeInstance setSimpleNodeId(String simpleNodeId) {
		this.simpleNodeId=simpleNodeId;
		return this;
	}
	
	/**
	 * 获得 变更前的数据<br>
	 * 变更前的数据
	 * @return 变更前的数据
	*/
	public ChangeData getDataBefore() {
		return dataBefore;
	}
	
	/**
	 * 设置 变更前的数据
	 * @param dataBefore 变更前的数据
	 * @return 当前对象
	*/
	public ChangeInstance setDataBefore(ChangeData dataBefore) {
		this.dataBefore=dataBefore;
		return this;
	}
	
	/**
	 * 获得 变更后的数据<br>
	 * 变更后的数据
	 * @return 变更后的数据
	*/
	public ChangeData getDataAfter() {
		return dataAfter;
	}
	
	/**
	 * 设置 变更后的数据
	 * @param dataAfter 变更后的数据
	 * @return 当前对象
	*/
	public ChangeInstance setDataAfter(ChangeData dataAfter) {
		this.dataAfter=dataAfter;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeInstance , 转换好的 ChangeInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeInstance , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeInstance
	 * @param changeInstanceMap 包含实体信息的 Map 对象
	 * @return ChangeInstance , 转换好的的 ChangeInstance 对象
	*/
	@Transient
	public static ChangeInstance createFrom(Map<String,Object> changeInstanceMap) {
		if(changeInstanceMap==null) return null;
		ChangeInstance po = EntityContext.create(ChangeInstance.class, changeInstanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeInstance , 转换好的的 ChangeInstance 对象
	*/
	@Transient
	public static ChangeInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeInstance po = EntityContext.create(ChangeInstance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeInstance，等同于 new
	 * @return ChangeInstance 对象
	*/
	@Transient
	public static ChangeInstance create() {
		return EntityContext.create(ChangeInstance.class);
	}
}