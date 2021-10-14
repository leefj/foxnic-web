package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_EXAMPLE_PRODUCT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 销售订单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:09:14
 * @sign 6E09C0F5C26E1090EF92CF9A85188AA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_example_product")
public class ExampleProduct extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_EXAMPLE_PRODUCT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 品牌ID：品牌ID
	*/
	@ApiModelProperty(required = false,value="品牌ID" , notes = "品牌ID")
	private String brandId;
	
	/**
	 * 大类ID：大类ID
	*/
	@ApiModelProperty(required = false,value="大类ID" , notes = "大类ID")
	private String bigCataId;
	
	/**
	 * 小类ID：小类ID
	*/
	@ApiModelProperty(required = false,value="小类ID" , notes = "小类ID")
	private String smlCataId;
	
	/**
	 * 售价：售价
	*/
	@ApiModelProperty(required = false,value="售价" , notes = "售价")
	private BigDecimal price;
	
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
	 * 小类：商品小类
	*/
	@ApiModelProperty(required = false,value="小类" , notes = "商品小类")
	private ExampleCatalog smlCatalog;
	
	/**
	 * 大类：商品大类
	*/
	@ApiModelProperty(required = false,value="大类" , notes = "商品大类")
	private ExampleCatalog bigCatalog;
	
	/**
	 * 品牌：商品品牌
	*/
	@ApiModelProperty(required = false,value="品牌" , notes = "商品品牌")
	private ExampleBrand brand;
	
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
	public ExampleProduct setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public ExampleProduct setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 品牌ID<br>
	 * 品牌ID
	 * @return 品牌ID
	*/
	public String getBrandId() {
		return brandId;
	}
	
	/**
	 * 设置 品牌ID
	 * @param brandId 品牌ID
	 * @return 当前对象
	*/
	public ExampleProduct setBrandId(String brandId) {
		this.brandId=brandId;
		return this;
	}
	
	/**
	 * 获得 大类ID<br>
	 * 大类ID
	 * @return 大类ID
	*/
	public String getBigCataId() {
		return bigCataId;
	}
	
	/**
	 * 设置 大类ID
	 * @param bigCataId 大类ID
	 * @return 当前对象
	*/
	public ExampleProduct setBigCataId(String bigCataId) {
		this.bigCataId=bigCataId;
		return this;
	}
	
	/**
	 * 获得 小类ID<br>
	 * 小类ID
	 * @return 小类ID
	*/
	public String getSmlCataId() {
		return smlCataId;
	}
	
	/**
	 * 设置 小类ID
	 * @param smlCataId 小类ID
	 * @return 当前对象
	*/
	public ExampleProduct setSmlCataId(String smlCataId) {
		this.smlCataId=smlCataId;
		return this;
	}
	
	/**
	 * 获得 售价<br>
	 * 售价
	 * @return 售价
	*/
	public BigDecimal getPrice() {
		return price;
	}
	
	/**
	 * 设置 售价
	 * @param price 售价
	 * @return 当前对象
	*/
	public ExampleProduct setPrice(BigDecimal price) {
		this.price=price;
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
	public ExampleProduct setCreateBy(String createBy) {
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
	public ExampleProduct setCreateTime(Date createTime) {
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
	public ExampleProduct setUpdateBy(String updateBy) {
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
	public ExampleProduct setUpdateTime(Date updateTime) {
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
	public ExampleProduct setDeleted(Integer deleted) {
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
	public ExampleProduct setDeleteBy(String deleteBy) {
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
	public ExampleProduct setDeleteTime(Date deleteTime) {
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
	public ExampleProduct setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 小类<br>
	 * 商品小类
	 * @return 小类
	*/
	public ExampleCatalog getSmlCatalog() {
		return smlCatalog;
	}
	
	/**
	 * 设置 小类
	 * @param smlCatalog 小类
	 * @return 当前对象
	*/
	public ExampleProduct setSmlCatalog(ExampleCatalog smlCatalog) {
		this.smlCatalog=smlCatalog;
		return this;
	}
	
	/**
	 * 获得 大类<br>
	 * 商品大类
	 * @return 大类
	*/
	public ExampleCatalog getBigCatalog() {
		return bigCatalog;
	}
	
	/**
	 * 设置 大类
	 * @param bigCatalog 大类
	 * @return 当前对象
	*/
	public ExampleProduct setBigCatalog(ExampleCatalog bigCatalog) {
		this.bigCatalog=bigCatalog;
		return this;
	}
	
	/**
	 * 获得 品牌<br>
	 * 商品品牌
	 * @return 品牌
	*/
	public ExampleBrand getBrand() {
		return brand;
	}
	
	/**
	 * 设置 品牌
	 * @param brand 品牌
	 * @return 当前对象
	*/
	public ExampleProduct setBrand(ExampleBrand brand) {
		this.brand=brand;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ExampleProduct , 转换好的 ExampleProduct 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ExampleProduct , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ExampleProduct
	 * @param exampleProductMap 包含实体信息的 Map 对象
	 * @return ExampleProduct , 转换好的的 ExampleProduct 对象
	*/
	@Transient
	public static ExampleProduct createFrom(Map<String,Object> exampleProductMap) {
		if(exampleProductMap==null) return null;
		ExampleProduct po = EntityContext.create(ExampleProduct.class, exampleProductMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ExampleProduct
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ExampleProduct , 转换好的的 ExampleProduct 对象
	*/
	@Transient
	public static ExampleProduct createFrom(Object pojo) {
		if(pojo==null) return null;
		ExampleProduct po = EntityContext.create(ExampleProduct.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ExampleProduct，等同于 new
	 * @return ExampleProduct 对象
	*/
	@Transient
	public static ExampleProduct create() {
		return EntityContext.create(ExampleProduct.class);
	}
}