package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.ProductOrderModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 2D4623A6894901CD1618F3EEDD50EF9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductOrderModelMeta {
	
	/**
	 * 订单ID
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 订单与商品的关系ID
	*/
	public static final String ORDER_PRODUCT_REL_ID="orderProductRelId";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ORDER_ID , ORDER_PRODUCT_REL_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.ProductOrderModel {
		
		/**
		 * 设置 订单ID
		 * @param orderId 订单ID
		 * @return 当前对象
		*/
		public ProductOrderModel setOrderId(Long orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 订单与商品的关系ID
		 * @param orderProductRelId 订单与商品的关系ID
		 * @return 当前对象
		*/
		public ProductOrderModel setOrderProductRelId(Long orderProductRelId) {
			super.change(ORDER_PRODUCT_REL_ID,super.getOrderProductRelId(),orderProductRelId);
			super.setOrderProductRelId(orderProductRelId);
			return this;
		}
}
}