package org.github.foxnic.web.domain.example;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.ExampleTables.EXAMPLE_ADDRESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 订单地址
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-09 11:07:56
 * @sign F1687084DEFDEB57D033DEA1E076FFB8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "example_address")
public class Address extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EXAMPLE_ADDRESS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 收件人姓名：收件人姓名
	*/
	@ApiModelProperty(required = false,value="收件人姓名" , notes = "收件人姓名")
	private String name;
	
	/**
	 * 收件人手机：收件人手机
	*/
	@ApiModelProperty(required = false,value="收件人手机" , notes = "收件人手机")
	private String phoneNumber;
	
	/**
	 * 收件地址：收件地址
	*/
	@ApiModelProperty(required = false,value="收件地址" , notes = "收件地址")
	private String address;
	
	/**
	 * 类型：A:国内；B:国外
	*/
	@ApiModelProperty(required = true,value="类型" , notes = "A:国内；B:国外")
	private String type;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Address setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 收件人姓名<br>
	 * 收件人姓名
	 * @return 收件人姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 收件人姓名
	 * @param name 收件人姓名
	 * @return 当前对象
	*/
	public Address setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 收件人手机<br>
	 * 收件人手机
	 * @return 收件人手机
	*/
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * 设置 收件人手机
	 * @param phoneNumber 收件人手机
	 * @return 当前对象
	*/
	public Address setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
		return this;
	}
	
	/**
	 * 获得 收件地址<br>
	 * 收件地址
	 * @return 收件地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 收件地址
	 * @param address 收件地址
	 * @return 当前对象
	*/
	public Address setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * A:国内；B:国外
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Address setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Address setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
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
	public Address setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Address setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
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
	public Address setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Address setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public Address setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Address setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
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
	public Address setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public Address setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Address , 转换好的 Address 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Address , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Address
	 * @param addressMap 包含实体信息的 Map 对象
	 * @return Address , 转换好的的 Address 对象
	*/
	@Transient
	public static Address createFrom(Map<String,Object> addressMap) {
		if(addressMap==null) return null;
		Address po = EntityContext.create(Address.class, addressMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Address
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Address , 转换好的的 Address 对象
	*/
	@Transient
	public static Address createFrom(Object pojo) {
		if(pojo==null) return null;
		Address po = EntityContext.create(Address.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Address，等同于 new
	 * @return Address 对象
	*/
	@Transient
	public static Address create() {
		return EntityContext.create(Address.class);
	}
}