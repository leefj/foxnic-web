package com.scientific.tailoring.domain.product;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.PRD_FABRIC;
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
 * @since 2021-05-17 01:18:17
 * @sign 9C2FB60A77DEC5680800330115618335
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "prd_fabric")
public class Fabric extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PRD_FABRIC.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private Integer id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = true,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = true,value="名称" , notes = "名称")
	private String fullName;
	
	/**
	 * 简称：简称
	*/
	@ApiModelProperty(required = false,value="简称" , notes = "简称")
	private String shortName;
	
	/**
	 * 图片ID：图片ID
	*/
	@ApiModelProperty(required = false,value="图片ID" , notes = "图片ID")
	private Integer fileId;
	
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
	 * 获得 id<br>
	 * 属性说明 : id
	 * @return id
	*/
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public Fabric setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 id
	 * @param id id
	 * @return 当前对象
	*/
	
	/**
	 * 获得 编码<br>
	 * 属性说明 : 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public Fabric setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 添加 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 名称<br>
	 * 属性说明 : 名称
	 * @return 名称
	*/
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 名称
	 * @param fullName 名称
	 * @return 当前对象
	*/
	public Fabric setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 添加 名称
	 * @param fullName 名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 简称<br>
	 * 属性说明 : 简称
	 * @return 简称
	*/
	public String getShortName() {
		return shortName;
	}
	
	/**
	 * 设置 简称
	 * @param shortName 简称
	 * @return 当前对象
	*/
	public Fabric setShortName(String shortName) {
		this.shortName=shortName;
		return this;
	}
	
	/**
	 * 添加 简称
	 * @param shortName 简称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 图片ID<br>
	 * 属性说明 : 图片ID
	 * @return 图片ID
	*/
	public Integer getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 图片ID
	 * @param fileId 图片ID
	 * @return 当前对象
	*/
	public Fabric setFileId(Integer fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 添加 图片ID
	 * @param fileId 图片ID
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
	public Fabric setCreateBy(Long createBy) {
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
	public Fabric setCreateTime(Date createTime) {
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
	public Fabric setUpdateBy(Long updateBy) {
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
	public Fabric setUpdateTime(Date updateTime) {
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
	public Fabric setDeleted(Boolean deleted) {
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
	public Fabric setDeleteBy(Long deleteBy) {
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
	public Fabric setDeleteTime(Date deleteTime) {
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
	public Fabric setVersion(Integer version) {
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
	 * @return Fabric , 转换好的 Fabric 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Fabric , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Fabric
	 * @param fabricMap 包含实体信息的 Map 对象
	 * @return Fabric , 转换好的的 Fabric 对象
	*/
	@Transient
	public static Fabric createFrom(Map<String,Object> fabricMap) {
		if(fabricMap==null) return null;
		Fabric po = EntityContext.create(Fabric.class, fabricMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Fabric
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Fabric , 转换好的的 Fabric 对象
	*/
	@Transient
	public static Fabric createFrom(Object pojo) {
		if(pojo==null) return null;
		Fabric po = EntityContext.create(Fabric.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Fabric，等同于 new
	 * @return Fabric 对象
	*/
	@Transient
	public static Fabric create() {
		return new Fabric();
	}
}