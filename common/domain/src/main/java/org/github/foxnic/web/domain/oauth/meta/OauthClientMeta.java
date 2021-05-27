package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.OauthClient;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-26 02:02:23
 * @sign 0627C7313D0CCB722858B4489E4C0C03
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OauthClientMeta {
	
	/**
	 * 客户端标识
	*/
	public static final String ID="id";
	
	/**
	 * 名称
	*/
	public static final String NAME="name";
	
	/**
	 * 资源集合 , 用逗号隔开
	*/
	public static final String RESOURCE_IDS="resourceIds";
	
	/**
	 * 访问密匙
	*/
	public static final String CLIENT_SECRET="clientSecret";
	
	/**
	 * 权限范围
	*/
	public static final String SCOPE="scope";
	
	/**
	 * 授权类型
	*/
	public static final String AUTHORIZED_GRANT_TYPES="authorizedGrantTypes";
	
	/**
	 * 重定向URI
	*/
	public static final String WEB_SERVER_REDIRECT_URI="webServerRedirectUri";
	
	/**
	 * 权限值列表
	*/
	public static final String AUTHORITIES="authorities";
	
	/**
	 * access , token时长(秒)
	*/
	public static final String ACCESS_TOKEN_VALIDITY="accessTokenValidity";
	
	/**
	 * refresh , token时长(秒)
	*/
	public static final String REFRESH_TOKEN_VALIDITY="refreshTokenValidity";
	
	/**
	 * 备注信息
	*/
	public static final String NOTES="notes";
	
	/**
	 * 是否有效
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否自动Approval操作
	*/
	public static final String AUTO_APPROVE="autoApprove";
	
	/**
	 * 是否信任
	*/
	public static final String TRUSTED="trusted";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
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
		public OauthClient setCreateBy(Long createBy) {
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
		public OauthClient setUpdateBy(Long updateBy) {
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
		public OauthClient setDeleteBy(Long deleteBy) {
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
	}
}