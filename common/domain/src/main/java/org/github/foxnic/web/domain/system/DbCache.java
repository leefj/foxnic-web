package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_DB_CACHE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据库缓存
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:42:19
 * @sign C11AB93391F7BBB5490E618EBA089BB0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_db_cache")
public class DbCache extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DB_CACHE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 数据分类：数据分类
	*/
	@ApiModelProperty(required = false,value="数据分类" , notes = "数据分类")
	private String catalog;
	
	/**
	 * 数据分区：数据分区
	*/
	@ApiModelProperty(required = false,value="数据分区" , notes = "数据分区")
	private String area;
	
	/**
	 * 所有者类型：所有者类型
	*/
	@ApiModelProperty(required = false,value="所有者类型" , notes = "所有者类型")
	private String ownerType;
	
	/**
	 * 所有者ID：所有者ID
	*/
	@ApiModelProperty(required = false,value="所有者ID" , notes = "所有者ID")
	private String ownerId;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据")
	private String value;
	
	/**
	 * 过期时间：过期时间
	*/
	@ApiModelProperty(required = false,value="过期时间" , notes = "过期时间")
	private Date expireTime;
	
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
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public DbCache setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 数据分类<br>
	 * 数据分类
	 * @return 数据分类
	*/
	public String getCatalog() {
		return catalog;
	}
	
	/**
	 * 设置 数据分类
	 * @param catalog 数据分类
	 * @return 当前对象
	*/
	public DbCache setCatalog(String catalog) {
		this.catalog=catalog;
		return this;
	}
	
	/**
	 * 获得 数据分区<br>
	 * 数据分区
	 * @return 数据分区
	*/
	public String getArea() {
		return area;
	}
	
	/**
	 * 设置 数据分区
	 * @param area 数据分区
	 * @return 当前对象
	*/
	public DbCache setArea(String area) {
		this.area=area;
		return this;
	}
	
	/**
	 * 获得 所有者类型<br>
	 * 所有者类型
	 * @return 所有者类型
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 所有者类型
	 * @param ownerType 所有者类型
	 * @return 当前对象
	*/
	public DbCache setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		return this;
	}
	
	/**
	 * 获得 所有者ID<br>
	 * 所有者ID
	 * @return 所有者ID
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所有者ID
	 * @param ownerId 所有者ID
	 * @return 当前对象
	*/
	public DbCache setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 数据
	 * @param value 数据
	 * @return 当前对象
	*/
	public DbCache setValue(String value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 获得 过期时间<br>
	 * 过期时间
	 * @return 过期时间
	*/
	public Date getExpireTime() {
		return expireTime;
	}
	
	/**
	 * 设置 过期时间
	 * @param expireTime 过期时间
	 * @return 当前对象
	*/
	public DbCache setExpireTime(Date expireTime) {
		this.expireTime=expireTime;
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
	public DbCache setCreateBy(String createBy) {
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
	public DbCache setCreateTime(Date createTime) {
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
	public DbCache setUpdateBy(String updateBy) {
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
	public DbCache setUpdateTime(Date updateTime) {
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
	public DbCache setDeleted(Integer deleted) {
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
	public DbCache setDeleted(Boolean deletedBool) {
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
	public DbCache setDeleteBy(String deleteBy) {
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
	public DbCache setDeleteTime(Date deleteTime) {
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
	public DbCache setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbCache , 转换好的 DbCache 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbCache , 转换好的 PoJo 对象
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
	public DbCache clone() {
		return EntityContext.clone(DbCache.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbCache clone(boolean deep) {
		return EntityContext.clone(DbCache.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbCache
	 * @param dbCacheMap 包含实体信息的 Map 对象
	 * @return DbCache , 转换好的的 DbCache 对象
	*/
	@Transient
	public static DbCache createFrom(Map<String,Object> dbCacheMap) {
		if(dbCacheMap==null) return null;
		DbCache po = EntityContext.create(DbCache.class, dbCacheMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbCache
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbCache , 转换好的的 DbCache 对象
	*/
	@Transient
	public static DbCache createFrom(Object pojo) {
		if(pojo==null) return null;
		DbCache po = EntityContext.create(DbCache.class,pojo);
		return po;
	}

	/**
	 * 创建一个 DbCache，等同于 new
	 * @return DbCache 对象
	*/
	@Transient
	public static DbCache create() {
		return EntityContext.create(DbCache.class);
	}
}