package com.scientific.tailoring.domain.product.meta;

import com.scientific.tailoring.domain.product.ProductVO;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 01:20:30
 * @sign C1D0612971CBE6382AC7BA5820A25F78
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductVOMeta extends ProductMeta {
	
	/**
	 * 页码
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 分页大小
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 搜索字段
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索的值
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final String IDS="ids";
	
	/**
	 * 标签ID , 指定需要传入的标签ID数组
	*/
	public static final String LABEL_IDS="labelIds";
	
	/**
	 * 图片ID , 指定需要传入的图片ID数组，其中第一个为主图
	*/
	public static final String IMAGE_IDS="imageIds";
	
	/**
	 * 面料ID , 指定需要传入的面料ID数组
	*/
	public static final String FABRIC_IDS="fabricIds";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , SEARCH_VALUE , IDS , LABEL_IDS , IMAGE_IDS , FABRIC_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.product.ProductVO {
		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ProductVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ProductVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ProductVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ProductVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ProductVO setIds(List<Long> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 标签ID
		 * @param labelIds 标签ID
		 * @return 当前对象
		*/
		public ProductVO setLabelIds(List<Integer> labelIds) {
			super.change(LABEL_IDS,super.getLabelIds(),labelIds);
			super.setLabelIds(labelIds);
			return this;
		}
		
		/**
		 * 设置 图片ID
		 * @param imageIds 图片ID
		 * @return 当前对象
		*/
		public ProductVO setImageIds(List<Long> imageIds) {
			super.change(IMAGE_IDS,super.getImageIds(),imageIds);
			super.setImageIds(imageIds);
			return this;
		}
		
		/**
		 * 设置 面料ID
		 * @param fabricIds 面料ID
		 * @return 当前对象
		*/
		public ProductVO setFabricIds(List<Integer> fabricIds) {
			super.change(FABRIC_IDS,super.getFabricIds(),fabricIds);
			super.setFabricIds(fabricIds);
			return this;
		}
}
}