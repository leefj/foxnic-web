package com.scientific.tailoring.domain.order;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE_FILE;
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
 * @sign E61E3AEB135C88D00491491CF9B34F11
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "odr_measure_file")
public class MeasureFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =ODR_MEASURE_FILE.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private Integer id;
	
	/**
	 * 订单测量ID：订单测量ID
	*/
	@ApiModelProperty(required = false,value="订单测量ID" , notes = "订单测量ID")
	private Long measureId;
	
	/**
	 * 文件ID：文件ID
	*/
	@ApiModelProperty(required = false,value="文件ID" , notes = "文件ID")
	private Long fileId;
	
	/**
	 * 测量类型：image/video/manual
	*/
	@ApiModelProperty(required = false,value="测量类型" , notes = "image/video/manual")
	private String type;
	
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
	 * 数据是否已经处理：数据是否已经处理
	*/
	@ApiModelProperty(required = false,value="数据是否已经处理" , notes = "数据是否已经处理")
	private Integer processed;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间")
	private Date processTime;
	
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
	public MeasureFile setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 id
	 * @param id id
	 * @return 当前对象
	*/
	
	/**
	 * 获得 订单测量ID<br>
	 * 属性说明 : 订单测量ID
	 * @return 订单测量ID
	*/
	public Long getMeasureId() {
		return measureId;
	}
	
	/**
	 * 设置 订单测量ID
	 * @param measureId 订单测量ID
	 * @return 当前对象
	*/
	public MeasureFile setMeasureId(Long measureId) {
		this.measureId=measureId;
		return this;
	}
	
	/**
	 * 添加 订单测量ID
	 * @param measureId 订单测量ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 文件ID<br>
	 * 属性说明 : 文件ID
	 * @return 文件ID
	*/
	public Long getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 文件ID
	 * @param fileId 文件ID
	 * @return 当前对象
	*/
	public MeasureFile setFileId(Long fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 添加 文件ID
	 * @param fileId 文件ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 测量类型<br>
	 * 属性说明 : image/video/manual
	 * @return 测量类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 测量类型
	 * @param type 测量类型
	 * @return 当前对象
	*/
	public MeasureFile setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 添加 测量类型
	 * @param type 测量类型
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
	public MeasureFile setCreateBy(Long createBy) {
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
	public MeasureFile setCreateTime(Date createTime) {
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
	public MeasureFile setUpdateBy(Long updateBy) {
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
	public MeasureFile setUpdateTime(Date updateTime) {
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
	public MeasureFile setDeleted(Boolean deleted) {
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
	public MeasureFile setDeleteBy(Long deleteBy) {
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
	public MeasureFile setDeleteTime(Date deleteTime) {
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
	public MeasureFile setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据是否已经处理<br>
	 * 属性说明 : 数据是否已经处理
	 * @return 数据是否已经处理
	*/
	public Integer getProcessed() {
		return processed;
	}
	
	/**
	 * 设置 数据是否已经处理
	 * @param processed 数据是否已经处理
	 * @return 当前对象
	*/
	public MeasureFile setProcessed(Integer processed) {
		this.processed=processed;
		return this;
	}
	
	/**
	 * 添加 数据是否已经处理
	 * @param processed 数据是否已经处理
	 * @return 当前对象
	*/
	
	/**
	 * 获得 处理时间<br>
	 * 属性说明 : 处理时间
	 * @return 处理时间
	*/
	public Date getProcessTime() {
		return processTime;
	}
	
	/**
	 * 设置 处理时间
	 * @param processTime 处理时间
	 * @return 当前对象
	*/
	public MeasureFile setProcessTime(Date processTime) {
		this.processTime=processTime;
		return this;
	}
	
	/**
	 * 添加 处理时间
	 * @param processTime 处理时间
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MeasureFile , 转换好的 MeasureFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MeasureFile , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MeasureFile
	 * @param measureFileMap 包含实体信息的 Map 对象
	 * @return MeasureFile , 转换好的的 MeasureFile 对象
	*/
	@Transient
	public static MeasureFile createFrom(Map<String,Object> measureFileMap) {
		if(measureFileMap==null) return null;
		MeasureFile po = EntityContext.create(MeasureFile.class, measureFileMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MeasureFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MeasureFile , 转换好的的 MeasureFile 对象
	*/
	@Transient
	public static MeasureFile createFrom(Object pojo) {
		if(pojo==null) return null;
		MeasureFile po = EntityContext.create(MeasureFile.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MeasureFile，等同于 new
	 * @return MeasureFile 对象
	*/
	@Transient
	public static MeasureFile create() {
		return new MeasureFile();
	}
}