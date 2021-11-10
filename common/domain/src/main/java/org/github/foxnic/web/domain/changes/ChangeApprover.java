package org.github.foxnic.web.domain.changes;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_APPROVER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import javax.persistence.Transient;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 变更单据关系
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-23 14:31:42
 * @sign 7CF46A188E1F530C0FC2AB9EEE0263D9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "chs_change_approver")
public class ChangeApprover extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CHS_CHANGE_APPROVER.$TABLE;

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
	 * 变更实例ID：变更实例ID
	*/
	@ApiModelProperty(required = false,value="变更实例ID" , notes = "变更实例ID")
	private String instanceId;

	/**
	 * 审批人ID：审批人ID
	*/
	@ApiModelProperty(required = false,value="审批人ID" , notes = "审批人ID")
	private String approverId;

	/**
	 * 审批人类型：参考枚举 ApproverType
	*/
	@ApiModelProperty(required = false,value="审批人类型" , notes = "参考枚举 ApproverType")
	private String approverType;
	@Transient
	private UnifiedUserType approverTypeEnum;

	/**
	 * 节点ID：节点ID
	*/
	@ApiModelProperty(required = false,value="节点ID" , notes = "节点ID")
	private String nodeId;

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
	public ChangeApprover setId(String id) {
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
	public ChangeApprover setDefinitionId(String definitionId) {
		this.definitionId=definitionId;
		return this;
	}

	/**
	 * 获得 变更实例ID<br>
	 * 变更实例ID
	 * @return 变更实例ID
	*/
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * 设置 变更实例ID
	 * @param instanceId 变更实例ID
	 * @return 当前对象
	*/
	public ChangeApprover setInstanceId(String instanceId) {
		this.instanceId=instanceId;
		return this;
	}

	/**
	 * 获得 审批人ID<br>
	 * 审批人ID
	 * @return 审批人ID
	*/
	public String getApproverId() {
		return approverId;
	}

	/**
	 * 设置 审批人ID
	 * @param approverId 审批人ID
	 * @return 当前对象
	*/
	public ChangeApprover setApproverId(String approverId) {
		this.approverId=approverId;
		return this;
	}

	/**
	 * 获得 审批人类型<br>
	 * 参考枚举 ApproverType
	 * @return 审批人类型
	*/
	public String getApproverType() {
		return approverType;
	}

	/**
	 * 获得 审批人类型 的投影属性<br>
	 * 等价于 getApproverType 方法，获得对应的枚举类型
	 * @return 审批人类型
	*/
	@Transient
	public UnifiedUserType getApproverTypeEnum() {
		if(this.approverTypeEnum==null) {
			this.approverTypeEnum = (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),approverType);
		}
		return this.approverTypeEnum ;
	}

	/**
	 * 设置 审批人类型
	 * @param approverType 审批人类型
	 * @return 当前对象
	*/
	public ChangeApprover setApproverType(String approverType) {
		this.approverType=approverType;
		this.approverTypeEnum= (UnifiedUserType) EnumUtil.parseByCode(UnifiedUserType.values(),approverType) ;
		if(StringUtil.hasContent(approverType) && this.approverTypeEnum==null) {
			throw new IllegalArgumentException( approverType + " is not one of ApproverType");
		}
		return this;
	}

	/**
	 * 设置 审批人类型的投影属性，等同于设置 审批人类型
	 * @param approverTypeEnum 审批人类型
	 * @return 当前对象
	*/
	@Transient
	public ChangeApprover setApproverTypeEnum(UnifiedUserType approverTypeEnum) {
		if(approverTypeEnum==null) {
			this.setApproverType(null);
		} else {
			this.setApproverType(approverTypeEnum.code());
		}
		this.approverTypeEnum=approverTypeEnum;
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
	public ChangeApprover setNodeId(String nodeId) {
		this.nodeId=nodeId;
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
	public ChangeApprover setCreateBy(String createBy) {
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
	public ChangeApprover setCreateTime(Date createTime) {
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
	public ChangeApprover setUpdateBy(String updateBy) {
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
	public ChangeApprover setUpdateTime(Date updateTime) {
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
	public ChangeApprover setDeleted(Integer deleted) {
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
	public ChangeApprover setDeleteBy(String deleteBy) {
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
	public ChangeApprover setDeleteTime(Date deleteTime) {
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
	public ChangeApprover setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ChangeApprover , 转换好的 ChangeApprover 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ChangeApprover , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ChangeApprover
	 * @param changeApproverMap 包含实体信息的 Map 对象
	 * @return ChangeApprover , 转换好的的 ChangeApprover 对象
	*/
	@Transient
	public static ChangeApprover createFrom(Map<String,Object> changeApproverMap) {
		if(changeApproverMap==null) return null;
		ChangeApprover po = EntityContext.create(ChangeApprover.class, changeApproverMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ChangeApprover
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ChangeApprover , 转换好的的 ChangeApprover 对象
	*/
	@Transient
	public static ChangeApprover createFrom(Object pojo) {
		if(pojo==null) return null;
		ChangeApprover po = EntityContext.create(ChangeApprover.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ChangeApprover，等同于 new
	 * @return ChangeApprover 对象
	*/
	@Transient
	public static ChangeApprover create() {
		return EntityContext.create(ChangeApprover.class);
	}
}
