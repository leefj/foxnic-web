package org.github.foxnic.web.domain.oauth.meta;

import org.github.foxnic.web.domain.oauth.Token;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 17:27:49
 * @sign 61F3EA44FEFF15349F32D096684D1DDA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TokenMeta {
	
	/**
	 * id
	*/
	public static final String ID="id";
	
	/**
	 * 账户ID
	*/
	public static final String USER_ID="userId";
	
	/**
	 * Token标识
	*/
	public static final String JTI="jti";
	
	/**
	 * 访问用Token
	*/
	public static final String ACCESS_TOKEN="accessToken";
	
	/**
	 * 刷新用Token
	*/
	public static final String REFRESH_TOKEN="refreshToken";
	
	/**
	 * 访问用Token过期时间
	*/
	public static final String ACCESS_TOKEN_EXPIRE_TIME="accessTokenExpireTime";
	
	/**
	 * 访问用Token是否过期
	*/
	public static final String ACCESS_TOKEN_EXPIRED="accessTokenExpired";
	
	/**
	 * 刷新用Token过期时间
	*/
	public static final String REFRESH_TOKEN_EXPIRE_TIME="refreshTokenExpireTime";
	
	/**
	 * 刷新用Token是否过期
	*/
	public static final String REFRESH_TOKEN_EXPIRED="refreshTokenExpired";
	
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
	public static final String[] $PROPS={ ID , USER_ID , JTI , ACCESS_TOKEN , REFRESH_TOKEN , ACCESS_TOKEN_EXPIRE_TIME , ACCESS_TOKEN_EXPIRED , REFRESH_TOKEN_EXPIRE_TIME , REFRESH_TOKEN_EXPIRED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.Token {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public Token setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 账户ID
		 * @param userId 账户ID
		 * @return 当前对象
		*/
		public Token setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 Token标识
		 * @param jti Token标识
		 * @return 当前对象
		*/
		public Token setJti(String jti) {
			super.change(JTI,super.getJti(),jti);
			super.setJti(jti);
			return this;
		}
		
		/**
		 * 设置 访问用Token
		 * @param accessToken 访问用Token
		 * @return 当前对象
		*/
		public Token setAccessToken(String accessToken) {
			super.change(ACCESS_TOKEN,super.getAccessToken(),accessToken);
			super.setAccessToken(accessToken);
			return this;
		}
		
		/**
		 * 设置 刷新用Token
		 * @param refreshToken 刷新用Token
		 * @return 当前对象
		*/
		public Token setRefreshToken(String refreshToken) {
			super.change(REFRESH_TOKEN,super.getRefreshToken(),refreshToken);
			super.setRefreshToken(refreshToken);
			return this;
		}
		
		/**
		 * 设置 访问用Token过期时间
		 * @param accessTokenExpireTime 访问用Token过期时间
		 * @return 当前对象
		*/
		public Token setAccessTokenExpireTime(Date accessTokenExpireTime) {
			super.change(ACCESS_TOKEN_EXPIRE_TIME,super.getAccessTokenExpireTime(),accessTokenExpireTime);
			super.setAccessTokenExpireTime(accessTokenExpireTime);
			return this;
		}
		
		/**
		 * 设置 访问用Token是否过期
		 * @param accessTokenExpired 访问用Token是否过期
		 * @return 当前对象
		*/
		public Token setAccessTokenExpired(Integer accessTokenExpired) {
			super.change(ACCESS_TOKEN_EXPIRED,super.getAccessTokenExpired(),accessTokenExpired);
			super.setAccessTokenExpired(accessTokenExpired);
			return this;
		}
		
		/**
		 * 设置 刷新用Token过期时间
		 * @param refreshTokenExpireTime 刷新用Token过期时间
		 * @return 当前对象
		*/
		public Token setRefreshTokenExpireTime(Date refreshTokenExpireTime) {
			super.change(REFRESH_TOKEN_EXPIRE_TIME,super.getRefreshTokenExpireTime(),refreshTokenExpireTime);
			super.setRefreshTokenExpireTime(refreshTokenExpireTime);
			return this;
		}
		
		/**
		 * 设置 刷新用Token是否过期
		 * @param refreshTokenExpired 刷新用Token是否过期
		 * @return 当前对象
		*/
		public Token setRefreshTokenExpired(Integer refreshTokenExpired) {
			super.change(REFRESH_TOKEN_EXPIRED,super.getRefreshTokenExpired(),refreshTokenExpired);
			super.setRefreshTokenExpired(refreshTokenExpired);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Token setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Token setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Token setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Token setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Token setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Token setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Token setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Token setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}