package com.scientific.tailoring.domain.product;

import io.swagger.annotations.ApiModelProperty;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 89325F9EF65D0ECEA658F57FDBA3E481
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductFabricModel extends ProductFabric {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品名称
	*/
	@ApiModelProperty(required = false,value="商品名称" , notes = "")
	private String productName;
	
	/**
	 * 面料名称
	*/
	@ApiModelProperty(required = false,value="面料名称" , notes = "")
	private String fabricName;
	
	/**
	 * 效果ID
	*/
	@ApiModelProperty(required = false,value="效果ID" , notes = "")
	private String effectFileId;
	
	/**
	 * 获得 商品名称<br>
	 * @return 商品名称
	*/
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 设置 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
	public ProductFabricModel setProductName(String productName) {
		this.productName=productName;
		return this;
	}
	
	/**
	 * 添加 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 面料名称<br>
	 * @return 面料名称
	*/
	public String getFabricName() {
		return fabricName;
	}
	
	/**
	 * 设置 面料名称
	 * @param fabricName 面料名称
	 * @return 当前对象
	*/
	public ProductFabricModel setFabricName(String fabricName) {
		this.fabricName=fabricName;
		return this;
	}
	
	/**
	 * 添加 面料名称
	 * @param fabricName 面料名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 效果ID<br>
	 * @return 效果ID
	*/
	public String getEffectFileId() {
		return effectFileId;
	}
	
	/**
	 * 设置 效果ID
	 * @param effectFileId 效果ID
	 * @return 当前对象
	*/
	public ProductFabricModel setEffectFileId(String effectFileId) {
		this.effectFileId=effectFileId;
		return this;
	}
	
	/**
	 * 添加 效果ID
	 * @param effectFileId 效果ID
	 * @return 当前对象
	*/
}