package com.scientific.tailoring.domain.crm;

import io.swagger.annotations.ApiModelProperty;



/**
 * 收藏夹内的收藏信息(聚合产品信息)
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 0C7F5816C7C776C306418A5D03AA3E0B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavoriteProductModel extends FavoriteProduct {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 商品主图ID
	*/
	@ApiModelProperty(required = false,value="商品主图ID" , notes = "")
	private Long imageId;
	
	/**
	 * 商品名称
	*/
	@ApiModelProperty(required = false,value="商品名称" , notes = "")
	private Long productName;
	
	/**
	 * 获得 商品主图ID<br>
	 * @return 商品主图ID
	*/
	public Long getImageId() {
		return imageId;
	}
	
	/**
	 * 设置 商品主图ID
	 * @param imageId 商品主图ID
	 * @return 当前对象
	*/
	public FavoriteProductModel setImageId(Long imageId) {
		this.imageId=imageId;
		return this;
	}
	
	/**
	 * 添加 商品主图ID
	 * @param imageId 商品主图ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 商品名称<br>
	 * @return 商品名称
	*/
	public Long getProductName() {
		return productName;
	}
	
	/**
	 * 设置 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
	public FavoriteProductModel setProductName(Long productName) {
		this.productName=productName;
		return this;
	}
	
	/**
	 * 添加 商品名称
	 * @param productName 商品名称
	 * @return 当前对象
	*/
}