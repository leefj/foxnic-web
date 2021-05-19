package com.scientific.tailoring.domain.product;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.PRD_VIRTUAL_LIBRARY;
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
 * @sign 690734638FD011514E1E23FC02F96936
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "prd_virtual_library")
public class VirtualLibrary extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PRD_VIRTUAL_LIBRARY.$TABLE;
	
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
	 * 面料ID：面料ID
	*/
	@ApiModelProperty(required = false,value="面料ID" , notes = "面料ID")
	private Integer fabricId;
	
	/**
	 * 虚拟试衣效果图ID：虚拟试衣效果图ID
	*/
	@ApiModelProperty(required = false,value="虚拟试衣效果图ID" , notes = "虚拟试衣效果图ID")
	private Long effectFileId;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Boolean valid;
	
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
	 * 商品
	*/
	@ApiModelProperty(required = false,value="商品" , notes = "")
	private Product product;
	
	/**
	 * 面料
	*/
	@ApiModelProperty(required = false,value="面料" , notes = "")
	private Fabric fabric;
	
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
	public VirtualLibrary setId(Long id) {
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
	public VirtualLibrary setProductId(Long productId) {
		this.productId=productId;
		return this;
	}
	
	/**
	 * 添加 商品ID
	 * @param productId 商品ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 面料ID<br>
	 * 属性说明 : 面料ID
	 * @return 面料ID
	*/
	public Integer getFabricId() {
		return fabricId;
	}
	
	/**
	 * 设置 面料ID
	 * @param fabricId 面料ID
	 * @return 当前对象
	*/
	public VirtualLibrary setFabricId(Integer fabricId) {
		this.fabricId=fabricId;
		return this;
	}
	
	/**
	 * 添加 面料ID
	 * @param fabricId 面料ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 虚拟试衣效果图ID<br>
	 * 属性说明 : 虚拟试衣效果图ID
	 * @return 虚拟试衣效果图ID
	*/
	public Long getEffectFileId() {
		return effectFileId;
	}
	
	/**
	 * 设置 虚拟试衣效果图ID
	 * @param effectFileId 虚拟试衣效果图ID
	 * @return 当前对象
	*/
	public VirtualLibrary setEffectFileId(Long effectFileId) {
		this.effectFileId=effectFileId;
		return this;
	}
	
	/**
	 * 添加 虚拟试衣效果图ID
	 * @param effectFileId 虚拟试衣效果图ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否有效<br>
	 * 属性说明 : 是否有效
	 * @return 是否有效
	*/
	public Boolean isValid() {
		return valid;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 等价于 isValid 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否有效
	 * @return 是否有效
	*/
	public Boolean getValid() {
		return this.valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public VirtualLibrary setValid(Boolean valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 添加 是否有效
	 * @param valid 是否有效
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
	public VirtualLibrary setCreateBy(Long createBy) {
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
	public VirtualLibrary setCreateTime(Date createTime) {
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
	public VirtualLibrary setUpdateBy(Long updateBy) {
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
	public VirtualLibrary setUpdateTime(Date updateTime) {
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
	public VirtualLibrary setDeleted(Boolean deleted) {
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
	public VirtualLibrary setDeleteBy(Long deleteBy) {
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
	public VirtualLibrary setDeleteTime(Date deleteTime) {
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
	public VirtualLibrary setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品<br>
	 * @return 商品
	*/
	public Product getProduct() {
		return product;
	}
	
	/**
	 * 设置 商品
	 * @param product 商品
	 * @return 当前对象
	*/
	public VirtualLibrary setProduct(Product product) {
		this.product=product;
		return this;
	}
	
	/**
	 * 添加 商品
	 * @param product 商品
	 * @return 当前对象
	*/
	
	/**
	 * 获得 面料<br>
	 * @return 面料
	*/
	public Fabric getFabric() {
		return fabric;
	}
	
	/**
	 * 设置 面料
	 * @param fabric 面料
	 * @return 当前对象
	*/
	public VirtualLibrary setFabric(Fabric fabric) {
		this.fabric=fabric;
		return this;
	}
	
	/**
	 * 添加 面料
	 * @param fabric 面料
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VirtualLibrary , 转换好的 VirtualLibrary 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VirtualLibrary , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 VirtualLibrary
	 * @param virtualLibraryMap 包含实体信息的 Map 对象
	 * @return VirtualLibrary , 转换好的的 VirtualLibrary 对象
	*/
	@Transient
	public static VirtualLibrary createFrom(Map<String,Object> virtualLibraryMap) {
		if(virtualLibraryMap==null) return null;
		VirtualLibrary po = EntityContext.create(VirtualLibrary.class, virtualLibraryMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 VirtualLibrary
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VirtualLibrary , 转换好的的 VirtualLibrary 对象
	*/
	@Transient
	public static VirtualLibrary createFrom(Object pojo) {
		if(pojo==null) return null;
		VirtualLibrary po = EntityContext.create(VirtualLibrary.class,pojo);
		return po;
	}

	/**
	 * 创建一个 VirtualLibrary，等同于 new
	 * @return VirtualLibrary 对象
	*/
	@Transient
	public static VirtualLibrary create() {
		return new VirtualLibrary();
	}
}