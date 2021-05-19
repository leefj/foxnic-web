package com.scientific.tailoring.domain.product;

import io.swagger.annotations.ApiModelProperty;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 2D4623A6894901CD1618F3EEDD50EF9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductOrderModel extends Product {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单ID
	*/
	@ApiModelProperty(required = false,value="订单ID" , notes = "")
	private Long orderId;
	
	/**
	 * 订单与商品的关系ID
	*/
	@ApiModelProperty(required = false,value="订单与商品的关系ID" , notes = "")
	private Long orderProductRelId;
	
	/**
	 * 获得 订单ID<br>
	 * @return 订单ID
	*/
	public Long getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	public ProductOrderModel setOrderId(Long orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 添加 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 订单与商品的关系ID<br>
	 * @return 订单与商品的关系ID
	*/
	public Long getOrderProductRelId() {
		return orderProductRelId;
	}
	
	/**
	 * 设置 订单与商品的关系ID
	 * @param orderProductRelId 订单与商品的关系ID
	 * @return 当前对象
	*/
	public ProductOrderModel setOrderProductRelId(Long orderProductRelId) {
		this.orderProductRelId=orderProductRelId;
		return this;
	}
	
	/**
	 * 添加 订单与商品的关系ID
	 * @param orderProductRelId 订单与商品的关系ID
	 * @return 当前对象
	*/
}