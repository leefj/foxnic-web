package org.github.foxnic.web.domain.dataperm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.DP_EXAMPLE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 销售订单
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-14 16:09:13
 * @sign C981CFF9C2FFB3E8CD1D15782FDA64B4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dp_example_order")
public class ExampleOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DP_EXAMPLE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 商品ID：商品ID
	*/
	@ApiModelProperty(required = false,value="商品ID" , notes = "商品ID")
	private String productId;
	
	/**
	 * 售价：售价
	*/
	@ApiModelProperty(required = false,value="售价" , notes = "售价")
	private BigDecimal price;
	
	/**
	 * 数量：数量
	*/
	@ApiModelProperty(required = false,value="数量" , notes = "数量")
	private Integer quantity;
	
	/**
	 * 金额：金额
	*/
	@ApiModelProperty(required = false,value="金额" , notes = "金额")
	private BigDecimal amount;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private String shopId;
	
	/**
	 * 销售人员ID：销售人员ID
	*/
	@ApiModelProperty(required = false,value="销售人员ID" , notes = "销售人员ID")
	private String salesId;
	
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
	 * 店铺：店铺
	*/
	@ApiModelProperty(required = false,value="店铺" , notes = "店铺")
	private ExampleShop shop;
	
	/**
	 * 商品：商品
	*/
	@ApiModelProperty(required = false,value="商品" , notes = "商品")
	private ExampleProduct product;
	
	/**
	 * 导购：导购
	*/
	@ApiModelProperty(required = false,value="导购" , notes = "导购")
	private Employee sales;
	
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
	public ExampleOrder setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 商品ID<br>
	 * 商品ID
	 * @return 商品ID
	*/
	public String getProductId() {
		return productId;
	}
	
	/**
	 * 设置 商品ID
	 * @param productId 商品ID
	 * @return 当前对象
	*/
	public ExampleOrder setProductId(String productId) {
		this.productId=productId;
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
	public ExampleOrder setPrice(BigDecimal price) {
		this.price=price;
		return this;
	}
	
	/**
	 * 获得 数量<br>
	 * 数量
	 * @return 数量
	*/
	public Integer getQuantity() {
		return quantity;
	}
	
	/**
	 * 设置 数量
	 * @param quantity 数量
	 * @return 当前对象
	*/
	public ExampleOrder setQuantity(Integer quantity) {
		this.quantity=quantity;
		return this;
	}
	
	/**
	 * 获得 金额<br>
	 * 金额
	 * @return 金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 金额
	 * @param amount 金额
	 * @return 当前对象
	*/
	public ExampleOrder setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 上级ID<br>
	 * 上级ID
	 * @return 上级ID
	*/
	public String getShopId() {
		return shopId;
	}
	
	/**
	 * 设置 上级ID
	 * @param shopId 上级ID
	 * @return 当前对象
	*/
	public ExampleOrder setShopId(String shopId) {
		this.shopId=shopId;
		return this;
	}
	
	/**
	 * 获得 销售人员ID<br>
	 * 销售人员ID
	 * @return 销售人员ID
	*/
	public String getSalesId() {
		return salesId;
	}
	
	/**
	 * 设置 销售人员ID
	 * @param salesId 销售人员ID
	 * @return 当前对象
	*/
	public ExampleOrder setSalesId(String salesId) {
		this.salesId=salesId;
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
	public ExampleOrder setCreateBy(String createBy) {
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
	public ExampleOrder setCreateTime(Date createTime) {
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
	public ExampleOrder setUpdateBy(String updateBy) {
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
	public ExampleOrder setUpdateTime(Date updateTime) {
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
	public ExampleOrder setDeleted(Integer deleted) {
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
	public ExampleOrder setDeleteBy(String deleteBy) {
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
	public ExampleOrder setDeleteTime(Date deleteTime) {
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
	public ExampleOrder setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 店铺<br>
	 * 店铺
	 * @return 店铺
	*/
	public ExampleShop getShop() {
		return shop;
	}
	
	/**
	 * 设置 店铺
	 * @param shop 店铺
	 * @return 当前对象
	*/
	public ExampleOrder setShop(ExampleShop shop) {
		this.shop=shop;
		return this;
	}
	
	/**
	 * 获得 商品<br>
	 * 商品
	 * @return 商品
	*/
	public ExampleProduct getProduct() {
		return product;
	}
	
	/**
	 * 设置 商品
	 * @param product 商品
	 * @return 当前对象
	*/
	public ExampleOrder setProduct(ExampleProduct product) {
		this.product=product;
		return this;
	}
	
	/**
	 * 获得 导购<br>
	 * 导购
	 * @return 导购
	*/
	public Employee getSales() {
		return sales;
	}
	
	/**
	 * 设置 导购
	 * @param sales 导购
	 * @return 当前对象
	*/
	public ExampleOrder setSales(Employee sales) {
		this.sales=sales;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ExampleOrder , 转换好的 ExampleOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ExampleOrder , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ExampleOrder
	 * @param exampleOrderMap 包含实体信息的 Map 对象
	 * @return ExampleOrder , 转换好的的 ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder createFrom(Map<String,Object> exampleOrderMap) {
		if(exampleOrderMap==null) return null;
		ExampleOrder po = EntityContext.create(ExampleOrder.class, exampleOrderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ExampleOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ExampleOrder , 转换好的的 ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		ExampleOrder po = EntityContext.create(ExampleOrder.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ExampleOrder，等同于 new
	 * @return ExampleOrder 对象
	*/
	@Transient
	public static ExampleOrder create() {
		return EntityContext.create(ExampleOrder.class);
	}
}