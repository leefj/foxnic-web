package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.Order;
import java.util.Date;
import com.github.foxnic.dao.relation.Catalog;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.system.DictItem;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:38
 * @sign 161A0CFEF600D36D790E6D8D72F83316
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OrderMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 订单号
	*/
	public static final String ORDER_NO="orderNo";
	
	/**
	 * 公司ID
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 预约时间
	*/
	public static final String APPOINTMENT_TIME="appointmentTime";
	
	/**
	 * 订单状态
	*/
	public static final String STATUS="status";
	
	/**
	 * 城市ID
	*/
	public static final String CITY_ID="cityId";
	
	/**
	 * 省份ID
	*/
	public static final String PROVINCE_ID="provinceId";
	
	/**
	 * 区县ID
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 镇ID
	*/
	public static final String TOWN_ID="townId";
	
	/**
	 * 详细地址
	*/
	public static final String ADDRESS_DETAIL="addressDetail";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 测量总量
	*/
	public static final String MEASURE_COUNT="measureCount";
	
	/**
	 * 测量总量
	*/
	public static final String MEASURE_STATUS_COUNT="measureStatusCount";
	
	/**
	 * 公司信息
	*/
	public static final String COMPANY="company";
	
	/**
	 * 状态信息
	*/
	public static final String STATUS_DICT_ITEM="statusDictItem";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_NO , COMPANY_ID , APPOINTMENT_TIME , STATUS , CITY_ID , PROVINCE_ID , AREA_ID , TOWN_ID , ADDRESS_DETAIL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MEASURE_COUNT , MEASURE_STATUS_COUNT , COMPANY , STATUS_DICT_ITEM };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.Order {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public Order setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 订单号
		 * @param orderNo 订单号
		 * @return 当前对象
		*/
		public Order setOrderNo(String orderNo) {
			super.change(ORDER_NO,super.getOrderNo(),orderNo);
			super.setOrderNo(orderNo);
			return this;
		}
		
		/**
		 * 设置 公司ID
		 * @param companyId 公司ID
		 * @return 当前对象
		*/
		public Order setCompanyId(Long companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 预约时间
		 * @param appointmentTime 预约时间
		 * @return 当前对象
		*/
		public Order setAppointmentTime(Date appointmentTime) {
			super.change(APPOINTMENT_TIME,super.getAppointmentTime(),appointmentTime);
			super.setAppointmentTime(appointmentTime);
			return this;
		}
		
		/**
		 * 设置 订单状态
		 * @param status 订单状态
		 * @return 当前对象
		*/
		public Order setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 城市ID
		 * @param cityId 城市ID
		 * @return 当前对象
		*/
		public Order setCityId(Integer cityId) {
			super.change(CITY_ID,super.getCityId(),cityId);
			super.setCityId(cityId);
			return this;
		}
		
		/**
		 * 设置 省份ID
		 * @param provinceId 省份ID
		 * @return 当前对象
		*/
		public Order setProvinceId(Integer provinceId) {
			super.change(PROVINCE_ID,super.getProvinceId(),provinceId);
			super.setProvinceId(provinceId);
			return this;
		}
		
		/**
		 * 设置 区县ID
		 * @param areaId 区县ID
		 * @return 当前对象
		*/
		public Order setAreaId(Integer areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 镇ID
		 * @param townId 镇ID
		 * @return 当前对象
		*/
		public Order setTownId(Integer townId) {
			super.change(TOWN_ID,super.getTownId(),townId);
			super.setTownId(townId);
			return this;
		}
		
		/**
		 * 设置 详细地址
		 * @param addressDetail 详细地址
		 * @return 当前对象
		*/
		public Order setAddressDetail(String addressDetail) {
			super.change(ADDRESS_DETAIL,super.getAddressDetail(),addressDetail);
			super.setAddressDetail(addressDetail);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Order setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Order setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Order setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Order setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Order setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Order setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Order setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Order setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 测量总量
		 * @param measureCount 测量总量
		 * @return 当前对象
		*/
		public Order setMeasureCount(Integer measureCount) {
			super.change(MEASURE_COUNT,super.getMeasureCount(),measureCount);
			super.setMeasureCount(measureCount);
			return this;
		}
		
		/**
		 * 设置 测量总量
		 * @param measureStatusCount 测量总量
		 * @return 当前对象
		*/
		public Order setMeasureStatusCount(Catalog measureStatusCount) {
			super.change(MEASURE_STATUS_COUNT,super.getMeasureStatusCount(),measureStatusCount);
			super.setMeasureStatusCount(measureStatusCount);
			return this;
		}
		
		/**
		 * 设置 公司信息
		 * @param company 公司信息
		 * @return 当前对象
		*/
		public Order setCompany(Company company) {
			super.change(COMPANY,super.getCompany(),company);
			super.setCompany(company);
			return this;
		}
		
		/**
		 * 设置 状态信息
		 * @param statusDictItem 状态信息
		 * @return 当前对象
		*/
		public Order setStatusDictItem(DictItem statusDictItem) {
			super.change(STATUS_DICT_ITEM,super.getStatusDictItem(),statusDictItem);
			super.setStatusDictItem(statusDictItem);
			return this;
		}
}
}