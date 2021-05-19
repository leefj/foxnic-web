package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.VirtualLibraryModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:18:17
 * @sign 0BB2BDCC607BC8F4830E8CA73087C92A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VirtualLibraryModelMeta {
	
	/**
	 * 商品名称
	*/
	public static final String PRODUCT_NAME="productName";
	
	/**
	 * 面料名称
	*/
	public static final String FABRIC_NAME="fabricName";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PRODUCT_NAME , FABRIC_NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.VirtualLibraryModel {
		
		/**
		 * 设置 商品名称
		 * @param productName 商品名称
		 * @return 当前对象
		*/
		public VirtualLibraryModel setProductName(String productName) {
			super.change(PRODUCT_NAME,super.getProductName(),productName);
			super.setProductName(productName);
			return this;
		}
		
		/**
		 * 设置 面料名称
		 * @param fabricName 面料名称
		 * @return 当前对象
		*/
		public VirtualLibraryModel setFabricName(String fabricName) {
			super.change(FABRIC_NAME,super.getFabricName(),fabricName);
			super.setFabricName(fabricName);
			return this;
		}
}
}