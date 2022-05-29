package org.github.foxnic.web.domain.example;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ORDER_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * example_order_item
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 06:30:54
 * @sign 0959226F8E5B6F4A9A33A5E181FA567F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "example_order_item")
public class OrderItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EXAMPLE_ORDER_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 订单ID：订单ID
	*/
	@ApiModelProperty(required = false,value="订单ID" , notes = "订单ID")
	private String orderId;
	
	/**
	 * 商品ID：商品ID
	*/
	@ApiModelProperty(required = false,value="商品ID" , notes = "商品ID")
	private String goodsId;
	
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
	private Goods goods;
	
	/**
	 * 收件地址：收件地址，包括收件人以及手机号码
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址，包括收件人以及手机号码")
	private List<Address> addressList;
	
	/**
	 * 订单：订单
	*/
	@ApiModelProperty(required = false,value="订单" , notes = "订单")
	private Order order;
	
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
	public OrderItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 订单ID<br>
	 * 订单ID
	 * @return 订单ID
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	public OrderItem setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 商品ID<br>
	 * 商品ID
	 * @return 商品ID
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 商品ID
	 * @param goodsId 商品ID
	 * @return 当前对象
	*/
	public OrderItem setGoodsId(String goodsId) {
		this.goodsId=goodsId;
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
	public OrderItem setCreateBy(String createBy) {
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
	public OrderItem setCreateTime(Date createTime) {
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
	public OrderItem setUpdateBy(String updateBy) {
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
	public OrderItem setUpdateTime(Date updateTime) {
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
	public OrderItem setDeleted(Integer deleted) {
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
	public OrderItem setDeleted(Boolean deletedBool) {
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
	public OrderItem setDeleteBy(String deleteBy) {
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
	public OrderItem setDeleteTime(Date deleteTime) {
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
	public OrderItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 订单明细商品<br>
	 * 订单明细商品
	 * @return 订单明细商品
	*/
	public Goods getGoods() {
		return goods;
	}
	
	/**
	 * 设置 订单明细商品
	 * @param goods 订单明细商品
	 * @return 当前对象
	*/
	public OrderItem setGoods(Goods goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址，包括收件人以及手机号码
	 * @return 收件地址
	*/
	public List<Address> getAddressList() {
		return addressList;
	}
	
	/**
	 * 设置 收件地址
	 * @param addressList 收件地址
	 * @return 当前对象
	*/
	public OrderItem setAddressList(List<Address> addressList) {
		this.addressList=addressList;
		return this;
	}
	
	/**
	 * 添加 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public OrderItem addAddress(Address... address) {
		if(this.addressList==null) addressList=new ArrayList<>();
		this.addressList.addAll(Arrays.asList(address));
		return this;
	}
	
	/**
	 * 获得 订单<br>
	 * 订单
	 * @return 订单
	*/
	public Order getOrder() {
		return order;
	}
	
	/**
	 * 设置 订单
	 * @param order 订单
	 * @return 当前对象
	*/
	public OrderItem setOrder(Order order) {
		this.order=order;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return OrderItem , 转换好的 OrderItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return OrderItem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 OrderItem
	 * @param orderItemMap 包含实体信息的 Map 对象
	 * @return OrderItem , 转换好的的 OrderItem 对象
	*/
	@Transient
	public static OrderItem createFrom(Map<String,Object> orderItemMap) {
		if(orderItemMap==null) return null;
		OrderItem po = EntityContext.create(OrderItem.class, orderItemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 OrderItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return OrderItem , 转换好的的 OrderItem 对象
	*/
	@Transient
	public static OrderItem createFrom(Object pojo) {
		if(pojo==null) return null;
		OrderItem po = EntityContext.create(OrderItem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 OrderItem，等同于 new
	 * @return OrderItem 对象
	*/
	@Transient
	public static OrderItem create() {
		return EntityContext.create(OrderItem.class);
	}
}