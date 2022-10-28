package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import org.github.foxnic.web.domain.system.meta.NodeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 系统节点
 * <p>系统节点 , 数据表 sys_node 的PO类型</p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:42:46
 * @sign 2686E9B5BEBC0824BDD6CB047374150D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_node")
@ApiModel(description = "系统节点 ; 系统节点 , 数据表 sys_node 的PO类型")
public class Node extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_NODE.$TABLE;
	
	/**
	 * 实例id：实例id
	*/
	@Id
	@ApiModelProperty(required = true,value="实例id" , notes = "实例id" , example = "00-110e397f47-f643")
	private String id;
	
	/**
	 * 主机ID：主机ID
	*/
	@ApiModelProperty(required = false,value="主机ID" , notes = "主机ID" , example = "B15BDA59450483F9")
	private String hostId;
	
	/**
	 * 应用名称：应用名称
	*/
	@ApiModelProperty(required = false,value="应用名称" , notes = "应用名称" , example = "service-all")
	private String applicationName;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口" , example = "1899")
	private Integer port;
	
	/**
	 * 进程号：进程号
	*/
	@ApiModelProperty(required = false,value="进程号" , notes = "进程号" , example = "21176")
	private String processId;
	
	/**
	 * 启动时间：启动时间
	*/
	@ApiModelProperty(required = false,value="启动时间" , notes = "启动时间" , example = "2021-10-19 07:45:06")
	private Date startTime;
	
	/**
	 * 是否启动：是否启动
	*/
	@ApiModelProperty(required = false,value="是否启动" , notes = "是否启动" , example = "0")
	private Integer isUp;
	
	/**
	 * 心跳时间：心跳时间
	*/
	@ApiModelProperty(required = false,value="心跳时间" , notes = "心跳时间" , example = "2021-10-19 08:48:16")
	private Date heartBeatTime;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称" , example = "LeeFJ-PC")
	private String hostName;
	
	/**
	 * IP地址：IP地址
	*/
	@ApiModelProperty(required = false,value="IP地址" , notes = "IP地址" , example = "192.168.70.158")
	private String ip;
	
	/**
	 * 雪花DCId：雪花DCId
	*/
	@ApiModelProperty(required = false,value="雪花DCId" , notes = "雪花DCId" , example = "0")
	private Integer datacenterId;
	
	/**
	 * 雪花WKId：雪花WKId
	*/
	@ApiModelProperty(required = false,value="雪花WKId" , notes = "雪花WKId" , example = "0")
	private Integer workerId;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 获得 实例id<br>
	 * 实例id
	 * @return 实例id
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 实例id
	 * @param id 实例id
	 * @return 当前对象
	*/
	public Node setId(String id) {
		this.id=id;
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
	public Node setHostId(String hostId) {
		this.hostId=hostId;
		return this;
	}
	
	/**
	 * 获得 应用名称<br>
	 * 应用名称
	 * @return 应用名称
	*/
	public String getApplicationName() {
		return applicationName;
	}
	
	/**
	 * 设置 应用名称
	 * @param applicationName 应用名称
	 * @return 当前对象
	*/
	public Node setApplicationName(String applicationName) {
		this.applicationName=applicationName;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public Integer getPort() {
		return port;
	}
	
	/**
	 * 设置 端口
	 * @param port 端口
	 * @return 当前对象
	*/
	public Node setPort(Integer port) {
		this.port=port;
		return this;
	}
	
	/**
	 * 获得 进程号<br>
	 * 进程号
	 * @return 进程号
	*/
	public String getProcessId() {
		return processId;
	}
	
	/**
	 * 设置 进程号
	 * @param processId 进程号
	 * @return 当前对象
	*/
	public Node setProcessId(String processId) {
		this.processId=processId;
		return this;
	}
	
	/**
	 * 获得 启动时间<br>
	 * 启动时间
	 * @return 启动时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 启动时间
	 * @param startTime 启动时间
	 * @return 当前对象
	*/
	public Node setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 是否启动<br>
	 * 是否启动
	 * @return 是否启动
	*/
	public Integer getIsUp() {
		return isUp;
	}
	
	/**
	 * 设置 是否启动
	 * @param isUp 是否启动
	 * @return 当前对象
	*/
	public Node setIsUp(Integer isUp) {
		this.isUp=isUp;
		return this;
	}
	
	/**
	 * 获得 心跳时间<br>
	 * 心跳时间
	 * @return 心跳时间
	*/
	public Date getHeartBeatTime() {
		return heartBeatTime;
	}
	
	/**
	 * 设置 心跳时间
	 * @param heartBeatTime 心跳时间
	 * @return 当前对象
	*/
	public Node setHeartBeatTime(Date heartBeatTime) {
		this.heartBeatTime=heartBeatTime;
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
	public Node setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 IP地址<br>
	 * IP地址
	 * @return IP地址
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP地址
	 * @param ip IP地址
	 * @return 当前对象
	*/
	public Node setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 雪花DCId<br>
	 * 雪花DCId
	 * @return 雪花DCId
	*/
	public Integer getDatacenterId() {
		return datacenterId;
	}
	
	/**
	 * 设置 雪花DCId
	 * @param datacenterId 雪花DCId
	 * @return 当前对象
	*/
	public Node setDatacenterId(Integer datacenterId) {
		this.datacenterId=datacenterId;
		return this;
	}
	
	/**
	 * 获得 雪花WKId<br>
	 * 雪花WKId
	 * @return 雪花WKId
	*/
	public Integer getWorkerId() {
		return workerId;
	}
	
	/**
	 * 设置 雪花WKId
	 * @param workerId 雪花WKId
	 * @return 当前对象
	*/
	public Node setWorkerId(Integer workerId) {
		this.workerId=workerId;
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
	public Node setCreateBy(String createBy) {
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
	public Node setCreateTime(Date createTime) {
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
	public Node setUpdateBy(String updateBy) {
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
	public Node setUpdateTime(Date updateTime) {
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
	public Node setDeleted(Integer deleted) {
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
	public Node setDeleted(Boolean deletedBool) {
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
	public Node setDeleteBy(String deleteBy) {
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
	public Node setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public Node setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Node , 转换好的 Node 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Node , 转换好的 PoJo 对象
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
	public Node clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Node duplicate(boolean all) {
		org.github.foxnic.web.domain.system.meta.NodeMeta.$$proxy$$ inst = new org.github.foxnic.web.domain.system.meta.NodeMeta.$$proxy$$();
		inst.setHostName(this.getHostName());
		inst.setWorkerId(this.getWorkerId());
		inst.setIp(this.getIp());
		inst.setDatacenterId(this.getDatacenterId());
		inst.setHostId(this.getHostId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setHeartBeatTime(this.getHeartBeatTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setIsUp(this.getIsUp());
		inst.setPort(this.getPort());
		inst.setProcessId(this.getProcessId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setApplicationName(this.getApplicationName());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Node clone(boolean deep) {
		return EntityContext.clone(Node.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Node
	 * @param nodeMap 包含实体信息的 Map 对象
	 * @return Node , 转换好的的 Node 对象
	*/
	@Transient
	public static Node createFrom(Map<String,Object> nodeMap) {
		if(nodeMap==null) return null;
		Node po = create();
		EntityContext.copyProperties(po,nodeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Node
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Node , 转换好的的 Node 对象
	*/
	@Transient
	public static Node createFrom(Object pojo) {
		if(pojo==null) return null;
		Node po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Node，等同于 new
	 * @return Node 对象
	*/
	@Transient
	public static Node create() {
		return new org.github.foxnic.web.domain.system.meta.NodeMeta.$$proxy$$();
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
			this.setHostName(DataParser.parse(String.class, map.get(NodeMeta.HOST_NAME)));
			this.setWorkerId(DataParser.parse(Integer.class, map.get(NodeMeta.WORKER_ID)));
			this.setIp(DataParser.parse(String.class, map.get(NodeMeta.IP)));
			this.setDatacenterId(DataParser.parse(Integer.class, map.get(NodeMeta.DATACENTER_ID)));
			this.setHostId(DataParser.parse(String.class, map.get(NodeMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NodeMeta.UPDATE_TIME)));
			this.setHeartBeatTime(DataParser.parse(Date.class, map.get(NodeMeta.HEART_BEAT_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NodeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NodeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NodeMeta.DELETED)));
			this.setIsUp(DataParser.parse(Integer.class, map.get(NodeMeta.IS_UP)));
			this.setPort(DataParser.parse(Integer.class, map.get(NodeMeta.PORT)));
			this.setProcessId(DataParser.parse(String.class, map.get(NodeMeta.PROCESS_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NodeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NodeMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NodeMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(NodeMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(NodeMeta.ID)));
			this.setApplicationName(DataParser.parse(String.class, map.get(NodeMeta.APPLICATION_NAME)));
			// others
			return true;
		} else {
			try {
				this.setHostName( (String)map.get(NodeMeta.HOST_NAME));
				this.setWorkerId( (Integer)map.get(NodeMeta.WORKER_ID));
				this.setIp( (String)map.get(NodeMeta.IP));
				this.setDatacenterId( (Integer)map.get(NodeMeta.DATACENTER_ID));
				this.setHostId( (String)map.get(NodeMeta.HOST_ID));
				this.setUpdateTime( (Date)map.get(NodeMeta.UPDATE_TIME));
				this.setHeartBeatTime( (Date)map.get(NodeMeta.HEART_BEAT_TIME));
				this.setVersion( (Integer)map.get(NodeMeta.VERSION));
				this.setCreateBy( (String)map.get(NodeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NodeMeta.DELETED));
				this.setIsUp( (Integer)map.get(NodeMeta.IS_UP));
				this.setPort( (Integer)map.get(NodeMeta.PORT));
				this.setProcessId( (String)map.get(NodeMeta.PROCESS_ID));
				this.setCreateTime( (Date)map.get(NodeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NodeMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(NodeMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(NodeMeta.START_TIME));
				this.setId( (String)map.get(NodeMeta.ID));
				this.setApplicationName( (String)map.get(NodeMeta.APPLICATION_NAME));
				// others
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
			this.setHostName(DataParser.parse(String.class, r.getValue(NodeMeta.HOST_NAME)));
			this.setWorkerId(DataParser.parse(Integer.class, r.getValue(NodeMeta.WORKER_ID)));
			this.setIp(DataParser.parse(String.class, r.getValue(NodeMeta.IP)));
			this.setDatacenterId(DataParser.parse(Integer.class, r.getValue(NodeMeta.DATACENTER_ID)));
			this.setHostId(DataParser.parse(String.class, r.getValue(NodeMeta.HOST_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NodeMeta.UPDATE_TIME)));
			this.setHeartBeatTime(DataParser.parse(Date.class, r.getValue(NodeMeta.HEART_BEAT_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NodeMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NodeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NodeMeta.DELETED)));
			this.setIsUp(DataParser.parse(Integer.class, r.getValue(NodeMeta.IS_UP)));
			this.setPort(DataParser.parse(Integer.class, r.getValue(NodeMeta.PORT)));
			this.setProcessId(DataParser.parse(String.class, r.getValue(NodeMeta.PROCESS_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NodeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NodeMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NodeMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(NodeMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(NodeMeta.ID)));
			this.setApplicationName(DataParser.parse(String.class, r.getValue(NodeMeta.APPLICATION_NAME)));
			return true;
		} else {
			try {
				this.setHostName( (String)r.getValue(NodeMeta.HOST_NAME));
				this.setWorkerId( (Integer)r.getValue(NodeMeta.WORKER_ID));
				this.setIp( (String)r.getValue(NodeMeta.IP));
				this.setDatacenterId( (Integer)r.getValue(NodeMeta.DATACENTER_ID));
				this.setHostId( (String)r.getValue(NodeMeta.HOST_ID));
				this.setUpdateTime( (Date)r.getValue(NodeMeta.UPDATE_TIME));
				this.setHeartBeatTime( (Date)r.getValue(NodeMeta.HEART_BEAT_TIME));
				this.setVersion( (Integer)r.getValue(NodeMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NodeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NodeMeta.DELETED));
				this.setIsUp( (Integer)r.getValue(NodeMeta.IS_UP));
				this.setPort( (Integer)r.getValue(NodeMeta.PORT));
				this.setProcessId( (String)r.getValue(NodeMeta.PROCESS_ID));
				this.setCreateTime( (Date)r.getValue(NodeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NodeMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(NodeMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(NodeMeta.START_TIME));
				this.setId( (String)r.getValue(NodeMeta.ID));
				this.setApplicationName( (String)r.getValue(NodeMeta.APPLICATION_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}