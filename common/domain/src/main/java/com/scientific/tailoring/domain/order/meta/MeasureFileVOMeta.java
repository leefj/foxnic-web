package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.MeasureFileVO;
import java.util.List;
import com.scientific.tailoring.domain.order.MeasureFile;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 213B2BE0994D2B0EDAA4F9C3530AC370
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureFileVOMeta extends MeasureFileMeta {
	
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
	 * 测量文件清单
	*/
	public static final String MEASURE_FILES="measureFiles";
	
	/**
	 * 测量人员ID
	*/
	public static final String BODY_ID="bodyId";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , SEARCH_VALUE , IDS , MEASURE_FILES , BODY_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.MeasureFileVO {
		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MeasureFileVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MeasureFileVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MeasureFileVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MeasureFileVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MeasureFileVO setIds(List<Integer> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 测量文件清单
		 * @param measureFiles 测量文件清单
		 * @return 当前对象
		*/
		public MeasureFileVO setMeasureFiles(List<MeasureFile> measureFiles) {
			super.change(MEASURE_FILES,super.getMeasureFiles(),measureFiles);
			super.setMeasureFiles(measureFiles);
			return this;
		}
		
		/**
		 * 设置 测量人员ID
		 * @param bodyId 测量人员ID
		 * @return 当前对象
		*/
		public MeasureFileVO setBodyId(Long bodyId) {
			super.change(BODY_ID,super.getBodyId(),bodyId);
			super.setBodyId(bodyId);
			return this;
		}
}
}