package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.sql.meta.DBTable;
import io.swagger.annotations.ApiModelProperty;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_OAUTH_CLIENT;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Map;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-28 15:09:51
 * @sign 80217A241E1E48648680C90E230A2E8A1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_oauth_client")
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
	 * 属性说明 : 客户端标识
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
	 * 添加 客户端标识
	 * @param id 客户端标识
	 * @return 当前对象
	*/
	
	/**
	 * 获得 名称<br>
	 * 属性说明 : 名称
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
	 * 添加 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 资源集合<br>
	 * 属性说明 : 用逗号隔开
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
	 * 添加 资源集合
	 * @param resourceIds 资源集合
	 * @return 当前对象
	*/
	
	/**
	 * 获得 访问密匙<br>
	 * 属性说明 : 访问密匙
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
	 * 添加 访问密匙
	 * @param clientSecret 访问密匙
	 * @return 当前对象
	*/
	
	/**
	 * 获得 权限范围<br>
	 * 属性说明 : 权限范围
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
	 * 添加 权限范围
	 * @param scope 权限范围
	 * @return 当前对象
	*/
	
	/**
	 * 获得 授权类型<br>
	 * 属性说明 : 授权类型
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
	 * 添加 授权类型
	 * @param authorizedGrantTypes 授权类型
	 * @return 当前对象
	*/
	
	/**
	 * 获得 重定向URI<br>
	 * 属性说明 : 重定向URI
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
	 * 添加 重定向URI
	 * @param webServerRedirectUri 重定向URI
	 * @return 当前对象
	*/
	
	/**
	 * 获得 权限值列表<br>
	 * 属性说明 : 权限值列表
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
	 * 添加 权限值列表
	 * @param authorities 权限值列表
	 * @return 当前对象
	*/
	
	/**
	 * 获得 access<br>
	 * 属性说明 : token时长(秒)
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
	 * 添加 access
	 * @param accessTokenValidity access
	 * @return 当前对象
	*/
	
	/**
	 * 获得 refresh<br>
	 * 属性说明 : token时长(秒)
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
	 * 添加 refresh
	 * @param refreshTokenValidity refresh
	 * @return 当前对象
	*/
	
	/**
	 * 获得 备注信息<br>
	 * 属性说明 : 备注信息
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
	 * 添加 备注信息
	 * @param notes 备注信息
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否有效<br>
	 * 属性说明 : 是否有效
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
	 * 添加 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否自动Approval操作<br>
	 * 属性说明 : 是否自动Approval操作
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
	 * 添加 是否自动Approval操作
	 * @param autoApprove 是否自动Approval操作
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否信任<br>
	 * 属性说明 : 是否信任
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
	 * 添加 是否信任
	 * @param trusted 是否信任
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
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
	public OauthClient setCreateTime(Date createTime) {
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
	public OauthClient setUpdateTime(Date updateTime) {
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
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public OauthClient setDeleted(Integer deleted) {
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
	public OauthClient setDeleteTime(Date deleteTime) {
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
	public OauthClient setVersion(Integer version) {
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
	 * 将 Map 转换成 OauthClient
	 * @param oauthClientMap 包含实体信息的 Map 对象
	 * @return OauthClient , 转换好的的 OauthClient 对象
	*/
	@Transient
	public static OauthClient createFrom(Map<String,Object> oauthClientMap) {
		if(oauthClientMap==null) return null;
		OauthClient po = EntityContext.create(OauthClient.class, oauthClientMap);
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
		OauthClient po = EntityContext.create(OauthClient.class,pojo);
		return po;
	}

	/**
	 * 创建一个 OauthClient，等同于 new
	 * @return OauthClient 对象
	*/
	@Transient
	public static OauthClient create() {
		return new OauthClient();
	}
}