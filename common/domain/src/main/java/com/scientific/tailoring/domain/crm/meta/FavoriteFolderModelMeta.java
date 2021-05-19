package com.scientific.tailoring.domain.crm.meta;

import com.scientific.tailoring.domain.crm.FavoriteFolderModel;



/**
 * @author 李方捷
 * @since 2021-05-17 01:13:38
 * @sign 432E2F4F4D4995C8B5C23D97B29B07A3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class FavoriteFolderModelMeta {
	
	/**
	 * 目录内收藏的商品数量
	*/
	public static final String PRODUCT_COUNT="product_count";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PRODUCT_COUNT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.crm.FavoriteFolderModel {
		
		/**
		 * 设置 目录内收藏的商品数量
		 * @param product_count 目录内收藏的商品数量
		 * @return 当前对象
		*/
		public FavoriteFolderModel setProductCount(Integer product_count) {
			super.change(PRODUCT_COUNT,super.getProductCount(),product_count);
			super.setProductCount(product_count);
			return this;
		}
}
}