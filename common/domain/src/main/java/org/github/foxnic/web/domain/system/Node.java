package org.github.foxnic.web.domain.system;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-11 17:11:20
 * @sign 564C33B9ADC0126AB75C93FCDB86F2D2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_node")
public class Node extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_NODE.$TABLE;
	
	/**
	 * 实例id：实例id
	*/
	@Id
	@ApiModelProperty(required = true,value="实例id" , notes = "实例id")
	private String id;
	
	/**
	 * 主机ID：主机ID
	*/
	@ApiModelProperty(required = false,value="主机ID" , notes = "主机ID")
	private String hostId;
	
	/**
	 * 应用名称：应用名称
	*/
	@ApiModelProperty(required = false,value="应用名称" , notes = "应用名称")
	private String applicationName;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口")
	private Integer port;
	
	/**
	 * 进程号：进程号
	*/
	@ApiModelProperty(required = false,value="进程号" , notes = "进程号")
	private String processId;
	
	/**
	 * 启动时间：启动时间
	*/
	@ApiModelProperty(required = false,value="启动时间" , notes = "启动时间")
	private Date startTime;
	
	/**
	 * 是否启动：是否启动
	*/
	@ApiModelProperty(required = false,value="是否启动" , notes = "是否启动")
	private Integer isUp;
	
	/**
	 * 心跳时间：心跳时间
	*/
	@ApiModelProperty(required = false,value="心跳时间" , notes = "心跳时间")
	private Date heartBeatTime;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public Node setDeleted(Integer deleted) {
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
	 * 将 Map 转换成 Node
	 * @param nodeMap 包含实体信息的 Map 对象
	 * @return Node , 转换好的的 Node 对象
	*/
	@Transient
	public static Node createFrom(Map<String,Object> nodeMap) {
		if(nodeMap==null) return null;
		Node po = EntityContext.create(Node.class, nodeMap);
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
		Node po = EntityContext.create(Node.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Node，等同于 new
	 * @return Node 对象
	*/
	@Transient
	public static Node create() {
		return EntityContext.create(Node.class);
	}
}