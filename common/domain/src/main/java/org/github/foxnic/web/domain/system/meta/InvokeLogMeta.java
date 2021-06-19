package org.github.foxnic.web.domain.system.meta;

import org.github.foxnic.web.domain.system.InvokeLog;
import java.sql.Timestamp;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 08:22:05
 * @sign EF2F8E7F4D11E5D78A1DC6831B2892B6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InvokeLogMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 主机名称
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * 请求的URI
	*/
	public static final String URI="uri";
	
	/**
	 * UserAgent
	*/
	public static final String USER_AGENT="userAgent";
	
	/**
	 * 客户端IP
	*/
	public static final String CLIENT_IP="clientIp";
	
	/**
	 * token值
	*/
	public static final String TOKEN="token";
	
	/**
	 * 用户ID
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户姓名
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 请求参数
	*/
	public static final String PARAMETER="parameter";
	
	/**
	 * 响应数据
	*/
	public static final String RESPONSE="response";
	
	/**
	 * 开始时间
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 结束时间
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 异常信息
	*/
	public static final String EXCEPTION="exception";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HOST_NAME , URI , USER_AGENT , CLIENT_IP , TOKEN , USER_ID , USER_NAME , PARAMETER , RESPONSE , START_TIME , END_TIME , EXCEPTION };
	
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