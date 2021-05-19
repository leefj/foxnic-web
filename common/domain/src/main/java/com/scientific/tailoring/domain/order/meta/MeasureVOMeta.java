package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.MeasureVO;
import java.util.List;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 2DF44C7B8D828E5BB12284EBEE05A8DB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureVOMeta extends MeasureMeta {
	
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
	 * 姓名
	*/
	public static final String BODY_NAME="bodyName";
	
	/**
	 * body表的ID字段
	*/
	public static final String BID="bid";
	
	/**
	 * 部门
	*/
	public static final String BODY_DEPT="bodyDept";
	
	/**
	 * 性别
	*/
	public static final String BODY_SEX="bodySex";
	
	/**
	 * 身高
	*/
	public static final String BODY_HEIGHT="bodyHeight";
	
	/**
	 * 状态列表 , 指定需要过滤的状态类型
	*/
	public static final String STATUS_LIST="statusList";
	
	/**
	 * 测量类型 , 净体body;着装outfit
	*/
	public static final String MEASURE_TYPE="measureType";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , SEARCH_VALUE , IDS , BODY_NAME , BID , BODY_DEPT , BODY_SEX , BODY_HEIGHT , STATUS_LIST , MEASURE_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.MeasureVO {
		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MeasureVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MeasureVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MeasureVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MeasureVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MeasureVO setIds(List<Long> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param bodyName 姓名
		 * @return 当前对象
		*/
		public MeasureVO setBodyName(String bodyName) {
			super.change(BODY_NAME,super.getBodyName(),bodyName);
			super.setBodyName(bodyName);
			return this;
		}
		
		/**
		 * 设置 body表的ID字段
		 * @param bid body表的ID字段
		 * @return 当前对象
		*/
		public MeasureVO setBid(Long bid) {
			super.change(BID,super.getBid(),bid);
			super.setBid(bid);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param bodyDept 部门
		 * @return 当前对象
		*/
		public MeasureVO setBodyDept(String bodyDept) {
			super.change(BODY_DEPT,super.getBodyDept(),bodyDept);
			super.setBodyDept(bodyDept);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param bodySex 性别
		 * @return 当前对象
		*/
		public MeasureVO setBodySex(String bodySex) {
			super.change(BODY_SEX,super.getBodySex(),bodySex);
			super.setBodySex(bodySex);
			return this;
		}
		
		/**
		 * 设置 身高
		 * @param bodyHeight 身高
		 * @return 当前对象
		*/
		public MeasureVO setBodyHeight(Integer bodyHeight) {
			super.change(BODY_HEIGHT,super.getBodyHeight(),bodyHeight);
			super.setBodyHeight(bodyHeight);
			return this;
		}
		
		/**
		 * 设置 状态列表
		 * @param statusList 状态列表
		 * @return 当前对象
		*/
		public MeasureVO setStatusList(List<String> statusList) {
			super.change(STATUS_LIST,super.getStatusList(),statusList);
			super.setStatusList(statusList);
			return this;
		}
		
		/**
		 * 设置 测量类型
		 * @param measureType 测量类型
		 * @return 当前对象
		*/
		public MeasureVO setMeasureType(String measureType) {
			super.change(MEASURE_TYPE,super.getMeasureType(),measureType);
			super.setMeasureType(measureType);
			return this;
		}
}
}