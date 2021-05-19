package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.AppOrderModel;
import java.util.Map;



/**
 * @author 李方捷
 * @since 2021-05-17 01:41:47
 * @sign 92290B725A543E33640B3A4B1B34DF09
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AppOrderModelMeta {
	
	/**
	 * 订单
	*/
	public static final String STATUS_NAME="statusName";
	
	/**
	 * 产品图ID
	*/
	public static final String IMAGE_ID="imageId";
	
	/**
	 * 公司名称
	*/
	public static final String COMPANY_NAME="companyName";
	
	/**
	 * 省份名称
	*/
	public static final String PROVINCE_NAME="provinceName";
	
	/**
	 * 城市名称
	*/
	public static final String CITY_NAME="cityName";
	
	/**
	 * 区县名称
	*/
	public static final String AREA_NAME="areaName";
	
	/**
	 * 镇名称
	*/
	public static final String TOWN_NAME="townName";
	
	/**
	 * 量体地址
	*/
	public static final String FULL_ADDRESS="fullAddress";
	
	/**
	 * 测量状态的汇总统计
	*/
	public static final String STATUS_SUMMARY="statusSummary";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ STATUS_NAME , IMAGE_ID , COMPANY_NAME , PROVINCE_NAME , CITY_NAME , AREA_NAME , TOWN_NAME , FULL_ADDRESS , STATUS_SUMMARY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.AppOrderModel {
		
		/**
		 * 设置 订单
		 * @param statusName 订单
		 * @return 当前对象
		*/
		public AppOrderModel setStatusName(String statusName) {
			super.change(STATUS_NAME,super.getStatusName(),statusName);
			super.setStatusName(statusName);
			return this;
		}
		
		/**
		 * 设置 产品图ID
		 * @param imageId 产品图ID
		 * @return 当前对象
		*/
		public AppOrderModel setImageId(Long imageId) {
			super.change(IMAGE_ID,super.getImageId(),imageId);
			super.setImageId(imageId);
			return this;
		}
		
		/**
		 * 设置 公司名称
		 * @param companyName 公司名称
		 * @return 当前对象
		*/
		public AppOrderModel setCompanyName(String companyName) {
			super.change(COMPANY_NAME,super.getCompanyName(),companyName);
			super.setCompanyName(companyName);
			return this;
		}
		
		/**
		 * 设置 省份名称
		 * @param provinceName 省份名称
		 * @return 当前对象
		*/
		public AppOrderModel setProvinceName(String provinceName) {
			super.change(PROVINCE_NAME,super.getProvinceName(),provinceName);
			super.setProvinceName(provinceName);
			return this;
		}
		
		/**
		 * 设置 城市名称
		 * @param cityName 城市名称
		 * @return 当前对象
		*/
		public AppOrderModel setCityName(String cityName) {
			super.change(CITY_NAME,super.getCityName(),cityName);
			super.setCityName(cityName);
			return this;
		}
		
		/**
		 * 设置 区县名称
		 * @param areaName 区县名称
		 * @return 当前对象
		*/
		public AppOrderModel setAreaName(String areaName) {
			super.change(AREA_NAME,super.getAreaName(),areaName);
			super.setAreaName(areaName);
			return this;
		}
		
		/**
		 * 设置 镇名称
		 * @param townName 镇名称
		 * @return 当前对象
		*/
		public AppOrderModel setTownName(String townName) {
			super.change(TOWN_NAME,super.getTownName(),townName);
			super.setTownName(townName);
			return this;
		}
		
		/**
		 * 设置 量体地址
		 * @param fullAddress 量体地址
		 * @return 当前对象
		*/
		public AppOrderModel setFullAddress(String fullAddress) {
			super.change(FULL_ADDRESS,super.getFullAddress(),fullAddress);
			super.setFullAddress(fullAddress);
			return this;
		}
		
		/**
		 * 设置 测量状态的汇总统计
		 * @param statusSummary 测量状态的汇总统计
		 * @return 当前对象
		*/
		public AppOrderModel setStatusSummary(Map<String,Integer> statusSummary) {
			super.change(STATUS_SUMMARY,super.getStatusSummary(),statusSummary);
			super.setStatusSummary(statusSummary);
			return this;
		}
}
}