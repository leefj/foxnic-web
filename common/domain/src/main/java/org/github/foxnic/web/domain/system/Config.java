package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.ConfigMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 系统配置
 * <p>系统配置 , 数据表 sys_config 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-02-01 11:37:34
 * @sign D616249B475673E900281A35905B340E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_config")
@ApiModel(description = "系统配置 ; 系统配置 , 数据表 sys_config 的PO类型")
public class Config extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CONFIG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "clps.portal.IN_URL")
	private String id;
	
	/**
	 * Profile：Profile Id
	*/
	@ApiModelProperty(required = true,value="Profile" , notes = "Profile Id" , example = "clps")
	private String profileId;
	
	/**
	 * 分类代码：关联 sys_config_catalog 数据字典
	*/
	@ApiModelProperty(required = false,value="分类代码" , notes = "关联 sys_config_catalog 数据字典")
	private String catalogCode;
	
	/**
	 * 配置键：配置键
	*/
	@ApiModelProperty(required = true,value="配置键" , notes = "配置键" , example = "clps.portal.IN_URL")
	private String code;
	
	/**
	 * 配置名：配置名
	*/
	@ApiModelProperty(required = false,value="配置名" , notes = "配置名" , example = "IN_URL")
	private String name;
	
	/**
	 * 数据类型：由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict
	*/
	@ApiModelProperty(required = false,value="数据类型" , notes = "由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict" , example = "STRING")
	private String type;
	
	/**
	 * 类型描述：类型描述
	*/
	@ApiModelProperty(required = false,value="类型描述" , notes = "类型描述")
	private String typeDesc;
	
	/**
	 * 配置值：配置值
	*/
	@ApiModelProperty(required = false,value="配置值" , notes = "配置值" , example = "8260111")
	private String value;
	
	/**
	 * 是否生效：是否生效
	*/
	@ApiModelProperty(required = true,value="是否生效" , notes = "是否生效" , example = "1")
	private Integer valid;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明" , example = "IN_URL")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-12-01 04:59:25")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "18")
	private Integer version;
	
	/**
	 * 上级ID：上级ID
	*/
	@ApiModelProperty(required = false,value="上级ID" , notes = "上级ID")
	private String parentId;
	
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
	public Config setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 Profile<br>
	 * Profile Id
	 * @return Profile
	*/
	public String getProfileId() {
		return profileId;
	}
	
	/**
	 * 设置 Profile
	 * @param profileId Profile
	 * @return 当前对象
	*/
	public Config setProfileId(String profileId) {
		this.profileId=profileId;
		return this;
	}
	
	/**
	 * 获得 分类代码<br>
	 * 关联 sys_config_catalog 数据字典
	 * @return 分类代码
	*/
	public String getCatalogCode() {
		return catalogCode;
	}
	
	/**
	 * 设置 分类代码
	 * @param catalogCode 分类代码
	 * @return 当前对象
	*/
	public Config setCatalogCode(String catalogCode) {
		this.catalogCode=catalogCode;
		return this;
	}
	
	/**
	 * 获得 配置键<br>
	 * 配置键
	 * @return 配置键
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 配置键
	 * @param code 配置键
	 * @return 当前对象
	*/
	public Config setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 配置名<br>
	 * 配置名
	 * @return 配置名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 配置名
	 * @param name 配置名
	 * @return 当前对象
	*/
	public Config setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 数据类型<br>
	 * 由开发人员在库中指定，包括 String,Integer,DateTime,Double,Enum,Dict
	 * @return 数据类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 数据类型
	 * @param type 数据类型
	 * @return 当前对象
	*/
	public Config setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 类型描述<br>
	 * 类型描述
	 * @return 类型描述
	*/
	public String getTypeDesc() {
		return typeDesc;
	}
	
	/**
	 * 设置 类型描述
	 * @param typeDesc 类型描述
	 * @return 当前对象
	*/
	public Config setTypeDesc(String typeDesc) {
		this.typeDesc=typeDesc;
		return this;
	}
	
	/**
	 * 获得 配置值<br>
	 * 配置值
	 * @return 配置值
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 配置值
	 * @param value 配置值
	 * @return 当前对象
	*/
	public Config setValue(String value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 获得 是否生效<br>
	 * 是否生效
	 * @return 是否生效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否生效
	 * @param valid 是否生效
	 * @return 当前对象
	*/
	public Config setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 说明
	 * @param notes 说明
	 * @return 当前对象
	*/
	public Config setNotes(String notes) {
		this.notes=notes;
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
	public Config setCreateBy(String createBy) {
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
	public Config setCreateTime(Date createTime) {
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
	public Config setUpdateBy(String updateBy) {
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
	public Config setUpdateTime(Date updateTime) {
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
	@JsonProperty("deleted")
	public Config setDeleted(Integer deleted) {
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
	public Config setDeleted(Boolean deletedBool) {
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
	public Config setDeleteBy(String deleteBy) {
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
	public Config setDeleteTime(Date deleteTime) {
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
	public Config setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 上级ID<br>
	 * 上级ID
	 * @return 上级ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级ID
	 * @param parentId 上级ID
	 * @return 当前对象
	*/
	public Config setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Config , 转换好的 Config 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Config , 转换好的 PoJo 对象
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
	public Config clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Config duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.ConfigMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.ConfigMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setTypeDesc(this.getTypeDesc());
		inst.setNotes(this.getNotes());
		inst.setCatalogCode(this.getCatalogCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProfileId(this.getProfileId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setValue(this.getValue());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Config clone(boolean deep) {
		return EntityContext.clone(Config.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Config
	 * @param configMap 包含实体信息的 Map 对象
	 * @return Config , 转换好的的 Config 对象
	*/
	@Transient
	public static Config createFrom(Map<String,Object> configMap) {
		if(configMap==null) return null;
		Config po = create();
		EntityContext.copyProperties(po,configMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Config
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Config , 转换好的的 Config 对象
	*/
	@Transient
	public static Config createFrom(Object pojo) {
		if(pojo==null) return null;
		Config po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Config，等同于 new
	 * @return Config 对象
	*/
	@Transient
	public static Config create() {
		return new org.github.foxnic.web.domain.system.meta.ConfigMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setCode(DataParser.parse(String.class, map.get(ConfigMeta.CODE)));
			this.setTypeDesc(DataParser.parse(String.class, map.get(ConfigMeta.TYPE_DESC)));
			this.setNotes(DataParser.parse(String.class, map.get(ConfigMeta.NOTES)));
			this.setCatalogCode(DataParser.parse(String.class, map.get(ConfigMeta.CATALOG_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ConfigMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(ConfigMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ConfigMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(ConfigMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, map.get(ConfigMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ConfigMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ConfigMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ConfigMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ConfigMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ConfigMeta.DELETE_TIME)));
			this.setProfileId(DataParser.parse(String.class, map.get(ConfigMeta.PROFILE_ID)));
			this.setName(DataParser.parse(String.class, map.get(ConfigMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ConfigMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ConfigMeta.ID)));
			this.setValue(DataParser.parse(String.class, map.get(ConfigMeta.VALUE)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ConfigMeta.CODE));
				this.setTypeDesc( (String)map.get(ConfigMeta.TYPE_DESC));
				this.setNotes( (String)map.get(ConfigMeta.NOTES));
				this.setCatalogCode( (String)map.get(ConfigMeta.CATALOG_CODE));
				this.setUpdateTime( (Date)map.get(ConfigMeta.UPDATE_TIME));
				this.setType( (String)map.get(ConfigMeta.TYPE));
				this.setVersion( (Integer)map.get(ConfigMeta.VERSION));
				this.setParentId( (String)map.get(ConfigMeta.PARENT_ID));
				this.setValid( (Integer)map.get(ConfigMeta.VALID));
				this.setCreateBy( (String)map.get(ConfigMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ConfigMeta.DELETED));
				this.setCreateTime( (Date)map.get(ConfigMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ConfigMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ConfigMeta.DELETE_TIME));
				this.setProfileId( (String)map.get(ConfigMeta.PROFILE_ID));
				this.setName( (String)map.get(ConfigMeta.NAME));
				this.setDeleteBy( (String)map.get(ConfigMeta.DELETE_BY));
				this.setId( (String)map.get(ConfigMeta.ID));
				this.setValue( (String)map.get(ConfigMeta.VALUE));
				// others
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setCode(DataParser.parse(String.class, r.getValue(ConfigMeta.CODE)));
			this.setTypeDesc(DataParser.parse(String.class, r.getValue(ConfigMeta.TYPE_DESC)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ConfigMeta.NOTES)));
			this.setCatalogCode(DataParser.parse(String.class, r.getValue(ConfigMeta.CATALOG_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ConfigMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(ConfigMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ConfigMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(ConfigMeta.PARENT_ID)));
			this.setValid(DataParser.parse(Integer.class, r.getValue(ConfigMeta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ConfigMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ConfigMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ConfigMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ConfigMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ConfigMeta.DELETE_TIME)));
			this.setProfileId(DataParser.parse(String.class, r.getValue(ConfigMeta.PROFILE_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(ConfigMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ConfigMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ConfigMeta.ID)));
			this.setValue(DataParser.parse(String.class, r.getValue(ConfigMeta.VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ConfigMeta.CODE));
				this.setTypeDesc( (String)r.getValue(ConfigMeta.TYPE_DESC));
				this.setNotes( (String)r.getValue(ConfigMeta.NOTES));
				this.setCatalogCode( (String)r.getValue(ConfigMeta.CATALOG_CODE));
				this.setUpdateTime( (Date)r.getValue(ConfigMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(ConfigMeta.TYPE));
				this.setVersion( (Integer)r.getValue(ConfigMeta.VERSION));
				this.setParentId( (String)r.getValue(ConfigMeta.PARENT_ID));
				this.setValid( (Integer)r.getValue(ConfigMeta.VALID));
				this.setCreateBy( (String)r.getValue(ConfigMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ConfigMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ConfigMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ConfigMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ConfigMeta.DELETE_TIME));
				this.setProfileId( (String)r.getValue(ConfigMeta.PROFILE_ID));
				this.setName( (String)r.getValue(ConfigMeta.NAME));
				this.setDeleteBy( (String)r.getValue(ConfigMeta.DELETE_BY));
				this.setId( (String)r.getValue(ConfigMeta.ID));
				this.setValue( (String)r.getValue(ConfigMeta.VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}