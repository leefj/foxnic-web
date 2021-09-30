package org.github.foxnic.web.domain.changes.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.changes.ExampleOrderItem;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-01 02:21:15
 * @sign CF78FFFD63BEDD2E8DCF2E469FF81870
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ExampleOrderItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 订单ID , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 订单ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> ORDER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,ORDER_ID, java.lang.String.class, "订单ID", "订单ID", java.lang.String.class, null);
	
	/**
	 * 商品名称 , 类型: java.lang.String
	*/
	public static final String PRODUCT_NAME="productName";
	
	/**
	 * 商品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> PRODUCT_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,PRODUCT_NAME, java.lang.String.class, "商品名称", "商品名称", java.lang.String.class, null);
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final String PRICE="price";
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.math.BigDecimal> PRICE_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,PRICE, java.math.BigDecimal.class, "单价", "单价", java.math.BigDecimal.class, null);
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final String QUANTITY="quantity";
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.Integer> QUANTITY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,QUANTITY, java.lang.Integer.class, "数量", "数量", java.lang.Integer.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> TENANT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.changes.ExampleOrderItem,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.changes.ExampleOrderItem.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ID , PRODUCT_NAME , PRICE , QUANTITY , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.changes.ExampleOrderItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ExampleOrderItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public ExampleOrderItem setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 商品名称
		 * @param productName 商品名称
		 * @return 当前对象
		*/
		public ExampleOrderItem setProductName(String productName) {
			super.change(PRODUCT_NAME,super.getProductName(),productName);
			super.setProductName(productName);
			return this;
		}
		
		/**
		 * 设置 单价
		 * @param price 单价
		 * @return 当前对象
		*/
		public ExampleOrderItem setPrice(BigDecimal price) {
			super.change(PRICE,super.getPrice(),price);
			super.setPrice(price);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param quantity 数量
		 * @return 当前对象
		*/
		public ExampleOrderItem setQuantity(Integer quantity) {
			super.change(QUANTITY,super.getQuantity(),quantity);
			super.setQuantity(quantity);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ExampleOrderItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ExampleOrderItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ExampleOrderItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ExampleOrderItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ExampleOrderItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ExampleOrderItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ExampleOrderItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ExampleOrderItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ExampleOrderItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}