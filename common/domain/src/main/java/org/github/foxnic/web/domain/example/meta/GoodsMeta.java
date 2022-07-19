package org.github.foxnic.web.domain.example.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.example.Goods;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.example.Address;
import org.github.foxnic.web.domain.example.Order;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-07-19 14:54:30
 * @sign 0ACFDBFD8DB3922195708932F726C172
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class GoodsMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 商品名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 商品名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,NAME, java.lang.String.class, "商品名", "商品名", java.lang.String.class, null);
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final String PRICE="price";
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.math.BigDecimal> PRICE_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,PRICE, java.math.BigDecimal.class, "单价", "单价", java.math.BigDecimal.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Goods
	*/
	public static final String ITEM_LIST="itemList";
	
	/**
	 * 订单明细 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Goods
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,org.github.foxnic.web.domain.example.Goods> ITEM_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,ITEM_LIST, java.util.List.class, "订单明细", "订单明细", org.github.foxnic.web.domain.example.Goods.class, null);
	
	/**
	 * 收件地址 , 收件地址，包括收件人以及手机号码 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final String ADDRESS_LIST="addressList";
	
	/**
	 * 收件地址 , 收件地址，包括收件人以及手机号码 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Address
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,org.github.foxnic.web.domain.example.Address> ADDRESS_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,ADDRESS_LIST, java.util.List.class, "收件地址", "收件地址，包括收件人以及手机号码", org.github.foxnic.web.domain.example.Address.class, null);
	
	/**
	 * 订单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Order
	*/
	public static final String ORDER_LIST="orderList";
	
	/**
	 * 订单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.example.Order
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.example.Goods,org.github.foxnic.web.domain.example.Order> ORDER_LIST_PROP = new BeanProperty(org.github.foxnic.web.domain.example.Goods.class ,ORDER_LIST, java.util.List.class, "订单", "订单", org.github.foxnic.web.domain.example.Order.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ITEM_LIST , ADDRESS_LIST , ORDER_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.example.Goods {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Goods setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 商品名
		 * @param name 商品名
		 * @return 当前对象
		*/
		public Goods setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 单价
		 * @param price 单价
		 * @return 当前对象
		*/
		public Goods setPrice(BigDecimal price) {
			super.change(PRICE,super.getPrice(),price);
			super.setPrice(price);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Goods setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Goods setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Goods setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Goods setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Goods setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Goods setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Goods setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Goods setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 订单明细
		 * @param itemList 订单明细
		 * @return 当前对象
		*/
		public Goods setItemList(List<Goods> itemList) {
			super.change(ITEM_LIST,super.getItemList(),itemList);
			super.setItemList(itemList);
			return this;
		}
		
		/**
		 * 设置 收件地址
		 * @param addressList 收件地址
		 * @return 当前对象
		*/
		public Goods setAddressList(List<Address> addressList) {
			super.change(ADDRESS_LIST,super.getAddressList(),addressList);
			super.setAddressList(addressList);
			return this;
		}
		
		/**
		 * 设置 订单
		 * @param orderList 订单
		 * @return 当前对象
		*/
		public Goods setOrderList(List<Order> orderList) {
			super.change(ORDER_LIST,super.getOrderList(),orderList);
			super.setOrderList(orderList);
			return this;
		}
	}
}