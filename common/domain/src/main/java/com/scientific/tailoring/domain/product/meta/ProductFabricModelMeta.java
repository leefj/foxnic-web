package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.ProductFabricModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 89325F9EF65D0ECEA658F57FDBA3E481
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductFabricModelMeta {
	
	/**
	 * 商品名称
	*/
	public static final String PRODUCT_NAME="productName";
	
	/**
	 * 面料名称
	*/
	public static final String FABRIC_NAME="fabricName";
	
	/**
	 * 效果ID
	*/
	public static final String EFFECT_FILE_ID="effectFileId";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PRODUCT_NAME , FABRIC_NAME , EFFECT_FILE_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.ProductFabricModel {
		
		/**
		 * 设置 商品名称
		 * @param productName 商品名称
		 * @return 当前对象
		*/
		public ProductFabricModel setProductName(String productName) {
			super.change(PRODUCT_NAME,super.getProductName(),productName);
			super.setProductName(productName);
			return this;
		}
		
		/**
		 * 设置 面料名称
		 * @param fabricName 面料名称
		 * @return 当前对象
		*/
		public ProductFabricModel setFabricName(String fabricName) {
			super.change(FABRIC_NAME,super.getFabricName(),fabricName);
			super.setFabricName(fabricName);
			return this;
		}
		
		/**
		 * 设置 效果ID
		 * @param effectFileId 效果ID
		 * @return 当前对象
		*/
		public ProductFabricModel setEffectFileId(String effectFileId) {
			super.change(EFFECT_FILE_ID,super.getEffectFileId(),effectFileId);
			super.setEffectFileId(effectFileId);
			return this;
		}
}
}