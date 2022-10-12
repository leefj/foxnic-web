package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_TOKEN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * Token
 * <p>Token , 数据表 sys_token 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-12 15:38:27
 * @sign B87FC6896ECA7824AE9D0D7CCEFB4C93
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_token")
@ApiModel(description = "Token ; Token , 数据表 sys_token 的PO类型")
public class Token extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_TOKEN.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID")
	private String userId;
	
	/**
	 * Token标识：Token标识
	*/
	@ApiModelProperty(required = false,value="Token标识" , notes = "Token标识")
	private String jti;
	
	/**
	 * 访问用Token：访问用Token
	*/
	@ApiModelProperty(required = false,value="访问用Token" , notes = "访问用Token")
	private String accessToken;
	
	/**
	 * 刷新用Token：刷新用Token
	*/
	@ApiModelProperty(required = false,value="刷新用Token" , notes = "刷新用Token")
	private String refreshToken;
	
	/**
	 * 访问用Token过期时间：访问用Token过期时间
	*/
	@ApiModelProperty(required = false,value="访问用Token过期时间" , notes = "访问用Token过期时间")
	private Date accessTokenExpireTime;
	
	/**
	 * 访问用Token是否过期：访问用Token是否过期
	*/
	@ApiModelProperty(required = true,value="访问用Token是否过期" , notes = "访问用Token是否过期")
	private Integer accessTokenExpired;
	
	/**
	 * 刷新用Token过期时间：刷新用Token过期时间
	*/
	@ApiModelProperty(required = false,value="刷新用Token过期时间" , notes = "刷新用Token过期时间")
	private Date refreshTokenExpireTime;
	
	/**
	 * 刷新用Token是否过期：刷新用Token是否过期
	*/
	@ApiModelProperty(required = true,value="刷新用Token是否过期" , notes = "刷新用Token是否过期")
	private Integer refreshTokenExpired;
	
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
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public Token setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 账户ID<br>
	 * 账户ID
	 * @return 账户ID
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 账户ID
	 * @param userId 账户ID
	 * @return 当前对象
	*/
	public Token setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 Token标识<br>
	 * Token标识
	 * @return Token标识
	*/
	public String getJti() {
		return jti;
	}
	
	/**
	 * 设置 Token标识
	 * @param jti Token标识
	 * @return 当前对象
	*/
	public Token setJti(String jti) {
		this.jti=jti;
		return this;
	}
	
	/**
	 * 获得 访问用Token<br>
	 * 访问用Token
	 * @return 访问用Token
	*/
	public String getAccessToken() {
		return accessToken;
	}
	
	/**
	 * 设置 访问用Token
	 * @param accessToken 访问用Token
	 * @return 当前对象
	*/
	public Token setAccessToken(String accessToken) {
		this.accessToken=accessToken;
		return this;
	}
	
	/**
	 * 获得 刷新用Token<br>
	 * 刷新用Token
	 * @return 刷新用Token
	*/
	public String getRefreshToken() {
		return refreshToken;
	}
	
	/**
	 * 设置 刷新用Token
	 * @param refreshToken 刷新用Token
	 * @return 当前对象
	*/
	public Token setRefreshToken(String refreshToken) {
		this.refreshToken=refreshToken;
		return this;
	}
	
	/**
	 * 获得 访问用Token过期时间<br>
	 * 访问用Token过期时间
	 * @return 访问用Token过期时间
	*/
	public Date getAccessTokenExpireTime() {
		return accessTokenExpireTime;
	}
	
	/**
	 * 设置 访问用Token过期时间
	 * @param accessTokenExpireTime 访问用Token过期时间
	 * @return 当前对象
	*/
	public Token setAccessTokenExpireTime(Date accessTokenExpireTime) {
		this.accessTokenExpireTime=accessTokenExpireTime;
		return this;
	}
	
	/**
	 * 获得 访问用Token是否过期<br>
	 * 访问用Token是否过期
	 * @return 访问用Token是否过期
	*/
	public Integer getAccessTokenExpired() {
		return accessTokenExpired;
	}
	
	/**
	 * 设置 访问用Token是否过期
	 * @param accessTokenExpired 访问用Token是否过期
	 * @return 当前对象
	*/
	public Token setAccessTokenExpired(Integer accessTokenExpired) {
		this.accessTokenExpired=accessTokenExpired;
		return this;
	}
	
	/**
	 * 获得 刷新用Token过期时间<br>
	 * 刷新用Token过期时间
	 * @return 刷新用Token过期时间
	*/
	public Date getRefreshTokenExpireTime() {
		return refreshTokenExpireTime;
	}
	
	/**
	 * 设置 刷新用Token过期时间
	 * @param refreshTokenExpireTime 刷新用Token过期时间
	 * @return 当前对象
	*/
	public Token setRefreshTokenExpireTime(Date refreshTokenExpireTime) {
		this.refreshTokenExpireTime=refreshTokenExpireTime;
		return this;
	}
	
	/**
	 * 获得 刷新用Token是否过期<br>
	 * 刷新用Token是否过期
	 * @return 刷新用Token是否过期
	*/
	public Integer getRefreshTokenExpired() {
		return refreshTokenExpired;
	}
	
	/**
	 * 设置 刷新用Token是否过期
	 * @param refreshTokenExpired 刷新用Token是否过期
	 * @return 当前对象
	*/
	public Token setRefreshTokenExpired(Integer refreshTokenExpired) {
		this.refreshTokenExpired=refreshTokenExpired;
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
	public Token setCreateBy(String createBy) {
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
	public Token setCreateTime(Date createTime) {
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
	public Token setUpdateBy(String updateBy) {
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
	public Token setUpdateTime(Date updateTime) {
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
	public Token setDeleted(Integer deleted) {
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
	public Token setDeleted(Boolean deletedBool) {
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
	public Token setDeleteBy(String deleteBy) {
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
	public Token setDeleteTime(Date deleteTime) {
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
	public Token setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Token , 转换好的 Token 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Token , 转换好的 PoJo 对象
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
	public Token clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Token duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.TokenMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.TokenMeta.$$proxy$$();
		inst.setAccessTokenExpireTime(this.getAccessTokenExpireTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setAccessToken(this.getAccessToken());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setRefreshTokenExpireTime(this.getRefreshTokenExpireTime());
		inst.setRefreshTokenExpired(this.getRefreshTokenExpired());
		inst.setDeleted(this.getDeleted());
		inst.setAccessTokenExpired(this.getAccessTokenExpired());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setJti(this.getJti());
		inst.setRefreshToken(this.getRefreshToken());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Token clone(boolean deep) {
		return EntityContext.clone(Token.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Token
	 * @param tokenMap 包含实体信息的 Map 对象
	 * @return Token , 转换好的的 Token 对象
	*/
	@Transient
	public static Token createFrom(Map<String,Object> tokenMap) {
		if(tokenMap==null) return null;
		Token po = create();
		EntityContext.copyProperties(po,tokenMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Token
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Token , 转换好的的 Token 对象
	*/
	@Transient
	public static Token createFrom(Object pojo) {
		if(pojo==null) return null;
		Token po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Token，等同于 new
	 * @return Token 对象
	*/
	@Transient
	public static Token create() {
		return new org.github.foxnic.web.domain.oauth.meta.TokenMeta.$$proxy$$();
	}
}