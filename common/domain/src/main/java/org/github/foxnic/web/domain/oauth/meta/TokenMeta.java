package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.Token;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-12 15:38:28
 * @sign B87FC6896ECA7824AE9D0D7CCEFB4C93
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TokenMeta {
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,USER_ID, java.lang.String.class, "账户ID", "账户ID", java.lang.String.class, null);
	
	/**
	 * Token标识 , 类型: java.lang.String
	*/
	public static final String JTI="jti";
	
	/**
	 * Token标识 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> JTI_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,JTI, java.lang.String.class, "Token标识", "Token标识", java.lang.String.class, null);
	
	/**
	 * 访问用Token , 类型: java.lang.String
	*/
	public static final String ACCESS_TOKEN="accessToken";
	
	/**
	 * 访问用Token , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> ACCESS_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,ACCESS_TOKEN, java.lang.String.class, "访问用Token", "访问用Token", java.lang.String.class, null);
	
	/**
	 * 刷新用Token , 类型: java.lang.String
	*/
	public static final String REFRESH_TOKEN="refreshToken";
	
	/**
	 * 刷新用Token , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> REFRESH_TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,REFRESH_TOKEN, java.lang.String.class, "刷新用Token", "刷新用Token", java.lang.String.class, null);
	
	/**
	 * 访问用Token过期时间 , 类型: java.util.Date
	*/
	public static final String ACCESS_TOKEN_EXPIRE_TIME="accessTokenExpireTime";
	
	/**
	 * 访问用Token过期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.util.Date> ACCESS_TOKEN_EXPIRE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,ACCESS_TOKEN_EXPIRE_TIME, java.util.Date.class, "访问用Token过期时间", "访问用Token过期时间", java.util.Date.class, null);
	
	/**
	 * 访问用Token是否过期 , 类型: java.lang.Integer
	*/
	public static final String ACCESS_TOKEN_EXPIRED="accessTokenExpired";
	
	/**
	 * 访问用Token是否过期 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.Integer> ACCESS_TOKEN_EXPIRED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,ACCESS_TOKEN_EXPIRED, java.lang.Integer.class, "访问用Token是否过期", "访问用Token是否过期", java.lang.Integer.class, null);
	
	/**
	 * 刷新用Token过期时间 , 类型: java.util.Date
	*/
	public static final String REFRESH_TOKEN_EXPIRE_TIME="refreshTokenExpireTime";
	
	/**
	 * 刷新用Token过期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.util.Date> REFRESH_TOKEN_EXPIRE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,REFRESH_TOKEN_EXPIRE_TIME, java.util.Date.class, "刷新用Token过期时间", "刷新用Token过期时间", java.util.Date.class, null);
	
	/**
	 * 刷新用Token是否过期 , 类型: java.lang.Integer
	*/
	public static final String REFRESH_TOKEN_EXPIRED="refreshTokenExpired";
	
	/**
	 * 刷新用Token是否过期 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.Integer> REFRESH_TOKEN_EXPIRED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,REFRESH_TOKEN_EXPIRED, java.lang.Integer.class, "刷新用Token是否过期", "刷新用Token是否过期", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.Token,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.Token.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}