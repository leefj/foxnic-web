package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_CONFIG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷
 * @since 2021-05-20 01:28:25
 * @sign CCCC131534F2D7A16194A6BF815B5E1D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_config")
public class Config extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CONFIG.$TABLE;
	
	/**
	 * 配置键：配置键
	*/
	@Id
	@ApiModelProperty(required = true,value="配置键" , notes = "配置键")
	private String code;
	
	/**
	 * 配置名：配置名
	*/
	@ApiModelProperty(required = false,value="配置名" , notes = "配置名")
	private String name;
	
	/**
	 * 配置值：配置值
	*/
	@ApiModelProperty(required = false,value="配置值" , notes = "配置值")
	private String value;
	
	/**
	 * 是否生效：是否生效
	*/
	@ApiModelProperty(required = true,value="是否生效" , notes = "是否生效")
	private Boolean valid;
	
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
	 * 获得 配置键<br>
	 * 属性说明 : 配置键
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
	 * 添加 配置键
	 * @param code 配置键
	 * @return 当前对象
	*/
	
	/**
	 * 获得 配置名<br>
	 * 属性说明 : 配置名
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
	 * 添加 配置名
	 * @param name 配置名
	 * @return 当前对象
	*/
	
	/**
	 * 获得 配置值<br>
	 * 属性说明 : 配置值
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
	 * 添加 配置值
	 * @param value 配置值
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否生效<br>
	 * 属性说明 : 是否生效
	 * @return 是否生效
	*/
	public Boolean isValid() {
		return valid;
	}
	
	/**
	 * 获得 是否生效<br>
	 * 等价于 isValid 方法，为兼容 Swagger 需要
	 * 属性说明 : 是否生效
	 * @return 是否生效
	*/
	public Boolean getValid() {
		return this.valid;
	}
	
	/**
	 * 设置 是否生效
	 * @param valid 是否生效
	 * @return 当前对象
	*/
	public Config setValid(Boolean valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 添加 是否生效
	 * @param valid 是否生效
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
	public Config setCreateBy(Long createBy) {
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
	public Config setCreateTime(Date createTime) {
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
	public Config setUpdateBy(Long updateBy) {
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
	public Config setUpdateTime(Date updateTime) {
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
	public Config setDeleted(Boolean deleted) {
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
	public Config setDeleteBy(Long deleteBy) {
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
	public Config setDeleteTime(Date deleteTime) {
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
	public Config setVersion(Integer version) {
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
	 * 将 Map 转换成 Config
	 * @param configMap 包含实体信息的 Map 对象
	 * @return Config , 转换好的的 Config 对象
	*/
	@Transient
	public static Config createFrom(Map<String,Object> configMap) {
		if(configMap==null) return null;
		Config po = EntityContext.create(Config.class, configMap);
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
		Config po = EntityContext.create(Config.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Config，等同于 new
	 * @return Config 对象
	*/
	@Transient
	public static Config create() {
		return new Config();
	}
}