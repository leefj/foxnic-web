package com.scientific.tailoring.domain.crm.meta;

import com.scientific.tailoring.domain.crm.FavoriteProductModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 0C7F5816C7C776C306418A5D03AA3E0B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavoriteProductModelMeta {
	
	/**
	 * 商品主图ID
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 商品名称
	*/
	public static final String PRODUCT_NAME="productName";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ IMAGE_ID , PRODUCT_NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.crm.FavoriteProductModel {
		
		/**
		 * 设置 商品主图ID
		 * @param imageId 商品主图ID
		 * @return 当前对象
		*/
		public FavoriteProductModel setImageId(Long imageId) {
			super.change(IMAGE_ID,super.getImageId(),imageId);
			super.setImageId(imageId);
			return this;
		}
		
		/**
		 * 设置 商品名称
		 * @param productName 商品名称
		 * @return 当前对象
		*/
		public FavoriteProductModel setProductName(Long productName) {
			super.change(PRODUCT_NAME,super.getProductName(),productName);
			super.setProductName(productName);
			return this;
		}
}
}