package com.scientific.tailoring.domain.order;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.scientific.tailoring.domain.system.DictItem;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign D7205A315B2D16FA03B5957EF634FEA0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "odr_measure")
public class Measure extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =ODR_MEASURE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 订单ID：订单ID
	*/
	@ApiModelProperty(required = true,value="订单ID" , notes = "订单ID")
	private Long orderId;
	
	/**
	 * 被测量人员ID：被测量人员ID
	*/
	@ApiModelProperty(required = false,value="被测量人员ID" , notes = "被测量人员ID")
	private Long bodyId;
	
	/**
	 * 测量方法：测量方法
	*/
	@ApiModelProperty(required = false,value="测量方法" , notes = "测量方法")
	private String method;
	
	/**
	 * 测量状态：测量状态
	*/
	@ApiModelProperty(required = true,value="测量状态" , notes = "测量状态")
	private String status;
	
	/**
	 * 视频效果：最终视频效果文件ID
	*/
	@ApiModelProperty(required = false,value="视频效果" , notes = "最终视频效果文件ID")
	private Long videoId;
	
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
	 * 净体3D效果文件ID：净体3D效果文件ID
	*/
	@ApiModelProperty(required = false,value="净体3D效果文件ID" , notes = "净体3D效果文件ID")
	private Long bodyEffectFileId;
	
	/**
	 * 着装3D效果文件ID：着装3D效果文件ID
	*/
	@ApiModelProperty(required = false,value="着装3D效果文件ID" , notes = "着装3D效果文件ID")
	private Long outfitEffectFileId;
	
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
	public Measure setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 ID
	 * @param id ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 订单ID<br>
	 * 属性说明 : 订单ID
	 * @return 订单ID
	*/
	public Long getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	public Measure setOrderId(Long orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 添加 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 被测量人员ID<br>
	 * 属性说明 : 被测量人员ID
	 * @return 被测量人员ID
	*/
	public Long getBodyId() {
		return bodyId;
	}
	
	/**
	 * 设置 被测量人员ID
	 * @param bodyId 被测量人员ID
	 * @return 当前对象
	*/
	public Measure setBodyId(Long bodyId) {
		this.bodyId=bodyId;
		return this;
	}
	
	/**
	 * 添加 被测量人员ID
	 * @param bodyId 被测量人员ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量方法<br>
	 * 属性说明 : 测量方法
	 * @return 测量方法
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 测量方法
	 * @param method 测量方法
	 * @return 当前对象
	*/
	public Measure setMethod(String method) {
		this.method=method;
		return this;
	}
	
	/**
	 * 添加 测量方法
	 * @param method 测量方法
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量状态<br>
	 * 属性说明 : 测量状态
	 * @return 测量状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 测量状态
	 * @param status 测量状态
	 * @return 当前对象
	*/
	public Measure setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 添加 测量状态
	 * @param status 测量状态
	 * @return 当前对象
	*/
	
	/**
	 * 获得 视频效果<br>
	 * 属性说明 : 最终视频效果文件ID
	 * @return 视频效果
	*/
	public Long getVideoId() {
		return videoId;
	}
	
	/**
	 * 设置 视频效果
	 * @param videoId 视频效果
	 * @return 当前对象
	*/
	public Measure setVideoId(Long videoId) {
		this.videoId=videoId;
		return this;
	}
	
	/**
	 * 添加 视频效果
	 * @param videoId 视频效果
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
	public Measure setCreateBy(Long createBy) {
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
	public Measure setCreateTime(Date createTime) {
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
	public Measure setUpdateBy(Long updateBy) {
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
	public Measure setUpdateTime(Date updateTime) {
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
	public Measure setDeleted(Boolean deleted) {
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
	public Measure setDeleteBy(Long deleteBy) {
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
	public Measure setDeleteTime(Date deleteTime) {
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
	public Measure setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 净体3D效果文件ID<br>
	 * 属性说明 : 净体3D效果文件ID
	 * @return 净体3D效果文件ID
	*/
	public Long getBodyEffectFileId() {
		return bodyEffectFileId;
	}
	
	/**
	 * 设置 净体3D效果文件ID
	 * @param bodyEffectFileId 净体3D效果文件ID
	 * @return 当前对象
	*/
	public Measure setBodyEffectFileId(Long bodyEffectFileId) {
		this.bodyEffectFileId=bodyEffectFileId;
		return this;
	}
	
	/**
	 * 添加 净体3D效果文件ID
	 * @param bodyEffectFileId 净体3D效果文件ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 着装3D效果文件ID<br>
	 * 属性说明 : 着装3D效果文件ID
	 * @return 着装3D效果文件ID
	*/
	public Long getOutfitEffectFileId() {
		return outfitEffectFileId;
	}
	
	/**
	 * 设置 着装3D效果文件ID
	 * @param outfitEffectFileId 着装3D效果文件ID
	 * @return 当前对象
	*/
	public Measure setOutfitEffectFileId(Long outfitEffectFileId) {
		this.outfitEffectFileId=outfitEffectFileId;
		return this;
	}
	
	/**
	 * 添加 着装3D效果文件ID
	 * @param outfitEffectFileId 着装3D效果文件ID
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
	public Measure setStatusDictItem(DictItem statusDictItem) {
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
	 * @return Measure , 转换好的 Measure 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Measure , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Measure
	 * @param measureMap 包含实体信息的 Map 对象
	 * @return Measure , 转换好的的 Measure 对象
	*/
	@Transient
	public static Measure createFrom(Map<String,Object> measureMap) {
		if(measureMap==null) return null;
		Measure po = EntityContext.create(Measure.class, measureMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Measure
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Measure , 转换好的的 Measure 对象
	*/
	@Transient
	public static Measure createFrom(Object pojo) {
		if(pojo==null) return null;
		Measure po = EntityContext.create(Measure.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Measure，等同于 new
	 * @return Measure 对象
	*/
	@Transient
	public static Measure create() {
		return new Measure();
	}
}