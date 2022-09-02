package org.github.foxnic.web.domain.pcm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ATTRIBUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 分类属性
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:40:38
 * @sign F6B125456C3FCD58557215125F0CD860
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "pcm_catalog_attribute")
public class CatalogAttribute extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =PCM_CATALOG_ATTRIBUTE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 存储ID：存储ID
	*/
	@ApiModelProperty(required = true,value="存储ID" , notes = "存储ID")
	private String catalogId;
	
	/**
	 * 字段名：自定义的字段别名
	*/
	@ApiModelProperty(required = true,value="字段名" , notes = "自定义的字段别名")
	private String field;
	
	/**
	 * 是否必填：是否必填
	*/
	@ApiModelProperty(required = true,value="是否必填" , notes = "是否必填")
	private Integer notNull;
	
	/**
	 * 配置版本号：配置版本号
	*/
	@ApiModelProperty(required = true,value="配置版本号" , notes = "配置版本号")
	private String versionNo;
	
	/**
	 * 数据类型：数据类型
	*/
	@ApiModelProperty(required = true,value="数据类型" , notes = "数据类型")
	private String dataType;
	
	/**
	 * 数据长度：数据长度
	*/
	@ApiModelProperty(required = false,value="数据长度" , notes = "数据长度")
	private Integer length;
	
	/**
	 * 数据精度：数据精度
	*/
	@ApiModelProperty(required = false,value="数据精度" , notes = "数据精度")
	private Integer accuracy;
	
	/**
	 * 小数位数：小数位数
	*/
	@ApiModelProperty(required = false,value="小数位数" , notes = "小数位数")
	private Integer scale;
	
	/**
	 * 简称：简称
	*/
	@ApiModelProperty(required = true,value="简称" , notes = "简称")
	private String shortName;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = true,value="全称" , notes = "全称")
	private String fullName;
	
	/**
	 * 提示信息：提示信息
	*/
	@ApiModelProperty(required = false,value="提示信息" , notes = "提示信息")
	private String hint;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String detail;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
	/**
	 * 原属性ID：原属性ID
	*/
	@ApiModelProperty(required = false,value="原属性ID" , notes = "原属性ID")
	private String sourceId;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 类目对象：类目对象
	*/
	@ApiModelProperty(required = false,value="类目对象" , notes = "类目对象")
	private Catalog catalog;
	
	/**
	 * 分配的字段：分配的字段
	*/
	@ApiModelProperty(required = false,value="分配的字段" , notes = "分配的字段")
	private CatalogAllocation allocation;
	
	/**
	 * 重新分配前的字段：用于字段参数变更时登记
	*/
	@ApiModelProperty(required = false,value="重新分配前的字段" , notes = "用于字段参数变更时登记")
	private CatalogAllocation allocationBefore;
	
	/**
	 * 来源：上一个版本的配置信息
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "上一个版本的配置信息")
	private CatalogAttribute sourceAttr;
	
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
	public CatalogAttribute setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 存储ID<br>
	 * 存储ID
	 * @return 存储ID
	*/
	public String getCatalogId() {
		return catalogId;
	}
	
	/**
	 * 设置 存储ID
	 * @param catalogId 存储ID
	 * @return 当前对象
	*/
	public CatalogAttribute setCatalogId(String catalogId) {
		this.catalogId=catalogId;
		return this;
	}
	
	/**
	 * 获得 字段名<br>
	 * 自定义的字段别名
	 * @return 字段名
	*/
	public String getField() {
		return field;
	}
	
	/**
	 * 设置 字段名
	 * @param field 字段名
	 * @return 当前对象
	*/
	public CatalogAttribute setField(String field) {
		this.field=field;
		return this;
	}
	
	/**
	 * 获得 是否必填<br>
	 * 是否必填
	 * @return 是否必填
	*/
	public Integer getNotNull() {
		return notNull;
	}
	
	/**
	 * 设置 是否必填
	 * @param notNull 是否必填
	 * @return 当前对象
	*/
	public CatalogAttribute setNotNull(Integer notNull) {
		this.notNull=notNull;
		return this;
	}
	
	/**
	 * 获得 配置版本号<br>
	 * 配置版本号
	 * @return 配置版本号
	*/
	public String getVersionNo() {
		return versionNo;
	}
	
	/**
	 * 设置 配置版本号
	 * @param versionNo 配置版本号
	 * @return 当前对象
	*/
	public CatalogAttribute setVersionNo(String versionNo) {
		this.versionNo=versionNo;
		return this;
	}
	
	/**
	 * 获得 数据类型<br>
	 * 数据类型
	 * @return 数据类型
	*/
	public String getDataType() {
		return dataType;
	}
	
	/**
	 * 设置 数据类型
	 * @param dataType 数据类型
	 * @return 当前对象
	*/
	public CatalogAttribute setDataType(String dataType) {
		this.dataType=dataType;
		return this;
	}
	
	/**
	 * 获得 数据长度<br>
	 * 数据长度
	 * @return 数据长度
	*/
	public Integer getLength() {
		return length;
	}
	
	/**
	 * 设置 数据长度
	 * @param length 数据长度
	 * @return 当前对象
	*/
	public CatalogAttribute setLength(Integer length) {
		this.length=length;
		return this;
	}
	
	/**
	 * 获得 数据精度<br>
	 * 数据精度
	 * @return 数据精度
	*/
	public Integer getAccuracy() {
		return accuracy;
	}
	
	/**
	 * 设置 数据精度
	 * @param accuracy 数据精度
	 * @return 当前对象
	*/
	public CatalogAttribute setAccuracy(Integer accuracy) {
		this.accuracy=accuracy;
		return this;
	}
	
	/**
	 * 获得 小数位数<br>
	 * 小数位数
	 * @return 小数位数
	*/
	public Integer getScale() {
		return scale;
	}
	
	/**
	 * 设置 小数位数
	 * @param scale 小数位数
	 * @return 当前对象
	*/
	public CatalogAttribute setScale(Integer scale) {
		this.scale=scale;
		return this;
	}
	
	/**
	 * 获得 简称<br>
	 * 简称
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
	public CatalogAttribute setShortName(String shortName) {
		this.shortName=shortName;
		return this;
	}
	
	/**
	 * 获得 全称<br>
	 * 全称
	 * @return 全称
	*/
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 全称
	 * @param fullName 全称
	 * @return 当前对象
	*/
	public CatalogAttribute setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 获得 提示信息<br>
	 * 提示信息
	 * @return 提示信息
	*/
	public String getHint() {
		return hint;
	}
	
	/**
	 * 设置 提示信息
	 * @param hint 提示信息
	 * @return 当前对象
	*/
	public CatalogAttribute setHint(String hint) {
		this.hint=hint;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 说明
	 * @param detail 说明
	 * @return 当前对象
	*/
	public CatalogAttribute setDetail(String detail) {
		this.detail=detail;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public CatalogAttribute setNote(String note) {
		this.note=note;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public CatalogAttribute setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 原属性ID<br>
	 * 原属性ID
	 * @return 原属性ID
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 原属性ID
	 * @param sourceId 原属性ID
	 * @return 当前对象
	*/
	public CatalogAttribute setSourceId(String sourceId) {
		this.sourceId=sourceId;
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
	public CatalogAttribute setCreateBy(String createBy) {
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
	public CatalogAttribute setCreateTime(Date createTime) {
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
	public CatalogAttribute setUpdateBy(String updateBy) {
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
	public CatalogAttribute setUpdateTime(Date updateTime) {
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
	public CatalogAttribute setDeleted(Integer deleted) {
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
	public CatalogAttribute setDeleted(Boolean deletedBool) {
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
	public CatalogAttribute setDeleteBy(String deleteBy) {
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
	public CatalogAttribute setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
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
	public CatalogAttribute setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 类目对象<br>
	 * 类目对象
	 * @return 类目对象
	*/
	public Catalog getCatalog() {
		return catalog;
	}
	
	/**
	 * 设置 类目对象
	 * @param catalog 类目对象
	 * @return 当前对象
	*/
	public CatalogAttribute setCatalog(Catalog catalog) {
		this.catalog=catalog;
		return this;
	}
	
	/**
	 * 获得 分配的字段<br>
	 * 分配的字段
	 * @return 分配的字段
	*/
	public CatalogAllocation getAllocation() {
		return allocation;
	}
	
	/**
	 * 设置 分配的字段
	 * @param allocation 分配的字段
	 * @return 当前对象
	*/
	public CatalogAttribute setAllocation(CatalogAllocation allocation) {
		this.allocation=allocation;
		return this;
	}
	
	/**
	 * 获得 重新分配前的字段<br>
	 * 用于字段参数变更时登记
	 * @return 重新分配前的字段
	*/
	public CatalogAllocation getAllocationBefore() {
		return allocationBefore;
	}
	
	/**
	 * 设置 重新分配前的字段
	 * @param allocationBefore 重新分配前的字段
	 * @return 当前对象
	*/
	public CatalogAttribute setAllocationBefore(CatalogAllocation allocationBefore) {
		this.allocationBefore=allocationBefore;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 上一个版本的配置信息
	 * @return 来源
	*/
	public CatalogAttribute getSourceAttr() {
		return sourceAttr;
	}
	
	/**
	 * 设置 来源
	 * @param sourceAttr 来源
	 * @return 当前对象
	*/
	public CatalogAttribute setSourceAttr(CatalogAttribute sourceAttr) {
		this.sourceAttr=sourceAttr;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CatalogAttribute , 转换好的 CatalogAttribute 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CatalogAttribute , 转换好的 PoJo 对象
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
	 * 克隆当前对象
	*/
	@Transient
	public CatalogAttribute clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CatalogAttribute duplicate(boolean all) {
		org.github.foxnic.web.domain.pcm.meta.CatalogAttributeMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.pcm.meta.CatalogAttributeMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setNote(this.getNote());
		inst.setNotNull(this.getNotNull());
		inst.setDataType(this.getDataType());
		inst.setLength(this.getLength());
		inst.setAccuracy(this.getAccuracy());
		inst.setScale(this.getScale());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setCatalogId(this.getCatalogId());
		inst.setDeleted(this.getDeleted());
		inst.setField(this.getField());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setHint(this.getHint());
		inst.setVersionNo(this.getVersionNo());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setDetail(this.getDetail());
		inst.setShortName(this.getShortName());
		if(all) {
			inst.setAllocation(this.getAllocation());
			inst.setSourceAttr(this.getSourceAttr());
			inst.setCatalog(this.getCatalog());
			inst.setAllocationBefore(this.getAllocationBefore());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CatalogAttribute clone(boolean deep) {
		return EntityContext.clone(CatalogAttribute.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CatalogAttribute
	 * @param catalogAttributeMap 包含实体信息的 Map 对象
	 * @return CatalogAttribute , 转换好的的 CatalogAttribute 对象
	*/
	@Transient
	public static CatalogAttribute createFrom(Map<String,Object> catalogAttributeMap) {
		if(catalogAttributeMap==null) return null;
		CatalogAttribute po = EntityContext.create(CatalogAttribute.class, catalogAttributeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CatalogAttribute
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CatalogAttribute , 转换好的的 CatalogAttribute 对象
	*/
	@Transient
	public static CatalogAttribute createFrom(Object pojo) {
		if(pojo==null) return null;
		CatalogAttribute po = EntityContext.create(CatalogAttribute.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CatalogAttribute，等同于 new
	 * @return CatalogAttribute 对象
	*/
	@Transient
	public static CatalogAttribute create() {
		return EntityContext.create(CatalogAttribute.class);
	}
}