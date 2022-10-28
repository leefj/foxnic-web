package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.OauthClient;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:30
 * @sign 547B58F40BD29A5F2269D6519356D46E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OauthClientMeta {
	
	/**
	 * 客户端标识 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 客户端标识 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,ID, java.lang.String.class, "客户端标识", "客户端标识", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 资源集合 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String RESOURCE_IDS="resourceIds";
	
	/**
	 * 资源集合 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> RESOURCE_IDS_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,RESOURCE_IDS, java.lang.String.class, "资源集合", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 访问密匙 , 类型: java.lang.String
	*/
	public static final String CLIENT_SECRET="clientSecret";
	
	/**
	 * 访问密匙 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> CLIENT_SECRET_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,CLIENT_SECRET, java.lang.String.class, "访问密匙", "访问密匙", java.lang.String.class, null);
	
	/**
	 * 权限范围 , 类型: java.lang.String
	*/
	public static final String SCOPE="scope";
	
	/**
	 * 权限范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> SCOPE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,SCOPE, java.lang.String.class, "权限范围", "权限范围", java.lang.String.class, null);
	
	/**
	 * 授权类型 , 类型: java.lang.String
	*/
	public static final String AUTHORIZED_GRANT_TYPES="authorizedGrantTypes";
	
	/**
	 * 授权类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> AUTHORIZED_GRANT_TYPES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,AUTHORIZED_GRANT_TYPES, java.lang.String.class, "授权类型", "授权类型", java.lang.String.class, null);
	
	/**
	 * 重定向URI , 类型: java.lang.String
	*/
	public static final String WEB_SERVER_REDIRECT_URI="webServerRedirectUri";
	
	/**
	 * 重定向URI , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> WEB_SERVER_REDIRECT_URI_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,WEB_SERVER_REDIRECT_URI, java.lang.String.class, "重定向URI", "重定向URI", java.lang.String.class, null);
	
	/**
	 * 权限值列表 , 类型: java.lang.String
	*/
	public static final String AUTHORITIES="authorities";
	
	/**
	 * 权限值列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> AUTHORITIES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,AUTHORITIES, java.lang.String.class, "权限值列表", "权限值列表", java.lang.String.class, null);
	
	/**
	 * access , token时长(秒) , 类型: java.lang.Integer
	*/
	public static final String ACCESS_TOKEN_VALIDITY="accessTokenValidity";
	
	/**
	 * access , token时长(秒) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> ACCESS_TOKEN_VALIDITY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,ACCESS_TOKEN_VALIDITY, java.lang.Integer.class, "access", "token时长(秒)", java.lang.Integer.class, null);
	
	/**
	 * refresh , token时长(秒) , 类型: java.lang.Integer
	*/
	public static final String REFRESH_TOKEN_VALIDITY="refreshTokenValidity";
	
	/**
	 * refresh , token时长(秒) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> REFRESH_TOKEN_VALIDITY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,REFRESH_TOKEN_VALIDITY, java.lang.Integer.class, "refresh", "token时长(秒)", java.lang.Integer.class, null);
	
	/**
	 * 备注信息 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> NOTES_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,NOTES, java.lang.String.class, "备注信息", "备注信息", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 是否自动Approval操作 , 类型: java.lang.Integer
	*/
	public static final String AUTO_APPROVE="autoApprove";
	
	/**
	 * 是否自动Approval操作 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> AUTO_APPROVE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,AUTO_APPROVE, java.lang.Integer.class, "是否自动Approval操作", "是否自动Approval操作", java.lang.Integer.class, null);
	
	/**
	 * 是否信任 , 类型: java.lang.Integer
	*/
	public static final String TRUSTED="trusted";
	
	/**
	 * 是否信任 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> TRUSTED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,TRUSTED, java.lang.Integer.class, "是否信任", "是否信任", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.OauthClient,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.OauthClient.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , RESOURCE_IDS , CLIENT_SECRET , SCOPE , AUTHORIZED_GRANT_TYPES , WEB_SERVER_REDIRECT_URI , AUTHORITIES , ACCESS_TOKEN_VALIDITY , REFRESH_TOKEN_VALIDITY , NOTES , VALID , AUTO_APPROVE , TRUSTED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.OauthClient {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 客户端标识
		 * @param id 客户端标识
		 * @return 当前对象
		*/
		public OauthClient setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public OauthClient setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 资源集合
		 * @param resourceIds 资源集合
		 * @return 当前对象
		*/
		public OauthClient setResourceIds(String resourceIds) {
			super.change(RESOURCE_IDS,super.getResourceIds(),resourceIds);
			super.setResourceIds(resourceIds);
			return this;
		}
		
		/**
		 * 设置 访问密匙
		 * @param clientSecret 访问密匙
		 * @return 当前对象
		*/
		public OauthClient setClientSecret(String clientSecret) {
			super.change(CLIENT_SECRET,super.getClientSecret(),clientSecret);
			super.setClientSecret(clientSecret);
			return this;
		}
		
		/**
		 * 设置 权限范围
		 * @param scope 权限范围
		 * @return 当前对象
		*/
		public OauthClient setScope(String scope) {
			super.change(SCOPE,super.getScope(),scope);
			super.setScope(scope);
			return this;
		}
		
		/**
		 * 设置 授权类型
		 * @param authorizedGrantTypes 授权类型
		 * @return 当前对象
		*/
		public OauthClient setAuthorizedGrantTypes(String authorizedGrantTypes) {
			super.change(AUTHORIZED_GRANT_TYPES,super.getAuthorizedGrantTypes(),authorizedGrantTypes);
			super.setAuthorizedGrantTypes(authorizedGrantTypes);
			return this;
		}
		
		/**
		 * 设置 重定向URI
		 * @param webServerRedirectUri 重定向URI
		 * @return 当前对象
		*/
		public OauthClient setWebServerRedirectUri(String webServerRedirectUri) {
			super.change(WEB_SERVER_REDIRECT_URI,super.getWebServerRedirectUri(),webServerRedirectUri);
			super.setWebServerRedirectUri(webServerRedirectUri);
			return this;
		}
		
		/**
		 * 设置 权限值列表
		 * @param authorities 权限值列表
		 * @return 当前对象
		*/
		public OauthClient setAuthorities(String authorities) {
			super.change(AUTHORITIES,super.getAuthorities(),authorities);
			super.setAuthorities(authorities);
			return this;
		}
		
		/**
		 * 设置 access
		 * @param accessTokenValidity access
		 * @return 当前对象
		*/
		public OauthClient setAccessTokenValidity(Integer accessTokenValidity) {
			super.change(ACCESS_TOKEN_VALIDITY,super.getAccessTokenValidity(),accessTokenValidity);
			super.setAccessTokenValidity(accessTokenValidity);
			return this;
		}
		
		/**
		 * 设置 refresh
		 * @param refreshTokenValidity refresh
		 * @return 当前对象
		*/
		public OauthClient setRefreshTokenValidity(Integer refreshTokenValidity) {
			super.change(REFRESH_TOKEN_VALIDITY,super.getRefreshTokenValidity(),refreshTokenValidity);
			super.setRefreshTokenValidity(refreshTokenValidity);
			return this;
		}
		
		/**
		 * 设置 备注信息
		 * @param notes 备注信息
		 * @return 当前对象
		*/
		public OauthClient setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public OauthClient setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 是否自动Approval操作
		 * @param autoApprove 是否自动Approval操作
		 * @return 当前对象
		*/
		public OauthClient setAutoApprove(Integer autoApprove) {
			super.change(AUTO_APPROVE,super.getAutoApprove(),autoApprove);
			super.setAutoApprove(autoApprove);
			return this;
		}
		
		/**
		 * 设置 是否信任
		 * @param trusted 是否信任
		 * @return 当前对象
		*/
		public OauthClient setTrusted(Integer trusted) {
			super.change(TRUSTED,super.getTrusted(),trusted);
			super.setTrusted(trusted);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public OauthClient setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public OauthClient setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public OauthClient setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public OauthClient setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public OauthClient setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public OauthClient setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public OauthClient setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public OauthClient setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}