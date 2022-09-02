package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_POSITION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 岗位
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:24:55
 * @sign DA6DABFCFB5FBC6E59FAE2212B90EF17
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_position")
public class Position extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_POSITION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属组织ID：所属组织ID
	*/
	@ApiModelProperty(required = false,value="所属组织ID" , notes = "所属组织ID")
	private String orgId;
	
	/**
	 * 岗位代码：岗位代码
	*/
	@ApiModelProperty(required = false,value="岗位代码" , notes = "岗位代码")
	private String code;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = true,value="全称" , notes = "全称")
	private String fullName;
	
	/**
	 * 简称：简称
	*/
	@ApiModelProperty(required = false,value="简称" , notes = "简称")
	private String shortName;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
	/**
	 * 总公司ID：总公司ID
	*/
	@ApiModelProperty(required = false,value="总公司ID" , notes = "总公司ID")
	private String companyId;
	
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
	 * 岗位类型：关联字典 position_type
	*/
	@ApiModelProperty(required = false,value="岗位类型" , notes = "关联字典 position_type")
	private String type;
	
	/**
	 * 所属组织节点：所属组织节点
	*/
	@ApiModelProperty(required = false,value="所属组织节点" , notes = "所属组织节点")
	private Organization organization;
	
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
	public Position setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属组织ID<br>
	 * 所属组织ID
	 * @return 所属组织ID
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 所属组织ID
	 * @param orgId 所属组织ID
	 * @return 当前对象
	*/
	public Position setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 岗位代码<br>
	 * 岗位代码
	 * @return 岗位代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 岗位代码
	 * @param code 岗位代码
	 * @return 当前对象
	*/
	public Position setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 全称<br>
	 * 全称
	 * @return 全称
	*/
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 全称
	 * @param fullName 全称
	 * @return 当前对象
	*/
	public Position setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 获得 简称<br>
	 * 简称
	 * @return 简称
	*/
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * 设置 简称
	 * @param shortName 简称
	 * @return 当前对象
	*/
	public Position setShortName(String shortName) {
		this.shortName=shortName;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public Position setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public Position setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 总公司ID<br>
	 * 总公司ID
	 * @return 总公司ID
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 总公司ID
	 * @param companyId 总公司ID
	 * @return 当前对象
	*/
	public Position setCompanyId(String companyId) {
		this.companyId=companyId;
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
	public Position setTenantId(String tenantId) {
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
	public Position setCreateBy(String createBy) {
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
	public Position setCreateTime(Date createTime) {
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
	public Position setUpdateBy(String updateBy) {
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
	public Position setUpdateTime(Date updateTime) {
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
	public Position setDeleted(Integer deleted) {
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
	public Position setDeleted(Boolean deletedBool) {
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
	public Position setDeleteBy(String deleteBy) {
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
	public Position setDeleteTime(Date deleteTime) {
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
	public Position setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 岗位类型<br>
	 * 关联字典 position_type
	 * @return 岗位类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 岗位类型
	 * @param type 岗位类型
	 * @return 当前对象
	*/
	public Position setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 所属组织节点<br>
	 * 所属组织节点
	 * @return 所属组织节点
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 所属组织节点
	 * @param organization 所属组织节点
	 * @return 当前对象
	*/
	public Position setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Position , 转换好的 Position 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Position , 转换好的 PoJo 对象
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
	public Position clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Position duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.PositionMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.PositionMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setValid(this.getValid());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setShortName(this.getShortName());
		if(all) {
			inst.setOrganization(this.getOrganization());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Position clone(boolean deep) {
		return EntityContext.clone(Position.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Position
	 * @param positionMap 包含实体信息的 Map 对象
	 * @return Position , 转换好的的 Position 对象
	*/
	@Transient
	public static Position createFrom(Map<String,Object> positionMap) {
		if(positionMap==null) return null;
		Position po = EntityContext.create(Position.class, positionMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Position
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Position , 转换好的的 Position 对象
	*/
	@Transient
	public static Position createFrom(Object pojo) {
		if(pojo==null) return null;
		Position po = EntityContext.create(Position.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Position，等同于 new
	 * @return Position 对象
	*/
	@Transient
	public static Position create() {
		return EntityContext.create(Position.class);
	}
}