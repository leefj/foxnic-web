package org.github.foxnic.web.domain.oauth;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_SESSION_ONLINE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 在线会话
 * <p>在线会话 , 数据表 sys_session_online 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 15:18:31
 * @sign 9DA453369728B9CBD532B7003F45E473
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_session_online")
@ApiModel(description = "在线会话 ; 在线会话 , 数据表 sys_session_online 的PO类型")
public class SessionOnline extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SESSION_ONLINE.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "-61S316HKyazR6Lp83s2UHZJmLx0kZyn5F1fXT6P")
	private String id;
	
	/**
	 * 会话ID：会话ID
	*/
	@ApiModelProperty(required = false,value="会话ID" , notes = "会话ID" , example = "UMQd37gnPGkG245uM0R--QwfqRbN6vQSf-LcHwTu")
	private String sessionId;
	
	/**
	 * 账户ID：账户ID
	*/
	@ApiModelProperty(required = false,value="账户ID" , notes = "账户ID" , example = "110588348101165911")
	private String userId;
	
	/**
	 * 登录时间：登录时间
	*/
	@ApiModelProperty(required = false,value="登录时间" , notes = "登录时间" , example = "2022-10-20 10:12:35")
	private Date loginTime;
	
	/**
	 * 最近一次交互时间：最近一次交互时间
	*/
	@ApiModelProperty(required = false,value="最近一次交互时间" , notes = "最近一次交互时间" , example = "2022-10-20 10:14:05")
	private Date interactTime;
	
	/**
	 * 最后访问的地址：最后访问的地址
	*/
	@ApiModelProperty(required = false,value="最后访问的地址" , notes = "最后访问的地址" , example = "/service-storage/sys-file/image")
	private String interactUrl;
	
	/**
	 * 登出时间：登出时间
	*/
	@ApiModelProperty(required = false,value="登出时间" , notes = "登出时间" , example = "2022-10-20 10:14:05")
	private Date logoutTime;
	
	/**
	 * 会话时长：单位秒
	*/
	@ApiModelProperty(required = false,value="会话时长" , notes = "单位秒" , example = "12000")
	private Integer sessionTime;
	
	/**
	 * 是否在线：是否在线
	*/
	@ApiModelProperty(required = false,value="是否在线" , notes = "是否在线" , example = "0")
	private Integer online;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-10-20 10:12:35")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
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
	 * 主机ID：主机ID
	*/
	@ApiModelProperty(required = false,value="主机ID" , notes = "主机ID" , example = "76C24FBF9BD15F8A")
	private String hostId;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 节点实例ID：节点实例ID
	*/
	@ApiModelProperty(required = false,value="节点实例ID" , notes = "节点实例ID" , example = "9c-3d93d9b1e5-7a35")
	private String nodeId;
	
	/**
	 * accessToken：accessToken
	*/
	@ApiModelProperty(required = false,value="accessToken" , notes = "accessToken")
	private String accessToken;
	
	/**
	 * refreshToken：refreshToken
	*/
	@ApiModelProperty(required = false,value="refreshToken" , notes = "refreshToken")
	private String refreshToken;
	
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
	public SessionOnline setDeleted(Integer deleted) {
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
	public SessionOnline setDeleted(Boolean deletedBool) {
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
	 * 获得 accessToken<br>
	 * accessToken
	 * @return accessToken
	*/
	public String getAccessToken() {
		return accessToken;
	}
	
	/**
	 * 设置 accessToken
	 * @param accessToken accessToken
	 * @return 当前对象
	*/
	public SessionOnline setAccessToken(String accessToken) {
		this.accessToken=accessToken;
		return this;
	}
	
	/**
	 * 获得 refreshToken<br>
	 * refreshToken
	 * @return refreshToken
	*/
	public String getRefreshToken() {
		return refreshToken;
	}
	
	/**
	 * 设置 refreshToken
	 * @param refreshToken refreshToken
	 * @return 当前对象
	*/
	public SessionOnline setRefreshToken(String refreshToken) {
		this.refreshToken=refreshToken;
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
	 * 克隆当前对象
	*/
	@Transient
	public SessionOnline clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SessionOnline duplicate(boolean all) {
		org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta.$$proxy$$();
		inst.setInteractTime(this.getInteractTime());
		inst.setHostId(this.getHostId());
		inst.setSessionTime(this.getSessionTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSessionId(this.getSessionId());
		inst.setAccessToken(this.getAccessToken());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setLogoutTime(this.getLogoutTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setLoginTime(this.getLoginTime());
		inst.setInteractUrl(this.getInteractUrl());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOnline(this.getOnline());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
		inst.setRefreshToken(this.getRefreshToken());
		if(all) {
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SessionOnline clone(boolean deep) {
		return EntityContext.clone(SessionOnline.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SessionOnline
	 * @param sessionOnlineMap 包含实体信息的 Map 对象
	 * @return SessionOnline , 转换好的的 SessionOnline 对象
	*/
	@Transient
	public static SessionOnline createFrom(Map<String,Object> sessionOnlineMap) {
		if(sessionOnlineMap==null) return null;
		SessionOnline po = create();
		EntityContext.copyProperties(po,sessionOnlineMap);
		po.clearModifies();
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
		SessionOnline po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SessionOnline，等同于 new
	 * @return SessionOnline 对象
	*/
	@Transient
	public static SessionOnline create() {
		return new org.github.foxnic.web.domain.oauth.meta.SessionOnlineMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setInteractTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.INTERACT_TIME)));
			this.setHostId(DataParser.parse(String.class, map.get(SessionOnlineMeta.HOST_ID)));
			this.setSessionTime(DataParser.parse(Integer.class, map.get(SessionOnlineMeta.SESSION_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.UPDATE_TIME)));
			this.setSessionId(DataParser.parse(String.class, map.get(SessionOnlineMeta.SESSION_ID)));
			this.setAccessToken(DataParser.parse(String.class, map.get(SessionOnlineMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, map.get(SessionOnlineMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SessionOnlineMeta.VERSION)));
			this.setLogoutTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.LOGOUT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SessionOnlineMeta.CREATE_BY)));
			this.setLoginTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.LOGIN_TIME)));
			this.setInteractUrl(DataParser.parse(String.class, map.get(SessionOnlineMeta.INTERACT_URL)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SessionOnlineMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SessionOnlineMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SessionOnlineMeta.DELETE_TIME)));
			this.setOnline(DataParser.parse(Integer.class, map.get(SessionOnlineMeta.ONLINE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SessionOnlineMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SessionOnlineMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(SessionOnlineMeta.NODE_ID)));
			this.setRefreshToken(DataParser.parse(String.class, map.get(SessionOnlineMeta.REFRESH_TOKEN)));
			// others
			this.setUser(DataParser.parse(User.class, map.get(SessionOnlineMeta.USER)));
			return true;
		} else {
			try {
				this.setInteractTime( (Date)map.get(SessionOnlineMeta.INTERACT_TIME));
				this.setHostId( (String)map.get(SessionOnlineMeta.HOST_ID));
				this.setSessionTime( (Integer)map.get(SessionOnlineMeta.SESSION_TIME));
				this.setUpdateTime( (Date)map.get(SessionOnlineMeta.UPDATE_TIME));
				this.setSessionId( (String)map.get(SessionOnlineMeta.SESSION_ID));
				this.setAccessToken( (String)map.get(SessionOnlineMeta.ACCESS_TOKEN));
				this.setUserId( (String)map.get(SessionOnlineMeta.USER_ID));
				this.setVersion( (Integer)map.get(SessionOnlineMeta.VERSION));
				this.setLogoutTime( (Date)map.get(SessionOnlineMeta.LOGOUT_TIME));
				this.setCreateBy( (String)map.get(SessionOnlineMeta.CREATE_BY));
				this.setLoginTime( (Date)map.get(SessionOnlineMeta.LOGIN_TIME));
				this.setInteractUrl( (String)map.get(SessionOnlineMeta.INTERACT_URL));
				this.setDeleted( (Integer)map.get(SessionOnlineMeta.DELETED));
				this.setCreateTime( (Date)map.get(SessionOnlineMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SessionOnlineMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SessionOnlineMeta.DELETE_TIME));
				this.setOnline( (Integer)map.get(SessionOnlineMeta.ONLINE));
				this.setDeleteBy( (String)map.get(SessionOnlineMeta.DELETE_BY));
				this.setId( (String)map.get(SessionOnlineMeta.ID));
				this.setNodeId( (String)map.get(SessionOnlineMeta.NODE_ID));
				this.setRefreshToken( (String)map.get(SessionOnlineMeta.REFRESH_TOKEN));
				// others
				this.setUser( (User)map.get(SessionOnlineMeta.USER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setInteractTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.INTERACT_TIME)));
			this.setHostId(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.HOST_ID)));
			this.setSessionTime(DataParser.parse(Integer.class, r.getValue(SessionOnlineMeta.SESSION_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.UPDATE_TIME)));
			this.setSessionId(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.SESSION_ID)));
			this.setAccessToken(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.ACCESS_TOKEN)));
			this.setUserId(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SessionOnlineMeta.VERSION)));
			this.setLogoutTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.LOGOUT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.CREATE_BY)));
			this.setLoginTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.LOGIN_TIME)));
			this.setInteractUrl(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.INTERACT_URL)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SessionOnlineMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SessionOnlineMeta.DELETE_TIME)));
			this.setOnline(DataParser.parse(Integer.class, r.getValue(SessionOnlineMeta.ONLINE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.NODE_ID)));
			this.setRefreshToken(DataParser.parse(String.class, r.getValue(SessionOnlineMeta.REFRESH_TOKEN)));
			return true;
		} else {
			try {
				this.setInteractTime( (Date)r.getValue(SessionOnlineMeta.INTERACT_TIME));
				this.setHostId( (String)r.getValue(SessionOnlineMeta.HOST_ID));
				this.setSessionTime( (Integer)r.getValue(SessionOnlineMeta.SESSION_TIME));
				this.setUpdateTime( (Date)r.getValue(SessionOnlineMeta.UPDATE_TIME));
				this.setSessionId( (String)r.getValue(SessionOnlineMeta.SESSION_ID));
				this.setAccessToken( (String)r.getValue(SessionOnlineMeta.ACCESS_TOKEN));
				this.setUserId( (String)r.getValue(SessionOnlineMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(SessionOnlineMeta.VERSION));
				this.setLogoutTime( (Date)r.getValue(SessionOnlineMeta.LOGOUT_TIME));
				this.setCreateBy( (String)r.getValue(SessionOnlineMeta.CREATE_BY));
				this.setLoginTime( (Date)r.getValue(SessionOnlineMeta.LOGIN_TIME));
				this.setInteractUrl( (String)r.getValue(SessionOnlineMeta.INTERACT_URL));
				this.setDeleted( (Integer)r.getValue(SessionOnlineMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SessionOnlineMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SessionOnlineMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SessionOnlineMeta.DELETE_TIME));
				this.setOnline( (Integer)r.getValue(SessionOnlineMeta.ONLINE));
				this.setDeleteBy( (String)r.getValue(SessionOnlineMeta.DELETE_BY));
				this.setId( (String)r.getValue(SessionOnlineMeta.ID));
				this.setNodeId( (String)r.getValue(SessionOnlineMeta.NODE_ID));
				this.setRefreshToken( (String)r.getValue(SessionOnlineMeta.REFRESH_TOKEN));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}