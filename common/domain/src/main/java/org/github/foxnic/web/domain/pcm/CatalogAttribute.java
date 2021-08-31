package org.github.foxnic.web.domain.pcm;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.PCM_CATALOG_ATTRIBUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-31 17:13:29
 * @sign 790E514503D150BE90719869A9254978
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
	@ApiModelProperty(required = false,value="存储ID" , notes = "存储ID")
	private String storageId;
	
	/**
	 * 字段名：在数据表中的真实字段名
	*/
	@ApiModelProperty(required = false,value="字段名" , notes = "在数据表中的真实字段名")
	private String field;
	
	/**
	 * 数据类型：数据类型
	*/
	@ApiModelProperty(required = false,value="数据类型" , notes = "数据类型")
	private String dataType;
	
	/**
	 * 简称：简称
	*/
	@ApiModelProperty(required = false,value="简称" , notes = "简称")
	private String shortName;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = false,value="全称" , notes = "全称")
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
	 * 数据长度：数据长度
	*/
	@ApiModelProperty(required = false,value="数据长度" , notes = "数据长度")
	private Integer length;
	
	/**
	 * 数据精度：数据精度
	*/
	@ApiModelProperty(required = false,value="数据精度" , notes = "数据精度")
	private Integer precision;
	
	/**
	 * 小数位数：小数位数
	*/
	@ApiModelProperty(required = false,value="小数位数" , notes = "小数位数")
	private Integer scale;
	
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
	public String getStorageId() {
		return storageId;
	}
	
	/**
	 * 设置 存储ID
	 * @param storageId 存储ID
	 * @return 当前对象
	*/
	public CatalogAttribute setStorageId(String storageId) {
		this.storageId=storageId;
		return this;
	}
	
	/**
	 * 获得 字段名<br>
	 * 在数据表中的真实字段名
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
	public Integer getPrecision() {
		return precision;
	}
	
	/**
	 * 设置 数据精度
	 * @param precision 数据精度
	 * @return 当前对象
	*/
	public CatalogAttribute setPrecision(Integer precision) {
		this.precision=precision;
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public CatalogAttribute setDeleted(Integer deleted) {
		this.deleted=deleted;
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