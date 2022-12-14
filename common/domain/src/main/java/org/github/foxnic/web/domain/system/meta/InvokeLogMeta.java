package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.InvokeLog;
import java.sql.Timestamp;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-08-25 11:42:23
 * @sign 1001880D3A20913EBC4BB6DA9DB43CF2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InvokeLogMeta {
	
	/**
	 * ID , 类型: java.lang.Long
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.Long> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,ID, java.lang.Long.class, "ID", "ID", java.lang.Long.class, null);
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final String APPLICATION="application";
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> APPLICATION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,APPLICATION, java.lang.String.class, "应用名称", "应用名称", java.lang.String.class, null);
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> HOST_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,HOST_NAME, java.lang.String.class, "主机名称", "主机名称", java.lang.String.class, null);
	
	/**
	 * 请求的URI , 类型: java.lang.String
	*/
	public static final String URI="uri";
	
	/**
	 * 请求的URI , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> URI_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,URI, java.lang.String.class, "请求的URI", "请求的URI", java.lang.String.class, null);
	
	/**
	 * UserAgent , 类型: java.lang.String
	*/
	public static final String USER_AGENT="userAgent";
	
	/**
	 * UserAgent , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> USER_AGENT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,USER_AGENT, java.lang.String.class, "UserAgent", "UserAgent", java.lang.String.class, null);
	
	/**
	 * 客户端IP , 类型: java.lang.String
	*/
	public static final String CLIENT_IP="clientIp";
	
	/**
	 * 客户端IP , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> CLIENT_IP_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,CLIENT_IP, java.lang.String.class, "客户端IP", "客户端IP", java.lang.String.class, null);
	
	/**
	 * token值 , 类型: java.lang.String
	*/
	public static final String TOKEN="token";
	
	/**
	 * token值 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> TOKEN_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,TOKEN, java.lang.String.class, "token值", "token值", java.lang.String.class, null);
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final String SESSION_ID="sessionId";
	
	/**
	 * 会话ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> SESSION_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,SESSION_ID, java.lang.String.class, "会话ID", "会话ID", java.lang.String.class, null);
	
	/**
	 * 用户ID , 类型: java.lang.Long
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户ID , 类型: java.lang.Long
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.Long> USER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,USER_ID, java.lang.Long.class, "用户ID", "用户ID", java.lang.Long.class, null);
	
	/**
	 * 用户姓名 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 用户姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> USER_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,USER_NAME, java.lang.String.class, "用户姓名", "用户姓名", java.lang.String.class, null);
	
	/**
	 * 日志跟踪ID , 类型: java.lang.String
	*/
	public static final String TID="tid";
	
	/**
	 * 日志跟踪ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> TID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,TID, java.lang.String.class, "日志跟踪ID", "日志跟踪ID", java.lang.String.class, null);
	
	/**
	 * 请求参数 , 类型: java.lang.String
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 请求参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> PARAMETER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,PARAMETER, java.lang.String.class, "请求参数", "请求参数", java.lang.String.class, null);
	
	/**
	 * 响应数据 , 类型: java.lang.String
	*/
	public static final String RESPONSE="response";
	
	/**
	 * 响应数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> RESPONSE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,RESPONSE, java.lang.String.class, "响应数据", "响应数据", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.sql.Timestamp
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.sql.Timestamp> START_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,START_TIME, java.sql.Timestamp.class, "开始时间", "开始时间", java.sql.Timestamp.class, null);
	
	/**
	 * 结束时间 , 类型: java.sql.Timestamp
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.sql.Timestamp
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.sql.Timestamp> END_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,END_TIME, java.sql.Timestamp.class, "结束时间", "结束时间", java.sql.Timestamp.class, null);
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 异常信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.InvokeLog,java.lang.String> EXCEPTION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.InvokeLog.class ,EXCEPTION, java.lang.String.class, "异常信息", "异常信息", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , APPLICATION , HOST_NAME , URI , USER_AGENT , CLIENT_IP , TOKEN , SESSION_ID , USER_ID , USER_NAME , TID , PARAMETER , RESPONSE , START_TIME , END_TIME , EXCEPTION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.InvokeLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public InvokeLog setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 应用名称
		 * @param application 应用名称
		 * @return 当前对象
		*/
		public InvokeLog setApplication(String application) {
			super.change(APPLICATION,super.getApplication(),application);
			super.setApplication(application);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostName 主机名称
		 * @return 当前对象
		*/
		public InvokeLog setHostName(String hostName) {
			super.change(HOST_NAME,super.getHostName(),hostName);
			super.setHostName(hostName);
			return this;
		}
		
		/**
		 * 设置 请求的URI
		 * @param uri 请求的URI
		 * @return 当前对象
		*/
		public InvokeLog setUri(String uri) {
			super.change(URI,super.getUri(),uri);
			super.setUri(uri);
			return this;
		}
		
		/**
		 * 设置 UserAgent
		 * @param userAgent UserAgent
		 * @return 当前对象
		*/
		public InvokeLog setUserAgent(String userAgent) {
			super.change(USER_AGENT,super.getUserAgent(),userAgent);
			super.setUserAgent(userAgent);
			return this;
		}
		
		/**
		 * 设置 客户端IP
		 * @param clientIp 客户端IP
		 * @return 当前对象
		*/
		public InvokeLog setClientIp(String clientIp) {
			super.change(CLIENT_IP,super.getClientIp(),clientIp);
			super.setClientIp(clientIp);
			return this;
		}
		
		/**
		 * 设置 token值
		 * @param token token值
		 * @return 当前对象
		*/
		public InvokeLog setToken(String token) {
			super.change(TOKEN,super.getToken(),token);
			super.setToken(token);
			return this;
		}
		
		/**
		 * 设置 会话ID
		 * @param sessionId 会话ID
		 * @return 当前对象
		*/
		public InvokeLog setSessionId(String sessionId) {
			super.change(SESSION_ID,super.getSessionId(),sessionId);
			super.setSessionId(sessionId);
			return this;
		}
		
		/**
		 * 设置 用户ID
		 * @param userId 用户ID
		 * @return 当前对象
		*/
		public InvokeLog setUserId(Long userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 用户姓名
		 * @param userName 用户姓名
		 * @return 当前对象
		*/
		public InvokeLog setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 日志跟踪ID
		 * @param tid 日志跟踪ID
		 * @return 当前对象
		*/
		public InvokeLog setTid(String tid) {
			super.change(TID,super.getTid(),tid);
			super.setTid(tid);
			return this;
		}
		
		/**
		 * 设置 请求参数
		 * @param parameter 请求参数
		 * @return 当前对象
		*/
		public InvokeLog setParameter(String parameter) {
			super.change(PARAMETER,super.getParameter(),parameter);
			super.setParameter(parameter);
			return this;
		}
		
		/**
		 * 设置 响应数据
		 * @param response 响应数据
		 * @return 当前对象
		*/
		public InvokeLog setResponse(String response) {
			super.change(RESPONSE,super.getResponse(),response);
			super.setResponse(response);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public InvokeLog setStartTime(Timestamp startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public InvokeLog setEndTime(Timestamp endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 异常信息
		 * @param exception 异常信息
		 * @return 当前对象
		*/
		public InvokeLog setException(String exception) {
			super.change(EXCEPTION,super.getException(),exception);
			super.setException(exception);
			return this;
		}
	}
}