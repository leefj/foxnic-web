package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_TENANT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Company;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.TenantMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 租户
 * <p>租户 , 数据表 sys_tenant 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:52
 * @sign 1AAF33EE5D9AA6B7824641A589075E97
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_tenant")
@ApiModel(description = "租户 ; 租户 , 数据表 sys_tenant 的PO类型")
public class Tenant extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_TENANT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "T001")
	private String id;
	
	/**
	 * 别名：别名
	*/
	@ApiModelProperty(required = false,value="别名" , notes = "别名" , example = "默认租户公司")
	private String alias;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效" , example = "1")
	private Integer valid;
	
	/**
	 * 公司ID：公司ID
	*/
	@ApiModelProperty(required = false,value="公司ID" , notes = "公司ID" , example = "002")
	private String companyId;
	
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
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-09-01 09:46:13")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "14")
	private Integer version;
	
	/**
	 * 公司：租户对应的公司
	*/
	@ApiModelProperty(required = false,value="公司" , notes = "租户对应的公司")
	private Company company;
	
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
	public Tenant setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 别名<br>
	 * 别名
	 * @return 别名
	*/
	public String getAlias() {
		return alias;
	}
	
	/**
	 * 设置 别名
	 * @param alias 别名
	 * @return 当前对象
	*/
	public Tenant setAlias(String alias) {
		this.alias=alias;
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
	public Tenant setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 公司ID<br>
	 * 公司ID
	 * @return 公司ID
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	public Tenant setCompanyId(String companyId) {
		this.companyId=companyId;
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
	public Tenant setCreateBy(String createBy) {
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
	public Tenant setCreateTime(Date createTime) {
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
	public Tenant setUpdateBy(String updateBy) {
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
	public Tenant setUpdateTime(Date updateTime) {
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
	public Tenant setDeleted(Integer deleted) {
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
	public Tenant setDeleted(Boolean deletedBool) {
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
	public Tenant setDeleteBy(String deleteBy) {
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
	public Tenant setDeleteTime(Date deleteTime) {
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
	public Tenant setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 公司<br>
	 * 租户对应的公司
	 * @return 公司
	*/
	public Company getCompany() {
		return company;
	}
	
	/**
	 * 设置 公司
	 * @param company 公司
	 * @return 当前对象
	*/
	public Tenant setCompany(Company company) {
		this.company=company;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Tenant , 转换好的 Tenant 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Tenant , 转换好的 PoJo 对象
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
	public Tenant clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Tenant duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.TenantMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.TenantMeta.$$proxy$$();
		inst.setValid(this.getValid());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAlias(this.getAlias());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setCompany(this.getCompany());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Tenant clone(boolean deep) {
		return EntityContext.clone(Tenant.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Tenant
	 * @param tenantMap 包含实体信息的 Map 对象
	 * @return Tenant , 转换好的的 Tenant 对象
	*/
	@Transient
	public static Tenant createFrom(Map<String,Object> tenantMap) {
		if(tenantMap==null) return null;
		Tenant po = create();
		EntityContext.copyProperties(po,tenantMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Tenant
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Tenant , 转换好的的 Tenant 对象
	*/
	@Transient
	public static Tenant createFrom(Object pojo) {
		if(pojo==null) return null;
		Tenant po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Tenant，等同于 new
	 * @return Tenant 对象
	*/
	@Transient
	public static Tenant create() {
		return new org.github.foxnic.web.domain.system.meta.TenantMeta.$$proxy$$();
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
			this.setValid(DataParser.parse(Integer.class, map.get(TenantMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, map.get(TenantMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TenantMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TenantMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TenantMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TenantMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TenantMeta.DELETE_TIME)));
			this.setAlias(DataParser.parse(String.class, map.get(TenantMeta.ALIAS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TenantMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TenantMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(TenantMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TenantMeta.VERSION)));
			// others
			this.setCompany(DataParser.parse(Company.class, map.get(TenantMeta.COMPANY)));
			return true;
		} else {
			try {
				this.setValid( (Integer)map.get(TenantMeta.VALID));
				this.setCompanyId( (String)map.get(TenantMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(TenantMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(TenantMeta.DELETED));
				this.setCreateTime( (Date)map.get(TenantMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TenantMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TenantMeta.DELETE_TIME));
				this.setAlias( (String)map.get(TenantMeta.ALIAS));
				this.setDeleteBy( (String)map.get(TenantMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(TenantMeta.UPDATE_TIME));
				this.setId( (String)map.get(TenantMeta.ID));
				this.setVersion( (Integer)map.get(TenantMeta.VERSION));
				// others
				this.setCompany( (Company)map.get(TenantMeta.COMPANY));
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
			this.setValid(DataParser.parse(Integer.class, r.getValue(TenantMeta.VALID)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(TenantMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TenantMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TenantMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TenantMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TenantMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TenantMeta.DELETE_TIME)));
			this.setAlias(DataParser.parse(String.class, r.getValue(TenantMeta.ALIAS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TenantMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TenantMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(TenantMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TenantMeta.VERSION)));
			return true;
		} else {
			try {
				this.setValid( (Integer)r.getValue(TenantMeta.VALID));
				this.setCompanyId( (String)r.getValue(TenantMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(TenantMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(TenantMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TenantMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TenantMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TenantMeta.DELETE_TIME));
				this.setAlias( (String)r.getValue(TenantMeta.ALIAS));
				this.setDeleteBy( (String)r.getValue(TenantMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(TenantMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(TenantMeta.ID));
				this.setVersion( (Integer)r.getValue(TenantMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}