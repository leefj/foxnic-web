package org.github.foxnic.web.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.example.Order;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.example.Goods;
import java.util.List;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.OrderItem;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-05-29 07:23:21
 * @sign 45812777AEAF41BBC0A772DB549BCB77
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OrderMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_NO="orderNo";
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> ORDER_NO_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,ORDER_NO, java.lang.String.class, "订单编号", "订单编号", java.lang.String.class, null);
	
	/**
	 * 订单金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 订单金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,AMOUNT, java.math.BigDecimal.class, "订单金额", "订单金额", java.math.BigDecimal.class, null);
	
	/**
	 * 收件地址ID , 类型: java.lang.String
	*/
	public static final String ADDRESS_ID="addressId";
	
	/**
	 * 收件地址ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> ADDRESS_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,ADDRESS_ID, java.lang.String.class, "收件地址ID", "收件地址ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 订单明细商品 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Goods
	*/
	public static final String GOODS_LIST="goodsList";
	
	/**
	 * 订单明细商品 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Goods
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,org.github.foxnic.web.domain.example.Goods> GOODS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,GOODS_LIST, java.util.List.class, "订单明细商品", "订单明细商品", org.github.foxnic.web.domain.example.Goods.class, null);
	
	/**
	 * 收件地址 , 收件地址，包括收件人以及手机号码 , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 收件地址 , 收件地址，包括收件人以及手机号码 , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,org.github.foxnic.web.domain.example.Address> ADDRESS_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,ADDRESS, org.github.foxnic.web.domain.example.Address.class, "收件地址", "收件地址，包括收件人以及手机号码", org.github.foxnic.web.domain.example.Address.class, null);
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.OrderItem
	*/
	public static final String ITEM_LIST="itemList";
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.OrderItem
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Order,org.github.foxnic.web.domain.example.OrderItem> ITEM_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Order.class ,ITEM_LIST, java.util.List.class, "订单明细", "订单明细", org.github.foxnic.web.domain.example.OrderItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_NO , AMOUNT , ADDRESS_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , GOODS_LIST , ADDRESS , ITEM_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.example.Order {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Order setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单编号
		 * @param orderNo 订单编号
		 * @return 当前对象
		*/
		public Order setOrderNo(String orderNo) {
			super.change(ORDER_NO,super.getOrderNo(),orderNo);
			super.setOrderNo(orderNo);
			return this;
		}
		
		/**
		 * 设置 订单金额
		 * @param amount 订单金额
		 * @return 当前对象
		*/
		public Order setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 收件地址ID
		 * @param addressId 收件地址ID
		 * @return 当前对象
		*/
		public Order setAddressId(String addressId) {
			super.change(ADDRESS_ID,super.getAddressId(),addressId);
			super.setAddressId(addressId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Order setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Order setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Order setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Order setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Order setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Order setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Order setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Order setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 订单明细商品
		 * @param goodsList 订单明细商品
		 * @return 当前对象
		*/
		public Order setGoodsList(List<Goods> goodsList) {
			super.change(GOODS_LIST,super.getGoodsList(),goodsList);
			super.setGoodsList(goodsList);
			return this;
		}
		
		/**
		 * 设置 收件地址
		 * @param address 收件地址
		 * @return 当前对象
		*/
		public Order setAddress(Address address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 订单明细
		 * @param itemList 订单明细
		 * @return 当前对象
		*/
		public Order setItemList(List<OrderItem> itemList) {
			super.change(ITEM_LIST,super.getItemList(),itemList);
			super.setItemList(itemList);
			return this;
		}
	}
}