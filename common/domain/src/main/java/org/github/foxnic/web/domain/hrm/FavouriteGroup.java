package org.github.foxnic.web.domain.hrm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.HRM_FAVOURITE_GROUP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 常用人员分组
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:24:59
 * @sign A759868D87160C1067D507EDAC31A88F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hrm_favourite_group")
public class FavouriteGroup extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HRM_FAVOURITE_GROUP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 组名：组名
	*/
	@ApiModelProperty(required = true,value="组名" , notes = "组名")
	private String name;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = true,value="上级ID" , notes = "上级ID")
	private String parentId;
	
	/**
	 * 所有者ID：所有者ID
	*/
	@ApiModelProperty(required = true,value="所有者ID" , notes = "所有者ID")
	private String employeeId;
	
	/**
	 * 层级路径：层级路径
	*/
	@ApiModelProperty(required = false,value="层级路径" , notes = "层级路径")
	private String hierarchy;
	
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
	public FavouriteGroup setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 组名<br>
	 * 组名
	 * @return 组名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 组名
	 * @param name 组名
	 * @return 当前对象
	*/
	public FavouriteGroup setName(String name) {
		this.name=name;
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
	public FavouriteGroup setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 所有者ID<br>
	 * 所有者ID
	 * @return 所有者ID
	*/
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * 设置 所有者ID
	 * @param employeeId 所有者ID
	 * @return 当前对象
	*/
	public FavouriteGroup setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
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
	public FavouriteGroup setHierarchy(String hierarchy) {
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
	public FavouriteGroup setSort(Integer sort) {
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
	public FavouriteGroup setCompanyId(String companyId) {
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
	public FavouriteGroup setTenantId(String tenantId) {
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
	public FavouriteGroup setCreateBy(String createBy) {
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
	public FavouriteGroup setCreateTime(Date createTime) {
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
	public FavouriteGroup setUpdateBy(String updateBy) {
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
	public FavouriteGroup setUpdateTime(Date updateTime) {
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
	public FavouriteGroup setDeleted(Integer deleted) {
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
	public FavouriteGroup setDeleted(Boolean deletedBool) {
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
	public FavouriteGroup setDeleteBy(String deleteBy) {
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
	public FavouriteGroup setDeleteTime(Date deleteTime) {
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
	public FavouriteGroup setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FavouriteGroup , 转换好的 FavouriteGroup 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FavouriteGroup , 转换好的 PoJo 对象
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
	public FavouriteGroup clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FavouriteGroup duplicate(boolean all) {
		org.github.foxnic.web.domain.hrm.meta.FavouriteGroupMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.hrm.meta.FavouriteGroupMeta.$$proxy$$();
		inst.setHierarchy(this.getHierarchy());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
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
	public FavouriteGroup clone(boolean deep) {
		return EntityContext.clone(FavouriteGroup.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FavouriteGroup
	 * @param favouriteGroupMap 包含实体信息的 Map 对象
	 * @return FavouriteGroup , 转换好的的 FavouriteGroup 对象
	*/
	@Transient
	public static FavouriteGroup createFrom(Map<String,Object> favouriteGroupMap) {
		if(favouriteGroupMap==null) return null;
		FavouriteGroup po = EntityContext.create(FavouriteGroup.class, favouriteGroupMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 FavouriteGroup
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FavouriteGroup , 转换好的的 FavouriteGroup 对象
	*/
	@Transient
	public static FavouriteGroup createFrom(Object pojo) {
		if(pojo==null) return null;
		FavouriteGroup po = EntityContext.create(FavouriteGroup.class,pojo);
		return po;
	}

	/**
	 * 创建一个 FavouriteGroup，等同于 new
	 * @return FavouriteGroup 对象
	*/
	@Transient
	public static FavouriteGroup create() {
		return EntityContext.create(FavouriteGroup.class);
	}
}