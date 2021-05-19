package com.scientific.tailoring.domain.product;

import com.github.foxnic.dao.entity.Entity;
import java.util.List;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.PRD_PRODUCT;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign AC244973BC9B65393224A8C3B65FABC9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "prd_product")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PRD_PRODUCT.$TABLE;
	
	/**
	 * 商品编号：商品编号
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="商品编号" , notes = "商品编号")
	private Long id;
	
	/**
	 * 商品名称：商品名称
	*/
	@ApiModelProperty(required = true,value="商品名称" , notes = "商品名称")
	private String name;
	
	/**
	 * 是否上架：是否上架
	*/
	@ApiModelProperty(required = true,value="是否上架" , notes = "是否上架")
	private Boolean isOnShelf;
	
	/**
	 * 商品详情：商品详情
	*/
	@ApiModelProperty(required = false,value="商品详情" , notes = "商品详情")
	private String detail;
	
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
	 * 商品图片清单
	*/
	@ApiModelProperty(required = false,value="商品图片清单" , notes = "")
	private List<ProductImage> images;
	
	/**
	 * 主图ID
	*/
	@ApiModelProperty(required = false,value="主图ID" , notes = "")
	private Long imageId;
	
	/**
	 * 面料清单
	*/
	@ApiModelProperty(required = false,value="面料清单" , notes = "")
	private List<Fabric> fabrics;
	
	/**
	 * 标签清单
	*/
	@ApiModelProperty(required = false,value="标签清单" , notes = "")
	private List<Label> labels;
	
	/**
	 * 是否收藏
	*/
	@ApiModelProperty(required = false,value="是否收藏" , notes = "")
	private Boolean isFavor;
	
	/**
	 * 获得 商品编号<br>
	 * 属性说明 : 商品编号
	 * @return 商品编号
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 商品编号
	 * @param id 商品编号
	 * @return 当前对象
	*/
	public Product setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 商品编号
	 * @param id 商品编号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品名称<br>
	 * 属性说明 : 商品名称
	 * @return 商品名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 商品名称
	 * @param name 商品名称
	 * @return 当前对象
	*/
	public Product setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 商品名称
	 * @param name 商品名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否上架<br>
	 * 属性说明 : 是否上架
	 * @return 是否上架
	*/
	public Boolean isOnShelf() {
		return isOnShelf;
	}
	
	/**
	 * 获得 是否上架<br>
	 * 等价于 isOnShelf 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否上架
	 * @return 是否上架
	*/
	public Boolean getIsOnShelf() {
		return this.isOnShelf;
	}
	
	/**
	 * 设置 是否上架
	 * @param isOnShelf 是否上架
	 * @return 当前对象
	*/
	public Product setOnShelf(Boolean isOnShelf) {
		this.isOnShelf=isOnShelf;
		return this;
	}
	
	/**
	 * 添加 是否上架
	 * @param isOnShelf 是否上架
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品详情<br>
	 * 属性说明 : 商品详情
	 * @return 商品详情
	*/
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 商品详情
	 * @param detail 商品详情
	 * @return 当前对象
	*/
	public Product setDetail(String detail) {
		this.detail=detail;
		return this;
	}
	
	/**
	 * 添加 商品详情
	 * @param detail 商品详情
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
	public Product setCreateBy(Long createBy) {
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
	public Product setCreateTime(Date createTime) {
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
	public Product setUpdateBy(Long updateBy) {
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
	public Product setUpdateTime(Date updateTime) {
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
	public Product setDeleted(Boolean deleted) {
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
	public Product setDeleteBy(Long deleteBy) {
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
	public Product setDeleteTime(Date deleteTime) {
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
	public Product setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品图片清单<br>
	 * @return 商品图片清单
	*/
	public List<ProductImage> getImages() {
		return images;
	}
	
	/**
	 * 设置 商品图片清单
	 * @param images 商品图片清单
	 * @return 当前对象
	*/
	public Product setImages(List<ProductImage> images) {
		this.images=images;
		return this;
	}
	
	/**
	 * 添加 商品图片清单
	 * @param images 商品图片清单
	 * @return 当前对象
	*/
	public Product addImage(ProductImage image) {
		if(this.images==null) images=new ArrayList<>();
		this.images.add(image);
		return this;
	}
	
	/**
	 * 获得 主图ID<br>
	 * @return 主图ID
	*/
	public Long getImageId() {
		return imageId;
	}
	
	/**
	 * 设置 主图ID
	 * @param imageId 主图ID
	 * @return 当前对象
	*/
	public Product setImageId(Long imageId) {
		this.imageId=imageId;
		return this;
	}
	
	/**
	 * 添加 主图ID
	 * @param imageId 主图ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 面料清单<br>
	 * @return 面料清单
	*/
	public List<Fabric> getFabrics() {
		return fabrics;
	}
	
	/**
	 * 设置 面料清单
	 * @param fabrics 面料清单
	 * @return 当前对象
	*/
	public Product setFabrics(List<Fabric> fabrics) {
		this.fabrics=fabrics;
		return this;
	}
	
	/**
	 * 添加 面料清单
	 * @param fabrics 面料清单
	 * @return 当前对象
	*/
	public Product addFabric(Fabric fabric) {
		if(this.fabrics==null) fabrics=new ArrayList<>();
		this.fabrics.add(fabric);
		return this;
	}
	
	/**
	 * 获得 标签清单<br>
	 * @return 标签清单
	*/
	public List<Label> getLabels() {
		return labels;
	}
	
	/**
	 * 设置 标签清单
	 * @param labels 标签清单
	 * @return 当前对象
	*/
	public Product setLabels(List<Label> labels) {
		this.labels=labels;
		return this;
	}
	
	/**
	 * 添加 标签清单
	 * @param labels 标签清单
	 * @return 当前对象
	*/
	public Product addLabel(Label label) {
		if(this.labels==null) labels=new ArrayList<>();
		this.labels.add(label);
		return this;
	}
	
	/**
	 * 获得 是否收藏<br>
	 * @return 是否收藏
	*/
	public Boolean isFavor() {
		return isFavor;
	}
	
	/**
	 * 获得 是否收藏<br>
	 * 等价于 isFavor 方法，为兼容 Swagger 需要
	 * @return 是否收藏
	*/
	public Boolean getIsFavor() {
		return this.isFavor;
	}
	
	/**
	 * 设置 是否收藏
	 * @param isFavor 是否收藏
	 * @return 当前对象
	*/
	public Product setFavor(Boolean isFavor) {
		this.isFavor=isFavor;
		return this;
	}
	
	/**
	 * 添加 是否收藏
	 * @param isFavor 是否收藏
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Product , 转换好的 Product 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Product , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Product
	 * @param productMap 包含实体信息的 Map 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Map<String,Object> productMap) {
		if(productMap==null) return null;
		Product po = EntityContext.create(Product.class, productMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Product
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Object pojo) {
		if(pojo==null) return null;
		Product po = EntityContext.create(Product.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Product，等同于 new
	 * @return Product 对象
	*/
	@Transient
	public static Product create() {
		return new Product();
	}
}