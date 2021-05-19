package com.scientific.tailoring.domain.crm;

import io.swagger.annotations.ApiModelProperty;



/**
 * 收藏夹目录(聚合产品信息)
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 432E2F4F4D4995C8B5C23D97B29B07A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavoriteFolderModel extends FavoriteFolder {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 目录内收藏的商品数量
	*/
	@ApiModelProperty(required = false,value="目录内收藏的商品数量" , notes = "")
	private Integer product_count;
	
	/**
	 * 获得 目录内收藏的商品数量<br>
	 * @return 目录内收藏的商品数量
	*/
	public Integer getProductCount() {
		return product_count;
	}
	
	/**
	 * 设置 目录内收藏的商品数量
	 * @param product_count 目录内收藏的商品数量
	 * @return 当前对象
	*/
	public FavoriteFolderModel setProductCount(Integer product_count) {
		this.product_count=product_count;
		return this;
	}
	
	/**
	 * 添加 目录内收藏的商品数量
	 * @param product_count 目录内收藏的商品数量
	 * @return 当前对象
	*/
}