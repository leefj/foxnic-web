package org.github.foxnic.web.domain.pcm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ALLOCATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 分类属性分配
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:40:40
 * @sign 32AA2CE877044950C345A9681C175F92
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "pcm_catalog_allocation")
public class CatalogAllocation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PCM_CATALOG_ALLOCATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 配置版本号：配置版本号
	*/
	@ApiModelProperty(required = true,value="配置版本号" , notes = "配置版本号")
	private String versionNo;
	
	/**
	 * 分类ID：分类ID
	*/
	@ApiModelProperty(required = true,value="分类ID" , notes = "分类ID")
	private String catalogId;
	
	/**
	 * 属性ID：属性ID
	*/
	@ApiModelProperty(required = true,value="属性ID" , notes = "属性ID")
	private String attributeId;
	
	/**
	 * 字段名：数据库字段名
	*/
	@ApiModelProperty(required = true,value="字段名" , notes = "数据库字段名")
	private String columnName;
	
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
	 * 与之关联的属性：与之关联的属性
	*/
	@ApiModelProperty(required = false,value="与之关联的属性" , notes = "与之关联的属性")
	private CatalogAttribute attribute;
	
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
	public CatalogAllocation setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 配置版本号<br>
	 * 配置版本号
	 * @return 配置版本号
	*/
	public String getVersionNo() {
		return versionNo;
	}
	
	/**
	 * 设置 配置版本号
	 * @param versionNo 配置版本号
	 * @return 当前对象
	*/
	public CatalogAllocation setVersionNo(String versionNo) {
		this.versionNo=versionNo;
		return this;
	}
	
	/**
	 * 获得 分类ID<br>
	 * 分类ID
	 * @return 分类ID
	*/
	public String getCatalogId() {
		return catalogId;
	}
	
	/**
	 * 设置 分类ID
	 * @param catalogId 分类ID
	 * @return 当前对象
	*/
	public CatalogAllocation setCatalogId(String catalogId) {
		this.catalogId=catalogId;
		return this;
	}
	
	/**
	 * 获得 属性ID<br>
	 * 属性ID
	 * @return 属性ID
	*/
	public String getAttributeId() {
		return attributeId;
	}
	
	/**
	 * 设置 属性ID
	 * @param attributeId 属性ID
	 * @return 当前对象
	*/
	public CatalogAllocation setAttributeId(String attributeId) {
		this.attributeId=attributeId;
		return this;
	}
	
	/**
	 * 获得 字段名<br>
	 * 数据库字段名
	 * @return 字段名
	*/
	public String getColumnName() {
		return columnName;
	}
	
	/**
	 * 设置 字段名
	 * @param columnName 字段名
	 * @return 当前对象
	*/
	public CatalogAllocation setColumnName(String columnName) {
		this.columnName=columnName;
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
	public CatalogAllocation setCreateBy(String createBy) {
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
	public CatalogAllocation setCreateTime(Date createTime) {
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
	public CatalogAllocation setUpdateBy(String updateBy) {
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
	public CatalogAllocation setUpdateTime(Date updateTime) {
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
	public CatalogAllocation setDeleted(Integer deleted) {
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
	public CatalogAllocation setDeleted(Boolean deletedBool) {
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
	public CatalogAllocation setDeleteBy(String deleteBy) {
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
	public CatalogAllocation setDeleteTime(Date deleteTime) {
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
	public CatalogAllocation setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 与之关联的属性<br>
	 * 与之关联的属性
	 * @return 与之关联的属性
	*/
	public CatalogAttribute getAttribute() {
		return attribute;
	}
	
	/**
	 * 设置 与之关联的属性
	 * @param attribute 与之关联的属性
	 * @return 当前对象
	*/
	public CatalogAllocation setAttribute(CatalogAttribute attribute) {
		this.attribute=attribute;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CatalogAllocation , 转换好的 CatalogAllocation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CatalogAllocation , 转换好的 PoJo 对象
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
	public CatalogAllocation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CatalogAllocation duplicate(boolean all) {
		org.github.foxnic.web.domain.pcm.meta.CatalogAllocationMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.pcm.meta.CatalogAllocationMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAttributeId(this.getAttributeId());
		inst.setCreateBy(this.getCreateBy());
		inst.setCatalogId(this.getCatalogId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setVersionNo(this.getVersionNo());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setColumnName(this.getColumnName());
		if(all) {
			inst.setAttribute(this.getAttribute());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CatalogAllocation clone(boolean deep) {
		return EntityContext.clone(CatalogAllocation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CatalogAllocation
	 * @param catalogAllocationMap 包含实体信息的 Map 对象
	 * @return CatalogAllocation , 转换好的的 CatalogAllocation 对象
	*/
	@Transient
	public static CatalogAllocation createFrom(Map<String,Object> catalogAllocationMap) {
		if(catalogAllocationMap==null) return null;
		CatalogAllocation po = EntityContext.create(CatalogAllocation.class, catalogAllocationMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CatalogAllocation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CatalogAllocation , 转换好的的 CatalogAllocation 对象
	*/
	@Transient
	public static CatalogAllocation createFrom(Object pojo) {
		if(pojo==null) return null;
		CatalogAllocation po = EntityContext.create(CatalogAllocation.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CatalogAllocation，等同于 new
	 * @return CatalogAllocation 对象
	*/
	@Transient
	public static CatalogAllocation create() {
		return EntityContext.create(CatalogAllocation.class);
	}
}