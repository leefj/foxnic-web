package com.scientific.tailoring.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.scientific.tailoring.constants.db.Tailoring.SYS_AREA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-17 01:05:53
 * @sign 5122728973FBBD3EB3DDA091EA7761F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_area")
public class Area extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_AREA.$TABLE;
	
	/**
	 * 区域ID：区域ID
	*/
	@Id
	@ApiModelProperty(required = true,value="区域ID" , notes = "区域ID")
	private Integer id;
	
	/**
	 * 父级ID：父级ID
	*/
	@ApiModelProperty(required = true,value="父级ID" , notes = "父级ID")
	private Integer parentId;
	
	/**
	 * 区域名称：区域名称
	*/
	@ApiModelProperty(required = true,value="区域名称" , notes = "区域名称")
	private String name;
	
	/**
	 * 等级（深度）：等级（深度）
	*/
	@ApiModelProperty(required = true,value="等级（深度）" , notes = "等级（深度）")
	private Integer depth;
	
	/**
	 * 创建人id：创建人id
	*/
	@ApiModelProperty(required = false,value="创建人id" , notes = "创建人id")
	private Long createdBy;
	
	/**
	 * 修改人id：修改人id
	*/
	@ApiModelProperty(required = false,value="修改人id" , notes = "修改人id")
	private Long updatedBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = true,value="创建时间" , notes = "创建时间")
	private Timestamp createDate;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = true,value="修改时间" , notes = "修改时间")
	private Timestamp updateDate;
	
	/**
	 * 数据是否有效：（0：无效 1：有效）
	*/
	@ApiModelProperty(required = true,value="数据是否有效" , notes = "（0：无效 1：有效）")
	private Boolean valid;
	
	/**
	 * 获得 区域ID<br>
	 * 属性说明 : 区域ID
	 * @return 区域ID
	*/
	public Integer getId() {
		return id;
	}
	
	/**
	 * 设置 区域ID
	 * @param id 区域ID
	 * @return 当前对象
	*/
	public Area setId(Integer id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 区域ID
	 * @param id 区域ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 父级ID<br>
	 * 属性说明 : 父级ID
	 * @return 父级ID
	*/
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 父级ID
	 * @param parentId 父级ID
	 * @return 当前对象
	*/
	public Area setParentId(Integer parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 添加 父级ID
	 * @param parentId 父级ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 区域名称<br>
	 * 属性说明 : 区域名称
	 * @return 区域名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 区域名称
	 * @param name 区域名称
	 * @return 当前对象
	*/
	public Area setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 区域名称
	 * @param name 区域名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 等级（深度）<br>
	 * 属性说明 : 等级（深度）
	 * @return 等级（深度）
	*/
	public Integer getDepth() {
		return depth;
	}
	
	/**
	 * 设置 等级（深度）
	 * @param depth 等级（深度）
	 * @return 当前对象
	*/
	public Area setDepth(Integer depth) {
		this.depth=depth;
		return this;
	}
	
	/**
	 * 添加 等级（深度）
	 * @param depth 等级（深度）
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人id<br>
	 * 属性说明 : 创建人id
	 * @return 创建人id
	*/
	public Long getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * 设置 创建人id
	 * @param createdBy 创建人id
	 * @return 当前对象
	*/
	public Area setCreatedBy(Long createdBy) {
		this.createdBy=createdBy;
		return this;
	}
	
	/**
	 * 添加 创建人id
	 * @param createdBy 创建人id
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人id<br>
	 * 属性说明 : 修改人id
	 * @return 修改人id
	*/
	public Long getUpdatedBy() {
		return updatedBy;
	}
	
	/**
	 * 设置 修改人id
	 * @param updatedBy 修改人id
	 * @return 当前对象
	*/
	public Area setUpdatedBy(Long updatedBy) {
		this.updatedBy=updatedBy;
		return this;
	}
	
	/**
	 * 添加 修改人id
	 * @param updatedBy 修改人id
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
	 * @return 创建时间
	*/
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	/**
	 * 设置 创建时间
	 * @param createDate 创建时间
	 * @return 当前对象
	*/
	public Area setCreateDate(Timestamp createDate) {
		this.createDate=createDate;
		return this;
	}
	
	/**
	 * 添加 创建时间
	 * @param createDate 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
	 * @return 修改时间
	*/
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateDate 修改时间
	 * @return 当前对象
	*/
	public Area setUpdateDate(Timestamp updateDate) {
		this.updateDate=updateDate;
		return this;
	}
	
	/**
	 * 添加 修改时间
	 * @param updateDate 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 数据是否有效<br>
	 * 属性说明 : （0：无效 1：有效）
	 * @return 数据是否有效
	*/
	public Boolean isValid() {
		return valid;
	}
	
	/**
	 * 获得 数据是否有效<br>
	 * 等价于 isValid 方法，为兼容 Swagger 需要
	 * 属性说明 : （0：无效 1：有效）
	 * @return 数据是否有效
	*/
	public Boolean getValid() {
		return this.valid;
	}
	
	/**
	 * 设置 数据是否有效
	 * @param valid 数据是否有效
	 * @return 当前对象
	*/
	public Area setValid(Boolean valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 添加 数据是否有效
	 * @param valid 数据是否有效
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Area , 转换好的 Area 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Area , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Area
	 * @param areaMap 包含实体信息的 Map 对象
	 * @return Area , 转换好的的 Area 对象
	*/
	@Transient
	public static Area createFrom(Map<String,Object> areaMap) {
		if(areaMap==null) return null;
		Area po = EntityContext.create(Area.class, areaMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Area
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Area , 转换好的的 Area 对象
	*/
	@Transient
	public static Area createFrom(Object pojo) {
		if(pojo==null) return null;
		Area po = EntityContext.create(Area.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Area，等同于 new
	 * @return Area 对象
	*/
	@Transient
	public static Area create() {
		return new Area();
	}
}