package com.scientific.tailoring.domain.order;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import java.util.HashMap;



/**
 * 订单模型(聚合产品、地址、结果汇总等信息)
 * @author 李方捷
 * @since 2021-05-17 01:41:47
 * @sign 92290B725A543E33640B3A4B1B34DF09
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AppOrderModel extends Order {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单
	*/
	@ApiModelProperty(required = false,value="订单" , notes = "")
	private String statusName;
	
	/**
	 * 产品图ID
	*/
	@ApiModelProperty(required = false,value="产品图ID" , notes = "")
	private Long imageId;
	
	/**
	 * 公司名称
	*/
	@ApiModelProperty(required = false,value="公司名称" , notes = "")
	private String companyName;
	
	/**
	 * 省份名称
	*/
	@ApiModelProperty(required = false,value="省份名称" , notes = "")
	private String provinceName;
	
	/**
	 * 城市名称
	*/
	@ApiModelProperty(required = false,value="城市名称" , notes = "")
	private String cityName;
	
	/**
	 * 区县名称
	*/
	@ApiModelProperty(required = false,value="区县名称" , notes = "")
	private String areaName;
	
	/**
	 * 镇名称
	*/
	@ApiModelProperty(required = false,value="镇名称" , notes = "")
	private String townName;
	
	/**
	 * 量体地址
	*/
	@ApiModelProperty(required = false,value="量体地址" , notes = "")
	private String fullAddress;
	
	/**
	 * 测量状态的汇总统计
	*/
	@ApiModelProperty(required = false,value="测量状态的汇总统计" , notes = "")
	private Map<String,Integer> statusSummary;
	
	/**
	 * 获得 订单<br>
	 * @return 订单
	*/
	public String getStatusName() {
		return statusName;
	}
	
	/**
	 * 设置 订单
	 * @param statusName 订单
	 * @return 当前对象
	*/
	public AppOrderModel setStatusName(String statusName) {
		this.statusName=statusName;
		return this;
	}
	
	/**
	 * 添加 订单
	 * @param statusName 订单
	 * @return 当前对象
	*/
	
	/**
	 * 获得 产品图ID<br>
	 * @return 产品图ID
	*/
	public Long getImageId() {
		return imageId;
	}
	
	/**
	 * 设置 产品图ID
	 * @param imageId 产品图ID
	 * @return 当前对象
	*/
	public AppOrderModel setImageId(Long imageId) {
		this.imageId=imageId;
		return this;
	}
	
	/**
	 * 添加 产品图ID
	 * @param imageId 产品图ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司名称<br>
	 * @return 公司名称
	*/
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * 设置 公司名称
	 * @param companyName 公司名称
	 * @return 当前对象
	*/
	public AppOrderModel setCompanyName(String companyName) {
		this.companyName=companyName;
		return this;
	}
	
	/**
	 * 添加 公司名称
	 * @param companyName 公司名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 省份名称<br>
	 * @return 省份名称
	*/
	public String getProvinceName() {
		return provinceName;
	}
	
	/**
	 * 设置 省份名称
	 * @param provinceName 省份名称
	 * @return 当前对象
	*/
	public AppOrderModel setProvinceName(String provinceName) {
		this.provinceName=provinceName;
		return this;
	}
	
	/**
	 * 添加 省份名称
	 * @param provinceName 省份名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 城市名称<br>
	 * @return 城市名称
	*/
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * 设置 城市名称
	 * @param cityName 城市名称
	 * @return 当前对象
	*/
	public AppOrderModel setCityName(String cityName) {
		this.cityName=cityName;
		return this;
	}
	
	/**
	 * 添加 城市名称
	 * @param cityName 城市名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 区县名称<br>
	 * @return 区县名称
	*/
	public String getAreaName() {
		return areaName;
	}
	
	/**
	 * 设置 区县名称
	 * @param areaName 区县名称
	 * @return 当前对象
	*/
	public AppOrderModel setAreaName(String areaName) {
		this.areaName=areaName;
		return this;
	}
	
	/**
	 * 添加 区县名称
	 * @param areaName 区县名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 镇名称<br>
	 * @return 镇名称
	*/
	public String getTownName() {
		return townName;
	}
	
	/**
	 * 设置 镇名称
	 * @param townName 镇名称
	 * @return 当前对象
	*/
	public AppOrderModel setTownName(String townName) {
		this.townName=townName;
		return this;
	}
	
	/**
	 * 添加 镇名称
	 * @param townName 镇名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 量体地址<br>
	 * @return 量体地址
	*/
	public String getFullAddress() {
		return fullAddress;
	}
	
	/**
	 * 设置 量体地址
	 * @param fullAddress 量体地址
	 * @return 当前对象
	*/
	public AppOrderModel setFullAddress(String fullAddress) {
		this.fullAddress=fullAddress;
		return this;
	}
	
	/**
	 * 添加 量体地址
	 * @param fullAddress 量体地址
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量状态的汇总统计<br>
	 * @return 测量状态的汇总统计
	*/
	public Map<String,Integer> getStatusSummary() {
		return statusSummary;
	}
	
	/**
	 * 设置 测量状态的汇总统计
	 * @param statusSummary 测量状态的汇总统计
	 * @return 当前对象
	*/
	public AppOrderModel setStatusSummary(Map<String,Integer> statusSummary) {
		this.statusSummary=statusSummary;
		return this;
	}
	
	/**
	 * 添加 测量状态的汇总统计
	 * @param statusSummary 测量状态的汇总统计
	 * @return 当前对象
	*/
	public AppOrderModel putStatusSummary(String key,Integer statusSummary) {
		if(this.statusSummary==null) this.statusSummary=new HashMap<>();
		this.statusSummary.put(key ,statusSummary);
		return this;
	}
}