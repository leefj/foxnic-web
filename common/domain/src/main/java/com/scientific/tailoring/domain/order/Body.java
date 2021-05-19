package com.scientific.tailoring.domain.order;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_BODY;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign 385BCD139BB0EC6917F4888E07BD0388
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "odr_body")
public class Body extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =ODR_BODY.$TABLE;
	
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
	 * 被测量人姓名：被测量人姓名
	*/
	@ApiModelProperty(required = false,value="被测量人姓名" , notes = "被测量人姓名")
	private String bodyName;
	
	/**
	 * 被测量人部门：被测量人部门
	*/
	@ApiModelProperty(required = false,value="被测量人部门" , notes = "被测量人部门")
	private String bodyDept;
	
	/**
	 * 被测量人性别：被测量人性别
	*/
	@ApiModelProperty(required = false,value="被测量人性别" , notes = "被测量人性别")
	private String bodySex;
	
	/**
	 * 被测量人身高：单位厘米cm
	*/
	@ApiModelProperty(required = true,value="被测量人身高" , notes = "单位厘米cm")
	private Integer bodyHeight;
	
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
	public Body setId(Long id) {
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
	public Body setOrderId(Long orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 添加 订单ID
	 * @param orderId 订单ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 被测量人姓名<br>
	 * 属性说明 : 被测量人姓名
	 * @return 被测量人姓名
	*/
	public String getBodyName() {
		return bodyName;
	}
	
	/**
	 * 设置 被测量人姓名
	 * @param bodyName 被测量人姓名
	 * @return 当前对象
	*/
	public Body setBodyName(String bodyName) {
		this.bodyName=bodyName;
		return this;
	}
	
	/**
	 * 添加 被测量人姓名
	 * @param bodyName 被测量人姓名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 被测量人部门<br>
	 * 属性说明 : 被测量人部门
	 * @return 被测量人部门
	*/
	public String getBodyDept() {
		return bodyDept;
	}
	
	/**
	 * 设置 被测量人部门
	 * @param bodyDept 被测量人部门
	 * @return 当前对象
	*/
	public Body setBodyDept(String bodyDept) {
		this.bodyDept=bodyDept;
		return this;
	}
	
	/**
	 * 添加 被测量人部门
	 * @param bodyDept 被测量人部门
	 * @return 当前对象
	*/
	
	/**
	 * 获得 被测量人性别<br>
	 * 属性说明 : 被测量人性别
	 * @return 被测量人性别
	*/
	public String getBodySex() {
		return bodySex;
	}
	
	/**
	 * 设置 被测量人性别
	 * @param bodySex 被测量人性别
	 * @return 当前对象
	*/
	public Body setBodySex(String bodySex) {
		this.bodySex=bodySex;
		return this;
	}
	
	/**
	 * 添加 被测量人性别
	 * @param bodySex 被测量人性别
	 * @return 当前对象
	*/
	
	/**
	 * 获得 被测量人身高<br>
	 * 属性说明 : 单位厘米cm
	 * @return 被测量人身高
	*/
	public Integer getBodyHeight() {
		return bodyHeight;
	}
	
	/**
	 * 设置 被测量人身高
	 * @param bodyHeight 被测量人身高
	 * @return 当前对象
	*/
	public Body setBodyHeight(Integer bodyHeight) {
		this.bodyHeight=bodyHeight;
		return this;
	}
	
	/**
	 * 添加 被测量人身高
	 * @param bodyHeight 被测量人身高
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
	public Body setCreateBy(Long createBy) {
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
	public Body setCreateTime(Date createTime) {
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
	public Body setUpdateBy(Long updateBy) {
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
	public Body setUpdateTime(Date updateTime) {
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
	public Body setDeleted(Boolean deleted) {
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
	public Body setDeleteBy(Long deleteBy) {
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
	public Body setDeleteTime(Date deleteTime) {
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
	public Body setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Body , 转换好的 Body 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Body , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Body
	 * @param bodyMap 包含实体信息的 Map 对象
	 * @return Body , 转换好的的 Body 对象
	*/
	@Transient
	public static Body createFrom(Map<String,Object> bodyMap) {
		if(bodyMap==null) return null;
		Body po = EntityContext.create(Body.class, bodyMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Body
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Body , 转换好的的 Body 对象
	*/
	@Transient
	public static Body createFrom(Object pojo) {
		if(pojo==null) return null;
		Body po = EntityContext.create(Body.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Body，等同于 new
	 * @return Body 对象
	*/
	@Transient
	public static Body create() {
		return new Body();
	}
}