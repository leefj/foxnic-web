package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_RESOURZE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.enums.hrm.ResourceType;
import javax.persistence.Transient;
import org.github.foxnic.web.constants.enums.system.AccessType;
import org.github.foxnic.web.constants.enums.system.HttpMethodType;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 系统资源
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-03-10 16:43:00
 * @sign 583BBDA673F96561C0B687C0773621D5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_resourze")
public class Resourze extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_RESOURZE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 类型：api/page
	*/
	@ApiModelProperty(required = true,value="类型" , notes = "api/page")
	private String type;
	@Transient
	private ResourceType typeEnum;
	
	/**
	 * 访问控制类型：访问控制类型
	*/
	@ApiModelProperty(required = true,value="访问控制类型" , notes = "访问控制类型")
	private String accessType;
	@Transient
	private AccessType accessTypeEnum;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = true,value="地址" , notes = "地址")
	private String url;
	
	/**
	 * HttpMethod：HttpMethod
	*/
	@ApiModelProperty(required = true,value="HttpMethod" , notes = "HttpMethod")
	private String method;
	@Transient
	private HttpMethodType methodEnum;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 来源表：来源表
	*/
	@ApiModelProperty(required = false,value="来源表" , notes = "来源表")
	private String tableName;
	
	/**
	 * 来源模块：来源模块
	*/
	@ApiModelProperty(required = false,value="来源模块" , notes = "来源模块")
	private String module;
	
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
	public Resourze setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Resourze setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * api/page
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 类型
	*/
	@Transient
	public ResourceType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (ResourceType) EnumUtil.parseByCode(ResourceType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Resourze setType(String type) {
		this.type=type;
		this.typeEnum= (ResourceType) EnumUtil.parseByCode(ResourceType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of ResourceType");
		}
		return this;
	}
	
	/**
	 * 设置 类型的投影属性，等同于设置 类型
	 * @param typeEnum 类型
	 * @return 当前对象
	*/
	@Transient
	public Resourze setTypeEnum(ResourceType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 访问控制类型<br>
	 * 访问控制类型
	 * @return 访问控制类型
	*/
	public String getAccessType() {
		return accessType;
	}
	
	/**
	 * 获得 访问控制类型 的投影属性<br>
	 * 等价于 getAccessType 方法，获得对应的枚举类型
	 * @return 访问控制类型
	*/
	@Transient
	public AccessType getAccessTypeEnum() {
		if(this.accessTypeEnum==null) {
			this.accessTypeEnum = (AccessType) EnumUtil.parseByCode(AccessType.values(),accessType);
		}
		return this.accessTypeEnum ;
	}
	
	/**
	 * 设置 访问控制类型
	 * @param accessType 访问控制类型
	 * @return 当前对象
	*/
	public Resourze setAccessType(String accessType) {
		this.accessType=accessType;
		this.accessTypeEnum= (AccessType) EnumUtil.parseByCode(AccessType.values(),accessType) ;
		if(StringUtil.hasContent(accessType) && this.accessTypeEnum==null) {
			throw new IllegalArgumentException( accessType + " is not one of AccessType");
		}
		return this;
	}
	
	/**
	 * 设置 访问控制类型的投影属性，等同于设置 访问控制类型
	 * @param accessTypeEnum 访问控制类型
	 * @return 当前对象
	*/
	@Transient
	public Resourze setAccessTypeEnum(AccessType accessTypeEnum) {
		if(accessTypeEnum==null) {
			this.setAccessType(null);
		} else {
			this.setAccessType(accessTypeEnum.code());
		}
		this.accessTypeEnum=accessTypeEnum;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getUrl() {
		return url;
	}
	
	/**
	 * 设置 地址
	 * @param url 地址
	 * @return 当前对象
	*/
	public Resourze setUrl(String url) {
		this.url=url;
		return this;
	}
	
	/**
	 * 获得 HttpMethod<br>
	 * HttpMethod
	 * @return HttpMethod
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 获得 HttpMethod 的投影属性<br>
	 * 等价于 getMethod 方法，获得对应的枚举类型
	 * @return HttpMethod
	*/
	@Transient
	public HttpMethodType getMethodEnum() {
		if(this.methodEnum==null) {
			this.methodEnum = (HttpMethodType) EnumUtil.parseByCode(HttpMethodType.values(),method);
		}
		return this.methodEnum ;
	}
	
	/**
	 * 设置 HttpMethod
	 * @param method HttpMethod
	 * @return 当前对象
	*/
	public Resourze setMethod(String method) {
		this.method=method;
		this.methodEnum= (HttpMethodType) EnumUtil.parseByCode(HttpMethodType.values(),method) ;
		if(StringUtil.hasContent(method) && this.methodEnum==null) {
			throw new IllegalArgumentException( method + " is not one of HttpMethodType");
		}
		return this;
	}
	
	/**
	 * 设置 HttpMethod的投影属性，等同于设置 HttpMethod
	 * @param methodEnum HttpMethod
	 * @return 当前对象
	*/
	@Transient
	public Resourze setMethodEnum(HttpMethodType methodEnum) {
		if(methodEnum==null) {
			this.setMethod(null);
		} else {
			this.setMethod(methodEnum.code());
		}
		this.methodEnum=methodEnum;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getBatchId() {
		return batchId;
	}
	
	/**
	 * 设置 批次号
	 * @param batchId 批次号
	 * @return 当前对象
	*/
	public Resourze setBatchId(String batchId) {
		this.batchId=batchId;
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
	public Resourze setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 来源表<br>
	 * 来源表
	 * @return 来源表
	*/
	public String getTableName() {
		return tableName;
	}
	
	/**
	 * 设置 来源表
	 * @param tableName 来源表
	 * @return 当前对象
	*/
	public Resourze setTableName(String tableName) {
		this.tableName=tableName;
		return this;
	}
	
	/**
	 * 获得 来源模块<br>
	 * 来源模块
	 * @return 来源模块
	*/
	public String getModule() {
		return module;
	}
	
	/**
	 * 设置 来源模块
	 * @param module 来源模块
	 * @return 当前对象
	*/
	public Resourze setModule(String module) {
		this.module=module;
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
	public Resourze setCreateTime(Date createTime) {
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
	public Resourze setUpdateBy(String updateBy) {
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
	public Resourze setUpdateTime(Date updateTime) {
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
	public Resourze setDeleted(Integer deleted) {
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
	public Resourze setDeleteBy(String deleteBy) {
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
	public Resourze setDeleteTime(Date deleteTime) {
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
	public Resourze setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Resourze , 转换好的 Resourze 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Resourze , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Resourze
	 * @param resourzeMap 包含实体信息的 Map 对象
	 * @return Resourze , 转换好的的 Resourze 对象
	*/
	@Transient
	public static Resourze createFrom(Map<String,Object> resourzeMap) {
		if(resourzeMap==null) return null;
		Resourze po = EntityContext.create(Resourze.class, resourzeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Resourze
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Resourze , 转换好的的 Resourze 对象
	*/
	@Transient
	public static Resourze createFrom(Object pojo) {
		if(pojo==null) return null;
		Resourze po = EntityContext.create(Resourze.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Resourze，等同于 new
	 * @return Resourze 对象
	*/
	@Transient
	public static Resourze create() {
		return EntityContext.create(Resourze.class);
	}
}