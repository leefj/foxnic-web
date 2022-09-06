package org.github.foxnic.web.domain.dataperm.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.dataperm.ExampleOrder;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.dataperm.ExampleShop;
import org.github.foxnic.web.domain.dataperm.ExampleProduct;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:45:37
 * @sign 383E53307C814C73B5C0D1F7AF14F6BD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ExampleOrderMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 商品ID , 类型: java.lang.String
	*/
	public static final String PRODUCT_ID="productId";
	
	/**
	 * 商品ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> PRODUCT_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,PRODUCT_ID, java.lang.String.class, "商品ID", "商品ID", java.lang.String.class, null);
	
	/**
	 * 售价 , 类型: java.math.BigDecimal
	*/
	public static final String PRICE="price";
	
	/**
	 * 售价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.math.BigDecimal> PRICE_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,PRICE, java.math.BigDecimal.class, "售价", "售价", java.math.BigDecimal.class, null);
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final String QUANTITY="quantity";
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.Integer> QUANTITY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,QUANTITY, java.lang.Integer.class, "数量", "数量", java.lang.Integer.class, null);
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,AMOUNT, java.math.BigDecimal.class, "金额", "金额", java.math.BigDecimal.class, null);
	
	/**
	 * 店铺ID , 类型: java.lang.String
	*/
	public static final String SHOP_ID="shopId";
	
	/**
	 * 店铺ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> SHOP_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,SHOP_ID, java.lang.String.class, "店铺ID", "店铺ID", java.lang.String.class, null);
	
	/**
	 * 销售人员ID , 类型: java.lang.String
	*/
	public static final String SALES_ID="salesId";
	
	/**
	 * 销售人员ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> SALES_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,SALES_ID, java.lang.String.class, "销售人员ID", "销售人员ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 店铺 , 类型: org.github.foxnic.web.domain.dataperm.ExampleShop
	*/
	public static final String SHOP="shop";
	
	/**
	 * 店铺 , 类型: org.github.foxnic.web.domain.dataperm.ExampleShop
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,org.github.foxnic.web.domain.dataperm.ExampleShop> SHOP_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,SHOP, org.github.foxnic.web.domain.dataperm.ExampleShop.class, "店铺", "店铺", org.github.foxnic.web.domain.dataperm.ExampleShop.class, null);
	
	/**
	 * 商品 , 类型: org.github.foxnic.web.domain.dataperm.ExampleProduct
	*/
	public static final String PRODUCT="product";
	
	/**
	 * 商品 , 类型: org.github.foxnic.web.domain.dataperm.ExampleProduct
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,org.github.foxnic.web.domain.dataperm.ExampleProduct> PRODUCT_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,PRODUCT, org.github.foxnic.web.domain.dataperm.ExampleProduct.class, "商品", "商品", org.github.foxnic.web.domain.dataperm.ExampleProduct.class, null);
	
	/**
	 * 导购 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String SALES="sales";
	
	/**
	 * 导购 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.dataperm.ExampleOrder,org.github.foxnic.web.domain.hrm.Employee> SALES_PROP = new BeanProperty(org.github.foxnic.web.domain.dataperm.ExampleOrder.class ,SALES, org.github.foxnic.web.domain.hrm.Employee.class, "导购", "导购", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PRODUCT_ID , PRICE , QUANTITY , AMOUNT , SHOP_ID , SALES_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SHOP , PRODUCT , SALES };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.dataperm.ExampleOrder {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ExampleOrder setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 商品ID
		 * @param productId 商品ID
		 * @return 当前对象
		*/
		public ExampleOrder setProductId(String productId) {
			super.change(PRODUCT_ID,super.getProductId(),productId);
			super.setProductId(productId);
			return this;
		}
		
		/**
		 * 设置 售价
		 * @param price 售价
		 * @return 当前对象
		*/
		public ExampleOrder setPrice(BigDecimal price) {
			super.change(PRICE,super.getPrice(),price);
			super.setPrice(price);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param quantity 数量
		 * @return 当前对象
		*/
		public ExampleOrder setQuantity(Integer quantity) {
			super.change(QUANTITY,super.getQuantity(),quantity);
			super.setQuantity(quantity);
			return this;
		}
		
		/**
		 * 设置 金额
		 * @param amount 金额
		 * @return 当前对象
		*/
		public ExampleOrder setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 店铺ID
		 * @param shopId 店铺ID
		 * @return 当前对象
		*/
		public ExampleOrder setShopId(String shopId) {
			super.change(SHOP_ID,super.getShopId(),shopId);
			super.setShopId(shopId);
			return this;
		}
		
		/**
		 * 设置 销售人员ID
		 * @param salesId 销售人员ID
		 * @return 当前对象
		*/
		public ExampleOrder setSalesId(String salesId) {
			super.change(SALES_ID,super.getSalesId(),salesId);
			super.setSalesId(salesId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ExampleOrder setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ExampleOrder setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ExampleOrder setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ExampleOrder setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ExampleOrder setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ExampleOrder setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ExampleOrder setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ExampleOrder setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 店铺
		 * @param shop 店铺
		 * @return 当前对象
		*/
		public ExampleOrder setShop(ExampleShop shop) {
			super.change(SHOP,super.getShop(),shop);
			super.setShop(shop);
			return this;
		}
		
		/**
		 * 设置 商品
		 * @param product 商品
		 * @return 当前对象
		*/
		public ExampleOrder setProduct(ExampleProduct product) {
			super.change(PRODUCT,super.getProduct(),product);
			super.setProduct(product);
			return this;
		}
		
		/**
		 * 设置 导购
		 * @param sales 导购
		 * @return 当前对象
		*/
		public ExampleOrder setSales(Employee sales) {
			super.change(SALES,super.getSales(),sales);
			super.setSales(sales);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ExampleOrder clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ExampleOrder duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAmount(this.getAmount());
			inst.setQuantity(this.getQuantity());
			inst.setProductId(this.getProductId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setSalesId(this.getSalesId());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setPrice(this.getPrice());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setShopId(this.getShopId());
			if(all) {
				inst.setProduct(this.getProduct());
				inst.setShop(this.getShop());
				inst.setSales(this.getSales());
			}
			inst.clearModifies();
			return inst;
		}

	}
}