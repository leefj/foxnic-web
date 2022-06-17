package org.github.foxnic.web.domain.example;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * example_order
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-06-17 22:22:18
 * @sign 45812777AEAF41BBC0A772DB549BCB77
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "example_order")
public class Order extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EXAMPLE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号")
	private String orderNo;
	
	/**
	 * 订单金额：订单金额
	*/
	@ApiModelProperty(required = false,value="订单金额" , notes = "订单金额")
	private BigDecimal amount;
	
	/**
	 * 收件地址ID：收件地址ID
	*/
	@ApiModelProperty(required = false,value="收件地址ID" , notes = "收件地址ID")
	private String addressId;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 订单明细商品：订单明细商品
	*/
	@ApiModelProperty(required = false,value="订单明细商品" , notes = "订单明细商品")
	private List<Goods> goodsList;
	
	/**
	 * 收件地址：收件地址，包括收件人以及手机号码
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址，包括收件人以及手机号码")
	private Address address;
	
	/**
	 * 订单明细：订单明细
	*/
	@ApiModelProperty(required = false,value="订单明细" , notes = "订单明细")
	private List<OrderItem> itemList;
	
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
	public Order setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getOrderNo() {
		return orderNo;
	}
	
	/**
	 * 设置 订单编号
	 * @param orderNo 订单编号
	 * @return 当前对象
	*/
	public Order setOrderNo(String orderNo) {
		this.orderNo=orderNo;
		return this;
	}
	
	/**
	 * 获得 订单金额<br>
	 * 订单金额
	 * @return 订单金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 订单金额
	 * @param amount 订单金额
	 * @return 当前对象
	*/
	public Order setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 收件地址ID<br>
	 * 收件地址ID
	 * @return 收件地址ID
	*/
	public String getAddressId() {
		return addressId;
	}
	
	/**
	 * 设置 收件地址ID
	 * @param addressId 收件地址ID
	 * @return 当前对象
	*/
	public Order setAddressId(String addressId) {
		this.addressId=addressId;
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
	public Order setCreateBy(String createBy) {
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
	public Order setCreateTime(Date createTime) {
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
	public Order setUpdateBy(String updateBy) {
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
	public Order setUpdateTime(Date updateTime) {
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
	public Order setDeleted(Integer deleted) {
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
	public Order setDeleted(Boolean deletedBool) {
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
	public Order setDeleteBy(String deleteBy) {
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
	public Order setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public Order setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 订单明细商品<br>
	 * 订单明细商品
	 * @return 订单明细商品
	*/
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	
	/**
	 * 设置 订单明细商品
	 * @param goodsList 订单明细商品
	 * @return 当前对象
	*/
	public Order setGoodsList(List<Goods> goodsList) {
		this.goodsList=goodsList;
		return this;
	}
	
	/**
	 * 添加 订单明细商品
	 * @param goods 订单明细商品
	 * @return 当前对象
	*/
	public Order addGoods(Goods... goods) {
		if(this.goodsList==null) goodsList=new ArrayList<>();
		this.goodsList.addAll(Arrays.asList(goods));
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址，包括收件人以及手机号码
	 * @return 收件地址
	*/
	public Address getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public Order setAddress(Address address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 订单明细<br>
	 * 订单明细
	 * @return 订单明细
	*/
	public List<OrderItem> getItemList() {
		return itemList;
	}
	
	/**
	 * 设置 订单明细
	 * @param itemList 订单明细
	 * @return 当前对象
	*/
	public Order setItemList(List<OrderItem> itemList) {
		this.itemList=itemList;
		return this;
	}
	
	/**
	 * 添加 订单明细
	 * @param item 订单明细
	 * @return 当前对象
	*/
	public Order addItem(OrderItem... item) {
		if(this.itemList==null) itemList=new ArrayList<>();
		this.itemList.addAll(Arrays.asList(item));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Order , 转换好的 Order 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Order , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Order
	 * @param orderMap 包含实体信息的 Map 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Map<String,Object> orderMap) {
		if(orderMap==null) return null;
		Order po = EntityContext.create(Order.class, orderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Order
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Object pojo) {
		if(pojo==null) return null;
		Order po = EntityContext.create(Order.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Order，等同于 new
	 * @return Order 对象
	*/
	@Transient
	public static Order create() {
		return EntityContext.create(Order.class);
	}
}