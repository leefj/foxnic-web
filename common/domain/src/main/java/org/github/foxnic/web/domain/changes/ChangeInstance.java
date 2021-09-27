package org.github.foxnic.web.domain.changes;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.sql.meta.DBTable;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.db.FoxnicWeb.CHS_CHANGE_INSTANCE;
import org.github.foxnic.web.constants.enums.changes.ChangeStatus;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Map;



/**
 * 变更实例
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-27 17:36:54
 * @sign 8452C649CECFDA30595A045A1C7D77FE
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
	 * 变更对象的数据表：变更对象的数据表
	*/
	@ApiModelProperty(required = false,value="变更对象的数据表" , notes = "变更对象的数据表")
	private String targetTable;
	
	/**
	 * 变更对象类型：变更对象类型
	*/
	@ApiModelProperty(required = false,value="变更对象类型" , notes = "变更对象类型")
	private String targetType;
	
	/**
	 * 变更对象ID：变更对象ID
	*/
	@ApiModelProperty(required = false,value="变更对象ID" , notes = "变更对象ID")
	private Integer targetId;
	
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
	private ChangeStatus statusEnum;
	
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
	 * 获得 变更对象的数据表<br>
	 * 变更对象的数据表
	 * @return 变更对象的数据表
	*/
	public String getTargetTable() {
		return targetTable;
	}
	
	/**
	 * 设置 变更对象的数据表
	 * @param targetTable 变更对象的数据表
	 * @return 当前对象
	*/
	public ChangeInstance setTargetTable(String targetTable) {
		this.targetTable=targetTable;
		return this;
	}
	
	/**
	 * 获得 变更对象类型<br>
	 * 变更对象类型
	 * @return 变更对象类型
	*/
	public String getTargetType() {
		return targetType;
	}
	
	/**
	 * 设置 变更对象类型
	 * @param targetType 变更对象类型
	 * @return 当前对象
	*/
	public ChangeInstance setTargetType(String targetType) {
		this.targetType=targetType;
		return this;
	}
	
	/**
	 * 获得 变更对象ID<br>
	 * 变更对象ID
	 * @return 变更对象ID
	*/
	public Integer getTargetId() {
		return targetId;
	}
	
	/**
	 * 设置 变更对象ID
	 * @param targetId 变更对象ID
	 * @return 当前对象
	*/
	public ChangeInstance setTargetId(Integer targetId) {
		this.targetId=targetId;
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
	@Transient
	public ChangeStatus getStatusEnum() {
		return statusEnum ;
	}
	
	/**
	 * 设置 变更状态
	 * @param status 变更状态
	 * @return 当前对象
	*/
	public ChangeInstance setStatus(String status) {
		this.status=status;
		this.statusEnum= (ChangeStatus) EnumUtil.parseByCode(ChangeStatus.values(),status) ;
		if(StringUtil.hasContent(status) && this.status==null) {
			throw new IllegalArgumentException("");
		}
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