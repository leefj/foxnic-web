package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_INVOKE_LOG;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-06 14:12:29
 * @sign 259073DE4AB7614135E63D1932FCB4BE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_invoke_log")
public class InvokeLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_INVOKE_LOG.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private Long id;
	
	/**
	 * 应用名称：应用名称
	*/
	@ApiModelProperty(required = false,value="应用名称" , notes = "应用名称")
	private String application;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称")
	private String hostName;
	
	/**
	 * 请求的URI：请求的URI
	*/
	@ApiModelProperty(required = false,value="请求的URI" , notes = "请求的URI")
	private String uri;
	
	/**
	 * UserAgent：UserAgent
	*/
	@ApiModelProperty(required = false,value="UserAgent" , notes = "UserAgent")
	private String userAgent;
	
	/**
	 * 客户端IP：客户端IP
	*/
	@ApiModelProperty(required = false,value="客户端IP" , notes = "客户端IP")
	private String clientIp;
	
	/**
	 * token值：token值
	*/
	@ApiModelProperty(required = false,value="token值" , notes = "token值")
	private String token;
	
	/**
	 * 会话ID：会话ID
	*/
	@ApiModelProperty(required = false,value="会话ID" , notes = "会话ID")
	private String sessionId;
	
	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = false,value="用户ID" , notes = "用户ID")
	private Long userId;
	
	/**
	 * 用户姓名：用户姓名
	*/
	@ApiModelProperty(required = false,value="用户姓名" , notes = "用户姓名")
	private String userName;
	
	/**
	 * 日志跟踪ID：日志跟踪ID
	*/
	@ApiModelProperty(required = false,value="日志跟踪ID" , notes = "日志跟踪ID")
	private String tid;
	
	/**
	 * 请求参数：请求参数
	*/
	@ApiModelProperty(required = false,value="请求参数" , notes = "请求参数")
	private String parameter;
	
	/**
	 * 响应数据：响应数据
	*/
	@ApiModelProperty(required = false,value="响应数据" , notes = "响应数据")
	private String response;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Timestamp startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Timestamp endTime;
	
	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息")
	private String exception;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public InvokeLog setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 应用名称<br>
	 * 应用名称
	 * @return 应用名称
	*/
	public String getApplication() {
		return application;
	}
	
	/**
	 * 设置 应用名称
	 * @param application 应用名称
	 * @return 当前对象
	*/
	public InvokeLog setApplication(String application) {
		this.application=application;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostName 主机名称
	 * @return 当前对象
	*/
	public InvokeLog setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 请求的URI<br>
	 * 请求的URI
	 * @return 请求的URI
	*/
	public String getUri() {
		return uri;
	}
	
	/**
	 * 设置 请求的URI
	 * @param uri 请求的URI
	 * @return 当前对象
	*/
	public InvokeLog setUri(String uri) {
		this.uri=uri;
		return this;
	}
	
	/**
	 * 获得 UserAgent<br>
	 * UserAgent
	 * @return UserAgent
	*/
	public String getUserAgent() {
		return userAgent;
	}
	
	/**
	 * 设置 UserAgent
	 * @param userAgent UserAgent
	 * @return 当前对象
	*/
	public InvokeLog setUserAgent(String userAgent) {
		this.userAgent=userAgent;
		return this;
	}
	
	/**
	 * 获得 客户端IP<br>
	 * 客户端IP
	 * @return 客户端IP
	*/
	public String getClientIp() {
		return clientIp;
	}
	
	/**
	 * 设置 客户端IP
	 * @param clientIp 客户端IP
	 * @return 当前对象
	*/
	public InvokeLog setClientIp(String clientIp) {
		this.clientIp=clientIp;
		return this;
	}
	
	/**
	 * 获得 token值<br>
	 * token值
	 * @return token值
	*/
	public String getToken() {
		return token;
	}
	
	/**
	 * 设置 token值
	 * @param token token值
	 * @return 当前对象
	*/
	public InvokeLog setToken(String token) {
		this.token=token;
		return this;
	}
	
	/**
	 * 获得 会话ID<br>
	 * 会话ID
	 * @return 会话ID
	*/
	public String getSessionId() {
		return sessionId;
	}
	
	/**
	 * 设置 会话ID
	 * @param sessionId 会话ID
	 * @return 当前对象
	*/
	public InvokeLog setSessionId(String sessionId) {
		this.sessionId=sessionId;
		return this;
	}
	
	/**
	 * 获得 用户ID<br>
	 * 用户ID
	 * @return 用户ID
	*/
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	public InvokeLog setUserId(Long userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 用户姓名<br>
	 * 用户姓名
	 * @return 用户姓名
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 用户姓名
	 * @param userName 用户姓名
	 * @return 当前对象
	*/
	public InvokeLog setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 日志跟踪ID<br>
	 * 日志跟踪ID
	 * @return 日志跟踪ID
	*/
	public String getTid() {
		return tid;
	}
	
	/**
	 * 设置 日志跟踪ID
	 * @param tid 日志跟踪ID
	 * @return 当前对象
	*/
	public InvokeLog setTid(String tid) {
		this.tid=tid;
		return this;
	}
	
	/**
	 * 获得 请求参数<br>
	 * 请求参数
	 * @return 请求参数
	*/
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * 设置 请求参数
	 * @param parameter 请求参数
	 * @return 当前对象
	*/
	public InvokeLog setParameter(String parameter) {
		this.parameter=parameter;
		return this;
	}
	
	/**
	 * 获得 响应数据<br>
	 * 响应数据
	 * @return 响应数据
	*/
	public String getResponse() {
		return response;
	}
	
	/**
	 * 设置 响应数据
	 * @param response 响应数据
	 * @return 当前对象
	*/
	public InvokeLog setResponse(String response) {
		this.response=response;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Timestamp getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public InvokeLog setStartTime(Timestamp startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Timestamp getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public InvokeLog setEndTime(Timestamp endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getException() {
		return exception;
	}
	
	/**
	 * 设置 异常信息
	 * @param exception 异常信息
	 * @return 当前对象
	*/
	public InvokeLog setException(String exception) {
		this.exception=exception;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InvokeLog , 转换好的 InvokeLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InvokeLog , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InvokeLog
	 * @param invokeLogMap 包含实体信息的 Map 对象
	 * @return InvokeLog , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLog createFrom(Map<String,Object> invokeLogMap) {
		if(invokeLogMap==null) return null;
		InvokeLog po = EntityContext.create(InvokeLog.class, invokeLogMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InvokeLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InvokeLog , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLog createFrom(Object pojo) {
		if(pojo==null) return null;
		InvokeLog po = EntityContext.create(InvokeLog.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InvokeLog，等同于 new
	 * @return InvokeLog 对象
	*/
	@Transient
	public static InvokeLog create() {
		return new InvokeLog();
	}
}