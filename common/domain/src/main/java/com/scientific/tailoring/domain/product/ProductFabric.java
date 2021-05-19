package com.scientific.tailoring.domain.product;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT_FABRIC;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign E43FBC028F7F8C28B813CA7EEDDA60BC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "prd_product_fabric")
public class ProductFabric extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PRD_PRODUCT_FABRIC.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 商品ID：商品ID
	*/
	@ApiModelProperty(required = false,value="商品ID" , notes = "商品ID")
	private Long productId;
	
	/**
	 * 标签ID：标签ID
	*/
	@ApiModelProperty(required = false,value="标签ID" , notes = "标签ID")
	private Integer fabricId;
	
	/**
	 * 效果图：面料+商品的效果图
	*/
	@ApiModelProperty(required = false,value="效果图" , notes = "面料+商品的效果图")
	private Integer effectId;
	
	/**
	 * 虚拟试衣ID：虚拟试衣ID
	*/
	@ApiModelProperty(required = false,value="虚拟试衣ID" , notes = "虚拟试衣ID")
	private Long virtualId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private Long createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private Long updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Boolean deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private Long deleteBy;
	
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
	 * 虚拟试衣信息
	*/
	@ApiModelProperty(required = false,value="虚拟试衣信息" , notes = "")
	private VirtualLibrary virtual;
	
	/**
	 * 获得 ID<br>
	 * 属性说明 : ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public ProductFabric setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品ID<br>
	 * 属性说明 : 商品ID
	 * @return 商品ID
	*/
	public Long getProductId() {
		return productId;
	}
	
	/**
	 * 设置 商品ID
	 * @param productId 商品ID
	 * @return 当前对象
	*/
	public ProductFabric setProductId(Long productId) {
		this.productId=productId;
		return this;
	}
	
	/**
	 * 添加 商品ID
	 * @param productId 商品ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 标签ID<br>
	 * 属性说明 : 标签ID
	 * @return 标签ID
	*/
	public Integer getFabricId() {
		return fabricId;
	}
	
	/**
	 * 设置 标签ID
	 * @param fabricId 标签ID
	 * @return 当前对象
	*/
	public ProductFabric setFabricId(Integer fabricId) {
		this.fabricId=fabricId;
		return this;
	}
	
	/**
	 * 添加 标签ID
	 * @param fabricId 标签ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 效果图<br>
	 * 属性说明 : 面料+商品的效果图
	 * @return 效果图
	*/
	public Integer getEffectId() {
		return effectId;
	}
	
	/**
	 * 设置 效果图
	 * @param effectId 效果图
	 * @return 当前对象
	*/
	public ProductFabric setEffectId(Integer effectId) {
		this.effectId=effectId;
		return this;
	}
	
	/**
	 * 添加 效果图
	 * @param effectId 效果图
	 * @return 当前对象
	*/
	
	/**
	 * 获得 虚拟试衣ID<br>
	 * 属性说明 : 虚拟试衣ID
	 * @return 虚拟试衣ID
	*/
	public Long getVirtualId() {
		return virtualId;
	}
	
	/**
	 * 设置 虚拟试衣ID
	 * @param virtualId 虚拟试衣ID
	 * @return 当前对象
	*/
	public ProductFabric setVirtualId(Long virtualId) {
		this.virtualId=virtualId;
		return this;
	}
	
	/**
	 * 添加 虚拟试衣ID
	 * @param virtualId 虚拟试衣ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
	 * @return 创建人ID
	*/
	public Long getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public ProductFabric setCreateBy(Long createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
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
	public ProductFabric setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
	 * @return 修改人ID
	*/
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public ProductFabric setUpdateBy(Long updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
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
	public ProductFabric setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 等价于 isDeleted 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean getDeleted() {
		return this.deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public ProductFabric setDeleted(Boolean deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
	 * @return 删除人ID
	*/
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public ProductFabric setDeleteBy(Long deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
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
	public ProductFabric setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据版本号<br>
	 * 属性说明 : 数据版本号
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
	public ProductFabric setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 虚拟试衣信息<br>
	 * @return 虚拟试衣信息
	*/
	public VirtualLibrary getVirtual() {
		return virtual;
	}
	
	/**
	 * 设置 虚拟试衣信息
	 * @param virtual 虚拟试衣信息
	 * @return 当前对象
	*/
	public ProductFabric setVirtual(VirtualLibrary virtual) {
		this.virtual=virtual;
		return this;
	}
	
	/**
	 * 添加 虚拟试衣信息
	 * @param virtual 虚拟试衣信息
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProductFabric , 转换好的 ProductFabric 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProductFabric , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ProductFabric
	 * @param productFabricMap 包含实体信息的 Map 对象
	 * @return ProductFabric , 转换好的的 ProductFabric 对象
	*/
	@Transient
	public static ProductFabric createFrom(Map<String,Object> productFabricMap) {
		if(productFabricMap==null) return null;
		ProductFabric po = EntityContext.create(ProductFabric.class, productFabricMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProductFabric
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProductFabric , 转换好的的 ProductFabric 对象
	*/
	@Transient
	public static ProductFabric createFrom(Object pojo) {
		if(pojo==null) return null;
		ProductFabric po = EntityContext.create(ProductFabric.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ProductFabric，等同于 new
	 * @return ProductFabric 对象
	*/
	@Transient
	public static ProductFabric create() {
		return new ProductFabric();
	}
}