package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_OAUTH_CLIENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 认证客户端
 * <p>认证客户端 , 数据表 sys_oauth_client 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-12 15:38:25
 * @sign 547B58F40BD29A5F2269D6519356D46E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_oauth_client")
@ApiModel(description = "认证客户端 ; 认证客户端 , 数据表 sys_oauth_client 的PO类型")
public class OauthClient extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_OAUTH_CLIENT.$TABLE;
	
	/**
	 * 客户端标识：客户端标识
	*/
	@Id
	@ApiModelProperty(required = true,value="客户端标识" , notes = "客户端标识")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 资源集合：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="资源集合" , notes = "用逗号隔开")
	private String resourceIds;
	
	/**
	 * 访问密匙：访问密匙
	*/
	@ApiModelProperty(required = false,value="访问密匙" , notes = "访问密匙")
	private String clientSecret;
	
	/**
	 * 权限范围：权限范围
	*/
	@ApiModelProperty(required = false,value="权限范围" , notes = "权限范围")
	private String scope;
	
	/**
	 * 授权类型：授权类型
	*/
	@ApiModelProperty(required = false,value="授权类型" , notes = "授权类型")
	private String authorizedGrantTypes;
	
	/**
	 * 重定向URI：重定向URI
	*/
	@ApiModelProperty(required = false,value="重定向URI" , notes = "重定向URI")
	private String webServerRedirectUri;
	
	/**
	 * 权限值列表：权限值列表
	*/
	@ApiModelProperty(required = false,value="权限值列表" , notes = "权限值列表")
	private String authorities;
	
	/**
	 * access：token时长(秒)
	*/
	@ApiModelProperty(required = false,value="access" , notes = "token时长(秒)")
	private Integer accessTokenValidity;
	
	/**
	 * refresh：token时长(秒)
	*/
	@ApiModelProperty(required = false,value="refresh" , notes = "token时长(秒)")
	private Integer refreshTokenValidity;
	
	/**
	 * 备注信息：备注信息
	*/
	@ApiModelProperty(required = false,value="备注信息" , notes = "备注信息")
	private String notes;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = false,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
	/**
	 * 是否自动Approval操作：是否自动Approval操作
	*/
	@ApiModelProperty(required = false,value="是否自动Approval操作" , notes = "是否自动Approval操作")
	private Integer autoApprove;
	
	/**
	 * 是否信任：是否信任
	*/
	@ApiModelProperty(required = false,value="是否信任" , notes = "是否信任")
	private Integer trusted;
	
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
	 * 获得 客户端标识<br>
	 * 客户端标识
	 * @return 客户端标识
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 客户端标识
	 * @param id 客户端标识
	 * @return 当前对象
	*/
	public OauthClient setId(String id) {
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
	public OauthClient setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 资源集合<br>
	 * 用逗号隔开
	 * @return 资源集合
	*/
	public String getResourceIds() {
		return resourceIds;
	}
	
	/**
	 * 设置 资源集合
	 * @param resourceIds 资源集合
	 * @return 当前对象
	*/
	public OauthClient setResourceIds(String resourceIds) {
		this.resourceIds=resourceIds;
		return this;
	}
	
	/**
	 * 获得 访问密匙<br>
	 * 访问密匙
	 * @return 访问密匙
	*/
	public String getClientSecret() {
		return clientSecret;
	}
	
	/**
	 * 设置 访问密匙
	 * @param clientSecret 访问密匙
	 * @return 当前对象
	*/
	public OauthClient setClientSecret(String clientSecret) {
		this.clientSecret=clientSecret;
		return this;
	}
	
	/**
	 * 获得 权限范围<br>
	 * 权限范围
	 * @return 权限范围
	*/
	public String getScope() {
		return scope;
	}
	
	/**
	 * 设置 权限范围
	 * @param scope 权限范围
	 * @return 当前对象
	*/
	public OauthClient setScope(String scope) {
		this.scope=scope;
		return this;
	}
	
	/**
	 * 获得 授权类型<br>
	 * 授权类型
	 * @return 授权类型
	*/
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}
	
	/**
	 * 设置 授权类型
	 * @param authorizedGrantTypes 授权类型
	 * @return 当前对象
	*/
	public OauthClient setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes=authorizedGrantTypes;
		return this;
	}
	
	/**
	 * 获得 重定向URI<br>
	 * 重定向URI
	 * @return 重定向URI
	*/
	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}
	
	/**
	 * 设置 重定向URI
	 * @param webServerRedirectUri 重定向URI
	 * @return 当前对象
	*/
	public OauthClient setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri=webServerRedirectUri;
		return this;
	}
	
	/**
	 * 获得 权限值列表<br>
	 * 权限值列表
	 * @return 权限值列表
	*/
	public String getAuthorities() {
		return authorities;
	}
	
	/**
	 * 设置 权限值列表
	 * @param authorities 权限值列表
	 * @return 当前对象
	*/
	public OauthClient setAuthorities(String authorities) {
		this.authorities=authorities;
		return this;
	}
	
	/**
	 * 获得 access<br>
	 * token时长(秒)
	 * @return access
	*/
	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}
	
	/**
	 * 设置 access
	 * @param accessTokenValidity access
	 * @return 当前对象
	*/
	public OauthClient setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity=accessTokenValidity;
		return this;
	}
	
	/**
	 * 获得 refresh<br>
	 * token时长(秒)
	 * @return refresh
	*/
	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}
	
	/**
	 * 设置 refresh
	 * @param refreshTokenValidity refresh
	 * @return 当前对象
	*/
	public OauthClient setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity=refreshTokenValidity;
		return this;
	}
	
	/**
	 * 获得 备注信息<br>
	 * 备注信息
	 * @return 备注信息
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注信息
	 * @param notes 备注信息
	 * @return 当前对象
	*/
	public OauthClient setNotes(String notes) {
		this.notes=notes;
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
	public OauthClient setValid(Integer valid) {
		this.valid=valid;
		return this;
	}
	
	/**
	 * 获得 是否自动Approval操作<br>
	 * 是否自动Approval操作
	 * @return 是否自动Approval操作
	*/
	public Integer getAutoApprove() {
		return autoApprove;
	}
	
	/**
	 * 设置 是否自动Approval操作
	 * @param autoApprove 是否自动Approval操作
	 * @return 当前对象
	*/
	public OauthClient setAutoApprove(Integer autoApprove) {
		this.autoApprove=autoApprove;
		return this;
	}
	
	/**
	 * 获得 是否信任<br>
	 * 是否信任
	 * @return 是否信任
	*/
	public Integer getTrusted() {
		return trusted;
	}
	
	/**
	 * 设置 是否信任
	 * @param trusted 是否信任
	 * @return 当前对象
	*/
	public OauthClient setTrusted(Integer trusted) {
		this.trusted=trusted;
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
	public OauthClient setCreateBy(String createBy) {
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
	public OauthClient setCreateTime(Date createTime) {
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
	public OauthClient setUpdateBy(String updateBy) {
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
	public OauthClient setUpdateTime(Date updateTime) {
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
	public OauthClient setDeleted(Integer deleted) {
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
	public OauthClient setDeleted(Boolean deletedBool) {
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
	public OauthClient setDeleteBy(String deleteBy) {
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
	public OauthClient setDeleteTime(Date deleteTime) {
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
	public OauthClient setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return OauthClient , 转换好的 OauthClient 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return OauthClient , 转换好的 PoJo 对象
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
	public OauthClient clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public OauthClient duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.OauthClientMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.OauthClientMeta.$$proxy$$();
		inst.setAuthorizedGrantTypes(this.getAuthorizedGrantTypes());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAuthorities(this.getAuthorities());
		inst.setAccessTokenValidity(this.getAccessTokenValidity());
		inst.setAutoApprove(this.getAutoApprove());
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setTrusted(this.getTrusted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRefreshTokenValidity(this.getRefreshTokenValidity());
		inst.setScope(this.getScope());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setClientSecret(this.getClientSecret());
		inst.setWebServerRedirectUri(this.getWebServerRedirectUri());
		inst.setId(this.getId());
		inst.setResourceIds(this.getResourceIds());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public OauthClient clone(boolean deep) {
		return EntityContext.clone(OauthClient.class,this,deep);
	}

	/**
	 * 将 Map 转换成 OauthClient
	 * @param oauthClientMap 包含实体信息的 Map 对象
	 * @return OauthClient , 转换好的的 OauthClient 对象
	*/
	@Transient
	public static OauthClient createFrom(Map<String,Object> oauthClientMap) {
		if(oauthClientMap==null) return null;
		OauthClient po = create();
		EntityContext.copyProperties(po,oauthClientMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 OauthClient
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return OauthClient , 转换好的的 OauthClient 对象
	*/
	@Transient
	public static OauthClient createFrom(Object pojo) {
		if(pojo==null) return null;
		OauthClient po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 OauthClient，等同于 new
	 * @return OauthClient 对象
	*/
	@Transient
	public static OauthClient create() {
		return new org.github.foxnic.web.domain.oauth.meta.OauthClientMeta.$$proxy$$();
	}
}