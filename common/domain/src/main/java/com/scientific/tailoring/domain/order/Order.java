package com.scientific.tailoring.domain.order;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_ORDER;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.github.foxnic.dao.relation.Catalog;
import com.scientific.tailoring.domain.crm.Company;
import com.scientific.tailoring.domain.system.DictItem;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:38
 * @sign BEC12AAF7D94D16C9BF76AF3C15C6465
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "odr_order")
public class Order extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =ODR_ORDER.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 订单号：订单号
	*/
	@ApiModelProperty(required = true,value="订单号" , notes = "订单号")
	private String orderNo;
	
	/**
	 * 公司ID：公司ID
	*/
	@ApiModelProperty(required = false,value="公司ID" , notes = "公司ID")
	private Long companyId;
	
	/**
	 * 预约时间：预约时间
	*/
	@ApiModelProperty(required = false,value="预约时间" , notes = "预约时间")
	private Date appointmentTime;
	
	/**
	 * 订单状态：订单状态
	*/
	@ApiModelProperty(required = true,value="订单状态" , notes = "订单状态")
	private String status;
	
	/**
	 * 城市ID：城市ID
	*/
	@ApiModelProperty(required = false,value="城市ID" , notes = "城市ID")
	private Integer cityId;
	
	/**
	 * 省份ID：省份ID
	*/
	@ApiModelProperty(required = false,value="省份ID" , notes = "省份ID")
	private Integer provinceId;
	
	/**
	 * 区县ID：区县ID
	*/
	@ApiModelProperty(required = false,value="区县ID" , notes = "区县ID")
	private Integer areaId;
	
	/**
	 * 镇ID：镇ID
	*/
	@ApiModelProperty(required = false,value="镇ID" , notes = "镇ID")
	private Integer townId;
	
	/**
	 * 详细地址：详细地址
	*/
	@ApiModelProperty(required = false,value="详细地址" , notes = "详细地址")
	private String addressDetail;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private Long createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private Long updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Boolean deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private Long deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 测量总量
	*/
	@ApiModelProperty(required = false,value="测量总量" , notes = "")
	private Integer measureCount;
	
	/**
	 * 测量总量
	*/
	@ApiModelProperty(required = false,value="测量总量" , notes = "")
	private Catalog measureStatusCount;
	
	/**
	 * 公司信息
	*/
	@ApiModelProperty(required = false,value="公司信息" , notes = "")
	private Company company;
	
	/**
	 * 状态信息
	*/
	@ApiModelProperty(required = false,value="状态信息" , notes = "")
	private DictItem statusDictItem;
	
	/**
	 * 获得 ID<br>
	 * 属性说明 : ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public Order setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 订单号<br>
	 * 属性说明 : 订单号
	 * @return 订单号
	*/
	public String getOrderNo() {
		return orderNo;
	}
	
	/**
	 * 设置 订单号
	 * @param orderNo 订单号
	 * @return 当前对象
	*/
	public Order setOrderNo(String orderNo) {
		this.orderNo=orderNo;
		return this;
	}
	
	/**
	 * 添加 订单号
	 * @param orderNo 订单号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司ID<br>
	 * 属性说明 : 公司ID
	 * @return 公司ID
	*/
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	public Order setCompanyId(Long companyId) {
		this.companyId=companyId;
		return this;
	}
	
	/**
	 * 添加 公司ID
	 * @param companyId 公司ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 预约时间<br>
	 * 属性说明 : 预约时间
	 * @return 预约时间
	*/
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	
	/**
	 * 设置 预约时间
	 * @param appointmentTime 预约时间
	 * @return 当前对象
	*/
	public Order setAppointmentTime(Date appointmentTime) {
		this.appointmentTime=appointmentTime;
		return this;
	}
	
	/**
	 * 添加 预约时间
	 * @param appointmentTime 预约时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 订单状态<br>
	 * 属性说明 : 订单状态
	 * @return 订单状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 订单状态
	 * @param status 订单状态
	 * @return 当前对象
	*/
	public Order setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 添加 订单状态
	 * @param status 订单状态
	 * @return 当前对象
	*/
	
	/**
	 * 获得 城市ID<br>
	 * 属性说明 : 城市ID
	 * @return 城市ID
	*/
	public Integer getCityId() {
		return cityId;
	}
	
	/**
	 * 设置 城市ID
	 * @param cityId 城市ID
	 * @return 当前对象
	*/
	public Order setCityId(Integer cityId) {
		this.cityId=cityId;
		return this;
	}
	
	/**
	 * 添加 城市ID
	 * @param cityId 城市ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 省份ID<br>
	 * 属性说明 : 省份ID
	 * @return 省份ID
	*/
	public Integer getProvinceId() {
		return provinceId;
	}
	
	/**
	 * 设置 省份ID
	 * @param provinceId 省份ID
	 * @return 当前对象
	*/
	public Order setProvinceId(Integer provinceId) {
		this.provinceId=provinceId;
		return this;
	}
	
	/**
	 * 添加 省份ID
	 * @param provinceId 省份ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 区县ID<br>
	 * 属性说明 : 区县ID
	 * @return 区县ID
	*/
	public Integer getAreaId() {
		return areaId;
	}
	
	/**
	 * 设置 区县ID
	 * @param areaId 区县ID
	 * @return 当前对象
	*/
	public Order setAreaId(Integer areaId) {
		this.areaId=areaId;
		return this;
	}
	
	/**
	 * 添加 区县ID
	 * @param areaId 区县ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 镇ID<br>
	 * 属性说明 : 镇ID
	 * @return 镇ID
	*/
	public Integer getTownId() {
		return townId;
	}
	
	/**
	 * 设置 镇ID
	 * @param townId 镇ID
	 * @return 当前对象
	*/
	public Order setTownId(Integer townId) {
		this.townId=townId;
		return this;
	}
	
	/**
	 * 添加 镇ID
	 * @param townId 镇ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 详细地址<br>
	 * 属性说明 : 详细地址
	 * @return 详细地址
	*/
	public String getAddressDetail() {
		return addressDetail;
	}
	
	/**
	 * 设置 详细地址
	 * @param addressDetail 详细地址
	 * @return 当前对象
	*/
	public Order setAddressDetail(String addressDetail) {
		this.addressDetail=addressDetail;
		return this;
	}
	
	/**
	 * 添加 详细地址
	 * @param addressDetail 详细地址
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
	 * @return 创建人ID
	*/
	public Long getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Order setCreateBy(Long createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public Order setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
	 * @return 修改人ID
	*/
	public Long getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Order setUpdateBy(Long updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public Order setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean isDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 等价于 isDeleted 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否已删除
	 * @return 是否已删除
	*/
	public Boolean getDeleted() {
		return this.deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Order setDeleted(Boolean deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
	 * @return 删除人ID
	*/
	public Long getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Order setDeleteBy(Long deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public Order setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据版本号<br>
	 * 属性说明 : 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public Order setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量总量<br>
	 * @return 测量总量
	*/
	public Integer getMeasureCount() {
		return measureCount;
	}
	
	/**
	 * 设置 测量总量
	 * @param measureCount 测量总量
	 * @return 当前对象
	*/
	public Order setMeasureCount(Integer measureCount) {
		this.measureCount=measureCount;
		return this;
	}
	
	/**
	 * 添加 测量总量
	 * @param measureCount 测量总量
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量总量<br>
	 * @return 测量总量
	*/
	public Catalog getMeasureStatusCount() {
		return measureStatusCount;
	}
	
	/**
	 * 设置 测量总量
	 * @param measureStatusCount 测量总量
	 * @return 当前对象
	*/
	public Order setMeasureStatusCount(Catalog measureStatusCount) {
		this.measureStatusCount=measureStatusCount;
		return this;
	}
	
	/**
	 * 添加 测量总量
	 * @param measureStatusCount 测量总量
	 * @return 当前对象
	*/
	
	/**
	 * 获得 公司信息<br>
	 * @return 公司信息
	*/
	public Company getCompany() {
		return company;
	}
	
	/**
	 * 设置 公司信息
	 * @param company 公司信息
	 * @return 当前对象
	*/
	public Order setCompany(Company company) {
		this.company=company;
		return this;
	}
	
	/**
	 * 添加 公司信息
	 * @param company 公司信息
	 * @return 当前对象
	*/
	
	/**
	 * 获得 状态信息<br>
	 * @return 状态信息
	*/
	public DictItem getStatusDictItem() {
		return statusDictItem;
	}
	
	/**
	 * 设置 状态信息
	 * @param statusDictItem 状态信息
	 * @return 当前对象
	*/
	public Order setStatusDictItem(DictItem statusDictItem) {
		this.statusDictItem=statusDictItem;
		return this;
	}
	
	/**
	 * 添加 状态信息
	 * @param statusDictItem 状态信息
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Order , 转换好的 Order 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Order , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 Order
	 * @param orderMap 包含实体信息的 Map 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Map<String,Object> orderMap) {
		if(orderMap==null) return null;
		Order po = EntityContext.create(Order.class, orderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Order
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Order , 转换好的的 Order 对象
	*/
	@Transient
	public static Order createFrom(Object pojo) {
		if(pojo==null) return null;
		Order po = EntityContext.create(Order.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Order，等同于 new
	 * @return Order 对象
	*/
	@Transient
	public static Order create() {
		return new Order();
	}
}