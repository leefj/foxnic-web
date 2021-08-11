package org.github.foxnic.web.domain.oauth.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.oauth.SessionOnline;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-11 16:55:28
 * @sign 2A4666C838F1AE796F066AB4F06C4627
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SessionOnlineMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final String SESSION_ID="sessionId";
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> SESSION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,SESSION_ID, java.lang.String.class, "会话ID", "会话ID", java.lang.String.class, null);
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,USER_ID, java.lang.String.class, "账户ID", "账户ID", java.lang.String.class, null);
	
	/**
	 * 登录时间 , 类型: java.util.Date
	*/
	public static final String LOGIN_TIME="loginTime";
	
	/**
	 * 登录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> LOGIN_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,LOGIN_TIME, java.util.Date.class, "登录时间", "登录时间", java.util.Date.class, null);
	
	/**
	 * 最近一次交互时间 , 类型: java.util.Date
	*/
	public static final String INTERACT_TIME="interactTime";
	
	/**
	 * 最近一次交互时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> INTERACT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,INTERACT_TIME, java.util.Date.class, "最近一次交互时间", "最近一次交互时间", java.util.Date.class, null);
	
	/**
	 * 最后访问的地址 , 类型: java.lang.String
	*/
	public static final String INTERACT_URL="interactUrl";
	
	/**
	 * 最后访问的地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> INTERACT_URL_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,INTERACT_URL, java.lang.String.class, "最后访问的地址", "最后访问的地址", java.lang.String.class, null);
	
	/**
	 * 登出时间 , 类型: java.util.Date
	*/
	public static final String LOGOUT_TIME="logoutTime";
	
	/**
	 * 登出时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> LOGOUT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,LOGOUT_TIME, java.util.Date.class, "登出时间", "登出时间", java.util.Date.class, null);
	
	/**
	 * 会话时长 , 单位秒 , 类型: java.lang.Integer
	*/
	public static final String SESSION_TIME="sessionTime";
	
	/**
	 * 会话时长 , 单位秒 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.Integer> SESSION_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,SESSION_TIME, java.lang.Integer.class, "会话时长", "单位秒", java.lang.Integer.class, null);
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final String ONLINE="online";
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.Integer> ONLINE_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,ONLINE, java.lang.Integer.class, "是否在线", "是否在线", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.oauth.SessionOnline,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.oauth.SessionOnline.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SESSION_ID , USER_ID , LOGIN_TIME , INTERACT_TIME , INTERACT_URL , LOGOUT_TIME , SESSION_TIME , ONLINE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.oauth.SessionOnline {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public SessionOnline setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 会话ID
		 * @param sessionId 会话ID
		 * @return 当前对象
		*/
		public SessionOnline setSessionId(String sessionId) {
			super.change(SESSION_ID,super.getSessionId(),sessionId);
			super.setSessionId(sessionId);
			return this;
		}
		
		/**
		 * 设置 账户ID
		 * @param userId 账户ID
		 * @return 当前对象
		*/
		public SessionOnline setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 登录时间
		 * @param loginTime 登录时间
		 * @return 当前对象
		*/
		public SessionOnline setLoginTime(Date loginTime) {
			super.change(LOGIN_TIME,super.getLoginTime(),loginTime);
			super.setLoginTime(loginTime);
			return this;
		}
		
		/**
		 * 设置 最近一次交互时间
		 * @param interactTime 最近一次交互时间
		 * @return 当前对象
		*/
		public SessionOnline setInteractTime(Date interactTime) {
			super.change(INTERACT_TIME,super.getInteractTime(),interactTime);
			super.setInteractTime(interactTime);
			return this;
		}
		
		/**
		 * 设置 最后访问的地址
		 * @param interactUrl 最后访问的地址
		 * @return 当前对象
		*/
		public SessionOnline setInteractUrl(String interactUrl) {
			super.change(INTERACT_URL,super.getInteractUrl(),interactUrl);
			super.setInteractUrl(interactUrl);
			return this;
		}
		
		/**
		 * 设置 登出时间
		 * @param logoutTime 登出时间
		 * @return 当前对象
		*/
		public SessionOnline setLogoutTime(Date logoutTime) {
			super.change(LOGOUT_TIME,super.getLogoutTime(),logoutTime);
			super.setLogoutTime(logoutTime);
			return this;
		}
		
		/**
		 * 设置 会话时长
		 * @param sessionTime 会话时长
		 * @return 当前对象
		*/
		public SessionOnline setSessionTime(Integer sessionTime) {
			super.change(SESSION_TIME,super.getSessionTime(),sessionTime);
			super.setSessionTime(sessionTime);
			return this;
		}
		
		/**
		 * 设置 是否在线
		 * @param online 是否在线
		 * @return 当前对象
		*/
		public SessionOnline setOnline(Integer online) {
			super.change(ONLINE,super.getOnline(),online);
			super.setOnline(online);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SessionOnline setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SessionOnline setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SessionOnline setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SessionOnline setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SessionOnline setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SessionOnline setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SessionOnline setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SessionOnline setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}