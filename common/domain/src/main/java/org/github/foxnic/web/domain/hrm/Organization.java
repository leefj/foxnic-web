package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_ORGANIZATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.hrm.meta.OrganizationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 组织层级
 * <p>组织层级 , 数据表 hrm_organization 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:47:50
 * @sign 54E943D72D5BF01666E9630E108B8E36
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_organization")
@ApiModel(description = "组织层级 ; 组织层级 , 数据表 hrm_organization 的PO类型")
public class Organization extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_ORGANIZATION.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "2")
	private String id;
	
	/**
	 * 代码：代码
	*/
	@ApiModelProperty(required = false,value="代码" , notes = "代码" , example = "localCompany")
	private String code;
	
	/**
	 * 简称：简称
	*/
	@ApiModelProperty(required = false,value="简称" , notes = "简称" , example = "集团总部")
	private String shortName;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = true,value="全称" , notes = "全称" , example = "集团总部")
	private String fullName;
	
	/**
	 * 组织类型：公司(com)或部门(dept)
	*/
	@ApiModelProperty(required = true,value="组织类型" , notes = "公司(com)或部门(dept)" , example = "com")
	private String type;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID" , example = "0")
	private String parentId;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
	/**
	 * 层级路径：层级路径
	*/
	@ApiModelProperty(required = false,value="层级路径" , notes = "层级路径" , example = "2")
	private String hierarchy;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "1")
	private Integer sort;
	
	/**
	 * 总公司ID：总公司ID
	*/
	@ApiModelProperty(required = false,value="总公司ID" , notes = "总公司ID" , example = "002")
	private String companyId;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID" , example = "T001")
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-10-08 08:34:26")
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
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2021-09-14 09:36:53")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "41")
	private Integer version;
	
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
	public Organization setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 代码<br>
	 * 代码
	 * @return 代码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 代码
	 * @param code 代码
	 * @return 当前对象
	*/
	public Organization setCode(String code) {
		this.code=code;
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
	public Organization setShortName(String shortName) {
		this.shortName=shortName;
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
	public Organization setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 获得 组织类型<br>
	 * 公司(com)或部门(dept)
	 * @return 组织类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 组织类型
	 * @param type 组织类型
	 * @return 当前对象
	*/
	public Organization setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 上级ID<br>
	 * 上级ID
	 * @return 上级ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	public Organization setParentId(String parentId) {
		this.parentId=parentId;
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
	public Organization setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 层级路径<br>
	 * 层级路径
	 * @return 层级路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 层级路径
	 * @param hierarchy 层级路径
	 * @return 当前对象
	*/
	public Organization setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
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
	public Organization setSort(Integer sort) {
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
	public Organization setCompanyId(String companyId) {
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
	public Organization setTenantId(String tenantId) {
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
	public Organization setCreateBy(String createBy) {
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
	public Organization setCreateTime(Date createTime) {
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
	public Organization setUpdateBy(String updateBy) {
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
	public Organization setUpdateTime(Date updateTime) {
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
	public Organization setDeleted(Integer deleted) {
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
	public Organization setDeleted(Boolean deletedBool) {
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
	public Organization setDeleteBy(String deleteBy) {
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
	public Organization setDeleteTime(Date deleteTime) {
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
	public Organization setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Organization , 转换好的 Organization 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Organization , 转换好的 PoJo 对象
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
	public Organization clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Organization duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.OrganizationMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.OrganizationMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setHierarchy(this.getHierarchy());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
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
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Organization clone(boolean deep) {
		return EntityContext.clone(Organization.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Organization
	 * @param organizationMap 包含实体信息的 Map 对象
	 * @return Organization , 转换好的的 Organization 对象
	*/
	@Transient
	public static Organization createFrom(Map<String,Object> organizationMap) {
		if(organizationMap==null) return null;
		Organization po = create();
		EntityContext.copyProperties(po,organizationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Organization
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Organization , 转换好的的 Organization 对象
	*/
	@Transient
	public static Organization createFrom(Object pojo) {
		if(pojo==null) return null;
		Organization po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Organization，等同于 new
	 * @return Organization 对象
	*/
	@Transient
	public static Organization create() {
		return new org.github.foxnic.web.domain.hrm.meta.OrganizationMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(OrganizationMeta.CODE)));
			this.setHierarchy(DataParser.parse(String.class, map.get(OrganizationMeta.HIERARCHY)));
			this.setFullName(DataParser.parse(String.class, map.get(OrganizationMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(OrganizationMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(OrganizationMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(OrganizationMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(OrganizationMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(OrganizationMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(OrganizationMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, map.get(OrganizationMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(OrganizationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(OrganizationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(OrganizationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(OrganizationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(OrganizationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(OrganizationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(OrganizationMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(OrganizationMeta.ID)));
			this.setShortName(DataParser.parse(String.class, map.get(OrganizationMeta.SHORT_NAME)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(OrganizationMeta.CODE));
				this.setHierarchy( (String)map.get(OrganizationMeta.HIERARCHY));
				this.setFullName( (String)map.get(OrganizationMeta.FULL_NAME));
				this.setUpdateTime( (Date)map.get(OrganizationMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(OrganizationMeta.SORT));
				this.setType( (String)map.get(OrganizationMeta.TYPE));
				this.setVersion( (Integer)map.get(OrganizationMeta.VERSION));
				this.setParentId( (String)map.get(OrganizationMeta.PARENT_ID));
				this.setValid( (Integer)map.get(OrganizationMeta.VALID));
				this.setCompanyId( (String)map.get(OrganizationMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(OrganizationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(OrganizationMeta.DELETED));
				this.setCreateTime( (Date)map.get(OrganizationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(OrganizationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(OrganizationMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(OrganizationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(OrganizationMeta.DELETE_BY));
				this.setId( (String)map.get(OrganizationMeta.ID));
				this.setShortName( (String)map.get(OrganizationMeta.SHORT_NAME));
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
			this.setCode(DataParser.parse(String.class, r.getValue(OrganizationMeta.CODE)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(OrganizationMeta.HIERARCHY)));
			this.setFullName(DataParser.parse(String.class, r.getValue(OrganizationMeta.FULL_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(OrganizationMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(OrganizationMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(OrganizationMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(OrganizationMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(OrganizationMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(OrganizationMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(OrganizationMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(OrganizationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(OrganizationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(OrganizationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(OrganizationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(OrganizationMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(OrganizationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(OrganizationMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(OrganizationMeta.ID)));
			this.setShortName(DataParser.parse(String.class, r.getValue(OrganizationMeta.SHORT_NAME)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(OrganizationMeta.CODE));
				this.setHierarchy( (String)r.getValue(OrganizationMeta.HIERARCHY));
				this.setFullName( (String)r.getValue(OrganizationMeta.FULL_NAME));
				this.setUpdateTime( (Date)r.getValue(OrganizationMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(OrganizationMeta.SORT));
				this.setType( (String)r.getValue(OrganizationMeta.TYPE));
				this.setVersion( (Integer)r.getValue(OrganizationMeta.VERSION));
				this.setParentId( (String)r.getValue(OrganizationMeta.PARENT_ID));
				this.setValid( (Integer)r.getValue(OrganizationMeta.VALID));
				this.setCompanyId( (String)r.getValue(OrganizationMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(OrganizationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(OrganizationMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(OrganizationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(OrganizationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(OrganizationMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(OrganizationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(OrganizationMeta.DELETE_BY));
				this.setId( (String)r.getValue(OrganizationMeta.ID));
				this.setShortName( (String)r.getValue(OrganizationMeta.SHORT_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}