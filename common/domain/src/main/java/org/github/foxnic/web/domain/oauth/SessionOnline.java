package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-13 22:14:37
 * @sign 7E81E58C8AAAD57030261B79D93558C6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_session_online")
public class SessionOnline extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SESSION_ONLINE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID")
	private String id;
	
	/**
	 * 会话ID：会话ID
	*/
	@ApiModelProperty(required = false,value="会话ID" , notes = "会话ID")
	private String sessionId;
	
	/**
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID")
	private String userId;
	
	/**
	 * 登录时间：登录时间
	*/
	@ApiModelProperty(required = false,value="登录时间" , notes = "登录时间")
	private Date loginTime;
	
	/**
	 * 最近一次交互时间：最近一次交互时间
	*/
	@ApiModelProperty(required = false,value="最近一次交互时间" , notes = "最近一次交互时间")
	private Date interactTime;
	
	/**
	 * 最后访问的地址：最后访问的地址
	*/
	@ApiModelProperty(required = false,value="最后访问的地址" , notes = "最后访问的地址")
	private String interactUrl;
	
	/**
	 * 登出时间：登出时间
	*/
	@ApiModelProperty(required = false,value="登出时间" , notes = "登出时间")
	private Date logoutTime;
	
	/**
	 * 会话时长：单位秒
	*/
	@ApiModelProperty(required = false,value="会话时长" , notes = "单位秒")
	private Integer sessionTime;
	
	/**
	 * 是否在线：是否在线
	*/
	@ApiModelProperty(required = false,value="是否在线" , notes = "是否在线")
	private Integer online;
	
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
	 * 主机ID：主机ID
	*/
	@ApiModelProperty(required = false,value="主机ID" , notes = "主机ID")
	private String hostId;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 节点实例ID：节点实例ID
	*/
	@ApiModelProperty(required = false,value="节点实例ID" , notes = "节点实例ID")
	private String nodeId;
	
	/**
	 * 账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "")
	private User user;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public SessionOnline setId(String id) {
		this.id=id;
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
	public SessionOnline setSessionId(String sessionId) {
		this.sessionId=sessionId;
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
	public SessionOnline setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 登录时间<br>
	 * 登录时间
	 * @return 登录时间
	*/
	public Date getLoginTime() {
		return loginTime;
	}
	
	/**
	 * 设置 登录时间
	 * @param loginTime 登录时间
	 * @return 当前对象
	*/
	public SessionOnline setLoginTime(Date loginTime) {
		this.loginTime=loginTime;
		return this;
	}
	
	/**
	 * 获得 最近一次交互时间<br>
	 * 最近一次交互时间
	 * @return 最近一次交互时间
	*/
	public Date getInteractTime() {
		return interactTime;
	}
	
	/**
	 * 设置 最近一次交互时间
	 * @param interactTime 最近一次交互时间
	 * @return 当前对象
	*/
	public SessionOnline setInteractTime(Date interactTime) {
		this.interactTime=interactTime;
		return this;
	}
	
	/**
	 * 获得 最后访问的地址<br>
	 * 最后访问的地址
	 * @return 最后访问的地址
	*/
	public String getInteractUrl() {
		return interactUrl;
	}
	
	/**
	 * 设置 最后访问的地址
	 * @param interactUrl 最后访问的地址
	 * @return 当前对象
	*/
	public SessionOnline setInteractUrl(String interactUrl) {
		this.interactUrl=interactUrl;
		return this;
	}
	
	/**
	 * 获得 登出时间<br>
	 * 登出时间
	 * @return 登出时间
	*/
	public Date getLogoutTime() {
		return logoutTime;
	}
	
	/**
	 * 设置 登出时间
	 * @param logoutTime 登出时间
	 * @return 当前对象
	*/
	public SessionOnline setLogoutTime(Date logoutTime) {
		this.logoutTime=logoutTime;
		return this;
	}
	
	/**
	 * 获得 会话时长<br>
	 * 单位秒
	 * @return 会话时长
	*/
	public Integer getSessionTime() {
		return sessionTime;
	}
	
	/**
	 * 设置 会话时长
	 * @param sessionTime 会话时长
	 * @return 当前对象
	*/
	public SessionOnline setSessionTime(Integer sessionTime) {
		this.sessionTime=sessionTime;
		return this;
	}
	
	/**
	 * 获得 是否在线<br>
	 * 是否在线
	 * @return 是否在线
	*/
	public Integer getOnline() {
		return online;
	}
	
	/**
	 * 设置 是否在线
	 * @param online 是否在线
	 * @return 当前对象
	*/
	public SessionOnline setOnline(Integer online) {
		this.online=online;
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
	public SessionOnline setCreateBy(String createBy) {
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
	public SessionOnline setCreateTime(Date createTime) {
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
	public SessionOnline setUpdateBy(String updateBy) {
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
	public SessionOnline setUpdateTime(Date updateTime) {
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public SessionOnline setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public SessionOnline setDeleteBy(String deleteBy) {
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
	public SessionOnline setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 主机ID<br>
	 * 主机ID
	 * @return 主机ID
	*/
	public String getHostId() {
		return hostId;
	}
	
	/**
	 * 设置 主机ID
	 * @param hostId 主机ID
	 * @return 当前对象
	*/
	public SessionOnline setHostId(String hostId) {
		this.hostId=hostId;
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
	public SessionOnline setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 节点实例ID<br>
	 * 节点实例ID
	 * @return 节点实例ID
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点实例ID
	 * @param nodeId 节点实例ID
	 * @return 当前对象
	*/
	public SessionOnline setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * @return 账户
	*/
	public User getUser() {
		return user;
	}
	
	/**
	 * 设置 账户
	 * @param user 账户
	 * @return 当前对象
	*/
	public SessionOnline setUser(User user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SessionOnline , 转换好的 SessionOnline 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SessionOnline , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 SessionOnline
	 * @param sessionOnlineMap 包含实体信息的 Map 对象
	 * @return SessionOnline , 转换好的的 SessionOnline 对象
	*/
	@Transient
	public static SessionOnline createFrom(Map<String,Object> sessionOnlineMap) {
		if(sessionOnlineMap==null) return null;
		SessionOnline po = EntityContext.create(SessionOnline.class, sessionOnlineMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 SessionOnline
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SessionOnline , 转换好的的 SessionOnline 对象
	*/
	@Transient
	public static SessionOnline createFrom(Object pojo) {
		if(pojo==null) return null;
		SessionOnline po = EntityContext.create(SessionOnline.class,pojo);
		return po;
	}

	/**
	 * 创建一个 SessionOnline，等同于 new
	 * @return SessionOnline 对象
	*/
	@Transient
	public static SessionOnline create() {
		return EntityContext.create(SessionOnline.class);
	}
}